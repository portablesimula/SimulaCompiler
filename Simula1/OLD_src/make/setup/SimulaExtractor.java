/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package make.setup;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//import javax.swing.ProgressMonitor;
import javax.swing.UIManager;

/* Self-extractor for installing a Simula System.
 * <p>
 * Based on http://www.javaworld.com/javaworld/javatips/jw-javatip120.html
 * <p>
 * This class is added to a jar file to turn it into a self-extracting jar file.
 * If the jar file is invoked in the standard way,
 * using the command "java -jar file.jar" or double-clicking on it,
 * it opens a dialog allowing the user to control install options,
 * then installs the application.
 * 
 * Modified by: Øystein Myhre Andersen
 */
public final class SimulaExtractor extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final boolean DEBUG=true;
	private static final boolean USE_CONSOLE=true;//false;
	
	// NOTE: When updating release id, change version in Global.simulaReleaseID
    public static final String simulaReleaseID="Simula-1.0";
    public static String simulaRevisionID="?";

    private static final String simulaInstallSubdirectory = "Simula"+File.separatorChar+simulaReleaseID;
	private static final String programAndVersion = "Simula 1.0";
	private static File INSTALL_DIR; // e.g. C:\Users\Øystein\Simula\Simula-1.0
//	private static File BATCH_FILE;
	private static String setupDated;
	private static ImageIcon simulaIcon;
	
	private static String simulaJarFileName;
	private static String targetDir;
	private static int nExtractedFiles;
//	private static boolean compilerBatWasWritten;
//	private static boolean desktopEntryWasWritten;
	
	private String myClassName;
	private JTextField installDirField;
	private static ConsolePanel console;
	private static JFrame mainFrame;

	// ****************************************************************
	// *** SimulaExtractor: Main Entry
	// ****************************************************************
	public static void main(String[] args) {
		if(DEBUG) System.out.println("SimulaExtractor: user.home="+System.getProperty("user.home"));
		if(DEBUG) System.out.println("SimulaExtractor: user.dir="+System.getProperty("user.dir"));
		// List UIManager keys: https://thebadprogrammer.com/swing-uimanager-keys/
		UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("OptionPane.messagebackground", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
		SimulaExtractor simulaExtractor = new SimulaExtractor();
//		simulaExtractor.setVisible(true);

		String jarFileName = simulaExtractor.getJarFileName();
		if(jarFileName==null) jarFileName = "C:/GitHub/Binaries/setup.jar"; // for TESTING ONLY
		
		boolean ok=simulaExtractor.extract(jarFileName);
//		askWriteDesktopLinks();
//		if(!desktopEntryWasWritten) askWriteCompilerBat();
		updateProperties();
		askRunSimula();
//		updateProperties();
		if(console!=null) {
			if(ok) {
			    console.write("=====================================================\n");
			    console.write("Simula was successfully installed in\n\n");
			    console.write("       "+INSTALL_DIR+"\n\n");
			    
//			    if(compilerBatWasWritten) {
//			    	console.write("To activate Simula you may use the following command:\n\n");
//			    	console.write(" "+BATCH_FILE+"\n\n");
//			    	boolean windows=(File.separatorChar)=='\\';
//			    	if(windows) {
//			    		console.write("You may move the batch-file to any directory.\n");
//			    	} else {
//			    		console.write("You may move the shell script to any directory.\n");
//			    	}
//			    }
//			    if(desktopEntryWasWritten) {
//			    	console.write("Use DesktopEntry 'Simula' to activate Simula\n");			    	
//			    }
			}
		while(true) Thread.yield();
		} else System.exit(ok ? 0 : 1);
	}
	
	// ***************************************************************
	// *** Constructor: SimulaExtractor
	// ***************************************************************
	SimulaExtractor() {
		URL url=getClass().getResource("sim.png");
		simulaIcon=(url==null)?null:new ImageIcon(url);
		mainFrame=this;
		if(USE_CONSOLE) {
			// Set the initial size of the window
			int frameHeight=300;
			int frameWidth=550;
			setSize(frameWidth, frameHeight);
	        // Set the default close operation (exit when it gets closed)
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null); // center the frame on screen
			if(DEBUG) System.out.println("Open ConsolePanel");
			console=new ConsolePanel();
			mainFrame.setTitle("Installing Simula");
			mainFrame.add(console);
//			mainFrame.setVisible(true);
		}
	}
	
//	// ***************************************************************
//	// *** askWriteCompilerBat
//	// ***************************************************************
//	private static void askWriteCompilerBat() {
//		boolean windows=(File.separatorChar)=='\\';
//		String text;
//		String fileName;
//		if(windows) {
//			fileName="RunSimulaEditor.bat";
//			text="CHCP 65001\r\n" +  // Let Windows recognize UTF-8
//			     "rem *** Call Simula Editor\r\n" + 
//				 "java -jar "+INSTALL_DIR+"\\simula.jar\r\n" + 
////				 "cd "+INSTALL_DIR+"\r\n"+
////				 "java -jar simula.jar\r\n" + 
//				 "pause\r\n";
//		} else {
//			fileName="RunSimulaEditor.sh";
//			text="printf \"*** Call Simula Editor\\n\"\n" + 
//                 "pushd "+INSTALL_DIR+"\n"+
//				 "java -jar simula.jar\n" + 
//                 "popd\n"+
//				 "read -p \"Press enter to continue\"\n";
//		}
//		if(DEBUG) System.out.println("INSTALL_DIR="+INSTALL_DIR);
//		if(DEBUG) System.out.println("fileName="+fileName);
//		if(DEBUG) System.out.println("text="+text);
////		File file=new File(path+'/'+fileName);
////		BATCH_FILE=new File(INSTALL_DIR,fileName);
////		if(windows) {
//			String USER_HOME=System.getProperty("user.home");
//			//File desktop=new File(USER_HOME,"desktop");
//			File desktop=new File(USER_HOME,"Desktop"); //  ~/Desktop;
//			BATCH_FILE=new File(desktop,fileName);
////		}
//		if(DEBUG) System.out.println("BATCH_FILE="+BATCH_FILE);
//		String msg="Do you want\n   '"+fileName+"'\nplaced on your desktop ?";
//		int res=optionDialog(msg,"Question",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, "Yes", "No");
//		if(res==0) try {
//			if(console!=null) console.write("Write: "+BATCH_FILE+'\n');
//			try { BATCH_FILE.setExecutable(true,false); // Sets everybody's execute permission 
//			} catch(SecurityException e) {}
//			FileOutputStream oupt=new FileOutputStream(BATCH_FILE);
//			Writer writer=new OutputStreamWriter(oupt,Charset.forName("UTF-8"));
//			writer.write(text);
//			writer.flush();
//			writer.close();
//			compilerBatWasWritten=true;
//		} catch(IOException e) { 
//			JOptionPane.showMessageDialog(null, "SORRY: Can't write " + BATCH_FILE, "Error", JOptionPane.ERROR_MESSAGE);
//			e.printStackTrace();
//		}
//	}
	
//	// ***************************************************************
//	// *** writeDesktopLinks
//	// ***************************************************************
//	private static void askWriteDesktopLinks() {
//		boolean windows=(File.separatorChar)=='\\';
//		//if(windows) createSymbolicLink(); // TODO: Test dette med Java 13
//		//createHardLink();
//		if(!windows) askWriteDesktopEntry();
//	}
	
//	// ***************************************************************
//	// *** createSymbolicLink  --  Used on Windows
//	// ***************************************************************
//	// Denne må utsettes til Java 13
//	//
//	// See: https://bugs.openjdk.java.net/browse/JDK-8221852
//	// ***************************************************************
//	private static void createSymbolicLink() {
//		//boolean windows=(File.separatorChar)=='\\';
//		String USER_HOME=System.getProperty("user.home");
//		Path simulaLink=Paths.get(USER_HOME,"desktop","Simula.lnk");
//		Path simulaJar=Paths.get(INSTALL_DIR.toString(),"simula.jar");
//		try {
//			if (Files.exists(simulaLink)) Files.delete(simulaLink);
//		    Files.createSymbolicLink(simulaLink, simulaJar);
//			if(console!=null) console.write("SLink: "+simulaLink+" -> "+simulaJar+'\n');
//		} catch (Exception x) {
//			if(DEBUG) x.printStackTrace();
//		}
//	}
	
//	// ***************************************************************
//	// *** createHardLink
//	// ***************************************************************
//	private static void createHardLink() {
//		boolean windows=(File.separatorChar)=='\\';
//		String USER_HOME=System.getProperty("user.home");
//		Path simulaLink=Paths.get(USER_HOME,"desktop","SimulaHard.lnk");
////		Path simulaJar=Paths.get(INSTALL_DIR.toString(),"simula.jar");
//		Path simulaJar=Paths.get(INSTALL_DIR.toString(),"RunSimulaEditor.bat");
//		try {
//			if (Files.exists(simulaLink)) Files.delete(simulaLink);
//		    Files.createLink(simulaLink, simulaJar);
//			boolean executable=new File(simulaLink.toString()).setExecutable(true,false); // Sets everybody's execute permission 
//			if(console!=null) console.write("HLink: "+simulaLink+" -> "+simulaJar+'\n');
//		} catch (IOException x) {
//			x.printStackTrace();
//		    System.err.println(x);
//		} catch (UnsupportedOperationException x) {
//		    // Some file systems do not
//		    // support adding an existing
//		    // file to a directory.
//			x.printStackTrace();
//		    System.err.println(x);
//		}
//	}
	
//	// ***************************************************************
//	// *** askWriteDesktopEntry
//	// ***************************************************************
//	// *** See: https://wiki.archlinux.org/index.php/desktop_entries
//	// ***************************************************************
//	private static void askWriteDesktopEntry() {
////		boolean windows=(File.separatorChar)=='\\';
//		String USER_HOME=System.getProperty("user.home");
//		String text;
////		File iconFile=new File(INSTALL_DIR,"icons/sim.png");    // The name of the icon that will be used to display this entry
//		text="[Desktop Entry]\n" + 
//				"Encoding=UTF-8\n" +
//				"Type=Application\n" +     // The type as listed above
//				"Version=1.0\n" +          // The version of the desktop entry specification to which this file complies
//				"Name=Simula\n" +          // The name of the application
//				"Path="+INSTALL_DIR+"\n" + // The path to the folder in which the executable is run
//				"Exec=java -jar simula.jar\n" +     // The executable of the application, possibly with arguments.
////				"Icon="+iconFile+"\n" +     // The name of the icon that will be used to display this entry
//				"Icon=icons/sim.png\n" +    // The name of the icon that will be used to display this entry
//				"Terminal=false\n" +     // Describes whether this application needs to be run in a terminal or not
//				"Categories=Education;Languages;Simula"; // Describes the categories in which this entry should be shown
//		//File apps=new File(USER_HOME,".local/share/applications");
//		File apps=new File(USER_HOME,"Desktop"); //  ~/Desktop;
//		//apps.mkdirs();
//		File file=new File(apps,"Simula.desktop");
//
//		if(DEBUG) System.out.println("fullFilePath="+file);
//		if(DEBUG) System.out.println("------ DESKTOP ENTRY ------\n"+text);
//		String msg="Do you want DesktopEntry\n      'Simula'\nplaced on your desktop ?";
//		int res=optionDialog(msg,"Question",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, "Yes", "No");
//		if(res==0) try {
//			if(console!=null) console.write("Write: "+file+'\n');
////			try { boolean executable=file.setExecutable(true,false); // Sets everybody's execute permission 
////			} catch(SecurityException e) {}
//			FileOutputStream oupt=new FileOutputStream(file);
//			Writer writer=new OutputStreamWriter(oupt,Charset.forName("UTF-8"));
//			writer.write(text);
//			writer.flush();
//			writer.close();
//			desktopEntryWasWritten=true;
//		} catch(IOException e) {
//			JOptionPane.showMessageDialog(null, "SORRY: Can't write " + file, "Error", JOptionPane.ERROR_MESSAGE);
//			e.printStackTrace();
//		}
//
//		// På Unix'type spør først og evt. gjør dette:
//		// sudo mv ~/.local/share/applications/Simula.desktop /usr/share/applications/
//	}
	
	// ***************************************************************
	// *** updateProperties
	// ***************************************************************
	private static void updateProperties() {
		Properties simulaProperties = new Properties();
		File loadPropertiesFrom=null;
		File simulaPropertiesFile=new File(INSTALL_DIR,"simulaProperties.xml");
		if(DEBUG) System.out.println("SimulaExtractor.getSimulaPropertiesFile: simulaPropertiesFile="+simulaPropertiesFile+", exists="+simulaPropertiesFile.exists());
		if(simulaPropertiesFile.exists()) {
			loadPropertiesFrom=simulaPropertiesFile;
		} else {
			// Compatibility: TRY TO READ OLD SIMULA PROPERTY FILE FROM <user.home>/.simula
			String USER_HOME=System.getProperty("user.home");
			loadPropertiesFrom=new File(USER_HOME,".simula/simulaProperties.xml");
		}
		if(loadPropertiesFrom.exists()) {
			if(DEBUG) System.out.println("SimulaCompiler: loadPropertiesFrom="+loadPropertiesFrom);
			if(console!=null) console.write("Read:  "+loadPropertiesFrom+'\n');
			try { simulaProperties.loadFromXML(new FileInputStream(loadPropertiesFrom));
			} catch(Exception e) {} // e.printStackTrace(); }
		}
		simulaProperties.put("simula.setup.dated",setupDated);
		simulaProperties.put("simula.installed",new Date().toString());
		simulaProperties.put("simula.version",simulaReleaseID);
		simulaProperties.put("simula.revision",simulaRevisionID);
		simulaProperties.put("simula.home",INSTALL_DIR.getParentFile().toString());

		if(DEBUG) simulaProperties.list(System.out);
		//if(console!=null) simulaProperties.list(console.getPrintStream());
		OutputStream out=null;
		try {
			try {
				simulaPropertiesFile.setReadable(true,false); // Sets everybody's read permission 
				simulaPropertiesFile.setWritable(true,false); // Sets everybody's write permission 
			} catch(SecurityException e) {}
			out=new FileOutputStream(simulaPropertiesFile);
			simulaProperties.storeToXML(out,"Simula Properties");
			if(console!=null) console.write("Write: "+simulaPropertiesFile+'\n');
		} catch(Exception e) { e.printStackTrace(); }
		finally { if(out!=null) try {out.close(); } catch(IOException e){}   }
	}

	// ***************************************************************
	// *** getJarFileName
	// ***************************************************************
	private String getJarFileName() {
		myClassName = this.getClass().getName().replace('.', '/') + ".class";
		if(DEBUG) System.out.println("SimulaExtractor.getJarFileName: myClassName="+myClassName); // TODO: MYH
		URL urlJar = ClassLoader.getSystemResource(myClassName);
		String urlEncStr = urlJar.toString();
		try {
			// The urlEncStr may contain encodings like "%20" for space,
			// we need to convert it back to regular characters.
			String urlStr = URLDecoder.decode(urlEncStr, "UTF-8");
			int from = "jar:file:".length();
			int to = urlStr.indexOf("!/");
			String jarFileName = urlStr.substring(from, to);
			if(DEBUG) {
				System.out.println("SimulaExtractor.getJarFileName: myClassName=" + myClassName);
				System.out.println("SimulaExtractor.getJarFileName: urlEncStr=" + urlEncStr);
				System.out.println("SimulaExtractor.getJarFileName: urlStr=" + urlStr);
				System.out.println("SimulaExtractor.getJarFileName: jarFileName=" + jarFileName);
			}
			return jarFileName;
		} catch (Exception e) { return(null); }
	}

	// ***************************************************************
	// *** getInstallDir
	// ***************************************************************
	// Get the directory in which to unpack our file
	// @param filename The name of the JAR file from which we are unpacking.
	File getInstallDir(String filename) {
		String installParentDirectory;
		installParentDirectory = System.getProperty("user.home");
		if(DEBUG) System.out.println("SimulaExtractor.getInstallDir: installParentDirectory="+installParentDirectory); // TODO: MYH

		String msg = "You are about to install a new Simula System on your computer.\n"+"This installer will create the directory  '" + simulaInstallSubdirectory + "'\n"
				+ "within the Install Directory you select below:\n ";

		// Create a panel with all of the install options
		Box panel = Box.createVerticalBox();
		// We want everything in this box to be left-justified.
		// It should work for us to call panel.setAlignmentX(0f),
		// but it doesn't. Instead, we use hBox (below) which puts
		// in some "glue" to make things be left-justified.
		JTextArea introLabel = new JTextArea(msg);
		introLabel.setEditable(false);
		introLabel.setBackground(panel.getBackground());
		panel.add(introLabel);

		Box installDirBox = Box.createHorizontalBox();
		installDirBox.add(new JLabel("Install Directory: "));
		installDirField = new JTextField(30);
		installDirField.setText(installParentDirectory); // TODO: MYH
		installDirBox.add(installDirField);
		JButton browseButton = new JButton("Browse...");
		browseButton.addActionListener(new AbstractAction() {
			private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent ev) {
				String newInstallDir = browseForInstallDirectory(installDirField.getText());
				if (newInstallDir != null) {
					installDirField.setText(newInstallDir);
				}
			}
		});
		installDirBox.add(browseButton);
		panel.add(installDirBox);

		// Show the user the query panel so he can select options
		String title = "Installing " + programAndVersion;
//		Object[] options = { "Log", "Install", "Cancel" };
		Object[] options = { "Install", "Cancel" };
        int answer = JOptionPane.showOptionDialog(this, panel, title, JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, simulaIcon, options, options[0]);
//		if (answer == 2) return null; // cancelled
//		if (answer == 0) mainFrame.setVisible(true);
		if (answer != 0) return null; // cancelled
		mainFrame.setVisible(true);


		// Get the values from the dialog box
		String installDirectory = installDirField.getText() + File.separator + simulaInstallSubdirectory;

		INSTALL_DIR = new File(installDirectory);
		if(INSTALL_DIR.exists()) {
			Object[] options2 = { "Exit", "Continue" };
			String msg2 = "It looks like the Simula System is already installed.\n"
					   + "The selected install directory:\n"
					   + "      "+installDirectory+"\n"
					   + "does already exists and may contain important stuff.\n\n"
					   + "Do you want to continue overwriting the files ?\n";
			int result = JOptionPane.showOptionDialog(SimulaExtractor.this, msg2, "Warning",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, simulaIcon, options2, options2[0]);
			if (result != 1) System.exit(-1); // Stop the install
		}
		if (!INSTALL_DIR.exists()) {
			if (!INSTALL_DIR.mkdirs()) {
				msg = "Unable to create directory\n" + installDirectory;
				title = "Error Creating Directory";
				JOptionPane.showMessageDialog(this, msg, title, JOptionPane.ERROR_MESSAGE);
				return null; // TBD - should let user try again
			}
		}
		if(console!=null) console.write("Installing "+programAndVersion+"\n"
		                               +"Simula-Directory:   "+INSTALL_DIR+'\n');
		return(INSTALL_DIR);
	}

	// ***************************************************************
	// *** browseForInstallDirectory
	// ***************************************************************
	// Call this when the user presses the Browse button, then put
	// the result back into the main dialog
	private String browseForInstallDirectory(String defaultInstallDir) {
		JFileChooser fc = new JFileChooser();
		if(DEBUG) System.out.println("SimulaExtractor.browseForInstallDirectory: defaultInstallDir="+defaultInstallDir); // TODO: MYH
		fc.setCurrentDirectory(new File(defaultInstallDir));
		fc.setDialogType(JFileChooser.SAVE_DIALOG);
		fc.setDialogTitle("Select destination directory for extracting Simula");
		fc.setMultiSelectionEnabled(false);
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (fc.showDialog(SimulaExtractor.this, "Select") != JFileChooser.APPROVE_OPTION) {
			return null; // user cancelled
		}
		return fc.getSelectedFile().toString();
	}


	// ***************************************************************
	// *** extract
	// ***************************************************************
	/**
	 * Extract from the specified Zip/Jar-file.
	 * 
	 * @return True if all was OK, false if there was a problem.
	 */
	private boolean extract(String zipfileName) {
		if(DEBUG) System.out.println("Trying to extract file " + zipfileName);
		File currentArchive = new File(zipfileName);
		byte[] buf = new byte[1024];
		ZipFile zf = null;
		FileOutputStream out = null;
		InputStream in = null;
		try {
			zf = new ZipFile(currentArchive);
			File outputDir = getInstallDir(currentArchive.getName());
			if (outputDir == null) {
				try {zf.close();} catch(Exception e){}
				return true; // cancelled
			}
			int size = zf.size();
			nExtractedFiles = 0;
			Enumeration<? extends ZipEntry> entries = zf.entries();

		LOOP:for (int i = 0; i < size; i++) {
				ZipEntry entry = (ZipEntry) entries.nextElement();
				if (entry.isDirectory()) continue LOOP;
				String pathname = entry.getName();
				//if(DEBUG) System.out.println("Found File Entry: " + pathname);
				if( pathname.startsWith("make/setup")) continue LOOP;
				if(	pathname.toUpperCase().equals("META-INF/MANIFEST.MF")) {
					loadManifest(zf,entry);
					continue LOOP;
				}
				if(pathname.endsWith(".gitignore")) continue LOOP;
				if(console!=null) {
					console.write("Extracting: "+entry+'\n');
				}
				in = zf.getInputStream(entry);
				File outFile = new File(outputDir, pathname);
				Date archiveTime = new Date(entry.getTime());
				File parent = new File(outFile.getParent());
				if (parent != null && !parent.exists()) {
					parent.mkdirs();
				}
				out = new FileOutputStream(outFile);
				while (true) {
					int nRead = in.read(buf, 0, buf.length);
					if (nRead <= 0)	break;
					out.write(buf, 0, nRead);
				}
				nExtractedFiles++;
				out.close();
				outFile.setLastModified(archiveTime.getTime());
			}
			zf.close();
			targetDir = outputDir.getPath();
			simulaJarFileName = targetDir + File.separator + "simula.jar";
			String title = "Installed " + programAndVersion;
			String msg = "Extracted " + nExtractedFiles + " file" + ((nExtractedFiles != 1) ? "s" : "")
					   + " from setup.jar\nInto: " + targetDir;
			File jarFile = new File(simulaJarFileName);
//			if (jarFile.exists()) {
//				msg += "\n\n" + "The Simula executable JAR file is installed at\n" + simulaJarFileName;
//				msg +="\n\nDo you want to start it now ?\n\n";
//				Object[] options = { "Start Simula", "Exit" };
//		        int answer = JOptionPane.showOptionDialog(SimulaExtractor.this, msg, title, JOptionPane.DEFAULT_OPTION,
//						JOptionPane.QUESTION_MESSAGE, simulaIcon, options, options[0]);
//				if(DEBUG) System.out.println("SimulaExtractor.extract: answer="+answer); // TODO: MYH
//				if(answer==0) {
//					new Thread() {
//						public void run() {	startJar(simulaJarFileName); }
//					}.start();
//				}
//			} else {
			if (!jarFile.exists()) {
				// The extraction was incomplete
				JOptionPane.showMessageDialog(SimulaExtractor.this, msg, title, JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			if (DEBUG) e.printStackTrace(System.out);
			return false; // got an error
		} finally {
			if (zf != null) { try {	zf.close();	} catch (IOException ioe) {}}
			if (out != null) { try { out.close(); } catch (IOException ioe) {}}
			if (in != null) { try {	in.close();	} catch (IOException ioe) {}}			
		}
		return true; // no errors
	}
	
	// ***************************************************************
	// *** askRunSimula
	// ***************************************************************
	private static void askRunSimula() {
		String title = "Installed " + programAndVersion;
		//String msg="";
		String msg = "Extracted " + nExtractedFiles + " file" + ((nExtractedFiles != 1) ? "s" : "")
				   + " from setup.jar\nInto: " + targetDir;
		msg += "\n\n" + "The Simula executable JAR file is installed at\n" + simulaJarFileName;
		msg +="\n\nDo you want to start it now ?\n\n";
		int answer=optionDialog(msg,title,JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, "Start Simula", "Exit");

		if(DEBUG) System.out.println("SimulaExtractor.extract: answer="+answer); // TODO: MYH
		if(answer==0) {
			new Thread() {
				public void run() {	startJar(simulaJarFileName); }
			}.start();
		}		
	}
	
	// ***************************************************************
	// *** loadManifest
	// ***************************************************************
	private static void loadManifest(ZipFile zipFile,ZipEntry entry) throws IOException  {
		Manifest manifest = new Manifest(zipFile.getInputStream(entry));
		Attributes main=manifest.getMainAttributes();
		if(DEBUG) System.out.println("SimulaExtractor.loadManifest: Main-Class="+main.getValue("Main-Class"));
		simulaRevisionID=main.getValue("Simula-Revision");
		setupDated=main.getValue("Simula-Setup-Dated");
		if(DEBUG) System.out.println("SimulaExtractor.loadManifest: This Simula-Revision: "+simulaRevisionID);
		if(DEBUG) System.out.println("SimulaExtractor.loadManifest: This Simula-Setup-Dated: "+setupDated);
		if(console!=null) {
			console.write("Simula-Release ID:  "+simulaReleaseID+'R'+simulaRevisionID+'\n');
			console.write("Simula-Setup-Dated: "+setupDated+'\n');
		}
	}

	// ***************************************************************
	// *** startJar
	// ***************************************************************
	private static void startJar(String jar) {
		String cmd;
		Runtime rt = Runtime.getRuntime();
		cmd = getJavaProg() + " -jar " + jar;
		try { rt.exec(cmd);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Can't run " + cmd, "Error Running Java", JOptionPane.ERROR_MESSAGE);
		}
		// Don't wait for it to finish, we just quietly exit now
	}

	/** Get the path to the java program. */
	private static String getJavaProg() {
		String sep = File.separator;
		return System.getProperty("java.home") + sep + "bin" + sep + "java";
	}


	private static int optionDialog(final Object msg,final String title,final int optionType,final int messageType,final String... option) {
		Object OptionPaneBackground=UIManager.get("OptionPane.background");
		Object PanelBackground=UIManager.get("Panel.background");
 		UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
		int answer = JOptionPane.showOptionDialog(null,msg,title,optionType,messageType,simulaIcon, option, option[0]);
		//System.out.println("doClose.saveDialog: answer="+answer);
		UIManager.put("OptionPane.background",OptionPaneBackground);
        UIManager.put("Panel.background",PanelBackground);
		return(answer);
	}
	
}