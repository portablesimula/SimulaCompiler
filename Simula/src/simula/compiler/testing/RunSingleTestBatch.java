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
		//names.add("simtst01.sim"); // OK:  Meaningless test of conditional statements,
		//names.add("simtst02.sim"); // OK:  Test boolean operators/expressions
		//names.add("simtst03.sim"); // OK:  Test Text Value Relations
		//names.add("simtst04.sim"); // err: To test putint and putreal.
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
		//names.add("simtst22.sim"); // ERR: Test for-loops with various for-list elements
		//names.add("simtst23.sim"); // OK:  Type conversions in for step-until element.
		//names.add("simtst24.sim"); // OK:  Conditional statements with more complex Boolean expressions.
		//names.add("simtst25.sim"); // OK:  Multiple arithmetic assignment
		//names.add("simtst26.sim"); // err: Designational expressions, goto statement and switch declaration.
		//names.add("simtst27.sim"); // OK:  Test while-loops.
		//names.add("simtst28.sim"); // ERR: Paramenter transmission to procedures by value. USES 3-DIM ARRAY-PARAMETERS
		//names.add("simtst29.sim"); // err: Procedure parameters by value  USES 2-DIM ARRAY-PARAMETERS
		//names.add("simtst30.sim"); // OK:  Name parameters (Modified: 2-dim arrays removed)

		//names.add("simtst31.sim"); // ERR: Labels and switches as parameters to procedures
		//names.add("simtst32.sim"); // OK:  Simple test of formal procedures.
		//names.add("simtst33.sim"); // err: Test call by reference (Uses: 3-dim arrays)
		//names.add("simtst34.sim"); // OK:  Procedures with procedures as parameters.
		//names.add("simtst35.sim"); // OK:  Type procedures as parameters.
		names.add("simtst36.sim"); // err: Jensens Device - call by name. TRENGER FIN-TESTING
		//names.add("simtst37.sim"); // OK:  Parameter by name and type conversion
		//names.add("simtst38.sim"); // OK:  Test the value of type procedures.
		//names.add("simtst39.sim"); // err: Check that a formal parameter is global to the procedure body.
		//names.add("simtst40.sim"); // err: Test separate compilation of procedures.

		//names.add("simtst41.sim"); // err: Name parameter in external procedure.
		//names.add("simtst42.sim"); // OK:  Compute "n-fac", using iteration within the procedure.
		//names.add("simtst43.sim"); // OK:  Compute "n-fac", using recursion.
		//names.add("simtst44.sim"); // OK:  Test text procedure.
		//names.add("simtst45.sim"); // OK:  Test object relations - is and in.
		//names.add("simtst46.sim"); // OK:  Test the qualification of a function designator.
		//names.add("simtst47.sim"); // OK:  Test of this.
		//names.add("simtst48.sim"); // OK:  Test of qua.
		//names.add("simtst49.sim"); // ERR: For statements in connection blocks.
		//names.add("simtst50.sim"); // ERR: Test binding and qualification in Connection Blocks

		//names.add("simtst51.sim"); // OK:  Test 'inner'.
		//names.add("simtst52.sim"); // OK:  Test 'inner'
		//names.add("simtst53.sim"); // OK:  Syntax check on virtual part
		//names.add("simtst54.sim"); // ERR: Test virtual switches and labels
		//names.add("simtst55.sim"); // OK:  Test virtual procedures.
		//names.add("simtst56.sim"); // OK:  Test virtual procedures.
		//names.add("simtst57.sim"); // OK:  Virtual procedure - different number of parameters
		//names.add("simtst58.sim"); // OK?: Goto from within a connection into otherwise
		//names.add("simtst59.sim"); // ERR: Virtual label in external class.
		//names.add("simtst60.sim"); // ERR: Visibility of protected attributes.

		//names.add("simtst61.sim"); // ERR: Remote access to attributes which are protected.
		//names.add("simtst62.sim"); // OK:  Test complex use of detach and resume.
		//names.add("simtst63.sim"); // OK:  Transmission by name of reference types. 
		//names.add("simtst64.sim"); // ERR: Parameter transmission by value to classes. MYE FEIL MED ARRAY as Parameter
		//names.add("simtst65.sim"); // ERR: Parameter transmission by reference to classes. FEIL med 2-DIM ARRAY
		//names.add("simtst66.sim"); // ERR: Test corutines and two infiles which read from the same file.
		//names.add("simtst67.sim"); // OK:  Simple test of detach, call and resume.
		//names.add("simtst68.sim"); // ERR: Test of coroutines. VIRKER 'NESTEN' - MÅ FINTESTES
		//names.add("simtst69.sim"); // ERR: Test complex use of detach, call and resume.
		//names.add("simtst70.sim"); // OK:  Text attributes and relations
		
		//names.add("simtst71.sim"); // OK:   Test visibility of identifiers.
		//names.add("simtst72.sim"); // err: Test of formal procedures. TRENGER FIN-TESTING
		//names.add("simtst73.sim"); // OK:  Test of formal procedures.
		//names.add("simtst74.sim"); // OK:  Test resume and detach.
		//names.add("simtst75.sim"); // OK:  Name parameters and virtual procedures.
		//names.add("simtst76.sim"); // ERR: Test of detach and resume in SIMSET.
		//names.add("simtst77.sim"); // ERR: Two infile objects reading from the same external file.
		//names.add("simtst78.sim"); // ERR: Test the text procedure filename of class file.
		//names.add("simtst79.sim"); // ERR: Test the attribute 'IsOpen' of class file.
		//names.add("simtst80.sim"); // ERR: Test the attribute 'IsOpen' of class file.

		//names.add("simtst81.sim"); // ERR: Test the value of close.
		//names.add("simtst82.sim"); // ERR: Simple test of the operations +, -, *, / and //.
		//names.add("simtst83.sim"); // ERR: Type procedures as attributes to class, and dot access.
		//names.add("simtst84.sim"); // ERR: Test Printfile.
		//names.add("simtst85.sim"); // ERR: Test Directfile.
		//names.add("simtst86.sim"); // OK?: Reading of real numbers from SYSIN.
		//names.add("simtst87.sim"); // ERR: Test SIMULATION, simple example.
		//names.add("simtst88.sim"); // OK?: Checking coroutines.
		//names.add("simtst89.sim"); // ERR: Test inbytefile and outbytefile.
		//names.add("simtst90.sim"); // ERR: Test getfrac/putfrac.

		//names.add("simtst91.sim"); // OK:  Test virtual procedures, simple case.
		//names.add("simtst92.sim"); // ERR: Test virtual labels and procedures.
		//names.add("simtst93.sim"); // OK:  Test Simset - linkage, head, link, into, out, follow and precede
		//names.add("simtst94.sim"); // OK:  Test Simset - first, last, empty, cardinal and clear.
		//names.add("simtst95.sim"); // OK:  Nested declaration of classes and prefixing.
		//names.add("simtst96.sim"); // ERR: Test SIMULATION, complex example.
		//names.add("simtst97.sim"); // ERR: Test Process, activation statements, idle, terminated, time.
		//names.add("simtst98.sim"); // ERR: Test attribute protection. Test visibility of labels.
		//names.add("simtst99.sim"); // ERR:
		//names.add("simtst00.sim"); // ERR: Test that put-get-put delivers the identity.

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
		Option.TRACE_CHECKER=false;//true;
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
		  SimulaCompiler compiler = new SimulaCompiler(fileName);
		  compiler.doCompile();
		}
	}

}
