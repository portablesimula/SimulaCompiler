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
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class Simula {

	private static void help() {
		Util.println(Global.simulaReleaseID+" See: https://github.com/portablesimula\n");
		Util.println("Usage: java -jar simula.jar  [options]  sourceFile \n\n"
				+ "possible options include:\n"
				+ "  -help                      Print this synopsis of standard options\n"
				+ "  -noexec                    Don't execute generated .jar file\n"
				+ "  -nowarn                    Generate no warnings\n"
				+ "  -noextension			    Disable all language extensions\n"
				+ "					            In other words, follow the Simula Standard literally\n"
				+ "  -select characters         First, all selectors are reset."
				+ "                             Then, for each character, the corresponding selector is set\n"
				+ "  -verbose                   Output messages about what the compiler is doing\n"
				+ "  -keepJava <directory>      Specify where to place generated .java files\n"
				+ "                             Default: Temp directory which is deleted upon exit\n"
				+ "  -output <directory>        Specify where to place generated executable .jar file\n"
				+ "                             Default: Same directory as source file\n"
				+ "  -extLib <directory>		Specify where to search for precompiled classes and procedures\n"
				+ "                             If not found, output directory is also searched "
				+ "\nsourceFile      Simula Source File\n");
		System.exit(0);
	}

	public static void main(String[] argv) {
		String fileName = null;
		Option.verbose=false;
		Option.WARNINGS=true;
		Option.EXTENSIONS=true;
		Global.initProperties();

		// Parse command line arguments.
		for(int i=0;i<argv.length;i++) {
			String arg=argv[i];
			if (arg.charAt(0) == '-') { // command line option
				if (arg.equalsIgnoreCase("-help")) help();
				else if (arg.equalsIgnoreCase("-noexec")) Option.noExecution=true;
				else if (arg.equalsIgnoreCase("-nowarn")) { Option.noJavacWarnings=true; Option.WARNINGS=false; }
				else if (arg.equalsIgnoreCase("-noextension")) { Option.EXTENSIONS=false; }
				else if (arg.equalsIgnoreCase("-select")) setSelectors(argv[++i]);
				else if (arg.equalsIgnoreCase("-verbose")) Option.verbose=true;
//				else if (arg.equalsIgnoreCase("-packetName")) Global.packetName=argv[++i];
				else if (arg.equalsIgnoreCase("-keepJava")) setKeepJava(argv[++i]);
				else if (arg.equalsIgnoreCase("-output")) setOutputDir(argv[++i]);
				else if (arg.equalsIgnoreCase("-extLib")) Global.extLib=new File(argv[++i]);
				else if (arg.equalsIgnoreCase("-source")) Option.SOURCE_FILE=argv[++i];
				else error("Unknown option "+arg);
			} else if(fileName==null) fileName = arg;
			else error("multiple input files specified");
		}	
		//System.out.println("FILE: "+fileName);
	    Global.simulaRtsLib=new File(Global.simulaHome,"rts");
		if (fileName == null) {
		    //printGlobalList("*** STARTING SIMULA EDITOR ***");
			Global.sampleSourceDir=new File(Global.simulaHome,"samples");
			RTOption.InitRuntimeOptions();
	    	Option.InitCompilerOptions();
	    	SimulaEditor editor=new SimulaEditor();
	    	editor.setVisible(true);
		} else {
		    //printGlobalList("*** STARTING SIMULA COMPILER ***");
		    new SimulaCompiler(fileName).doCompile();
		}
	}

	private static void error(final String msg) {
		System.err.println("Simula: " + msg + "\n");
		Util.popUpError(msg);
		help();
	}

    /**
     * %SELECT select-character { select-character }
     * <p>
     * Set selectors for conditional compilation.
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
