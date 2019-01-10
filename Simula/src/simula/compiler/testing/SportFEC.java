/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.testing;

import java.util.Vector;

import simula.compiler.SimulaCompiler;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.runtime.RTObject$.LABQNT$;

/**
 * Simula Front-end-Compiler donated by Simula as.
 * 
 * @author Several from Norwegian Computing Center.
 * @author Several from Simula as.
 * @author Øystein Myhre Andersen
 *
 */
public final class SportFEC {

	public static void main(String[] args) {
		Vector<String> names=new Vector<String>();
		//names.add("adHoc00.sim"); // For ad'hoc testing
		// *** SIMULA TEST BATCH TIL EKSEKVERING
		// String name=Global.packetName+"/sim/InspectionSamples.sim";
//		names.add("COMMON.DEF");
//		names.add("ERRMSG.DEF");
//		names.add("SCANNER.DEF");
//		names.add("SCANINP.DEF");
//		names.add("PARSER.DEF");
//		names.add("PAS1INIT.DEF");
//		names.add("BUILDER1.DEF");
//		names.add("BUILDER2.DEF");
//		names.add("CHECKER1.DEF");
//		names.add("CHECKER2.DEF");
		names.add("SCODER0.DEF");
		
//		names.add("SCANNER.DEF");
//		names.add("SCANNER.DEF");
//		names.add("SCANNER.DEF");
//		names.add("SCANNER.DEF");
//		names.add("SCANNER.DEF");
//		names.add("SCANNER.DEF");
//		names.add("SCANNER.DEF");
//		names.add("SCANNER.DEF");
//		names.add("SCANNER.DEF");
//		names.add("SCANNER.DEF");

//		String fileName = "C:/WorkSpaces/SimulaCompiler/Simula/src/" + name;
//		String fileName = "C:/WorkSpaces/SimulaCompiler/Simula/src/"+Global.packetName+"/batch/"+name;

		// Set options and tracing.
		Option.verbose = true;// false;
		Option.WARNINGS=true;

		// Overall TRACING Options
		Option.TRACING=true;//false;//true;
		Option.BREAKING=true;//false;//true; 

		// Scanner Trace Options
		Option.TRACE_SCAN=false;//true;
		Option.TRACE_COMMENTS=false;//true;

		// Parser Trace Options
		Option.TRACE_PARSE=false;//true;

		// Checker Trace Options
		Option.TRACE_CHECKER=false;//true;
		Option.TRACE_CHECKER_OUTPUT=false;//true;

		// Coder Trace Options
		Option.TRACE_CODING=false; //true;

		// Java Compiler and Jar-tool Trace Options
		Option.TRACE_JAVAC=false;//true;
		Option.TRACE_JAVAC_OUTPUT=false;//true;
		Option.TRACE_JARING=false;//true;

		String userDir=System.getProperty("user.dir");
		Global.simulaRtsLib=userDir+"/bin/";
		Global.packetName="sportFEC";
		Option.keepJava=userDir+"/src/"+Global.packetName;
		Option.outputDir=userDir+"/src/"+Global.packetName+"/bin/";

		for(String name:names)
		{ String fileName = userDir+"/src/"+Global.packetName+"/sim/"+name;
	      try { SimulaCompiler compiler = new SimulaCompiler(fileName);
		        compiler.doCompile();
		  }
	      catch(LABQNT$ q) { q.printStackTrace(); }
		  catch(Throwable t) { System.err.println("ERROR: "+t.getMessage()); t.printStackTrace(); }
		}
	}

}
