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
public class TestCompiler {

	public static void main(String[] args) {
		// String name=Global.packetName+"/sim/old/ClassGlyph.sim";
		// String name=Global.packetName+"/sim/old/SubClassSample.sim";
		// String name=Global.packetName+"/sim/old/Sample6.sim";
		// String name=Global.packetName+"/sim/old/Sample7.sim";
		// String name=Global.packetName+"/sim/old/Sample10.sim";
		// String name=Global.packetName+"/sim/old/Sample11.sim";
		// String name=Global.packetName+"/sim/old/NewObject.sim";
		// String name=Global.packetName+"/sim/old/RemoteAccess.sim";
		// String name=Global.packetName+"/sim/old/TypeConversionSamples.sim";
		// String name=Global.packetName+"/sim/old/Scopes.sim";
		// String name=Global.packetName+"/sim/old/SimsetSamples.sim";
		// String name=Global.packetName+"/sim/old/InOutSamples.sim";
		// String name=Global.packetName+"/sim/old/PointPolarSamples.sim";
		// String name=Global.packetName+"/sim/old/MyFileSample.sim";

		// *** STANDARD CLASSES
		// String name=Global.packetName+"/rts/Text.sim";
		// String name=Global.packetName+"/rts/ENVIRONMENT.sim";
		// String name=Global.packetName+"/rts/BASICIO.sim";
		// String name=Global.packetName+"/rts/FILE.sim";
		// String name=Global.packetName+"/rts/ImageFile.sim";
		// String name=Global.packetName+"/rts/InFile.sim";
		// String name=Global.packetName+"/rts/OutFile.sim";
		// String name=Global.packetName+"/rts/PrintFile.sim";
		// String name=Global.packetName+"/rts/DirectFile.sim";
		// String name=Global.packetName+"/rts/ByteFile.sim";
		// String name=Global.packetName+"/rts/InbyteFile.sim";
		// String name=Global.packetName+"/rts/OutbyteFile.sim";
		// String name=Global.packetName+"/rts/DirectByteFile.sim";
		// String name=Global.packetName+"/rts/Simset.sim";
		// String name=Global.packetName+"/rts/Simulation.sim";

		// *** S-PORT MODULER SOM TEST PROGRAMMER
		// String name=Global.packetName+"/sim/FEC_Errmsg.sim";
		// String name=Global.packetName+"/sim/FEC_Scanner.sim";

		// *** SIMULA TEST PROGRAMMER TIL EKSEKVERING
		// String name=Global.packetName+"/sim/adHoc00.sim";
	    // String name=Global.packetName+"/sim/Activation.sim";
	    // String name=Global.packetName+"/sim/ArrayAsParameter.sim";
		// String name=Global.packetName+"/sim/Assignments.sim";

		// String name=Global.packetName+"/sim/Blocks.sim";
		// String name=Global.packetName+"/sim/Blocks2.sim";
		 
		// String name=Global.packetName+"/sim/ClassGlyph.sim";
		// String name=Global.packetName+"/sim/ClassGlyph2.sim";
		// String name=Global.packetName+"/sim/CoroutineSample.sim";
		// String name=Global.packetName+"/sim/DetachSamples.sim"; 
		 String name=Global.packetName+"/sim/DecimalEdit.sim"; 
		// String name=Global.packetName+"/sim/DisplaySamples.sim";
		// String name=Global.packetName+"/sim/Editing.sim";
		// String name=Global.packetName+"/sim/Expressions.sim";
		// String name=Global.packetName+"/sim/ExternalClass1.sim";
		// String name=Global.packetName+"/sim/ExternalClass2.sim";
		// String name=Global.packetName+"/sim/FileSamples.sim";
		// String name=Global.packetName+"/sim/FittingRoom.sim";
		// String name=Global.packetName+"/sim/ForWhileSamples.sim";
		// String name=Global.packetName+"/sim/FunctionCall.sim";
		// String name=Global.packetName+"/sim/Gauss.sim";
		// String name=Global.packetName+"/sim/GotoSamples.sim";
		// String name=Global.packetName+"/sim/HashingExample.sim";
		// String name=Global.packetName+"/sim/HelloWord.sim";
		// String name=Global.packetName+"/sim/InspectionSamples.sim";
		// String name=Global.packetName+"/sim/JensensDevice.sim";
		// String name=Global.packetName+"/sim/MathSample.sim";
		// String name=Global.packetName+"/sim/MultiAssignments.sim";
		// String name=Global.packetName+"/sim/ParamSample.sim";
		// String name=Global.packetName+"/sim/ParamSample2.sim";
		// String name=Global.packetName+"/sim/PrfxBlockSamples.sim";
		// String name=Global.packetName+"/sim/ProcedureSample.sim";
		// String name=Global.packetName+"/sim/QPSample1.sim";
		// String name=Global.packetName+"/sim/QPSample2.sim";
		// String name=Global.packetName+"/sim/QPSample3.sim";
		// String name=Global.packetName+"/sim/RemoteProcedure.sim";
		// String name=Global.packetName+"/sim/Simtest1.sim";
		// String name=Global.packetName+"/sim/SubClassTest.sim";
		// String name=Global.packetName+"/sim/TextSamples.sim";
		// String name=Global.packetName+"/sim/VariableByName.sim";
		// String name=Global.packetName+"/sim/VirtualSample.sim";

			// Set options and tracing.
			Option.verbose = true;// false;
			Option.WARNINGS=true;

			// Overall TRACING Options
			Option.TRACING=true;//false;//true;
			Option.BREAKING=true;//false; //true; 

			// Scanner Trace Options
			Option.TRACE_PREPROCESSOR=false;//true;
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

//		Option.keepJava="C:/WorkSpaces/SimulaCompiler/Simula/src/testing";
//		Option.outputDir="C:/WorkSpaces/SimulaCompiler/Simula/bin/";
//		String fileName = "C:/WorkSpaces/SimulaCompiler/Simula/src/" + name;
			String userDir=System.getProperty("user.dir");
			Global.simulaRtsLib=userDir+"/bin/";         // AD'HOC

			Option.keepJava=userDir+"/src/testing";
//			Option.outputDir=userDir+"/bin/";
			Option.outputDir=userDir+"/src/testing/bin/";
			String fileName=userDir+"/src/" + name;

		SimulaCompiler compiler = new SimulaCompiler(fileName);
		compiler.doCompile();
	}

}
