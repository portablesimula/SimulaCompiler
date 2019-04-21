/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
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
import java.io.StringReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import simula.compiler.SimulaCompiler;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;


public class SimulaEditor extends JFrame {

    private static final long serialVersionUID = 1L;
    static JTabbedPane tabbedPane; 
    static EditorMenues menuBar;
    static SourceTextPanel current;
    static AutoRefresher autoRefresher;
    
	// ****************************************************************
	// *** SimulaEditor: Main Entry
	// ****************************************************************
    public static void main(String[] args) {
		String simulaHome=Global.getProperty("simula.home",null); // Default, may be null
		if(simulaHome==null) Util.error("Simula Property 'simula.home' is not defined");
		String userDir="C:/GitHub/SimulaCompiler/Simula";
		Global.packetName="simulaTestPrograms";
		Option.keepJava=userDir; // Generated .java Source is then found in Eclipse Package simulaTestPrograms
		Global.simulaRtsLib=userDir+"/bin/"; // To use Eclipse Project's simula.runtime
		Option.outputDir=Global.getTempFileDir("simula/bin/");
		RTOption.InitRuntimeOptions();
    	Option.InitCompilerOptions();
		Global.sampleSourceDir="C:/GitHub/SimulaCompiler/Simula/src/simulaTestPrograms/samples";
		SimulaEditor editor=new SimulaEditor();
    	editor.setVisible(true);
    }
            
	// ****************************************************************
	// *** Constructor
	// ****************************************************************
    public SimulaEditor() {
        try { setIconImage(Global.simIcon.getImage()); } 
        catch (Exception e) { Util.INTERNAL_ERROR("Impossible",e); }
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

        getContentPane().setLayout(new BorderLayout()); // the BorderLayout bit makes it fill it automatically
        tabbedPane = new JTabbedPane();
        tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Component selected=tabbedPane.getSelectedComponent();
				if(selected instanceof SourceTextPanel) {
					//SourceTextPanel current=getCurrentTextPanel();
					current=(SourceTextPanel)selected;
					menuBar.updateMenuItems();
				}
			}});
        boolean continuousLayout = true;
        JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,continuousLayout, tabbedPane,Global.console);
        splitPane1.setOneTouchExpandable(true);
        splitPane1.setDividerLocation(topHeight);
        getContentPane().add(splitPane1);

        autoRefresher=new AutoRefresher(); autoRefresher.start();

        // Set the Menus
        menuBar=new EditorMenues();
        this.setJMenuBar(menuBar);
        this.setVisible(true);
        doCheckForNewVersion();
        doSelectWorkspace();
    }
    
    // ****************************************************************
    // *** processWindowEvent
    // ****************************************************************
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
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
    			   +"\nThe default workspace 'Samples' contains a set of"
    	           +"\nSimula sample programs ready to be compiled."
    	           +"\nYou may open them by the menu item [File][Open]"
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
    	panel.add(new JTextArea(""),BorderLayout.SOUTH);
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
//			if (Option.verbose) {
//				System.out.print("SimulaEditor.doCheckForNewVersion: REMOTE ");
//				remoteProperties.list(System.out);
//			}
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
        } catch(Exception e) { Util.INTERNAL_ERROR("Impossible",e); }
    }
    
    
    // ****************************************************************
    // *** setSelectedTabTitle  /  removeSelectedTab
    // ****************************************************************
    static void setSelectedTabTitle(String title) { tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(),title); }
    static void removeSelectedTab() {
    	tabbedPane.removeTabAt(tabbedPane.getSelectedIndex());
        current=(SourceTextPanel)tabbedPane.getSelectedComponent();
        menuBar.updateMenuItems();
    }
    
    // ****************************************************************
    // *** doNewTabbedPanel
    // ****************************************************************
	static void doNewTabbedPanel(File file) {
        //SourceTextPanel current=new SourceTextPanel(file,menuBar.popupMenu);
        current=new SourceTextPanel(file,menuBar.popupMenu);
        tabbedPane.addTab((file==null)?"unnamed":file.getName(), null, current, "Tool tip ...");
        // select the last tab
        tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
		current.fileChanged=false;
		if(file==null)current.fillTextPane(new StringReader("begin\n\nend;\n"),0);
		else try { Reader reader=new InputStreamReader(new FileInputStream(file),Global.CHARSET$);
		 		   current.fillTextPane(reader,0);
		} catch(IOException e) { Util.INTERNAL_ERROR("Impossible",e); }
		menuBar.updateMenuItems();
	}
	
    // ****************************************************************
    // *** doRunJarFile
    // ****************************************************************
	static void doRunJarFile(File jarFile) {
		new Thread(new Runnable() {
			public void run() {
				try { SimulaCompiler.execute("java -jar " + jarFile + " -USE_CONSOLE");
				} catch (IOException e) { Util.INTERNAL_ERROR("Impossible",e); }
			}
		}).start();
	}
	
    // ****************************************************************
    // *** AutoRefresher
    // ****************************************************************
	class AutoRefresher extends Thread {
		int counter=10;
		boolean stoped=false;
		public AutoRefresher() { setPriority(MIN_PRIORITY);	}
		public void terminate() { stoped=true; }
		public void reset() { counter=10; }

		public void run() {
			while (!stoped) {
				try { sleep(100); } catch (InterruptedException e) {}
				if ((counter--) <= 0) {
					try { if (current.AUTO_REFRESH && current != null && current.refreshNeeded) {
							  current.refreshNeeded = false;
							  menuBar.refresh.doClick();
						  }
					} catch (Throwable t) {}
				}
			}
		}
	}

}