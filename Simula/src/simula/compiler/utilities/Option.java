/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;

/**
 * Compile Time Options
 * 
 * @author Øystein
 *
 */
public final class Option {
	
	public static boolean verbose = false; 
	public static boolean WARNINGS=true;

	// Overall TRACING Options
	public static boolean TRACING=false;//true;//false;//true;
	public static boolean BREAKING=true;//false; //true; 

	// Scanner Trace Options
	public static boolean TRACE_SCAN=false;//true;
	public static boolean TRACE_COMMENTS=false;//true;

	// Parser Trace Options
	public static boolean TRACE_PARSE=true;//false;//true;
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
	public static boolean TRACE_JARING=false;//true;
	
	// Byte code engineering Options
	public static boolean TRACE_BYTECODE_OUTPUT=false;
	public static boolean LIST_REPAIRED_INSTRUCTION_LIST=false;
	public static boolean TRACE_REPAIRING=false;


	
	
	/** 
	 * Enables/disables special S-Port Simula features,
	 * such as inclusion of the S-Port Library.
	 */
	public static boolean sport = true;
	
	/** 
	 * Used to compile 'standard classes' to indicate simplified block structure.
	 * In addition all 'procedures' will be treated as Java Methods.
	 */
	public static boolean standardClass = false;

	
	/**
	 * Enables/disables deletion of temporary .java .class and .jasm files.
	 */
	public static boolean deleteTempFiles = true;
	
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
	public static boolean noExecution = false;
	
	/**
	 * Generate no warnings from Java-Compiler.
	 */
	public static boolean noJavacWarnings = false;
	
	public static boolean getOption(String id) {
		if(id.equalsIgnoreCase("VERBOSE")) return(verbose); 
		if(id.equalsIgnoreCase("WARNINGS")) return(WARNINGS); 
		if(id.equalsIgnoreCase("TRACING")) return(TRACING); 
		if(id.equalsIgnoreCase("BREAKING")) return(BREAKING); 
		if(id.equalsIgnoreCase("TRACE_SCAN")) return(TRACE_SCAN); 
		if(id.equalsIgnoreCase("TRACE_COMMENTS")) return(TRACE_COMMENTS); 
		if(id.equalsIgnoreCase("TRACE_PARSE")) return(TRACE_PARSE); 
		if(id.equalsIgnoreCase("TRACE_ATTRIBUTE_OUTPUT")) return(TRACE_ATTRIBUTE_OUTPUT); 
		if(id.equalsIgnoreCase("TRACE_ATTRIBUTE_INPUT")) return(TRACE_ATTRIBUTE_INPUT); 
		if(id.equalsIgnoreCase("TRACE_CHECKER")) return(TRACE_CHECKER); 
		if(id.equalsIgnoreCase("TRACE_CHECKER_OUTPUT")) return(TRACE_CHECKER_OUTPUT); 
		if(id.equalsIgnoreCase("TRACE_CODING")) return(TRACE_CODING); 
		if(id.equalsIgnoreCase("TRACE_JAVAC")) return(TRACE_JAVAC); 
		if(id.equalsIgnoreCase("TRACE_JAVAC_OUTPUT")) return(TRACE_JAVAC_OUTPUT); 
		if(id.equalsIgnoreCase("TRACE_BYTECODE_OUTPUT")) return(TRACE_BYTECODE_OUTPUT); 
		if(id.equalsIgnoreCase("TRACE_JARING")) return(TRACE_JARING); 
		if(id.equalsIgnoreCase("standardClass")) return(standardClass); 
		if(id.equalsIgnoreCase("noExecution")) return(noExecution); 
		if(id.equalsIgnoreCase("noJavacWarnings")) return(noJavacWarnings); 

//		public static boolean INCLUDE_RUNTIME_SYSTEM_IN_JAR=true;//false;//true;
//		public static String keepJava = null;
//		public static String outputDir = null;
		return(false);
	}

	
	public static void setOption(String id,boolean val) {
		if(id.equalsIgnoreCase("VERBOSE")) verbose=val; 
		if(id.equalsIgnoreCase("WARNINGS")) WARNINGS=val; 
		if(id.equalsIgnoreCase("TRACING")) TRACING=val; 
		if(id.equalsIgnoreCase("BREAKING")) BREAKING=val; 
		if(id.equalsIgnoreCase("TRACE_SCAN")) TRACE_SCAN=val; 
		if(id.equalsIgnoreCase("TRACE_COMMENTS")) TRACE_COMMENTS=val; 
		if(id.equalsIgnoreCase("TRACE_PARSE")) TRACE_PARSE=val; 
		if(id.equalsIgnoreCase("TRACE_ATTRIBUTE_OUTPUT")) TRACE_ATTRIBUTE_OUTPUT=val; 
		if(id.equalsIgnoreCase("TRACE_ATTRIBUTE_INPUT")) TRACE_ATTRIBUTE_INPUT=val; 
		if(id.equalsIgnoreCase("TRACE_CHECKER")) TRACE_CHECKER=val; 
		if(id.equalsIgnoreCase("TRACE_CHECKER_OUTPUT")) TRACE_CHECKER_OUTPUT=val; 
		if(id.equalsIgnoreCase("TRACE_CODING")) TRACE_CODING=val; 
		if(id.equalsIgnoreCase("TRACE_JAVAC")) TRACE_JAVAC=val; 
		if(id.equalsIgnoreCase("TRACE_JAVAC_OUTPUT")) TRACE_JAVAC_OUTPUT=val; 
		if(id.equalsIgnoreCase("TRACE_BYTECODE_OUTPUT")) TRACE_BYTECODE_OUTPUT=val; 
		if(id.equalsIgnoreCase("TRACE_JARING")) TRACE_JARING=val; 
		if(id.equalsIgnoreCase("standardClass")) standardClass=val; 
		if(id.equalsIgnoreCase("noExecution")) noExecution=val; 
		if(id.equalsIgnoreCase("noJavacWarnings")) noJavacWarnings=val; 

//		public static boolean INCLUDE_RUNTIME_SYSTEM_IN_JAR=true;//false;//true;
//		public static String keepJava = null;
//		public static String outputDir = null;
	}

	public static JCheckBoxMenuItem checkItem(String id) {
        JCheckBoxMenuItem item = new JCheckBoxMenuItem(id);
        item.setSelected(Option.getOption(id));
        item.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//Util.println(id+"Item.actionPerformed: e="+e);
        		Option.setOption(id,item.isSelected());
        		//Util.println(id+"Item.actionPerformed: Option."+id+"="+Option.getOption(id));            		
		}});
        return(item);
	}

}