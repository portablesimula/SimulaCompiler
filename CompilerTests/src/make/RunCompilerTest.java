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

import simula.compiler.Simula;
import simula.compiler.SimulaCompiler;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Run inline compiler tests.
 * @author Øystein Myhre Andersen
 *
 */
public final class RunCompilerTest {

	public static void main(String[] args) {
    	//System.setProperty("file.encoding","UTF-8");

		// *** STANDARD CLASSES
		// String name="/rts/Text.sim";
		// String name="/rts/ENVIRONMENT.sim";
		// String name="/rts/BASICIO.sim";
		// String name="/rts/FILE.sim";
		// String name="/rts/ImageFile.sim";
		// String name="/rts/InFile.sim";
		// String name="/rts/OutFile.sim";
		// String name="/rts/PrintFile.sim";
		// String name="/rts/DirectFile.sim";
		// String name="/rts/ByteFile.sim";
		// String name="/rts/InbyteFile.sim";
		// String name="/rts/OutbyteFile.sim";
		// String name="/rts/DirectByteFile.sim";
		// String name="/rts/Simset.sim";
		// String name="/rts/Simulation.sim";

		// *** SIMULA PROGRAMMER FOR VIDERE UTVIKLING
		// String name="/simprogs/COUNTERACT.sim";  // Used by AirportDeparture
		// String name="/simprogs/AirportDeparture.sim";
		// String name="/simprogs/DEMOS.sim";
		// String name="/simprogs/HegnaNRK.sim";
		// String name="/simprogs/LIFT90.sim";
		// String name="/simprogs/Matte.sim";
		// String name="/simprogs/NewDocking.sim";
		// String name="/simprogs/QueDemo.sim";
		// String name="/simprogs/TRAFFIC.sim";
		// String name="/simprogs/SudokuPuzzle.sim";
		// String name="/simprogs/SudokuPuzzleFlow.sim";

		// *** SIMULA PROGRAMMER TIL RELEASE TESTING
		// String name="/samples/AnimationTest.sim";
		// String name="/samples/Atkins.sim";
		// String name="/samples/Dates.sim";
		 String name="/samples/DatesTest.sim";
		// String name="/samples/Docking.sim";
		// String name="/samples/FittingRoom.sim";
		// String name="/samples/HelloWorld.sim";
		// String name="/samples/HexDump.sim";
		// String name="/samples/InfectionDisease.sim";
		// String name="/samples/JensensDevice.sim";
		// String name="/samples/LiftSimulation.sim";
		// String name="/samples/PrimeUnder.sim";
		// String name="/samples/Quine.sim";
		// String name="/samples/Sudoku.sim";
		// String name="/samples/SudokuPuzzle.sim";
		// String name="/samples/TQueens.sim";

		// *** DEMOS EXAMPLES
		// String name="/demos/Demos.sim";
		// String name="/demos/Klant1.sim";
		// String name="/demos/Klant4.sim";

		// *** SIMULA I EXAMPLES
		// String name="/SIMULA_1/SIMULA.sim";

		// *** SINGULÆRE TEST PROGRAMMER
		// String name="/singulares/DirectBytefileAppend.sim";
		// String name="/singulares/DirectfileAppend.sim";
		// String name="/singulares/OutfileAppend.sim";
		// String name="/singulares/PrintFileTest.sim";
		// String name="/singulares/PrintFileTest2.sim";
		// String name="/singulares/RandomDrawing.sim";
		// String name="/singulares/Transplantation1.sim";
		// String name="/singulares/Transplantation2.sim";
		// String name="/singulares/Transplantation3.sim";

		// *** SimulaRTS Document EXAMPLES
		// String name="/simulaRTS_Examples/Sect-2-1-SubBlock.sim";
		// String name="/simulaRTS_Examples/Sect-2-2-Class.sim";
		// String name="/simulaRTS_Examples/Sect-2-3-SubClass.sim";
		// String name="/simulaRTS_Examples/Sect-2-4-PrefixedBlock.sim";
		// String name="/simulaRTS_Examples/Sect-2-5-Procedure.sim";
		// String name="/simulaRTS_Examples/Sect-2-6-Switch.sim";
		// String name="/simulaRTS_Examples/Sect-3-3-Text.sim";
		// String name="/simulaRTS_Examples/Sect-4-1-JensensDevice.sim";
		// String name="/simulaRTS_Examples/Sect-4-2-ArrayParameter.sim";
		// String name="/simulaRTS_Examples/Sect-4-3-ProcedureAsParameter.sim";
		// String name="/simulaRTS_Examples/Sect-5-SomeExpressions.sim";
		// String name="/simulaRTS_Examples/Sect-6-1-GotoStatement.sim";
		// String name="/simulaRTS_Examples/Sect-6-2-ForStatement.sim";
		// String name="/simulaRTS_Examples/Sect-6-3-ConnectionStatement.sim";
		// String name="/simulaRTS_Examples/Sect-6-4-SwitchStatement.sim";
		// String name="/simulaRTS_Examples/Sect-6-5-ActivationStatement.sim";

		// *** SIMULA DESIGN EXAMPLES
		// String name="/design/Test.sim";
		// String name="/design/ActivationStatement.sim";
		// String name="/design/ArrayAssignment.sim";
		// String name="/design/ArrayAsParameters.sim";
		// String name="/design/ArrayByValue.sim";
		// String name="/design/ArrayDeclaration.sim";
		// String name="/design/CallProcedureRemote.sim";
		// String name="/design/CallProcedureConnected.sim";
		// String name="/design/ProcedureDeclaration.sim";
		// String name="/design/CallProcedureFormal.sim";
		// String name="/design/CallProcedureVirtual.sim";
		// String name="/design/ProcedureByName.sim";
		// String name="/design/ProcedureResult.sim";
		// String name="/design/RandomDrawing.sim";
		// String name="/design/SwitchDeclaration.sim";
		// String name="/design/SwitchStatement.sim";
		// String name="/design/SyntaxTree.sim";
		// String name="/design/VirtualSwitch.sim";
		// String name="/design/FormalSwitch.sim";
		// String name="/design/NormalSwitch.sim";
		// String name="/design/ForStatement.sim";
		// String name="/design/InspectStatement.sim";
		// String name="/design/WhileStatement.sim";
		// String name="/design/ClassTry.sim";
		// String name="/design/Test_CatchingErrors.sim";

		// *** SIMULA ERROR-TEST PROGRAMMER FRA KAREL
		// String name="/Karel/Collatz.sim";
		// String name="/Karel/Factorial.sim";
		// String name="/Karel/FittingRoom.sim";  // P()
		// String name="/Karel/HegnaNRK.sim";
		// String name="/Karel/IBMQuine.sim";
		// String name="/Karel/JensensDevice.sim";
		// String name="/Karel/PrimeUnder.sim";
		// String name="/Karel/simulaid.sim";

		// *** SIMULA ERROR-TEST PROGRAMMER
		// String name="/error/ComplexQPS.sim"; //
		// String name="/error/VirtualThreadMegaTest.sim"; //
		// String name="/error/simerr01.sim"; // Syntax errors
		// String name="/error/simerr02.sim"; // Syntax errors  TODO: MÅ SJEKKES - NumberFormatException - Illegal number: 1e
		// String name="/error/simerr03.sim"; // Wrong Number of parameters  
		// String name="/error/simerr04.sim"; // Type checking of Parameter Array 
		// String name="/error/simerr05.sim"; // Syntax error - Semicolon before 'else' 
		// String name="/error/simerr06.sim"; // Label invisible through inspection 
		// String name="/error/simerr08.sim"; // Local Connected Object 
		// String name="/error/simerr09.sim"; // Character and Java keyword char 
		// String name="/error/simerr10.sim"; // Java keywords as Identifiers 
		// String name="/error/simerr13.sim"; // Nested Connections 
		// String name="/error/simerr14.sim"; // Two consecutive identifiers - ERROR - GÅR I LOOP
		// String name="/error/simerr15.sim"; // Constants
		// String name="/error/simerr16.sim"; // Illegal lhs in assignment
		// String name="/error/simerr17.sim"; // Transplantation
		// String name="/error/simerr18.sim"; // Transplantation
		// String name="/error/simerr19.sim"; // Transplantation
		// String name="/error/simerr20.sim"; // Transplantation
		
		// String name="/error/issue12.sim"; // Dot-aksess inn i klasser med lokale klasser,
		// String name="/error/issue13.sim"; // Tillater subklasser på dypere blokknivå.
		// String name="/error/issue16.sim"; // Problemer med å evaluere Constant-expression
		// String name="/error/issue20.sim"; // Label og Proceure som parameter til en Klasse
		// String name="/error/issue23.sim"; // no-type Array som parameter
		// String name="/error/issue21.sim"; // Ingen new-line til slutt i file
		// String name="/error/issue24.sim"; // For step until
		// String name="/error/issue26.sim"; // Terminating Process in strict sence.
		// String name="/error/issue31.sim"; // Labeled INNER
		// String name="/error/issue32.sim"; // This Process
		// String name="/error/issue33.sim"; // Call Procedure Formal 
		// String name="/error/issue34.sim"; // NOTEXT.put... 
		// String name="/error/issue35.sim"; // Missing cast in for-statement coding ...
		// String name="/error/issue36.sim"; // Missing cast in for-statement coding ...
		// String name="/error/issue37a.sim"; // Missing cast in for-statement coding ...
		// String name="/error/issue37b.sim"; // Missing cast in for-statement coding ...
		// String name="/error/issue38.sim"; // Standalone  new ...
		// String name="/error/issue39.sim"; //  ...
		// String name="/error/issue40.sim"; // Integer overflow during parsing
		// String name="/error/issue41.sim"; // Drawing
		// String name="/error/issue42.sim"; // GOTO else-brance
		// String name="/error/8Queens.sim";  // Illegal Identifier
		// String name="/error/Queens.sim";
		// String name="/error/Queens2.sim";  // Illegal Characters
		// String name="/error/Characters.sim";  // Illegal Characters
		// String name="/error/NoughtsAndCrosses.sim";  // 
		// String name="/error/simtst76b.sim";  // 

//		String name="/simple/COMMON.sim";
//		String name="/simple/ERRMSG.sim";
//		String name="/simple/SCANNER.sim";
//		String name="/FECTest/fecTest.sim";

		// *** SMÅ ENKLE SIMULA TEST PROGRAMMER
		// String name="/simple/adHoc00.sim";
		// String name="/simple/adHoc01.sim";
		// String name="/simple/adHoc02.sim";
		// String name="/simple/adHoc03.sim";
		// String name="/simple/adHoc04.sim";
		// String name="/simple/adHoc05.sim";
		// String name="/simple/adHoc06.sim";
		// String name="/simple/adHoc26.sim";
		// String name="/simple/adHoc51.sim";
		// String name="/simple/adHoc54.sim";
		// String name="/simple/adHoc66.sim";
		// String name="/simple/adHoc67.sim";
		// String name="/simple/adHoc68.sim";
	    // String name="/simple/ArrayAsParameter.sim";
		// String name="/simple/Assignments.sim";
		// String name="/simple/Blocks.sim";
		// String name="/simple/ClassGlyph.sim";
		// String name="/simple/ClockTimeTest.sim";
		// String name="/simple/CommentSamples.sim";
		// String name="/simple/ConcatSample.sim";
		// String name="/simple/DecimalEdit.sim"; 
		// String name="/simple/Detachable.sim"; 
		// String name="/simple/DetachSamples.sim"; 
		// String name="/simple/DrawingTest.sim";
		// String name="/simple/Editing.sim";
		// String name="/simple/Expressions.sim";
		// String name="/simple/ForWhileSamples.sim";
		// String name="/simple/ForWhileSamples2.sim";
		// String name="/simple/FunctionCall.sim";
		// String name="/simple/Gauss.sim";
		// String name="/simple/HashingExample.sim";
		// String name="/simple/HelloWorld.sim";
		// String name="/simple/InfileSample.sim";
		// String name="/simple/InspectionSamples.sim";  
		// String name="/simple/LocalObject.sim";
		// String name="/simple/ParamSample.sim";
		// String name="/simple/PrfxBlockSamples.sim";
		// String name="/simple/PrintFile.sim";
		// String name="/simple/PriorProcedure.sim";   // ????
		// String name="/simple/ProcedureSample.sim";
		// String name="/simple/PromptSample.sim";
		// String name="/simple/RemoteProcedure.sim";
		// String name="/simple/SubClassTest.sim";
		// String name="/simple/TextSamples.sim";
		// String name="/simple/TextSamples1.sim";
		// String name="/simple/VariableByName.sim";

			// Set Compile Time Options and tracing.
			Option.INLINE_TESTING=true;
		    Option.verbose = true;
			Option.WARNINGS=true;
//			Option.EXTENSIONS=false;
//			Option.CASE_SENSITIVE=true;
//			Option.TESTING=true;

			// Overall TRACING Options
//			Option.TRACING=true;
//
//			// Scanner Trace Options
//			Option.TRACE_SCAN=true;
//			Option.TRACE_COMMENTS=true;
//
//			// Parser Trace Options
//			Option.TRACE_PARSE=true;
			Option.PRINT_SYNTAX_TREE=true;
//			Option.TRACE_ATTRIBUTE_OUTPUT=true;
//			Option.TRACE_ATTRIBUTE_INPUT=true;
//
//			// Checker Trace Options
//			Option.TRACE_CHECKER=true;
//			Option.TRACE_CHECKER_OUTPUT=true;
//			Option.TRACE_FIND_MEANING=2;
//			
//			// Coder Trace Options
//			Option.TRACE_CODING=true;
//			Option.GNERATE_LINE_CALLS=true;
//			
//			Option.USE_FILE_CLASS_API=1;
//			Option.USE_FILE_CLASS_API=2;
			
			Option.USE_FILE_CLASS_API=1;
//			Option.TRACE_REPAIRING=true;
//			Option.LIST_REPAIRED_INSTRUCTION_LIST=true;
//			Option.TRACE_BYTECODE_OUTPUT=true;
//			Option.DEBUGGING=true;

//			File simulaHome=new File("C:/GitHub/SimulaCompiler/TestBatch");
			File simulaDir=new File("C:/GitHub/SimulaCompiler/Simula");
			File userDir=new File("C:/GitHub/SimulaCompiler/CompilerTests");
			
			
			Global.packetName="simulaTestPrograms";
			Option.keepJava=userDir; // Generated .java Source is then found in Eclipse Package simulaTestPrograms
			Global.simulaRtsLib=new File(simulaDir,"bin"); // To use Eclipse Project's simula.runtime
//			Option.outputDir=new File("C:/GitHub/SimulaCompiler/Simula/src/simulaTestPrograms/samples/simula/bin");
//			Global.outputDir=new File("C:/GitHub/SimulaCompiler/TestBatch/src/simulaTestPrograms/samples/simula/bin");
			Global.outputDir=new File("C:/GitHub/SimulaCompiler/CompilerTests/bin/simulaTestPrograms");
			
			
			// Set RunTime Options and tracing.
//			RTOption.VERBOSE = true;
//			RTOption.USE_CONSOLE=true;
//			RTOption.BLOCK_TRACING = true;
//			RTOption.GOTO_TRACING = false;
//			RTOption.QPS_TRACING = false;
//			RTOption.SML_TRACING = false;

			String fileName=userDir+"/src/"+Global.packetName + name;
			Option.RUNTIME_USER_DIR=new File(fileName).getParent();
			
			Simula.setSelectors("ZD");

		SimulaCompiler compiler = new SimulaCompiler(fileName);
		try { compiler.doCompile(); } catch (IOException e) { Util.IERR("Compiler Error: ", e); }
	}


}
