/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.parsing;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Stack;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

//*************************************************************************************
//**                                                                 CLASS PreProcessor
//*************************************************************************************

/**
 * Input Utilities for the Simula Scanner.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class PreProcessor
{ private static int currentCharacter;
  private static PreProcessor currentSource;
  private static Reader currentReader() { return(currentSource.reader); }
  private static Stack<Character> puchBackStack=new Stack<Character>();
  private static boolean newline=true; // Last character read was a NEWLINE character \n
  private static boolean incrementLineNumber=true;
  private static boolean selector[]=new boolean[256];
  private static String currentTitle="";
  private static StringBuilder listingLine=new StringBuilder();

  public static final int EOF=-1;           // used to denote end-of-input
//  public static int getLineNumber() { return(sourceLineNumber); }
  
  // Attributes
  private String fileName;    //! source file name;
  private boolean inserted;   //! true if this module is INSERT'ed, false when COPY;
//  boolean listingon;        //! stacked listing flag;
  private Reader reader;      //! actual source file reader;
  private PreProcessor prev;   //! stack link for inserted modules;

  
  public PreProcessor(String fileName,boolean inserted)
  { this.fileName=fileName; this.inserted=inserted;
    //Util.BREAK("NEW PreProcessor fileName="+fileName);
	try { reader=new FileReader(fileName);
		} catch (IOException e) {
		System.out.println("Error Opening File: "+fileName);
		e.printStackTrace();
		Util.error("can't open "+fileName);
	}
    prev=currentSource; currentSource=this;
//    if(inserted) listingon=false;		  
    if(inserted) incrementLineNumber=false;		  
  }
    
  public void close()
  { try { reader.close();
    } catch (IOException e) {
      System.out.println("Error Closing File: "+fileName);
      e.printStackTrace();
    }
//    listingon=prev.listingon;
    incrementLineNumber=!prev.inserted;
    currentSource=prev;
  } // end close;

  
  // *****************************************************************
  // *** STATIC METHODS
  // *****************************************************************

  private static void skipCommentLine()
  { StringBuilder s=new  StringBuilder();
	do { readNextCharacter();
	     s.append((char)currentCharacter);
	}
	while( currentCharacter!='\n');
	pushBack('\n');
	if(Option.TRACE_PREPROCESSOR) Util.TRACE("PreProcessor.skipCommentLine: % "+s);
  }
	
  
  
//case '\b':	/* BS */
//case '\t':	/* HT */
//case 11:		/* VT */
//case '\f':	/* FF */
//case '\r':	/* CR */

  private static void readNextCharacter()
  {	if(!puchBackStack.empty())
    { currentCharacter=puchBackStack.pop(); return; }
	try
    { currentCharacter=currentReader().read();
	  if(currentCharacter=='\n')
	  { if(incrementLineNumber) Global.sourceLineNumber++;
	    Util.setLine(Global.sourceLineNumber);
	    if(Option.verbose) Util.LIST(listingLine.toString());
	    listingLine=new StringBuilder();
	  } 
      if(currentCharacter!=EOF && currentCharacter<32 && currentCharacter!=10) currentCharacter=' ';
      //Util.BREAK("PreProcessor.read: c="+(char)currentCharacter);
      if(currentCharacter>=32) listingLine.append((char)currentCharacter);
      else if(currentCharacter!=10 && currentCharacter!=13)
    	  listingLine.append("!"+currentCharacter+'!');
    }
	catch(IOException e) { currentCharacter=EOF;  }
  }
  
  // advances one character in the input
  public static int getNext()
  { readNextCharacter();
    if(newline)
    { newline=false;
  	  while(currentCharacter=='%') try { scanDirectiveLine(); }
  	  catch(IOException e) { return(EOF);  }
    }   	
	if(Option.TRACE_PREPROCESSOR) Util.TRACE("Input: '"+(char)currentCharacter+"'="+currentCharacter);
	if(currentCharacter=='\n') newline=true; 
	return(currentCharacter);
  }
		  
  
  // put given value back into the input stream
  public static void pushBack(int chr)
  { puchBackStack.push((char)chr); }

  // put given value back into the input stream
  static void pushBack(String s) 
  { int i=s.length();
	while((i--)>0) pushBack(s.charAt(i));
  }
  
  
  // **********************************************************************
  // *** DIRECTIVE
  // **********************************************************************
  static String linefield() throws IOException
  { StringBuilder s=new StringBuilder();
	// Skip initial blanks
    while(currentCharacter==' ') readNextCharacter();
	while(currentCharacter!=' ' && currentCharacter!='\n')
    { s.append((char)currentCharacter);
 	  readNextCharacter();
    }
    return(s.toString());
  }
  
  static String lineRest() throws IOException
  { StringBuilder s=new StringBuilder();
	// Skip initial blanks
    while(currentCharacter==' ') readNextCharacter();
	while(currentCharacter!='\n')
    { s.append((char)currentCharacter);
 	  readNextCharacter();
    }
    return(s.toString());
  }

//procedure addoption(c); character c;
//begin text t;
//      if not xoption(c) then begin
//         t:-blanks(feoptions.length+1); t:=feoptions;
//         t.sub(t.length,1).putchar(c); feoptions:-t;
//      end;
//end;

//procedure removeoption(c); character c;
//begin text t; character d;
//      if xoption(c) then begin
//         t:-feoptions; feoptions.setpos(1); t.setpos(1);
//         while feoptions.more do begin
//               d:=feoptions.getchar;
//               if d <> c then t.putchar(d);
//         end;
//         feoptions:-copy(t.sub(1,t.pos-1));
//      end;
//end;
  private static boolean lineSelected() throws IOException
  { //Util.BREAK("PreProcessor.lineSelected: c="+(char)currentCharacter);
	while(true)
	{ if(currentCharacter=='+')
	  { readNextCharacter();
	    //Util.BREAK("PreProcessor.lineSelected(+): c="+(char)currentCharacter);
	    while(Character.isLetter(currentCharacter))
	    { if(!selector[currentCharacter]) return(false); // then goto SKIPLINE;
	      readNextCharacter();
		  //Util.BREAK("PreProcessor.lineSelected(2+): c="+(char)currentCharacter);
	    }
	  }
	  else if(currentCharacter=='-')
	  { readNextCharacter();
	    //Util.BREAK("PreProcessor.lineSelected(-): c="+(char)currentCharacter);
	    while(Character.isLetter(currentCharacter))
	    { if(selector[currentCharacter]) return(false); // then goto SKIPLINE;
	      readNextCharacter();
		  //Util.BREAK("PreProcessor.lineSelected(2-): c="+(char)currentCharacter);
	    }
	  }
	  else break;
	}
	while(currentCharacter==' ') readNextCharacter();
    //Util.BREAK("PreProcessor.lineSelected(end): c="+(char)currentCharacter);
	return(true); // Return to scan remainder part of line.
  }

public static void scanDirectiveLine() throws IOException
{ readNextCharacter(); //"First character of line";
  //Util.BREAK("PreProcessor.scanDirectiveLine: char="+(char)currentCharacter);
  if(currentCharacter==' ') 
  {	skipCommentLine(); // Skip comment line
	return;  
  }
  if(currentCharacter=='+' || currentCharacter=='-')
  { if(!lineSelected())
    { //Util.BREAK("PreProcessor.scanDirectiveLine: NOT SELECTED char="+(char)currentCharacter);
	  skipCommentLine();
    }
    //Util.BREAK("PreProcessor.scanDirectiveLine: RETURN char="+(char)currentCharacter);
    return;
  }
  String u=linefield(); // First word of line
  //Util.BREAK("PreProcessor.scanDirectiveLine: word="+u);
  if( u.equalsIgnoreCase("BOUNDCHECK")) boundCheck();
  else if(u.equalsIgnoreCase("COPY")) copy();
  else if(u.equalsIgnoreCase("DEFINITION")) definition();
//  else if(u.equalsIgnoreCase("DISPLAY")) setDisplay();
  else if(u.equalsIgnoreCase("EOF")) endFile();
  else if(u.equalsIgnoreCase("INSERT")) insert();
  else if(u.equalsIgnoreCase("KEEP_JAVA")) setKeepJava();
  else if(u.equalsIgnoreCase("LIST")) list("lineField");
  else if(u.equalsIgnoreCase("NODUMMY")) noDummy();
  else if(u.equalsIgnoreCase("NONECHECK")) noneCheck();
  else if(u.equalsIgnoreCase("NOSOURCE")) list("OFF"); //then  listingon:=false
  else if(u.equalsIgnoreCase("PAGE")) page();
  else if(u.equalsIgnoreCase("QUACHECK")) quaCheck();
  else if(u.equalsIgnoreCase("REUSE")) reuse();
  else if(u.equalsIgnoreCase("SELECT")) select();
  else if(u.equalsIgnoreCase("SETOPT")) setOption();
  else if(u.equalsIgnoreCase("SETSWITCH")) setSwitch();
  else if(u.equalsIgnoreCase("SLENGTH")) sourceLength();
  else if(u.equalsIgnoreCase("SOURCE")) list("ON");//then    listingon:=listfile=/=none
  else if(u.equalsIgnoreCase("SPORT")) sport();
  else if(u.equalsIgnoreCase("STANDARDCLASS")) setStandardClass();
  else if(u.equalsIgnoreCase("TITLE")) setTitle();
  else if(u.equalsIgnoreCase("QUALIFIEDNAMES")) setUseQualifiedNames();

  else if( u.equalsIgnoreCase("IMPLEMENTATION")) {
    	//then begin recomp:=true;definition:=false end
    	warning("NOT IMPLEMENTED: Compiler Directive: %IMPLEMENTATION");
  }
  else if( u.equalsIgnoreCase("DEFINE")) {
    	warning("NOT IMPLEMENTED: Compiler Directive: %DEFINE");
    	//	         parser:-new macro_parser(parser,false);
    	//	         line:-line.sub(9,line.length-8); goto DELIVERLINE; 
  }
  else if( u.equalsIgnoreCase("MACRO")) {
    	warning("NOT IMPLEMENTED: Compiler Directive: %MACRO");
    	//	    	 parser:-new macro_parser(parser,true);
    	//	         line:-line.sub(8,line.length-7); goto DELIVERLINE;
  }
  else if( u.equalsIgnoreCase("ENDMACRO")) {
    	  warning("NOT IMPLEMENTED: Compiler Directive: %ENDMACRO");
    	//	               inspect parser when macro_parser do begin
    	//	                       terminate;
    	//	                       symbol:=';'; line:-terminator;
    	//	                       call(scanner); !to terminate possible END-comment;
    	//	               end otherwise goto DIRWARN;
  }
  else warning("Unknown Compiler Directive: %"+u);    
} //end directive;

private static void warning(String msg)
{ Util.warning(msg);
  //readUntilEndOfLine();
  skipCommentLine();
  currentCharacter=' ';
}


/**
 * %BOUNDCHECK [ ON | OFF ]
 * <p>
 * Controls generation of array bound checking, if possible on the given implementation.
 * The initial setting is ON.
 */
private static void boundCheck()
{ warning("NOT IMPLEMENTED: Compiler Directive: %BOUNDCHECK"); }

/**
 * %COPY file-name
 * <p>
 * Will cause the compiler to include the indicated file at this place in the source
 * input stream, as if the text was actually written in the module containing %COPY.
 * COPY (or INSERT) may occur in the included file:
 * The included lines are always counted, i.e. they will be numbered sequentially,
 * starting from the number of the line of the COPY-directive. 
 */
private static void copy() throws IOException
{ String fileName=linefield();
  new PreProcessor(fileName,false); //u="INSERT");
	
}

/**
 * %DEFINITION
 * <p>
 * This directive is relevant only in a separately compiled procedure or class.
 * The compiler will regard this compilation as a prototype definition only,
 * i.e. the module is checked for syntactic and semantic correctness, and
 * the appropriate attribute element is produced, but no code generation is performed.
 */
private static void definition()
{
  warning("NOT IMPLEMENTED: Compiler Directive: %DEFINITION");
  // recomp:=false; definition:=true end
}

///**
// * %DISPLAY [ ON | OFF ]
// * <p>
// * Normally, the compiler will produce code for a nested block structure
// * using an object display vector.
// * <p>
// * This option will set/reset the 'useDisplayAccess' option.
// * <p> 
// * The initial setting is ON.
// */
//private static void setDisplay() throws IOException
//{ String opt=linefield();
//  warning("Compiler Directive: %DISPLAY sets Option.useDisplayAccess="+opt);
//  // recomp:=false; definition:=true end
//  Option.useDisplayAccess=opt.equalsIgnoreCase("ON");
//}

 /**
 * %EOF
 * <p>
 * When the compiler recognizes this directive it reacts as if the end of the
 * source file was encountered, i.e. it terminates reading and, if this module
 * was inserted (see INSERT/COPY), source scanning will continue after the INSERT (COPY)
 * directive in the enclosing file.
 */
private static void endFile()
{
  warning("NOT IMPLEMENTED: Compiler Directive: %EOF");
}

/**
 * %INSERT file-name
 * <p>
 * Will cause the compiler to include the indicated file at this place in the
 * source input stream. INSERT may occur in the included file.
 * In contrast to COPY, the included lines are not counted (they will all be
 * numbered with the line number of the line containing the outermost INSERT).
 * Furthermore, if the source is being listed, listing is turned off during 
 * the inclusion and turned on again when reading continues after this directive. 
 */
private static void insert() throws IOException
{ String fileName=linefield();
  new PreProcessor(fileName,true);//u="INSERT");
}

/**
 * %LIST [ ON | OFF ] 
 * <p>
 * %NOSOURCE - same effect as %LIST OFF
 * <p>
 * %SOURCE - same effect as %LIST ON
 * <p>
 * Use of this directive controls whether or not the succeeding lines of the
 * source text shall be listed.
 * %LIST OFF will suspend listing, while %LIST ON will resume listing.
 * If listing was not requested when the compilation was started (see compiler
 * options) these directives have no effect. 
 * The initial setting is ON. 
 */
private static void list(String t)
{
  warning("NOT IMPLEMENTED: Compiler Directive: %LIST");
//  t:-linefield; t:-upcase(t);
//          if t="ON" then       listingon:=listfile=/=none
//          else if t="OFF" then listingon:=false
//          else goto DIRWARN;
}

/**
 * %NODUMMY [ ON | OFF ]
 * <p>
 * Supress the generation of dummy inspection-blocks.
 * In order to have effect the directive must occur 
 * before the first connection statement affected.
 */
private static void noDummy()
{ warning("NOT IMPLEMENTED: Compiler Directive: %NODUMMY"); }

/**
 * %NONECHECK [ ON | OFF ] 
 * <p>
 * Controls the generation of checks for whether a reference attribute
 * is none when it is used as a pointer. The initial setting is ON.
 */
private static void noneCheck()
{ warning("NOT IMPLEMENTED: Compiler Directive: %NONECHECK"); }

/**
 * %PAGE
 * <p>
 * Will cause the compiler to change to a new page in the listing file.
 * If the page heading (as defined by %TITLE, see below) is non-empty,
 * it will be printed on top of the new page.
 */
private static void page()
{ warning("NOT IMPLEMENTED: Compiler Directive: %PAGE"); }

/**
 * %QUACHECK [ ON | OFF ]
 * <p>
 * Controls the generation of qualification checks,
 * both explicit and implicit. The initial setting is ON.
 */
private static void quaCheck()
{ warning("NOT IMPLEMENTED: Compiler Directive: %QUACHECK"); }

/**
 * %REUSE
 * <p>
 * Normally, termination of a procedure or block will leave the
 * corresponding object as a (non-referenced) block in the heap.
 * This area cannot be used until the heap is compacted
 * (by the 'garbage collector').
 * When REUSE is ON during compilation, such objects are reclaimed 
 * when released if they are at the moment on top of the heap.
 * The initial setting is OFF.
 */
private static void reuse()
{ warning("NOT IMPLEMENTED: Compiler Directive: %REUSE"); }

/**
 * %SELECT select-character { select-character }
 * <p>
 * Set selectors for conditional compilation.
 */
private static void select() throws IOException
{ for(int i=0;i<255;i++) selector[i]=false;
  readNextCharacter();
  while(currentCharacter==' ') readNextCharacter();
  while(currentCharacter!=' ' && currentCharacter!='\n')
  { selector[currentCharacter]=true;
    Util.BREAK("PreProcessor.select: selector["+(char)currentCharacter+"]=true");
	readNextCharacter();
  }
}

/**
 * %SETOPT option-character { option-character }
 * <p>
 * For each character in the option-character string, the corresponding
 * selector is set. All selectors not in the string are reset.
 * <p>
 * Selectors are used to decide which conditional source lines to be scanned.
 * <pre>
 * Example:
 *     %+MD-F  while(x>45)
 * </pre>
 * The statement "while(x>45)" is compiled only when selectors 'M' and 'D'
 * are set and 'F' is reset.
 */
private static void setOption()
{
  warning("NOT IMPLEMENTED: Compiler Directive: %SETOPT");
//    short integer i; character c,d;
//    line.setpos(8);
//    while line.more do
//    begin c:=line.getchar;
//          if c='+' or c='-' then
//          begin while line.more do
//                begin d:=line.getchar;
//                      if d=' ' then goto endpack;
//                      if c='+' then addoption(d)
//                      else removeoption(d);
//                end;
//          end
//     else if c <> ' ' then
//          begin i:=line.pos-1;
//                while line.more do
//                if line.getchar=' ' then
//                begin line.setpos(line.pos-1); goto E end;
//             E: feoptions:-copy(line.sub(i,line.pos-i));
//          end;
//endpack: end;
//    setoptions; opn:=IGO; call(coder);
	
}

/**
 * %SETSWITCH  number1  number2
 * <p>
 * Will set compiler switch 'number1' to the value 'number2'.
 * The facility is intended for compiler maitenance,
 * and is not explained further.
 */
private static void setSwitch()
{
  warning("NOT IMPLEMENTED: Compiler Directive: %SETSWITCH");
//    t:-linefield;
//          if not digit(t.getchar) !or t.length>3; then goto DIRWARN;
//          inspect coder when L2coder do begin
//             cswa:=t.getint; if cswa>255 or cswa<0 then goto DIRWARN;
//             t:-linefield;
//             if not digit(t.getchar) !or t.length>3; then goto DIRWARN;
//             cswb:=t.getint; if cswb>255 or cswb<0 then goto DIRWARN;
//          end;
//          opn:=ISSWA; call(coder);
//          !*** scanner and parser are bypassed;

}

/**
 * %SLENGTH last-column
 * <p>
 * The argument must be a positive integer.
 * The directive will cause the compiler to scan only columns 1 through
 * 'last-column' of the source lines.
 * The directive may be useful in case the source text has e.g. sequence
 * numbers in the last positions of each source line, or when compiling 
 * a set of source files of varying widths.
 * Initially the compiler will scan the complete source line.
 */
private static void sourceLength()
{
  warning("NOT IMPLEMENTED: Compiler Directive: %SLENGTH");
//    t:-linefield;
//          if not digit(t.getchar) then goto DIRWARN;
//          i:=t.getint;
//          if i>maxsourcelength then scanwarn(208)
//          else signiflength:=i;

}

/**
 * %SPORT [ ON | OFF ]
 * <p>
 * Enables/disables special features of any S-port SIMULA compiler,
 * such as inclusion of the S-port library
 */
private static void sport()
{ warning("NOT IMPLEMENTED: Compiler Directive: %SPORT"); }

/**
 * %STANDARDCLASS
 * <p>
 * Used to compile 'standard classes' to indicate simplified block structure.
 * In addition all 'procedures' will be treated as Java Methods.
 * <p>
 * The initial value is false.
 * See BlockDeclaration.java
 */
private static void setStandardClass()
{ warning("Compiler Directive: %STANDARDCLASS sets Option.standardClass=true");
  Option.standardClass=true;
}

/**
 * %TITLE title-string
 */
private static void setTitle() throws IOException
{ currentTitle=lineRest();
  Util.BREAK("TITLE: "+currentTitle);
}


/**
 * %QUALIFIEDNAMES
 * <p>
 * Used by Java-Coding to generate fully qualified class/procedure names.
 * <p>
 * Consider a class A with local class B, then the 'qualified name' B is
 * 'A$B<number>' where <number> is added to make the name 'A$B<number>.java'
 * unique within the file directory.
 * <p>
 * The initial value is false.
 * See BlockDeclaration.java
 */
private static void setUseQualifiedNames()
{ warning("Compiler Directive: %QUALIFIEDNAMES sets Option.useQualifiedNames=true");
  Option.useQualifiedNames=true;
}


/**
 * %KEEP_JAVA directory-string
 */
private static void setKeepJava() throws IOException
{ Option.keepJava=lineRest();
  Util.BREAK("KEEP_JAVA: "+Option.keepJava);
}

  
 
  
  
  
}
