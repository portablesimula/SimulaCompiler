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
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;
import java.util.Vector;

import javax.swing.ImageIcon;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.byteCodeEngineering.JavaClassInfo;
import simula.compiler.declaration.DeclarationScope;
import simula.compiler.editor.RTOption;

/**
 * Global Variables 
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class Global {
	public static final String gitURL="https://github.com/portablesimula";
	
	// NOTE: When updating release id, change version in SimulaExtractor and RuntimeSystem
    public static final String simulaReleaseID="Simula-2.0";
    public static ImageIcon simulaIcon;
    public static ImageIcon simIcon;
    public static ImageIcon sIcon;
    public static final int MAX_WORKSPACE=10;
    
	public static final boolean INCLUDE_RUNTIME_SYSTEM_IN_JAR=true;
	public static final boolean USE_JAVA_SYSTEM_COMPILER=true;//false;//true;
	public static final boolean USE_EXACT_MATH=true;//false;//true;
	
//	public static final boolean MODIFY_CLASS_VERSION=false;
//	public static final int major=52;  // .class file format version's Major
//	public static final int minor=0;   // .class file format version's Minor
//	public static final int classFileVersion=minor<<16 | major;   // .class file format version used by modified .class files

	public static File simulaHome;
	public static String simulaVersion;
	public static Vector<File> externalJarFiles;
	public static Charset CHARSET$=Charset.defaultCharset();

	public static int sourceLineNumber; //=1;
	public static File sourceFileDir; 
	public static String sourceFileName;
	public static String sourceName;
	public static String insertName;
	public static File simulaRtsLib;      // The simula runtime system

	
    public static File simulaPropertiesFile;
    private static Properties simulaProperties;
	public static File sampleSourceDir;   // Where to find sample simula files
	public static File currentWorkspace;  // Where to find .sim source files
	public static ArrayDeque<File> workspaces;
	public static File outputDir;         // Used by Java-Coding to save the generated .jar files.
	public static Map<String,Type> typeMap;

	public static boolean duringParsing;  // True while Parsing

	public static File simulaTempDir;     // Temp directory
	public static File tempJavaFileDir;   // Temp sub-dir for .java  files
	public static File tempClassFileDir;  // Temp sub-dir for .class  files
	
	public static String packetName = "simprog"; // NOTE: Must be a single identifier
	public static GeneratedJavaClass currentJavaModule; // Current Java output Module. Maintained by JavaModule during Java Coding	
	public static Hashtable<String,JavaClassInfo> javaClassMap; // SKAL MERGE'ES MED DEN NEDENFOR ?????
	public static Vector<GeneratedJavaClass> generatedJavaClass;	  

	public static ConsolePanel console;
	
	public static void initiate() {
		typeMap=new HashMap<String,Type>();
		javaClassMap=new Hashtable<String,JavaClassInfo>();
		duringParsing=true;
		externalJarFiles=new Vector<File>();
		String SIMULA_HOME=getProperty("simula.home",null);
		if(SIMULA_HOME!=null) {
			String SIMULA_VERSION=getProperty("simula.version",null);
			if(SIMULA_VERSION!=null) {
				File simdir=new File(SIMULA_HOME,SIMULA_VERSION);
				simulaIcon = new ImageIcon(new File(simdir,"icons/simula.png").toString());
				simIcon = new ImageIcon(new File(simdir,"icons/sim2.png").toString());
				sIcon = new ImageIcon(new File(simdir,"icons/sim.png").toString());
			}
		}
	}
	
	private static Stack<DeclarationScope> scopeStack=new Stack<DeclarationScope>();
	private static DeclarationScope currentScope=null; // Current Scope. Maintained during Checking and Coding
	public static DeclarationScope getCurrentScope() { return(currentScope); }
	public static void setScope(DeclarationScope scope) { currentScope=scope; } // During Parsing
	public static String edScopeChain() { return(getCurrentScope().edScopeChain()); }
	
	public static void enterScope(DeclarationScope scope) {
		scopeStack.push(currentScope); currentScope=scope;
	}
	
	public static void exitScope() {
		currentScope=scopeStack.pop();
	}


	public static File getTempFileDir(String subDir) {
		String tmp=System.getProperty("java.io.tmpdir");
		File tempFileDir=new File(tmp,subDir);
		tempFileDir.mkdirs();
		setAccessRWX(tempFileDir);
		return(tempFileDir);
	}
	
	public static void setAccessRWX(File dir) {
		dir.setReadable(true,false);   // Readable for all users
		dir.setWritable(true,false);   // Writable for all users
		dir.setExecutable(true,false); // Executable for all users
	}
	
	public static void trySetOutputDir(File dir) {
		dir.mkdirs();
		if(dir.canWrite()) Global.outputDir=dir;
		else {
			Global.outputDir=getTempFileDir("simulaEditor/bin");
		}
	}
	
	public static void initProperties() {
		if(simulaProperties==null) loadProperties();
	}

	public static String getProperty(String key,String defaultValue) {
		if(simulaProperties==null) loadProperties();
		return(simulaProperties.getProperty(key,defaultValue));
	}
	
	private static File getSimulaPropertiesFile() {
		File javaClassPath=new File(System.getProperty("java.class.path"));
		if(Option.INLINE_TESTING) {
			if(RTOption.USE_VIRTUAL_THREAD) System.out.print("USE_VIRTUAL_THREAD, ");
			System.out.println("INLINE_TESTING");
		}
		if(javaClassPath.exists()) {
			simulaHome=javaClassPath.getParentFile();
			simulaPropertiesFile=new File(simulaHome,"simulaProperties.xml");
			if(simulaPropertiesFile.exists()) return(simulaPropertiesFile);
		}
		
		if(!Option.INLINE_TESTING)
		Util.popUpError("It seems that the system is not properly installed"
		         +"\nSimula Properties is not defined"
		         +"\n\nPlease check Simula Property File:\n      "
		         +simulaPropertiesFile+"\n");
		
		// Compatibility: TRY TO READ OLD SIMULA PROPERTY FILE FROM <user.home>/.simula
		// Compatibility: TRY TO READ OLD SIMULA PROPERTY FILE FROM <user.home>/simula/simula-2.0
		String USER_HOME=System.getProperty("user.home");
		File simulaPropertiesDir=new File(USER_HOME,"simula/simula-2.0");
		System.out.println("Global.getSimulaPropertiesFile: simulaPropertiesDir="+simulaPropertiesDir);
		simulaPropertiesDir.mkdirs();
		simulaPropertiesFile=new File(simulaPropertiesDir,"simulaProperties.xml");
		if(!simulaPropertiesFile.exists()) {
			Util.popUpError("It seems that the system is not properly installed"
			         +"\n\nTrying to use 'old' Simula Property File:\n"
			         +simulaPropertiesFile+"\n"
					 +"But could not find it either\n"
			         +"\nHint: Try to Download Simula again.\n");
		}
		return(simulaPropertiesFile);
	}
	
	private static void loadProperties() {
		simulaPropertiesFile=getSimulaPropertiesFile();
		simulaProperties = new Properties();
		try { simulaProperties.loadFromXML(new FileInputStream(simulaPropertiesFile));
		} catch(Exception e) {
			Util.popUpError("Can't load: "+simulaPropertiesFile+"\nGot error: "+e );
		}	
	}
	
	
	// **********************************************************
	// *** WORKSPACES
	// **********************************************************
    public static File simulaWorkspacesFile;
    private static Properties simulaWorkspaces;
	
	
    public static void loadWorkspaceProperties() {
    	simulaWorkspaces = new Properties();
    	String USER_HOME=System.getProperty("user.home");
    	File simulaPropertiesDir=new File(USER_HOME,".simula");
    	simulaWorkspacesFile=new File(simulaPropertiesDir,"workspaces.xml");
    	workspaces=new ArrayDeque<File>();
    	if(simulaWorkspacesFile.exists()) {
    		try {
    			simulaWorkspaces.loadFromXML(new FileInputStream(simulaWorkspacesFile));
    			for(int i=1;i<=MAX_WORKSPACE;i++) {
    				String ws=simulaWorkspaces.getProperty("simula.workspace."+i,null);
    				if(ws!=null) {
    					if(ws.contains("Simula-Beta-0.3")) ws=ws.replace("Simula-Beta-0.3","Simula-1.0");
    					//System.out.println("Global.loadWorkspaceProperties: ADD "+ws);
    					workspaces.add(new File(ws));
    				}
    			}
    		} catch(Exception e) {
    			Util.popUpError("Can't load: "+simulaWorkspacesFile+"\nGot error: "+e );
    			Util.INTERNAL_ERROR("Global.loadWorkspaces FAILED: ", e);
    		}
    	} else {
    		loadWorkspacesFromOldPropertyFile();
    	}
    	if(workspaces.isEmpty()) {
    		workspaces.add(Global.sampleSourceDir);
    	}
    	currentWorkspace=workspaces.getFirst();
    }
	
	private static void loadWorkspacesFromOldPropertyFile() {
		for(int i=1;i<=MAX_WORKSPACE;i++) {
			String ws=getProperty("simula.workspace."+i,null);
			if(ws!=null) {
				if(ws.contains("Simula-Beta-0.3")) ws=ws.replace("Simula-Beta-0.3","Simula-1.0");
				workspaces.add(new File(ws));
			}
		}
	}
	
	public static void setCurrentWorkspace(File workspace) {
		if(!workspace.equals(Global.currentWorkspace)) {
			workspaces.remove(workspace);
			workspaces.addFirst(workspace);
			storeWorkspaceProperties();
		}
	}
	
	public static void storeWorkspaceProperties() {
		simulaWorkspaces = new Properties();
		int i=1;
		for(File ws:workspaces) {
			simulaWorkspaces.setProperty("simula.workspace."+(i++),ws.toString());
		}
		Global.currentWorkspace=workspaces.getFirst();
		simulaWorkspacesFile.getParentFile().mkdirs();
		try { simulaWorkspaces.storeToXML(new FileOutputStream(simulaWorkspacesFile),"Simula Workspaces");
		} catch(Exception e) { Util.INTERNAL_ERROR("Impossible",e); }
	}
	
	
}