/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.testing;

import simula.compiler.SimulaCompiler;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class TestBatch {

	static String[] TEST_PROGRAMS={

			// *** SIMULA TEST PROGRAMMER TIL EKSEKVERING
			"simula/test/sim/ArrayAsParameter.sim",
			"simula/test/sim/Assignments.sim",
			"simula/test/sim/Blocks.sim",
			"simula/test/sim/CoroutineSample.sim",
			"simula/test/sim/DisplaySamples.sim",
			"simula/test/sim/FileSamples.sim",
			"simula/test/sim/ForWhileSamples.sim",
			"simula/test/sim/FunctionCall.sim", //CHECK DENNE
			"simula/test/sim/ClassGlyph.sim",
			"simula/test/sim/Gauss.sim",
			"simula/test/sim/GotoSamples.sim",
			"simula/test/sim/HashingExample.sim",
			"simula/test/sim/HelloWord.sim",
			"simula/test/sim/InspectionSamples.sim",
			"simula/test/sim/JensensDevice.sim",
			"simula/test/sim/MathSample.sim",
			"simula/test/sim/ParamSample.sim",
			"simula/test/sim/ParamSample2.sim",
			"simula/test/sim/ProcedureSample.sim",
			"simula/test/sim/RemoteProcedure.sim",
			"simula/test/sim/TextSamples.sim",
			"simula/test/sim/VariableByName.sim",
			"simula/test/sim/VirtualSample.sim",
	};
			
			
	static String[] OLDIES={
		// OLDIES
//		"simula/test/sim/old/SubClassSample.sim",
//		"simula/test/sim/old/Sample6.sim",
//		"simula/test/sim/old/Sample7.sim",
//		"simula/test/sim/old/Sample10.sim",
//		"simula/test/sim/old/Sample11.sim",
//		"simula/test/sim/old/NewObject.sim",
//		"simula/test/sim/old/RemoteAccess.sim",
//		"simula/test/sim/old/TypeConversionSamples.sim",
//		"simula/test/sim/old/Scopes.sim",
//		"simula/test/sim/old/SimsetSamples.sim",
//		"simula/test/sim/old/InOutSamples.sim",
//		"simula/test/sim/old/PointPolarSamples.sim",
//		"simula/test/sim/old/MyFileSample.sim",

	};
	
		static String[] STANDARD_CLASSES={
		"simula/test/rts/Text.sim",
		"simula/test/rts/ENVIRONMENT.sim",
		"simula/test/rts/BASICIO.sim",
		"simula/test/rts/FILE.sim",
		"simula/test/rts/ImageFile.sim",
		"simula/test/rts/InFile.sim",
		"simula/test/rts/OutFile.sim",
		"simula/test/rts/PrintFile.sim",
		"simula/test/rts/DirectFile.sim",
		"simula/test/rts/ByteFile.sim",
		"simula/test/rts/InbyteFile.sim",
		"simula/test/rts/OutbyteFile.sim",
		"simula/test/rts/DirectByteFile.sim",
		"simula/test/rts/Simset.sim",
		"simula/test/rts/Simulation.sim",

		// *** S-PORT MODULER SOM TEST PROGRAMMER
//		"simula/test/sim/FEC_Errmsg.sim",
//		"simula/test/sim/FEC_Scanner.sim"
		};

		public static void doCompile(String[] names) {
		    for(int i=0;i<names.length;i++)
		    {  String fileName = "C:/WorkSpaces/SimulaCompiler/Simula/src/" + names[i];
			  SimulaCompiler compiler = new SimulaCompiler(fileName);
			  compiler.doCompile();
		    }
		}

	public static void main(String[] args) {
    	//System.setProperty("file.encoding","UTF-8");
		Option.BREAKING=false;
		doCompile(TEST_PROGRAMS);
//		doCompile(OLDIES);
//		doCompile(STANDARD_CLASSES);
		Util.println("*** SIMULA TESTBATCH TERMINATES NORMALLY");
	}

}
