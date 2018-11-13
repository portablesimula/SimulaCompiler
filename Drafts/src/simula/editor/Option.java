/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.editor;

public final class Option {
	
	public static boolean verbose = false; 
	public static boolean WARNINGS=true;

	// Overall TRACING Options
	public static boolean TRACING=false;//true;//false;//true;
	public static boolean BREAKING=true;//false; //true; 

	// Scanner Trace Options
	public static boolean TRACE_PREPROCESSOR=false;//true;
	public static boolean TRACE_SCAN=false;//true;
	public static boolean TRACE_COMMENTS=false;//true;

	// Parser Trace Options
	public static boolean TRACE_PARSE=false;//true;
	public static boolean TRACE_ATTRIBUTE_OUTPUT=false;//true;
	public static boolean TRACE_ATTRIBUTE_INPUT=false;//true;

	// Checker Trace Options
	public static boolean TRACE_CHECKER=false;//true;
	public static boolean TRACE_CHECKER_OUTPUT=false;//true;

	// Coder Trace Options
	public static boolean TRACE_CODING=false;//true;

	// Java Compiler and Jar-tool Trace Options
	public static boolean TRACE_JAVAC=false;//true;
	public static boolean TRACE_JAVAC_OUTPUT=false;//true;
	public static boolean TRACE_BYTECODE_OUTPUT=false;
	public static boolean TRACE_JARING=false;//true;
	public static boolean INCLUDE_RUNTIME_SYSTEM_IN_JAR=true;//false;//true;

	
	
	/** 
	 * Used to compile 'standard classes' to indicate simplified block structure.
	 * In addition all 'procedures' will be treated as Java Methods.
	 */
	public static boolean standardClass = false;

	
	/**
	 * Used by Java-Coding to save the generated .java files.
	 * <p>
	 * If not set, a temp directory is used/created.
	 */
	public static String keepJava = null;
	
	/**
	 * Used by Java-Coding to save the generated .jar files.
	 * <p>
	 * If not set, .jar files are stored in the same directory as the source file.
	 */
	public static String outputDir = null;
	
	
	/**
	 * Don't execute generated .jar file.
	 */
	public static boolean noexec = false;
	
	/**
	 * Generate no warnings.
	 */
	public static boolean nowarn = false;
	

}