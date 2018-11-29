/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.parsing;

import java.io.IOException;
import java.io.Reader;
import java.util.Stack;
import java.util.StringTokenizer;

//import simula.compiler.parsing.PreProcessor;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Token;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class SimulaScanner
{ 
  public static long prevLineNumber;
  
  private static Reader reader;      // actual source file reader;
  private static Stack<Character> puchBackStack=new Stack<Character>();
  private static StringBuilder listingLine=new StringBuilder();
  public static final int EOF=-1;           // used to denote end-of-input

  /**
   * NOTE: An initial "-" in array upper bound may follow : directly (cf. 1.3).
   * The scanner will treat ":-" within parentheses (round brackets) as two
   * separate symbols ":" and "-" thus solving this ambiguity in the syntax. 
   * <p>
   * This variable is used to cover such situations.
   */
  private static int pardepth=0;

  //*************************************************************************
  //*** CONSTRUCTORS: SimulaScanner
  //*************************************************************************
  
  /**
  Constructs a new SimulaScanner that produces Items scanned from the specified
  source.

  @param fileName The character source to scan
  */
  public SimulaScanner(Reader theReader) {
	  Global.sourceLineNumber=1;
	  prevLineNumber=0;
	  reader=theReader;
  }

  //********************************************************************************
  //**	                                                                 UTILITIES 
  //********************************************************************************
  private static int current;
//  private static int getNext() { return(current=PreProcessor.getNext()); }
//  private static void pushBack(int chr) { PreProcessor.pushBack(chr); current='�'; }
//  private static void pushBack(String s) { PreProcessor.pushBack(s); }
  private static int getNext() {
	  current=readNextCharacter();
	  return(current);
  }
  
  private static int readNextCharacter()
  {	if(!puchBackStack.empty()) return(puchBackStack.pop());
    int currentCharacter;
	try
    { currentCharacter=reader.read();
	  if(currentCharacter=='\n')
	  { Global.sourceLineNumber++;
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
	return(currentCharacter);
  }

  private static void pushBack(int chr) {
	  // put given value back into the input stream
	  //public static void pushBack(int chr)
	  { puchBackStack.push((char)chr); }
	  current='�';
  }
  
  private static void pushBack(String s) {
	  // put given value back into the input stream
	  { int i=s.length();
		while((i--)>0) pushBack(s.charAt(i));
	  }

  }
  
  private Token newItem(KeyWord keyWord,Object value)
  {
	return(new Token(keyWord,value));
  }
  
  private Token newItem(KeyWord keyWord)
  { return(newItem(keyWord,null)); }
  
  private static String edcurrent()
  { if(current<32) return("Current code="+current);
	return("Current='"+(char)current+"' value="+current);
  }
	
  private boolean isHexDigit(int c)
  { switch(c)
    { case '0':case '1':case '2':case '3':case '4':
      case '5':case '6':case '7':case '8':case '9':
      case 'A':case 'B':case 'C':case 'D':case 'E':case 'F':
      case 'a':case 'b':case 'c':case 'd':case 'e':case 'f': return(true);
      default: return(false);
    }
  }
	
  private boolean isPrintable(int c)
  { if(c<32) return(false);
    if(c>126) return(false);
    return(true);
  }
	
  //********************************************************************************
  //**	                                                                 nextToken 
  //********************************************************************************
  private static Token savedItem;
  public Token nextToken()
  { if(savedItem!=null)
	  { Token saved=savedItem;
	    savedItem=null;
	    return(saved);
	  }
    Token token=scanToken();
    
    if(token!=null)
    { if(token.getKeyWord()==KeyWord.AND)
      { Token maybeThen=scanToken();
        if(maybeThen.getKeyWord()==KeyWord.THEN)
            return(newItem(KeyWord.AND_THEN));
        savedItem=maybeThen;
      }
      else if(token.getKeyWord()==KeyWord.OR)
      { Token maybeElse=scanToken();
        if(maybeElse.getKeyWord()==KeyWord.ELSE)
            return(newItem(KeyWord.OR_ELSE));
        savedItem=maybeElse;
      }
    }
	if(Option.TRACE_SCAN) Util.TRACE("Item.nextToken, "+edcurrent());
	//Util.BREAK("Item.nextToken, "+token);
	return(token);
  }	
	
  //********************************************************************************
  //**	                                                                 scanToken 
  //********************************************************************************
  //** End-Condition: current is last character of construct
  //**                getNext will return first character after construct
  //********************************************************************************
  private Token scanToken() {
	  Token token;
	  do token = scanBasic();
	  while (token!=null && token.getKeyWord() == KeyWord.COMMENT);
	  return(token);
  }
  private Token scanBasic()
  {	if(Option.TRACE_SCAN) Util.TRACE("SimulaScanner.scanToken, "+edcurrent());

	while(true)
	{ if(Character.isLetter(getNext())) return(scanIdentifier());
	  switch(current)
	  { case '=':
		  if(getNext() == '=')   return(newItem(KeyWord.EQR));
		  if(current == '/')
		  if(getNext() == '=')   return(newItem(KeyWord.NER));
		  else Util.error("Illegal character combination ="+(char)current);
		  pushBack(current);     return(newItem(KeyWord.EQ));
	    case '>':
		  if(getNext() == '=')   return(newItem(KeyWord.GE));
		  pushBack(current);     return(newItem(KeyWord.GT));
	    case '<':
	      if(getNext() == '=')   return(newItem(KeyWord.LE));
		  if(current == '>')     return(newItem(KeyWord.NE));
		  pushBack(current);     return(newItem(KeyWord.LT));
	    case '+':                return(newItem(KeyWord.PLUS));
	    case '-':	             return(newItem(KeyWord.MINUS));
	    case '*':
		  if(getNext() == '*')   return(newItem(KeyWord.EXP));
		  pushBack(current); 	 return(newItem(KeyWord.MUL));
	    case '/':
		  if(getNext() == '/')   return(newItem(KeyWord.INTDIV));
		  pushBack(current); 	 return(newItem(KeyWord.DIV));
	    case '.':
		  if(Character.isDigit(getNext())) { return(scanDotDigit(new StringBuilder())); }
		  pushBack(current); return(newItem(KeyWord.DOT));
	    case ',':	         return(newItem(KeyWord.COMMA));
	    case ':':
		  if(getNext() == '=')               return(newItem(KeyWord.ASSIGNVALUE));
		  if(current == '-' && pardepth == 0) return(newItem(KeyWord.ASSIGNREF));
		  pushBack(current);           return(newItem(KeyWord.COLON));
	    case ';':	pardepth=0; return(newItem(KeyWord.SEMICOLON));
	    case '(':	pardepth++; return(newItem(KeyWord.BEGPAR));
	    case ')':	pardepth--; return(newItem(KeyWord.ENDPAR));
	    case '[':	return(newItem(KeyWord.BEGBRACKET));
	    case ']':	return(newItem(KeyWord.ENDBRACKET));
	    case '&':
		  if(getNext()=='&'
		  || current=='-'
		  || current=='+'
		  || Character.isDigit(current)) { return(scanDigitsExp(null)); }
		    
		  pushBack(current); return(newItem(KeyWord.CONC));
//	    case '!': scanComment(); break;
	    case '!': return(scanComment());
	    case '\'': return(scanCharacterConstant());
	    case '\"': return(scanTextConstant());
	    case '0':case '1':case '2':case '3':case '4':
	    case '5':case '6':case '7':case '8':case '9':return(scanNumber());
	   
//	    case PreProcessor.EOF:
	    case EOF:
	      if(Option.TRACE_SCAN) Util.BREAK("GOT END-OF-FILE");
	      return(null);
	    	  
	    case '%': return(scanDirectiveLine());
	    	
	    case '\n':			/* NL (LF) */
	      int lineNumber=Global.sourceLineNumber;
	      if(lineNumber>prevLineNumber) { prevLineNumber=lineNumber; }
	    case ' ':
	    case '\b':			/* BS */
	    case '\t':			/* HT */
	    //case '\v':		/* VT */
	    case '\f':			/* FF */
	    case '\r':			/* CR */
	    case '�': // See PushBack
		  break;
	    default: Util.error("Illegal character: "+(char)current+", Value="+(int)current);
//	    Util.BREAK("");
//	    Util.EXIT();
		  break;
	  }
	}
  }
  
  
  //********************************************************************************
  //**	                                                            scanIdentifier 
  //********************************************************************************
  //** End-Condition: current is last character of construct
  //**                getNext will return first character after construct
  //********************************************************************************
	private Token scanIdentifier()
	{ String name=scanName();
	  if(Option.TRACE_SCAN) Util.TRACE("scanIdentifier: name=\""+name+"\"");
	  switch(name.toUpperCase().charAt(0))
	  { case 'A':
		  if(name.equalsIgnoreCase("ABSTRACT"))	  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("ACTIVATE"))   return(newItem(KeyWord.ACTIVATE));
		  if(name.equalsIgnoreCase("AFTER"))	  return(newItem(KeyWord.AFTER));
		  if(name.equalsIgnoreCase("AND"))		  return(newItem(KeyWord.AND));
		  if(name.equalsIgnoreCase("AND_THEN"))	  return(newItem(KeyWord.AND_THEN));
		  if(name.equalsIgnoreCase("ARRAY"))	  return(newItem(KeyWord.ARRAY));
		  if(name.equalsIgnoreCase("ASSERT"))	  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("AT"))		  return(newItem(KeyWord.AT));
		  break;
		case 'B':
		  if(name.equalsIgnoreCase("BEFORE"))     return(newItem(KeyWord.BEFORE));
		  if(name.equalsIgnoreCase("BEGIN"))      return(newItem(KeyWord.BEGIN));
		  if(name.equalsIgnoreCase("BOOLEAN"))    return(newItem(KeyWord.BOOLEAN));
		  if(name.equalsIgnoreCase("BREAK"))	  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("BYTE"))	  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  break;
		case 'C':
		  if(name.equalsIgnoreCase("CASE"))		  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("CATCH"))	  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("CHAR"))  	  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("CHARACTER"))  return(newItem(KeyWord.CHARACTER));
		  if(name.equalsIgnoreCase("CLASS"))      return(newItem(KeyWord.CLASS));
//		  if(name.equalsIgnoreCase("COMMENT"))    { scanComment(); return(nextToken()); }
		  if(name.equalsIgnoreCase("COMMENT"))    { return(scanComment()); }
		  if(name.equalsIgnoreCase("CONST"))	  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("CONTINUE"))	  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  break;
		case 'D':
		  if(name.equalsIgnoreCase("DEFAULT"))	  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("DELAY"))      return(newItem(KeyWord.DELAY));
		  if(name.equalsIgnoreCase("DO")) 	      return(newItem(KeyWord.DO));
		  if(name.equalsIgnoreCase("DOUBLE"))	  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  break;
		case 'E':
		  if(name.equalsIgnoreCase("ELSE"))       return(newItem(KeyWord.ELSE));
		  if(name.equalsIgnoreCase("END"))   	  return(scanEndComment());
		  if(name.equalsIgnoreCase("ENUM"))		  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("EQ"))	      return(newItem(KeyWord.EQ));
		  if(name.equalsIgnoreCase("EQV"))	      return(newItem(KeyWord.EQV));
		  if(name.equalsIgnoreCase("EXTENDS"))	  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("EXTERNAL"))   return(newItem(KeyWord.EXTERNAL));
		  break;
		case 'F':
		  if(name.equalsIgnoreCase("false"))  	return(newItem(KeyWord.BOOLEANKONST,false));
		  if(name.equalsIgnoreCase("FINAL"))  	return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("FINALLY"))	return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("FLOAT"))	  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("FOR"))    	return(newItem(KeyWord.FOR));
		  break;
		case 'G':
		  if(name.equalsIgnoreCase("GE"))     return(newItem(KeyWord.GE));
		  if(name.equalsIgnoreCase("GO"))     return(newItem(KeyWord.GO));
		  if(name.equalsIgnoreCase("GOTO"))   return(newItem(KeyWord.GOTO));
		  if(name.equalsIgnoreCase("GT"))     return(newItem(KeyWord.GT));
		  break;
		case 'H':
		  if(name.equalsIgnoreCase("HIDDEN")) return(newItem(KeyWord.HIDDEN));
		  break;
		case 'I':
		  if(name.equalsIgnoreCase("IF"))	      return(newItem(KeyWord.IF));
		  if(name.equalsIgnoreCase("IMP"))   	  return(newItem(KeyWord.IMP));
		  if(name.equalsIgnoreCase("IMPLEMENTS")) return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("IMPORT"))	  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("IN"))   	  return(newItem(KeyWord.IN));
		  if(name.equalsIgnoreCase("INNER"))	  return(newItem(KeyWord.INNER));
		  if(name.equalsIgnoreCase("INSPECT")) 	  return(newItem(KeyWord.INSPECT));
		  if(name.equalsIgnoreCase("INSTANCEOF")) return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("INT"))		  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("INTEGER"))	  return(newItem(KeyWord.INTEGER));
		  if(name.equalsIgnoreCase("INTERFACE"))  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("IS"))         return(newItem(KeyWord.IS));
		  break;
		case 'L':
		  if(name.equalsIgnoreCase("LABEL")) return(newItem(KeyWord.LABEL));
		  if(name.equalsIgnoreCase("LE"))    return(newItem(KeyWord.LE));
		  if(name.equalsIgnoreCase("LONG"))  return(newItem(KeyWord.LONG));
		  if(name.equalsIgnoreCase("LT"))    return(newItem(KeyWord.LT));
		  break;
		case 'N':
		  if(name.equalsIgnoreCase("NAME"))   return(newItem(KeyWord.NAME));
		  if(name.equalsIgnoreCase("NATIVE")) return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("NE"))     return(newItem(KeyWord.NE));
		  if(name.equalsIgnoreCase("NEW"))    return(newItem(KeyWord.NEW));
		  if(name.equalsIgnoreCase("NONE"))   return(newItem(KeyWord.NONE));
		  if(name.equalsIgnoreCase("NOT"))    return(newItem(KeyWord.NOT));
		  if(name.equalsIgnoreCase("NOTEXT")) return(newItem(KeyWord.NOTEXT));
		  break;
		case 'O':
		  if(name.equalsIgnoreCase("OR"))         return(newItem(KeyWord.OR));
		  if(name.equalsIgnoreCase("OR_ELSE"))    return(newItem(KeyWord.OR_ELSE));
		  if(name.equalsIgnoreCase("OTHERWISE"))  return(newItem(KeyWord.OTHERWISE));
		  break;
		case 'P':
		  if(name.equalsIgnoreCase("PACKAGE"))	  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("PRIOR"))      return(newItem(KeyWord.PRIOR));
		  if(name.equalsIgnoreCase("PRIVATE"))	  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("PROCEDURE"))  return(newItem(KeyWord.PROCEDURE));
		  if(name.equalsIgnoreCase("PROTECTED"))  return(newItem(KeyWord.PROTECTED));
		  if(name.equalsIgnoreCase("PUBLIC"))	  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  break;
		case 'Q':
		  if(name.equalsIgnoreCase("QUA"))        return(newItem(KeyWord.QUA));
		  break;
		case 'R':
		  if(name.equalsIgnoreCase("REACTIVATE")) return(newItem(KeyWord.REACTIVATE));
		  if(name.equalsIgnoreCase("REAL"))       return(newItem(KeyWord.REAL));
		  if(name.equalsIgnoreCase("REF"))        return(newItem(KeyWord.REF));
		  if(name.equalsIgnoreCase("RETURN"))	  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  break;
		case 'S':
		  if(name.equalsIgnoreCase("SHORT"))  		return(newItem(KeyWord.SHORT));
		  if(name.equalsIgnoreCase("STATIC"))	    return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("STEP"))   		return(newItem(KeyWord.STEP));
		  if(name.equalsIgnoreCase("STRICTFP"))	    return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("SUPER"))	    return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("SWITCH")) 		return(newItem(KeyWord.SWITCH));
		  if(name.equalsIgnoreCase("SYNCHRONIZED"))	return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  break;
		case 'T':
		  if(name.equalsIgnoreCase("TEXT"))  	  return(newItem(KeyWord.TEXT));
		  if(name.equalsIgnoreCase("THEN"))  	  return(newItem(KeyWord.THEN));
		  if(name.equalsIgnoreCase("THIS"))   	  return(newItem(KeyWord.THIS));
		  if(name.equalsIgnoreCase("THROW"))	  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("THROWS"))	  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("TO"))         return(newItem(KeyWord.TO));
		  if(name.equalsIgnoreCase("TRANSIENT"))  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("true"))   	  return(newItem(KeyWord.BOOLEANKONST,true));
		  if(name.equalsIgnoreCase("TRY"))	  	  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  break;
		case 'U':
		  if(name.equalsIgnoreCase("UNTIL"))  return(newItem(KeyWord.UNTIL));
		  break;
		case 'V':
		  if(name.equalsIgnoreCase("VALUE"))   return(newItem(KeyWord.VALUE));
		  if(name.equalsIgnoreCase("VIRTUAL")) return(newItem(KeyWord.VIRTUAL));
		  if(name.equalsIgnoreCase("VOID"))	   return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  if(name.equalsIgnoreCase("VOLATILE"))	  return(newItem(KeyWord.IDENTIFIER,name+'$')); // Java KeyWord
		  break;
		case 'W':
		  if(name.equalsIgnoreCase("WHEN"))  return(newItem(KeyWord.WHEN));
		  if(name.equalsIgnoreCase("WHILE")) return(newItem(KeyWord.WHILE));
		  break;
	  }
//	  if(Option.TRACE_SCAN) Util.TRACE("Put identifier into NameTable: "+name);
	  return(newItem(KeyWord.IDENTIFIER,name));
	}
	
  //********************************************************************************
  //**	                                                                scanNumber 
  //********************************************************************************
  /**
  * Scan a unsigned number.
  * <pre>
  *  Reference-Syntax:
  *      unsigned-number
  *        = decimal-number  [  exponent-part  ]
  *        | exponent-part
  *      decimal-number
  *        = unsigned-integer  [  decimal-fraction  ]
  *        | decimal-fraction
  *      decimal-fraction
  *        = .  unsigned-integer
  *      exponent-part
  *        =  ( & | && )  [ + | - ]  unsigned-integer
  *      unsigned-integer
  *        =  digit  {  digit  |  _  }
  *        |  radix  R  radix-digit  {  radix-digit  |  _  radix-digit  }
  *      radix
  *        =  2  |  4  |  8  |  16
  *      radix-digit
  *        =  digit  |  A  |  B  |  C  |  D  |  E  |  F
  * </pre>
  * <b>End-Condition:</b>
  *  <ul>
  *  <li>current is last character of construct</li>
  *  <li>getNext will return first character after construct</li>
  * </ul>
  * @return A Item representing a constant number.
  */
  private Token scanNumber() 	  
  { int radix=10;
    char firstChar=(char)current;
	if(Option.TRACE_SCAN) Util.TRACE("scanNumber, "+edcurrent());
	Util.ASSERT(Character.isDigit((char)(current)),"scanNumber:Expecting a Digit");
	StringBuilder number=new StringBuilder();
	
	number.append((char)current);
    if(getNext() == 'R' && (firstChar == '2' | firstChar == '4' | firstChar == '8'))
    { radix=firstChar - '0';
  	  if(Option.TRACE_SCAN) Util.TRACE("scanNumber, radix="+radix);
  	  number.setLength(0);
    }
    else if(firstChar == '1' && current == '6')
    { number.append((char)current);
      if(getNext() == 'R')
      { radix=16;
  	    if(Option.TRACE_SCAN) Util.TRACE("scanNumber, radix="+radix);
    	number.setLength(0);
      } else pushBack(current);
    } else pushBack (current);
    
    while ((radix==16 ? isHexDigit(getNext()) : Character.isDigit(getNext())) || current=='_')
    if(current!='_') number.append((char)current);
    
    if(current == '.' && radix == 10)
    { getNext(); return(scanDotDigit(number)); }
    
    if(current == '&' && radix == 10)
    { getNext(); return(scanDigitsExp(number)); }
      
    String result=number.toString(); number=null;
	if(Option.TRACE_SCAN) Util.TRACE("scanNumber, result='"+result+"' radix="+radix);

    pushBack(current);
    return(newItem(KeyWord.INTEGERKONST,new Long(Long.parseLong(result,radix))));
  }


  //********************************************************************************
  //**	                                                              scanDotDigit 
  //********************************************************************************
  //** End-Condition: current is last character of construct                 CHECKED
  //**                getNext will return first character after construct
  //********************************************************************************
  private Token scanDotDigit(StringBuilder number)
  { /* Behandling av tall som starter med tegnet '.' */
    if(Option.TRACE_SCAN) Util.TRACE("scanDotDigit, "+edcurrent());
   	number.append('.');
    if(Character.isDigit(current)) number.append((char)current);
    while(Character.isDigit(getNext()) || current == '_')
        if(current != '_') number.append((char)current);

    if(current == '&') { getNext(); return(scanDigitsExp(number)); }
    
    String result=number.toString(); number=null;
  	if(Option.TRACE_SCAN) Util.TRACE("scanDotDigit, result='"+result);
    pushBack(current);
//    return(newItem(KeyWord.REALKONST,new Double(result)));
    return(newItem(KeyWord.REALKONST,new Float(result)));
  }
	
  //********************************************************************************
  //**	                                                             scanDigitsExp 
  //********************************************************************************
  //** End-Condition: current is last character of construct                 CHECKED
  //**                getNext will return first character after construct
  //********************************************************************************
  private Token scanDigitsExp(StringBuilder number)
  { String result;
    boolean doubleAmpersand=false;
	if(Option.TRACE_SCAN) Util.TRACE("scanDigitsExp, "+edcurrent());
	if(number==null) { number=new StringBuilder(); number.append('1'); }
	if(current == '&') { getNext(); doubleAmpersand=true; }
	number.append('e');
	if(current == '-') { number.append('-'); getNext(); }
	else if(current == '+') getNext();
	if(Character.isDigit(current)) number.append((char)current);
	while(Character.isDigit(getNext()) || current == '_') number.append((char)current);
	      
	result=number.toString(); number=null;
  	if(Option.TRACE_SCAN) Util.TRACE("scanDigitsExp, result='"+result);
	pushBack(current);
//	Util.BREAK("SimulaScanner.scanDigitsExp: doubleAmpersand="+doubleAmpersand);
	if(doubleAmpersand) return(newItem(KeyWord.REALKONST,new Double(result)));
	return(newItem(KeyWord.REALKONST,new Float(result)));
  }
	

  //********************************************************************************
  //**					                                                  scanName
  //********************************************************************************
  //**  Reference-Syntax:
  //**      identifier
  //**       = letter  { letter  |  digit  |  _  }
  //********************************************************************************
  // Scan identifier or reserved name.                                       CHECKED
  //** End-Condition: current is last character of construct
  //**                getNext will return first character after construct
  //********************************************************************************
  private String scanName()
  { StringBuilder name=new StringBuilder();
	if(Option.TRACE_SCAN) Util.TRACE("scanName, "+edcurrent());
	Util.ASSERT(Character.isLetter((char)(current)),"Expecting a Letter");
	name.append((char)current);
	while ((Character.isLetter(getNext()) || Character.isDigit(current) || current == '_'))
	{ name.append((char)current); }
	pushBack(current);
	if(Option.TRACE_SCAN) Util.TRACE("scanName, name="+name+",current="+edcurrent());
	return(name.toString());
  }
	

  //********************************************************************************
  //**	                                                     scanCharacterConstant
  //********************************************************************************
  //**  Reference-Syntax:                                                    CHECKED
  //**      character-constant
  //**       = '  character-designator  '
  //**      character-designator
  //**       = iso-code
  //**        |  non-quote-character
  //**        |  "
  //**      iso-code
  //**       =! digit  [ digit ]  [ digit ]  !
  //********************************************************************************
  //** End-Condition: current is last character of construct
  //**                getNext will return first character after construct
  //********************************************************************************
  private Token scanCharacterConstant()
  { char result=0;
    if(Option.TRACE_SCAN) Util.TRACE("scanCharacterConstant, "+edcurrent());
	Util.ASSERT((char)(current)=='\'',"Expecting a character quote '");
	if((isPrintable(getNext())) && current != '!')
    { result=(char)current; getNext(); }
    else if(current == '!')
    { result=(char)scanPossibleIsoCode(); getNext(); }
	else Util.error("Illegal character constant. "+edcurrent());
    if(current != '\'')
    { Util.error("Character constant is not terminated. "+edcurrent());
      pushBack(current);
    }
    if(Option.TRACE_SCAN) Util.TRACE("END scanCharacterConstant, result='"+result+"', "+edcurrent());
    return(newItem(KeyWord.CHARACTERKONST,new Character(result)));
  }  
  //********************************************************************************
  //**	                                                          scanTextConstant
  //********************************************************************************
  //**  Reference-Syntax:                                                    CHECKED
  //**      string
  //**       = simple-string  {  string-separator  simple-string  }
  //**      simple-string
  //**       = " { iso-code |  non-quote-character  |  ""  }  "
  //**      iso-code
  //**       =! digit  [ digit ]  [ digit ]  !
  //**      string-separator
  //**       = token-separator  {  token-separator  }
  //**      token-separator
  //**       = a direct comment
  //**        |  a space  { except in simple strings and character constants }
  //**        |  a format effector  { except as noted for spaces }
  //**        |  the separation of consecutive lines
  //********************************************************************************
  //** End-Condition: current is last character of construct
  //**                getNext will return first character after construct
  //********************************************************************************
  private Token scanTextConstant()
  { if(Option.TRACE_SCAN) Util.TRACE("scanTextConstant, "+edcurrent());
	StringBuilder text=new StringBuilder();
	int firstLine=Global.sourceLineNumber;
	int lastLine=firstLine;
	while(true)
    { // Scan simple-string:
      while(getNext() != '"')
      { if(current=='!') text.append((char)scanPossibleIsoCode());
        else if(current == EOF)
        { Util.error("Text constant is not terminated.");
	      String result=text.toString(); text=null;
  	      if(Option.TRACE_SCAN); Util.TRACE("scanTextConstant(1): Result=\""+result+"\", "+edcurrent());
	      return(newItem(KeyWord.TEXTKONST,result));
        }
        else text.append((char)current);
      }
      lastLine=Global.sourceLineNumber;
      if(getNext() == '"') {
    	  text.append('"');
          lastLine=Global.sourceLineNumber;
      }
      else
      { // Skip string-separator
    	while(currentIsItemSeparator()) getNext();
	    if(Option.TRACE_SCAN) Util.TRACE("scanTextConstant(2): "+edcurrent());
        if(current!='"')
        { pushBack(current);
		  String result=text.toString(); text=null;
	  	  if(Option.TRACE_SCAN); Util.TRACE("scanTextConstant: Result=\""+result+"\", "+edcurrent());
//		  if(firstLine<Global.sourceLineNumber) Util.warning("Text constant span mutiple source lines");
		  if(firstLine<lastLine) Util.warning("Text constant span mutiple source lines");
		  return(newItem(KeyWord.TEXTKONST,result));
	    }
      }
    }
  }
	
  //********************************************************************************
  //**	                                                   currentIsItemSeparator
  //********************************************************************************
  //**  Reference-Syntax:
  //**      string-separator
  //**       = token-separator  {  token-separator  }
  //**      token-separator
  //**       = a direct comment
  //**        |  a space  { except in simple strings and character constants }
  //**        |  a format effector  { except as noted for spaces }
  //**        |  the separation of consecutive lines
  //********************************************************************************
  //** End-Condition: current is last character of construct
  //**                getNext will return first character after construct
  //********************************************************************************
  private boolean currentIsItemSeparator()
  { if(Option.TRACE_SCAN) Util.TRACE("isStringSeparator: "+edcurrent());    	
  	if(current=='!')
  	{ scanComment();
	  if(Option.TRACE_SCAN) Util.TRACE("isStringSeparator(2): "+edcurrent()); 
	  current=' '; return(true);
  	}
  	else if(Character.isLetter((char)current))
  	{ String name=scanName();
	  if(Option.TRACE_SCAN) Util.TRACE("isStringSeparator(3): "+edcurrent());
  	  if(name.equalsIgnoreCase("COMMENT"))
  	  { scanComment();
	    if(Option.TRACE_SCAN) Util.TRACE("isStringSeparator(2): "+edcurrent()); 
	    current=' '; return(true);
  	  }
  	  else pushBack(name);
	  if(Option.TRACE_SCAN) Util.TRACE("isStringSeparator(4): "+edcurrent());
	  return(false);
  	}
	  
//	switch(current)
//    { case '\n':	/* NL (LF) */
//      //           checkFullLineComment();
//      case ' ':
//	  case '\b':	/* BS */
//	  case '\t':	/* HT */
//	  case 11:		/* VT */
//	  case '\f':	/* FF */
//	  case '\r':	/* CR */
//		       return(true);
//      default: return(false);
//    }
  	return(isWhiteSpace(current));
  }
  
  private boolean isWhiteSpace(int c)
  {	switch(c)
	{ case '\n':	/* NL (LF) */
//	           checkFullLineComment();
	  //case ' ':
	  case 32:
	  case '\b':	/* BS */
	  case '\t':	/* HT */
	  case 11:		/* VT */
	  case '\f':	/* FF */
	  case '\r':	/* CR */
		       return(true);
	  default: return(false);
	}  
  }
  
  

  //********************************************************************************
  //**	                                                       scanPossibleIsoCode
  //********************************************************************************
  //**  Reference-Syntax:
  //**      iso-code
  //**       =! digit  [ digit ]  [ digit ]  !
  //********************************************************************************
  //** End-Condition: current is last character of construct
  //**                getNext will return first character after construct
  //********************************************************************************
  private int scanPossibleIsoCode()	
  { char firstchar,secondchar,thirdchar;
	if(Option.TRACE_SCAN) Util.TRACE("scanPossibleIsoCode, "+edcurrent());
	Util.ASSERT((char)(current)=='!',"Expecting a character !");
	if(Character.isDigit (getNext()))
	{ firstchar=(char)current;
	  if(Character.isDigit (getNext()))
	  { secondchar=(char)current;
		if(Character.isDigit (getNext()))
		{ thirdchar=(char)current;
		  if(getNext() == '!')
		  { //  ! digit digit digit !  Found
			int value=(((firstchar - '0')*10+secondchar-'0')*10+thirdchar-'0');
			if(Option.TRACE_SCAN) Util.TRACE("scanPossibleIsoCode:Got three digits: "+(char)firstchar+(char)secondchar+(char)thirdchar+" value="+value);
			if(value<256) return(value);
			Util.warning("ISO-Code "+value+" is out of range (0:255)");
			pushBack(current); pushBack(thirdchar); pushBack(secondchar); pushBack(firstchar);
			return('!');
		  }
		  else
		  {	pushBack(current); pushBack(thirdchar); pushBack(secondchar); pushBack(firstchar);
			return('!');
		  }
		}
		else if(current == '!')
		{ //  ! digit digit !  Found
		  return((char)((firstchar-'0')*10+secondchar-'0'));
		}
		else
		{ pushBack(current); pushBack(secondchar); pushBack(firstchar);
		  return('!');
		}
	  }
	  else if(current == '!')
	  {	//  ! digit !  Found
		return((char)(firstchar - '0')); 
	  }
	  else { pushBack(current); pushBack(firstchar); return('!'); }
    }
    else { pushBack(current); return('!'); }
  }

  //********************************************************************************
  //**	                                                           scanDirectiveLine
  //********************************************************************************
  //**  Reference-Syntax:
  //**      directive
  //**       =  % { any character except end-of-line }
  //********************************************************************************
  //** End-Condition: current is last character of construct               UNCHECKED
  //**                getNext will return first character after construct
  //********************************************************************************
  public Token scanDirectiveLine()
  { StringBuilder s=new StringBuilder();
    int c;
	while((c=getNext())!='\n') s.append((char)c); //"First character of line";
	String directive=s.toString();
    //Util.BREAK("PreProcessor.scanDirectiveLine: directive=\""+directive+'"');
    pushBack('\n');
    if(!directive.startsWith(" ")) doTreatDirective(directive);
	return(newItem(KeyWord.COMMENT));
  }
  private void doTreatDirective(String directive)
  {
	//Util.BREAK("PreScanner.doTreatDirective: directive="+directive);
	StringTokenizer tokenizer=new StringTokenizer(directive," ,");//,true);
	if(tokenizer.hasMoreTokens()) {
		String id=tokenizer.nextToken();
		//Util.BREAK("PreScanner.doTreatDirective: id="+id);
		if(id.equalsIgnoreCase("OPTION")) setOption();
		else if(id.equalsIgnoreCase("STANDARDCLASS")) setStandardClass();
		else if(id.equalsIgnoreCase("KEEP_JAVA")) setKeepJava(tokenizer);			
		else Util.warning("Unknown Compiler Directive: "+directive);    
	}
  }
  
  /**
   * %OPTION  name  value
   * <p>
   * Will set compiler switch 'name' to the value 'value'.
   * The facility is intended for compiler maitenance,
   * and is not explained further.
   */
  private static void setOption()
  {
    Util.warning("NOT IMPLEMENTED: Compiler Directive: %OPTION");
  }
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
  { Util.warning("Compiler Directive: %STANDARDCLASS sets Option.standardClass=true");
    Option.standardClass=true;
  }

  /**
   * %KEEP_JAVA directory-string
   */
  private static void setKeepJava(StringTokenizer tokenizer)
  { if(tokenizer.hasMoreTokens()) Option.keepJava=tokenizer.nextToken();
    else Util.warning("Missing directory in KEEP_JAVA directive");	
    Util.BREAK("KEEP_JAVA: "+Option.keepJava);
  }
  
  //********************************************************************************
  //**	                                                               scanComment
  //********************************************************************************
  //**  Reference-Syntax:
  //**      comment
  //**       =  COMMENT  { any character except semicolon }  ;
  //********************************************************************************
  //** End-Condition: current is last character of construct                 CHECKED
  //**                getNext will return first character after construct
  //********************************************************************************
  private Token scanComment()
  { StringBuilder skipped=new StringBuilder();
	if(Option.TRACE_SCAN) Util.TRACE("BEGIN scanComment, "+edcurrent());
    while((getNext() != ';') && current != EOF) skipped.append((char)current); 
    skipped.append((char)current);
    if(current == ';') current=' '; // getNext();
    else { Util.error("Comments are not terminated with ';'."); pushBack(current); }
	if(Option.TRACE_SCAN) Util.TRACE("END scanComment: "+edcurrent()+"  skipped=\""+skipped+'"');
	if(Option.TRACE_COMMENTS) Util.TRACE("COMMENT:\""+skipped+"\" Skipped and replaced with a SPACE");
	return(newItem(KeyWord.COMMENT));
  }

	
  //********************************************************************************
  //**                                                              scanEndComment
  //********************************************************************************
  //**  reference-Syntax:
  //**      The sequence:
  //**         END  { any sequence of printable characters not
  //**                containing  END, ELSE, WHEN, OTHERWISE or  ;  }
  //**      is equivalent to:
  //**         END
  //********************************************************************************
  //** End-Condition: current is last character of construct
  //**                getNext will return first character after construct
  //********************************************************************************
  private Token scanEndComment()
  { StringBuilder skipped=new StringBuilder();
	if(Option.TRACE_SCAN) Util.TRACE("scanEndComment, "+edcurrent());
	int firstLine=Global.sourceLineNumber;
	int lastLine=firstLine;
    while(getNext()!=EOF)
    { //if(!isWhiteSpace(current)) skipped.append((char)current);
      if(current==';')
      { if(Option.TRACE_COMMENTS) Util.TRACE("ENDCOMMENT:\""+skipped+'"');
	    if(firstLine<lastLine && (skipped.length()>0)) Util.warning("END-Comment span mutiple source lines");
        pushBack(current); return(newItem(KeyWord.END));
      }
      else if(Character.isLetter(current))
      { String name=scanName();
		if(name.equalsIgnoreCase("END")
		|| name.equalsIgnoreCase("ELSE")
		|| name.equalsIgnoreCase("WHEN")
		|| name.equalsIgnoreCase("OTHERWISE"))
		{ pushBack(name);
		  if(Option.TRACE_COMMENTS) Util.TRACE("END-COMMENT:\""+skipped+'"');
		  if(firstLine<lastLine && (skipped.length()>0)) Util.warning("END-Comment span mutiple source lines");
		  return(newItem(KeyWord.END));
		}
		skipped.append(name); //lastLine=Global.sourceLineNumber;
      } else if(!isWhiteSpace(current))
      { skipped.append((char)current); lastLine=Global.sourceLineNumber; }
    }
    if(skipped.length()>0) Util.error("END-Comment is not terminated");
    if(Option.TRACE_COMMENTS) Util.TRACE("ENDCOMMENT:\""+skipped+'"');
    return(newItem(KeyWord.END));
  }

}
