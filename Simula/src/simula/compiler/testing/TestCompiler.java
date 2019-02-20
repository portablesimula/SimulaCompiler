/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.testing;

import simula.compiler.SimulaCompiler;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;

/**
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class TestCompiler {

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
		// String name="/simprogs/Matte.sim";
		// String name="/simprogs/HexDump.sim";
		// String name="/simprogs/LIFT90.sim";
		// String name="/simprogs/TRAFFIC.sim";

		// *** SIMULA PROGRAMMER TIL RELEASE TESTING
		// String name="/samples/Docking.sim";
		// String name="/samples/FittingRoom.sim";
		// String name="/samples/HegnaNRK.sim";
		// String name="/samples/HelloWorld.sim";
		// String name="/samples/JensensDevice.sim";

		// *** SIMULA ERROR-TEST PROGRAMMER
		// String name="/error/simerr01.sim"; // Syntax errors
		// String name="/error/simerr02.sim"; // Syntax errors
		// String name="/error/simerr03.sim"; // Wrong Number of parameters  
		// String name="/error/simerr04.sim"; // Type checking of Parameter Array 
		// String name="/error/simerr05.sim"; // Syntax error - Semicolon before 'else' 
		// String name="/error/simerr06.sim"; // Label invisible through inspection 
		// String name="/error/simerr07.sim"; // None-check failed 
		// String name="/error/simerr08.sim"; // Local Connected Object 
		// String name="/error/simerr09.sim"; // Character and Java keyword char 
		// String name="/error/simerr10.sim"; // Java keywords as Identifiers 
		// String name="/error/PrecompiledClass.sim"; // Used by simerr11 
		// String name="/error/simerr11.sim"; // Division by Zero in Precompiled Class 
		// String name="/error/PrecompiledProcedure.sim"; // Used by simerr12 
		// String name="/error/simerr12.sim"; // Division by Zero in Precompiled Procedure 
		// String name="/error/simerr13.sim"; // Nested Connections 
		// String name="/error/simerr14.sim"; // Two consecutive identifiers - ERROR - GÅR I LOOP
		// String name="/error/simerr15.sim"; // Constants - Må Sjekkes, går i loop
		 String name="/error/8Queens.sim";  // Illegal Identifier
		// String name="/error/Queens.sim";
		// String name="/error/Queens2.sim";  // Illegal Characters
		// String name="/error/Characters.sim";  // Illegal Characters
		// String name="/error/Sudoku.sim";  // 

		// *** SMÅ ENKLE SIMULA TEST PROGRAMMER
		// String name="/simple/adHoc00.sim";
		// String name="/simple/adHoc01.sim";
		// String name="/simple/adHoc02.sim";
		// String name="/simple/adHoc03.sim";
		// String name="/simple/adHoc04.sim";
		// String name="/simple/adHoc05.sim";
		// String name="/simple/adHoc26.sim";
		// String name="/simple/adHoc68.sim";
	    // String name="/simple/Activation.sim";
	    // String name="/simple/AnimationTest.sim";
	    // String name="/simple/ArrayAsParameter.sim";
		// String name="/simple/Assignments.sim";

		// String name="/simple/Blocks.sim";
		// String name="/simple/Blocks2.sim";
		 
		// String name="/simple/ClassGlyph.sim"; 
		// String name="/simple/ClassGlyph2.sim";
		// String name="/simple/ClockTimeTest.sim";
		// String name="/simple/CoroutineSample.sim";
		// String name="/simple/dates.sim";
		// String name="/simple/testdates.sim";
		// String name="/simple/DetachSamples.sim"; 
		// String name="/simple/DecimalEdit.sim"; 
		// String name="/simple/DisplaySamples.sim";
		// String name="/simple/DrawingTest.sim";
		// String name="/simple/Editing.sim";
		// String name="/simple/Expressions.sim";          // MÅ SJEKKES  UNARY  + - + operand
		// String name="/simple/ExternalClass1.sim";
		// String name="/simple/ExternalClass2.sim";
		// String name="/simple/ExternalClass3.sim";
		// String name="/simple/FileSamples.sim";
		// String name="/simple/FittingRoom.sim";
		// String name="/simple/ForWhileSamples.sim";
		// String name="/simple/FunctionCall.sim";
		// String name="/simple/Gauss.sim";
		// String name="/simple/GotoSample0.sim";
		// String name="/simple/GotoSample1.sim";
		// String name="/simple/GotoSample2.sim";
		// String name="/simple/GotoSample3.sim";   // ERROR 
		// String name="/simple/GotoSample4.sim";           // MÅ SJEKKES
		// String name="/simple/GotoSample5.sim";
		// String name="/simple/GotoSample6.sim";   // ERROR
		// String name="/simple/GotoSample7.sim";
		// String name="/simple/GotoSample8.sim";
		// String name="/simple/HashingExample.sim";
		// String name="/simple/HelloWorld.sim";
		// String name="/simple/InfileSample.sim";
		// String name="/simple/InspectionSamples.sim";  
		// String name="/simple/JensensDevice.sim";
		// String name="/simple/LocalObject.sim";
		// String name="/simple/MathSample.sim"; 
		// String name="/simple/MultiAssignments.sim";
		// String name="/simple/ParamSample.sim";
		// String name="/simple/ParamSample2.sim";
		// String name="/simple/ParamSample3.sim";
		// String name="/simple/PrfxBlockSamples.sim";
		// String name="/simple/PriorProcedure.sim";
		// String name="/simple/ProcedureSample.sim";
		// String name="/simple/QPSample0.sim";
		// String name="/simple/QPSample1.sim";
		// String name="/simple/QPSample2.sim";
		// String name="/simple/QPSample3.sim";
		// String name="/simple/QPSample4.sim";
		// String name="/simple/RemoteProcedure.sim";
		// String name="/simple/SubClassTest.sim";
		// String name="/simple/SwitchStatement.sim";
		// String name="/simple/TextSamples.sim";
		// String name="/simple/VariableByName.sim";
		// String name="/simple/VirtualSample.sim";

			// Set options and tracing.
			Option.verbose = true;// false;
			Option.WARNINGS=true;

			// Overall TRACING Options
			Option.TRACING=true;//false;//true;
			Option.BREAKING=true;//false; //true; 

			// Scanner Trace Options
			Option.TRACE_SCAN=false;//true;
			Option.TRACE_COMMENTS=false;//true;

			// Parser Trace Options
			Option.TRACE_PARSE=true;//false;//true;

			// Checker Trace Options
			Option.TRACE_CHECKER=false;//true;
			Option.TRACE_CHECKER_OUTPUT=true;//false;//true;

			// Coder Trace Options
			Option.TRACE_CODING=true;

			// Java Compiler and Jar-tool Trace Options
			Option.TRACE_JAVAC=false;//true;
			Option.TRACE_JAVAC_OUTPUT=false;//true;
			Option.TRACE_JARING=true;//false;//true;

			//String userDir=System.getProperty("user.dir");
			String userDir="C:/GitHub/SimulaCompiler/Simula";
			Global.packetName="simulaTestPrograms";
			Option.keepJava=userDir; // Generated .java Source is then found in Eclipse Package simulaTestPrograms
			Global.simulaRtsLib=userDir+"/bin/"; // To use Eclipse Project's simula.runtime
			Option.outputDir=Global.getTempFileDir("simula/bin/");

			String fileName=userDir+"/src/"+Global.packetName + name;

		SimulaCompiler compiler = new SimulaCompiler(fileName);
		compiler.doCompile();
	}

}
