/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package SystemGeneration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.Set;
import static java.nio.file.StandardCopyOption.*;

import simula.compiler.utilities.Global;

/**
 * NOTE:
 * <p>
 * <ul>
 * <li> Update Global.simulaReleaseID
 * </li>
 * <li> Set Environment variable  SIMULA_HOME = C:\GitHub\Binaries
 *      - KontrolPanel
 *      - System
 *      - Avanserte Systeminnstillinger
 *      - Miljøvariabler (Environment Variables)
 *      - Definer: SIMULA_HOME = C:\GitHub\Binaries  (Husk: OK OK )
 *      - Restart Eclipse
 * </li>
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class MakeCompiler {
	
	private final static String SIMULA_HOME=System.getenv("SIMULA_HOME"); // NOTE: may be null
	private final static String RELEASE_ID=Global.simulaReleaseID; // E.g. "Release-1.0";

	private final static String RELEASE_HOME=SIMULA_HOME+"\\"+RELEASE_ID;
	private final static String RELEASE_TST=RELEASE_HOME+"\\tst";

	private final static String ECLIPSE_ROOT="C:\\GitHub\\SimulaCompiler\\Simula";
	private final static String COMPILER_BIN=ECLIPSE_ROOT+"\\bin";

	public static void main(String[] args) {
		printHeading("Make Simula Compiler, SIMULA_HOME="+SIMULA_HOME);
		if(SIMULA_HOME==null) {
			System.out.println("*** FATAL ERROR: Environment Variable 'SIMULA_HOME' is not defined");
			System.exit(-1);
		}
		try {
//			printSystemProperties();
			makeSimulaCompiler();
			copySimulaRuntimeSystem();
			dummyExecuteSimulaCompiler();
			copySimulaReleaseTests();
			copySimulaReleaseTestBats();
			compileAndExecuteSimulaPrograms();
		} catch(Exception e) { e.printStackTrace(); }
	}
	
	// ***************************************************************
	// *** MAKE SIMULA COMPILER JAR
	// ***************************************************************
	private static void makeSimulaCompiler() throws IOException	{
		printHeading("Make Simula Compiler.jar in "+RELEASE_HOME);
		File releaseHome=new File(RELEASE_HOME);
		//System.out.println("releaseHome="+releaseHome);
		//System.out.println("releaseHome'canWrite="+releaseHome.canWrite());
		//boolean directoryWasCreated=
				releaseHome.mkdirs();
		//System.out.println("directoryWasCreated="+directoryWasCreated);

		execute("jar cmf .\\MANIFEST.MF "+RELEASE_HOME+"\\simula.jar -C "+COMPILER_BIN+" ./simula/compiler -C "+COMPILER_BIN+" ./org/apache/bcel");
		execute("jar -tvf "+RELEASE_HOME+"\\simula.jar");
	}
	
	// ***************************************************************
	// *** COPY SIMULA RUNTIME SYSTEM
	// ***************************************************************
	private static void copySimulaRuntimeSystem() throws IOException {
		String target=RELEASE_HOME+"\\rts\\simula\\runtime";
		printHeading("Copy Simula RuntimeSystem into "+RELEASE_HOME);
        System.out.println("MakeCompiler.copySimulaRuntimeSystem: RELEASE_HOME="+RELEASE_HOME);
        // *** Copy Current Runtime System
		execute("Robocopy "+COMPILER_BIN+"\\simula\\runtime "+target+" /E");
//		echo *** Copy Current Compiler Also -- TEMP
//		Robocopy .\simula\compiler %RELEASE_HOME%\rts\simula\compiler /E
	}
	
	// ***************************************************************
	// *** DUMMY EXECUTE SIMULA COMPILER JAR
	// ***************************************************************
	private static void dummyExecuteSimulaCompiler() throws IOException	{
		printHeading("Dummy Execute SimulaCompiler: "+RELEASE_HOME+"\\simula.jar");
		execute("java -jar "+RELEASE_HOME+"\\simula.jar");
	}
	
	// ***************************************************************
	// *** COPY SIMULA RELEASE TEST PROGRAMS
	// ***************************************************************
	private static void copySimulaReleaseTests() throws IOException	{
		printHeading("Copy Simula TestPrograms into "+RELEASE_TST);
		execute("Robocopy "+ECLIPSE_ROOT+"\\src\\testing\\tst "+RELEASE_TST+" /E");
	}
	
	// ***************************************************************
	// *** COPY SIMULA RELEASE TEST BATCH FILES
	// ***************************************************************
	private static void copySimulaReleaseTestBats() throws IOException	{
		printHeading("Copy Simula Test .bat's into "+RELEASE_HOME);
		copyBatFile("RunCompilerTest.bat");
		copyBatFile("RunCompilerTest.sh");
	}
	private static void copyBatFile(String batName) throws IOException	{
		File source=new File(ECLIPSE_ROOT+"\\src\\SystemGeneration\\"+batName);
		File target=new File(RELEASE_HOME+"\\"+batName);
		target.mkdirs();
		System.out.println("source="+source);
		System.out.println("target="+target);
		Files.copy(source.toPath(), target.toPath(), REPLACE_EXISTING);
	}
	
	// ***************************************************************
	// *** COMPILE AND EXECUTE SIMULA PROGRAMS
	// ***************************************************************
	private static void compileAndExecuteSimulaPrograms() throws IOException {
		printHeading("Compile and Execute TestPrograms from "+RELEASE_TST);
		compileAndExecuteSimulaProgram(RELEASE_TST+"\\HelloWord.sim");
		compileAndExecuteSimulaProgram(RELEASE_TST+"\\JensensDevice.sim");
		compileAndExecuteSimulaProgram(RELEASE_TST+"\\FittingRoom.sim");
		compileAndExecuteSimulaProgram(RELEASE_TST+"\\Docking.sim");
	}
	private static void compileAndExecuteSimulaProgram(String source) throws IOException {
		execute("java -jar "+RELEASE_HOME+"\\simula.jar "+source);
	}
	
	// ***************************************************************
	// *** EXECUTE OS COMMAND
	// ***************************************************************
	private static int execute(String command) throws IOException {
		Runtime runtime = Runtime.getRuntime();
        System.out.println("MakeCompiler.execute: command="+command);
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

	private static void printHeading(String heading) {
		System.out.println("********************************************************************************");
		System.out.println("*** "+heading);
		System.out.println("********************************************************************************");
	}
	
	private static void printSystemProperties() {
		printHeading("Jave System Properties");
		Properties prop = System.getProperties();
		Set<Object> keySet = prop.keySet();
		for (Object obj : keySet) {
			System.out.println("System Property: {" 
					+ obj.toString() + " = " 
					+ System.getProperty(obj.toString()) + "}");
		}
	}

}
