/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.OverLoad;
import simula.compiler.utilities.Type;

import java.util.Vector;

import simula.compiler.CodeLine;
import simula.compiler.expression.Constant;

public final class StandardClass extends ClassDeclaration
{
  public Declaration.Kind getBlockKind() { return(Declaration.Kind.StandardClass); }
  public String edJavaClassName() { return(identifier); }
//  public String getJavaIdentifier() { return(identifier+"$"); }
  
  // ******************************************************************
  // *** The Type TXT
  // ******************************************************************
  public static StandardClass typeText=new StandardClass("TXT");
  static // Define attribute procedures to Type TXT
  {	typeText.isContextFree=true;
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
    typeText.addStandardProcedure(Declaration.Kind.MemberMethod,new OverLoad(Type.Real,Type.LongReal),"putfix", parameter("r",new OverLoad(Type.Real,Type.LongReal)),parameter("n",Type.Integer)); 
    typeText.addStandardProcedure(Declaration.Kind.MemberMethod,new OverLoad(Type.Real,Type.LongReal),"putreal",parameter("r",new OverLoad(Type.Real,Type.LongReal)),parameter("n",Type.Integer)); 
  }
  
  // ******************************************************************
  // *** The Standard Class UNIVERSE
  // ******************************************************************
  public static StandardClass UNIVERSE=new StandardClass("UNIVERSE");
  static
  {	UNIVERSE.isContextFree=true;
    UNIVERSE.declaredIn=null;
  }
  
  // ******************************************************************
  // *** The Standard Class RTObject - Prefix to all classes
  // ******************************************************************
  public static StandardClass RTObject=new StandardClass("RTObject");
  static
  { UNIVERSE.addStandardClass(RTObject); // Declared in UNIVERSE
    RTObject.isContextFree=true;
    RTObject.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Text,"objectTraceIdentifier");
    RTObject.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Text,"waitSomeTime",parameter("millies",Type.Integer));
  }
  
  // ******************************************************************
  // *** The Standard Class ENVIRONMENT
  // ******************************************************************
  // TODO: Rettes slik at alle genererte metoder blir static.
  //       Ta med et flag (enten i klassen eller i alle procedurene
  //       Dettte svarer til diskusjonen om innføring av 'context class'
  //  
  public static StandardClass ENVIRONMENT=new StandardClass("RTObject","ENVIRONMENT");
  static
  { UNIVERSE.addStandardClass(ENVIRONMENT); // Declared in UNIVERSE
    ENVIRONMENT.isContextFree=true; // This class is a Context i.e. all members are static
    
//    Environmental enquiries ................................. 9.6
//    Procedure sourceline.
//    Constants  maxrank, maxint, minint, maxreal, minreal,
//      maxlongreal, minlongreal, simulaid.

    ENVIRONMENT.addStandardAttribute(Type.LongReal,"maxlongreal");  
    ENVIRONMENT.addStandardAttribute(Type.LongReal,"minlongreal");  
    ENVIRONMENT.addStandardAttribute(Type.Real,"maxreal");  
    ENVIRONMENT.addStandardAttribute(Type.Real,"minreal");  
    ENVIRONMENT.addStandardAttribute(Type.Integer,"maxrank");  
    ENVIRONMENT.addStandardAttribute(Type.Integer,"maxint");  
    ENVIRONMENT.addStandardAttribute(Type.Integer,"minint");  
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"simulaid");
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"sourceline");
    
//    Basic operations ........................................ 9.1
//    Procedures mod, rem, abs, sign, entier,
//      addepsilon, subepsilon.
    
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"mod",parameter("i",Type.Integer),parameter("j",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"rem",parameter("i",Type.Integer),parameter("j",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"abs",parameter("e",Type.LongReal));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"sign",parameter("e",Type.LongReal));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"entier",parameter("e",Type.LongReal));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,new OverLoad(Type.Real,Type.LongReal),"addepsilon",parameter("e",new OverLoad(Type.Real,Type.LongReal)));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,new OverLoad(Type.Real,Type.LongReal),"subepsilon",parameter("e",new OverLoad(Type.Real,Type.LongReal)));

//    Text utilities .......................................... 9.2
//    Procedures copy, blanks, char, isochar, rank, isorank,
//      digit, letter, lowten, decimalmark, upcase, lowcase.

    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"copy",parameter("T",Parameter.Mode.value,Type.Text));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"blanks",parameter("n",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Character,"Char",parameter("n",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Character,"char$",parameter("n",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Character,"isochar",parameter("n",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"rank",parameter("c",Type.Character));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"isorank",parameter("c",Type.Character));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Boolean,"digit",parameter("c",Type.Character));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Boolean,"letter",parameter("c",Type.Character));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Character,"lowten",parameter("c",Type.Character));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Character,"decimalmark",parameter("c",Type.Character));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"upcase",parameter("t",Type.Text));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"lowcase",parameter("t",Type.Text));
    
//    Scheduling .............................................. 9.3
//    Procedures call (7.3.2), resume (7.3.3).
    
//    Mathematical functions .................................. 9.4
//    Procedures sqrt, sin, cos, tan, cotan, arcsin, arccos,
//      arctan, arctan2, sinh, cosh, tanh, ln, log10, exp.

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

//    Extremum functions ...................................... 9.5
//    Procedures max, min.

    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,new OverLoad(Type.Real,Type.LongReal),"min",parameter("x",new OverLoad(Type.Real,Type.LongReal)),parameter("y",new OverLoad(Type.Real,Type.LongReal)));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,new OverLoad(Type.Real,Type.LongReal),"max",parameter("x",new OverLoad(Type.Real,Type.LongReal)),parameter("y",new OverLoad(Type.Real,Type.LongReal)));

//    Error control ........................................... 9.7
//    Procedure error.

    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"error",parameter("msg",Type.Text));

    // Array quantities ........................................ 9.8
//    Procedures upperbound, lowerbound.

    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"upperbound",parameter("a",null,Parameter.Kind.Array),parameter("i",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"lowerbound",parameter("a",null,Parameter.Kind.Array),parameter("i",Type.Integer));

    // Random drawing .......................................... 9.9
//    Procedures draw, randint, uniform, normal, negexp,
//      Poisson, Erlang, discrete, linear, histd.

//    ENVIRONMENT.addStandardProcedure(BlockKind.ContextFreeMethod,Type.Boolean,"draw",parameter("a",Type.LongReal),parameter("U",Parameter.Mode.name,Type.Integer));
//    ENVIRONMENT.addStandardProcedure(BlockKind.ContextFreeMethod,Type.Integer,"randint",parameter("a",Type.Integer),parameter("b",Type.Integer),parameter("U",Parameter.Mode.name,Type.Integer));
//    ENVIRONMENT.addStandardProcedure(BlockKind.ContextFreeMethod,Type.LongReal,"uniform",parameter("a",Type.LongReal),parameter("b",Type.LongReal),parameter("U",Parameter.Mode.name,Type.Integer));
//    ENVIRONMENT.addStandardProcedure(BlockKind.ContextFreeMethod,Type.LongReal,"normal",parameter("a",Type.LongReal),parameter("b",Type.LongReal),parameter("U",Parameter.Mode.name,Type.Integer));
//    ENVIRONMENT.addStandardProcedure(BlockKind.ContextFreeMethod,Type.LongReal,"negexp",parameter("a",Type.LongReal),parameter("U",Parameter.Mode.name,Type.Integer));
//    ENVIRONMENT.addStandardProcedure(BlockKind.ContextFreeMethod,Type.Integer,"Poisson",parameter("a",Type.LongReal),parameter("U",Parameter.Mode.name,Type.Integer));
//    ENVIRONMENT.addStandardProcedure(BlockKind.ContextFreeMethod,Type.LongReal,"Erlang",parameter("a",Type.LongReal),parameter("b",Type.LongReal),parameter("U",Parameter.Mode.name,Type.Integer));
//    ENVIRONMENT.addStandardProcedure(BlockKind.ContextFreeMethod,Type.Integer,"discrete",parameter("A",Type.LongReal,Parameter.Kind.Array,1),parameter("U",Parameter.Mode.name,Type.Integer));
//    ENVIRONMENT.addStandardProcedure(BlockKind.ContextFreeMethod,Type.LongReal,"linear",parameter("A",Type.LongReal,Parameter.Kind.Array,1),parameter("B",Type.LongReal,Parameter.Kind.Array,1),parameter("U",Parameter.Mode.name,Type.Integer));
//    ENVIRONMENT.addStandardProcedure(BlockKind.ContextFreeMethod,Type.Integer,"histd",parameter("A",Type.Real,Parameter.Kind.Array,1),parameter("U",Parameter.Mode.name,Type.Integer));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Boolean,"draw",parameter("a",Type.LongReal),parameter("U",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"randint",parameter("a",Type.Integer),parameter("b",Type.Integer),parameter("U",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"uniform",parameter("a",Type.LongReal),parameter("b",Type.LongReal),parameter("U",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"normal",parameter("a",Type.LongReal),parameter("b",Type.LongReal),parameter("U",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"negexp",parameter("a",Type.LongReal),parameter("U",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"Poisson",parameter("a",Type.LongReal),parameter("U",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"Erlang",parameter("a",Type.LongReal),parameter("b",Type.LongReal),parameter("U",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"discrete",parameter("A",Type.LongReal,Parameter.Kind.Array,1),parameter("U",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"linear",parameter("A",Type.LongReal,Parameter.Kind.Array,1),parameter("B",Type.LongReal,Parameter.Kind.Array,1),parameter("U",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"histd",parameter("A",Type.Real,Parameter.Kind.Array,1),parameter("U",Type.Integer));

//    Calendar and timing utilities ........................... 9.10
//    Procedures datetime, cputime, clocktime.

    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"datetime");
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"cputime");
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.LongReal,"clocktime");
    
//    Miscellaneous utilities ................................. 9.11
//    Procedure histo.

    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"histo",parameter("A",Type.Real,Parameter.Kind.Array,1),parameter("B",Type.Real,Parameter.Kind.Array,1)
    		                                     ,parameter("c",Type.Real),parameter("d",Type.Real));
//    ENVIRONMENT.addStandardProcedure(BlockKind.ContextFreeMethod,Type.Text,"objectTraceIdentifier");

    // **************************************
    // *** Additional Standard Procedures ***
    // **************************************
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Boolean,"setSeed",parameter("seed",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"waitSomeTime",parameter("millies",Type.Integer)); 
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"printThreadList",parameter("withStackTrace",Type.Boolean));

    // *****************************************
    // *** Additional S-Port'like Procedures ***
    // *****************************************
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"DEFEXCEPTION",parameter("erh",Parameter.Kind.Procedure,Parameter.Mode.value,null));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"hash",parameter("t",Type.Text));
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Character,"loadChar",parameter("t",Type.Text),parameter("i",Type.Integer)); 
    
    // storechar(EOL,line,linlen);
    //ENVIRONMENT.addStandardProcedure(BlockKind.ContextFreeMethod,null,"storeChar",parameter("t",Type.Text),parameter("i",Type.Integer),parameter("c",Type.Character)); 
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"storeChar",parameter("c",Type.Character),parameter("t",Type.Text),parameter("i",Type.Integer)); 

    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Text,"getTextInfo",parameter("i",Type.Integer)); 
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"giveTextInfo",parameter("i",Type.Integer),parameter("t",Type.Text)); 
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,Type.Integer,"getIntInfo",parameter("i",Type.Integer)); 
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"giveIntInfo",parameter("i",Type.Integer),parameter("val",Type.Integer)); 
    ENVIRONMENT.addStandardProcedure(Declaration.Kind.ContextFreeMethod,null,"rts_utility",parameter("index",Type.Integer),parameter("level",Type.Integer)); 
    
  }
  
  // ******************************************************************
  // *** The Standard Class BASICIO
  // ******************************************************************
  //  ENVIRONMENT class BASICIO (INPUT_LINELENGTH, OUTPUT_LINELENGTH);
  //  integer INPUT_LINELENGTH, OUTPUT_LINELENGTH;
  //  begin ref (infile) SYSIN; ref (printfile) SYSOUT;
  //        ref (infile)    procedure sysin;   sysin  :- SYSIN;
  //        ref (printfile) procedure sysout;  sysout :- SYSOUT;
  //
  //        procedure terminate_program;
  //        begin ... ;  goto STOP  end terminate_program;
  //
  //            class FILE 
  //       FILE class imagefile
  //       FILE class bytefile
  //  imagefile class infile
  //  imagefile class outfile
  //  imagefile class directfile
  //    outfile class printfile
  //   bytefile class inbytefile
  //   bytefile class outbytefile 
  //   bytefile class directbytefile
  //
  //        SYSIN  :- new infile("...");    ! Implementation-defined
  //        SYSOUT :- new printfile("..."); ! files names;
  //        SYSIN.open(blanks(INPUT_LINELENGTH));
  //        SYSOUT.open(blanks(OUTPUT_LINELENGTH));
  //        inner;
  //  STOP: SYSIN.close;
  //        SYSOUT.close
  //  end BASICIO;
  
  public static StandardClass BASICIO=new StandardClass("RTObject","BASICIO");
  static
  { ENVIRONMENT.addStandardClass(BASICIO); // Declared in ENVIRONMENT
    BASICIO.isContextFree=true;
    BASICIO.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("InFile"),"sysin");  
	BASICIO.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("PrintFile"),"sysout");  
	BASICIO.addStandardProcedure(Declaration.Kind.MemberMethod,null,"terminate_program");  
//	BASICIO.addStandardProcedure(BlockKind.MemberMethod,null,"detach");
	BASICIO.addStandardProcedure(Declaration.Kind.MemberMethod,null,"call",parameter("obj",Type.Ref("RTObject")));
	BASICIO.addStandardProcedure(Declaration.Kind.MemberMethod,null,"resume",parameter("obj",Type.Ref("RTObject")));
  }

  // ******************************************************************
  // *** The Standard Class CLASS
  // ******************************************************************
  /**
   * Simula Stadard States: Fictituous outermost prefix
   * Any class that has no (textually given) prefix is by definition
   * prefixed by a fictitious class whose only attribute is:
   * <pre>
   *	          procedure detach; ... ;  (see 7.3.1)
   * </pre>
   * Thus every class object or instance of a prefixed block has this attribute.
   */
  
  public static StandardClass CLASS=new StandardClass("RTObject","CLASS");
  static
  { ENVIRONMENT.addStandardClass(CLASS);  // Declared in ENVIRONMENT
	CLASS.addStandardProcedure(Declaration.Kind.MemberMethod,null,"detach");
  }
  
  // ******************************************************************
  // *** The Standard Class FILE
  // ******************************************************************
  //  class FILE_(FILENAME_); value FILENAME_; text FILENAME_;
  //  begin
  //     Boolean OPEN$;
  //     text procedure filename; filename:=copy(FILENAME_);
  //     Boolean procedure isopen; isopem:=OPEN$;
  //     Boolean procedure setaccess(mode);  text mode; ... ;
  //  
  //     if FILENAME_ = notext then error("Illegal File Name");
  //  end FILE_;      
  public static StandardClass FILE=new StandardClass("RTObject","FILE",parameter("FILENAME$",Type.Text));
  static
  { BASICIO.addStandardClass(FILE);  // Declared in BASICIO
    FILE.addStandardAttribute(Type.Boolean,"OPEN$");  
    FILE.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Text,"filename");
    FILE.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"isopen");
    FILE.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"setaccess",parameter("mode",Type.Text));  
  }  
  // ******************************************************************
  // *** The Standard FILE Class ImageFile
  // ******************************************************************
  //  FILE class imagefile;
  //  begin text image;
  //     procedure setpos(i);  integer i;  image.setpos(i);
  //     integer procedure pos;     pos    := image.pos;
  //     Boolean procedure more;    more   := image.more;
  //     integer procedure length;  length := image.length;
  //  end imagefile;
  public static StandardClass ImageFile=new StandardClass("FILE","ImageFile");
  static
  { BASICIO.addStandardClass(ImageFile);  // Declared in BASICIO
    ImageFile.addStandardAttribute(Type.Text,"image");  
    ImageFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"setpos",parameter("i",Type.Integer));  
    ImageFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"pos");  
    ImageFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"more");  
    ImageFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"length");   
  }  
  // ******************************************************************
  // *** The Standard ImageFile Class InFile
  // ******************************************************************
  //  imagefile class infile;
  //  begin Boolean ENDFILE;
  //     Boolean procedure endfile;  endfile:= ENDFILE;
  //     Boolean procedure open(fileimage); text fileimage;
  //     Boolean procedure close;
  //     procedure inimage;
  //     Boolean procedure inrecord;
  //     character procedure inchar;
  //     Boolean procedure lastitem;
  //     text procedure intext(w); integer w;
  //     integer procedure inint;
  //     long real procedure inreal;
  //     integer procedure infrac;
  //
  //     ENDFILE:= true
  //     ...
  //  end infile;
  public static StandardClass InFile=new StandardClass("ImageFile","InFile");
  static
  { BASICIO.addStandardClass(InFile);  // Declared in BASICIO
    InFile.addStandardAttribute(Type.Boolean,"ENDFILE_");  
    InFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"endfile");  
    InFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"open",parameter("fileimage",Type.Text));  
    InFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"close");  
    InFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"inimage");  
    InFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"inrecord");  
    InFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Character,"inchar");  
    InFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"lastitem");  
    InFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Text,"intext",parameter("w",Type.Integer));  
    InFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"inint");  
    InFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.LongReal,"inreal");  
    InFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"infrac");  
  }  
  // ******************************************************************
  // *** The Standard ImageFile Class OutFile
  // ******************************************************************
  //  imagefile class outfile;
  //  begin
  //     Boolean procedure open(fileimage);  text fileimage;
  //     Boolean procedure close;
  //     procedure outimage;
  //     procedure outrecord;
  //     procedure breakoutimage;
  //     Boolean procedure checkpoint;
  //     procedure outchar(c); character c;
  //     procedure outtext(t); text t;
  //     text procedure FIELD(w); integer w;
  //     procedure outint(i,w); integer i,w;
  //     procedure outfix(r,n,w); long real r; integer n,w;
  //     procedure outreal(r,n,w); long real r; integer n,w;
  //     procedure outfrac(i,n,w); integer i,n,w;
  //
  //    ... ;
  // end outfile;
  public static StandardClass OutFile=new StandardClass("ImageFile","OutFile");
  static
  { BASICIO.addStandardClass(OutFile);  // Declared in BASICIO
    OutFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"open",parameter("fileimage",Type.Text));  
    OutFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"close");  
    OutFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outimage");  
    OutFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outrecord");  
    OutFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"breakoutimage");  
    OutFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"checkpoint");  
    OutFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outchar",parameter("c",Type.Character));  
    OutFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outtext",parameter("t",Type.Text));  
    OutFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Text,"FIELD_",parameter("w",Type.Integer));  
    OutFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outint",parameter("i",Type.Integer),parameter("w",Type.Integer));  
    OutFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outfrac",parameter("i",Type.Integer),parameter("n",Type.Integer),parameter("w",Type.Integer)); 
    OutFile.addStandardProcedure(Declaration.Kind.MemberMethod,new OverLoad(Type.Real,Type.LongReal),"outfix", parameter("r",new OverLoad(Type.Real,Type.LongReal)),parameter("n",Type.Integer),parameter("w",Type.Integer)); 
    OutFile.addStandardProcedure(Declaration.Kind.MemberMethod,new OverLoad(Type.Real,Type.LongReal),"outreal",parameter("r",new OverLoad(Type.Real,Type.LongReal)),parameter("n",Type.Integer),parameter("w",Type.Integer)); 
  }  
  
  // ******************************************************************
  // *** The Standard ImageFile Class DirectFile
  // ******************************************************************
  //  imagefile class directfile;
  //  begin   integer LOC, MAXLOC;  Boolean ENDFILE, LOCKED;
  //     integer procedure location;  location:= LOC;
  //     Boolean procedure endfile;   endfile := ENDFILE;
  //     Boolean procedure locked;    locked  := LOCKED;
  //     Boolean procedure open(fileimage); text fileimage; 
  //     Boolean procedure close;
  //     integer procedure lastloc;
  //     integer procedure maxloc;
  //     procedure locate(i); integer i;
  //     procedure inimage;
  //     procedure outimage;
  //     Boolean procedure deleteimage;
  //     character procedure inchar;
  //     integer procedure lock(t,i,j); real t; integer i,j;
  //     Boolean procedure unlock; 
  //     Boolean procedure checkpoint;
  //     Boolean procedure lastitem;
  //     text procedure intext;
  //     integer procedure inint;
  //     long real procedure inreal;
  //     integer procedure infrac;
  //     procedure outchar(c); character c;
  //     procedure outtext(t); text t;
  //     text procedure FIELD(w); integer w;
  //     procedure outint(i,w); integer i,w;
  //     procedure outfix(r,n,w);  long real r; integer n,w;
  //     procedure outreal(r,n,w); long real r; integer n,w;
  //     procedure outfrac(i,n,w); integer i,n,w;
  //
  //     ENDFILE:= true
  //     ...
  //  end directfile;
  public static StandardClass DirectFile=new StandardClass("ImageFile","DirectFile");
  static
  { BASICIO.addStandardClass(DirectFile);  // Declared in BASICIO
    DirectFile.addStandardAttribute(Type.Integer,"LOC_");  
    DirectFile.addStandardAttribute(Type.Integer,"MAXLOC_");  
    DirectFile.addStandardAttribute(Type.Boolean,"ENDFILE_");  
    DirectFile.addStandardAttribute(Type.Boolean,"LOCKED_");  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"location");  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"endfile");  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"locked");  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"open",parameter("fileimage",Type.Text));  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"close");      
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"lastloc");  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"maxloc");  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"locate",parameter("i",Type.Integer));  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"inimage");  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outimage");  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"deleteimage");  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Character,"inchar");  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"lock",parameter("t",Type.Real),parameter("i",Type.Integer),parameter("j",Type.Integer));  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"unlock");  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"checkpoint");  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"lastitem");  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Text,"intext",parameter("w",Type.Integer));  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"inint");  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.LongReal,"inreal");  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"infrac");  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outchar",parameter("c",Type.Character));  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outtext",parameter("t",Type.Text));   
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Text,"FIELD_",parameter("w",Type.Integer));  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outint",parameter("i",Type.Integer),parameter("w",Type.Integer));  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outfrac",parameter("i",Type.Integer),parameter("n",Type.Integer),parameter("w",Type.Integer));  
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,new OverLoad(Type.Real,Type.LongReal),"outfix", parameter("r",new OverLoad(Type.Real,Type.LongReal)),parameter("n",Type.Integer),parameter("w",Type.Integer)); 
    DirectFile.addStandardProcedure(Declaration.Kind.MemberMethod,new OverLoad(Type.Real,Type.LongReal),"outreal",parameter("r",new OverLoad(Type.Real,Type.LongReal)),parameter("n",Type.Integer),parameter("w",Type.Integer)); 
  }  
  
  // ******************************************************************
  // *** The Standard OutFile Class PrintFile
  // ******************************************************************
  //  outfile class printfile;
  //  begin integer LINE, LINES_PER_PAGE, SPACING, PAGE;
  //    integer procedure line; line := LINE;
  //    integer procedure page; page := PAGE;
  //    Boolean procedure open(fileimage); text fileimage; 
  //    Boolean procedure close; 
  //    integer procedure linesperpage(n); integer n; 
  //    procedure spacing(n); integer n; 
  //    procedure eject(n);  integer n; 
  //    procedure outimage;
  //    procedure outrecord;
  //
  //    SPACING := 1;
  //    LINES_PER_PAGE := ... ;
  //    ...
  //  end printfile;
  public static StandardClass PrintFile=new StandardClass("OutFile","PrintFile");
  static
  { BASICIO.addStandardClass(PrintFile);  // Declared in BASICIO
    PrintFile.addStandardAttribute(Type.Integer,"LINE_");  
    PrintFile.addStandardAttribute(Type.Integer,"LINES_PER_PAGE_");  
    PrintFile.addStandardAttribute(Type.Integer,"SPACING_");  
    PrintFile.addStandardAttribute(Type.Integer,"PAGE_");  
    PrintFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"line"); 
    PrintFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"page");  
    PrintFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"open",parameter("fileimage",Type.Text));  
    PrintFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"close");  
    PrintFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"linesperpage",parameter("n",Type.Integer));  
    PrintFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"spacing",parameter("n",Type.Integer));  
    PrintFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"eject",parameter("n",Type.Integer));  
    PrintFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outimage");  
    PrintFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outrecord");  
  }  
  // ******************************************************************
  // *** The Standard FILE Class ByteFile
  // ******************************************************************
  //  FILE class bytefile;
  //  begin short integer BYTESIZE;
  //     short integer procedure bytesize; bytesize := BYTESIZE;
  //
  //  end bytefile;
  public static StandardClass ByteFile=new StandardClass("FILE","ByteFile");
  static
  { BASICIO.addStandardClass(ByteFile);  // Declared in BASICIO
    ByteFile.addStandardAttribute(Type.Integer,"BYTESIZE_");  
    ByteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"bytesize");  
  }  
  // ******************************************************************
  // *** The Standard ByteFile Class InbyteFile
  // ******************************************************************
  //  bytefile class inbytefile;
  //  begin Boolean ENDFILE;
  //    Boolean procedure endfile; endfile:= ENDFILE;
  //    Boolean procedure open; 
  //    Boolean procedure close;
  //    short integer procedure inbyte;
  //    text procedure intext(t); text t; 
  //
  //    ENDFILE:= true;
  //    ...
  //  end inbytefile;
  public static StandardClass InbyteFile=new StandardClass("ByteFile","InbyteFile");
  static
  { BASICIO.addStandardClass(InbyteFile);  // Declared in BASICIO
    InbyteFile.addStandardAttribute(Type.Boolean,"ENDFILE_");  
    InbyteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"endfile");  
    InbyteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"open",parameter("fileimage",Type.Text));  
    InbyteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"close");  
    InbyteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"inbyte");  
    InbyteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"in2byte");  // TODO: Extension to Simula Standard
    InbyteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Text,"intext",parameter("t",Type.Text));  
  }  
  // ******************************************************************
  // *** The Standard ByteFile Class OutbyteFile
  // ******************************************************************
  //  bytefile class outbytefile;
  //  begin
  //    Boolean procedure open; 
  //    Boolean procedure close; 
  //    procedure outbyte(x); short integer x; 
  //    procedure outtext(t); text t; 
  //    Boolean procedure checkpoint; 
  //
  //  end outbytefile;
  public static StandardClass OutbyteFile=new StandardClass("ByteFile","OutbyteFile");
  static
  { BASICIO.addStandardClass(OutbyteFile);
    OutbyteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"open",parameter("fileimage",Type.Text));  
    OutbyteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"close");  
    OutbyteFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outbyte",parameter("x",Type.Integer));   
    OutbyteFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outtext",parameter("t",Type.Text));  
    OutbyteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"checkpoint");  
  }  
  // ******************************************************************
  // *** The Standard ByteFile Class DirectByteFile
  // ******************************************************************
  //  bytefile class directbytefile;
  //  begin integer LOC, MAXLOC;  Boolean LOCKED;
  //    Boolean procedure endfile; endfile:=OPEN and then LOC>lastloc;
  //    integer procedure location; location := LOC;
  //    integer procedure maxloc; maxloc := MAXLOC;
  //    Boolean procedure locked; locked := LOCKED;
  //    Boolean procedure open; 
  //    Boolean procedure close; 
  //    integer procedure lastloc; 
  //    procedure locate(i); integer i; 
  //    short integer procedure inbyte; 
  //    procedure outbyte(x); short integer x; 
  //    Boolean procedure checkpoint; 
  //    integer procedure lock(t,i,j); real t; integer i,j; 
  //    Boolean procedure unlock; 
  //    procedure intext(t); text t; 
  //    procedure outtext(t); text t;
  //     ...
  //  end directbytefile;
  public static StandardClass DirectByteFile=new StandardClass("ByteFile","DirectByteFile");
  static
  { BASICIO.addStandardClass(DirectByteFile);  // Declared in BASICIO
    DirectByteFile.addStandardAttribute(Type.Integer,"LOC_");  
    DirectByteFile.addStandardAttribute(Type.Integer,"MAXLOC_");  
    DirectByteFile.addStandardAttribute(Type.Boolean,"LOCKED_");  
    DirectByteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"endfile");  
    DirectByteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"location");  
    DirectByteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"maxloc");  
    DirectByteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"locked");  
    DirectByteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"open",parameter("fileimage",Type.Text));  
    DirectByteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"close");      
    DirectByteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"lastloc");  
    DirectByteFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"locate",parameter("i",Type.Integer));  
    DirectByteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"inbyte");  
    DirectByteFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outbyte",parameter("x",Type.Integer));   
    DirectByteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"checkpoint");  
    DirectByteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"lock",parameter("t",Type.Real),parameter("i",Type.Integer),parameter("j",Type.Integer));  
    DirectByteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"unlock");  
    DirectByteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Text,"intext",parameter("t",Type.Text));  
    DirectByteFile.addStandardProcedure(Declaration.Kind.MemberMethod,null,"outtext",parameter("t",Type.Text));  
    DirectByteFile.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"checkpoint");  
  }  
  
  // ******************************************************************
  // *** The Standard Class Simset
  // ******************************************************************
  public static StandardClass Simset=new StandardClass("CLASS","Simset");
  static
  { ENVIRONMENT.addStandardClass(Simset);  // Declared in ENVIRONMENT
  }  
  
  // ******************************************************************
  // *** The Standard Class Linkage
  // ******************************************************************
  public static StandardClass Linkage=new StandardClass("CLASS","Linkage");
  static
  { Simset.addStandardClass(Linkage);  // Declared in Simset
    Linkage.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("Link"),"suc");  
    Linkage.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("Link"),"pred");  
    Linkage.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("Linkage"),"prev");  
  }  
  
  // ******************************************************************
  // *** The Standard Linkage Class Head
  // ******************************************************************
  public static StandardClass Head=new StandardClass("Linkage","Head");
  static
  { Simset.addStandardClass(Head);  // Declared in Simset
    Head.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("Link"),"first");  
    Head.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("Link"),"last");  
    Head.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Boolean,"empty");  
    Head.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Integer,"cardinal");  
    Head.addStandardProcedure(Declaration.Kind.MemberMethod,null,"clear");  
  }  
  
  // ******************************************************************
  // *** The Standard Linkage Class Link
  // ******************************************************************
  public static StandardClass Link=new StandardClass("Linkage","Link");
  static
  { Simset.addStandardClass(Link);  // Declared in Simset
    Link.addStandardProcedure(Declaration.Kind.MemberMethod,null,"out");  
    Link.addStandardProcedure(Declaration.Kind.MemberMethod,null,"follow",parameter("X",Type.Ref("Linkage")));  
    Link.addStandardProcedure(Declaration.Kind.MemberMethod,null,"precede",parameter("X",Type.Ref("Linkage")));  
    Link.addStandardProcedure(Declaration.Kind.MemberMethod,null,"into",parameter("S",Type.Ref("Head")));  
  }  
  
  // ******************************************************************
  // *** The Standard Class Simulation
  // ******************************************************************
  public static StandardClass Simulation=new StandardClass("Simset","Simulation");
  static
  { ENVIRONMENT.addStandardClass(Simulation);  // Declared in ENVIRONMENT
    Simulation.detachUsed=true;
//    Simulation.code1=codeSet( // Statements before inner 
//    		new CodeLine(1,"SQS = (Head$) new Head$(this).STM$();"),
//    		new CodeLine(1,"main = (MAIN_PROGRAM$) new MAIN_PROGRAM$((Simulation$) CUR$).START$();"),
//    		new CodeLine(1,"main.EVENT = (EVENT_NOTICE$) new EVENT_NOTICE$((Simulation$) CUR$, 0, main).STM$();"),
//    		new CodeLine(1,"main.EVENT.into(SQS);"));
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
  public static StandardClass EVENT_NOTICE=new StandardClass("Link","EVENT_NOTICE");
  static
  { Simulation.addStandardClass(EVENT_NOTICE);  // Declared in Simulation
//  ref(EVENT_NOTICE) procedure suc;
//  ref(EVENT_NOTICE) procedure pred;
//  procedure RANK(BEFORE_); Boolean BEFORE_;
    EVENT_NOTICE.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("EVENT_NOTICE"),"suc");  
    EVENT_NOTICE.addStandardProcedure(Declaration.Kind.MemberMethod,Type.Ref("EVENT_NOTICE"),"pred");  
    EVENT_NOTICE.addStandardProcedure(Declaration.Kind.MemberMethod,null,"RANK",parameter("BEFORET",Type.Boolean));  
  }  
  
  // ******************************************************************
  // *** The Standard Link Class Process
  // ******************************************************************
  public static StandardClass Process=new StandardClass("Link","Process");
  static
  { Simulation.addStandardClass(Process);  // Declared in Simulation
    Process.detachUsed=true;
    Process.code1=codeSet(new CodeLine(1,"detach();"));    // Statements before inner 
    Process.code2=codeSet(new CodeLine(1,"terminate();")); // Statements after inner 
//  ref(EVENT_NOTICE) EVENT;
//  Boolean TERMINATED_;
//  Boolean procedure idle;
//  Boolean procedure terminated;
//  real procedure evtime;
//  ref(Process) procedure nextev;
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
  public static final StandardClass MAIN_PROGRAM=new StandardClass("Process","MAIN_PROGRAM");
  static
  { Simulation.addStandardClass(MAIN_PROGRAM);   // Declared in Simulation
//  Process class MAIN_PROGRAM;
//  begin
//     L: detach; goto L
//  end MAIN_PROGRAM;
  }  
  
  // ******************************************************************
  // *** The Standard Class Drawing
  // ******************************************************************
  public static StandardClass Drawing=new StandardClass("Simset","Drawing",parameter("Title",Type.Text),parameter("width",Type.Integer),parameter("height",Type.Integer)); 
  static
  { ENVIRONMENT.addStandardClass(Drawing);  // Declared in ENVIRONMENT
//    Drawing.code1=codeSet( // Statements before inner 
//  		new CodeLine(1,"// RENDERING_SET = (Head$) new Head$(Drawing$.this).STM$();"),
//  		new CodeLine(1,"// init(title.edText(),width,height);")
//  		);
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
    
    Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,null,"drawText",parameter("t",Type.Text),parameter("x",Type.LongReal),parameter("y",Type.LongReal));  
    Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,null,"drawLine",parameter("x1",Type.LongReal),parameter("y1",Type.LongReal),parameter("x2",Type.LongReal),parameter("y2",Type.LongReal));  
    Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,null,"drawEllipse",parameter("x",Type.LongReal),parameter("y",Type.LongReal),parameter("width",Type.LongReal),parameter("height",Type.LongReal));  
    Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,null,"drawRectangle",parameter("x",Type.LongReal),parameter("y",Type.LongReal),parameter("width",Type.LongReal),parameter("height",Type.LongReal));  
    Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,null,"drawRoundRectangle",parameter("x",Type.LongReal),parameter("y",Type.LongReal),parameter("width",Type.LongReal)
    														   ,parameter("height",Type.LongReal),parameter("arcw",Type.LongReal),parameter("arch",Type.LongReal));  
    Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,null,"fillEllipse",parameter("x",Type.LongReal),parameter("y",Type.LongReal),parameter("width",Type.LongReal),parameter("height",Type.LongReal));  
    Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,null,"fillRectangle",parameter("x",Type.LongReal),parameter("y",Type.LongReal),parameter("width",Type.LongReal),parameter("height",Type.LongReal));  
    Drawing.addStandardProcedure(Declaration.Kind.MemberMethod,null,"fillRoundRectangle",parameter("x",Type.LongReal),parameter("y",Type.LongReal),parameter("width",Type.LongReal)
    														   ,parameter("height",Type.LongReal),parameter("arcw",Type.LongReal),parameter("arch",Type.LongReal));  
  }
  
  // ******************************************************************
  // *** The Standard Link Class ShapeElement
  // ******************************************************************
  public static StandardClass ShapeElement=new StandardClass("Link","ShapeElement");
  static
  { Drawing.addStandardClass(ShapeElement);  // Declared in Drawing
//    ShapeElement.code1=codeSet( // Statements before inner 
//		new CodeLine(1,"this.stroke=drawing.currentStroke;"),
//		new CodeLine(1,"this.into(drawing.RENDERING_SET);")
//		);
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
  // *** The Standard Link Class TextElement
  // ******************************************************************
  public static StandardClass TextElement=new StandardClass("Link","TextElement",parameter("txt",Type.Text),parameter("x",Type.LongReal),parameter("y",Type.LongReal));  
  static
  { Drawing.addStandardClass(TextElement);  // Declared in Drawing
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
	
  public StandardClass(String className)
  { super(className);
    this.externalIdent=className+"$";
	this.declarationKind=Declaration.Kind.StandardClass;
	this.type=Type.Ref(className);
  }
  
  public StandardClass(String prefix,String className)
  { this(className);
	this.prefix=prefix;
  }
	
  public StandardClass(String prefix,String className,Parameter p1,Parameter p2,Parameter p3)
  { this(prefix,className);
	p1.into(parameterList);
	p2.into(parameterList);
	p3.into(parameterList);
  }
	
  public StandardClass(String prefix,String className,Parameter p1)
  { this(prefix,className);
	p1.into(parameterList);
  }
	
  public StandardClass(String className,Parameter p1)
  { this(className);
	p1.into(parameterList);
  }
  
  private static Vector<CodeLine> codeSet(CodeLine... codeLine) {
	  Vector<CodeLine> set=new Vector<CodeLine>();
	  for(CodeLine c:codeLine) set.add(c);
	  return(set);
  }

  private static Parameter parameter(String ident,Type type)
  { return(new Parameter(ident,type,Parameter.Kind.Simple)); }
  
  private static Parameter parameter(String ident,Type type,Parameter.Kind kind)
  { return(new Parameter(ident,type,kind)); }
  
  private static Parameter parameter(String ident,Type type,Parameter.Kind kind,int nDim)
  { return(new Parameter(ident,type,kind,nDim)); }
  
  private static Parameter parameter(String ident,Parameter.Mode mode,Type type)
  { Parameter spec=new Parameter(ident,type,Parameter.Kind.Simple);
    spec.setMode(mode); return(spec);
  }
  
  private static Parameter parameter(String ident,Parameter.Kind kind,Parameter.Mode mode,Type type)
  { Parameter spec=new Parameter(ident,type,kind);
    spec.setMode(mode); return(spec);
  }
  
  public Meaning findVisibleAttributeMeaning(String ident)
  { for(Declaration declaration:declarationList)
    	if(ident.equalsIgnoreCase(declaration.identifier))
    	   	  return(new Meaning(declaration,this));
    ClassDeclaration prfx=getPrefixClass();
    if(prfx!=null) return(prfx.findVisibleAttributeMeaning(ident));
    return(null);
  }
  
  public Meaning findRemoteAttributeMeaning(String ident)
  { for(Declaration declaration:declarationList)
    	if(ident.equalsIgnoreCase(declaration.identifier))
    	   	  return(new Meaning(declaration,this));
    ClassDeclaration prfx=getPrefixClass();
    if(prfx!=null) return(prfx.findRemoteAttributeMeaning(ident));
    return(null);
  }

  private void addStandardClass(StandardClass standardClass)
  {	standardClass.declaredIn=this;
    ((ClassDeclaration)standardClass.declaredIn).hasLocalClasses=true;
    declarationList.add(standardClass);
  }

  private void addStandardAttribute(Type type,String ident)
  { declarationList.add(new SimpleVariableDeclaration(type,ident)); }

  private void addStandardAttribute(Type type,String ident,int iValue)
  { declarationList.add(new SimpleVariableDeclaration(type,ident,true,new Constant(Type.Integer,(Integer)iValue))); }

  private void addStandardProcedure(Declaration.Kind kind,Type type,String ident,Parameter p1,Parameter p2,Parameter p3,Parameter p4,Parameter p5,Parameter p6)
  {	declarationList.add(new StandardProcedure(this,kind,type,ident,p1,p2,p3,p4,p5,p6)); }

//  private void addStandardProcedure(BlockKind kind,Type type,String ident,Parameter p1,Parameter p2,Parameter p3,Parameter p4,Parameter p5)
//  {	declarationList.add(new StandardProcedure(this,kind,type,ident,p1,p2,p3,p4,p5)); }

  private void addStandardProcedure(Declaration.Kind kind,Type type,String ident,Parameter p1,Parameter p2,Parameter p3,Parameter p4)
  {	declarationList.add(new StandardProcedure(this,kind,type,ident,p1,p2,p3,p4)); }

  private void addStandardProcedure(Declaration.Kind kind,Type type,String ident,Parameter p1,Parameter p2,Parameter p3)
  {	declarationList.add(new StandardProcedure(this,kind,type,ident,p1,p2,p3)); }

  private void addStandardProcedure(Declaration.Kind kind,Type type,String ident,Parameter p1,Parameter p2)
  {	declarationList.add(new StandardProcedure(this,kind,type,ident,p1,p2)); }

  private void addStandardProcedure(Declaration.Kind kind,Type type,String ident,Parameter param)
  {	declarationList.add(new StandardProcedure(this,kind,type,ident,param)); }

  private void addStandardProcedure(Declaration.Kind kind,Type type,String ident)
  {	declarationList.add(new StandardProcedure(this,kind,type,ident)); }

}


