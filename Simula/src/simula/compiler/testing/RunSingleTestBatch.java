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
import simula.runtime.RTObject$.$LABQNT;

/**
 * Simula Test Batch donated by Simula as.
 * 
 * @author Several from Norwegian Computing Center.
 * @author Several from Simula as.
 * @author Øystein Myhre Andersen
 *
 */
public class RunSingleTestBatch {

	public static void main(String[] args) {
		Vector<String> names=new Vector<String>();
		//names.add("adHoc00.sim"); // For ad'hoc testing
		// *** SIMULA TEST BATCH TIL EKSEKVERING
		// String name=Global.packetName+"/sim/InspectionSamples.sim";
		names.add("simtst01.sim"); // OK:  Meaningless test of conditional statements,
		//names.add("simtst02.sim"); // OK:  Test boolean operators/expressions
		//names.add("simtst03.sim"); // OK:  Test Text Value Relations
		//names.add("simtst04.sim"); // OK:  To test putint and putreal.
		//names.add("simtst05.sim"); // OK:  Test Aritmetisk Relations
		//names.add("simtst06.sim"); // OK:  Test Mathematical Functions
		//names.add("simtst07.sim"); // OK:  Test Mathematical Library
		//names.add("simtst08.sim"); // OK:  Test Scope of Variables.
		//names.add("simtst09.sim"); // OK:  Test relation operator and some Funtions
		//names.add("simtst10.sim"); // OK:  Test Evaluation of Text-Constants

		//names.add("simtst11.sim"); // OK:  Text Attributes constant, start, length, pos and main
		//names.add("simtst12.sim"); // OK:  Text value and reference relations.
		//names.add("simtst13.sim"); // OK:  Text value assignment and text reference assigment.
		//names.add("simtst14.sim"); // OK:  Text attributes: pos, setpos, more, getchar and putchar.
		//names.add("simtst15.sim"); // OK:  Text generation procedures copy and blanks.
		//names.add("simtst16.sim"); // OK:  Standard Text procedures sub and strip.
		//names.add("simtst17.sim"); // OK:  Editing and De-editing
		//names.add("simtst18.sim"); // OK:  The put- and get-procedures for texts.
		//names.add("simtst19.sim"); // OK:  Text concatenation and text expression evaluation.
		//names.add("simtst20.sim"); // OK:  Simple tests: integer relations <, <=, =, >=, > and <>

		//names.add("simtst21.sim"); // OK:  Arrays of simple types and text.
		//names.add("simtst22.sim"); // OK:  Test for-loops with various for-list elements
		//names.add("simtst23.sim"); // OK:  Type conversions in for step-until element.
		//names.add("simtst24.sim"); // OK:  Conditional statements with more complex Boolean expressions.
		//names.add("simtst25.sim"); // OK:  Multiple arithmetic assignment
		//names.add("simtst26.sim"); // OK:  Designational expressions, goto statement and switch declaration.
		//names.add("simtst27.sim"); // OK:  Test while-loops.
		//names.add("simtst28.sim"); // OK:  Paramenter transmission to procedures by value.
		//names.add("simtst29.sim"); // OK:  Procedure parameters by value
		//names.add("simtst30.sim"); // OK:  Name parameters (Modified: 2-dim arrays removed)

		//names.add("simtst31.sim"); // OK:  Labels and switches as parameters to procedures
		//names.add("simtst32.sim"); // OK:  Simple test of formal procedures.
		//names.add("simtst33.sim"); // OK:  Test call by reference
		//names.add("simtst34.sim"); // OK:  Procedures with procedures as parameters.
		//names.add("simtst35.sim"); // OK:  Type procedures as parameters.
		//names.add("simtst36.sim"); // OK:  Jensens Device - call by name.
		//names.add("simtst37.sim"); // OK:  Parameter by name and type conversion
		//names.add("simtst38.sim"); // OK:  Test the value of type procedures.
		//names.add("simtst39.sim"); // OK:  Check that a formal parameter is global to the procedure body.
		//names.add("p40b.sim");     // OK:  Precompile this for Simtst 40.
		//names.add("p40a.sim");     // OK:  Precompile this for Simtst 40.
		//names.add("p40c.sim");     // OK:  Precompile this for Simtst 40.
		//names.add("simtst40.sim"); // OK:  Test separate compilation of procedures.

		//names.add("p41.sim");      // OK:  Precompile this for Simtst 41.
		//names.add("simtst41.sim"); // OK:  Name parameter in external procedure.
		//names.add("simtst42.sim"); // OK:  Compute "n-fac", using iteration within the procedure.
		//names.add("simtst43.sim"); // OK:  Compute "n-fac", using recursion.
		//names.add("simtst44.sim"); // OK:  Test text procedure.
		//names.add("simtst45.sim"); // OK:  Test object relations - is and in.
		//names.add("simtst46.sim"); // OK:  Test the qualification of a function designator.
		//names.add("simtst47.sim"); // OK:  Test of this.
		//names.add("simtst48.sim"); // OK:  Test of qua.
		//names.add("simtst49.sim"); // OK:  For statements in connection blocks.
		//names.add("simtst50.sim"); // OK:  Test binding and qualification in Connection Blocks

		//names.add("simtst51.sim"); // OK:  Test 'inner'.
		//names.add("simtst52.sim"); // OK:  Test 'inner'
		//names.add("simtst53.sim"); // OK:  Syntax check on virtual part
		//names.add("simtst54.sim"); // ERR: Test virtual switches and labels  ERROR - GOTO VIRTUAL LABEL IN INNER PART
		//names.add("simtst55.sim"); // OK:  Test virtual procedures.
		//names.add("simtst56.sim"); // OK:  Test virtual procedures.
		//names.add("simtst57.sim"); // OK:  Virtual procedure - different number of parameters
		//names.add("simtst58.sim"); // OK?: Goto from within a connection into otherwise
		//names.add("c59.sim");      // OK:  Precompile this for Simtst 59.
		//names.add("simtst59.sim"); // ERR: Virtual label in external class.  ERROR - GOTO VIRTUAL LABEL IN INNER PART
		//names.add("simtst60.sim"); // OK:  Visibility of protected attributes.

		//names.add("simtst61.sim"); // OK:  Remote access to attributes which are protected.
		//names.add("simtst62.sim"); // OK:  Test complex use of detach and resume.  Re-trow
		//names.add("simtst63.sim"); // OK:  Transmission by name of reference types. 
		//names.add("simtst64.sim"); // OK:  Parameter transmission by value to classes.
		//names.add("simtst65.sim"); // OK:  Parameter transmission by reference to classes.
		//names.add("simtst66.sim"); // OK:  Test corutines and two infiles which read from the same file.
		//names.add("simtst67.sim"); // OK:  Simple test of detach, call and resume.
		//names.add("simtst68.sim"); // OK:  Test of coroutines.
		//names.add("simtst69.sim"); // OK:  Test complex use of detach, call and resume.
		//names.add("simtst70.sim"); // OK:  Text attributes and relations
		
		//names.add("simtst71.sim"); // OK:  Test visibility of identifiers.
		//names.add("simtst72.sim"); // OK: Test of formal procedures.
		//names.add("simtst73.sim"); // OK:  Test of formal procedures.
		//names.add("simtst74.sim"); // OK:  Test resume and detach.
		//names.add("simtst75.sim"); // OK:  Name parameters and virtual procedures.
		//names.add("simtst76.sim"); // OK:  Test of detach and resume in SIMSET.
		//names.add("simtst77.sim"); // OK:  Two infile objects reading from the same external file.
		//names.add("simtst78.sim"); // OK:  Test the text procedure filename of class file.
		//names.add("simtst79.sim"); // OK:  Test the attribute 'IsOpen' of class file.
		//names.add("simtst80.sim"); // OK:  Test the attribute 'IsOpen' of class file.

		//names.add("simtst81.sim"); // OK:  Test the value of close.
		//names.add("simtst82.sim"); // OK:  Simple test of the operations +, -, *, / and //.
		//names.add("simtst83.sim"); // OK:  Name Parameter with EXTREME BI-EFFECTS
		//names.add("simtst84.sim"); // OK:  Test Printfile.
		//names.add("simtst85.sim"); // OK:  Test Directfile.
		//names.add("Separat.sim");  // OK:  Precompile this for Simtst 86.
		//names.add("simtst86.sim"); // OK?: Reading of real numbers from SYSIN.
		//names.add("simtst87.sim"); // OK: Specification of Virtual Procedures.
		//names.add("simtst88.sim"); // OK:  Visibility of Hidden attributes.
		//names.add("simtst89.sim"); // OK:  Test inbytefile and outbytefile.
		//names.add("simtst90.sim"); // OK:  Test getfrac/putfrac.

		//names.add("simtst91.sim"); // OK:  Test virtual procedures, simple case.
		//names.add("simtst92.sim"); // OK:  Test virtual labels and procedures. ERROR NOT IMPLEMENTED
		//names.add("simtst93.sim"); // OK:  Test Simset - linkage, head, link, into, out, follow and precede
		//names.add("simtst94.sim"); // OK:  Test Simset - first, last, empty, cardinal and clear.
		//names.add("simtst95.sim"); // OK:  Nested declaration of classes and prefixing.
		//names.add("simtst96.sim"); // err: Test SIMULATION, complex example.
		//names.add("simtst97.sim"); // OK:  Test Process, activation statements, idle, terminated, time.
		//names.add("simtst98.sim"); // ERR: Test attribute protection. Test visibility of labels.
		//names.add("simtst99.sim"); // OK:  Test mod, rem, min, max.
		//names.add("simtst100.sim"); // OK: Test that put-get-put delivers the identity.  Uses GOTO/LABEL
		//names.add("simtst101.sim"); // OK:  Test Standard Procedure 'sourceline'.

//		String fileName = "C:/WorkSpaces/SimulaCompiler/Simula/src/" + name;
//		String fileName = "C:/WorkSpaces/SimulaCompiler/Simula/src/"+Global.packetName+"/batch/"+name;

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
		Option.TRACE_PARSE=false;//true;

		// Checker Trace Options
		Option.TRACE_CHECKER=true;//false;//true;
		Option.TRACE_CHECKER_OUTPUT=false;//true;

		// Coder Trace Options
		Option.TRACE_CODING=true;

		// Java Compiler and Jar-tool Trace Options
		Option.TRACE_JAVAC=false;//true;
		Option.TRACE_JAVAC_OUTPUT=false;//true;
		Option.TRACE_JARING=true; //false;//true;

		String userDir=System.getProperty("user.dir");
		Global.simulaRtsLib=userDir+"/bin/";
		Option.keepJava=userDir+"/src/testing";
		Option.outputDir=userDir+"/src/testing/bin/";

		for(String name:names)
		{ String fileName = userDir+"/src/"+Global.packetName+"/batch/"+name;
	      try { SimulaCompiler compiler = new SimulaCompiler(fileName);
		        compiler.doCompile();
		  }
	      catch($LABQNT q) { q.printStackTrace(); }
		  catch(Throwable t) { System.err.println("ERROR: "+t.getMessage()); t.printStackTrace(); }
		}
	}

}
