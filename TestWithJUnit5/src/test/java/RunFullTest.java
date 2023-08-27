/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import simula.compiler.SimulaCompiler;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;

import org.junit.jupiter.api.MethodOrderer;


/**
 * Simula Test Batch donated by Simula as.
 * Later extended in this Project.
 * 
 * @author Several from Norwegian Computing Center.
 * @author Several from Simula as.
 * @author Øystein Myhre Andersen
 *
 */
@TestMethodOrder(MethodOrderer.DisplayName.class)
public final class RunFullTest {
	private static final File simulaDir=new File("C:/GitHub/SimulaCompiler/Simula");
	private static final File userDir=new File("C:/GitHub/SimulaCompiler/TestWithJUnit5");
	private static final String testBatchDir = userDir+"/src/simulaTestBatch/bin/";


    @BeforeAll                                         
    static void init() {
		
//		list(testBatchDir);
		deleteFiles(testBatchDir);
//		list(testBatchDir);
		
		initCompilerOptions();
		initRuntimerOptions();

    }
    
    @AfterAll
    static void postActions() {

//		list(testBatchDir);
		deleteFiles(testBatchDir);
//		list(testBatchDir);
    	
    }

 
    
	@Test @DisplayName("Precompile 0: SimulaTest.sim") void testPreSimulaTest() { doCompile("SimulaTest.sim"); }

    @Test @DisplayName("Run simtst001.sim - Meaningless test of conditional statements") void testSimtst01() { doCompile("simtst01.sim"); }
	@Test @DisplayName("Run simtst002.sim - Test boolean operators/expressions") void testSimtst02() { doCompile("simtst02.sim"); }
	@Test @DisplayName("Run simtst003.sim - Test Text Value Relations") void testSimtst03() { doCompile("simtst03.sim"); }
	@Test @DisplayName("Run simtst004.sim - To test putint and putreal.") void testSimtst04() { doCompile("simtst04.sim"); }
	@Test @DisplayName("Run simtst005.sim - Test Aritmetisk Relations") void testSimtst05() { doCompile("simtst05.sim"); }
	@Test @DisplayName("Run simtst006.sim - Test Mathematical Functions") void testSimtst06() { doCompile("simtst06.sim"); }
	@Test @DisplayName("Run simtst007.sim - Test Mathematical Library") void testSimtst07() { doCompile("simtst07.sim"); }
	@Test @DisplayName("Run simtst008.sim - Test Scope of Variables.") void testSimtst08() { doCompile("simtst08.sim"); }
	@Test @DisplayName("Run simtst009.sim - Test relation operator and some Funtions") void testSimtst09() { doCompile("simtst09.sim"); }
	@Test @DisplayName("Run simtst010.sim - Test Evaluation of Text-Constants") void testSimtst10() { doCompile("simtst10.sim"); }

	@Test @DisplayName("Run simtst011.sim - Text Attributes constant, start, length, pos and main") void testSimtst11() { doCompile("simtst11.sim"); }
	@Test @DisplayName("Run simtst012.sim - Text value and reference relations.") void testSimtst12() { doCompile("simtst12.sim"); }
	@Test @DisplayName("Run simtst013.sim - Text value assignment and text reference assigment.") void testSimtst13() { doCompile("simtst13.sim"); }
	@Test @DisplayName("Run simtst014.sim - Text attributes: pos, setpos, more, getchar and putchar.") void testSimtst14() { doCompile("simtst14.sim"); }
	@Test @DisplayName("Run simtst015.sim - Text generation procedures copy and blanks.") void testSimtst15() { doCompile("simtst15.sim"); }
	@Test @DisplayName("Run simtst016.sim - Standard Text procedures sub and strip.") void testSimtst16() { doCompile("simtst16.sim"); }
	@Test @DisplayName("Run simtst017.sim - Editing and De-editing") void testSimtst17() { doCompile("simtst17.sim"); }
	@Test @DisplayName("Run simtst018.sim - The put- and get-procedures for texts.") void testSimtst18() { doCompile("simtst18.sim"); }
	@Test @DisplayName("Run simtst019.sim - Text concatenation and text expression evaluation.") void testSimtst19() { doCompile("simtst19.sim"); }
	@Test @DisplayName("Run simtst030.sim - Simple tests: integer relations <, <=, =, >=, > and <>") void testSimtst20() { doCompile("simtst20.sim"); }

	@Test @DisplayName("Run simtst021.sim - Arrays of simple types and text.") void testSimtst21() { doCompile("simtst21.sim"); }
	@Test @DisplayName("Run simtst022.sim - Test for-loops with various for-list elements") void testSimtst22() { doCompile("simtst22.sim"); }
	@Test @DisplayName("Run simtst023.sim - Type conversions in for step-until element.") void testSimtst23() { doCompile("simtst23.sim"); }
	@Test @DisplayName("Run simtst024.sim - Conditional statements with more complex Boolean expressions.") void testSimtst24() { doCompile("simtst24.sim"); }
	@Test @DisplayName("Run simtst025.sim - Multiple arithmetic assignment") void testSimtst25() { doCompile("simtst25.sim"); }
	@Test @DisplayName("Run simtst026.sim - Designational expressions, goto statement and switch declaration.") void testSimtst26() { doCompile("simtst26.sim"); }
	@Test @DisplayName("Run simtst027.sim - Test while-loops.") void testSimtst27() { doCompile("simtst27.sim"); }
	@Test @DisplayName("Run simtst028.sim - Paramenter transmission to procedures by value.") void testSimtst28() { doCompile("simtst28.sim"); }
	@Test @DisplayName("Run simtst029.sim - Procedure parameters by value") void testSimtst29() { doCompile("simtst29.sim"); }
	@Test @DisplayName("Run simtst030.sim - Name parameters (Modified: 2-dim arrays removed)") void testSimtst30() { doCompile("simtst30.sim"); }

	@Test @DisplayName("Run simtst031.sim - Labels and switches as parameters to procedures") void testSimtst31() { doCompile("simtst31.sim"); }
	@Test @DisplayName("Run simtst032.sim - Simple test of formal procedures.") void testSimtst32() { doCompile("simtst32.sim"); }
	@Test @DisplayName("Run simtst033.sim - Test call by reference") void testSimtst33() { doCompile("simtst33.sim"); }
	@Test @DisplayName("Run simtst034.sim - Procedures with procedures as parameters.") void testSimtst34() { doCompile("simtst34.sim"); }
	@Test @DisplayName("Run simtst035.sim - Type procedures as parameters.") void testSimtst35() { doCompile("simtst35.sim"); }
	@Test @DisplayName("Run simtst036.sim - Jensens Device - call by name. TRENGER FIN-TESTING") void testSimtst36() { doCompile("simtst36.sim"); }
	@Test @DisplayName("Run simtst037.sim - Parameter by name and type conversion") void testSimtst37() { doCompile("simtst37.sim"); }
	@Test @DisplayName("Run simtst038.sim - Test the value of type procedures.") void testSimtst38() { doCompile("simtst38.sim"); }
	@Test @DisplayName("Run simtst039.sim - Check that a formal parameter is global to the procedure body.") void testSimtst39() { doCompile("simtst39.sim"); }
	@Test @DisplayName("Precompile 1: p40b.sim for Simtst 40.") void testPre40_1() { doCompile("p40b.sim"); }
	@Test @DisplayName("Precompile 2: p40a.sim for Simtst 40.") void testPre40_2() { doCompile("p40a.sim"); }
	@Test @DisplayName("Precompile 3: p40c.sim for Simtst 40.") void testPre40_3() { doCompile("p40c.sim"); }
	@Test @DisplayName("Run simtst040.sim - Test separate compilation of procedures.") void testSimtst40() { doCompile("simtst40.sim"); }

	@Test @DisplayName("Precompile p41.sim for Simtst 41.") void testPre41() { doCompile("p41.sim"); }
	@Test @DisplayName("Run simtst041.sim - Name parameter in external procedure.") void testSimtst41() { doCompile("simtst41.sim"); }
	@Test @DisplayName("Run simtst042.sim - Compute 'n-fac', using iteration within the procedure.") void testSimtst42() { doCompile("simtst42.sim"); }
	@Test @DisplayName("Run simtst043.sim - Compute 'n-fac', using recursion.") void testSimtst43() { doCompile("simtst43.sim"); }
	@Test @DisplayName("Run simtst044.sim - Test text procedure.") void testSimtst44() { doCompile("simtst44.sim"); }
	@Test @DisplayName("Run simtst045.sim - Test object relations - is and in.") void testSimtst45() { doCompile("simtst45.sim"); }
	@Test @DisplayName("Run simtst046.sim - Test the qualification of a function designator.") void testSimtst46() { doCompile("simtst46.sim"); }
	@Test @DisplayName("Run simtst047.sim - Test of this.") void testSimtst47() { doCompile("simtst47.sim"); }
	@Test @DisplayName("Run simtst048.sim - Test of qua.") void testSimtst48() { doCompile("simtst48.sim"); }
	@Test @DisplayName("Run simtst049.sim - For statements in connection blocks.") void testSimtst49() { doCompile("simtst49.sim"); }
	@Test @DisplayName("Run simtst050.sim - Test binding and qualification in Connection Blocks") void testSimtst50() { doCompile("simtst50.sim"); }

	@Test @DisplayName("Run simtst051.sim - Test 'inner'.") void testSimtst51() { doCompile("simtst51.sim"); }
	@Test @DisplayName("Run simtst052.sim - Test 'inner'") void testSimtst52() { doCompile("simtst52.sim"); }
	@Test @DisplayName("Run simtst053.sim - Syntax check on virtual part") void testSimtst53() { doCompile("simtst53.sim"); }
	@Test @DisplayName("Run simtst054.sim - A VERY Simple Simulation") void testSimtst54() { doCompile("simtst54.sim"); }
	@Test @DisplayName("Run simtst055.sim - Test virtual procedures.") void testSimtst55() { doCompile("simtst55.sim"); }
	@Test @DisplayName("Run simtst056.sim - Test virtual procedures.") void testSimtst56() { doCompile("simtst56.sim"); }
	@Test @DisplayName("Run simtst057.sim - Virtual procedure - different number of parameters") void testSimtst57() { doCompile("simtst57.sim"); }
	@Test @DisplayName("Run simtst058.sim - Goto from within a connection into otherwise") void testSimtst58() { doCompile("simtst58.sim"); }
	@Test @DisplayName("Run simtst059.sim - Test 2-dim Array by value.") void testSimtst59() { doCompile("simtst59.sim"); }
	@Test @DisplayName("Run simtst060.sim - Visibility of protected attributes.") void testSimtst60() { doCompile("simtst60.sim"); }

	@Test @DisplayName("Run simtst061.sim - Remote access to attributes which are protected.") void testSimtst61() { doCompile("simtst61.sim"); }
	@Test @DisplayName("Run simtst062.sim - Test complex use of detach and resume.") void testSimtst62() { doCompile("simtst62.sim"); }
	@Test @DisplayName("Run simtst063.sim - Transmission by name of reference types.") void testSimtst63() { doCompile("simtst63.sim"); } 
	@Test @DisplayName("Run simtst064.sim - Parameter transmission by value to classes.") void testSimtst64() { doCompile("simtst64.sim"); }
	@Test @DisplayName("Run simtst065.sim - Parameter transmission by reference to classes.") void testSimtst65() { doCompile("simtst65.sim"); }
	@Test @DisplayName("Run simtst066.sim - Test corutines and two infiles which read from the same file.") void testSimtst66() { doCompile("simtst66.sim"); }
	@Test @DisplayName("Run simtst067.sim - Simple test of detach, call and resume.") void testSimtst67() { doCompile("simtst67.sim"); }
	@Test @DisplayName("Run simtst068.sim - Test of coroutines. VIRKER 'NESTEN' - Må FINTESTES") void testSimtst68() { doCompile("simtst68.sim"); }
	@Test @DisplayName("Run simtst069.sim - Test complex use of detach, call and resume.") void testSimtst69() { doCompile("simtst69.sim"); }
	@Test @DisplayName("Run simtst070.sim - Text attributes and relations") void testSimtst70() { doCompile("simtst70.sim"); }
	
	@Test @DisplayName("Run simtst071.sim - Test visibility of identifiers.") void testSimtst71() { doCompile("simtst71.sim"); }
	@Test @DisplayName("Run simtst072.sim - Test of formal procedures.") void testSimtst72() { doCompile("simtst72.sim"); }
	@Test @DisplayName("Run simtst073.sim - Test of formal procedures.") void testSimtst73() { doCompile("simtst73.sim"); }
	@Test @DisplayName("Run simtst074.sim - Test resume and detach.") void testSimtst74() { doCompile("simtst74.sim"); }
	@Test @DisplayName("Run simtst075.sim - Name parameters and virtual procedures.") void testSimtst75() { doCompile("simtst75.sim"); }
	@Test @DisplayName("Run simtst076.sim - Test of detach and resume in SIMSET.") void testSimtst76() { doCompile("simtst76.sim"); }
	@Test @DisplayName("Run simtst077.sim - Two infile objects reading from the same external file.") void testSimtst77() { doCompile("simtst77.sim"); }
	@Test @DisplayName("Run simtst078.sim - Test the text procedure filename of class file.") void testSimtst78() { doCompile("simtst78.sim"); }
//	@Test @DisplayName("Run simtst079.sim - Test the attribute 'IsOpen' of class file.") void testSimtst79() { doCompile("simtst79.sim"); }
	@Test @DisplayName("Run simtst080.sim - Test the attribute 'IsOpen' of class file.") void testSimtst80() { doCompile("simtst80.sim"); }

	@Test @DisplayName("Run simtst081.sim - Test the value of close.") void testSimtst81() { doCompile("simtst81.sim"); }
	@Test @DisplayName("Run simtst082.sim - Simple test of the operations +, -, *, / and //.") void testSimtst82() { doCompile("simtst82.sim"); }
	@Test @DisplayName("Run simtst083.sim - Name Parameter with EXTREME BI-EFFECTS") void testSimtst83() { doCompile("simtst83.sim"); }
	@Test @DisplayName("Run simtst084.sim - Test DirectBytefile.") void testSimtst84() { doCompile("simtst84.sim"); }
	@Test @DisplayName("Run simtst085.sim - Test Directfile.") void testSimtst85() { doCompile("simtst85.sim"); }
	@Test @DisplayName("Precompile Separat.sim for Simtst 86.") void testPre86() { doCompile("Separat.sim"); }
	@Test @DisplayName("Run simtst086.sim - Test separate compilation of Class.") void testSimtst86() { doCompile("simtst86.sim"); }
	@Test @DisplayName("Run simtst087.sim - Specification of Virtual Procedures.") void testSimtst87() { doCompile("simtst87.sim"); }
	@Test @DisplayName("Run simtst088.sim - Visibility of Hidden attributes.") void testSimtst88() { doCompile("simtst88.sim"); }
	@Test @DisplayName("Run simtst089.sim - Test inbytefile and outbytefile.") void testSimtst89() { doCompile("simtst89.sim"); }
	@Test @DisplayName("Run simtst090.sim - Test getfrac/putfrac.") void testSimtst90() { doCompile("simtst90.sim"); }

	@Test @DisplayName("Run simtst091.sim - Test virtual procedures, simple case.") void testSimtst91() { doCompile("simtst91.sim"); }
	@Test @DisplayName("Run simtst092.sim - Test 1-dim Array by value.") void testSimtst92() { doCompile("simtst92.sim"); }
	@Test @DisplayName("Run simtst093.sim - Test Simset - linkage, head, link, into, out, follow and precede") void testSimtst93() { doCompile("simtst93.sim"); }
	@Test @DisplayName("Run simtst094.sim - Test Simset - first, last, empty, cardinal and clear.") void testSimtst94() { doCompile("simtst94.sim"); }
	@Test @DisplayName("Run simtst095.sim - Test Environment Interface.") void testSimtst95() { doCompile("simtst95.sim"); }
	@Test @DisplayName("Run simtst096.sim - Test hidden, protected attributes.") void testSimtst96() { doCompile("simtst96.sim"); }
	@Test @DisplayName("Run simtst097.sim - Test nested hidden and protected.") void testSimtst97() { doCompile("simtst97.sim"); }
	@Test @DisplayName("Run simtst098.sim - Test attribute protection - complex example. Test visibility of labels.") void testSimtst98() { doCompile("simtst98.sim"); }
	@Test @DisplayName("Run simtst099.sim - Test mod, rem, min, max.") void testSimtst99() { doCompile("simtst99.sim"); }
	@Test @DisplayName("Run simtst100.sim - Test that put-get-put delivers the identity.") void testSimtst100() { doCompile("simtst100.sim"); }

	@Test @DisplayName("Run simtst101.sim - Test Standard Procedure 'sourceline'.") void testSimtst101() { doCompile("simtst101.sim"); }
	@Test @DisplayName("Run simtst102.sim - GOTO out of an operating Process") void testSimtst102() { doCompile("simtst102.sim"); }
	@Test @DisplayName("Run simtst103.sim - All kinds of Activation Statements") void testSimtst103() { doCompile("simtst103.sim"); }
	@Test @DisplayName("Run simtst104.sim - Procedure parameter 'F' by name.") void testSimtst104() { doCompile("simtst104.sim"); }
	@Test @DisplayName("Run simtst105.sim - Multiple assignments.") void testSimtst105() { doCompile("simtst105.sim"); }
//	@Test @DisplayName("Run simtst106.sim - ERR: Test SIMULATION, complex example.") void testSimtst106() { doCompile("simtst106.sim"); }
	@Test @DisplayName("Run simtst107.sim - Test Process, activation statements, idle, terminated, time.") void testSimtst107() { doCompile("simtst107.sim"); }
	@Test @DisplayName("Run simtst108.sim - Simple Co-Routine Sample 1: detach - call") void testSimtst108() { doCompile("simtst108.sim"); }
	@Test @DisplayName("Run simtst109.sim - Simple Co-Routine Sample 2: detach - resume") void testSimtst109() { doCompile("simtst109.sim"); }
	@Test @DisplayName("Run simtst110.sim - Simple Co-Routine Sample 3: detach - resume - chain") void testSimtst110() { doCompile("simtst110.sim"); }

	@Test @DisplayName("Run simtst111.sim - Virtual Label Sample 1") void testSimtst111() { doCompile("simtst111.sim"); }
	@Test @DisplayName("Run simtst112.sim - Virtual Label Sample 2") void testSimtst112() { doCompile("simtst112.sim"); }
	@Test @DisplayName("Run simtst113.sim - Virtual Switch Sample 1") void testSimtst113() { doCompile("simtst113.sim"); }
	@Test @DisplayName("Run simtst114.sim - Switch Statement") void testSimtst114() { doCompile("simtst114.sim"); }
	@Test @DisplayName("Run simtst115.sim - Simple QPS-Sample 1") void testSimtst115() { doCompile("simtst115.sim"); }
	@Test @DisplayName("Run simtst116.sim - Simple QPS-Sample 2") void testSimtst116() { doCompile("simtst116.sim"); }
	@Test @DisplayName("Run simtst117.sim - Simple QPS-Sample 3") void testSimtst117() { doCompile("simtst117.sim"); }
	@Test @DisplayName("Run simtst118.sim - Simple QPS-Sample 4") void testSimtst118() { doCompile("simtst118.sim"); }
	@Test @DisplayName("Precompile ExternalClass1.sim for Simtst 119.") void testPre119_1() { doCompile("ExternalClass1.sim"); }
	@Test @DisplayName("Precompile ExternalClass2.sim for Simtst 119.") void testPre119_2() { doCompile("ExternalClass2.sim"); }
	@Test @DisplayName("Run simtst119.sim - Uses EcternalClass1-2") void testSimtst119() { doCompile("simtst119.sim"); }
	@Test @DisplayName("Run simtst120.sim - VERY LOCAL GOTO SAMPLE") void testSimtst120() { doCompile("simtst120.sim"); }

	@Test @DisplayName("Run simtst121.sim - LEGAL GOTO out of an operating Process and the enclosing System.") void testSimtst121() { doCompile("simtst121.sim"); }
	@Test @DisplayName("Run simtst122.sim - GOTO LABEL IN SUPER CLASS") void testSimtst122() { doCompile("simtst122.sim"); }
	@Test @DisplayName("Run simtst123.sim - GOTO VIRTUAL LABEL") void testSimtst123() { doCompile("simtst123.sim"); }
	@Test @DisplayName("Run simtst124.sim - GOTO VIRTUAL LABEL") void testSimtst124() { doCompile("simtst124.sim"); }
	@Test @DisplayName("Run simtst125.sim - GOTO LABEL WITHIN NESTED COMPOUND STATEMENTS") void testSimtst125() { doCompile("simtst125.sim"); }
	@Test @DisplayName("Run simtst126.sim - GOTO SIMPLE SWITCH") void testSimtst126() { doCompile("simtst126.sim"); }
	@Test @DisplayName("Run simtst127.sim - Switch (character) Statement") void testSimtst127() { doCompile("simtst127.sim"); }
	@Test @DisplayName("Run simtst128.sim - Standard Procedure edit and edfix") void testSimtst128() { doCompile("simtst128.sim"); }
	@Test @DisplayName("Precompile Precompiled129.sim for Simtst 129.") void testPre129() { doCompile("Precompiled129.sim"); }
	@Test @DisplayName("Run simtst129.sim - Switch in precompiled class") void testSimtst129() { doCompile("simtst129.sim"); }
	@Test @DisplayName("Run simtst130.sim - Class SimLib, a set of utility procedures from DEC Handbook.") void testSimtst130() { doCompile("simtst130.sim"); }

	@Test @DisplayName("Run simtst131.sim - Catching Errors") void testSimtst131() { doCompile("simtst131.sim"); }
	@Test @DisplayName("Run simtst132.sim - ERR: SPORT Options") void testSimtst132() { doCompile("simtst132.sim"); }
	@Test @DisplayName("Run simtst133.sim - Test infile reading with inimage and inrecord.") void testSimtst133() { doCompile("simtst133.sim"); }
	@Test @DisplayName("Run simtst134.sim - Outfile with CREATE, APPEND and PURGE.") void testSimtst134() { doCompile("simtst134.sim"); }
	@Test @DisplayName("Run simtst135.sim - OutBytefile with CREATE, APPEND and PURGE.") void testSimtst135() { doCompile("simtst135.sim"); }
	@Test @DisplayName("Run simtst136.sim - Directfile with CREATE, APPEND and PURGE.") void testSimtst136() { doCompile("simtst136.sim"); }
	@Test @DisplayName("Run simtst137.sim - DirectBytefile with CREATE, APPEND and PURGE.") void testSimtst137() { doCompile("simtst137.sim"); }
	@Test @DisplayName("Run simtst138.sim - ref() and Real type Arrays.") void testSimtst138() { doCompile("simtst138.sim"); }

	@Test @DisplayName("Precompile RT_ErrorTest.sim - Simula Error TestBatch Framework") void preRT_ErrorTest() { doCompile("RT_ErrorTest.sim"); }
	@Test @DisplayName("Run simerr01.sim - ILLEGAL GOTO out of an operating Process and into the enclosing System.") void testSimerr01() { doCompile("simerr01.sim"); }
	@Test @DisplayName("Run simerr02.sim - Testing NONE-CHECK") void testSimerr02() { doCompile("simerr02.sim"); }
	@Test @DisplayName("Precompile PrecompiledClass.sim - Used by simerr03") void preSimterr03() { doCompile("PrecompiledClass.sim"); }
	@Test @DisplayName("Run simerr03.sim - Division by Zero in Precompiled Class ") void testSimerr03() { doCompile("simerr03.sim"); }
	@Test @DisplayName("Precompile PrecompiledProcedure.sim - Used by simerr04") void preSimterr04() { doCompile("PrecompiledProcedure.sim"); }
	@Test @DisplayName("Run simerr04.sim - Division by Zero in Precompiled Procedure") void testSimerr04() { doCompile("simerr04.sim"); }
	@Test @DisplayName("Run simerr05.sim - NumberFormatException") void testSimerr05() { doCompile("simerr05.sim"); }
	@Test @DisplayName("Run simerr06.sim - ArrayIndexOutOfBounds") void testSimerr06() { doCompile("simerr06.sim"); }
	@Test @DisplayName("Run simerr07.sim - Wrong number of paramerters to virtual procedure") void testSimerr07() { doCompile("simerr07.sim"); }
	@Test @DisplayName("Run simerr08.sim - Illegal assignment. Name parameter is not a variable") void testSimerr08() { doCompile("simerr08.sim"); }
	@Test @DisplayName("Run simerr09.sim - Read/write access on DirectFile and DirectByteFile") void testSimerr09() { doCompile("simerr09.sim"); }

	
	   
	// ***************************************************************
	// *** INIT COMPILER OPTIONS
	// ***************************************************************
	static void initCompilerOptions() {

		// Set options and tracing.
		Option.INLINE_TESTING=true;
		Option.SPORT=true;
//		Option.verbose = true;
		Option.WARNINGS=false;
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

		Global.packetName="simulaTestBatch";
//		Option.keepJava=userDir; // Generated .java Source is then found in Eclipse Package simulaTestBatch
		Global.simulaRtsLib=new File(simulaDir,"bin"); // To use Eclipse Project's simula.runtime
//		Global.extLib="C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/sim/bin";

	}

	// ***************************************************************
	// *** INIT RUNTIME OPTIONS
	// ***************************************************************
	static void initRuntimerOptions() {
		// Set RunTime Options and tracing.
//		RTOption.VERBOSE = true;
//		RTOption.USE_CONSOLE=true;
//		RTOption.BLOCK_TRACING = true;
//		RTOption.GOTO_TRACING = true;
//		RTOption.QPS_TRACING = true;
//		RTOption.SML_TRACING = true;
//		Option.RUNTIME_USER_DIR = "C:/GitHub/SimulaCompiler/TestBatch/";
	}


	// ***************************************************************
	// *** CALL SIMULA COMPILER
	// ***************************************************************
	void doCompile(String name) {
		String fileName = userDir+"/src/"+Global.packetName+"/"+name;
//		Option.RUNTIME_USER_DIR=new File(fileName).getParent();
//		System.out.println("RUN: "+fileName);
		SimulaCompiler compiler = new SimulaCompiler(fileName);
		assertDoesNotThrow( () -> compiler.doCompile() );
	}


	// ***************************************************************
	// *** DELETE FILES
	// ***************************************************************
	private static void deleteFiles(final String dirName) {
		try { File tmpClass = new File(dirName);
		File[] elt = tmpClass.listFiles();
		if(elt==null) return; 
		for (File f : elt) {
			if(f.isDirectory()) deleteFiles(f.getPath());
			f.delete();
		}
		} catch (Exception e) { e.printStackTrace(); }
	}

	// ***************************************************************
	// *** LIST FILES
	// ***************************************************************
	private static void list(final String dirName) { list(new File(dirName)); }
	private static void list(final File dir) {
		try { System.out.println("------------  LIST "+dir+"  ------------");
		list("",dir);
		} catch (Exception e) { e.printStackTrace(); }
	}

	private static void list(String indent,final File dir) {
		try {
			//System.out.println("tmpClass: "+dir);
			File[] elt = dir.listFiles();
			if(elt==null || elt.length==0) {
				System.out.println("Empty Directory: "+dir);
				return; 
			}
			System.out.println("Elements: "+elt.length);
			for (File f : elt) {
				System.out.println(indent+"- "+getModifiedTime(f)+"  "+f);
				if(f.isDirectory()) list(indent+"   ",f);
			}
		} catch (Exception e) { e.printStackTrace(); }
	}

	private static String getModifiedTime(File file) {
		try { Path path = Paths.get(file.toString());
		BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
		return(attr.lastModifiedTime().toString().substring(0,19).replace('T',' '));
		} catch (IOException e) { e.printStackTrace(); }
		return(null);
	}


}
