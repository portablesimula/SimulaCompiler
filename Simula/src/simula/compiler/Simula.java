/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler;

import java.lang.reflect.Field;
import java.nio.charset.Charset;

import simula.compiler.editor.OptionMenu;
import simula.compiler.editor.SimulaEditor;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class Simula {
	static String SIMULA_HOME;

	static void help() {
		System.out.println(Global.simulaReleaseID+" See: https://github.com/portablesimula\n");
		System.out.println("SIMULA_HOME="+System.getenv("SIMULA_HOME")+"\n");
		System.out.println("JAVA_HOME="+System.getenv("JAVA_HOME")+"\n\n");
		System.out.println("Usage: java simula.jar  [options]  sourceFile \n\n"
				+ "possible options include:\n"
				+ "  -help                      Print this synopsis of standard options\n"
				+ "  -noexec                    Don't execute generated .jar file\n"
				+ "  -nowarn                    Generate no warnings\n"
				+ "  -verbose                   Output messages about what the compiler is doing\n"
				+ "  -SIMULA_HOME <directory>   Specify where to find the Simula Runtime-System\n"
				+ "                             Default: Taken from the Environment variable SIMULA_HOME\n"
				+ "  -keepJava <directory>      Specify where to place generated .java files\n"
				+ "                             Default: Temp directory which is deleted upon exit\n"
				+ "  -output <directory>        Specify where to place generated executable .jar file\n"
				+ "                             Default: Same directory as source file\n"
				+ "\nsourceFile      Simula Source File\n");
		System.exit(0);
	}

	public static void main(String[] argv) {
		String fileName = null;
//		SIMULA_HOME=System.getenv("SIMULA_HOME"); // Default, may be null
		SIMULA_HOME=Global.getProperty("simula.home",null); // Default, may be null
		// Set default options.
		Option.verbose=true;//false;
		Option.WARNINGS=true;

		// Parse command line arguments.
		for(int i=0;i<argv.length;i++) {
			String arg=argv[i];
			if (arg.charAt(0) == '-') { // command line option
				if (arg.equals("-help")) help();
				else if (arg.equals("-noexec")) Option.noExecution=true;
				else if (arg.equals("-nowarn")) { Option.noJavacWarnings=true; Option.WARNINGS=false; }
				else if (arg.equals("-verbose")) Option.verbose=true;
				else if (arg.equals("-standardClass")) Option.standardClass=true;
				else if (arg.equals("-keepJava")) setKeepJava(argv[++i]);
				else if (arg.equals("-outputJava")) setOutputDir(argv[++i]);
				else error("Unknown option "+arg);
			} else if(fileName==null) fileName = arg;
			else error("multiple input files specified");
		}
		if(SIMULA_HOME==null) {
			error("Environment Variable 'SIMULA_HOME' is not defined");
		}
//		System.setProperty("file.encoding","UTF-8");		
		setEncoding("UTF-8");	
		Util.popUpMessage("SIMULA_HOME="+SIMULA_HOME);
		
		if (fileName == null) {
			//error("No input files specified");
			Global.sampleSourceDir=SIMULA_HOME+'/'+Global.simulaReleaseID+"/tst";
		    Global.simulaRtsLib=SIMULA_HOME+'/'+Global.simulaReleaseID+"/rts/"; // TODO: Later  /RTS.jar
		    printGlobalList("*** STARTING SIMULA EDITOR ***");
	    	OptionMenu.InitRuntimeOptions();
	    	OptionMenu.InitCompilerOptions();
	    	SimulaEditor editor=new SimulaEditor();
	    	editor.setVisible(true);
		} else {
		    Global.simulaRtsLib=SIMULA_HOME+'/'+Global.simulaReleaseID+"/rts/"; // TODO: Later  /RTS.jar
		    printGlobalList("*** STARTING SIMULA COMPILER ***");
		    // Start compiler ....
		    new SimulaCompiler(fileName).doCompile();
		}
	}
	
	private static void printGlobalList(String msg) {
		if(Option.verbose)
		{ Util.message(msg);
		  Util.message("SIMULA HOME:     "+SIMULA_HOME);
		  Util.message("Package Name:    "+Global.packetName);
		  //Util.message("SourceFile Name: "+Global.sourceName);
		  //Util.message("SourceFile Dir:  "+Global.sourceFileDir);
		  //Util.message("TempDir .Java:   "+Global.tempJavaFileDir);
		  //Util.message("TempDir .Class:  "+Global.tempClassFileDir);
		  Util.message("SimulaRtsLib:    "+Global.simulaRtsLib);
		  //Util.message("OutputDir:       "+Global.outputDir);
		}

	}
	
	private static void setEncoding(String encoding) {
        dump("Actual system config");
        System.setProperty("file.encoding",encoding);
        dump("Config after System.setProperty(\"file.encoding\","+encoding+"\")");
        try { Field cs = Charset.class.getDeclaredField("defaultCharset");
              cs.setAccessible(true); cs.set(null, null);
        } catch(Exception e) {}
        dump("Config after manipulating defatulCharset field");
    }

    private static void dump(String msg) {
    	if(!Option.verbose) return;
        System.out.println(msg);
        System.out.println("****************************************************************");
        System.out.println("file.encoding          = " + System.getProperty("file.encoding"));
        System.out.println("defaultCharset         = " + Charset.defaultCharset());
        System.out.println("****************************************************************");
        System.out.println("");
    }
	
	private static void error(String msg)
	{ System.err.println("Simula: "+msg+"\n");
	  Util.popUpError(msg);
	  help();
	}
	

    /**
     * Option:  -SIMULA_HOME <directory>   Specify where to find the Compiler and Runtime-System\n"
     */
    private static String getSimulaHome(String dir)
    { String SIMULA_HOME=dir;
      Util.TRACE("SIMULA_HOME: "+SIMULA_HOME);
      // TODO: Check dir legal directory name
      return(SIMULA_HOME);
    }

    /**
     * Option:  -keepJava <directory> Specify where to place generated .java files
     */
    private static void setKeepJava(String dir)
    { Option.keepJava=dir;
      Util.TRACE("KEEP_JAVA: "+Option.keepJava);
      // TODO: Check dir legal directory name
    }

    /**
     * Option:  -output <directory>        Specify where to place generated executable .jar file
     */
    private static void setOutputDir(String dir)
    { Option.outputDir=dir;
      Util.TRACE("OUTPUT_DIR: "+Option.keepJava);
      // TODO: Check dir legal directory name
    }


}
