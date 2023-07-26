/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler;

import java.io.File;

import simula.compiler.editor.RTOption;
import simula.compiler.editor.SimulaEditor;
import simula.compiler.parsing.SimulaScanner;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Simula Main class.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/Simula.java"><b>Source File</b></a>.

 * @author Øystein Myhre Andersen
 *
 */
public final class Simula {
	private Simula(){}

	private static void help() {
		Util.println(Global.simulaReleaseID+" See: https://github.com/portablesimula");
		Util.println("");
		Util.println("Usage: java -jar simula.jar  [options]  sourceFile ");
		Util.println("");
		Util.println("possible options include:");
		Util.println("  -help                      Print this synopsis of standard options");
		Util.println("  -caseSensitive             Source file is case sensitive.");	
		Util.println("  -noexec                    Don't execute generated .jar file");
		Util.println("  -nowarn                    Generate no warnings");
		Util.println("  -noextension               Disable all language extensions");
		Util.println("                             In other words, follow the Simula Standard literally");
		Util.println("  -sport                     Enable all S-PORT extensions");
		Util.println("  -select characters         First, all selectors are reset.");
		Util.println("                             Then, for each character, the corresponding selector is set");
		Util.println("  -verbose                   Output messages about what the compiler is doing");
		Util.println("  -keepJava <directory>      Specify where to place generated .java files");
		Util.println("                             Default: Temp directory which is deleted upon exit");
		Util.println("  -output <directory>        Specify where to place generated executable .jar file");
		Util.println("                             Default: Same directory as source file");
		Util.println("  -extLib <directory>        Specify where to search for precompiled classes and procedures");
		Util.println("                             If not found, output directory is also searched");
		Util.println("");
		Util.println("sourceFile      Simula Source File");
		System.exit(0);
	}

	/**
	 * Main entry.
	 * @param argv arguments
	 */
	public static void main(String[] argv) {
		String fileName = null;
		Option.verbose=false;
		Option.WARNINGS=true;
		Option.EXTENSIONS=true;
		Global.initSimulaProperties();

		// Parse command line arguments.
		for(int i=0;i<argv.length;i++) {
			String arg=argv[i];
			if (arg.charAt(0) == '-') { // command line option
				if (arg.equalsIgnoreCase("-help")) help();
				else if (arg.equalsIgnoreCase("-caseSensitive")) Option.CaseSensitive=true;
				else if (arg.equalsIgnoreCase("-noexec")) Option.noExecution=true;
				else if (arg.equalsIgnoreCase("-nowarn")) Option.WARNINGS=false;
				else if (arg.equalsIgnoreCase("-noextension")) Option.EXTENSIONS=false;
				else if (arg.equalsIgnoreCase("-sport")) Option.SPORT=true;
				else if (arg.equalsIgnoreCase("-select")) setSelectors(argv[++i]);
				else if (arg.equalsIgnoreCase("-verbose")) Option.verbose=true;
				else if (arg.equalsIgnoreCase("-keepJava")) setKeepJava(argv[++i]);
				else if (arg.equalsIgnoreCase("-output")) setOutputDir(argv[++i]);
				else if (arg.equalsIgnoreCase("-extLib")) Global.extLib=new File(argv[++i]);
				else if (arg.equalsIgnoreCase("-source")) Option.SOURCE_FILE=argv[++i];
				else error("Unknown option "+arg);
			} else if(fileName==null) fileName = arg;
			else error("multiple input files specified");
		}	
	    if(!Option.INLINE_TESTING) Global.simulaRtsLib=new File(Global.simulaHome,"rts");
	    
//	    Util.IERR("");
	    
		if (fileName == null) {
		    // *** STARTING SIMULA EDITOR ***
			Global.sampleSourceDir=new File(Global.simulaHome,"samples");
			RTOption.InitRuntimeOptions();
	    	Option.InitCompilerOptions();
	    	SimulaEditor editor=new SimulaEditor();
	    	editor.setVisible(true);
		} else {
		    // *** STARTING SIMULA COMPILER ***
		    new SimulaCompiler(fileName).doCompile();
		}
	}

	private static void error(final String msg) {
		System.err.println("Simula: " + msg + "\n");
		Util.popUpError(msg);
		help();
	}

    /**
     * Set selectors for conditional compilation.
     * <pre>
     * %SELECT select-character { select-character }
	 * </pre>
	 * 
	 * @param chars select characters
	 */
    public static void setSelectors(String chars) {
    	for(int i=0;i<255;i++) SimulaScanner.selector[i]=false;
    	for(int j=0;j<chars.length();j++) {
    		char c=chars.charAt(j);
    		if(c!=' ' && c!='\n') {
    			//System.out.println("Simula.setSelectors: "+ c + " ON");
    			SimulaScanner.selector[c]=true;
    		}
    	}
    }

	/**
	 * Option: -keepJava <directory> Specify where to place generated .java files
	 */
	private static void setKeepJava(final String dir) {
		Option.keepJava = new File(dir);
		Util.TRACE("KEEP_JAVA: " + Option.keepJava);
	}

	/**
	 * Option: -output <directory> Specify where to place generated executable .jar
	 * file
	 */
	private static void setOutputDir(final String dir) {
		Global.outputDir = new File(dir);
		Util.TRACE("OUTPUT_DIR: " + Global.outputDir);
	}

}
