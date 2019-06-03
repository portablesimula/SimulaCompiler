/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.testing;

import java.io.File;
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
    	//System.setProperty("file.encoding","UTF-8");
		Vector<String> names=new Vector<String>();
		
		// *** SIMULA S-PORT COMPILER AS TEST BATCH

//		names.add("COMMON.DEF");  // END Create .jar File: C:\Users\YSTEIN~1\AppData\Local\Temp\simula\bin\COMMON.jar 
//		names.add("ERRMSG.DEF");  // END Create .jar File: C:\Users\YSTEIN~1\AppData\Local\Temp\simula\bin\ERRMSG.jar 
		names.add("SCANNER.DEF"); // END Create .jar File: C:\Users\YSTEIN~1\AppData\Local\Temp\simula\bin\SCANNER.jar 
		names.add("SCANINP.DEF"); // END Create .jar File: C:\Users\YSTEIN~1\AppData\Local\Temp\simula\bin\SCANINP.jar 
		names.add("PARSER.DEF");
		names.add("PAS1INIT.DEF");
		names.add("BUILDER1.DEF");
		names.add("BUILDER2.DEF"); // END Create .jar File: C:\Users\YSTEIN~1\AppData\Local\Temp\simula\bin\BUILDER2.jar
		names.add("CHECKER1.DEF"); // END Create .jar File: C:\Users\YSTEIN~1\AppData\Local\Temp\simula\bin\CHECKER1.jar
		names.add("CHECKER2.DEF"); // END Create .jar File: C:\Users\YSTEIN~1\AppData\Local\Temp\simula\bin\CHECKER2.jar
		names.add("SCODER0.DEF"); // Stopper fordi  %MACRO  ikke er implementert
		
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
		
		Option.TRACE_REPAIRING=true;
		

		File userDir=new File("C:/GitHub/SimulaCompiler/Simula");
		Global.packetName="sportFEC";
		Option.keepJava=userDir; // Generated .java Source is then found in Eclipse Package simulaTestBatch
//		Global.simulaRtsLib=userDir+"/bin/"; // To use Eclipse Project's simula.runtime
		Global.simulaRtsLib=new File(userDir,"bin"); // To use Eclipse Project's simula.runtime

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
