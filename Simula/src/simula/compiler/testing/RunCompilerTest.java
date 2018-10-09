/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.testing;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import simula.compiler.SimulaCompiler;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * @author Øystein Myhre Andersen
 *
 */
public final class RunCompilerTest {

	public static void main(String[] args) {

//		// Set options and tracing.
//		Option.BREAKING=false;
//		Option.TRACING=false;
//		Option.WARNINGS=false;
//		Option.verbose=false;
//		
//		String userDir=System.getProperty("user.dir");
//		Global.simulaRtsLib=userDir+"/bin/";
//		Option.outputDir=userDir+"/src/testing/bin/";
		
//		echo Two sample calls on Simula-Compiler
//		echo %SIMULA_HOME%
//		pause
//		dir
//		java -jar .\jar\simula.jar
//		pause
//		java -cp %SIMULA_HOME%\simula.jar -jar %SIMULA_HOME%\simula.jar .\src\testing\sim\HelloWord.sim
//		pause
//		java -cp %SIMULA_HOME%\simula.jar -jar .\src\testing\sim\HelloWord.jar
//		pause
		
		String SIMULA_SGEN="C:\\GitHub\\SimulaCompiler\\Simula\\src\\SystemGeneration";
		String SIMULA_COMP="C:\\GitHub\\SimulaCompiler\\Simula";
		String SIMULA_HOME="C:\\GitHub\\Binaries\\UnderConstruction";
		
//		try { execute("java -cp "+SIMULA_HOME+"\\simula.jar -jar "+SIMULA_HOME+"\\simula.jar .\\src\\testing\\sim\\HelloWord.sim");
		
		try {
			
			execute(SIMULA_SGEN+"\\CreateCompilerJar.bat");
//			execute(SIMULA_COMP+"\\CreateCompilerJar.bat");
			
//			execute("java -jar "+SIMULA_HOME+"\\simula.jar");
//			execute("java -jar "+SIMULA_HOME+"\\simula.jar -verbose "+SIMULA_HOME+"\\tst\\HelloWord.sim");
//			execute("java -jar "+SIMULA_HOME+"\\simula.jar "+SIMULA_HOME+"\\tst\\HelloWord.sim");
		
		} catch(Exception e) { e.printStackTrace(); }
	}
	
	// ***************************************************************
	// *** EXECUTE OS COMMAND
	// ***************************************************************
	private static int execute(String command) throws IOException
	{	Runtime runtime = Runtime.getRuntime();
        System.out.println("SimulaCompiler Test: EXECUTE command="+command);
	    //if(Option.TRACE_JAVAC) Util.BREAK("SimulaCompiler.doCompile: EXECUTE command="+command);
	    String cmd=command.trim()+'\n';
		Process process = runtime.exec(cmd);
		//try
		{ InputStream err=process.getErrorStream();
		  InputStream inp=process.getInputStream();
		  while(process.isAlive())
		  { while(err.available()>0) System.err.append((char)err.read());
		    while(inp.available()>0) System.out.append((char)inp.read());
			
		  }
		  // process.waitFor();
		} //catch(InterruptedException e) { e.printStackTrace(); }
		return(process.exitValue());
	}

}
