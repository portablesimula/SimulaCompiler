/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.utilities;

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
    public static final String simulaReleaseID="Release-Beta-0.3";
    
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

	

}