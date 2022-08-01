/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package make.setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;
import java.util.Properties;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import static java.nio.file.StandardCopyOption.*;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Util;

/**
 * NOTE:
 * <p>
 * <ul>
 * <li> Update Global.simulaReleaseID
 * </li>
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class MakeSetup {
	
//	private final static int EXPLICIT_REVISION = -1; // Normal update
	private final static int EXPLICIT_REVISION = 7;
	
	private final static String GIT_BINARIES="C:\\GitHub\\Binaries";
	private final static String RELEASE_ID=Global.simulaReleaseID; // E.g. "Simula-1.0";

	private final static String RELEASE_HOME=GIT_BINARIES+"\\"+RELEASE_ID;
	private final static String RELEASE_SAMPLES=RELEASE_HOME+"\\samples";

	private final static String GITHUB_ROOT="C:\\GitHub";
	private final static String ECLIPSE_ROOT="C:\\GitHub\\SimulaCompiler\\Simula";
	private final static String COMPILER_BIN=ECLIPSE_ROOT+"\\bin";
	private final static String INSTALLER_BIN=ECLIPSE_ROOT+"\\bin";

	public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
		printHeading("Make Simula Compiler, GIT_BINARIES="+GIT_BINARIES);
		try {
//			printSystemProperties();
			updateSetupProperties();

			makeSimulaCompiler();
			copySimulaRuntimeSystem();
			copySimulaIconFiles();
//			dummyExecuteSimulaCompiler();
			copySimulaReleaseTestBats();
//			compileAndExecuteSimulaPrograms();
			copySimulaReleaseTests();
			makeSimulaInstaller();
//			executeSimulaCompilerEditor();
			executeSimulaSetup();
			} catch(Exception e) { e.printStackTrace(); }
	}
	
	// ***************************************************************
	// *** MAKE SIMULA COMPILER JAR
	// ***************************************************************
	private static void makeSimulaCompiler() throws IOException	{
		printHeading("Make Simula Compiler.jar in "+RELEASE_HOME);
		deleteFiles(RELEASE_HOME);
		list(RELEASE_HOME);
		File releaseHome=new File(RELEASE_HOME);
		releaseHome.mkdirs();
		String compilerManifest=ECLIPSE_ROOT+"\\src\\make\\setup\\CompilerManifest.MF";
//		execute("jar cmf "+compilerManifest+" "+RELEASE_HOME+"\\simula.jar -C "+COMPILER_BIN+" ./simula/common -C "+COMPILER_BIN+" ./simula/compiler -C "+COMPILER_BIN+" ./org/objectweb/asm");
		execute("jar","cmf",compilerManifest,RELEASE_HOME+"\\simula.jar",
//				"-C",COMPILER_BIN,"./simula/common",
				"-C", COMPILER_BIN, "./simula/compiler",
				"-C", COMPILER_BIN, "./org/objectweb/asm");
//		execute("jar -tvf "+RELEASE_HOME+"\\simula.jar");
		execute("jar", "-tvf", RELEASE_HOME+"\\simula.jar");
	}
	
	// ***************************************************************
	// *** COPY SIMULA RUNTIME SYSTEM
	// ***************************************************************
	private static void copySimulaRuntimeSystem() throws IOException {
		File source=new File(COMPILER_BIN+"\\simula\\runtime");
		String target=RELEASE_HOME+"\\rts\\simula\\runtime";
		printHeading("Copy Simula RuntimeSystem "+source+" ===> "+target);
        System.out.println("MakeCompiler.copySimulaRuntimeSystem: target="+target);
		copyFolder(source,new File(target),true);
		list(source);
	}
	
	// ***************************************************************
	// *** COPY SIMULA ICON FILES
	// ***************************************************************
	private static void copySimulaIconFiles() throws IOException	{
		printHeading("Copy Simula Icons .png's into "+RELEASE_HOME);
		copyImageFile("sim.png");
		copyImageFile("sim2.png");
		copyImageFile("simula.png");
	}
	private static void copyImageFile(String fileName) throws IOException	{
		File source=new File(ECLIPSE_ROOT+"\\src\\icons\\"+fileName);
		File target=new File(RELEASE_HOME+"\\icons\\"+fileName);
		target.mkdirs();
		System.out.println("source="+source);
		System.out.println("target="+target);
		Files.copy(source.toPath(), target.toPath(), REPLACE_EXISTING);
	}
	
	// ***************************************************************
	// *** COPY SIMULA RELEASE TEST BATCH FILES
	// ***************************************************************
	private static void copySimulaReleaseTestBats() throws IOException	{
		printHeading("Copy Simula Release Info into "+RELEASE_HOME);
		copyTxtFile("ReleaseNotes.txt");
		copyTxtFile("Issues.txt");
	}
	private static void copyTxtFile(String batName) throws IOException	{
		File source=new File(ECLIPSE_ROOT+"\\src\\make\\setup\\"+batName);
		File target=new File(RELEASE_HOME+"\\"+batName);
		target.mkdirs();
		System.out.println("source="+source);
		System.out.println("target="+target);
		Files.copy(source.toPath(), target.toPath(), REPLACE_EXISTING);
	}
	
	// ***************************************************************
	// *** COPY SIMULA RELEASE TEST PROGRAMS
	// ***************************************************************
	private static void copySimulaReleaseTests() throws IOException	{
		printHeading("Copy Simula TestPrograms into "+RELEASE_SAMPLES);
		deleteFiles(RELEASE_SAMPLES);
//		execute("Robocopy "+ECLIPSE_ROOT+"\\src\\simulaTestPrograms\\samples "+RELEASE_SAMPLES+" /E");
		copyFolder(new File(ECLIPSE_ROOT+"\\src\\simulaTestPrograms\\samples"), new File(RELEASE_SAMPLES), false);
		copyFolder(new File(ECLIPSE_ROOT+"\\src\\simulaTestPrograms\\samples\\data"), new File(RELEASE_SAMPLES+"\\data"), false);
	}
	
	// ***************************************************************
	// *** DELETE FILES
	// ***************************************************************
	private static void deleteFiles(final String dirName) {
		try { File tmpClass = new File(dirName);
			  File[] elt = tmpClass.listFiles();
			  if(elt==null) return; 
			  for (File f : elt) {
				  if(f.isDirectory()) deleteFiles(f.getPath());
				  f.delete();
			  }
		} catch (Exception e) { e.printStackTrace(); }
	}

	// ***************************************************************
	// *** COPY FOLDER
	// ***************************************************************
	static private void copyFolder(File source, File target,boolean copySubFolders) throws IOException {
		target.mkdirs();
	    for(File file: source.listFiles()) {
	        File fileDest = new File(target, file.getName());
	        //System.out.println(fileDest.getAbsolutePath());
	        if(file.isDirectory()) {
	            if(copySubFolders) copyFolder(file, fileDest, copySubFolders);
	        } else {
	            //if(fileDest.exists()) continue;
	        	Files.copy(file.toPath(), fileDest.toPath());
	        }
	    }
	}	
	// ***************************************************************
	// *** LIST FILES
	// ***************************************************************
	private static void list(final String dirName) { list(new File(dirName)); }
	private static void list(final File dir) {
		try { Util.message("------------  LIST "+dir+"  ------------");
			  list("",dir);
		} catch (Exception e) { e.printStackTrace(); }
	}
	
	private static void list(String indent,final File dir) {
		try {
			//Util.println("tmpClass: "+dir);
			File[] elt = dir.listFiles();
			if(elt==null || elt.length==0) {
				Util.println("Empty Directory: "+dir);
				return; 
			}
			Util.println("Elements: "+elt.length);
			for (File f : elt) {
				Util.println(indent+"- "+getModifiedTime(f)+"  "+f);
				if(f.isDirectory()) list(indent+"   ",f);
			}
		} catch (Exception e) { e.printStackTrace(); }
	}

	private static String getModifiedTime(File file) {
		try { Path path = Paths.get(file.toString());
			  BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
			  return(attr.lastModifiedTime().toString().substring(0,19).replace('T',' '));
		} catch (IOException e) { e.printStackTrace(); }
		return(null);
	}
	
//	// ***************************************************************
//	// *** DUMMY EXECUTE SIMULA COMPILER JAR
//	// ***************************************************************
//	private static void dummyExecuteSimulaCompiler() throws IOException	{
//		printHeading("Dummy Execute SimulaCompiler: "+RELEASE_HOME+"\\simula.jar");
//		execute("java -jar "+RELEASE_HOME+"\\simula.jar");
//	}
	
//	// ***************************************************************
//	// *** EXECUTE SIMULA COMPILER EDITOR
//	// ***************************************************************
//	private static void executeSimulaCompilerEditor() throws IOException	{
//		printHeading("Execute SimulaCompilerEditor: "+RELEASE_HOME+"\\simula.jar");
//		execute("java -jar "+RELEASE_HOME+"\\simula.jar");
//	}
	
	// ***************************************************************
	// *** COMPILE AND EXECUTE SIMULA PROGRAMS
	// ***************************************************************
//	private static void compileAndExecuteSimulaPrograms() throws IOException {
//		printHeading("Compile and Execute TestPrograms from "+RELEASE_SAMPLES);
//		compileAndExecuteSimulaProgram(RELEASE_SAMPLES+"\\HelloWord.sim");
//		compileAndExecuteSimulaProgram(RELEASE_SAMPLES+"\\JensensDevice.sim");
//		compileAndExecuteSimulaProgram(RELEASE_SAMPLES+"\\FittingRoom.sim");
//		compileAndExecuteSimulaProgram(RELEASE_SAMPLES+"\\Docking.sim");
//	}
//	private static void compileAndExecuteSimulaProgram(String source) throws IOException {
//		execute("java -jar "+RELEASE_HOME+"\\simula.jar "+source);
//	}
	
	// ***************************************************************
	// *** MAKE SIMULA INSTALLER JAR
	// ***************************************************************
	private static void makeSimulaInstaller() throws IOException	{
		printHeading("Make Simula Setup.jar in "+GIT_BINARIES);
		File releaseHome=new File(RELEASE_HOME);
		releaseHome.mkdirs();
		String SETUP_SRC=ECLIPSE_ROOT+"\\src\\make\\setup";
		// CopySimulaIcon  --> INSTALLER_BIN;
		File source=new File(SETUP_SRC+"\\sim.png");
		File target=new File(INSTALLER_BIN+"\\make\\setup\\sim.png");
		System.out.println("source="+source);
		System.out.println("target="+target);
		Files.copy(source.toPath(), target.toPath(), REPLACE_EXISTING);
			
		String installerManifest=SETUP_SRC+"\\InstallerManifest.MF";
		
//		String files=" -C "+RELEASE_HOME+"."  // Complete Simula Release
//				    +" -C "+INSTALLER_BIN+" ./make/setup";
//		System.out.println("jar cmf "+installerManifest+" "+GIT_BINARIES+"\\setup.jar"+files);
		
		execute("jar", "cmf", installerManifest, GIT_BINARIES+"\\setup.jar",
				"-C",RELEASE_HOME, ".",  // Complete Simula Release
			    "-C",INSTALLER_BIN, "./make/setup");
		printHeading("BEGIN -- List Simula Setup.jar in "+GIT_BINARIES);
//		execute("jar -tvf "+GIT_BINARIES+"\\setup.jar");
		execute("jar","-tvf",GIT_BINARIES+"\\setup.jar");
		printHeading("END -- List Simula Setup.jar in "+GIT_BINARIES);
		copySetupJAR();
	}
	
	// ***************************************************************
	// *** COPY SIMULA INSTALLER JAR
	// ***************************************************************
	private static void copySetupJAR() throws IOException	{
		File source=new File(GIT_BINARIES+"\\setup.jar");
		File target=new File(GITHUB_ROOT+"\\github.io\\setup2\\setup.jar");
		System.out.println("source="+source);
		System.out.println("target="+target);
		Files.copy(source.toPath(), target.toPath(), REPLACE_EXISTING);
		//updateSetupProperties();
	}
	
	// ***************************************************************
	// *** EXECUTE SIMULA SETUP
	// ***************************************************************
	private static void executeSimulaSetup() throws IOException	{
		String SETUP_JAR=GITHUB_ROOT+"\\github.io\\setup2\\setup.jar";
		printHeading("Execute SimulaSetup: "+SETUP_JAR);
//		execute("java -jar "+SETUP_JAR);
		execute("java","-jar",SETUP_JAR);
	}
	
	// ***************************************************************
	// *** EXECUTE OS COMMAND
	// ***************************************************************
	private static int execute(String... cmd) throws IOException {
		Runtime runtime = Runtime.getRuntime();
		String line="";
		for(int i=0;i<cmd.length;i++) line=line+" "+cmd[i];
        System.out.println("MakeCompiler.execute: command="+line);
//	    String cmd=command.trim()+'\n';
		Process process = runtime.exec(cmd);
		//try
		{ InputStream err=process.getErrorStream();
		  InputStream inp=process.getInputStream();
		  while(process.isAlive())
		  { while(err.available()>0) System.err.append((char)err.read());
		    while(inp.available()>0) System.out.append((char)inp.read());
			
		  }
		  // process.waitFor();
		} //catch(InterruptedException e) { e.printStackTrace(); }
		return(process.exitValue());
	}

	private static void printHeading(String heading) {
		System.out.println("************************************************************************************************************************************");
		System.out.println("*** "+heading);
		System.out.println("************************************************************************************************************************************");
	}
	
	
	// ***************************************************************
	// *** UPDATE SETUP PROPERTIES
	// ***************************************************************
	@SuppressWarnings("unused")
	private static void updateSetupProperties() {
		String prevRevision=getProperty("simula.revision",null);
		int revision=0;
		if(prevRevision!=null) {
			if(EXPLICIT_REVISION > 0) revision=EXPLICIT_REVISION;
			else revision=Integer.parseUnsignedInt(prevRevision)+1;
		}
		//revision=xx; // TODO: Ad'Hoc
		String setupDated=""+new Date();
		setProperty("simula.setup.dated",setupDated);
		setProperty("simula.version",""+Global.simulaReleaseID);
		setProperty("simula.revision",""+revision);
		try { // also update 'Simula-Revision' and 'Simula-Setup-Dated' in InstallerManifest.MF
		   String SETUP_SRC=ECLIPSE_ROOT+"\\src\\make\\setup";
		   File installerManifestFile=new File(SETUP_SRC+"\\InstallerManifest.MF");
		   System.out.println("installerManifestFile: "+installerManifestFile);
		   Manifest manifest=new Manifest();
		   InputStream inputStream=new FileInputStream(installerManifestFile);
		   manifest.read(inputStream);
		   Attributes main=manifest.getMainAttributes();
		   System.out.println("Main-Class: "+main.getValue("Main-Class"));
		   System.out.println("Simula-Revision: "+main.getValue("Simula-Revision"));
		   main.putValue("Simula-Revision",""+revision);
		   main.putValue("Simula-Setup-Dated",""+setupDated);
		   System.out.println("Simula-Revision: "+main.getValue("Simula-Revision"));
		   System.out.println("Simula-Setup-Dated: "+main.getValue("Simula-Setup-Dated"));
		   OutputStream outputStream=new FileOutputStream(installerManifestFile);
		   manifest.write(outputStream);
		} catch(Exception e) { e.printStackTrace(); }
	}
    private static File setupPropertiesFile;
    private static Properties setupProperties;
	public static String getProperty(String key,String defaultValue) {
		if(setupPropertiesFile==null) loadProperties();
		return(setupProperties.getProperty(key,defaultValue));
	}
	
	public static void setProperty(String key,String value) {
		if(setupPropertiesFile==null) loadProperties();
		setupProperties.setProperty(key,value);
		storeProperties();
	}
	
	private static void loadProperties() {
		String USER_HOME=System.getProperty("user.home");
		System.out.println("USER_HOME="+USER_HOME);
//		File setupPropertiesDir=new File(USER_HOME+File.separatorChar+".simula");
		File setupPropertiesDir=new File(GITHUB_ROOT+"\\github.io\\setup2");
		System.out.println("setupPropertiesDir="+setupPropertiesDir);
		setupPropertiesDir.mkdirs();
		setupPropertiesFile=new File(setupPropertiesDir,"setupProperties.xml");
		setupProperties = new Properties();
		try { setupProperties.loadFromXML(new FileInputStream(setupPropertiesFile));
		} catch(Exception e) {} // e.printStackTrace(); }
	}
	
	private static void storeProperties() {
		setupProperties.list(System.out);
		try { setupProperties.storeToXML(new FileOutputStream(setupPropertiesFile),"Setup Properties");
		} catch(Exception e) { e.printStackTrace(); }
	}
	
//	private static void printSystemProperties() {
//		printHeading("Jave System Properties");
//		Properties prop = System.getProperties();
//		Set<Object> keySet = prop.keySet();
//		for (Object obj : keySet) {
//			System.out.println("System Property: {" 
//					+ obj.toString() + " = " 
//					+ System.getProperty(obj.toString()) + "}");
//		}
//	}

}
