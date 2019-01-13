package simula.compiler.editor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

import simula.compiler.utilities.Global;


public class SimulaEditor extends JFrame {

    private static final long serialVersionUID = 1L;
    public static boolean RENDER_LINE_NUMBERS=true;
    public static boolean AUTO_REFRESH=false;
    public static final ImageIcon simulaIcon = new ImageIcon("icons/sim2.png");
    
    JTabbedPane tabbedPane; 
    FileMenu fileMenu;

    
//    private File currentFile;
    
    public static void main(String[] args) {
    	SettingsMenu.InitRuntimeOptions();
    	SettingsMenu.InitCompilerOptions();
		
//		Global.sampleSourceDir="C:/GitHub/SimulaCompiler/Simula/src/simulaTestPrograms/simple";
		Global.sampleSourceDir="C:/GitHub/SimulaCompiler/Simula/src/simulaTestPrograms/samples";

		SimulaEditor editor=new SimulaEditor();
    	editor.setVisible(true);
    }

    SourceTextPanel getCurrentTextPanel() {
        SourceTextPanel current=(SourceTextPanel)tabbedPane.getSelectedComponent();
//        System.out.println("SimulaEditor.getCurrentTextPanel - Current Panel: name=" + current.getName());
//        System.out.println("SimulaEditor.getCurrentTextPanel - Current Panel: sourceFile=" + current.sourceFile);
        return(current);
    }
    
    void setSelectedTabTitle(String title) {
    	int selectedIndex = tabbedPane.getSelectedIndex();
//    	System.out.println("SimulaEditor.setSelectedTabTitle - Current Index:" + selectedIndex);
    	tabbedPane.setTitleAt(selectedIndex,title);
    }
    
    void removeSelectedTab() {
    	int selectedIndex = tabbedPane.getSelectedIndex();
    	tabbedPane.removeTabAt(selectedIndex);
    }
    
    JTextPane getCurrentTextPane() {
    	return(getCurrentTextPanel().getTextPane());
    }
    
    File getCurrentSourceFile() {
    	return(getCurrentTextPanel().sourceFile);
    }
    
    public SimulaEditor() {
        try { setIconImage(simulaIcon.getImage()); } 
        catch (Exception e) { e.printStackTrace(); }
		Global.console=new ConsolePanel();
        Global.console.write("Simula Compiler Console:\n");
        
        // Set the initial size of the window
        int frameHeight=800;//500;
        int topHeight=500;//300;
        int frameWidth=800;
        setSize(frameWidth, frameHeight);

        // Set the title of the window
        setTitle("Untitled - " + "SimulaEditor");

        // Set the default close operation (exit when it gets closed)
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null); // center the frame on screen
//        this.setLocationByPlatform(true);

        getContentPane().setLayout(new BorderLayout()); // the BorderLayout bit makes it fill it automatically
        tabbedPane = new JTabbedPane();
        boolean continuousLayout = true;
        JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,continuousLayout, tabbedPane,Global.console);
        splitPane1.setOneTouchExpandable(true);
        splitPane1.setDividerLocation(topHeight);
        getContentPane().add(splitPane1);

        new Refresher().start();

        // Set the Menus
        JMenuItem aboutMenu = new JMenuItem("About");
        JMenuBar menuBar = new JMenuBar();
        fileMenu=new FileMenu(this);
        menuBar.add(fileMenu);
        menuBar.add(new SourceMenu(this));
        menuBar.add(new EditMenu(this));
        menuBar.add(new RunMenu(this));
        menuBar.add(new SettingsMenu());
        menuBar.add(aboutMenu);
       
        this.setJMenuBar(menuBar);
        
        AboutDialog about=new AboutDialog(this);
        aboutMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("ABOUT");
				about.setVisible(true);
			}});
        aboutMenu.setEnabled(true);
    }
    
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
        	//System.out.println("WINDOW CLOSING EVENT");
        	fileMenu.doExit(); 
        }
    }


	void doNewFile() {
        SourceTextPanel panel=new SourceTextPanel(null);
        panel.newTextPane();
        tabbedPane.addTab("unnamed", null, panel, "Tool tip ...");
        // select the last tab
        tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
//        getCurrentTextPanel();
		panel.fileChanged=false;
	}

	void doOpenFile(File file) {
        SourceTextPanel panel=new SourceTextPanel(file);
		try { panel.fillTextPane(new FileReader(file)); }
		catch(IOException e) { e.printStackTrace(); }
        tabbedPane.addTab(file.getName(), null, panel, "Tool tip ...");
        // select the last tab
        tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
		panel.fileChanged=false;
	}
	
	class Refresher extends Thread {
		boolean stop=false;
		
		public Refresher() {
			setPriority(MIN_PRIORITY);
		}
		
		public void run() {
			while(!stop) {
				try {sleep(1000); } catch(InterruptedException e) {}
				try {
				SourceTextPanel current=getCurrentTextPanel();
				if(AUTO_REFRESH && current!=null && current.refreshNeeded) {
					current.refreshNeeded=false;
					current.doRefresh();
				}
				} catch(Throwable t) {}
			}
		}
	}


	void doRefresh() {
		getCurrentTextPanel().doRefresh();
	}

}