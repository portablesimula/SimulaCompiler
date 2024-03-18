/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.declaration;

import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;
import java.util.Vector;

import simula.compiler.CodeLine;
import simula.compiler.syntaxClass.OverLoad;
import simula.compiler.syntaxClass.Type;
import simula.compiler.syntaxClass.expression.Constant;

/**
 * Standard Class.
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/declaration/StandardClass.java">
 * <b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public final class StandardClass extends ClassDeclaration {
//  private Declaration.Kind getBlockKind() { return(Declaration.Kind.StandardClass); }
	public String edJavaClassName() {
		return (identifier);
	}

	/**
	 * The type text.
	 */
	public static StandardClass typeText;

	/**
	 * The Standard Class ENVIRONMENT.
	 */
	public static StandardClass ENVIRONMENT;

	/**
	 * The Standard Class BASICIO.
	 */
	public static StandardClass BASICIO;

	/**
	 * The Standard Class CLASS.
	 */
	static StandardClass CLASS;

	/**
	 * The Standard Class Infile.
	 */
	public static StandardClass Infile;

	/**
	 * The Standard Class Printfile.
	 */
	public static StandardClass Printfile;

	/**
	 * Method to initiate all standard classes.
	 */
	public static void INITIATE() {
		initTypeText();
		initUNIVERSE();
		initRTObject();
		initENVIRONMENT();
		initBASICIO();
		initCLASS();
		initFile();
			initImagefile();
				initInfile();
				initOutfile();
				initDirectfile();
				initPrintfile();
			initBytefile();
				initInbytefile();
				initOutbytefile();
				initDirectbytefile();
		initSimset();
			initLinkage();
			initHead();
			initLink();
		initSimulation();
			initEVENT_NOTICE();
			initProcess();
			initMAIN_PROGRAM();
			
		if(Option.EXTENSIONS) {
			initCatchingErrors();
			initDEC_Lib();
			initDrawing();
				initShapeElement();
				initTextElement();
		}
	}


	// ******************************************************************
	// *** The Type TXT
	// ******************************************************************
	/**
	 * Initiate the The Type Text
	 */
	private static void initTypeText() {
		typeText=new StandardClass("TXT");
		typeText.isContextFree=true;
		typeText.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"constant");  
		typeText.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"start");  
		typeText.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"length");  
		typeText.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Text,"main");  
		typeText.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"pos");  
		typeText.addStandardProcedure(Declaration.Kind.MemberMethod,null,"setpos",parameter("i",Type.Integer));  
		typeText.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"more");  
		typeText.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Character,"getchar");  
		typeText.addStandardProcedure(Declaration.Kind.MemberMethod,null,"putchar",parameter("c",Type.Character));  
		typeText.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Text,"sub",parameter("i",Type.Integer),parameter("n",Type.Integer));  
		typeText.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Text,"strip");  
		typeText.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"getint");  
		typeText.addStandardProcedure(Declaration.Kind.MemberMethod,Type.LongReal,"getreal");  
		typeText.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"getfrac");  
		typeText.addStandardProcedure(Declaration.Kind.MemberMethod,null,"putint",parameter("i",Type.Integer));  
		typeText.addStandardProcedure(Declaration.Kind.MemberMethod,null,"putfrac",parameter("i",Type.Integer),parameter("n",Type.Integer));  
		typeText.addStandardProcedure(Declaration.Kind.MemberMethod,null,"putfix", parameter("r",new OverLoad(Type.Real,Type.LongReal)),parameter("n",Type.Integer)); 
		typeText.addStandardProcedure(Declaration.Kind.MemberMethod,null,"putreal",parameter("r",new OverLoad(Type.Real,Type.LongReal)),parameter("n",Type.Integer)); 
	}

	// ******************************************************************
	// *** The Standard Class UNIVERSE
	// ******************************************************************
	/**
	 * The Standard Class UNIVERSE
	 */
	private static StandardClass UNIVERSE;
	
	/**
	 * Initiate the Standard Class UNIVERSE
	 */
	private static void initUNIVERSE() {
		UNIVERSE=new StandardClass("UNIVERSE");
		UNIVERSE.isContextFree=true;
		UNIVERSE.declaredIn=null;
	}
	  
	// ******************************************************************
	// *** The Standard Class RTObject - Prefix to all classes
	// ******************************************************************
	/**
	 * Initiate the Standard Class RTObject
	 */
	private static void initRTObject() {
		StandardClass RTObject = new StandardClass("RTObject");
		UNIVERSE.addStandardClass(RTObject); // Declared in UNIVERSE
		RTObject.isContextFree = true;
		RTObject.addStandardProcedure(Declaration.Kind.MemberMethod, Type.Text, "objectTraceIdentifier");
		RTObject.addStandardProcedure(Declaration.Kind.MemberMethod, Type.Text, "waitSomeTime",	parameter("millies", Type.Integer));
		RTObject.addStandardProcedure(Declaration.Kind.MemberMethod, null, "detach"); // Nødvendig for å kompilere
																						// Simuletta
	}
	  
	// ******************************************************************
	// *** The Standard Class ENVIRONMENT
	// ******************************************************************
	/**
	 * Initiate the Standard Class ENVIRONMENT
	 */
	private static void initENVIRONMENT() {
		ENVIRONMENT=new StandardClass("RTObject","ENVIRONMENT");
		UNIVERSE.addStandardClass(ENVIRONMENT); // Declared in UNIVERSE
		ENVIRONMENT.isContextFree=true; // This class is a Context i.e. all members are static

		//	    Environmental enquiries ................................. 9.6
		//	    Procedure sourceline.
		//	    Constants  maxrank, maxint, minint, maxreal, minreal,
		//	      maxlongreal, minlongreal, simulaid.

//		ENVIRONMENT.addStandardAttribute(Type.LongReal,"maxlongreal");  
//		ENVIRONMENT.addStandardAttribute(Type.LongReal,"minlongreal");  
//		ENVIRONMENT.addStandardAttribute(Type.Real,"maxreal");  
//		ENVIRONMENT.addStandardAttribute(Type.Real,"minreal");  
//		ENVIRONMENT.addStandardAttribute(Type.Integer,"maxrank");  
//		ENVIRONMENT.addStandardAttribute(Type.Integer,"maxint");  
//		ENVIRONMENT.addStandardAttribute(Type.Integer,"minint");  
		ENVIRONMENT.addStandardAttribute(Type.LongReal,"maxlongreal",Double.MAX_VALUE);  
		ENVIRONMENT.addStandardAttribute(Type.LongReal,"minlongreal",-Double.MAX_VALUE);  
		ENVIRONMENT.addStandardAttribute(Type.Real,"maxreal",Float.MAX_VALUE);  
		ENVIRONMENT.addStandardAttribute(Type.Real,"minreal",-Float.MAX_VALUE);  
		ENVIRONMENT.addStandardAttribute(Type.Integer,"maxrank",255);  
		ENVIRONMENT.addStandardAttribute(Type.Integer,"maxint",Integer.MAX_VALUE);  
		ENVIRONMENT.addStandardAttribute(Type.Integer,"minint",Integer.MIN_VALUE);  
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"simulaid");
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"sourceline");

		//	    Basic operations ........................................ 9.1
		//	    Procedures mod, rem, abs, sign, entier,
		//	      addepsilon, subepsilon.

		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"mod",parameter("i",Type.Integer),parameter("j",Type.Integer));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"rem",parameter("i",Type.Integer),parameter("j",Type.Integer));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"abs",parameter("e",Type.LongReal));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"sign",parameter("e",Type.LongReal));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"entier",parameter("e",Type.LongReal));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,new OverLoad(Type.Real,Type.LongReal),"addepsilon",parameter("e",new OverLoad(Type.Real,Type.LongReal)));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,new OverLoad(Type.Real,Type.LongReal),"subepsilon",parameter("e",new OverLoad(Type.Real,Type.LongReal)));

		//	    Text utilities .......................................... 9.2
		//	    Procedures copy, blanks, char, isochar, rank, isorank,
		//	      digit, letter, lowten, decimalmark, upcase, lowcase.

		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"copy",parameter("T",Parameter.Mode.value,Type.Text));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"blanks",parameter("n",Type.Integer));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Character,"Char",parameter("n",Type.Integer));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Character,"_char",parameter("n",Type.Integer));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Character,"isochar",parameter("n",Type.Integer));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"rank",parameter("c",Type.Character));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"isorank",parameter("c",Type.Character));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Boolean,"digit",parameter("c",Type.Character));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Boolean,"letter",parameter("c",Type.Character));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Character,"lowten",parameter("c",Type.Character));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Character,"decimalmark",parameter("c",Type.Character));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"upcase",parameter("t",Type.Text));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"lowcase",parameter("t",Type.Text));

		//	    Scheduling .............................................. 9.3
		//	    Procedures call (7.3.2), resume (7.3.3).

		//	    Mathematical functions .................................. 9.4
		//	    Procedures sqrt, sin, cos, tan, cotan, arcsin, arccos,
		//	      arctan, arctan2, sinh, cosh, tanh, ln, log10, exp.

		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"sqrt",parameter("x",Type.LongReal));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"sin",parameter("x",Type.LongReal));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"cos",parameter("x",Type.LongReal));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"tan",parameter("x",Type.LongReal));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"cotan",parameter("x",Type.LongReal));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"arcsin",parameter("x",Type.LongReal));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"arccos",parameter("x",Type.LongReal));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"arctan",parameter("x",Type.LongReal));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"arctan2",parameter("x",Type.LongReal),parameter("y",Type.LongReal));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"sinh",parameter("x",Type.LongReal));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"cosh",parameter("x",Type.LongReal));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"tanh",parameter("x",Type.LongReal));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"ln",parameter("x",Type.LongReal));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"log10",parameter("x",Type.LongReal));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"exp",parameter("x",Type.LongReal));

		//	    Extremum functions ...................................... 9.5
		//	    Procedures max, min.

		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,new OverLoad(Type.Real,Type.LongReal),"min",parameter("x",new OverLoad(Type.Real,Type.LongReal)),parameter("y",new OverLoad(Type.Real,Type.LongReal)));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,new OverLoad(Type.Real,Type.LongReal),"max",parameter("x",new OverLoad(Type.Real,Type.LongReal)),parameter("y",new OverLoad(Type.Real,Type.LongReal)));

		//	    Error control ........................................... 9.7
		//	    Procedure error.

		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"error",parameter("msg",Type.Text));

		// Array quantities ........................................ 9.8
		//	    Procedures upperbound, lowerbound.

		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"upperbound",parameter("a",null,Parameter.Kind.Array),parameter("i",Type.Integer));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"lowerbound",parameter("a",null,Parameter.Kind.Array),parameter("i",Type.Integer));

		// Random drawing .......................................... 9.9
		//	    Procedures draw, randint, uniform, normal, negexp,
		//	      Poisson, Erlang, discrete, linear, histd.

		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Boolean,"draw",parameter("a",Type.LongReal),parameter("U",Parameter.Mode.name,Type.Integer));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"randint",parameter("a",Type.Integer),parameter("b",Type.Integer),parameter("U",Parameter.Mode.name,Type.Integer));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"uniform",parameter("a",Type.LongReal),parameter("b",Type.LongReal),parameter("U",Parameter.Mode.name,Type.Integer));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"normal",parameter("a",Type.LongReal),parameter("b",Type.LongReal),parameter("U",Parameter.Mode.name,Type.Integer));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"negexp",parameter("a",Type.LongReal),parameter("U",Parameter.Mode.name,Type.Integer));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"Poisson",parameter("a",Type.LongReal),parameter("U",Parameter.Mode.name,Type.Integer));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"Erlang",parameter("a",Type.LongReal),parameter("b",Type.LongReal),parameter("U",Parameter.Mode.name,Type.Integer));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"discrete",parameter("A",new OverLoad(Type.Real,Type.LongReal),Parameter.Kind.Array,1),parameter("U",Parameter.Mode.name,Type.Integer));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"linear",parameter("A",new OverLoad(Type.Real,Type.LongReal),Parameter.Kind.Array,1),parameter("B",new OverLoad(Type.Real,Type.LongReal),Parameter.Kind.Array,1),parameter("U",Parameter.Mode.name,Type.Integer));
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"histd",parameter("A",new OverLoad(Type.Real,Type.LongReal),Parameter.Kind.Array,1),parameter("U",Parameter.Mode.name,Type.Integer));

		//	    Calendar and timing utilities ........................... 9.10
		//	    Procedures datetime, cputime, clocktime.

		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"datetime");
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"cputime");
		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"clocktime");

		//	    Miscellaneous utilities ................................. 9.11
		//	    Procedure histo.

		ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"histo",parameter("A",Type.Real,Parameter.Kind.Array,1),parameter("B",Type.Real,Parameter.Kind.Array,1)
				,parameter("c",Type.Real),parameter("d",Type.Real));
		//	    ENVIRONMENT.addStandardProcedure(BlockKind.ContextFreeMethod,Type.Text,"objectTraceIdentifier");

		// **************************************
		// *** Additional Standard Procedures ***
		// **************************************
		if(Option.EXTENSIONS) {
			ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"waitSomeTime"
				,parameter("millies",Type.Integer)); 
			ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"printThreadList"
				,parameter("withStackTrace",Type.Boolean));
			ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"printStaticChain");
			ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"edit"
				,parameter("x",new OverLoad(Type.Integer,Type.Real,Type.LongReal,Type.Boolean,Type.Character)));
			ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"edfix"
				,parameter("x",new OverLoad(Type.Real,Type.LongReal)),parameter("n",Type.Integer));
			ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"edtime"
				,parameter("x",new OverLoad(Type.Real,Type.LongReal)));
		}
		
		// *****************************************
		// *** Additional S-Port'like Procedures ***
		// *****************************************
		if(Option.SPORT) {
			ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"DEFEXCEPTION",parameter("erh",Parameter.Kind.Procedure,Parameter.Mode.value,null));
			ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"hash",parameter("t",Type.Text));
			ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Character,"loadChar",parameter("t",Type.Text),parameter("i",Type.Integer)); 
			ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"storeChar",parameter("c",Type.Character),parameter("t",Type.Text),parameter("i",Type.Integer)); 
			ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"getTextInfo",parameter("i",Type.Integer)); 
			ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"giveTextInfo",parameter("i",Type.Integer),parameter("t",Type.Text)); 
			ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"getIntInfo",parameter("i",Type.Integer)); 
			ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"giveIntInfo",parameter("i",Type.Integer),parameter("val",Type.Integer)); 
			ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"rts_utility",parameter("index",Type.Integer),parameter("level",Type.Integer)); 
		}
	}

	// ******************************************************************
	// *** The Standard Class BASICIO
	// ******************************************************************

	/**
	 * Initiate the Standard Class BASICIO
	 * <pre>
	 *  ENVIRONMENT class BASICIO (INPUT_LINELENGTH, OUTPUT_LINELENGTH);
	 *  integer INPUT_LINELENGTH, OUTPUT_LINELENGTH;
	 *  begin ref (Infile) SYSIN; ref (Printfile) SYSOUT;
	 *        ref (Infile)    procedure sysin;   sysin  :- SYSIN;
	 *        ref (Printfile) procedure sysout;  sysout :- SYSOUT;
	 *
	 *        procedure terminate_program;
	 *        begin ... ;  goto STOP  end terminate_program;
	 *
	 *            class File 
	 *       File class Imagefile
	 *       File class Bytefile
	 *  Imagefile class Infile
	 *  Imagefile class Outfile
	 *  Imagefile class Directfile
	 *    Outfile class Printfile
	 *   Bytefile class Inbytefile
	 *   Bytefile class Outbytefile 
	 *   Bytefile class Directbytefile
	 *
	 *        SYSIN  :- new Infile("...");    ! Implementation-defined
	 *        SYSOUT :- new Printfile("..."); ! files names;
	 *        SYSIN.open(blanks(INPUT_LINELENGTH));
	 *        SYSOUT.open(blanks(OUTPUT_LINELENGTH));
	 *        inner;
	 *  STOP: SYSIN.close;
	 *        SYSOUT.close
	 *  end BASICIO;
	 * </pre>
	 */
	private static void initBASICIO() {
		BASICIO=new StandardClass("RTObject","BASICIO");
		ENVIRONMENT.addStandardClass(BASICIO); // Declared in ENVIRONMENT
		BASICIO.isContextFree=true;
		BASICIO.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Ref("Infile"),"sysin");  
		BASICIO.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Ref("Printfile"),"sysout");  
		BASICIO.addStandardProcedure(Declaration.Kind.MemberMethod,null,"terminate_program");  
		BASICIO.addStandardProcedure(Declaration.Kind.MemberMethod,null,"call",parameter("obj",Type.Ref("RTObject")));
		BASICIO.addStandardProcedure(Declaration.Kind.MemberMethod,null,"resume",parameter("obj",Type.Ref("RTObject")));
	}


	// ******************************************************************
	// *** The Standard Class CLASS
	// ******************************************************************
	/**
	 * Initiate the Standard Class CLASS
	 * <p>
	 * Simula Stadard States: Fictituous outermost prefix
	 * Any class that has no (textually given) prefix is by definition
	 * prefixed by a fictitious class whose only attribute is:
	 * <pre>
	 *	          procedure detach; ... ;  (see 7.3.1)
	 * </pre>
	 * Thus every class object or instance of a prefixed block has this attribute.
	 */

	private static void initCLASS() {
		CLASS=new StandardClass("RTObject","CLASS");
		ENVIRONMENT.addStandardClass(CLASS);  // Declared in ENVIRONMENT
		CLASS.addStandardProcedure(Declaration.Kind.MemberMethod,null,"detach");
	}

	// ******************************************************************
	// *** The Standard Class File
	// ******************************************************************
	/**
	 * The Standard Class File
	 */
	private static StandardClass File;
	
	/**
	 * Initiate the Standard Class File
	 * <pre>
	 *  class File(FILENAME); value FILENAME; text FILENAME;
	 *  begin
	 *     Boolean OPEN_;
	 *     text procedure filename; filename:=copy(FILENAME);
	 *     Boolean procedure isopen; isopen:=OPEN_;
	 *     Boolean procedure setaccess(mode);  text mode; ... ;
	 *  
	 *     if FILENAME = notext then error("Illegal File Name");
	 *  end File;      
	 * </pre>
	 */
	private static void initFile() {
		File=new StandardClass("CLASS","File",parameter("FILENAME_",Type.Text));
		BASICIO.addStandardClass(File);  // Declared in BASICIO
		File.addStandardAttribute(Type.Boolean,"OPEN_");  
		File.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Text,"filename");
		File.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"isopen");
		File.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"setaccess",parameter("mode",Type.Text));  
	}  

	// ******************************************************************
	// *** The Standard File Class Imagefile
	// ******************************************************************
	/**
	 * The Standard Class Imagefile
	 */
	private static StandardClass Imagefile;
	
	/**
	 * Initiate the Standard Class Imagefile
	 * <pre>
	 *  File class Imagefile;
	 *  begin text image;
	 *     procedure setpos(i);  integer i;  image.setpos(i);
	 *     integer procedure pos;     pos    := image.pos;
	 *     Boolean procedure more;    more   := image.more;
	 *     integer procedure length;  length := image.length;
	 *  end Imagefile;
	 * </pre>
	 */
	private static void initImagefile() {
		Imagefile=new StandardClass("File","Imagefile");
		BASICIO.addStandardClass(Imagefile);  // Declared in BASICIO
		Imagefile.addStandardAttribute(Type.Text,"image");  
		Imagefile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"setpos",parameter("i",Type.Integer));  
		Imagefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"pos");  
		Imagefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"more");  
		Imagefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"length");   
	}

	// ******************************************************************
	// *** The Standard Imagefile Class Infile
	// ******************************************************************
	/**
	 * Initiate the Standard Class Infile
	 * <pre>
	 *  Imagefile class Infile;
	 *  begin Boolean ENDFILE;
	 *     Boolean procedure endfile;  endfile:= ENDFILE;
	 *     Boolean procedure open(fileimage); text fileimage;
	 *     Boolean procedure close;
	 *     procedure inimage;
	 *     Boolean procedure inrecord;
	 *     character procedure inchar;
	 *     Boolean procedure lastitem;
	 *     text procedure intext(w); integer w;
	 *     integer procedure inint;
	 *     long real procedure inreal;
	 *     integer procedure infrac;
	 *
	 *     ENDFILE:= true
	 *     ...
	 *  end Infile;
	 * </pre>
	 */
	private static void initInfile() {
		Infile=new StandardClass("Imagefile","Infile");
		BASICIO.addStandardClass(Infile);  // Declared in BASICIO
		Infile.addStandardAttribute(Type.Boolean,"ENDFILE_");  
		Infile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"endfile");  
		Infile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"open",parameter("fileimage",Type.Text));  
		Infile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"close");  
		Infile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"inimage");  
		Infile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"inrecord");  
		Infile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Character,"inchar");  
		Infile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"lastitem");  
		Infile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Text,"intext",parameter("w",Type.Integer));  
		Infile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"inint");  
		Infile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.LongReal,"inreal");  
		Infile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"infrac");  
	}  

	// ******************************************************************
	// *** The Standard Imagefile Class Outfile
	// ******************************************************************
	/**
	 * Initiate the Standard Class Outfile
	 * <pre>
	 *  Imagefile class Outfile;
	 *  begin
	 *     Boolean procedure open(fileimage);  text fileimage;
	 *     Boolean procedure close;
	 *     procedure outimage;
	 *     procedure outrecord;
	 *     procedure breakoutimage;
	 *     Boolean procedure checkpoint;
	 *     procedure outchar(c); character c;
	 *     procedure outtext(t); text t;
	 *     text procedure FIELD(w); integer w;
	 *     procedure outint(i,w); integer i,w;
	 *     procedure outfix(r,n,w); long real r; integer n,w;
	 *     procedure outreal(r,n,w); long real r; integer n,w;
	 *     procedure outfrac(i,n,w); integer i,n,w;
	 *
	 *    ... ;
	 * end Outfile;
	 * </pre>
	 */
	private static void initOutfile() { 
		StandardClass Outfile=new StandardClass("Imagefile","Outfile");
		BASICIO.addStandardClass(Outfile);  // Declared in BASICIO
		Outfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"open",parameter("fileimage",Type.Text));  
		Outfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"close");  
		Outfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outimage");  
		Outfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outrecord");  
		Outfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"breakoutimage");  
		Outfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"checkpoint");  
		Outfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outchar",parameter("c",Type.Character));  
		Outfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outtext",parameter("t",Type.Text));  
		Outfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Text,"FIELD_",parameter("w",Type.Integer));  
		Outfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outint",parameter("i",Type.Integer),parameter("w",Type.Integer));  
		Outfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outfrac",parameter("i",Type.Integer),parameter("n",Type.Integer),parameter("w",Type.Integer)); 
		Outfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outfix", parameter("r",new OverLoad(Type.Real,Type.LongReal)),parameter("n",Type.Integer),parameter("w",Type.Integer)); 
		Outfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outreal",parameter("r",new OverLoad(Type.Real,Type.LongReal)),parameter("n",Type.Integer),parameter("w",Type.Integer)); 
	}  

	// ******************************************************************
	// *** The Standard Imagefile Class Directfile
	// ******************************************************************
	/**
	 * Initiate the Standard Class Directfile
	 * <pre>
	 *  Imagefile class Directfile;
	 *  begin   integer LOC, MAXLOC;  Boolean ENDFILE, LOCKED;
	 *     integer procedure location;  location:= LOC;
	 *     Boolean procedure endfile;   endfile := ENDFILE;
	 *     Boolean procedure locked;    locked  := LOCKED;
	 *     Boolean procedure open(fileimage); text fileimage; 
	 *     Boolean procedure close;
	 *     integer procedure lastloc;
	 *     integer procedure maxloc;
	 *     procedure locate(i); integer i;
	 *     procedure inimage;
	 *     procedure outimage;
	 *     Boolean procedure deleteimage;
	 *     character procedure inchar;
	 *     integer procedure lock(t,i,j); real t; integer i,j;
	 *     Boolean procedure unlock; 
	 *     Boolean procedure checkpoint;
	 *     Boolean procedure lastitem;
	 *     text procedure intext;
	 *     integer procedure inint;
	 *     long real procedure inreal;
	 *     integer procedure infrac;
	 *     procedure outchar(c); character c;
	 *     procedure outtext(t); text t;
	 *     text procedure FIELD(w); integer w;
	 *     procedure outint(i,w); integer i,w;
	 *     procedure outfix(r,n,w);  long real r; integer n,w;
	 *     procedure outreal(r,n,w); long real r; integer n,w;
	 *     procedure outfrac(i,n,w); integer i,n,w;
	 *
	 *     ENDFILE:= true
	 *     ...
	 *  end Directfile;
	 * </pre>
	 */
	private static void initDirectfile() {
		StandardClass Directfile=new StandardClass("Imagefile","Directfile");
		BASICIO.addStandardClass(Directfile);  // Declared in BASICIO
		Directfile.addStandardAttribute(Type.Integer,"LOC_");  
		Directfile.addStandardAttribute(Type.Integer,"MAXLOC_");  
		Directfile.addStandardAttribute(Type.Boolean,"ENDFILE_");  
		Directfile.addStandardAttribute(Type.Boolean,"LOCKED_");  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"location");  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"endfile");  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"locked");  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"open",parameter("fileimage",Type.Text));  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"close");      
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"lastloc");  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"maxloc");  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"locate",parameter("i",Type.Integer));  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"inimage");  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outimage");  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"deleteimage");  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Character,"inchar");  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"lock",parameter("t",Type.Real),parameter("i",Type.Integer),parameter("j",Type.Integer));  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"unlock");  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"checkpoint");  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"lastitem");  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Text,"intext",parameter("w",Type.Integer));  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"inint");  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.LongReal,"inreal");  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"infrac");  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outchar",parameter("c",Type.Character));  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outtext",parameter("t",Type.Text));   
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Text,"FIELD_",parameter("w",Type.Integer));  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outint",parameter("i",Type.Integer),parameter("w",Type.Integer));  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outfrac",parameter("i",Type.Integer),parameter("n",Type.Integer),parameter("w",Type.Integer));  
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outfix", parameter("r",new OverLoad(Type.Real,Type.LongReal)),parameter("n",Type.Integer),parameter("w",Type.Integer)); 
		Directfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outreal",parameter("r",new OverLoad(Type.Real,Type.LongReal)),parameter("n",Type.Integer),parameter("w",Type.Integer)); 
	}  

	// ******************************************************************
	// *** The Standard Outfile Class Printfile
	// ******************************************************************
	/**
	 * Initiate the Standard Class Printfile
	 * <pre>
	 *  Outfile class Printfile;
	 *  begin integer LINE, LINES_PER_PAGE, SPACING, PAGE;
	 *    integer procedure line; line := LINE;
	 *    integer procedure page; page := PAGE;
	 *    Boolean procedure open(fileimage); text fileimage; 
	 *    Boolean procedure close; 
	 *    integer procedure linesperpage(n); integer n; 
	 *    procedure spacing(n); integer n; 
	 *    procedure eject(n);  integer n; 
	 *    procedure outimage;
	 *    procedure outrecord;
	 *
	 *    SPACING := 1;
	 *    LINES_PER_PAGE := ... ;
	 *    ...
	 *  end Printfile;
	 * </pre>
	 */
	private static void initPrintfile() {
		Printfile=new StandardClass("Outfile","Printfile");
		BASICIO.addStandardClass(Printfile);  // Declared in BASICIO
		Printfile.addStandardAttribute(Type.Integer,"LINE_");  
		Printfile.addStandardAttribute(Type.Integer,"LINES_PER_PAGE_");  
		Printfile.addStandardAttribute(Type.Integer,"SPACING_");  
		Printfile.addStandardAttribute(Type.Integer,"PAGE_");  
		Printfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"line"); 
		Printfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"page");  
		Printfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"open",parameter("fileimage",Type.Text));  
		Printfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"close");  
		Printfile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"linesperpage",parameter("n",Type.Integer));  
		Printfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"spacing",parameter("n",Type.Integer));  
		Printfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"eject",parameter("n",Type.Integer));  
		Printfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outimage");  
		Printfile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outrecord");  
	}  

	// ******************************************************************
	// *** The Standard file Class Bytefile
	// ******************************************************************
	/**
	 * The Standard Class Bytefile
	 */
	private static StandardClass Bytefile;

	/**
	 * Initiate the Standard Class Bytefile
	 * <pre>
	 *  file class Bytefile;
	 *  begin short integer BYTESIZE;
	 *     short integer procedure bytesize; bytesize := BYTESIZE;
	 *
	 *  end Bytefile;
	 * </pre>
	 */
	private static void initBytefile() { 
		Bytefile=new StandardClass("File","Bytefile");
		BASICIO.addStandardClass(Bytefile);  // Declared in BASICIO
		Bytefile.addStandardAttribute(Type.Integer,"BYTESIZE_");  
		Bytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"bytesize");  
	}  

	// ******************************************************************
	// *** The Standard Bytefile Class Inbytefile
	// ******************************************************************
	/**
	 * Initiate the Standard Class Inbytefile
	 * <pre>
	 *  Bytefile class Inbytefile;
	 *  begin Boolean ENDFILE;
	 *    Boolean procedure endfile; endfile:= ENDFILE;
	 *    Boolean procedure open; 
	 *    Boolean procedure close;
	 *    short integer procedure inbyte;
	 *    text procedure intext(t); text t; 
	 *
	 *    ENDFILE:= true;
	 *    ...
	 *  end Inbytefile;
	 * </pre>
	 */
	private static void initInbytefile() { 
		StandardClass Inbytefile=new StandardClass("Bytefile","Inbytefile");
		BASICIO.addStandardClass(Inbytefile);  // Declared in BASICIO
		Inbytefile.addStandardAttribute(Type.Boolean,"ENDFILE_");  
		Inbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"endfile");  
//		Inbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"open",parameter("fileimage",Type.Text));  
		Inbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"open");  // TODO: TESTING
		Inbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"close");  
		Inbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"inbyte");  
		Inbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Text,"intext",parameter("t",Type.Text));
		if(Option.EXTENSIONS) {
			Inbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"in2byte");  // Extension to Simula Standard
		}
	}  

	// ******************************************************************
	// *** The Standard Bytefile Class Outbytefile
	// ******************************************************************
	/**
	 * Initiate the Standard Class Outbytefile
	 * <pre>
	 *  Bytefile class Outbytefile;
	 *  begin
	 *    Boolean procedure open; 
	 *    Boolean procedure close; 
	 *    procedure outbyte(x); short integer x; 
	 *    procedure outtext(t); text t; 
	 *    Boolean procedure checkpoint; 
	 *
	 *  end Outbytefile;
	 * </pre>
	 */
	private static void initOutbytefile() { 
		StandardClass Outbytefile=new StandardClass("Bytefile","Outbytefile");
		BASICIO.addStandardClass(Outbytefile);
//		Outbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"open",parameter("fileimage",Type.Text));  
		Outbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"open");   // TODO: TESTING
		Outbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"close");  
		Outbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outbyte",parameter("x",Type.Integer));   
		Outbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outtext",parameter("t",Type.Text));  
		Outbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"checkpoint");  
		if(Option.EXTENSIONS) {
			Outbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"out2byte",parameter("x",Type.Integer));   			
		}
	}  

	// ******************************************************************
	// *** The Standard Bytefile Class Directbytefile
	// ******************************************************************
	/**
	 * Initiate the Standard Class Directbytefile
	 * <pre>
	 *  Bytefile class Directbytefile;
	 *  begin integer LOC, MAXLOC;  Boolean LOCKED;
	 *    Boolean procedure endfile; endfile:=OPEN and then LOC>lastloc;
	 *    integer procedure location; location := LOC;
	 *    integer procedure maxloc; maxloc := MAXLOC;
	 *    Boolean procedure locked; locked := LOCKED;
	 *    Boolean procedure open; 
	 *    Boolean procedure close; 
	 *    integer procedure lastloc; 
	 *    procedure locate(i); integer i; 
	 *    short integer procedure inbyte; 
	 *    procedure outbyte(x); short integer x; 
	 *    Boolean procedure checkpoint; 
	 *    integer procedure lock(t,i,j); real t; integer i,j; 
	 *    Boolean procedure unlock; 
	 *    procedure intext(t); text t; 
	 *    procedure outtext(t); text t;
	 *     ...
	 *  end Directbytefile;
	 * </pre>
	 */
	private static void initDirectbytefile() { 
		StandardClass Directbytefile=new StandardClass("Bytefile","Directbytefile");
		BASICIO.addStandardClass(Directbytefile);  // Declared in BASICIO
		Directbytefile.addStandardAttribute(Type.Integer,"LOC_");  
		Directbytefile.addStandardAttribute(Type.Integer,"MAXLOC_");  
		Directbytefile.addStandardAttribute(Type.Boolean,"LOCKED_");  
		Directbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"endfile");  
		Directbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"location");  
		Directbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"maxloc");  
		Directbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"locked");  
//		Directbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"open",parameter("fileimage",Type.Text));  
		Directbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"open");   // TODO: TESTING
		Directbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"close");      
		Directbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"lastloc");  
		Directbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"locate",parameter("i",Type.Integer));  
		Directbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"inbyte");  
		Directbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outbyte",parameter("x",Type.Integer));   
		Directbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"out2byte",parameter("x",Type.Integer));   
		//	    Directbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"checkpoint");  
		Directbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"lock",parameter("t",Type.Real),parameter("i",Type.Integer),parameter("j",Type.Integer));  
		Directbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"unlock");  
		Directbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Text,"intext",parameter("t",Type.Text));  
		Directbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outtext",parameter("t",Type.Text));  
		Directbytefile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"checkpoint");  
	}  

	// ******************************************************************
	// *** The Standard Class Simset
	// ******************************************************************
	/**
	 * The Standard Class Simset
	 */
	private static StandardClass Simset;

	/**
	 * Initiate the Standard Class Simset
	 */
	private static void initSimset() { 
		Simset=new StandardClass("CLASS","Simset");
		ENVIRONMENT.addStandardClass(Simset);  // Declared in ENVIRONMENT
	}  

	// ******************************************************************
	// *** The Standard Class Linkage
	// ******************************************************************
	/**
	 * The Standard Class Linkage
	 */
	private static StandardClass Linkage;

	/**
	 * Initiate the Standard Class Linkage
	 */
	private static void initLinkage() { 
		Linkage=new StandardClass("CLASS","Linkage");
		Simset.addStandardClass(Linkage);  // Declared in Simset
		Linkage.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("Link"),"suc");  
		Linkage.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("Link"),"pred");  
		Linkage.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("Linkage"),"prev");  
	}  

	// ******************************************************************
	// *** The Standard Linkage Class Head
	// ******************************************************************
	/**
	 * Initiate the Standard Class Head
	 */
	private static void initHead() {
		StandardClass Head=new StandardClass("Linkage","Head");
		Simset.addStandardClass(Head);  // Declared in Simset
		Head.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("Link"),"first");  
		Head.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("Link"),"last");  
		Head.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"empty");  
		Head.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"cardinal");  
		Head.addStandardProcedure(Declaration.Kind.MemberMethod,null,"clear");  
	}  

	// ******************************************************************
	// *** The Standard Linkage Class Link
	// ******************************************************************
	/**
	 * Initiate the Standard Class Link
	 */
	private static void initLink() { 
		StandardClass Link=new StandardClass("Linkage","Link");
		Simset.addStandardClass(Link);  // Declared in Simset
		Link.addStandardProcedure(Declaration.Kind.MemberMethod,null,"out");  
		Link.addStandardProcedure(Declaration.Kind.MemberMethod,null,"follow",parameter("X",Type.Ref("Linkage")));  
		Link.addStandardProcedure(Declaration.Kind.MemberMethod,null,"precede",parameter("X",Type.Ref("Linkage")));  
		Link.addStandardProcedure(Declaration.Kind.MemberMethod,null,"into",parameter("S",Type.Ref("Head")));  
	}  

	// ******************************************************************
	// *** The Standard Class Simulation
	// ******************************************************************
	/**
	 * The Standard Class Simulation
	 */
	private static StandardClass Simulation;	

	/**
	 * Initiate the Standard Class Simulation
	 */
	private static void initSimulation() { 
		Simulation=new StandardClass("Simset","Simulation");
		ENVIRONMENT.addStandardClass(Simulation);  // Declared in ENVIRONMENT
		Simulation.detachUsed=true;
		//	    Simulation.code1=codeSet( // Statements before inner 
		//	    		new CodeLine(1,"SQS = (Head_) new Head_(this)._STM();"),
		//	    		new CodeLine(1,"main = (MAIN_PROGRAM_) new MAIN_PROGRAM_((Simulation_) _CUR)._START();"),
		//	    		new CodeLine(1,"main.EVENT = (EVENT_NOTICE_) new EVENT_NOTICE_((Simulation_) _CUR, 0, main)._STM();"),
		//	    		new CodeLine(1,"main.EVENT.into(SQS);"));
		Simulation.addStandardAttribute(Type.Ref("Head"),"SQS");  
		Simulation.addStandardAttribute(Type.Ref("MAIN_PROGRAM"),"main");  
		Simulation.addStandardProcedure(Declaration.Kind.MemberMethod,Type.LongReal,"time");  
		Simulation.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("EVENT_NOTICE"),"FIRSTEV");  
		Simulation.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("Process"),"current");  
		Simulation.addStandardProcedure(Declaration.Kind.MemberMethod,null,"hold",parameter("T",Type.LongReal));  
		Simulation.addStandardProcedure(Declaration.Kind.MemberMethod,null,"passivate");  
		Simulation.addStandardProcedure(Declaration.Kind.MemberMethod,null,"wait",parameter("S",Type.Ref("Head")));  
		Simulation.addStandardProcedure(Declaration.Kind.MemberMethod,null,"cancel",parameter("x",Type.Ref("Process")));  
		Simulation.addStandardProcedure(Declaration.Kind.MemberMethod,null,"accum",parameter("a",Parameter.Mode.name,Type.LongReal),parameter("b",Parameter.Mode.name,Type.LongReal)
				,parameter("c",Parameter.Mode.name,Type.LongReal),parameter("d",Type.LongReal));    
		Simulation.addStandardProcedure(Declaration.Kind.MemberMethod,null,"ActivateDirect"
				,parameter("REAC",Type.Boolean)
				,parameter("X",Type.Ref("Process"))
				);  
		Simulation.addStandardProcedure(Declaration.Kind.MemberMethod,null,"ActivateAt"
				,parameter("REAC",Type.Boolean)
				,parameter("X",Type.Ref("Process"))
				,parameter("T",Type.LongReal)
				,parameter("PRIO",Type.Boolean)
				);  
		Simulation.addStandardProcedure(Declaration.Kind.MemberMethod,null,"ActivateDelay"
				,parameter("REAC",Type.Boolean)
				,parameter("X",Type.Ref("Process"))
				,parameter("T",Type.LongReal)
				,parameter("PRIO",Type.Boolean)
				);  
		Simulation.addStandardProcedure(Declaration.Kind.MemberMethod,null,"ActivateBefore"
				,parameter("REAC",Type.Boolean)
				,parameter("X",Type.Ref("Process"))
				,parameter("Y",Type.Ref("Process"))
				);  
		Simulation.addStandardProcedure(Declaration.Kind.MemberMethod,null,"ActivateAfter"
				,parameter("REAC",Type.Boolean)
				,parameter("X",Type.Ref("Process"))
				,parameter("Y",Type.Ref("Process"))
				);  
	}  

	// ******************************************************************
	// *** The Standard Link Class EVENT_NOTICE
	// ******************************************************************
	/**
	 * Initiate the Standard Class EVENT_NOTICE
	 */
	private static void initEVENT_NOTICE() { 
		StandardClass EVENT_NOTICE=new StandardClass("Link","EVENT_NOTICE");
		Simulation.addStandardClass(EVENT_NOTICE);  // Declared in Simulation
		//	    ref(EVENT_NOTICE) procedure suc;
		//	    ref(EVENT_NOTICE) procedure pred;
		//	    procedure RANK(BEFORE_); Boolean BEFORE_;
		EVENT_NOTICE.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("EVENT_NOTICE"),"suc");  
		EVENT_NOTICE.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("EVENT_NOTICE"),"pred");  
		EVENT_NOTICE.addStandardProcedure(Declaration.Kind.MemberMethod,null,"RANK",parameter("BEFORET",Type.Boolean));  
	}  

	// ******************************************************************
	// *** The Standard Link Class Process
	// ******************************************************************
	/**
	 * The Standard Class Process
	 */
	private static StandardClass Process;

	/**
	 * Initiate the Standard Class Process
	 */
	private static void initProcess() { 
		Process=new StandardClass("Link","Process");
		Simulation.addStandardClass(Process);  // Declared in Simulation
		Process.detachUsed=true;
		Process.code1=codeSet(new CodeLine("Process",1,"detach();"));    // Statements before inner 
		Process.code2=codeSet(new CodeLine("Process",3,"terminate();")); // Statements after inner 
		//	    ref(EVENT_NOTICE) EVENT;
		//	    Boolean TERMINATED_;
		//	    Boolean procedure idle;
		//	    Boolean procedure terminated;
		//	    real procedure evtime;
		//	    ref(Process) procedure nextev;
		Process.addStandardAttribute(Type.Ref("EVENT_NOTICE"),"EVENT");  
		Process.addStandardAttribute(Type.Boolean,"TERMINATED_");  
		Process.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"idle");  
		Process.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"terminated");  
		Process.addStandardProcedure(Declaration.Kind.MemberMethod,Type.LongReal,"evtime");  
		Process.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("Process"),"nextev");  
	}  

	// ******************************************************************
	// *** The Standard Process Class MAIN_PROGRAM
	// ******************************************************************
	/**
	 * Initiate the Standard Class MAIN_PROGRAM
	 */
	private static void initMAIN_PROGRAM() { 
		StandardClass MAIN_PROGRAM=new StandardClass("Process","MAIN_PROGRAM");
		Simulation.addStandardClass(MAIN_PROGRAM);   // Declared in Simulation
		//	    Process class MAIN_PROGRAM;
		//	    begin
		//	       L: detach; goto L
		//	    end MAIN_PROGRAM;
	}  


	// ******************************************************************
	// *** The Standard Class CatchingErrors  NOTE: if(Option.EXTENSIONS)
	// ******************************************************************
	/**
	 * Initiate the Standard Class CatchingErrors
	 */
	private static void initCatchingErrors() { 
		StandardClass CatchingErrors=new StandardClass("CLASS","CatchingErrors");
		ENVIRONMENT.addStandardClass(CatchingErrors);  // Declared in ENVIRONMENT
		CatchingErrors.virtualSpecList.add(new VirtualSpecification("onError",null,VirtualSpecification.Kind.Procedure,null));
		CatchingErrors.code1=codeSet( // Statements before inner 
				new CodeLine("CatchingErrors",1,"try {"));      
		CatchingErrors.code2=codeSet( // Statements after inner 
				new CodeLine("CatchingErrors",3,"} catch(RuntimeException e) { _CUR=this; _onError(e,onError_0()); }"));
	}  

	
	// ******************************************************************
	// *** The Standard Class DEC_Lib   - as defined in DEC handbook III    NOTE: if(Option.EXTENSIONS)
	// ******************************************************************
	/**
	 * Initiate the Standard Class DEC_Lib
	 */
	private static void initDEC_Lib() { 
		StandardClass DEC_Lib=new StandardClass("CLASS","DEC_Lib");
		ENVIRONMENT.addStandardClass(DEC_Lib);  // Declared in ENVIRONMENT.
		DEC_Lib.isContextFree=true; // This class is a Context i.e. all members are static
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"abort",parameter("mess",Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Boolean,"change",parameter("m",Parameter.Mode.name,Type.Text),parameter("o",Type.Text),parameter("n",Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"checkextension",parameter("fileName",Type.Text),parameter("defaultextension",Parameter.Mode.value,Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"checkfrac",parameter("t",Parameter.Mode.name,Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"checkint",parameter("t",Parameter.Mode.name,Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"checkreal",parameter("t",Parameter.Mode.name,Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"compress",parameter("t",Type.Text),parameter("c",Type.Character));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"conc",parameter("t1",Type.Text),parameter("t2",Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"conc2",parameter("t1",Type.Text),parameter("t2",Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"conc3",parameter("t1",Type.Text),parameter("t2",Type.Text),parameter("t3",Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"conc4",parameter("t1",Type.Text),parameter("t2",Type.Text),parameter("t3",Type.Text),parameter("t4",Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"conc5",parameter("t1",Type.Text),parameter("t2",Type.Text),parameter("t3",Type.Text),parameter("t4",Type.Text),parameter("t5",Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"cptime");  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"dayno");  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"daytime");  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"depchar",parameter("t",Type.Text),parameter("p",Type.Integer),parameter("c",Type.Character));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"enterdebug",parameter("maycontinue",Type.Boolean));
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"exit",parameter("code",Type.Integer));
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Character,"fetchar",parameter("t",Type.Text),parameter("p",Type.Integer));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Character,"findtrigger",parameter("master",Parameter.Mode.name,Type.Text),parameter("triggers",Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"from",parameter("t",Type.Text),parameter("p",Type.Integer));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"front",parameter("t",Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Boolean,"frontcompare",parameter("string",Type.Text),parameter("config",Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"frontstrip",parameter("t",Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"getitem",parameter("tt",Parameter.Mode.name,Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"hash",parameter("t",Type.Text),parameter("n",Type.Integer));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"initem",parameter("f",Type.Ref("File")));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"linecount",parameter("pf",Type.Ref("Printfile")));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Character,"insinglechar");  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Character,"lowc",parameter("c",Type.Character));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"maketext",parameter("c",Type.Character),parameter("n",Type.Integer));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Boolean,"puttext",parameter("ot",Parameter.Mode.name,Type.Text),parameter("nt",Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"rest",parameter("t",Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Character,"scanchar",parameter("t",Parameter.Mode.name,Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"scanfrac",parameter("tt",Parameter.Mode.name,Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"scanint",parameter("tt",Parameter.Mode.name,Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"scanreal",parameter("tt",Parameter.Mode.name,Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"scanto",parameter("t",Parameter.Mode.name,Type.Text),parameter("c",Type.Character));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"search",parameter("t1",Type.Text),parameter("t2",Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"skip",parameter("t",Parameter.Mode.name,Type.Text),parameter("c",Type.Character));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"startpos",parameter("t",Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"today");  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"tsub",parameter("t",Type.Text),parameter("p",Type.Integer),parameter("l",Type.Integer));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Character,"upc",parameter("c",Type.Character));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Boolean,"upcompare",parameter("master",Type.Text),parameter("test",Type.Text));  
		DEC_Lib.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"upto",parameter("t",Type.Text),parameter("p",Type.Integer));  
	}  

	// ******************************************************************
	// *** The Standard Class Drawing    NOTE: if(Option.EXTENSIONS)
	// ******************************************************************
	/**
	 * The Standard Class Drawing
	 */
	private static StandardClass Drawing;

	/**
	 * Initiate the Standard Class Drawing
	 */
	private static void initDrawing() {
		Drawing=new StandardClass("Simset","Drawing",parameter("Title",Type.Text),parameter("width",Type.Integer),parameter("height",Type.Integer)); 
		ENVIRONMENT.addStandardClass(Drawing);  // Declared in ENVIRONMENT
		//	    Drawing.code1=codeSet( // Statements before inner 
		//	  		new CodeLine(1,"// RENDERING_SET = (Head_) new Head_(Drawing_.this)._STM();"),
		//	  		new CodeLine(1,"// init(title.edText(),width,height);")
		//	  		);
		Drawing.addStandardAttribute(Type.Integer,"white",    0xffffff); // Color white:      R=255, G=255, B=255.
		Drawing.addStandardAttribute(Type.Integer,"lightGray",0xc0c0c0); // Color light gray: R=192, G=192, B=192.  
		Drawing.addStandardAttribute(Type.Integer,"gray",     0x808080); // Color gray:       R=128, G=128, B=128. 
		Drawing.addStandardAttribute(Type.Integer,"darkGray", 0x404040); // Color dark gray:  R=64,  G=64,  B=64.
		Drawing.addStandardAttribute(Type.Integer,"black",    0x000000); // Color black:      R=0,   G=0,   B=0.  
		Drawing.addStandardAttribute(Type.Integer,"red",      0xff0000); // Color red:        R=255, G=0,   B=0. 
		Drawing.addStandardAttribute(Type.Integer,"pink",     0xffafaf); // Color pink:       R=255, G=175, B=175.
		Drawing.addStandardAttribute(Type.Integer,"orange",   0xffc800); // Color orange:     R=255, G=200, B=0. 
		Drawing.addStandardAttribute(Type.Integer,"yellow",   0xffff00); // Color yellow:     R=255, G=255, B=0. 
		Drawing.addStandardAttribute(Type.Integer,"green",    0x00ff00); // Color green:      R=0,   G=255, B=0.
		Drawing.addStandardAttribute(Type.Integer,"magenta",  0xff00ff); // Color magenta:    R=255, G=0,   B=255.
		Drawing.addStandardAttribute(Type.Integer,"cyan",     0x00ffff); // Color cyan:       R=0,   G=255, B=255.
		Drawing.addStandardAttribute(Type.Integer,"blue",     0x0000ff); // Color blue:       R=0,   G=0,   B=255.
		Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"color",parameter("r",Type.Integer),parameter("g",Type.Integer),parameter("b",Type.Integer));  
		Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,null,"setBackgroundColor",parameter("color",Type.Integer));  
		Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,null,"setDrawColor",parameter("color",Type.Integer));  
		Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,null,"setFillColor",parameter("color",Type.Integer));  
		Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,null,"setStroke",parameter("width",Type.Real));  

		Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("Head"),"renderingSet");  
		Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,null,"setFontStylePlain");  
		Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,null,"setFontStyleBold");  
		Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,null,"setFontStyleItalic");  
		Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,null,"setFontStyleBoldItalic");  
		Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,null,"setFontSize",parameter("size",Type.Real));  
		Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Real,"getFontSize");  

		Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("TextElement"),"drawText",parameter("t",Type.Text),parameter("x",Type.LongReal),parameter("y",Type.LongReal));  
		Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("ShapeElement"),"drawLine",parameter("x1",Type.LongReal),parameter("y1",Type.LongReal),parameter("x2",Type.LongReal),parameter("y2",Type.LongReal));  
		Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("ShapeElement"),"drawEllipse",parameter("x",Type.LongReal),parameter("y",Type.LongReal),parameter("width",Type.LongReal),parameter("height",Type.LongReal));  
		Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("ShapeElement"),"drawRectangle",parameter("x",Type.LongReal),parameter("y",Type.LongReal),parameter("width",Type.LongReal),parameter("height",Type.LongReal));  
		Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("ShapeElement"),"drawRoundRectangle",parameter("x",Type.LongReal),parameter("y",Type.LongReal),parameter("width",Type.LongReal)
				,parameter("height",Type.LongReal),parameter("arcw",Type.LongReal),parameter("arch",Type.LongReal));  
		Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("ShapeElement"),"fillEllipse",parameter("x",Type.LongReal),parameter("y",Type.LongReal),parameter("width",Type.LongReal),parameter("height",Type.LongReal));  
		Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("ShapeElement"),"fillRectangle",parameter("x",Type.LongReal),parameter("y",Type.LongReal),parameter("width",Type.LongReal),parameter("height",Type.LongReal));  
		Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("ShapeElement"),"fillRoundRectangle",parameter("x",Type.LongReal),parameter("y",Type.LongReal),parameter("width",Type.LongReal)
				,parameter("height",Type.LongReal),parameter("arcw",Type.LongReal),parameter("arch",Type.LongReal));  
	}

	// ******************************************************************
	// *** The Standard Link Class ShapeElement    NOTE: if(Option.EXTENSIONS)
	// ******************************************************************
	/**
	 * Initiate the Standard Class ShapeElement
	 */
	private static void initShapeElement() {
		StandardClass ShapeElement=new StandardClass("Link","ShapeElement");
		Drawing.addStandardClass(ShapeElement);  // Declared in Drawing
		//	    ShapeElement.code1=codeSet( // Statements before inner 
		//			new CodeLine(1,"this.stroke=drawing.currentStroke;"),
		//			new CodeLine(1,"this.into(drawing.RENDERING_SET);")
		//			);
		ShapeElement.addStandardProcedure(Declaration.Kind.MemberMethod,null,"setColor",parameter("color",Type.Integer));  
		ShapeElement.addStandardProcedure(Declaration.Kind.MemberMethod,null,"drawLine",parameter("x1",Type.LongReal),parameter("y1",Type.LongReal),parameter("x2",Type.LongReal),parameter("y2",Type.LongReal));  
		ShapeElement.addStandardProcedure(Declaration.Kind.MemberMethod,null,"drawEllipse",parameter("x",Type.LongReal),parameter("y",Type.LongReal),parameter("width",Type.LongReal),parameter("height",Type.LongReal));  
		ShapeElement.addStandardProcedure(Declaration.Kind.MemberMethod,null,"drawRectangle",parameter("x",Type.LongReal),parameter("y",Type.LongReal),parameter("width",Type.LongReal),parameter("height",Type.LongReal));  
		ShapeElement.addStandardProcedure(Declaration.Kind.MemberMethod,null,"drawRoundRectangle",parameter("x",Type.LongReal),parameter("y",Type.LongReal),parameter("width",Type.LongReal)
				,parameter("height",Type.LongReal),parameter("arcw",Type.LongReal),parameter("arch",Type.LongReal));  
		ShapeElement.addStandardProcedure(Declaration.Kind.MemberMethod,null,"fillEllipse",parameter("x",Type.LongReal),parameter("y",Type.LongReal),parameter("width",Type.LongReal),parameter("height",Type.LongReal));  
		ShapeElement.addStandardProcedure(Declaration.Kind.MemberMethod,null,"fillRectangle",parameter("x",Type.LongReal),parameter("y",Type.LongReal),parameter("width",Type.LongReal),parameter("height",Type.LongReal));  
		ShapeElement.addStandardProcedure(Declaration.Kind.MemberMethod,null,"fillRoundRectangle",parameter("x",Type.LongReal),parameter("y",Type.LongReal),parameter("width",Type.LongReal)
				,parameter("height",Type.LongReal),parameter("arcw",Type.LongReal),parameter("arch",Type.LongReal));  
		ShapeElement.addStandardProcedure(Declaration.Kind.MemberMethod,null,"instantMoveTo",parameter("x",Type.LongReal),parameter("y",Type.LongReal));  
		ShapeElement.addStandardProcedure(Declaration.Kind.MemberMethod,null,"moveTo",parameter("x",Type.LongReal),parameter("y",Type.LongReal),parameter("speed",Type.LongReal));  
	}

	// ******************************************************************
	// *** The Standard Link Class TextElement    NOTE: if(Option.EXTENSIONS)
	// ******************************************************************
	/**
	 * Initiate the Standard Class TextElement
	 */
	private static void initTextElement() {
		StandardClass TextElement=new StandardClass("Link","TextElement",parameter("txt",Type.Text),parameter("x",Type.LongReal),parameter("y",Type.LongReal));  
		Drawing.addStandardClass(TextElement);  // Declared in Drawing
		TextElement.addStandardProcedure(Declaration.Kind.MemberMethod,null,"setColor",parameter("color",Type.Integer));  
		TextElement.addStandardProcedure(Declaration.Kind.MemberMethod,null,"setStroke",parameter("width",Type.Real));  
		TextElement.addStandardProcedure(Declaration.Kind.MemberMethod,null,"setFontStylePlain");  
		TextElement.addStandardProcedure(Declaration.Kind.MemberMethod,null,"setFontStyleBold");  
		TextElement.addStandardProcedure(Declaration.Kind.MemberMethod,null,"setFontStyleItalic");  
		TextElement.addStandardProcedure(Declaration.Kind.MemberMethod,null,"setFontStyleBoldItalic");  
		TextElement.addStandardProcedure(Declaration.Kind.MemberMethod,null,"setFontSize",parameter("size",Type.Real));  
		TextElement.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Real,"getFontSize");  

		TextElement.addStandardProcedure(Declaration.Kind.MemberMethod,null,"setText",parameter("t",Type.Text));  
		TextElement.addStandardProcedure(Declaration.Kind.MemberMethod,null,"instantMoveTo",parameter("x",Type.LongReal),parameter("y",Type.LongReal));  
		TextElement.addStandardProcedure(Declaration.Kind.MemberMethod,null,"moveTo",parameter("x",Type.LongReal),parameter("y",Type.LongReal),parameter("speed",Type.LongReal));  
	}





	// ******************************************************************
	// *** Constructors
	// ******************************************************************

	/**
	 * Create a new StandardClass
	 * @param className the class's name
	 */
	private StandardClass(String className) {
		super(className);
		this.externalIdent="RTS_"+className;
		this.declarationKind=Declaration.Kind.StandardClass;
		this.type=Type.Ref(className);
	}

	/**
	 * Create a new StandardClass
	 * @param prefix prefix class-identifier
	 * @param className the class's name
	 */
	private StandardClass(String prefix,String className) {
		this(className);
		this.prefix=prefix;
	}

	/**
	 * Create a new StandardClass
	 * @param prefix prefix class-identifier
	 * @param className the class's name
	 * @param param the parameters
	 */
	private StandardClass(String prefix,String className,Parameter... param) {
		this(prefix,className);
		for(int i=0;i<param.length;i++) param[i].into(parameterList);
	}

	// ******************************************************************
	// *** Lookup Meaning
	// ******************************************************************

	@Override
	public Meaning findVisibleAttributeMeaning(String ident) {
		if(Option.TRACE_FIND_MEANING>0) Util.println("BEGIN Checking Standard Class "+identifier+" for "+ident+" ================================== "+identifier+" ==================================");
		for(Declaration declaration:declarationList) {
			if(Option.TRACE_FIND_MEANING>1) Util.println("Checking Local "+declaration.identifier);
			if(Util.equals(ident, declaration.identifier)) {
				return(new Meaning(declaration,this));
			}
		}
		if(Option.TRACE_FIND_MEANING>0) Util.println("ENDOF Checking Standard Class "+identifier+" for "+ident+" ================================== "+identifier+" ==================================");
		ClassDeclaration prfx=getPrefixClass();
		if(prfx!=null) return(prfx.findVisibleAttributeMeaning(ident));
		return(null);
	}

	@Override
	public Meaning findRemoteAttributeMeaning(String ident) {
		for(Declaration declaration:declarationList)
			if(Util.equals(ident, declaration.identifier))
				return(new Meaning(declaration,this));
		ClassDeclaration prfx=getPrefixClass();
		if(prfx!=null) return(prfx.findRemoteAttributeMeaning(ident));
		return(null);
	}

	// ******************************************************************
	// *** PRIVATE UTILITIES
	// ******************************************************************

	/**
	 * Utility to hold a set of Java code lines
	 * @param codeLine a sequence of Java code lines
	 * @return the resulting set of Java code lines
	 */
	private static Vector<CodeLine> codeSet(CodeLine... codeLine) {
		Vector<CodeLine> set=new Vector<CodeLine>();
		for(CodeLine c:codeLine) set.add(c);
		return(set);
	}

	// ******************************************************************
	// *** Parameter Specifications
	// ******************************************************************

	/**
	 * Create a new Parameter
	 * @param ident the identifier
	 * @param type  the type
	 * @return the newly created Parameter
	 */
	private static Parameter parameter(String ident,Type type)	{
		return(new Parameter(ident,type,Parameter.Kind.Simple)); }

	/**
	 * Create a new Parameter
	 * @param ident the identifier
	 * @param type  the type
	 * @param kind  the parameter kind
	 * @return the newly created Parameter
	 */
	private static Parameter parameter(String ident,Type type,Parameter.Kind kind)	{
		return(new Parameter(ident,type,kind)); }

	/**
	 * Create a new Parameter
	 * @param ident the identifier
	 * @param type  the type
	 * @param kind  the parameter kind
	 * @param nDim  number of dimensions for arrays
	 * @return the newly created Parameter
	 */
	private static Parameter parameter(String ident,Type type,Parameter.Kind kind,int nDim)	{
		return(new Parameter(ident,type,kind,nDim)); }

	/**
	 * Create a new Parameter
	 * @param ident the identifier
	 * @param mode  the mode
	 * @param type  the type
	 * @return the newly created Parameter
	 */
	private static Parameter parameter(String ident,Parameter.Mode mode,Type type) {
		Parameter spec=new Parameter(ident,type,Parameter.Kind.Simple);
		spec.setMode(mode); return(spec);
	}

	/**
	 * Create a new Parameter
	 * @param ident the identifier
	 * @param kind  the parameter kind
	 * @param mode  the mode
	 * @param type  the type
	 * @return the newly created Parameter
	 */
	private static Parameter parameter(String ident,Parameter.Kind kind,Parameter.Mode mode,Type type) {
		Parameter spec=new Parameter(ident,type,kind);
		spec.setMode(mode); return(spec);
	}


	// ******************************************************************
	// *** Add Class / Attribute / Procedure
	// ******************************************************************

	/**
	 * Add a StandardClass
	 * @param standardClass the StandardClass
	 */
	private void addStandardClass(StandardClass standardClass) {
		standardClass.declaredIn=this;
		((ClassDeclaration)standardClass.declaredIn).hasLocalClasses=true;
		declarationList.add(standardClass);
	}

	/**
	 * Create and add a new standard attribute
	 * @param type the attribute type
	 * @param ident the attribute identifier
	 */
	private void addStandardAttribute(Type type,String ident) {
		declarationList.add(new SimpleVariableDeclaration(type,ident)); }

	/**
	 * Create and add a new constant standard attribute
	 * @param type the attribute type
	 * @param ident the attribute identifier
	 * @param iValue the constant integer value
	 */
	private void addStandardAttribute(Type type,String ident,Number value) {
		declarationList.add(new SimpleVariableDeclaration(type,ident,true,new Constant(type,value))); }

	/**
	 * Create and add a new StandardProcedure
	 * @param kind the declaration kind
	 * @param type the procedure's type
	 * @param ident the procedure identifier
	 */
	private void addStandardProcedure(Declaration.Kind kind,Type type,String ident) {
		declarationList.add(new StandardProcedure(this,kind,type,ident)); }

	/**
	 * Create and add a new StandardProcedure
	 * @param kind the declaration kind
	 * @param type the procedure's type
	 * @param ident the procedure identifier
	 * @param param the parameters
	 */
	private void addStandardProcedure(Declaration.Kind kind,Type type,String ident,Parameter... param) {
		declarationList.add(new StandardProcedure(this,kind,type,ident,param)); }

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	/**
	 * Default constructor used by Externalization.
	 */
	public StandardClass() {
		super(null);
	}


}


