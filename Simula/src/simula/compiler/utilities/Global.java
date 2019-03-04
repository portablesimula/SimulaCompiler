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
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.Properties;
import java.util.Vector;

import javax.swing.ImageIcon;

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
    public static final ImageIcon simulaIcon = new ImageIcon("icons/simula.png");
    public static final ImageIcon simIcon = new ImageIcon("icons/sim2.png");
    public static final ImageIcon sIcon = new ImageIcon("icons/sim.png");
    public static final int MAX_WORKSPACE=10;
    
	public static final boolean INCLUDE_RUNTIME_SYSTEM_IN_JAR=true;
	public static final boolean USE_OpenJDK_ASMTOOLS=false;//true;
	public static final boolean USE_OW2_ASMTOOLS=true;
	public static final boolean USE_QPS_LOOM=false;
	
	public static final boolean MODIFY_CLASS_VERSION=false;
	public static final int major=52;  // .class file format version's Major
	public static final int minor=0;   // .class file format version's Minor
	public static final int classFileVersion=minor<<16 | major;   // .class file format version used by modified .class files

	
	public static Vector<JavaModule> javaModules;
	public static Vector<String> externalJarFiles=new Vector<String>();
	public static Charset CHARSET$=Charset.defaultCharset();

	public static int sourceLineNumber; //=1;
	public static String sourceFileDir; 
	public static String sourceFileName;
	public static String sourceName;
	public static String simulaRtsLib;      // The simula runtime system  (rts.jar - later)
	public static String outputDir;         // Where to put resulting .jar

	public static String sampleSourceDir;   // Where to find ...put resulting .jar
	public static String currentWorkspace;  // Where to find ...put resulting .jar
	public static ArrayDeque<String> workspaces;

	public static String tempJavaFileDir;   // Temp dir for .java  files
	public static String tempClassFileDir;  // Temp dir for .class  files
	
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
		//Util.println("USER_HOME="+USER_HOME);
		File simulaPropertiesDir=new File(USER_HOME+File.separatorChar+".simula");
		//Util.println("simulaPropertiesDir="+simulaPropertiesDir);
		simulaPropertiesDir.mkdirs();
		simulaPropertiesFile=new File(simulaPropertiesDir,"simulaProperties.xml");
		simulaProperties = new Properties();
		try { simulaProperties.loadFromXML(new FileInputStream(simulaPropertiesFile));
		} catch(Exception e) {
			Util.popUpError("Can't load: "+simulaPropertiesFile+"\nGot error: "+e );
			e.printStackTrace();
		}
		String simulaHome=Global.getProperty("simula.home",null);
		if(simulaHome==null) {
			Util.popUpError("It seems that the system is not properly installed"
		         +"\nSimula Property 'simula.home' is not defined"
		         +"\n\nPlease check Simula Property File:\n      "
		         +simulaPropertiesFile+"\n");
		}

	}
	
	private static void storeProperties() {
//		System.out.print("Global.storeProperties: SIMULA ");
//		simulaProperties.list(System.out);
		try { simulaProperties.storeToXML(new FileOutputStream(simulaPropertiesFile),"Simula Properties");
		} catch(Exception e) { e.printStackTrace(); }
	}
	
    public static ArrayDeque<String> loadWorkspaces() {
    	workspaces=new ArrayDeque<String>();
    	for(int i=1;i<=MAX_WORKSPACE;i++) {
    		String ws=getProperty("simula.workspace."+i,null);
    		if(ws!=null) workspaces.add(ws);
    	}
    	if(workspaces.isEmpty()) {
    		//String dir=System.getProperty("user.dir",null);
    		//String dir=getProperty("simula.home",null);
    		String dir=Global.sampleSourceDir;
    		dir=dir.replace('/', File.separatorChar).replace('\\', File.separatorChar);
    		workspaces.add(dir);
    	}
    	return(workspaces);
    }
	
	public static void updateCurrentWorkspace(String currentWorkspace) {
		workspaces.remove(currentWorkspace);
		workspaces.addFirst(currentWorkspace);
		updateWorkspaceList();
	}
	
	public static void updateWorkspaceList() {
    	for(int i=1;i<=MAX_WORKSPACE;i++) {
    		simulaProperties.remove("simula.workspace."+i);
    	}
		int i=1;
		for(String ws:workspaces) {
			simulaProperties.setProperty("simula.workspace."+(i++),ws);
		}
		Global.currentWorkspace=workspaces.getFirst();
		storeProperties();

	}


}