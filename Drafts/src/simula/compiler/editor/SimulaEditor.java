package simula.compiler.editor;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import simula.compiler.SimulaCompiler;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.RTOption;
import simula.compiler.utilities.Util;


public class SimulaEditor extends JFrame {

    private static final long serialVersionUID = 1L;
//    public static boolean RENDER_LINE_NUMBERS=true;
//    public static boolean AUTO_REFRESH=false;
    
    JTabbedPane tabbedPane; 
    static SimulaMenuBar menuBar;
//    FileMenu fileMenu;
//    static EditMenu editMenu;
//    RunMenu runMenu;
//    HelpMenu helpMenu;
//    SettingsMenu settings;
//    JPopupMenu popupMenu;

    
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

		RTOption.InitRuntimeOptions();
    	Option.InitCompilerOptions();
		
//		Global.sampleSourceDir="C:/GitHub/SimulaCompiler/Simula/src/simulaTestPrograms/simple";
		Global.sampleSourceDir="C:/GitHub/SimulaCompiler/Simula/src/simulaTestPrograms/samples";

		SimulaEditor editor=new SimulaEditor();
    	editor.setVisible(true);
    }

    SourceTextPanel getCurrentTextPanel() {
        SourceTextPanel current=(SourceTextPanel)tabbedPane.getSelectedComponent();
//        Util.println("SimulaEditor.getCurrentTextPanel - Current Panel: name=" + current.getName());
//        Util.println("SimulaEditor.getCurrentTextPanel - Current Panel: sourceFile=" + current.sourceFile);
        return(current);
    }
    
    void setSelectedTabTitle(String title) {
    	int selectedIndex = tabbedPane.getSelectedIndex();
    	tabbedPane.setTitleAt(selectedIndex,title);
    }
    
    void removeSelectedTab() {
    	int selectedIndex = tabbedPane.getSelectedIndex();
    	tabbedPane.removeTabAt(selectedIndex);
    }
    
    JTextPane getCurrentTextPane() {
		SourceTextPanel current=getCurrentTextPanel();
		if(current!=null) return(current.editTextPane);
		return(null);
    }
    
    File getCurrentSourceFile() {
		SourceTextPanel current=getCurrentTextPanel();
		if(current!=null) return(current.sourceFile);
		return(null);
    }
    
    public SimulaEditor() {
        try { setIconImage(Global.simIcon.getImage()); } 
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
    	Global.currentWorkspace=Global.getProperty("simula.workspace.dir",Global.sampleSourceDir);

        // Set the default close operation (exit when it gets closed)
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null); // center the frame on screen
//        this.setLocationByPlatform(true);

        getContentPane().setLayout(new BorderLayout()); // the BorderLayout bit makes it fill it automatically
        tabbedPane = new JTabbedPane();
        tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Component selected=tabbedPane.getSelectedComponent();
				if(selected instanceof SourceTextPanel) {
					SourceTextPanel current=getCurrentTextPanel();
					//current.updateEditable();
					//editMenu.updateMenuItems(current);
					menuBar.updateMenuItems(current);
				}
			}});
        boolean continuousLayout = true;
        JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,continuousLayout, tabbedPane,Global.console);
        splitPane1.setOneTouchExpandable(true);
        splitPane1.setDividerLocation(topHeight);
        getContentPane().add(splitPane1);

        new Refresher().start();

        // Set the Menus
        //JMenuBar menuBar = new JMenuBar();
        menuBar=new SimulaMenuBar(this);

        
//        fileMenu=new FileMenu(this); menuBar.add(fileMenu);
//        editMenu=new EditMenu(this); menuBar.add(editMenu);
//        runMenu=new RunMenu(this); menuBar.add(runMenu);
//        settings=new SettingsMenu(); menuBar.add(settings);
//        helpMenu=new HelpMenu(); menuBar.add(helpMenu);
       
        this.setJMenuBar(menuBar);

//	    popupMenu=new JPopupMenu();
//	    fileMenu.addPopupMenuItems(popupMenu);
//	    editMenu.addPopupMenuItems(popupMenu);
//	    runMenu.addPopupMenuItems(popupMenu);
//	    settings.addPopupMenuItems(popupMenu);
//	    helpMenu.addPopupMenuItems(popupMenu);
        this.setVisible(true);
        doCheckForNewVersion();
        doSelectWorkspace();
    }
    
    // ****************************************************************
    // *** processWindowEvent
    // ****************************************************************
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
        	//Util.println("WINDOW CLOSING EVENT");
        	//fileMenu.doExitAction(); 
        	menuBar.doExitAction(); 
        }
    }

    // ****************************************************************
    // *** doSelectWorkspace
    // ****************************************************************
    void doSelectWorkspace() {
    	if (Option.verbose) Util.println("SimulaEditor.doSelectWorkspace: ");
    	String text="The Simula Editor uses the directory workspace to "
    			   +"\nretrieve Simula source files and save the results"
    	           +"\n"
    			   +"\nExecutable .jar files are stored in the subdirectory /bin"
                   +"\n";
    	String browse="Browse for another Workspace Directory";
    	Choice workspaceChooser = new Choice();
    	ArrayDeque<String> workspaces=Global.loadWorkspaces();
    	for(String workspace:workspaces) workspaceChooser.add(workspace);
    	workspaceChooser.add(browse);
    	workspaceChooser.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
		        //Util.println("itemStateChanged: "+e);
		        //Util.println("Workspace Selected: "+ workspaceChooser.getItem(workspaceChooser.getSelectedIndex()));  
		        String s=workspaceChooser.getItem(workspaceChooser.getSelectedIndex());  
		        if(s.equals(browse)) {
			        //Util.println("itemStateChanged: CALL FILE CHOOSER on"+e.getItem());  
			        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home",Global.currentWorkspace));
			        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			        int answer = fileChooser.showOpenDialog(SimulaEditor.this);
			        if (answer == JFileChooser.APPROVE_OPTION) {
			        	String anotherWorkspace=fileChooser.getSelectedFile().toString();
			        	workspaceChooser.remove(browse);  
			        	workspaceChooser.add(anotherWorkspace);
			        	workspaceChooser.add(browse);
			        	workspaceChooser.select(anotherWorkspace);
			        }
		        }		        	
			}});

		Object PanelBackground=UIManager.get("Panel.background");
        UIManager.put("Panel.background", Color.WHITE);
    	JPanel panel=new JPanel();
    	JTextArea textArea=new JTextArea(text);
    	panel.setLayout(new BorderLayout());
    	panel.add(textArea,BorderLayout.NORTH);
    	panel.add(workspaceChooser,BorderLayout.CENTER);
		Util.optionDialog(panel,"Select Simula Workspace",JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE,"OK");
        UIManager.put("Panel.background",PanelBackground);
        String selected=workspaceChooser.getItem(workspaceChooser.getSelectedIndex());  
    	Global.updateCurrentWorkspace(selected);
        //Util.println("doSelectWorkspace: selected="+selected);
    }

    // ****************************************************************
    // *** doCheckForNewVersion
    // ****************************************************************
    void doCheckForNewVersion() {
    	if (Option.verbose) Util.println("SimulaEditor.doCheckForNewVersion: ");
        try {
        	String thisRevision=Global.getProperty("simula.revision","?");
        	String thisSetupDated=Global.getProperty("simula.setup.dated","?");
	        String thisReleaseID=Global.simulaReleaseID+'R'+thisRevision;

		    String remoteFileName="https://portablesimula.github.io/github.io/setup/setupProperties.xml";
		    if (Option.verbose) Util.println("SimulaEditor.doCheckForNewVersion: Load Remote Properties from: "+remoteFileName);
		    URL remote = new URL(remoteFileName);
            Properties remoteProperties=new Properties();
            remoteProperties.loadFromXML(remote.openStream());
			if (Option.verbose) {
				System.out.print("SimulaEditor.doCheckForNewVersion: REMOTE ");
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
    			int result=Util.optionDialog(msg,"Update Notification",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,"Yes","No");
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
    
    
	void doNewTabbedPanel(File file) {
//        SourceTextPanel panel=new SourceTextPanel(file,popupMenu);
        SourceTextPanel panel=new SourceTextPanel(file,menuBar.popupMenu);
        tabbedPane.addTab((file==null)?"unnamed":file.getName(), null, panel, "Tool tip ...");
        // select the last tab
        tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
		panel.fileChanged=false; if(file==null) return;
		try {
			Reader reader=new InputStreamReader(new FileInputStream(file),Global.CHARSET$);
			panel.fillTextPane(reader,0);
		}
		catch(IOException e) { e.printStackTrace(); }
	}
	
	void doRunJarFile(File jarFile) {
		new Thread(new Runnable() {
			public void run() {
				try { SimulaCompiler.execute("java -jar " + jarFile + " -USE_CONSOLE");
				} catch (IOException e) { e.printStackTrace(); }
			}
		}).start();
	}
	
	class Refresher extends Thread {
		boolean stop=false;
		
		public Refresher() {
			setPriority(MIN_PRIORITY);
		}
		
		// counter - set when a keyin
		// sleep(n): counter--
		public void run() {
			while(!stop) {
				try {sleep(1000); } catch(InterruptedException e) {}
				try {
				SourceTextPanel current=getCurrentTextPanel();
				if(current.AUTO_REFRESH && current!=null && current.refreshNeeded) {
					current.refreshNeeded=false;
					//current.doRefresh();
					//editMenu.refresh.doClick();
					menuBar.refresh.doClick();
				}
				} catch(Throwable t) {}
			}
		}
	}

}