/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package test.java;

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
public final class RunSimulaSample {

	public static void main(String[] args) {
    	//System.setProperty("file.encoding","UTF-8");

		// *** SIMULA PROGRAMMER TIL RELEASE TESTING
//		 String name="AnimationTest.sim";
//		 String name="Atkins.sim";
//		 String name="Dates.sim";
//		 String name="DatesTest.sim";
//		 String name="Docking.sim";
//		 String name="FittingRoom.sim";
//		 String name="HelloWorld.sim";
//		 String name="HexDump.sim";
//		 String name="InfectionDisease.sim";
//		 String name="JensensDevice.sim";
		 String name="LiftSimulation.sim";
//		 String name="PrimeUnder.sim";
//		 String name="Quine.sim";
//		 String name="Sudoku.sim";
//		 String name="SudokuPuzzle.sim";
//		 String name="TQueens.sim";

			// Set Compile Time Options and tracing.
			Option.INLINE_TESTING=true;
//		    Option.verbose = true;
//			Option.WARNINGS=true;
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
//			Option.PRINT_SYNTAX_TREE=true;
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
			
//			Option.USE_FILE_CLASS_API=1;
//			Option.TRACE_REPAIRING=true;
//			Option.LIST_REPAIRED_INSTRUCTION_LIST=true;
//			Option.TRACE_BYTECODE_OUTPUT=true;
//			Option.DEBUGGING=true;

//			File simulaHome=new File("C:/GitHub/SimulaCompiler/TestBatch");
			File simulaDir=new File("C:/GitHub/SimulaCompiler/Simula");
			File userDir=new File("C:/GitHub/SimulaCompiler/SimulaTestBatch");
			
			
			Global.packetName="simulaSamples";
//			Option.keepJava=userDir; // Generated .java Source is then found in Eclipse Package simulaTestPrograms
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

			String fileName=userDir+"/src/"+Global.packetName + '/' + name;
			Option.RUNTIME_USER_DIR=new File(fileName).getParent();
			
			Simula.setSelectors("ZD");

		SimulaCompiler compiler = new SimulaCompiler(fileName);
		try { compiler.doCompile(); } catch (IOException e) { Util.IERR("Compiler Error: ", e); }
	}


}
