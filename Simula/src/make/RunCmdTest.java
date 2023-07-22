/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package make;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import simula.compiler.Simula;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

public final class RunCmdTest {

	public static void main(String[] args) {
		Vector<String> cmd=new Vector<String>();
//		String simulaHome="C:/Users/Øystein/Simula/Simula-2.0";
		String simulaHome="C:/Simula";

		String file=simulaHome+"/samples/HelloWorld.sim";
//		String file=simulaHome+"/samples/LiftSimulation.sim";
		
//		cmd.add("-help");
//		cmd.add("-verbose");
		cmd.add("-nowarn");
		cmd.add("-noexec");
		cmd.add(file);
		
		String[] arr = new String[cmd.size()];
        arr = cmd.toArray(arr);
        
		// Set options and tracing.
		Option.INLINE_TESTING=true;
//		Option.DEBUGGING=true;
//		Option.TRACING=true;
		Option.WARNINGS=true;
		Option.verbose=true;
//		Option.EXTENSIONS=false;
//		Option.CaseSensitive=true;
		Option.GNERATE_LINE_CALLS=true;
		
		File userDir=new File("C:/GitHub/SimulaCompiler/Simula");
		Global.packetName="simulaTest";
		Global.simulaRtsLib=new File(userDir,"bin"); // To use Eclipse Project's simula.runtime
		
		// Set RunTime Options and tracing.
//		RTOption.VERBOSE = true;
//		RTOption.USE_CONSOLE=false;
//		RTOption.BLOCK_TRACING = false;
//		RTOption.GOTO_TRACING = false;
//		RTOption.QPS_TRACING = false;
//		RTOption.SML_TRACING = false;


		// ===================================================================
		// CALL SIMULA COMPILER
		// ===================================================================
		Simula.main(arr);
		String jarFile="C:/Simula/samples/bin/_Block_HelloWorld.jar";
//		String jarFile="C:/Simula/samples/bin/_HelloWorld.jar";
		
		// LIST .jar FILE
		//listJarfile(jarFile);
		
		
		Vector<String> cmds=new Vector<String>();
		cmds.add("java");
		cmds.add("-jar");
		cmds.add(jarFile);
//		cmds.add("-useConsole");
//		cmds.add("-help");
		cmds.add("-verbose");
		int exitValue3=execute(cmds);
		if (Option.verbose)	Util.println("END Execute .jar File. Exit value="+exitValue3);
	}
	
//	public static void listJarfile(String jarFile) {
//		Vector<String> cmds=new Vector<String>();
//		cmds.add("jar");
//		cmds.add("-tf");
//		cmds.add(jarFile);
//		int exitValue3=execute(cmds);
//		if (Option.verbose)	Util.println("END Execute list .jar File. Exit value="+exitValue3);
//		
//	}

	// ***************************************************************
	// *** EXECUTE OS COMMAND
	// ***************************************************************
	public static int execute(final Vector<String> cmdarray) {
		String[] cmds=new String[cmdarray.size()];
		cmdarray.copyInto(cmds);
		try {
			return(execute(cmds));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return(-1);
	}
	
	public static int execute(final String... cmdarray) throws IOException {
		Runtime runtime = Runtime.getRuntime();
		if (Option.TRACING) {
			String line="";
			for(int i=0;i<cmdarray.length;i++) line=line+" "+cmdarray[i];
			Util.println("Execute: " + line);
		}
		Process process = runtime.exec(cmdarray);
		InputStream err = process.getErrorStream();
		InputStream inp = process.getInputStream();
		StringBuilder error=new StringBuilder();
		while (process.isAlive()) {
			while (err.available() > 0) {
				char c=(char)err.read();
				System.err.append(c);
				error.append(c);
			}
			while (inp.available() > 0) {
				if(Global.console != null) Global.console.write(""+(char) inp.read());
				else System.out.append((char) inp.read());
			}
		}
		if(error.length()>0) Util.error(error.toString());
		return (process.exitValue());
	}


}
