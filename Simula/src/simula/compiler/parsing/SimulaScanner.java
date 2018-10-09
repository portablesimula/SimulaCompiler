/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.parsing;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Token;
import simula.compiler.utilities.Util;

/**
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class SimulaScanner
{ 
  public static long prevLineNumber;
  
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
  Constructs a new SimulaScanner that produces Tokens scanned from the specified
  source.

  @param fileName The character source to scan
  */
  public SimulaScanner(String fileName) {
	  prevLineNumber=0;
	  new PreProcessor(fileName,false);
  }

  //********************************************************************************
  //**	                                                                 UTILITIES 
  //********************************************************************************
  private static int current;
  private static int getNext() { return(current=PreProcessor.getNext()); }
  private static void pushBack(int chr) { PreProcessor.pushBack(chr); current='�'; }
  private static void pushBack(String s) { PreProcessor.pushBack(s); }
  
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
  private static Token savedToken;
  public Token nextToken()
  { if(savedToken!=null)
	  { Token saved=savedToken;
	    savedToken=null;
	    return(saved);
	  }
    Token token=scanToken();
    if(token!=null)
    { if(token.getKeyWord()==KeyWord.AND)
      { Token maybeThen=scanToken();
        if(maybeThen.getKeyWord()==KeyWord.THEN)
            return(new Token(KeyWord.AND_THEN));
        savedToken=maybeThen;
      }
      else if(token.getKeyWord()==KeyWord.OR)
      { Token maybeElse=scanToken();
        if(maybeElse.getKeyWord()==KeyWord.ELSE)
            return(new Token(KeyWord.OR_ELSE));
        savedToken=maybeElse;
      }
    }
	if(Option.TRACE_SCAN) Util.TRACE("Token.nextToken, "+edcurrent());
	//Util.BREAK("Token.nextToken, "+token);
	return(token);
  }	
	
  //********************************************************************************
  //**	                                                                 scanToken 
  //********************************************************************************
  //** End-Condition: current is last character of construct
  //**                getNext will return first character after construct
  //********************************************************************************
  private Token scanToken()
  {	if(Option.TRACE_SCAN) Util.TRACE("SimulaScanner.scanToken, "+edcurrent());

	while(true)
	{ if(Character.isLetter(getNext())) return(scanIdentifier());
	  switch(current)
	  { case '=':
		  if(getNext() == '=')   return(new Token(KeyWord.EQR));
		  if(current == '/')
		  if(getNext() == '=')   return(new Token(KeyWord.NER));
		  else Util.error("Illegal character combination ="+(char)current);
		  pushBack(current);     return(new Token(KeyWord.EQ));
	    case '>':
		  if(getNext() == '=')   return(new Token(KeyWord.GE));
		  pushBack(current);     return(new Token(KeyWord.GT));
	    case '<':
	      if(getNext() == '=')   return(new Token(KeyWord.LE));
		  if(current == '>')     return(new Token(KeyWord.NE));
		  pushBack(current);     return(new Token(KeyWord.LT));
	    case '+':                return(new Token(KeyWord.PLUS));
	    case '-':	             return(new Token(KeyWord.MINUS));
	    case '*':
		  if(getNext() == '*')   return(new Token(KeyWord.EXP));
		  pushBack(current); 	 return(new Token(KeyWord.MUL));
	    case '/':
		  if(getNext() == '/')   return(new Token(KeyWord.INTDIV));
		  pushBack(current); 	 return(new Token(KeyWord.DIV));
	    case '.':
		  if(Character.isDigit(getNext())) { return(scanDotDigit(new StringBuilder())); }
		  pushBack(current); return(new Token(KeyWord.DOT));
	    case ',':	         return(new Token(KeyWord.COMMA));
	    case ':':
		  if(getNext() == '=')               return(new Token(KeyWord.ASSIGNVALUE));
		  if(current == '-' && pardepth == 0) return(new Token(KeyWord.ASSIGNREF));
		  pushBack(current);           return(new Token(KeyWord.COLON));
	    case ';':	pardepth=0; return(new Token(KeyWord.SEMICOLON));
	    case '(':	pardepth++; return(new Token(KeyWord.BEGPAR));
	    case ')':	pardepth--; return(new Token(KeyWord.ENDPAR));
	    case '[':	return(new Token(KeyWord.BEGBRACKET));
	    case ']':	return(new Token(KeyWord.ENDBRACKET));
	    case '&':
		  if(getNext()=='&'
		  || current=='-'
		  || current=='+'
		  || Character.isDigit(current)) { return(scanDigitsExp(null)); }
		    
		  pushBack(current); return(new Token(KeyWord.CONC));
	    case '!': scanComment(); break;
	    case '\'': return(scanCharacterConstant());
	    case '\"': return(scanTextConstant());
	    case '0':case '1':case '2':case '3':case '4':
	    case '5':case '6':case '7':case '8':case '9':return(scanNumber());
	   
	    case PreProcessor.EOF:
	      if(Option.TRACE_SCAN) Util.BREAK("GOT END-OF-FILE");
	      return(null);
	    	  
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
	    Util.BREAK("");
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
		  if(name.equalsIgnoreCase("ACTIVATE"))   return(new Token(KeyWord.ACTIVATE));
		  if(name.equalsIgnoreCase("AFTER"))	  return(new Token(KeyWord.AFTER));
		  if(name.equalsIgnoreCase("AND"))		  return(new Token(KeyWord.AND));
		  if(name.equalsIgnoreCase("AND_THEN"))	  return(new Token(KeyWord.AND_THEN));
		  if(name.equalsIgnoreCase("ARRAY"))	  return(new Token(KeyWord.ARRAY));
		  if(name.equalsIgnoreCase("AT"))		  return(new Token(KeyWord.AT));
		  break;
		case 'B':
		  if(name.equalsIgnoreCase("BEFORE"))     return(new Token(KeyWord.BEFORE));
		  if(name.equalsIgnoreCase("BEGIN"))      return(new Token(KeyWord.BEGIN));
		  if(name.equalsIgnoreCase("BOOLEAN"))    return(new Token(KeyWord.BOOLEAN));
		  break;
		case 'C':
		  if(name.equalsIgnoreCase("CHARACTER"))  return(new Token(KeyWord.CHARACTER));
		  if(name.equalsIgnoreCase("CLASS"))      return(new Token(KeyWord.CLASS));
		  if(name.equalsIgnoreCase("COMMENT"))    { scanComment(); return(nextToken()); }
		  break;
		case 'D':
		  if(name.equalsIgnoreCase("DELAY"))      return(new Token(KeyWord.DELAY));
		  if(name.equalsIgnoreCase("DO")) 	      return(new Token(KeyWord.DO));
		  break;
		case 'E':
		  if(name.equalsIgnoreCase("ELSE"))       return(new Token(KeyWord.ELSE));
		  if(name.equalsIgnoreCase("END"))   	  return(scanEndComment());
		  if(name.equalsIgnoreCase("EQ"))	      return(new Token(KeyWord.EQ));
		  if(name.equalsIgnoreCase("EQV"))	      return(new Token(KeyWord.EQV));
		  if(name.equalsIgnoreCase("EXTERNAL"))   return(new Token(KeyWord.EXTERNAL));
		  break;
		case 'F':
		  if(name.equalsIgnoreCase("false"))  return(new Token(KeyWord.BOOLEANKONST,false));
		  if(name.equalsIgnoreCase("FOR"))    return(new Token(KeyWord.FOR));
		  break;
		case 'G':
		  if(name.equalsIgnoreCase("GE"))     return(new Token(KeyWord.GE));
		  if(name.equalsIgnoreCase("GO"))     return(new Token(KeyWord.GO));
		  if(name.equalsIgnoreCase("GOTO"))   return(new Token(KeyWord.GOTO));
		  if(name.equalsIgnoreCase("GT"))     return(new Token(KeyWord.GT));
		  break;
		case 'H':
		  if(name.equalsIgnoreCase("HIDDEN")) return(new Token(KeyWord.HIDDEN));
		  break;
		case 'I':
		  if(name.equalsIgnoreCase("IF"))      return(new Token(KeyWord.IF));
		  if(name.equalsIgnoreCase("IMP"))     return(new Token(KeyWord.IMP));
		  if(name.equalsIgnoreCase("IN"))      return(new Token(KeyWord.IN));
		  if(name.equalsIgnoreCase("INNER"))   return(new Token(KeyWord.INNER));
		  if(name.equalsIgnoreCase("INSPECT")) return(new Token(KeyWord.INSPECT));
		  if(name.equalsIgnoreCase("INTEGER")) return(new Token(KeyWord.INTEGER));
		  if(name.equalsIgnoreCase("IS"))      return(new Token(KeyWord.IS));
		  break;
		case 'L':
		  if(name.equalsIgnoreCase("LABEL")) return(new Token(KeyWord.LABEL));
		  if(name.equalsIgnoreCase("LE"))    return(new Token(KeyWord.LE));
		  if(name.equalsIgnoreCase("LONG"))  return(new Token(KeyWord.LONG));
		  if(name.equalsIgnoreCase("LT"))    return(new Token(KeyWord.LT));
		  break;
		case 'N':
		  if(name.equalsIgnoreCase("NAME"))   return(new Token(KeyWord.NAME));
		  if(name.equalsIgnoreCase("NE"))     return(new Token(KeyWord.NE));
		  if(name.equalsIgnoreCase("NEW"))    return(new Token(KeyWord.NEW));
		  if(name.equalsIgnoreCase("NONE"))   return(new Token(KeyWord.NONE));
		  if(name.equalsIgnoreCase("NOT"))    return(new Token(KeyWord.NOT));
		  if(name.equalsIgnoreCase("NOTEXT")) return(new Token(KeyWord.NOTEXT));
		  break;
		case 'O':
		  if(name.equalsIgnoreCase("OR"))         return(new Token(KeyWord.OR));
		  if(name.equalsIgnoreCase("OR_ELSE"))    return(new Token(KeyWord.OR_ELSE));
		  if(name.equalsIgnoreCase("OTHERWISE"))  return(new Token(KeyWord.OTHERWISE));
		  break;
		case 'P':
		  if(name.equalsIgnoreCase("PRIOR"))      return(new Token(KeyWord.PRIOR));
		  if(name.equalsIgnoreCase("PROCEDURE"))  return(new Token(KeyWord.PROCEDURE));
		  if(name.equalsIgnoreCase("PROTECTED"))  return(new Token(KeyWord.PROTECTED));
		  break;
		case 'Q':
		  if(name.equalsIgnoreCase("QUA"))        return(new Token(KeyWord.QUA));
		  break;
		case 'R':
		  if(name.equalsIgnoreCase("REACTIVATE")) return(new Token(KeyWord.REACTIVATE));
		  if(name.equalsIgnoreCase("REAL"))       return(new Token(KeyWord.REAL));
		  if(name.equalsIgnoreCase("REF"))        return(new Token(KeyWord.REF));
		  break;
		case 'S':
		  if(name.equalsIgnoreCase("SHORT"))  return(new Token(KeyWord.SHORT));
		  if(name.equalsIgnoreCase("STEP"))   return(new Token(KeyWord.STEP));
		  if(name.equalsIgnoreCase("SWITCH")) return(new Token(KeyWord.SWITCH));
		  break;
		case 'T':
		  if(name.equalsIgnoreCase("TEXT"))   return(new Token(KeyWord.TEXT));
		  if(name.equalsIgnoreCase("THEN"))   return(new Token(KeyWord.THEN));
		  if(name.equalsIgnoreCase("THIS"))   return(new Token(KeyWord.THIS));
		  if(name.equalsIgnoreCase("TO"))     return(new Token(KeyWord.TO));
		  if(name.equalsIgnoreCase("true"))   return(new Token(KeyWord.BOOLEANKONST,true));
		  break;
		case 'U':
		  if(name.equalsIgnoreCase("UNTIL"))  return(new Token(KeyWord.UNTIL));
		  break;
		case 'V':
		  if(name.equalsIgnoreCase("VALUE"))   return(new Token(KeyWord.VALUE));
		  if(name.equalsIgnoreCase("VIRTUAL")) return(new Token(KeyWord.VIRTUAL));
		  break;
		case 'W':
		  if(name.equalsIgnoreCase("WHEN"))  return(new Token(KeyWord.WHEN));
		  if(name.equalsIgnoreCase("WHILE")) return(new Token(KeyWord.WHILE));
		  break;
	  }
//	  if(Option.TRACE_SCAN) Util.TRACE("Put identifier into NameTable: "+name);
	  return(new Token(KeyWord.IDENTIFIER,name));
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
  * @return A Token representing a constant number.
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
    return(new Token(KeyWord.INTEGERKONST,new Long(Long.parseLong(result,radix))));
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
//    return(new Token(KeyWord.REALKONST,new Double(result)));
    return(new Token(KeyWord.REALKONST,new Float(result)));
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
	if(doubleAmpersand) return(new Token(KeyWord.REALKONST,new Double(result)));
	return(new Token(KeyWord.REALKONST,new Float(result)));
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
    return(new Token(KeyWord.CHARACTERKONST,new Character(result)));
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
        else if(current == PreProcessor.EOF)
        { Util.error("Text constant is not terminated.");
	      String result=text.toString(); text=null;
  	      if(Option.TRACE_SCAN); Util.TRACE("scanTextConstant(1): Result=\""+result+"\", "+edcurrent());
	      return(new Token(KeyWord.TEXTKONST,result));
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
    	while(currentIsTokenSeparator()) getNext();
	    if(Option.TRACE_SCAN) Util.TRACE("scanTextConstant(2): "+edcurrent());
        if(current!='"')
        { pushBack(current);
		  String result=text.toString(); text=null;
	  	  if(Option.TRACE_SCAN); Util.TRACE("scanTextConstant: Result=\""+result+"\", "+edcurrent());
//		  if(firstLine<Global.sourceLineNumber) Util.warning("Text constant span mutiple source lines");
		  if(firstLine<lastLine) Util.warning("Text constant span mutiple source lines");
		  return(new Token(KeyWord.TEXTKONST,result));
	    }
      }
    }
  }
	
  //********************************************************************************
  //**	                                                   currentIsTokenSeparator
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
  private boolean currentIsTokenSeparator()
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
  //**	                                                               scanComment
  //********************************************************************************
  //**  Reference-Syntax:
  //**      comment
  //**       =  COMMENT  { any character except semicolon }  ;
  //********************************************************************************
  //** End-Condition: current is last character of construct                 CHECKED
  //**                getNext will return first character after construct
  //********************************************************************************
  private void scanComment()
  { StringBuilder skipped=new StringBuilder();
	if(Option.TRACE_SCAN) Util.TRACE("BEGIN scanComment, "+edcurrent());
    while((getNext() != ';') && current != PreProcessor.EOF) skipped.append((char)current); 
    skipped.append((char)current);
    if(current == ';') current=' '; // getNext();
    else { Util.error("Comments are not terminated with ';'."); pushBack(current); }
	if(Option.TRACE_SCAN) Util.TRACE("END scanComment: "+edcurrent()+"  skipped=\""+skipped+'"');
	if(Option.TRACE_COMMENTS) Util.TRACE("COMMENT:\""+skipped+"\" Skipped and replaced with a SPACE");
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
    while(getNext()!=PreProcessor.EOF)
    { //if(!isWhiteSpace(current)) skipped.append((char)current);
      if(current==';')
      { if(Option.TRACE_COMMENTS) Util.TRACE("ENDCOMMENT:\""+skipped+'"');
	    if(firstLine<lastLine && (skipped.length()>0)) Util.warning("END-Comment span mutiple source lines");
        pushBack(current); return(new Token(KeyWord.END));
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
		  return(new Token(KeyWord.END));
		}
		skipped.append(name); //lastLine=Global.sourceLineNumber;
      } else if(!isWhiteSpace(current))
      { skipped.append((char)current); lastLine=Global.sourceLineNumber; }
    }
    if(skipped.length()>0) Util.error("END-Comment is not terminated");
    if(Option.TRACE_COMMENTS) Util.TRACE("ENDCOMMENT:\""+skipped+'"');
    return(new Token(KeyWord.END));
  }

}
