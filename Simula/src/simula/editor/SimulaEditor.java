/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.editor;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.URL;
import java.nio.file.attribute.FileTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

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

import simula.compiler.utilities.ConsolePanel;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;


/**
 * The SimulaEditor.
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/editor/SimulaEditor.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
@SuppressWarnings("serial")
public class SimulaEditor extends JFrame {
	
	/**
	 * The tabbed pane.
	 */
    static JTabbedPane tabbedPane; 
    
    /**
     * The menu bar.
     */
    static EditorMenues menuBar;
    
    /**
     * The current SourceTextPanel
     */
    static SourceTextPanel current;
    
    /**
     * The autoRefresher
     */
    static AutoRefresher autoRefresher;
    
    /**
     * Available languages.
     */
    public enum Language { /** Simula */Simula,/** Jar file */Jar,/** Text file */Text,/** other */ Other }

    
	// ****************************************************************
	// *** SimulaEditor: Main Entry for TESTING ONLY
	// ****************************************************************
    /**
     * SimulaEditor: Main Entry for TESTING ONLY.
     * @param args the arguments
     */
    public static void main(String[] args) {
		Global.packetName="simprog";
		String userDir="C:/GitHub/SimulaCompiler/Simula";
		Global.simulaRtsLib=new File(userDir,"bin"); // To use Eclipse Project's simula.runtime  Download
		RTOption.InitRuntimeOptions();
    	Option.InitCompilerOptions();
		Global.sampleSourceDir=new File(userDir+"/src/simulaTestPrograms/samples");
		Option.INLINE_TESTING=true;
		SimulaEditor editor=new SimulaEditor();
    	editor.setVisible(true);
    }
            
	// ****************************************************************
	// *** Constructor
	// ****************************************************************
    /**
     * Create a new SimulaEditor.
     */
    public SimulaEditor() {
		Global.initiate();
        try { setIconImage(Global.simIcon.getImage()); } 
        catch (Exception e) {}// Util.IERR("Impossible",e); }
		Global.console=new ConsolePanel();
    	String revision=Global.getSimulaProperty("simula.revision","?");
    	String dated=Global.getSimulaProperty("simula.setup.dated","?");
        String releaseID=Global.simulaReleaseID+'R'+revision;
		Global.simulaVersion="SimulaEditor ("+releaseID+ " built "+dated+" using "+getJavaID()+")";
        Global.console.write(Global.simulaVersion+"\n");
        
        // Set the initial size of the window
        int frameHeight=800;//500;
        int topHeight=500;//300;
        int frameWidth=800;
        setSize(frameWidth, frameHeight);

        // Set the title of the window
        setTitle(Global.simulaVersion);
       	Global.loadWorkspaceProperties();
    	
        // Set the default close operation (exit when it gets closed)
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null); // center the frame on screen

        getContentPane().setLayout(new BorderLayout()); // the BorderLayout bit makes it fill it automatically
        tabbedPane = new JTabbedPane();
        tabbedPane.addMouseListener(mouseListener);
        tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Component selected=tabbedPane.getSelectedComponent();
				if(selected instanceof SourceTextPanel panel) {
					current=panel;
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
        
		int javaVersion=getJavaVersion();
		if(javaVersion < 21) {
			Util.popUpError("You have installed Java "+System.getProperty("java.version")+'.'
					     +"\nWe recommend at least Java 21."
					     +"\nCheck the settings and consider"
					     +"\ninstalling a newer version.\n");
		}

        doCheckForNewVersion();
        doSelectWorkspace();
    }

    /**
     * Utility: getJavaVersion
     * @return the JavaVersion
     */
	private static int getJavaVersion() {
		String ver = System.getProperty("java.version");
		try {
			if (ver.startsWith("1.")) {
				return (ver.charAt(2) - '0');
			} else {
				ver = ver.substring(0, 2);
				return (Integer.parseInt(ver));
			}
		} catch (Exception e) {}
		return (0);
	}
	
	/**
	 * Utility: get Java ID
	 * @return the Java ID string
	 */
	private static String getJavaID() {
		String javaID="Java version "+System.getProperty("java.version");
        return(javaID);
	}

	// ****************************************************************
	// *** MouseListener
	// ****************************************************************
	/**
	 * The MouseListener.
	 */
    MouseListener mouseListener = new MouseListener() {
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {
    	    if(e.getButton()==3) menuBar.popupMenu.show(tabbedPane,e.getX(),e.getY());
    	}
    };
    
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
    /**
     * Select Workspace dialog.
     */
    static void doSelectWorkspace() {
    	if (Option.TRACING) Util.println("SimulaEditor.doSelectWorkspace: ");
    	String text="The Simula Editor uses the directory workspace to "
    			   +"\nretrieve Simula source files and save the results"
    	           +"\n"
    			   +"\nThe default workspace 'Samples' contains a set of"
    	           +"\nSimula sample programs ready to be compiled."
    	           +"\nYou may open them by the menu item [File][Open]"
    	           +"\n"
    			   +"\nExecutable .jar files are normally stored in the"
    	           +"\nsubdirectory <CurrentWorkspace>/bin"
                   +"\n";
    	String browse="Browse for another Workspace Directory";
    	Choice workspaceChooser = new Choice();
		for(File workspace:Global.workspaces) workspaceChooser.add(workspace.toString());			
    	workspaceChooser.add(browse);
    	workspaceChooser.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
		        String s=workspaceChooser.getItem(workspaceChooser.getSelectedIndex());  
		        if(s.equals(browse)) {
			        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home",Global.currentWorkspace.toString()));
			        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			        int answer = fileChooser.showOpenDialog(null);
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
    	Global.setCurrentWorkspace(new File(selected));
	    Global.trySetOutputDir(new File(Global.currentWorkspace,"bin"));
    }

    // ****************************************************************
    // *** doSelectJavaDir
    // ****************************************************************
    /**
     * Select Java directory dialog.
     */
    static void doSelectJavaDir() {
    	if (Option.TRACING) Util.println("SimulaEditor.doSelectJavaDir: ");
	    File file=new File(Global.currentWorkspace,"java");
	    file.mkdirs();
        JFileChooser fileChooser = new JFileChooser(file);
        fileChooser.setDialogTitle("Select Java Directory");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int answer = fileChooser.showOpenDialog(null);
        if (answer == JFileChooser.APPROVE_OPTION) {
        	Option.keepJava=fileChooser.getSelectedFile();
        }
    }

    // ****************************************************************
    // *** doSelectOutputDir
    // ****************************************************************
    /**
     * Select Output directory dialog.
     */
    static void doSelectOutputDir() {
    	if (Option.TRACING) Util.println("SimulaEditor.doSelectOutputDir: ");
        JFileChooser fileChooser = new JFileChooser(Global.outputDir);
        fileChooser.setDialogTitle("Select Output Directory");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int answer = fileChooser.showOpenDialog(null);
        if (answer == JFileChooser.APPROVE_OPTION) {
        	Global.outputDir=fileChooser.getSelectedFile();
        }
    }

    // ****************************************************************
    // *** doSelectExtLibDir
    // ****************************************************************
    /**
     * Select External Search Library dialog.
     */
    static void doSelectExtLibDir() {
    	if (Option.TRACING) Util.println("SimulaEditor.doSelectExtLibDir: ");
    	File prev=Global.extLib;
    	if(prev==null) prev=Global.outputDir.getParentFile();
//        JFileChooser fileChooser = new JFileChooser(Global.extLib);
        JFileChooser fileChooser = new JFileChooser(prev);
        fileChooser.setDialogTitle("Select External Search Library");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int answer = fileChooser.showOpenDialog(null);
        if (answer == JFileChooser.APPROVE_OPTION) {
        	Global.extLib=fileChooser.getSelectedFile();
        }
    }
    
    // ****************************************************************
    // *** doCheckForNewVersion
    // ****************************************************************
    /**
     * Check for new version of the Simula System.
     * <p>
     * The Simula site at GitHub is contacted and the current Simula Release ID is checked against this vesrion.
     * If not equal question dialog panel is poped up.
     */
    void doCheckForNewVersion() {
    	if (Option.TRACING) Util.println("SimulaEditor.doCheckForNewVersion: ");
        try {
        	String thisRevision=Global.getSimulaProperty("simula.revision","?");
        	String thisSetupDated=Global.getSimulaProperty("simula.setup.dated","?");
	        String thisReleaseID=Global.simulaReleaseID+'R'+thisRevision;

		    String remoteFileName="https://portablesimula.github.io/github.io/setup/setupProperties.xml";
		    if (Option.TRACING) Util.println("SimulaEditor.doCheckForNewVersion: Load Remote Properties from: "+remoteFileName);
//		    URL remote = new URL(remoteFileName);
		    URL remote = (new URI(remoteFileName)).toURL();
            Properties remoteProperties=new Properties();
            remoteProperties.loadFromXML(remote.openStream());
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
					try {
						desktop.browse(new URI("https://portablesimula.github.io/github.io/"));
					    System.exit(-1); // Stop the Editor
					} catch (Exception ex) {
						msg="Unable to open Desktop Browser\n\n"
						   +"Go to your Browser and open page:\n"
						   +" https://portablesimula.github.io/github.io/\n\n"
						   +"Do you want to continue ?";
		    			result=Util.optionDialog(msg,"Update Notification",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,"Yes","No");
						if(result!=0) System.exit(-1); // Stop the Editor
					}
    			}
            }
        } catch(Exception e) { Util.IERR("Impossible",e); }
    }
    
    
    // ****************************************************************
    // *** setSelectedTabTitle  /  removeSelectedTab
    // ****************************************************************
    /**
     * Set selected tab's title
     * @param title the new title
     */
    static void setSelectedTabTitle(String title) { tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(),title); }
    
    /**
     * Remove selected tab.
     */
    static void removeSelectedTab() {
    	tabbedPane.removeTabAt(tabbedPane.getSelectedIndex());
        current=(SourceTextPanel)tabbedPane.getSelectedComponent();
        menuBar.updateMenuItems();
    }
    
    // ****************************************************************
    // *** doNewTabbedPanel
    // ****************************************************************
    /**
     * Create a new Tab with text generated from the given file.
     * @param file the file
     * @param lang the language
     */
    static void doNewTabbedPanel(File file,Language lang) {
    	new Thread(new Runnable() {
    		public void run() {
     			current=new SourceTextPanel(file,lang,menuBar.popupMenu);
    			tabbedPane.addTab((file==null)?"unnamed":file.getName(), null, current, "Tool tip ...");
    			// select the last tab
    			tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
    			current.fileChanged=false;
    			if(file==null)current.fillTextPane(new StringReader("begin\n\nend;\n"),0);
    			else if(lang==Language.Simula) {
    				try { Reader reader=new InputStreamReader(new FileInputStream(file),Global._CHARSET);
    					  current.fillTextPane(reader,0);
    				} catch(IOException e) { Util.IERR("Impossible",e); }
    			}
    			else if(lang==Language.Jar) {
    				current.fillTextPane(getJarFileReader(file),0);
    			}
    			else if(lang==Language.Other) {
    				current.fillTextPane(getHexFileReader(file),0);
    			}
    			else if(lang==Language.Text)
    				try { Reader reader=new InputStreamReader(new FileInputStream(file),Global._CHARSET);
    				current.fillTextPane(reader,0);
    			} catch(IOException e) { Util.IERR("Impossible",e); }
    			menuBar.updateMenuItems();
    		}}).start();
    }
    
    /**
     * Utility: Get HexFile Reader.
     * @param file the file to read
     * @return The resulting reader
     */
    private static Reader getHexFileReader(File file) {
    	StringBuilder sb=new StringBuilder();
    	String hexPart="",charPart="";
    	FileInputStream inpt;
    	try { inpt=new FileInputStream(file);
    		int b;
    		while((b=inpt.read()) != -1) {
    			hexPart=hexPart+' '+AppendLeadingZeroes(Integer.toHexString(b),2);
    			charPart=charPart+((b>31 && b<128)?((char)b):'.');
    			if((charPart.length())>15) {
    				sb.append("  "+hexPart+"  "+charPart+"\n");
    				hexPart=""; charPart="";
    			}
    		}
    		if((charPart.length())>0) {
    	    	while(hexPart.length()<(16*3)) hexPart=hexPart+" ";
				sb.append("  "+hexPart+"  "+charPart+"\n");    			
    		}
    	} catch(IOException e) { Util.IERR("Impossible",e); }
    	return(new StringReader(sb.toString()));
    }
    
    /** 
     * Utility: Append leading zeroes.
     * @param s the input string
     * @param n the expected length
     * @return the resulting string
     */
    private static String AppendLeadingZeroes(String s,int n) {
    	while(s.length()<n) s="0"+s;
    	return(s.toUpperCase());
    }
   
    /**
     * Get .jar file Reader
     * @param file the file
     * @return a .jar file Reader
     */
    private static Reader getJarFileReader(File file) {
    	StringBuilder sb=new StringBuilder();
    	sb.append("File: "+file).append("\n");
    	if(!(file.exists() && file.canRead())) {
    		sb.append("Can't read .jar file: "+file).append("\n");
    	} else {
    		JarFile jarFile=null;
    		try {
    			jarFile=new JarFile(file);
    			Manifest manifest=jarFile.getManifest();
    			Attributes mainAttributes=manifest.getMainAttributes();
    			Set<Object> keys=mainAttributes.keySet();
    			for(Object key:keys) {
    				String val=mainAttributes.getValue(key.toString());
    				sb.append(key.toString()+"=\""+val+"\"").append("\n");
    			}

    			Enumeration<JarEntry> entries=jarFile.entries();
    			while(entries.hasMoreElements()) {
    				JarEntry entry=entries.nextElement();
    				String size=""+entry.getSize();
    				while(size.length()<6) size=" "+size;
    				FileTime fileTime=entry.getLastModifiedTime();
    				String date = DateTimeFormatter.ofPattern("uuuu-MMM-dd HH:mm:ss", Locale.getDefault())
    						.withZone(ZoneId.systemDefault()).format(fileTime.toInstant());
    				sb.append("Jar-Entry: "+size+"  "+date+"  \""+entry+"\"").append("\n");
    			}
    		} catch(IOException e) {
    			Util.IERR("Caused by:",e);
    		} finally {
    			if(jarFile!=null)
    				try { jarFile.close(); } catch (IOException e) { e.printStackTrace(); }
    		}
    	}
    	return(new StringReader(sb.toString()));
    }
	
	// ****************************************************************
	// *** doRunJarFile
	// ****************************************************************
    /**
     * Run the given .jar file
     * @param jarFile the file
     */
	static void doRunJarFile(File jarFile) {
		new Thread(new Runnable() {
			@Override
			public void run() {
//				String[] cmds= {"java","-jar",jarFile.toString(),"-useConsole"};
				String userDir=jarFile.getParentFile().getParent();
				String[] cmds= {"java","-jar",jarFile.toString(),"-useConsole","-userDir",userDir};
				try { Util.execute(cmds);
				} catch (IOException e) { Util.IERR("Impossible",e); }
			}
		}).start();
	}
	    
    // ****************************************************************
    // *** AutoRefresher
    // ****************************************************************
	/**
	 *  Utility class: AutoRefresher
	 */
	class AutoRefresher extends Thread {
		/** counter */ int counter=10;
		/** stoped mark */ boolean stoped=false;
		/** Constructor */ public AutoRefresher() { setPriority(MIN_PRIORITY);	}
		/** terminate */ public void terminate() { stoped=true; }
		/** reset */ public void reset() { counter=10; }

		/**
		 * Run the AutoRefresher
		 */
		@Override
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