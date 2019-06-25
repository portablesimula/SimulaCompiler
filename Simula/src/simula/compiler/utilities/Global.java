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

import simula.common.ConsolePanel;
import simula.compiler.JavaModule;
import simula.compiler.declaration.DeclarationScope;

/**
 * Global Variables 
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class Global {
	public static final String gitURL="https://github.com/portablesimula";
	
	// NOTE: When updating release id, change version in SimulaExtractor.
    public static final String simulaReleaseID="Simula-1.0";
//    public static final ImageIcon simulaIcon = new ImageIcon("icons/simula.png");
//    public static final ImageIcon simIcon = new ImageIcon("icons/sim2.png");
//    public static final ImageIcon sIcon = new ImageIcon("icons/sim.png");
    public static ImageIcon simulaIcon;
    public static ImageIcon simIcon;
    public static ImageIcon sIcon;
    public static final int MAX_WORKSPACE=10;
    
	public static final boolean INCLUDE_RUNTIME_SYSTEM_IN_JAR=true;
	public static final boolean USE_JAVA_SYSTEM_COMPILER=true;//false;//true;
	public static final boolean USE_EXACT_MATH=true;//false;//true;
//	public static final boolean USE_NEW_WORKSPACES=true;//false;
	
	public static final boolean MODIFY_CLASS_VERSION=false;
	public static final int major=52;  // .class file format version's Major
	public static final int minor=0;   // .class file format version's Minor
	public static final int classFileVersion=minor<<16 | major;   // .class file format version used by modified .class files

	public static File simulaHome;
	public static String simulaVersion;
	public static Vector<JavaModule> javaModules;
	public static Vector<File> externalJarFiles;
	public static Charset CHARSET$=Charset.defaultCharset();

	public static int sourceLineNumber; //=1;
	public static File sourceFileDir; 
	public static String sourceFileName;
	public static String sourceName;
	public static File simulaRtsLib;      // The simula runtime system

	
    public static File simulaPropertiesFile;
    private static Properties simulaProperties;
	public static File sampleSourceDir;   // Where to find sample simula files
	public static File currentWorkspace;  // Where to find .sim source files
	public static ArrayDeque<File> workspaces;
	public static File outputDir;         // Used by Java-Coding to save the generated .jar files.

	public static File simulaTempDir;     // Temp directory
	public static File tempJavaFileDir;   // Temp sub-dir for .java  files
	public static File tempClassFileDir;  // Temp sub-dir for .class  files
	
	public static String packetName = "simprog"; // NOTE: Must be a single identifier


	public static DeclarationScope currentScope=null; // Current Scope. Maintained during Checking and Coding
	public static boolean duringParsing; // True while Parsing
	  
	public static JavaModule currentJavaModule; // Current Java output Module. Maintained by JavaModule during Java Coding

	public static ConsolePanel console;
	
	public static void initiate() {
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
		
		//TESTING();
	}
	
//	private static void TESTING() {
//		File temp=getTempFileDir("simula/temp");
//		isFileWriteable(temp);
//		File tempFile=new File(temp,"tempfile");
//		try { tempFile.createNewFile();	} catch (IOException e) { e.printStackTrace(); }
//		isFileWriteable(tempFile);
//	}
//	
//	private static boolean isFileWriteable(File file) {
//		try {
//			System.out.println("SimulaCompiler.isFileWriteable: " + file + " ==> exists="+(file.exists()?"TRUE":"FALSE"));
//			System.out.println("SimulaCompiler.isFileWriteable: " + file + " ==> isDirectory="+(file.isDirectory()?"TRUE":"FALSE"));
//			System.out.println("SimulaCompiler.isFileWriteable: " + file + " ==> canRead="+(file.canRead()?"TRUE":"FALSE"));
//			System.out.println("SimulaCompiler.isFileWriteable: " + file + " ==> canWrite="+(file.canWrite()?"TRUE":"FALSE"));
//			if (file.canWrite()) {
//				System.out.println("SimulaCompiler.isFileWriteable: " + file + " ==> TRUE");
//				return (true);
//			}
//		} catch (SecurityException e) {
//			e.printStackTrace();
//		}
//		System.out.println("SimulaCompiler.isFileWriteable: " + file + " ==> FALSE");
//		return (false);
//	}

	public static File getTempFileDir(String subDir) {
		String tmp=System.getProperty("java.io.tmpdir");
//		System.out.println("Global.getTempFileDir: subDir="+subDir+", tmp="+tmp);
//		// See: https://bugs.java.com/bugdatabase/view_bug.do?bug_id=4391434
//		if(!(tmp.endsWith("/") || tmp.endsWith("\\"))) tmp=tmp+'/';
//		if(subDir.startsWith("/") || subDir.startsWith("\\")) subDir=subDir.substring(1);
		File tempFileDir=new File(tmp,subDir);
		tempFileDir.mkdirs();
		return(tempFileDir);
	}
	
	public static void trySetOutputDir(File dir) {
		dir.mkdirs();
		if(dir.canWrite()) Global.outputDir=dir;
		else Global.outputDir=getTempFileDir("simulaEditor/bin");
		//System.out.println("Global.trySetOutputDir: dir="+dir+", Global.outputDir="+Global.outputDir);
	}
	
	public static void initProperties() {
		if(simulaProperties==null) loadProperties();
//		if(USE_NEW_WORKSPACES) {
//			Util.BREAK("Global.initProperties: simulaWorkspaces="+simulaWorkspaces);
//			if(simulaWorkspaces==null) loadWorkspaceProperties();			
//		}
	}

	public static String getProperty(String key,String defaultValue) {
		if(simulaProperties==null) loadProperties();
		return(simulaProperties.getProperty(key,defaultValue));
	}
	
//	public static void NOT_USED_setProperty(String key,String value) {
//		if(simulaProperties==null) loadProperties();
//		simulaProperties.setProperty(key,value);
//		storeProperties();
//	}
	
	private static File getSimulaPropertiesFile() {
		File javaClassPath=new File(System.getProperty("java.class.path"));
		if(javaClassPath.exists()) {
			simulaHome=javaClassPath.getParentFile();
			//System.out.println("Global.getSimulaPropertiesFile: simulaHome="+simulaHome);
			simulaPropertiesFile=new File(simulaHome,"simulaProperties.xml");
			//System.out.println("Global.getSimulaPropertiesFile: simulaPropertiesFile="+simulaPropertiesFile+", exists="+simulaPropertiesFile.exists());
			if(simulaPropertiesFile.exists()) return(simulaPropertiesFile);
		}
		Util.popUpError("It seems that the system is not properly installed"
		         +"\nSimula Properties is not defined"
		         +"\n\nPlease check Simula Property File:\n      "
		         +simulaPropertiesFile+"\n");
		
		// Compatibility: TRY TO READ OLD SIMULA PROPERTY FILE FROM <user.home>/.simula
		String USER_HOME=System.getProperty("user.home");
		File simulaPropertiesDir=new File(USER_HOME,".simula");
		simulaPropertiesDir.mkdirs();
		simulaPropertiesFile=new File(simulaPropertiesDir,"simulaProperties.xml");
		//System.out.println("SimulaCompiler: simulaPropertiesFile="+simulaPropertiesFile+", exists="+simulaPropertiesFile.exists());
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
			//Util.INTERNAL_ERROR("Global.loadProperties FAILED: ", e);
		}	
	}
	
//	private static void storeProperties() {
////		System.out.print("Global.storeProperties: SIMULA ");
////		simulaProperties.list(System.out);
//		try { simulaProperties.storeToXML(new FileOutputStream(simulaPropertiesFile),"Simula Properties");
//		} catch(Exception e) { Util.INTERNAL_ERROR("Impossible",e); }
//	}
	
	
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
    	//System.out.println("Global: simulaWorkspacesFile="+simulaWorkspacesFile+", exists="+simulaWorkspacesFile.exists());
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
    	//System.out.println("Global.loadWorkspaceProperties: currentWorkspace="+currentWorkspace);
		//listWorkspaces("loadWorkspaceProperties: LOAD WORKSPACES");
    }
	
	private static void loadWorkspacesFromOldPropertyFile() {
    	//System.out.println("Global.loadWorkspaceProperties: loadWorkspacesFromOldPropertyFile ====== OLD !!!!!!!!!!!!");
		for(int i=1;i<=MAX_WORKSPACE;i++) {
			String ws=getProperty("simula.workspace."+i,null);
			if(ws!=null) {
				if(ws.contains("Simula-Beta-0.3")) ws=ws.replace("Simula-Beta-0.3","Simula-1.0");
				workspaces.add(new File(ws));
			}
		}
	}
	
	public static void setCurrentWorkspace(File workspace) {
		//System.out.println("Global.updateCurrentWorkspace: "+workspace);
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
		//System.out.println("Global.updateWorkspaceList: StoreWorkspaceProperties: SIMULA ");
		//listWorkspaces("storeWorkspaceProperties: STORE WORKSPACES");
		simulaWorkspacesFile.getParentFile().mkdirs();
		try { simulaWorkspaces.storeToXML(new FileOutputStream(simulaWorkspacesFile),"Simula Workspaces");
		} catch(Exception e) { Util.INTERNAL_ERROR("Impossible",e); }
	}
	
//	private static void listWorkspaces(String title) {
//		System.out.println("Global.listWorkspaces: "+title);
//		for(File ws:workspaces)
//			System.out.println("Global.listWorkspaces: "+ws);
//    	System.out.println("Global.listWorkspaces: currentWorkspace="+currentWorkspace);
//	}
	
	
	


}