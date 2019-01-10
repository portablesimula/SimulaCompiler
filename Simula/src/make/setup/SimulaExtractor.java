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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Enumeration;
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
	
	// NOTE: When updating release id, change version in Global.simulaReleaseID
	private final String subDirName = "Simula"+File.separatorChar+"Simula-Beta-0.3";
	private final String programAndVersion = "Simula Beta 0.3";
	private final ImageIcon simulaIcon;
	
	private String myClassName;
	private JTextField installDirField;

	public static void main(String[] args) {
		if(DEBUG) System.out.println("SimulaExtractor: user.home="+System.getProperty("user.home"));
		if(DEBUG) System.out.println("SimulaExtractor: user.dir="+System.getProperty("user.dir"));
		setEncoding("UTF-8");
		// List UIManager keys: https://thebadprogrammer.com/swing-uimanager-keys/
		UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("OptionPane.messagebackground", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
		SimulaExtractor simulaExtractor = new SimulaExtractor();
		String jarFileName = simulaExtractor.getJarFileName();
		boolean ok=simulaExtractor.extract(jarFileName);
		System.exit(ok ? 0 : 1);
	}
	
	private static void setEncoding(String encoding) {
        System.setProperty("file.encoding",encoding);
        try { Field cs = Charset.class.getDeclaredField("defaultCharset");
              cs.setAccessible(true); cs.set(null, null);
        } catch(Exception e) {}
    }

	SimulaExtractor() {
		URL url=getClass().getResource("sim.png");
		simulaIcon=(url==null)?null:new ImageIcon(url);
	}

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

//	// True if we are running on Windows
//	private boolean isWindows() {
//		return (File.separatorChar == '\\');
//	}


	// Get the directory in which to unpack our file
	// @param filename The name of the JAR file from which we are unpacking.
	File getInstallDir(String filename) {
		String installParentDirectory;
		installParentDirectory = System.getProperty("user.home");
		if(DEBUG) System.out.println("SimulaExtractor.getInstallDir: installParentDirectory="+installParentDirectory); // TODO: MYH

		String msg = "You are about to install a new Simula System on your computer.\n"+"This installer will create the directory  '" + subDirName + "'\n"
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
		Object[] options = { "Install", "Cancel" };
        int answer = JOptionPane.showOptionDialog(this, panel, title, JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, simulaIcon, options, options[0]);
		if (answer != 0) {
			return null; // cancelled
		}

		// Get the values from the dialog box
		String installDirectory = installDirField.getText() + File.separator + subDirName;

		File installDirFile = new File(installDirectory);
		if(installDirFile.exists()) {
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
		if (!installDirFile.exists()) {
			if (!installDirFile.mkdirs()) {
				msg = "Unable to create directory\n" + installDirectory;
				title = "Error Creating Directory";
				JOptionPane.showMessageDialog(this, msg, title, JOptionPane.ERROR_MESSAGE);
				return null; // TBD - should let user try again
			}
		}
		return installDirFile;
	}

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
			int extracted = 0;
			Enumeration<? extends ZipEntry> entries = zf.entries();

			for (int i = 0; i < size; i++) {
				ZipEntry entry = (ZipEntry) entries.nextElement();
				if (entry.isDirectory()) continue;
				String pathname = entry.getName();
				if( pathname.startsWith("make/setup") ||
					pathname.toUpperCase().equals("META-INF/MANIFEST.MF")) {
					continue;
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
				extracted++;
				out.close();
				outFile.setLastModified(archiveTime.getTime());
			}
			zf.close();
			String targetDir = outputDir.getPath();
			String jarFileName = targetDir + File.separator + "simula.jar";
			String title = "Installed " + programAndVersion;
			String msg = "Extracted " + extracted + " file" + ((extracted != 1) ? "s" : "")
					   + " from setup.jar\nInto: " + targetDir;
			File jarFile = new File(jarFileName);
			if (jarFile.exists()) {
				msg += "\n\n" + "The Simula executable JAR file is installed at\n" + jarFileName;
				msg +="\n\nDo you want to start it now ?\n\n";
				Object[] options = { "Start Simula", "Exit" };
		        int answer = JOptionPane.showOptionDialog(SimulaExtractor.this, msg, title, JOptionPane.DEFAULT_OPTION,
						JOptionPane.QUESTION_MESSAGE, simulaIcon, options, options[0]);
				if(DEBUG) System.out.println("SimulaExtractor.extract: answer="+answer); // TODO: MYH
				if(answer==0) {
					startJar(jarFileName);
//					try {
//						Thread.sleep(5 * 1000); // sleep a few seconds
//						// On Windows, when the installer exits,
//						// the window from which it was invoked
//						// (e.g. DOS window or File Manager)
//						// is raised, hiding the app startup
//						// screen. This is annoying. Keep the
//						// sleep time here low so that on a slow
//						// machine we will be gone before the
//						// app startup screen appears, and
//						// thus we won't have covered it up as
//						// the slow machine plods along.
//					} catch (Exception ex) {}
				}
			} else {
				// The extraction was incomplete
				JOptionPane.showMessageDialog(SimulaExtractor.this, msg, title, JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			if (DEBUG) e.printStackTrace(System.out); else if(DEBUG) if(DEBUG) System.out.println(e);
			if (zf != null) { try {	zf.close();	} catch (IOException ioe) {}}
			if (out != null) { try { out.close(); } catch (IOException ioe) {}}
			if (in != null) { try {	in.close();	} catch (IOException ioe) {}}
			return false; // got an error
		}
		return true; // no errors
	}

	private void startJar(String jar) {
		String cmd;
		Runtime rt = Runtime.getRuntime();
//		if (isWindows())
//			 cmd = "\"" + getJavawProg() + "\" -jar \"" + jar + "\"";
//		else
			cmd = getJavaProg() + " -jar " + jar;
		try { rt.exec(cmd);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, "Can't run " + cmd, "Error Running Java", JOptionPane.ERROR_MESSAGE);
		}
		// Don't wait for it to finish, we just quietly exit now
	}

	/** Get the path to the java program. */
	private String getJavaProg() {
		String sep = File.separator;
		return System.getProperty("java.home") + sep + "bin" + sep + "java";
	}

//	/** Get the path to the javaw program. */
//	private String getJavawProg() {
//		String sep = File.separator;
//		return System.getProperty("java.home") + sep + "bin" + sep + "javaw";
//	}
	
}