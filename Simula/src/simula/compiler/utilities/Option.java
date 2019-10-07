/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.utilities;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
	public static boolean DEBUGGING=false; // Set by EditorMenues - doDebugAction

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
	 * Used by Java-Coding to save the generated .java files.
	 * <p>
	 * If not set, a temp directory is used/created.
	 */
	public static File keepJava = null;
	
	/**
	 * Don't execute generated .jar file.
	 */
	public static boolean noExecution = false;
	
	/**
	 * Generate no warnings from Java-Compiler.
	 */
	public static boolean noJavacWarnings = false;
    
    public static void InitCompilerOptions() {
		Option.verbose = true;
		Option.WARNINGS=true;

		// Overall TRACING Options
		Option.TRACING=false;//true;
		Option.BREAKING=false; //true; 
		Option.DEBUGGING=false;
		
		// Scanner Trace Options
		Option.TRACE_SCAN=false;//true;
		Option.TRACE_COMMENTS=false;//true;

		// Parser Trace Options
		Option.TRACE_PARSE=false;//true;

		// Checker Trace Options
		Option.TRACE_CHECKER=false;//true;
		Option.TRACE_CHECKER_OUTPUT=false;//true;

		// Coder Trace Options
		Option.TRACE_CODING=false;
	
		Option.noExecution = false;
		Option.noJavacWarnings = false;
	}
	
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
		if(id.equalsIgnoreCase("TRACE_BYTECODE_OUTPUT")) return(TRACE_BYTECODE_OUTPUT); 
		if(id.equalsIgnoreCase("noExecution")) return(noExecution); 
		if(id.equalsIgnoreCase("noJavacWarnings")) return(noJavacWarnings); 
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
		if(id.equalsIgnoreCase("TRACE_BYTECODE_OUTPUT")) TRACE_BYTECODE_OUTPUT=val; 
		if(id.equalsIgnoreCase("noExecution")) noExecution=val; 
		if(id.equalsIgnoreCase("noJavacWarnings")) noJavacWarnings=val; 
	}
    
    public static void selectCompilerOptions() {
    	JPanel panel=new JPanel();
    	panel.setBackground(Color.white);
    	panel.add(checkBox("Verbose"));
        panel.add(checkBox("Warnings"));
        panel.add(checkBox("TRACING"));
        panel.add(checkBox("BREAKING"));
        panel.add(checkBox("TRACE_SCAN"));
        panel.add(checkBox("TRACE_COMMENTS"));
        panel.add(checkBox("TRACE_PARSE"));
        panel.add(checkBox("TRACE_ATTRIBUTE_OUTPUT"));
        panel.add(checkBox("TRACE_ATTRIBUTE_INPUT"));
        panel.add(checkBox("TRACE_CHECKER"));
        panel.add(checkBox("TRACE_CHECKER_OUTPUT"));
        panel.add(checkBox("TRACE_CODING"));
        panel.add(checkBox("TRACE_BYTECODE_OUTPUT"));
        panel.add(checkBox("noExecution"));
        panel.add(checkBox("noJavacWarnings"));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		Util.optionDialog(panel,"Select Compiler Options",JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,"Ok");
    }

	private static JCheckBox checkBox(String id) {
        JCheckBox item = new JCheckBox(id);
    	item.setBackground(Color.white);
        item.setSelected(Option.getOption(id));
        item.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Option.setOption(id,item.isSelected());
		}});
        return(item);
	}

}