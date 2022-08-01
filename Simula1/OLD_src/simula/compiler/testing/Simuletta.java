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
import simula.compiler.editor.RTOption;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.runtime.RT;
import simula.runtime.RTObject$.LABQNT$;

/**
 * Simuletta Front-end-Compiler donated by Simula as.
 * 
 * @author Several from Norwegian Computing Center.
 * @author Several from Simula as.
 * @author Øystein Myhre Andersen
 *
 */
public final class Simuletta {

	public static void main(String[] args) {
    	//System.setProperty("file.encoding","UTF-8");
		Vector<String> names=new Vector<String>();
		
		// *** SIMULETTA COMPILER AS TEST BATCH

//		names.add("COMMON.sim");    // END Create .jar File: C:\GitHub\Simula15Loom\Simula15Loom\src\simuletta\bin\Common.jar
//		names.add("OUPTFILE.sim");  // END Create .jar File: C:\GitHub\Simula15Loom\Simula15Loom\src\simuletta\bin\OuptFile.jar
//		names.add("INPTFILE.sim");  // END Create .jar File: C:\GitHub\Simula15Loom\Simula15Loom\src\simuletta\bin\InptFile.jar"
//		names.add("INMODULE.sim");  // END Create .jar File: C:\GitHub\Simula15Loom\Simula15Loom\src\simuletta\bin\InModule.jar
//		names.add("PASS1.sim");     // END Create .jar File: C:\GitHub\Simula15Loom\Simula15Loom\src\simuletta\sim\bin\Pass1.jar
//		names.add("UTMODULE.sim");  // END Create .jar File: C:\GitHub\Simula15Loom\Simula15Loom\src\simuletta\sim\bin\UtModule.jar
//		names.add("PASS2.sim");     // END Create .jar File: C:\GitHub\Simula15Loom\Simula15Loom\src\simuletta\sim\bin\Pass2.jar
		names.add("SIMULETTA.sim"); // END Create .jar File:

		// Set options and tracing.
		Option.verbose = false;//true;// false;
		Option.WARNINGS=true;

		// Overall TRACING Options
		Option.TRACING=true;//false;//true;
		Option.BREAKING=true;//false;//true; 

		// Scanner Trace Options
		Option.TRACE_SCAN=false;//true;
		Option.TRACE_COMMENTS=false;//true;

		// Parser Trace Options
		Option.TRACE_PARSE=false;//true;
		Option.TRACE_ATTRIBUTE_OUTPUT=false;//true;
		Option.TRACE_ATTRIBUTE_INPUT=false;//true;

		// Checker Trace Options
		Option.TRACE_CHECKER=false;//true;
		Option.TRACE_CHECKER_OUTPUT=false;//true;

		// Coder Trace Options
		Option.TRACE_CODING=false; //true;
		
		Option.TRACE_REPAIRING=false;//true;
		
		RTOption.DEBUGGING=true;
		RTOption.USE_CONSOLE=true;
//		RTOption.QPS_TRACING=true;
		

//		File userDir=new File("C:/GitHub/Simula15Loom/Simula15Loom");
		File userDir=new File("C:/GitHub/SimulaCompiler/Simula");
		Global.packetName="simuletta";
		
//		Option.keepJava=userDir; // Generated .java Source is then found in Eclipse Package simulaTestBatch
		Option.keepJava=new File(userDir,""); // Generated .java Source is then found in Eclipse Package simulaTestBatch
		
//		Global.simulaRtsLib=userDir+"/bin/"; // To use Eclipse Project's simula.runtime
		Global.simulaRtsLib=new File(userDir,"bin"); // To use Eclipse Project's simula.runtime

		for(String name:names) {
			String fileName = userDir+"/src/"+Global.packetName+"/sim/"+name;
//			String fileName = userDir+"/src/"+Global.packetName+"/"+name;
	      try { SimulaCompiler compiler = new SimulaCompiler(fileName);
		        compiler.doCompile();
		  }
	      catch(LABQNT$ q) { q.printStackTrace(); }
		  catch(Throwable t) { System.err.println("ERROR: "+t.getMessage()); t.printStackTrace(); }
		}
	}

}
