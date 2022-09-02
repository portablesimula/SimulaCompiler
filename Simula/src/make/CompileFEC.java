/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package make;

import java.io.File;
import java.util.Vector;

import simula.compiler.Simula;
import simula.compiler.SimulaCompiler;
import simula.compiler.editor.RTOption;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;

/**
 * Simula Test Batch donated by Simula as.
 * 
 * @author Several from Norwegian Computing Center.
 * @author Several from Simula as.
 * @author Øystein Myhre Andersen
 *
 */
public final class CompileFEC {

	public static void main(String[] args) {
    	//System.setProperty("file.encoding","UTF-8");
		Vector<String> names=new Vector<String>();
		names.add("COMMON.sim");   // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\COMMON.jar
		names.add("ERRMSG.sim");   // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\ERRMSG.jar
		names.add("SCANNER.sim");  // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\SCANNER.jar
		names.add("SCANINP.sim");  // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\SCANINP.jar 
		names.add("PARSER.sim");   // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\PARSER.jar
		names.add("PAS1INIT.sim"); // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\PAS1INIT.jar
		names.add("BUILDER1.sim"); // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\BUILDER1.jar
		names.add("BUILDER2.sim"); // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\BUILDER2.jar
		
		names.add("CHECKER1.sim"); // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\CHECKER1.jar
		names.add("CHECKER2.sim"); // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\CHECKER2.jar
		
		names.add("SCODER0.sim");  // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\SCODER0.jar
		names.add("SCODER1.sim");  // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\SCODER1.jar
		names.add("SCODER1E.sim"); // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\SCODER1E.jar	
		names.add("SCODER2.sim");  // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\SCODER2.jar
		names.add("SCODER3.sim");  // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\SCODER3.jar
		names.add("SCODER4.sim");  // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\SCODER4.jar
		
		names.add("PAS2INIT.sim"); // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\PAS2INIT.jar 
		names.add("SCODMAIN.sim"); // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\SCODMAIN.jar

//		names.add("GENMSG.sim");            // WILL GENERATE FILE MessageGenerator.sim
//		names.add("MessageGenerator.sim");  // WILL GENERATE ERROR MESSAGE FILE FECERROR.txt
		
		names.add("FECMAIN.sim");  // WILL CREATE THE S-PORT COMPILER

		// Set options and tracing.
		Option.INLINE_TESTING=true;
		Option.BREAKING=false;
		Option.TRACING=false;
		Option.WARNINGS=false;
//		Option.CASE_SENSITIVE=true;
		Option.GNERATE_LINE_CALLS=true;
		
		Simula.setSelectors("ZDT");
		Option.noExecution=false;//true;
//		Option.verbose=true;
		
		File userDir=new File("C:/GitHub/SimulaCompiler/Simula");
//		Option.keepJava=userDir; // Generated .java Source is then found in Eclipse Package simulaTestBatch
		Global.packetName="simulaFEC";
		Global.simulaRtsLib=new File(userDir,"bin"); // To use Eclipse Project's simula.runtime
		
		// Set RunTime Options and tracing.
		RTOption.VERBOSE = true;//false;
		RTOption.DEBUGGING = true;//false;
		RTOption.USE_CONSOLE=false;
		RTOption.CODE_STEP_TRACING = false;
		RTOption.BLOCK_TRACING = false;
		RTOption._GOTOTRACING = false;
		RTOption.THREAD_TRACING = false;
		RTOption.QPS_TRACING = false;
		RTOption.SML_TRACING = false;
		RTOption.USE_VIRTUAL_THREAD=true;//false;
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/sim/simtst01.sim";
		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestPrograms/samples/HelloWorld.sim";
		// SCODE ==>                C:/GitHub/SimulaCompiler/Simula/src/sport/rts/scode/HelloWorld.sim.scd
		long startTimeMs = System.currentTimeMillis( );

		for(String name:names) {
//			String fileName = userDir+"/src/"+Global.packetName+"/sim/"+name;
			String fileName = "C:/WorkSpaces/SPort-System/S-Port/src/sport/fec/"+name;
			System.out.println("Compile: "+fileName);
			SimulaCompiler compiler = new SimulaCompiler(fileName);
			Option.RUNTIME_USER_DIR=new File(fileName).getParent();
			compiler.doCompile();
			System.out.println("Done: "+fileName);
		}
		System.out.println("--- END OF SIMULA TESTBATCH");
		long timeUsed  = System.currentTimeMillis( ) - startTimeMs;
		System.out.println("\nElapsed Time: Approximately " + timeUsed/1000 + " sec.");
	}

}
