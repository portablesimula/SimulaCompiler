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

/**
 * Global Variables 
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class Global {
	public static final String gitURL="https://github.com/portablesimula";
    public static final String simulaID="Simula Beta(0.2)";
	public static final String javaDir="C:/Programfiler/Java/jdk1.8.0_73/bin/";
	
	public static Vector<JavaModule> javaModules;

	public static int sourceLineNumber=1;
//	public static String sourceFilePath; 
	public static String sourceFileDir; 
	public static String sourceName;
	public static String simulaRtsLib;      // The simula runtime system  (rts.jar - later)
	public static String outputDir;   // Where to put resulting .jar

	public static String tempJavaFileDir;   // Temp dir for .java  files
	public static String tempClassFileDir;  // Temp dir for .class  files
	
//	public static String packetName = "simula.test";
	public static String packetName = "testing";
	
	public static boolean OVERLOADING=true; // TODO: Temp implementation of Overloading
	public static boolean ROUNDING=true;//false; // TODO: Temp implementation of real to integer rounding


	public static DeclarationScope currentScope=null; // Current Scope. Maintained during Checking and Coding
	  
	public static JavaModule currentJavaModule; // Current Java output Module. Maintained by JavaModule during Java Coding
	
	public static void initiate()
	{
		sourceLineNumber=1;
	}

	

}