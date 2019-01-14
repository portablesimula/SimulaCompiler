/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Vector;

import simula.compiler.JavaModule;
import simula.compiler.declaration.DeclarationScope;
import simula.compiler.editor.ConsolePanel;

/**
 * Global Variables 
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class Global {
	public static final String gitURL="https://github.com/portablesimula";
	
	// NOTE: When updating release id, change version in SimulaExtractor.
    public static final String simulaReleaseID="Simula-Beta-0.3";
    
	public static boolean INCLUDE_RUNTIME_SYSTEM_IN_JAR=true;
	
	public static Vector<JavaModule> javaModules;
	public static Vector<String> externalJarFiles=new Vector<String>();

	public static int sourceLineNumber; //=1;
//	public static String sourceFilePath; 
	public static String sourceFileDir; 
	public static String sourceFileName;
	public static String sourceName;
	public static String simulaRtsLib;      // The simula runtime system  (rts.jar - later)
	public static String outputDir;         // Where to put resulting .jar

	public static String sampleSourceDir;   // Where to find ...put resulting .jar

	public static String tempJavaFileDir;   // Temp dir for .java  files
	public static String tempClassFileDir;  // Temp dir for .class  files
	
//	public static String packetName = "simula.test";
//	public static String packetName = "testing";
	public static String packetName = "simprog"; // NOTE: Must be a single identifier


	public static DeclarationScope currentScope=null; // Current Scope. Maintained during Checking and Coding
	public static boolean duringParsing; // True while Parsing
	  
	public static JavaModule currentJavaModule; // Current Java output Module. Maintained by JavaModule during Java Coding

	public static ConsolePanel console;
	
	public static void initiate()
	{ duringParsing=true;
//		sourceLineNumber=0;
		//console=new Console();
	}

	public static String getTempFileDir(String subDir) {
		String tmp=System.getProperty("java.io.tmpdir");
		// See: https://bugs.java.com/bugdatabase/view_bug.do?bug_id=4391434
		if(!(tmp.endsWith("/") || tmp.endsWith("\\"))) tmp=tmp+'/';
		if(subDir.startsWith("/") || subDir.startsWith("\\")) subDir=subDir.substring(1);
//		Option.outputDir=simtmp+"simula/bin/";
		return(tmp+subDir);
	}
	
    private static File simulaPropertiesFile;
    private static Properties simulaProperties;
	public static String getProperty(String key,String defaultValue) {
		if(simulaProperties==null) loadProperties();
		return(simulaProperties.getProperty(key,defaultValue));
	}
	
	public static void setProperty(String key,String value) {
		if(simulaProperties==null) loadProperties();
		simulaProperties.setProperty(key,value);
		storeProperties();
	}
	
	private static void loadProperties() {
		String USER_HOME=System.getProperty("user.home");
		System.out.println("USER_HOME="+USER_HOME);
		File simulaPropertiesDir=new File(USER_HOME+File.separatorChar+".simula");
		System.out.println("simulaPropertiesDir="+simulaPropertiesDir);
		simulaPropertiesDir.mkdirs();
		simulaPropertiesFile=new File(simulaPropertiesDir,"simulaProperties.prop");
		simulaProperties = new Properties();
		try { simulaProperties.loadFromXML(new FileInputStream(simulaPropertiesFile));
		} catch(Exception e) {} // e.printStackTrace(); }
	}
	
	private static void storeProperties() {
		simulaProperties.list(System.out);
		try { simulaProperties.storeToXML(new FileOutputStream(simulaPropertiesFile),"Simula Properties");
		} catch(Exception e) { e.printStackTrace(); }
	}

}