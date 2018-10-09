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
public final class Simula {

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
		String SIMULA_HOME=System.getenv("SIMULA_HOME"); // Default, may be null
		//System.out.println("SYSTEM: java.class.path="+System.getProperty("java.class.path"));
		
		// Set default options.
		Option.verbose=false;
		Option.WARNINGS=true;

		// Parse command line arguments.
		for(int i=0;i<argv.length;i++) {
			String arg=argv[i];
			if (arg.charAt(0) == '-') { // command line option
				if (arg.equals("-help")) help();
				else if (arg.equals("-noexec")) Option.noexec=true;
				else if (arg.equals("-nowarn")) { Option.nowarn=true; Option.WARNINGS=false; }
				else if (arg.equals("-verbose")) Option.verbose=true;
				else if (arg.equals("-standardClass")) Option.standardClass=true;
				else if (arg.equals("-SIMULA_HOME")) SIMULA_HOME=getSimulaHome(argv[++i]);
				else if (arg.equals("-keepJava")) setKeepJava(argv[++i]);
				else if (arg.equals("-outputJava")) setOutputDir(argv[++i]);
				else error("Unknown option "+arg);
			} else if(fileName==null) fileName = arg;
			else error("multiple input files specified");
		}
		if(SIMULA_HOME==null)
			error("Environment Variable 'SIMULA_HOME' is not defined");
		
//		fileName=SIMULA_HOME+"/tst/HelloWord.sim"; // TEMP !!!!!
//		fileName=SIMULA_HOME+"/tst/JensenDevice.sim"; // TEMP !!!!!
//		fileName=SIMULA_HOME+"/tst/FittingRoom.sim"; // TEMP !!!!!
		
		if (fileName == null) error("No input files specified");
		
		Option.INCLUDE_RUNTIME_SYSTEM_IN_JAR=true;//false;
//		Global.simulaRtsLib=SIMULA_HOME+"/Simula.jar";  // TODO: Later  /RTS.jar
//		Global.simulaRtsLib=SIMULA_HOME+"/rts/";        // TODO: Later  /RTS.jar
		Global.simulaRtsLib=SIMULA_HOME+'/'+Global.simulaReleaseID+"/rts/";        // TODO: Later  /RTS.jar
	
		// Start compiler ....
		new SimulaCompiler(fileName).doCompile();
	}
	
	private static void error(String msg)
	{ System.err.println("Simula: "+msg+"\n");
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
