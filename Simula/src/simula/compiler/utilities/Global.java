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
    public static final ImageIcon simulaIcon = new ImageIcon("icons/simula.png");
    public static final ImageIcon simIcon = new ImageIcon("icons/sim2.png");
    public static final ImageIcon sIcon = new ImageIcon("icons/sim.png");
    public static final int MAX_WORKSPACE=10;
    
	public static final boolean INCLUDE_RUNTIME_SYSTEM_IN_JAR=true;
	public static final boolean USE_JAVA_SYSTEM_COMPILER=true;//false;//true;
	public static final boolean USE_EXACT_MATH=true;//false;//true;
	
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
	public static File outputDir;         // Where to put resulting .jar

	public static File sampleSourceDir;   // Where to find sample simula files
	public static File currentWorkspace;  // Where to find ...put resulting .jar
	public static ArrayDeque<File> workspaces;
	public static File[] workspaceList;

	public static File simulaTempDir;     // Temp directory
	public static File tempJavaFileDir;   // Temp sub-dir for .java  files
	public static File tempClassFileDir;  // Temp sub-dir for .class  files
	
	public static String packetName = "simprog"; // NOTE: Must be a single identifier


	public static DeclarationScope currentScope=null; // Current Scope. Maintained during Checking and Coding
	public static boolean duringParsing; // True while Parsing
	  
	public static JavaModule currentJavaModule; // Current Java output Module. Maintained by JavaModule during Java Coding

	public static ConsolePanel console;
	
	public static void initiate()
	{ duringParsing=true;
	  externalJarFiles=new Vector<File>();
	}

	public static File getTempFileDir(String subDir) {
		String tmp=System.getProperty("java.io.tmpdir");
		// See: https://bugs.java.com/bugdatabase/view_bug.do?bug_id=4391434
		if(!(tmp.endsWith("/") || tmp.endsWith("\\"))) tmp=tmp+'/';
		if(subDir.startsWith("/") || subDir.startsWith("\\")) subDir=subDir.substring(1);
		return(new File(tmp,subDir));
	}
	
    public static File simulaPropertiesFile;
    private static Properties simulaProperties;
    
	public static void initProperties() {
		if(simulaProperties==null) loadProperties();
	}

	public static String getProperty(String key,String defaultValue) {
		if(simulaProperties==null) loadProperties();
		return(simulaProperties.getProperty(key,defaultValue));
	}
	
	public static void setProperty(String key,String value) {
		if(simulaProperties==null) loadProperties();
		simulaProperties.setProperty(key,value);
		storeProperties();
	}
	
	private static File getSimulaPropertiesFile() {
		File javaClassPath=new File(System.getProperty("java.class.path"));
		if(javaClassPath.exists()) {
			simulaHome=javaClassPath.getParentFile();
			System.out.println("Global.getSimulaPropertiesFile: simulaHome="+simulaHome);
			simulaPropertiesFile=new File(simulaHome,"simulaProperties.xml");
			System.out.println("Global.getSimulaPropertiesFile: simulaPropertiesFile="+simulaPropertiesFile+", exists="+simulaPropertiesFile.exists());
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
		System.out.println("SimulaCompiler: simulaPropertiesFile="+simulaPropertiesFile+", exists="+simulaPropertiesFile.exists());
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
			Util.INTERNAL_ERROR("Global.loadProperties FAILED: ", e);
		}
	}
	
	private static void storeProperties() {
//		System.out.print("Global.storeProperties: SIMULA ");
//		simulaProperties.list(System.out);
		try { simulaProperties.storeToXML(new FileOutputStream(simulaPropertiesFile),"Simula Properties");
		} catch(Exception e) { Util.INTERNAL_ERROR("Impossible",e); }
	}
	
    public static ArrayDeque<File> loadWorkspaces() {
    	workspaces=new ArrayDeque<File>();
    	for(int i=1;i<=MAX_WORKSPACE;i++) {
    		String ws=getProperty("simula.workspace."+i,null);
    		if(ws!=null) {
    	    	if(ws.contains("Simula-Beta-0.3")) ws=ws.replace("Simula-Beta-0.3","Simula-1.0");
    			workspaces.add(new File(ws));
    		}
    	}
    	if(workspaces.isEmpty()) {
    		String dir=Global.sampleSourceDir.toString();
    		dir=dir.replace('/', File.separatorChar).replace('\\', File.separatorChar);
    		workspaces.add(new File(dir));
    	}
    	return(workspaces);
    }
	
	public static void updateCurrentWorkspace(File currentWorkspace) {
		workspaces.remove(currentWorkspace);
		workspaces.addFirst(currentWorkspace);
		updateWorkspaceList();
	}
	
	public static void updateWorkspaceList() {
    	for(int i=1;i<=MAX_WORKSPACE;i++) {
    		simulaProperties.remove("simula.workspace."+i);
    	}
		int i=1;
		for(File ws:workspaces) {
			simulaProperties.setProperty("simula.workspace."+(i++),ws.toString());
		}
		Global.currentWorkspace=workspaces.getFirst();
		storeProperties();

	}
	public static void NEW_updateWorkspaceList() {
    	for(int i=1;i<=MAX_WORKSPACE;i++) {
    		simulaWorkspaces.remove("simula.workspace."+i);
    	}
		int i=1;
		for(File ws:workspaceList) {
			simulaWorkspaces.setProperty("simula.workspace."+(i++),ws.toString());
		}
		Global.currentWorkspace=workspaceList[0];
		storeProperties();

	}
	
	// *** Workspaces ***
    public static File simulaWorkspacesFile;
    private static Properties simulaWorkspaces;
	
	
    private static void loadWorkspaceProperties() {
    	simulaWorkspaces = new Properties();
    	String USER_HOME=System.getProperty("user.home");
    	File simulaPropertiesDir=new File(USER_HOME,".simula");
    	simulaPropertiesDir.mkdirs();
    	simulaWorkspacesFile=new File(simulaPropertiesDir,"workspaces.xml");
    	System.out.println("SimulaCompiler: simulaWorkspacesFile="+simulaWorkspacesFile+", exists="+simulaWorkspacesFile.exists());
    	if(simulaWorkspacesFile.exists()) {
    		try { simulaWorkspaces.loadFromXML(new FileInputStream(simulaWorkspacesFile));
    		} catch(Exception e) {
    			Util.popUpError("Can't load: "+simulaWorkspacesFile+"\nGot error: "+e );
    			Util.INTERNAL_ERROR("Global.loadWorkspaces FAILED: ", e);
    		}
    	}
    	workspaceList=new File[MAX_WORKSPACE];
    	boolean empty=true;
    	for(int i=1;i<=MAX_WORKSPACE;i++) {
    		String ws=getProperty("simula.workspace."+i,null);
    		if(ws!=null) {
    	    	if(ws.contains("Simula-Beta-0.3")) ws=ws.replace("Simula-Beta-0.3","Simula-1.0");
    			workspaceList[i]=new File(ws);
    			empty=false;
    		}
    	}
    	if(empty) {
    		String dir=Global.sampleSourceDir.toString();
    		dir=dir.replace('/', File.separatorChar).replace('\\', File.separatorChar);
    		workspaces.add(new File(dir));
    	}

    }
	
	private static void storeWorkspaceProperties() {
//		System.out.print("Global.storeWorkspaceProperties: SIMULA ");
//		simulaWorkspaces.list(System.out);
		try { simulaWorkspaces.storeToXML(new FileOutputStream(simulaWorkspacesFile),"Simula Workspaces");
		} catch(Exception e) { Util.INTERNAL_ERROR("Impossible",e); }
	}
	
	


}