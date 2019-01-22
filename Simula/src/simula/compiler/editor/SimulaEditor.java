package simula.compiler.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;


public class SimulaEditor extends JFrame {

    private static final long serialVersionUID = 1L;
    public static boolean RENDER_LINE_NUMBERS=true;
    public static boolean AUTO_REFRESH=false;
    public static final ImageIcon simulaIcon = new ImageIcon("icons/simula.png");
    public static final ImageIcon simIcon = new ImageIcon("icons/sim2.png");
    public static final ImageIcon sIcon = new ImageIcon("icons/sim.png");
    
    JTabbedPane tabbedPane; 
    FileMenu fileMenu;

    
//    private File currentFile;
    
    public static void main(String[] args) {
    	//System.setProperty("file.encoding","UTF-8");
       	
		String simulaHome=Global.getProperty("simula.home",null); // Default, may be null
		if(simulaHome==null) Util.error("Simula Property 'simula.home' is not defined");

		//String userDir=System.getProperty("user.dir");
		String userDir="C:/GitHub/SimulaCompiler/Simula";
		Global.packetName="simulaTestPrograms";
		Option.keepJava=userDir; // Generated .java Source is then found in Eclipse Package simulaTestPrograms
		Global.simulaRtsLib=userDir+"/bin/"; // To use Eclipse Project's simula.runtime
		Option.outputDir=Global.getTempFileDir("simula/bin/");

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
//		UIManager.put("OptionPane.background", Color.WHITE);
//        UIManager.put("OptionPane.messagebackground", Color.WHITE);
//        UIManager.put("Panel.background", Color.WHITE);
        try { setIconImage(simIcon.getImage()); } 
        catch (Exception e) { e.printStackTrace(); }
		Global.console=new ConsolePanel();
        Global.console.write("Simula Compiler Console:\n");
        
        // Set the initial size of the window
        int frameHeight=800;//500;
        int topHeight=500;//300;
        int frameWidth=800;
        setSize(frameWidth, frameHeight);

        // Set the title of the window
    	String revision=Global.getProperty("simula.revision","?");
    	String dated=Global.getProperty("simula.setup.dated","?");
        String releaseID=Global.simulaReleaseID+'R'+revision;
        setTitle("SimulaEditor ("+releaseID+ " built "+dated+" )");

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
        this.setVisible(true);
        doCheckForNewVersion();
    }
    
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
        	//System.out.println("WINDOW CLOSING EVENT");
        	fileMenu.doExit(); 
        }
    }

    void doCheckForNewVersion() {
    	if (Option.verbose) System.out.println("SimulaEditor.doCheckForNewVersion: ");
        try {
        	String thisRevision=Global.getProperty("simula.revision","?");
        	String thisSetupDated=Global.getProperty("simula.setup.dated","?");
	        String thisReleaseID=Global.simulaReleaseID+'R'+thisRevision;

		    String remoteFileName="https://portablesimula.github.io/github.io/setup/setupProperties.xml";
		    if (Option.verbose) System.out.println("SimulaEditor.doCheckForNewVersion: Load Remote Properties from: "+remoteFileName);
		    URL remote = new URL(remoteFileName);
            Properties remoteProperties=new Properties();
            remoteProperties.loadFromXML(remote.openStream());
			if (Option.verbose) {
				System.out.print("REMOTE ");
				remoteProperties.list(System.out);
			}
            String remoteReleaseID=remoteProperties.getProperty("simula.version")
            		          +'R'+remoteProperties.getProperty("simula.revision");
        	String remoteSetupDated=remoteProperties.getProperty("simula.setup.dated","?");
            
            if(!remoteReleaseID.equalsIgnoreCase(thisReleaseID)) {
    			String msg = "   A newer version of Simula is available:\n\n"
				  	       + "   - Installed version: "+thisReleaseID+"\n"
 				  	       + "        Dated: "+thisSetupDated+"\n\n"
    					   + "   - Available version: "+remoteReleaseID+"\n"
 				  	       + "        Dated: "+remoteSetupDated+"\n\n"
    					   
    					   + "   Do you want to download now ?\n";
    			int result=optionDialog(msg,"Update Notification",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    			if(result==0) {
					Desktop desktop = Desktop.getDesktop();
//					try { desktop.browse(new URI("https://github.com/portablesimula"));
					try {
						desktop.browse(new URI("https://portablesimula.github.io/github.io/"));
					    System.exit(-1); // Stop the Editor
					} catch (Exception ex) {}
    			}
            }
        } catch(Exception e) { e.printStackTrace(); }
        
    }
 
	public static int optionDialog(Object msg, String title, int optionType, int messageType) {
		Object OptionPaneBackground=UIManager.get("OptionPane.background");
		Object PanelBackground=UIManager.get("Panel.background");
 		UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
		int answer = JOptionPane.showOptionDialog(null,msg,title,optionType,messageType,SimulaEditor.sIcon, null, null);
		//System.out.println("doClose.saveDialog: answer="+answer);
		UIManager.put("OptionPane.background",OptionPaneBackground);
        UIManager.put("Panel.background",PanelBackground);
		return(answer);
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