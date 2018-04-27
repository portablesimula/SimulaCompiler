/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * 
 * Creating a New Runnable JAR File
 * 
 * Eclipse Help search 'Runnable JAR':
 * To create a new runnable JAR file in the Eclipse Workbench:
 * <ul>
 * <li>1. From the menu bar's File menu, select Export.
 * <li>2. Expand the Java node and select Runnable JAR file. Click Next.
 * <li>3. In the Opens the Runnable JAR export wizard Runnable JAR File
 *        Specification page, select a 'Java Application' launch configuration to use
 *        to create a runnable JAR.
 * <li>4. In the Export destination field, either type or click Browse to select
 *        a location for the JAR file.
 * <li>5. Select an appropriate library handling strategy.
 * <li>6. Optionally, you can also create an ANT script to quickly regenerate a
 *        previously created runnable JAR file.
 * </ul>
 * 
 * @author Øystein Myhre Andersen
 *
 */
public class Simula {

	static void help() {
		System.out.println(Global.simulaID+" See: https://github.com/portablesimula\n\n");
		System.out.println("SIMULA_HOME="+System.getenv("SIMULA_HOME")+"\n\n");
		System.out.println("JAVA_HOME="+System.getenv("JAVA_HOME")+"\n\n");
		System.out.println("Usage: java Simula [options] sourceFile \n\n"
				+ "possible options include:\n"
				+ "  -help                      Print this synopsis of standard options\n"
				+ "  -noexec                    Don't execute generated .jar file\n"
				+ "  -nowarn                    Generate no warnings\n"
				+ "  -verbose                   Output messages about what the compiler is doing\n"
				+ "  -keepJava <directory>      Specify where to place generated .java files\n"
				+ "                             Default: Temp directory which is deleted upon exit\n"
				+ "  -output <directory>        Specify where to place generated executable .jar file\n"
				+ "                             Default: Same directory as source file\n"
				+ "\nsourceFile      Simula Source File\n");
		System.exit(0);
	}

	public static void main(String[] argv) {
		String fileName = null;
		// Parse command line arguments.
		for(int i=0;i<argv.length;i++) {
			String arg=argv[i];
			if (arg.charAt(0) == '-') { // command line option
				if (arg.equals("-help")) help();
				else if (arg.equals("-noexec")) Option.noexec=true;
				else if (arg.equals("-nowarn")) { Option.nowarn=true; Option.WARNINGS=false; }
				else if (arg.equals("-verbose")) Option.verbose=true;
				else if (arg.equals("-standardClass")) Option.standardClass=true;
				else if (arg.equals("-keepJava")) setKeepJava(argv[++i]);
				else if (arg.equals("-outputJava")) setOutputDir(argv[++i]);
				else error("Unknown option "+arg);
			} else if(fileName==null) fileName = arg;
			else error("multiple input files specified");
		}
//		fileName="C:/GitHub/SimulaCompiler/Simula/src/testing/sim/HelloWord.sim"; // TEMP !!!!!
		if (fileName == null) error("No input files specified");
//		// Set DEBUG OPTIONS
//
//		// Set options and tracing.
//		Option.verbose = true;// false;
//		Option.WARNINGS=true;
//
//		// Overall TRACING Options
//		Option.TRACING=true;//false;//true;
//		Option.BREAKING=true;//false; //true; 
//
//		// Scanner Trace Options
//		Option.TRACE_PREPROCESSOR=false;//true;
//		Option.TRACE_SCAN=false;//true;
//		Option.TRACE_COMMENTS=false;//true;
//
//		// Parser Trace Options
//		Option.TRACE_PARSE=true;//false;//true;
//
//		// Checker Trace Options
//		Option.TRACE_CHECKER=false;//true;
//		Option.TRACE_CHECKER_OUTPUT=false;//true;
//
//		// Coder Trace Options
//		Option.TRACE_CODING=true;
//
//		// Java Compiler and Jar-tool Trace Options
//		Option.TRACE_JAVAC=true;
//		Option.TRACE_JAVAC_OUTPUT=true;
//		Option.TRACE_JARING=true;
		
		Option.INCLUDE_RUNTIME_SYSTEM_IN_JAR=true;//false;
//		Global.simulaRtsLib=System.getenv("SIMULA_HOME")+"/Simula.jar";  // TODO: Later  /RTS.jar
		Global.simulaRtsLib=System.getenv("SIMULA_HOME")+"/rts/";  // TODO: Later  /RTS.jar
	
		// Start compiler ....
		new SimulaCompiler(fileName).doCompile();
	}
	
	private static void error(String msg)
	{ System.err.println("simula: "+msg+"\n");
	  help();
	}
	

    /**
     * Option:  -keepJava <directory> Specify where to place generated .java files
     */
    private static void setKeepJava(String dir)
    { Option.keepJava=dir;
      Util.BREAK("KEEP_JAVA: "+Option.keepJava);
      // TODO: Check dir legal directory name
    }

    /**
     * Option:  -output <directory>        Specify where to place generated executable .jar file
     */
    private static void setOutputDir(String dir)
    { Option.keepJava=dir;
      Util.BREAK("KEEP_JAVA: "+Option.keepJava);
      // TODO: Check dir legal directory name
    }


}
