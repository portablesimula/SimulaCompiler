/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.OverLoad;
import simula.compiler.utilities.Type;
import simula.compiler.expression.Variable;

public class StandardClass extends BlockDeclaration //ClassDeclaration
{
  public BlockDeclaration.Kind getBlockKind() { return(BlockDeclaration.Kind.StandardClass); }
  public String edJavaClassName() { return(identifier); }
//  public String getJavaIdentifier() { return(identifier+"$"); }
  
  // ******************************************************************
  // *** The Type TXT
  // ******************************************************************
  public static StandardClass typeText=new StandardClass("TXT");
  static // Define attribute procedures to Type TXT
  {	typeText.isContextFree=true;
	typeText.addStandardProcedure(Type.Boolean,"constant");  
  	typeText.addStandardProcedure(Type.Integer,"start");  
  	typeText.addStandardProcedure(Type.Integer,"length");  
  	typeText.addStandardProcedure(Type.Text,"main");  
  	typeText.addStandardProcedure(Type.Integer,"pos");  
  	typeText.addStandardProcedure(null,"setpos",parameter("i",Type.Integer));  
  	typeText.addStandardProcedure(Type.Boolean,"more");  
  	typeText.addStandardProcedure(Type.Character,"getchar");  
  	typeText.addStandardProcedure(null,"putchar",parameter("c",Type.Character));  
  	typeText.addStandardProcedure(Type.Text,"sub",parameter("i",Type.Integer),parameter("n",Type.Integer));  
  	typeText.addStandardProcedure(Type.Text,"strip");  
  	typeText.addStandardProcedure(Type.Integer,"getint");  
  	typeText.addStandardProcedure(Type.LongReal,"getreal");  
  	typeText.addStandardProcedure(Type.Integer,"getfrac");  
  	typeText.addStandardProcedure(null,"putint",parameter("i",Type.Integer));  
//  	typeText.addStandardProcedure(null,"putfix",parameter("r",Type.LongReal),parameter("n",Type.Integer));
//  	typeText.addStandardProcedure(null,"putreal",parameter("r",Type.LongReal),parameter("n",Type.Integer));  
  	typeText.addStandardProcedure(null,"putfrac",parameter("i",Type.Integer),parameter("n",Type.Integer));  
  	
    if(Global.OVERLOADING)
    { typeText.addStandardProcedure(new OverLoad(Type.Real,Type.LongReal),"putfix", parameter("r",new OverLoad(Type.Real,Type.LongReal)),parameter("n",Type.Integer)); 
      typeText.addStandardProcedure(new OverLoad(Type.Real,Type.LongReal),"putreal",parameter("r",new OverLoad(Type.Real,Type.LongReal)),parameter("n",Type.Integer)); 
    } else {
      typeText.addStandardProcedure(null,"putfix",parameter("r",Type.LongReal),parameter("n",Type.Integer));  
      typeText.addStandardProcedure(null,"putreal",parameter("r",Type.LongReal),parameter("n",Type.Integer));  
    }

  }
  
  // ******************************************************************
  // *** The Standard Class UNIVERSE
  // ******************************************************************
  public static StandardClass UNIVERSE=new StandardClass("UNIVERSE");
  static
  {	UNIVERSE.isContextFree=true;
    //UNIVERSE.blockLevel=2;
    UNIVERSE.declaredIn=null;
  }
  
  // ******************************************************************
  // *** The Standard Class RTObject - Prefix to all classes
  // ******************************************************************
  public static StandardClass RTObject=new StandardClass("RTObject");
  static
  { UNIVERSE.addStandardClass(RTObject);
    RTObject.isContextFree=true;
//    RTObject.addStandardProcedure(null,"detach");
//    RTObject.addStandardProcedure(null,"call",parameter("obj",Type.Ref("RTObject")));
//    RTObject.addStandardProcedure(null,"resume",parameter("obj",Type.Ref("RTObject")));
  }
  
  // ******************************************************************
  // *** The Standard Class ENVIRONMENT
  // ******************************************************************
  // TODO: Rettes slik at alle genererte metoder blir static.
  //       Ta med et flag (enten i klassen eller i alle procedurene
  //       Dettte svarer til diskusjonen om innf�ring av 'context class'
  //  
  public static StandardClass ENVIRONMENT=new StandardClass("RTObject","ENVIRONMENT");
  static
  { UNIVERSE.addStandardClass(ENVIRONMENT);
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
//    ENVIRONMENT.addStandardAttribute(Type.Text,"simulaid");
    ENVIRONMENT.addStandardProcedure(Type.Text,"simulaid");
    ENVIRONMENT.addStandardProcedure(Type.Integer,"sourceline");
    
//    Basic operations ........................................ 9.1
//    Procedures mod, rem, abs, sign, entier,
//      addepsilon, subepsilon.
    
    ENVIRONMENT.addStandardProcedure(Type.Integer,"mod",parameter("i",Type.Integer),parameter("j",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Type.Integer,"rem",parameter("i",Type.Integer),parameter("j",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"abs",parameter("e",Type.LongReal));
    ENVIRONMENT.addStandardProcedure(Type.Integer,"sign",parameter("e",Type.LongReal));
    ENVIRONMENT.addStandardProcedure(Type.Integer,"entier",parameter("e",Type.LongReal));
    
    if(Global.OVERLOADING)
    { ENVIRONMENT.addStandardProcedure(new OverLoad(Type.Real,Type.LongReal),"addepsilon",parameter("e",new OverLoad(Type.Real,Type.LongReal)));
      ENVIRONMENT.addStandardProcedure(new OverLoad(Type.Real,Type.LongReal),"subepsilon",parameter("e",new OverLoad(Type.Real,Type.LongReal)));
    } else {
      ENVIRONMENT.addStandardProcedure(Type.LongReal,"addepsilon",parameter("e",Type.LongReal));
      ENVIRONMENT.addStandardProcedure(Type.LongReal,"subepsilon",parameter("e",Type.LongReal));
    }

//    Text utilities .......................................... 9.2
//    Procedures copy, blanks, char, isochar, rank, isorank,
//      digit, letter, lowten, decimalmark, upcase, lowcase.

    ENVIRONMENT.addStandardProcedure(Type.Text,"copy",parameter("T",Parameter.Mode.value,Type.Text));
    ENVIRONMENT.addStandardProcedure(Type.Text,"blanks",parameter("n",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Type.Character,"Char",parameter("n",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Type.Character,"isochar",parameter("n",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Type.Integer,"rank",parameter("c",Type.Character));
    ENVIRONMENT.addStandardProcedure(Type.Integer,"isorank",parameter("c",Type.Character));
    ENVIRONMENT.addStandardProcedure(Type.Boolean,"digit",parameter("c",Type.Character));
    ENVIRONMENT.addStandardProcedure(Type.Boolean,"letter",parameter("c",Type.Character));
    ENVIRONMENT.addStandardProcedure(Type.Character,"lowten",parameter("c",Type.Character));
    ENVIRONMENT.addStandardProcedure(Type.Character,"decimalmark",parameter("c",Type.Character));
    ENVIRONMENT.addStandardProcedure(Type.Text,"upcase",parameter("t",Type.Text));
    ENVIRONMENT.addStandardProcedure(Type.Text,"lowcase",parameter("t",Type.Text));
    
//    Scheduling .............................................. 9.3
//    Procedures call (7.3.2), resume (7.3.3).
    
//    Mathematical functions .................................. 9.4
//    Procedures sqrt, sin, cos, tan, cotan, arcsin, arccos,
//      arctan, arctan2, sinh, cosh, tanh, ln, log10, exp.

    ENVIRONMENT.addStandardProcedure(Type.LongReal,"sqrt",parameter("x",Type.LongReal));
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"sin",parameter("x",Type.LongReal));
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"cos",parameter("x",Type.LongReal));
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"tan",parameter("x",Type.LongReal));
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"cotan",parameter("x",Type.LongReal));
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"arcsin",parameter("x",Type.LongReal));
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"arccos",parameter("x",Type.LongReal));
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"arctan",parameter("x",Type.LongReal));
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"arctan2",parameter("x",Type.LongReal),parameter("y",Type.LongReal));
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"sinh",parameter("x",Type.LongReal));
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"cosh",parameter("x",Type.LongReal));
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"tanh",parameter("x",Type.LongReal));
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"ln",parameter("x",Type.LongReal));
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"log10",parameter("x",Type.LongReal));
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"exp",parameter("x",Type.LongReal));

//    Extremum functions ...................................... 9.5
//    Procedures max, min.

    ENVIRONMENT.addStandardProcedure(Type.LongReal,"min",parameter("x",Type.LongReal),parameter("y",Type.LongReal));
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"max",parameter("x",Type.LongReal),parameter("y",Type.LongReal));

//    Error control ........................................... 9.7
//    Procedure error.

    ENVIRONMENT.addStandardProcedure(null,"error",parameter("msg",Type.Text));

    // Array quantities ........................................ 9.8
//    Procedures upperbound, lowerbound.

    ENVIRONMENT.addStandardProcedure(Type.Integer,"upperbound",parameter("a",null,Parameter.Kind.Array),parameter("i",Type.Integer));
    ENVIRONMENT.addStandardProcedure(Type.Integer,"lowerbound",parameter("a",null,Parameter.Kind.Array),parameter("i",Type.Integer));

    // Random drawing .......................................... 9.9
//    Procedures draw, randint, uniform, normal, negexp,
//      Poisson, Erlang, discrete, linear, histd.

    ENVIRONMENT.addStandardProcedure(Type.Boolean,"draw",parameter("a",Type.LongReal),parameter("U",Parameter.Mode.name,Type.Integer));
    ENVIRONMENT.addStandardProcedure(Type.Integer,"randint",parameter("a",Type.Integer),parameter("b",Type.Integer),parameter("U",Parameter.Mode.name,Type.Integer));
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"uniform",parameter("a",Type.LongReal),parameter("b",Type.LongReal),parameter("U",Parameter.Mode.name,Type.Integer));
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"normal",parameter("a",Type.LongReal),parameter("b",Type.LongReal),parameter("U",Parameter.Mode.name,Type.Integer));
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"negexp",parameter("a",Type.LongReal),parameter("U",Parameter.Mode.name,Type.Integer));
    ENVIRONMENT.addStandardProcedure(Type.Integer,"Poisson",parameter("a",Type.LongReal),parameter("U",Parameter.Mode.name,Type.Integer));
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"Erlang",parameter("a",Type.LongReal),parameter("b",Type.LongReal),parameter("U",Parameter.Mode.name,Type.Integer));
    ENVIRONMENT.addStandardProcedure(Type.Integer,"discrete",parameter("A",Type.LongReal,Parameter.Kind.Array),parameter("U",Parameter.Mode.name,Type.Integer));
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"linear",parameter("A",Type.LongReal,Parameter.Kind.Array),parameter("B",Type.LongReal,Parameter.Kind.Array),parameter("U",Parameter.Mode.name,Type.Integer));
    ENVIRONMENT.addStandardProcedure(Type.Integer,"histd",parameter("A",Type.Real,Parameter.Kind.Array),parameter("U",Parameter.Mode.name,Type.Integer));

//    Calendar and timing utilities ........................... 9.10
//    Procedures datetime, cputime, clocktime.

    ENVIRONMENT.addStandardProcedure(Type.Text,"datetime");
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"cputime");
    ENVIRONMENT.addStandardProcedure(Type.LongReal,"clocktime");
    
//    Miscellaneous utilities ................................. 9.11
//    Procedure histo.

    ENVIRONMENT.addStandardProcedure(null,"histo",parameter("A",Type.Real,Parameter.Kind.Array),parameter("B",Type.Real,Parameter.Kind.Array)
    		                                     ,parameter("c",Type.Real),parameter("d",Type.Real));
    ENVIRONMENT.addStandardProcedure(null,"accum",parameter("a",Parameter.Mode.name,Type.Real),parameter("b",Parameter.Mode.name,Type.Real)
                                                 ,parameter("c",Parameter.Mode.name,Type.Real),parameter("d",Type.Real));
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
  public static StandardClass BASICIO=new StandardClass("ENVIRONMENT","BASICIO");
  static
  { UNIVERSE.addStandardClass(BASICIO);
    BASICIO.isContextFree=true;
    BASICIO.addStandardProcedure(Type.Ref("InFile"),"sysin");  
	BASICIO.addStandardProcedure(Type.Ref("PrintFile"),"sysout");  
	BASICIO.addStandardProcedure(null,"terminate_program");  
//	BASICIO.addStandardProcedure(null,"detach");
	BASICIO.addStandardProcedure(null,"call",parameter("obj",Type.Ref("RTObject")));
	BASICIO.addStandardProcedure(null,"resume",parameter("obj",Type.Ref("RTObject")));
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
  public static StandardClass CLASS=new StandardClass("BASICIO","CLASS");
  static
  { UNIVERSE.addStandardClass(CLASS);
	CLASS.addStandardProcedure(null,"detach");
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
  public static StandardClass FILE=new StandardClass("RTObject","FILE",parameter("FILENAME",Type.Text));
  static
  { BASICIO.addStandardClass(FILE);
    //FILE.isContextFree=true;
    FILE.addStandardAttribute(Type.Boolean,"OPEN$");  
    FILE.addStandardProcedure(Type.Text,"filename");
    FILE.addStandardProcedure(Type.Boolean,"isopen");
    FILE.addStandardProcedure(Type.Boolean,"setaccess",parameter("mode",Type.Text));  
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
  { BASICIO.addStandardClass(ImageFile);
    //ImageFile.isContextFree=true;
    ImageFile.addStandardAttribute(Type.Text,"image");  
    ImageFile.addStandardProcedure(null,"setpos",parameter("i",Type.Integer));  
    ImageFile.addStandardProcedure(Type.Integer,"pos");  
    ImageFile.addStandardProcedure(Type.Boolean,"more");  
    ImageFile.addStandardProcedure(Type.Integer,"length");   
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
  { BASICIO.addStandardClass(InFile);
    //InFile.isContextFree=true;
    InFile.addStandardAttribute(Type.Boolean,"ENDFILE_");  
    InFile.addStandardProcedure(Type.Boolean,"endfile");  
    InFile.addStandardProcedure(Type.Boolean,"open",parameter("fileimage",Type.Text));  
    InFile.addStandardProcedure(Type.Boolean,"close");  
    InFile.addStandardProcedure(null,"inimage");  
    InFile.addStandardProcedure(Type.Boolean,"inrecord");  
    InFile.addStandardProcedure(Type.Character,"inchar");  
    InFile.addStandardProcedure(Type.Boolean,"lastitem");  
    InFile.addStandardProcedure(Type.Text,"intext",parameter("w",Type.Integer));  
    InFile.addStandardProcedure(Type.Integer,"inint");  
    InFile.addStandardProcedure(Type.LongReal,"inreal");  
    InFile.addStandardProcedure(Type.Integer,"infrac");  
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
  { BASICIO.addStandardClass(OutFile);
    //OutFile.isContextFree=true;
    OutFile.addStandardProcedure(Type.Boolean,"open",parameter("fileimage",Type.Text));  
    OutFile.addStandardProcedure(Type.Boolean,"close");  
    OutFile.addStandardProcedure(null,"outimage");  
    OutFile.addStandardProcedure(null,"outrecord");  
    OutFile.addStandardProcedure(null,"breakoutimage");  
    OutFile.addStandardProcedure(Type.Boolean,"checkpoint");  
    OutFile.addStandardProcedure(null,"outchar",parameter("c",Type.Character));  
    OutFile.addStandardProcedure(null,"outtext",parameter("t",Type.Text));  
    OutFile.addStandardProcedure(Type.Text,"FIELD_",parameter("w",Type.Integer));  
    OutFile.addStandardProcedure(null,"outint",parameter("i",Type.Integer),parameter("w",Type.Integer));  
    OutFile.addStandardProcedure(null,"outfrac",parameter("i",Type.Integer),parameter("n",Type.Integer),parameter("w",Type.Integer)); 
    if(Global.OVERLOADING)
    { OutFile.addStandardProcedure(new OverLoad(Type.Real,Type.LongReal),"outfix", parameter("r",new OverLoad(Type.Real,Type.LongReal)),parameter("n",Type.Integer),parameter("w",Type.Integer)); 
      OutFile.addStandardProcedure(new OverLoad(Type.Real,Type.LongReal),"outreal",parameter("r",new OverLoad(Type.Real,Type.LongReal)),parameter("n",Type.Integer),parameter("w",Type.Integer)); 
    } else {
      OutFile.addStandardProcedure(null,"outfix",parameter("r",Type.LongReal),parameter("n",Type.Integer),parameter("w",Type.Integer));  
      OutFile.addStandardProcedure(null,"outreal",parameter("r",Type.LongReal),parameter("n",Type.Integer),parameter("w",Type.Integer));  
    }
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
  { BASICIO.addStandardClass(DirectFile);
    //DirectFile.isContextFree=true;
    DirectFile.addStandardAttribute(Type.Integer,"LOC_");  
    DirectFile.addStandardAttribute(Type.Integer,"MAXLOC_");  
    DirectFile.addStandardAttribute(Type.Boolean,"ENDFILE_");  
    DirectFile.addStandardAttribute(Type.Boolean,"LOCKED_");  
    DirectFile.addStandardProcedure(Type.Integer,"location");  
    DirectFile.addStandardProcedure(Type.Boolean,"endfile");  
    DirectFile.addStandardProcedure(Type.Boolean,"locked");  
    DirectFile.addStandardProcedure(Type.Boolean,"open",parameter("fileimage",Type.Text));  
    DirectFile.addStandardProcedure(Type.Boolean,"close");      
    DirectFile.addStandardProcedure(Type.Integer,"lastloc");  
    DirectFile.addStandardProcedure(Type.Integer,"maxloc");  
    DirectFile.addStandardProcedure(null,"locate",parameter("i",Type.Integer));  
    DirectFile.addStandardProcedure(null,"inimage");  
    DirectFile.addStandardProcedure(null,"outimage");  
    DirectFile.addStandardProcedure(Type.Boolean,"deleteimage");  
    DirectFile.addStandardProcedure(Type.Character,"inchar");  
    DirectFile.addStandardProcedure(Type.Integer,"lock",parameter("t",Type.Real),parameter("i",Type.Integer),parameter("j",Type.Integer));  
    DirectFile.addStandardProcedure(Type.Boolean,"unlock");  
    DirectFile.addStandardProcedure(Type.Boolean,"checkpoint");  
    DirectFile.addStandardProcedure(Type.Boolean,"lastitem");  
    DirectFile.addStandardProcedure(Type.Text,"intext",parameter("w",Type.Integer));  
    DirectFile.addStandardProcedure(Type.Integer,"inint");  
    DirectFile.addStandardProcedure(Type.LongReal,"inreal");  
    DirectFile.addStandardProcedure(Type.Integer,"infrac");  
    DirectFile.addStandardProcedure(null,"outchar",parameter("c",Type.Character));  
    DirectFile.addStandardProcedure(null,"outtext",parameter("t",Type.Text));   
    DirectFile.addStandardProcedure(Type.Text,"FIELD_",parameter("w",Type.Integer));  
    DirectFile.addStandardProcedure(null,"outint",parameter("i",Type.Integer),parameter("w",Type.Integer));  
//    DirectFile.addStandardProcedure(null,"outfix",parameter("r",Type.LongReal),parameter("n",Type.Integer),parameter("w",Type.Integer));  
//    DirectFile.addStandardProcedure(null,"outreal",parameter("r",Type.LongReal),parameter("n",Type.Integer),parameter("w",Type.Integer));  
    DirectFile.addStandardProcedure(null,"outfrac",parameter("i",Type.Integer),parameter("n",Type.Integer),parameter("w",Type.Integer));  
    if(Global.OVERLOADING)
    { DirectFile.addStandardProcedure(new OverLoad(Type.Real,Type.LongReal),"outfix", parameter("r",new OverLoad(Type.Real,Type.LongReal)),parameter("n",Type.Integer),parameter("w",Type.Integer)); 
      DirectFile.addStandardProcedure(new OverLoad(Type.Real,Type.LongReal),"outreal",parameter("r",new OverLoad(Type.Real,Type.LongReal)),parameter("n",Type.Integer),parameter("w",Type.Integer)); 
    } else {
      DirectFile.addStandardProcedure(null,"outfix",parameter("r",Type.LongReal),parameter("n",Type.Integer),parameter("w",Type.Integer));  
      DirectFile.addStandardProcedure(null,"outreal",parameter("r",Type.LongReal),parameter("n",Type.Integer),parameter("w",Type.Integer));  
    }
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
  { BASICIO.addStandardClass(PrintFile);
    //PrintFile.isContextFree=true;
    PrintFile.addStandardAttribute(Type.Integer,"LINE_");  
    PrintFile.addStandardAttribute(Type.Integer,"LINES_PER_PAGE_");  
    PrintFile.addStandardAttribute(Type.Integer,"SPACING_");  
    PrintFile.addStandardAttribute(Type.Integer,"PAGE_");  
    PrintFile.addStandardProcedure(Type.Integer,"line"); 
    PrintFile.addStandardProcedure(Type.Integer,"page");  
    PrintFile.addStandardProcedure(Type.Boolean,"open",parameter("fileimage",Type.Text));  
    PrintFile.addStandardProcedure(Type.Boolean,"close");  
    PrintFile.addStandardProcedure(Type.Integer,"linesperpage",parameter("n",Type.Integer));  
    PrintFile.addStandardProcedure(null,"spacing",parameter("n",Type.Integer));  
    PrintFile.addStandardProcedure(null,"eject",parameter("n",Type.Integer));  
    PrintFile.addStandardProcedure(null,"outimage");  
    PrintFile.addStandardProcedure(null,"outrecord");  
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
  { BASICIO.addStandardClass(ByteFile);
    //ByteFile.isContextFree=true;
    ByteFile.addStandardAttribute(Type.ShortInteger,"BYTESIZE_");  
    ByteFile.addStandardProcedure(Type.ShortInteger,"bytesize");  
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
  { BASICIO.addStandardClass(InbyteFile);
    //InbyteFile.isContextFree=true;
    InbyteFile.addStandardAttribute(Type.Boolean,"ENDFILE_");  
    InbyteFile.addStandardProcedure(Type.Boolean,"endfile");  
    InbyteFile.addStandardProcedure(Type.Boolean,"open",parameter("fileimage",Type.Text));  
    InbyteFile.addStandardProcedure(Type.Boolean,"close");  
    InbyteFile.addStandardProcedure(Type.ShortInteger,"inbyte");  
    InbyteFile.addStandardProcedure(Type.Text,"intext",parameter("t",Type.Text));  
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
    //OutbyteFile.isContextFree=true;
    OutbyteFile.addStandardProcedure(Type.Boolean,"open",parameter("fileimage",Type.Text));  
    OutbyteFile.addStandardProcedure(Type.Boolean,"close");  
    OutbyteFile.addStandardProcedure(null,"outbyte",parameter("x",Type.ShortInteger));   
    OutbyteFile.addStandardProcedure(null,"outtext",parameter("t",Type.Text));  
    OutbyteFile.addStandardProcedure(Type.Boolean,"checkpoint");  
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
  { BASICIO.addStandardClass(DirectByteFile);
    //DirectByteFile.isContextFree=true;
    DirectByteFile.addStandardAttribute(Type.Integer,"LOC_");  
    DirectByteFile.addStandardAttribute(Type.Integer,"MAXLOC_");  
    DirectByteFile.addStandardAttribute(Type.Boolean,"LOCKED_");  
    DirectByteFile.addStandardProcedure(Type.Boolean,"endfile");  
    DirectByteFile.addStandardProcedure(Type.Integer,"location");  
    DirectByteFile.addStandardProcedure(Type.Integer,"maxloc");  
    DirectByteFile.addStandardProcedure(Type.Boolean,"locked");  
    DirectByteFile.addStandardProcedure(Type.Boolean,"open",parameter("fileimage",Type.Text));  
    DirectByteFile.addStandardProcedure(Type.Boolean,"close");      
    DirectByteFile.addStandardProcedure(Type.Integer,"lastloc");  
    DirectByteFile.addStandardProcedure(null,"locate",parameter("i",Type.Integer));  
    DirectByteFile.addStandardProcedure(Type.ShortInteger,"inbyte");  
    DirectByteFile.addStandardProcedure(null,"outbyte",parameter("x",Type.ShortInteger));   
    DirectByteFile.addStandardProcedure(Type.Boolean,"checkpoint");  
    DirectByteFile.addStandardProcedure(Type.Integer,"lock",parameter("t",Type.Real),parameter("i",Type.Integer),parameter("j",Type.Integer));  
    DirectByteFile.addStandardProcedure(Type.Boolean,"unlock");  
    DirectByteFile.addStandardProcedure(Type.Text,"intext",parameter("t",Type.Text));  
    DirectByteFile.addStandardProcedure(null,"outtext",parameter("t",Type.Text));  
    DirectByteFile.addStandardProcedure(Type.Boolean,"checkpoint");  
  }  
  
  // ******************************************************************
  // *** The Standard Class Simset
  // ******************************************************************
  public static StandardClass Simset=new StandardClass("CLASS","Simset");
  static
  { ENVIRONMENT.addStandardClass(Simset);
  }  
  
  // ******************************************************************
  // *** The Standard Class Linkage
  // ******************************************************************
  public static StandardClass Linkage=new StandardClass("CLASS","Linkage");
  static
  { Simset.addStandardClass(Linkage);
//  ref(link) procedure suc;
//  ref(link) procedure pred;
    Linkage.addStandardProcedure(Type.Ref("Link"),"suc");  
    Linkage.addStandardProcedure(Type.Ref("Link"),"pred");  
    Linkage.addStandardProcedure(Type.Ref("Linkage"),"prev");  
  }  
  
  // ******************************************************************
  // *** The Standard Linkage Class Head
  // ******************************************************************
  public static StandardClass Head=new StandardClass("Linkage","Head");
  static
  { Simset.addStandardClass(Head);
//  ref(link) procedure first;
//  ref(link) procedure last;
//  Boolean procedure empty;
//  Integer procedure cardinal;
//  procedure clear;
    Head.addStandardProcedure(Type.Ref("Link"),"first");  
    Head.addStandardProcedure(Type.Ref("Link"),"last");  
    Head.addStandardProcedure(Type.Boolean,"empty");  
    Head.addStandardProcedure(Type.Integer,"cardinal");  
    Head.addStandardProcedure(null,"clear");  
  }  
  
  // ******************************************************************
  // *** The Standard Linkage Class Link
  // ******************************************************************
  public static StandardClass Link=new StandardClass("Linkage","Link");
  static
  { Simset.addStandardClass(Link);
//  procedure out;
//  procedure follow(X); ref(linkage) X;
//  procedure precede(X); ref(linkage) X;
//  procedure into(S); ref(head) S;
    Link.addStandardProcedure(null,"out");  
    Link.addStandardProcedure(null,"follow",parameter("X",Type.Ref("Linkage")));  
    Link.addStandardProcedure(null,"precede",parameter("X",Type.Ref("Linkage")));  
    Link.addStandardProcedure(null,"into",parameter("S",Type.Ref("Head")));  
  }  
  
  // ******************************************************************
  // *** The Standard Class Simulation
  // ******************************************************************
  public static StandardClass Simulation=new StandardClass("Simset","Simulation");
  static
  { ENVIRONMENT.addStandardClass(Simulation);
    Simulation.detachUsed=true;
    Simulation.addStandardAttribute(Type.Ref("Head"),"SQS");  
    Simulation.addStandardAttribute(Type.Ref("MAIN_PROGRAM"),"main");  
    Simulation.addStandardProcedure(Type.LongReal,"time");  
    Simulation.addStandardProcedure(Type.Ref("EVENT_NOTICE"),"FIRSTEV");  
    Simulation.addStandardProcedure(Type.Ref("Process"),"current");  
    Simulation.addStandardProcedure(null,"hold",parameter("T",Type.LongReal));  
    Simulation.addStandardProcedure(null,"passivate");  
    Simulation.addStandardProcedure(null,"wait",parameter("S",Type.Ref("Head")));  
    Simulation.addStandardProcedure(null,"cancel",parameter("x",Type.Ref("Process")));  
    Simulation.addStandardProcedure(null,"ActivateDirect"
    		,parameter("REAC",Type.Boolean)
    		,parameter("X",Type.Ref("Process"))
    		);  
    Simulation.addStandardProcedure(null,"ActivateAt"
    		,parameter("REAC",Type.Boolean)
    		,parameter("X",Type.Ref("Process"))
    		,parameter("T",Type.LongReal)
    		,parameter("PRIO",Type.Boolean)
    		);  
    Simulation.addStandardProcedure(null,"ActivateDelay"
    		,parameter("REAC",Type.Boolean)
    		,parameter("X",Type.Ref("Process"))
    		,parameter("T",Type.LongReal)
    		,parameter("PRIO",Type.Boolean)
    		);  
    Simulation.addStandardProcedure(null,"ActivateBefore"
    		,parameter("REAC",Type.Boolean)
    		,parameter("X",Type.Ref("Process"))
    		,parameter("Y",Type.Ref("Process"))
    		);  
    Simulation.addStandardProcedure(null,"ActivateAfter"
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
  { Simulation.addStandardClass(EVENT_NOTICE);
//  ref(EVENT_NOTICE) procedure suc;
//  ref(EVENT_NOTICE) procedure pred;
//  procedure RANK(BEFORE_); Boolean BEFORE_;
    EVENT_NOTICE.addStandardProcedure(Type.Ref("EVENT_NOTICE"),"suc");  
    EVENT_NOTICE.addStandardProcedure(Type.Ref("EVENT_NOTICE"),"pred");  
    EVENT_NOTICE.addStandardProcedure(null,"RANK",parameter("BEFORET",Type.Boolean));  
  }  
  
  // ******************************************************************
  // *** The Standard Link Class Process
  // ******************************************************************
  public static StandardClass Process=new StandardClass("Link","Process");
  static
  { Simulation.addStandardClass(Process);
    Process.detachUsed=true;
//  ref(EVENT_NOTICE) EVENT;
//  Boolean TERMINATED_;
//  Boolean procedure idle;
//  Boolean procedure terminated;
//  real procedure evtime;
//  ref(Process) procedure nextev;
    Process.addStandardAttribute(Type.Ref("EVENT_NOTICE"),"EVENT");  
    Process.addStandardAttribute(Type.Boolean,"TERMINATED_");  
    Process.addStandardProcedure(Type.Boolean,"idle");  
    Process.addStandardProcedure(Type.Boolean,"terminated");  
    Process.addStandardProcedure(Type.LongReal,"evtime");  
    Process.addStandardProcedure(Type.Ref("Process"),"nextev");  
  }  
  
  // ******************************************************************
  // *** The Standard Process Class MAIN_PROGRAM
  // ******************************************************************
  public static StandardClass MAIN_PROGRAM=new StandardClass("Process","MAIN_PROGRAM");
  static
  { Simulation.addStandardClass(MAIN_PROGRAM);
//  Process class MAIN_PROGRAM;
//  begin
//     L: detach; goto L
//  end MAIN_PROGRAM;
  }  
	
  
  
  // ******************************************************************
  // *** Constructors
  // ******************************************************************
	
  public StandardClass(String className)
  { super(className);
    this.externalIdent=className+"$";
	this.blockKind=BlockDeclaration.Kind.StandardClass;
	this.type=Type.Ref(className);
	//  Util.BREAK("NEW StandardClass "+this);
  }
  public StandardClass(String prefix,String className)
  { this(className);
	this.prefix=prefix;
	//  Util.BREAK("NEW StandardClass "+this);
	
  }
	
  public StandardClass(String prefix,String className,Parameter p1)
  { this(prefix,className);
	addParameter(p1);
  }
	
  public StandardClass(String className,Parameter p1)
  { this(className);
	addParameter(p1);
  }
  
  private static Parameter parameter(String ident,Type type)
  { return(new Parameter(ident,type,Parameter.Kind.Simple)); }
  
  private static Parameter parameter(String ident,Type type,Parameter.Kind kind)
  { return(new Parameter(ident,type,kind)); }
  
  private static Parameter parameter(String ident,Parameter.Mode mode,Type type)
  { Parameter spec=new Parameter(ident,type,Parameter.Kind.Simple);
    spec.setMode(mode); return(spec);
  }
  
  public Meaning findVisibleAttributeMeaning(String ident)
  { //Util.BREAK("StandardClass("+this.identifier+").findAttribute("+ident+"): scope="+declaredIn+", chain="+edScopeChain());
    for(Declaration declaration:declarationList)
    	if(ident.equalsIgnoreCase(declaration.identifier))
    	   	  return(new Meaning(Variable.Kind.standardAttribute,declaration,this));
    BlockDeclaration prfx=getPrefix();
    if(prfx!=null) return(prfx.findVisibleAttributeMeaning(ident));
    
//    if(result!=null) Util.TRACE("END StandardClass.findAttribute("+ident+"): result="+result.getEnclosureName()+'.'+result);   
    return(null);
  }
  
  public Meaning findRemoteAttributeMeaning(String ident)
  {return(findRemoteAttributeMeaning(ident,false)); } 
  public Meaning findRemoteAttributeMeaning(String ident,boolean behindProtected)
  { //Util.BREAK("StandardClass("+this.identifier+").findAttribute("+ident+"): scope="+declaredIn+", chain="+edScopeChain());
    for(Declaration declaration:declarationList)
    	if(ident.equalsIgnoreCase(declaration.identifier))
    	   	  return(new Meaning(Variable.Kind.standardAttribute,declaration,this));
    BlockDeclaration prfx=getPrefix();
    if(prfx!=null) return(prfx.findRemoteAttributeMeaning(ident,behindProtected));
    
//    if(result!=null) Util.TRACE("END StandardClass.findAttribute("+ident+"): result="+result.getEnclosureName()+'.'+result);   
    return(null);
  }

  private void addStandardClass(StandardClass standardClass)
  {	standardClass.declaredIn=this;
    //standardClass.blockLevel=blockLevel+1;
   	//Util.BREAK("StandardClass.addStandardClass("+standardClass+") to "+this+": scope="+getScopeName()+", chain="+standardClass.edScopeChain());
    declarationList.add(standardClass);
  }

  private void addStandardAttribute(Type type,String ident)
  { declarationList.add(new TypeDeclaration(type,ident)); }

//  private void addStandardProcedure(Type type,String ident,Parameter p1,Parameter p2,Parameter p3,Parameter p4,Parameter p5,Parameter p6)
//  {	declarationList.add(new StandardProcedure(this,type,ident,p1,p2,p3,p4,p5,p6)); }
//
//  private void addStandardProcedure(Type type,String ident,Parameter p1,Parameter p2,Parameter p3,Parameter p4,Parameter p5)
//  {	declarationList.add(new StandardProcedure(this,type,ident,p1,p2,p3,p4,p5)); }

  private void addStandardProcedure(Type type,String ident,Parameter p1,Parameter p2,Parameter p3,Parameter p4)
  {	declarationList.add(new StandardProcedure(this,type,ident,p1,p2,p3,p4)); }

  private void addStandardProcedure(Type type,String ident,Parameter p1,Parameter p2,Parameter p3)
  {	declarationList.add(new StandardProcedure(this,type,ident,p1,p2,p3)); }

  private void addStandardProcedure(Type type,String ident,Parameter p1,Parameter p2)
  {	declarationList.add(new StandardProcedure(this,type,ident,p1,p2)); }

  private void addStandardProcedure(Type type,String ident,Parameter param)
  {	declarationList.add(new StandardProcedure(this,type,ident,param)); }

  private void addStandardProcedure(Type type,String ident)
  {	declarationList.add(new StandardProcedure(this,type,ident)); }

}


