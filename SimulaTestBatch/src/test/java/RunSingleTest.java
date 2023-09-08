/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package test.java;

import java.io.File;
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
public final class RunSingleTest {
	private static final File simulaDir=new File("C:/GitHub/SimulaCompiler/Simula");
	private static final File userDir=new File("C:/GitHub/SimulaCompiler/SimulaTestBatch");
	private static final String sourceDir = userDir+"/src/simulaTestBatch/";
	private static final String testBatchJarDir = userDir+"/src/simulaTestBatch/bin/";

	public static void main(String[] args) {
    	//System.setProperty("file.encoding","UTF-8");
		Vector<String> names=new Vector<String>();
//		names.add("adHoc00.sim"); // For ad'hoc testing
//		names.add("adHoc01.sim"); // For ad'hoc testing
		// *** SIMULA TEST BATCH TIL EKSEKVERING
		// String name=Global.packetName+"/sim/InspectionSamples.sim";
		names.add("SimulaTest.sim"); // Simula TestBatch Framework
//		names.add("simtst01.sim"); // OK:  Meaningless test of conditional statements,
//		names.add("simtst02.sim"); // OK:  Test boolean operators/expressions
//		names.add("simtst03.sim"); // OK:  Test Text Value Relations
//		names.add("simtst04.sim"); // OK:  To test putint and putreal.
//		names.add("simtst05.sim"); // OK:  Test Aritmetisk Relations
//		names.add("simtst06.sim"); // OK:  Test Mathematical Functions
//		names.add("simtst07.sim"); // OK:  Test Mathematical Library
//		names.add("simtst08.sim"); // OK:  Test Scope of Variables.
//		names.add("simtst09.sim"); // OK:  Test relation operator and some Funtions
//		names.add("simtst10.sim"); // OK:  Test Evaluation of Text-Constants
//
//		names.add("simtst11.sim"); // OK:  Text Attributes constant, start, length, pos and main
//		names.add("simtst12.sim"); // OK:  Text value and reference relations.
//		names.add("simtst13.sim"); // OK:  Text value assignment and text reference assigment.
//		names.add("simtst14.sim"); // OK:  Text attributes: pos, setpos, more, getchar and putchar.
//		names.add("simtst15.sim"); // OK:  Text generation procedures copy and blanks.
//		names.add("simtst16.sim"); // OK:  Standard Text procedures sub and strip.
//		names.add("simtst17.sim"); // OK:  Editing and De-editing
//		names.add("simtst18.sim"); // OK:  The put- and get-procedures for texts.
//		names.add("simtst19.sim"); // OK:  Text concatenation and text expression evaluation.
//		names.add("simtst20.sim"); // OK:  Simple tests: integer relations <, <=, =, >=, > and <>
//
//		names.add("simtst21.sim"); // OK:  Arrays of simple types and text.
//		names.add("simtst22.sim"); // OK:  Test for-loops with various for-list elements
//		names.add("simtst23.sim"); // OK:  Type conversions in for step-until element.
//		names.add("simtst24.sim"); // OK:  Conditional statements with more complex Boolean expressions.
//		names.add("simtst25.sim"); // OK:  Multiple arithmetic assignment
//		names.add("simtst26.sim"); // OK:  Designational expressions, goto statement and switch declaration.
//		names.add("simtst27.sim"); // OK:  Test while-loops.
//		names.add("simtst28.sim"); // OK:  Paramenter transmission to procedures by value.
//		names.add("simtst29.sim"); // OK:  Procedure parameters by value
//		names.add("simtst30.sim"); // OK:  Name parameters (Modified: 2-dim arrays removed)
//
//		names.add("simtst31.sim"); // OK:  Labels and switches as parameters to procedures
//		names.add("simtst32.sim"); // OK:  Simple test of formal procedures.
//		names.add("simtst33.sim"); // OK:  Test call by reference
//		names.add("simtst34.sim"); // OK:  Procedures with procedures as parameters.
//		names.add("simtst35.sim"); // OK:  Type procedures as parameters.
//		names.add("simtst36.sim"); // OK:  Jensens Device - call by name.
//		names.add("simtst37.sim"); // OK:  Parameter by name and type conversion
//		names.add("simtst38.sim"); // OK:  Test the value of type procedures.
//		names.add("simtst39.sim"); // OK:  Check that a formal parameter is global to the procedure body.
//		names.add("p40b.sim");     // OK:  Precompile this for Simtst 40.
//		names.add("p40a.sim");     // OK:  Precompile this for Simtst 40.
//		names.add("p40c.sim");     // OK:  Precompile this for Simtst 40.
//		names.add("simtst40.sim"); // OK:  Test separate compilation of procedures.
//
//		names.add("p41.sim");      // OK:  Precompile this for Simtst 41.
//		names.add("simtst41.sim"); // OK:  Name parameter in external procedure.
//		names.add("simtst42.sim"); // OK:  Compute "n-fac", using iteration within the procedure.
//		names.add("simtst43.sim"); // OK:  Compute "n-fac", using recursion.
//		names.add("simtst44.sim"); // OK:  Test text procedure.
//		names.add("simtst45.sim"); // OK:  Test object relations - is and in.
//		names.add("simtst46.sim"); // OK:  Test the qualification of a function designator.
//		names.add("simtst47.sim"); // OK:  Test of this.
//		names.add("simtst48.sim"); // OK:  Test of qua.
//		names.add("simtst49.sim"); // OK:  For statements in connection blocks.
//		names.add("simtst50.sim"); // OK:  Test binding and qualification in Connection Blocks
//
//		names.add("simtst51.sim"); // OK:  Test 'inner'.
//		names.add("simtst52.sim"); // OK:  Test 'inner'         Scanning past END-OF-FILE
//		names.add("simtst53.sim"); // OK:  Syntax check on virtual part
//		names.add("simtst54.sim"); // OK: A VERY Simple Simulation
//		names.add("simtst55.sim"); // OK:  Test virtual procedures.
//		names.add("simtst56.sim"); // OK:  Test virtual procedures.
//		names.add("simtst57.sim"); // OK:  Virtual procedure - different number of parameters
//		names.add("simtst58.sim"); // OK?: Goto from within a connection into otherwise
//		names.add("simtst59.sim"); // OK: Test 2-dim Array by value.
//		names.add("simtst60.sim"); // OK:  Visibility of protected attributes.
//
//		names.add("simtst61.sim"); // OK:  Remote access to attributes which are protected.
//		names.add("simtst62.sim"); // OK:  Test complex use of detach and resume.  Re-trow
//		names.add("simtst63.sim"); // OK:  Transmission by name of reference types. 
//		names.add("simtst64.sim"); // OK:  Parameter transmission by value to classes.
//		names.add("simtst65.sim"); // OK:  Parameter transmission by reference to classes.
//		names.add("simtst66.sim"); // OK:  Test coroutines and two infiles which read from the same file.
//		names.add("simtst67.sim"); // OK:  Simple test of detach, call and resume.
//		names.add("simtst68.sim"); // OK:  Test of coroutines.
//		names.add("simtst69.sim"); // OK:  Test complex use of detach, call and resume.
//		names.add("simtst70.sim"); // OK:  Text attributes and relations
//		
//		names.add("simtst71.sim"); // OK:  Test visibility of identifiers.
//		names.add("simtst72.sim"); // OK:  Test of formal procedures.
//		names.add("simtst73.sim"); // OK:  Test of formal procedures.
//		names.add("simtst74.sim"); // OK:  Test resume and detach.
//		names.add("simtst75.sim"); // OK:  Name parameters and virtual procedures.
//		names.add("simtst76.sim"); // OK:  Test of detach and resume in SIMSET.
//		names.add("simtst77.sim"); // OK:  Two infile objects reading from the same external file.
//		names.add("simtst78.sim"); // OK:  Test the text procedure filename of class file.
//		names.add("simtst79.sim"); // OK:  Test the attribute 'IsOpen' of class file.
//		names.add("simtst80.sim"); // OK:  Test the attribute 'IsOpen' of class file.
//
//		names.add("simtst81.sim"); // OK:  Test the value of close.
//		names.add("simtst82.sim"); // OK:  Simple test of the operations +, -, *, / and //.
//		names.add("simtst83.sim"); // OK:  Name Parameter with EXTREME BI-EFFECTS
//		names.add("simtst84.sim"); // OK:  Test DirectBytefile.
//		names.add("simtst85.sim"); // OK:  Test Directfile.
//		names.add("Separat.sim");  // OK:  Precompile this for Simtst 86.
//		names.add("simtst86.sim"); // OK?: Reading of real numbers from SYSIN.
//		names.add("simtst87.sim"); // OK:  Specification of Virtual Procedures.
//		names.add("simtst88.sim"); // OK:  Visibility of Hidden attributes.
//		names.add("simtst89.sim"); // OK:  Test inbytefile and outbytefile.
//		names.add("simtst90.sim"); // OK:  Test getfrac/putfrac.
//
//		names.add("simtst91.sim"); // OK:  Test virtual procedures, simple case.
//		names.add("simtst92.sim"); // OK: Test 1-dim Array by value.
//		names.add("simtst93.sim"); // OK:  Test Simset - linkage, head, link, into, out, follow and precede
//		names.add("simtst94.sim"); // OK:  Test Simset - first, last, empty, cardinal and clear.
//		names.add("simtst95.sim"); // OK:  Test Environment Interface.
//		names.add("simtst96.sim"); // OK:  Test hidden, protected attributes.
//		names.add("simtst97.sim"); // OK:  Test nested hidden and protected.
//		names.add("simtst98.sim"); // OK:  Test attribute protection - complex example. Test visibility of labels.
//		names.add("simtst99.sim"); // OK:  Test mod, rem, min, max.
//		names.add("simtst100.sim"); // OK: Test that put-get-put delivers the identity.  Uses GOTO/LABEL
//
//		names.add("simtst101.sim"); // OK:  Test Standard Procedure 'sourceline'.
//		names.add("simtst102.sim"); // OK: GOTO out of an operating Process
//		names.add("simtst103.sim"); // OK: All kinds of Activation Statements
//		names.add("simtst104.sim"); // OK: Procedure parameter 'F' by name.
//		names.add("simtst105.sim"); // OK: Multiple assignments.
//		names.add("simtst106.sim"); // ERR: Test SIMULATION, complex example.
//		names.add("simtst107.sim"); // OK:  Test Process, activation statements, idle, terminated, time.
//		names.add("simtst108.sim"); // OK: Simple Co-Routine Sample 1: detach - call
//		names.add("simtst109.sim"); // OK: Simple Co-Routine Sample 2: detach - resume
//		names.add("simtst110.sim"); // OK: Simple Co-Routine Sample 3: detach - resume - chain
//
//		names.add("simtst111.sim"); // OK: Virtual Label Sample 1
//		names.add("simtst112.sim"); // OK: Virtual Label Sample 2
		names.add("simtst113.sim"); // OK: Virtual Switch Sample 1
//		names.add("simtst114.sim"); // OK: Switch Statement
//		names.add("simtst115.sim"); // OK: Simple QPS-Sample 1
//		names.add("simtst116.sim"); // OK: Simple QPS-Sample 2
//		names.add("simtst117.sim"); // OK: Simple QPS-Sample 3
//		names.add("simtst118.sim"); // OK: Simple QPS-Sample 4
//		names.add("ExternalClass1.sim");      // OK:  Precompile this for Simtst 119.
//		names.add("ExternalClass2.sim");      // OK:  Precompile this for Simtst 119.
//		names.add("simtst119.sim"); // OK: Uses EcternalClass1-2
//		names.add("simtst120.sim"); // OK: VERY LOCAL GOTO SAMPLE
//
//		names.add("simtst121.sim"); // OK: LEGAL GOTO out of an operating Process and the enclosing System.
//		names.add("simtst122.sim"); // OK: GOTO LABEL IN SUPER CLASS
//		names.add("simtst123.sim"); // OK: GOTO VIRTUAL LABEL
//		names.add("simtst124.sim"); // OK: GOTO VIRTUAL LABEL
//		names.add("simtst125.sim"); // OK: GOTO LABEL WITHIN NESTED COMPOUND STATEMENTS
//		names.add("simtst126.sim"); // OK: GOTO SIMPLE SWITCH
//		names.add("simtst127.sim"); // OK: Switch (character) Statement
//		names.add("simtst128.sim"); // OK: Standard Procedure edit and edfix
//		names.add("Precompiled129.sim"); // OK: Precompile this for Simtst 129.
//		names.add("simtst129.sim"); // OK: Switch in precompiled class
//		names.add("simtst130.sim"); // OK: Class SimLib, a set of utility procedures from DEC Handbook.
//
//		names.add("simtst131.sim"); // OK: Catching Errors
//		names.add("simtst132.sim"); // OK: SPORT Options
//		names.add("simtst133.sim"); // OK: Test infile reading with inimage and inrecord.
//		names.add("simtst134.sim"); // OK: Outfile with CREATE, APPEND, SYNCHRONOUS and PURGE.
//		names.add("simtst135.sim"); // OK: OutBytefile with CREATE, APPEND, SYNCHRONOUS and PURGE.
//		names.add("simtst136.sim"); // OK: Directfile with CREATE, APPEND, SYNCHRONOUS and PURGE.
//		names.add("simtst137.sim"); // OK: DirectBytefile with CREATE, APPEND, SYNCHRONOUS and PURGE.
//		names.add("simtst138.sim"); // OK: ref() and Real type Arrays.
//		
//		names.add("RT_ErrorTest.sim"); // Simula TestBatch Framework
//		names.add("simerr01.sim"); // OK: ILLEGAL GOTO out of an operating Process and into the enclosing System.
//		names.add("simerr02.sim"); // OK: Testing NONE-CHECK
//		names.add("PrecompiledClass.sim"); // OK: Used by simerr03
//		names.add("simerr03.sim"); // OK: Division by Zero in Precompiled Class 
//		names.add("PrecompiledProcedure.sim"); // OK: Used by simerr04
//		names.add("simerr04.sim"); // OK: Division by Zero in Precompiled Procedure
//		names.add("simerr05.sim"); // OK: NumberFormatException
//		names.add("simerr06.sim"); // OK: ArrayIndexOutOfBounds
//		names.add("simerr07.sim"); // OK: Wrong number of paramerters to virtual procedure
//		names.add("simerr08.sim"); // OK: Illegal assignment. Name parameter is not a variable
//		names.add("simerr09.sim"); // OK: Read/write access on DirectFile and DirectByteFile

		// Set options and tracing.
		Option.INLINE_TESTING=true;
		Option.SPORT=true;
//		Option.verbose = true;
		Option.WARNINGS=true;
//		Option.DEBUGGING=true;
//		Option.EXTENSIONS=false;
		Option.CaseSensitive=true;

		// Overall TRACING Options
//		Option.TRACING=true;

		// Scanner Trace Options
//		Option.TRACE_SCAN=true;
//		Option.TRACE_COMMENTS=true;

		// Parser Trace Options
//		Option.TRACE_PARSE=true;
//		Option.PRINT_SYNTAX_TREE=true;
//		Option.TRACE_ATTRIBUTE_OUTPUT=true;
//		Option.TRACE_ATTRIBUTE_INPUT=true;

		// Checker Trace Options
//		Option.TRACE_FIND_MEANING=4;
//		Option.TRACE_CHECKER=true;
//		Option.TRACE_CHECKER_OUTPUT=true;

		// Coder Trace Options
//		Option.TRACE_CODING=true;
		Option.GNERATE_LINE_CALLS=true;

		// Byte code engineering Options
//		Option.USE_FILE_CLASS_API=1;
//		Option.LIST_INPUT_INSTRUCTION_LIST=true;
//		Option.LIST_REPAIRED_INSTRUCTION_LIST=true;
//		Option.TRACE_REPAIRING_INPUT=true;
//		Option.TRACE_REPAIRING=true;
//		Option.TRACE_REPAIRING_OUTPUT=true;

		Global.packetName="simulaTestBatch";
//		Option.keepJava=userDir; // Generated .java Source is then found in Eclipse Package simulaTestBatch
		Global.simulaRtsLib=new File(simulaDir,"bin"); // To use Eclipse Project's simula.runtime
//		Global.extLib="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/sim/bin";
		
		// Set RunTime Options and tracing.
//		RTOption.VERBOSE = true;
//		RTOption.USE_CONSOLE=true;
//		RTOption.BLOCK_TRACING = true;
//		RTOption.GOTO_TRACING = true;
//		RTOption.QPS_TRACING = true;
//		RTOption.SML_TRACING = true;
//		Option.RUNTIME_USER_DIR = "C:/GitHub/SimulaCompiler/TestBatch/";
		
		
		for(String name:names) {
			String fileName = sourceDir+name;
//			Option.RUNTIME_USER_DIR=new File(fileName).getParent();
			try { SimulaCompiler compiler = new SimulaCompiler(fileName);
				  compiler.doCompile();
			}
			catch(Throwable t) { System.err.println("ERROR: "+t.getMessage()); t.printStackTrace(); }
		}
	}

}
