package simula.compiler.editor;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import simula.compiler.utilities.Option;
import simula.compiler.utilities.RTOption;

public class OptionMenu extends JMenu {
	private static final long serialVersionUID = 1L;

	public OptionMenu() {
		super("Option");

        // ****************************************************************
        // *** optionMenu: Compiler Options
        // ****************************************************************
        JMenuItem option = new JMenu("Compiler Option");
              option.add(Option.checkItem("Verbose"));
              option.add(Option.checkItem("Warnings"));
              option.add(Option.checkItem("TRACING"));
              option.add(Option.checkItem("BREAKING"));
              option.add(Option.checkItem("TRACE_SCAN"));
              option.add(Option.checkItem("TRACE_COMMENTS"));
              option.add(Option.checkItem("TRACE_PARSE"));
              option.add(Option.checkItem("TRACE_ATTRIBUTE_OUTPUT"));
              option.add(Option.checkItem("TRACE_ATTRIBUTE_INPUT"));
              option.add(Option.checkItem("TRACE_CHECKER"));
              option.add(Option.checkItem("TRACE_CHECKER_OUTPUT"));
              option.add(Option.checkItem("TRACE_CODING"));
              option.add(Option.checkItem("TRACE_JAVAC"));
              option.add(Option.checkItem("TRACE_JAVAC_OUTPUT"));
              option.add(Option.checkItem("TRACE_BYTECODE_OUTPUT"));
              option.add(Option.checkItem("TRACE_JARING"));
              option.add(Option.checkItem("standardClass"));
              option.add(Option.checkItem("noExecution"));
              option.add(Option.checkItem("noJavacWarnings"));
        this.add(option);
            
        // ****************************************************************
        // *** optionMenu: Compiler Options
        // ****************************************************************
        JMenuItem rtOption = new JMenu("Runtime Option");
              rtOption.add(RTOption.checkItem("Verbose"));
              rtOption.add(RTOption.checkItem("USE_CONSOLE"));
              rtOption.add(RTOption.checkItem("CODE_STEP_TRACING"));
              rtOption.add(RTOption.checkItem("BLOCK_TRACING"));
              rtOption.add(RTOption.checkItem("GOTO_TRACING"));
              rtOption.add(RTOption.checkItem("THREAD_TRACING"));
              rtOption.add(RTOption.checkItem("THREADSWAP_TRACING"));
              rtOption.add(RTOption.checkItem("QPS_TRACING"));
              rtOption.add(RTOption.checkItem("SML_TRACING"));
        this.add(rtOption);
    }

    public static void InitRuntimeOptions() {
		RTOption.VERBOSE = false;//true;
		RTOption.USE_CONSOLE=true;//false;//true;
		RTOption.CODE_STEP_TRACING = false;// true;
		RTOption.BLOCK_TRACING = false;// true;
		RTOption.GOTO_TRACING = false;// true;
		RTOption.THREAD_TRACING = false;// true;
		RTOption.THREADSWAP_TRACING = false;// true;
		RTOption.QPS_TRACING = false; // true;
		RTOption.SML_TRACING = false; // true;

	}
    
    public static void InitCompilerOptions() {
		Option.verbose = true;
		Option.WARNINGS=true;

		// Overall TRACING Options
		Option.TRACING=false;//true;
		Option.BREAKING=false; //true; 

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

		// Java Compiler and Jar-tool Trace Options
		Option.TRACE_JAVAC=false;//true;
		Option.TRACE_JAVAC_OUTPUT=false;//true;
		Option.TRACE_JARING=false;//true;
	
		Option.standardClass = false;
//		Option.keepJava="C:/WorkSpaces/SimulaCompiler/Simula/src/testing";
//		Option.outputDir="C:/WorkSpaces/SimulaCompiler/Simula/bin/";
		Option.noExecution = false;
		Option.noJavacWarnings = false;
	}

}
