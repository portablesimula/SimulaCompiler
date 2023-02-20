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
	
	// The following files are created when Simuletta front-end compiling the RTS:
    // - "C:\Simuletta\Attrs\BEC\simulaRTS\RTS$INTERFACE.dat"
	// - "C:/WorkSpaces/SPort-System/S-Port/src/sport/fec/RTSINIT.ini"
	// - "C:/WorkSpaces/SPort-System/S-Port/src/sport/fec/RTS-FEC-INTERFACE1.def"
    // - "C:/WorkSpaces/SPort-System/S-Port/src/sport/fec/RTS-FEC-INTERFACE2.def"
	// - "C:/WorkSpaces/SPort-System/S-Port/attrs/FEC/PREDEF.atr


	public static void main(String[] args) {
    	//System.setProperty("file.encoding","UTF-8");
		Vector<String> names=new Vector<String>();
//		names.add("COMMON.sim");   // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\COMMON.jar
//		names.add("ERRMSG.sim");   // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\ERRMSG.jar
//		names.add("SCANNER.sim");  // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\SCANNER.jar
//		names.add("SCANINP.sim");  // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\SCANINP.jar 
//		names.add("PARSER.sim");   // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\PARSER.jar
//		names.add("PAS1INIT.sim"); // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\PAS1INIT.jar
//		names.add("BUILDER1.sim"); // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\BUILDER1.jar
//		names.add("BUILDER2.sim"); // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\BUILDER2.jar
//		
//		names.add("CHECKER1.sim"); // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\CHECKER1.jar
//		names.add("CHECKER2.sim"); // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\CHECKER2.jar
//		
//		names.add("SCODER0.sim");  // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\SCODER0.jar
//		names.add("SCODER1.sim");  // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\SCODER1.jar
//		names.add("SCODER1E.sim"); // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\SCODER1E.jar	
//		names.add("SCODER2.sim");  // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\SCODER2.jar
//		names.add("SCODER3.sim");  // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\SCODER3.jar
//		names.add("SCODER4.sim");  // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\SCODER4.jar
//		
//		names.add("PAS2INIT.sim"); // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\PAS2INIT.jar 
		names.add("SCODMAIN.sim"); // END Create .jar File: C:\WorkSpaces\SPort-System\S-Port\src\sport\fec\bin\SCODMAIN.jar

//		names.add("GENMSG.sim");            // WILL GENERATE FILE MessageGenerator.sim
//		names.add("MessageGenerator.sim");  // WILL GENERATE ERROR MESSAGE FILE FECERROR.txt
		
		names.add("FECMAIN.sim");  // WILL CREATE THE S-PORT COMPILER

		// Set options and tracing.
		Option.INLINE_TESTING=true;
//		Option.verbose=true;
//		Option.BREAKING=false;
//		Option.TRACING=false;
		Option.WARNINGS=false;
//		Option.CASE_SENSITIVE=true;
		Option.GNERATE_LINE_CALLS=true;
		
		Simula.setSelectors("ZDTW");
		Option.noExecution=false;//true;
//		Option.verbose=true;
		
		File userDir=new File("C:/GitHub/SimulaCompiler/Simula");
//		Option.keepJava=new File("C:/GitHub/SimulaCompiler/javaCodeFEC"); // Generated .java Source is then found in project javaCodeFEC
		Global.packetName="simulaFEC";

		Global.simulaRtsLib=new File(userDir,"bin"); // To use Eclipse Project's simula.runtime
		System.out.println("SimulaRtsLib: "+Global.simulaRtsLib);
		
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
		
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestPrograms/samples/HelloWorld.sim";
		// SCODE ==>                C:/GitHub/SimulaCompiler/Simula/src/sport/rts/scode/HelloWorld.sim.scd

//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestPrograms/simple/adHoc00.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestPrograms/simple/adHoc01.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestPrograms/simple/adHoc02.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestPrograms/simple/Editing.sim";

//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst00.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst01.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst02.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst03.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst03.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst04.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst05.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst06.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst07.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst08.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst09.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst10.sim";
		
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst11.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst12.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst13.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst14.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst15.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst16.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst17.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst18.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst19.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst20.sim";
		
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst21.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst22.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst23.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst24.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst25.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst26.sim";  // FEILER !!!
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst27.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst28.sim";  //ERROR: Internal error: TYPE mismatch below TOS -- ASSREP: param.type=SINT, sprec-type=INT
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst29.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst30.sim";  //ERROR: B_FNP_ACC --- DENNE MANGLET I 'RTSINT1.def' 
		
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst31.sim";  //ERROR: SORRY, complex switch element IS NOT IMPLEMENTED
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst32.sim";  //ERROR: form$THK2PQ:BODY[30]    RETURN    THK2PQ:BODY
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst33.sim";  //ERROR: TypeMap.checkLegal: Illegal type=GADDR, Legal types=OADDR[ARGIND.IMPORT.HEAD]
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst34.sim";  //ERROR: B_FNP_ACC --- DENNE MANGLET I 'RTSINT1.def' 
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst35.sim";  //ERROR: B_FNP_ACC --- DENNE MANGLET I 'RTSINT1.def' 
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst36.sim";  //ERROR: B_FNP_ACC --- DENNE MANGLET I 'RTSINT1.def'
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst37.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst38.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst39.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst40.sim";  //IKKE FORSØKT: External Procedure  !!! 
		
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst41.sim";  //IKKE FORSØKT: External Procedure  !!! 
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst42.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst43.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst44.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst45.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst46.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst47.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst48.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst49.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst50.sim";
		
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst51.sim"; 
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst52.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst53.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst54.sim";  //ERROR: Noe rart med prefix'chain i prototypen til Simulation begin
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst55.sim";  //WARNING type
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst56.sim";  //ERROR: B_FNP_ACC --- DENNE MANGLET I 'RTSINT1.def' 
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst57.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst58.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst59.sim";  //ERROR: Line 18  missing indices
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst60.sim";
		
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst61.sim"; 
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst62.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst63.sim";  //ERROR: TypeMap.checkLegal: Illegal type=AADDR, Legal types=OADDR[E_FPT.IMPORT.CLA_SL]
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst64.sim";  //ERROR: Recursive or nested call is not allowed in S-Code: AR1IND
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst65.sim";  //ERROR: Recursive or nested call is not allowed in S-Code: TXTASS
		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst66.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst67.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst68.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst69.sim";
//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst70.sim";

		//		RTOption.SPORT_SOURCE_FILE="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch2/sim/simtst30.sim";

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
