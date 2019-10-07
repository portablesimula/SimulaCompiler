/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.parsing;

import java.io.Reader;
import java.util.LinkedList;
import java.util.Stack;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Token;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * A Simula Scanner
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class SimulaScanner extends DefaultScanner { 
    private static final int EOF_MARK=25; // ISO EM(EndMedia) character used to denote end-of-input
    public boolean EOF_SEEN=false;        // Set 'true' when EOF-character ( -1 ) was read.
    private SourceFileReader sourceFileReader;      // The source file reader;
    private Stack<Character> puchBackStack=new Stack<Character>();
    private boolean selector[]=new boolean[256];
    
    private StringBuilder accum;
    private final boolean editorMode;

    private LinkedList<Token> tokenQueue=new LinkedList<Token>();


	/**
	 * NOTE: An initial "-" in array upper bound may follow : directly (cf. 1.3).
	 * The scanner will treat ":-" within parentheses (round brackets) as two
	 * separate symbols ":" and "-" thus solving this ambiguity in the syntax.
	 * <p>
	 * This variable is used to cover such situations.
	 */
	private int pardepth = 0;

    //********************************************************************************
    //*** CONSTRUCTORS: SimulaScanner
    //********************************************************************************
	/**
	 * Constructs a new SimulaScanner that produces Items scanned from the specified
	 * source.
	 * 
	 * @param reader The character source to scan
	 * @param editorMode true: delivers tokens to the SimulaEditor
	 */
	public SimulaScanner(final Reader reader,final boolean editorMode) {
		this.sourceFileReader=new SourceFileReader(reader);
		this.editorMode=editorMode;
		Global.sourceLineNumber=1;
	}

    //********************************************************************************
    //*** Insert
    //********************************************************************************
	void insert(Reader reader) {
		this.sourceFileReader.insert(reader);
	}

    //********************************************************************************
    //*** Close
    //********************************************************************************
	void close() {
		SEARCH:while(!EOF_SEEN) {
			int c=readNextCharacter();
			if(!EOF_SEEN && !isWhiteSpace(c)) {
				Util.warning("Text after final END");
				break SEARCH;
			}
		}
		sourceFileReader.close();
		sourceFileReader=null;
	}

    //********************************************************************************
    //**	                                                                 nextToken 
    //********************************************************************************
	public Token nextToken() {
    	Token token;
		if(tokenQueue.size()>0) { 
		    token=tokenQueue.remove();
		} else token = scanToken();

		if (token != null) {
			if (token.getKeyWord() == KeyWord.AND) {
				Token maybeThen = scanToken();
				if (maybeThen.getKeyWord() == KeyWord.THEN) {
					Token andThen=newToken(KeyWord.AND_THEN);
					andThen.setText(token.getText()+maybeThen.getText());
					return(andThen);
				}
				tokenQueue.add(maybeThen);
			} else if (token.getKeyWord() == KeyWord.OR) {
				Token maybeElse = scanToken();
				if (maybeElse.getKeyWord() == KeyWord.ELSE) {
					Token orElse=newToken(KeyWord.OR_ELSE);
					orElse.setText(token.getText()+maybeElse.getText());
					return(orElse);
				}
				tokenQueue.add(maybeElse);
			}
		}
		if (Option.TRACE_SCAN) Util.TRACE("Item.nextToken, " + edcurrent());
		return (token);
	}
	
    //********************************************************************************
    //**	                                                                 scanToken 
    //********************************************************************************
    //** End-Condition: current is last character of construct
    //**                getNext will return first character after construct
    //********************************************************************************
    private Token scanToken() {
  	  Token token;
  	  if (editorMode) {
  			  token = scanBasic();    
  	  } else {
  		do token = scanBasic();
  		while (token!=null && ( token.getKeyWord() == KeyWord.COMMENT || token.getKeyWord() == KeyWord.STRING ));
  	  }
  	  return(token);
    }
    
    //********************************************************************************
    //**	                                                                 scanBasic 
    //********************************************************************************
    private Token scanBasic() {
    	if(Option.TRACE_SCAN) Util.TRACE("SimulaScanner.scanBasic, "+edcurrent());
    	while(true)	{
    		if(Character.isLetter(getNext())) return(scanIdentifier());
    		switch(current) {
    		    case '=':
		            if(getNext() == '=')   return(newToken(KeyWord.EQR));
		            if(current == '/')
		            if(getNext() == '=')   return(newToken(KeyWord.NER));
		            else Util.error("Illegal character combination ="+(char)current);
		            pushBack(current);     return(newToken(KeyWord.EQ));
	            case '>':
		            if(getNext() == '=')   return(newToken(KeyWord.GE));
		            pushBack(current);     return(newToken(KeyWord.GT));
	            case '<':
	                if(getNext() == '=')   return(newToken(KeyWord.LE));
		            if(current == '>')     return(newToken(KeyWord.NE));
		            pushBack(current);     return(newToken(KeyWord.LT));
	            case '+':                  return(newToken(KeyWord.PLUS));
	            case '-':
	            	if(getNext() == '-')   return(scanCommentToEndOfLine());
	                pushBack(current); 	   return(newToken(KeyWord.MINUS));
	            case '*':
		            if(getNext() == '*')   return(newToken(KeyWord.EXP));
		            pushBack(current); 	   return(newToken(KeyWord.MUL));
	            case '/':
		            if(getNext() == '/')   return(newToken(KeyWord.INTDIV));
		            pushBack(current); 	   return(newToken(KeyWord.DIV));
	            case '.':
		            if(Character.isDigit(getNext())) { return(scanDotDigit(new StringBuilder())); }
		            pushBack(current);     return(newToken(KeyWord.DOT));
	            case ',':	               return(newToken(KeyWord.COMMA));
	            case ':':
		            if(getNext() == '=')                return(newToken(KeyWord.ASSIGNVALUE));
		            if(current == '-' && pardepth == 0) return(newToken(KeyWord.ASSIGNREF));
		            pushBack(current);                  return(newToken(KeyWord.COLON));
	            case ';':	pardepth=0; return(newToken(KeyWord.SEMICOLON));
	            case '(':	pardepth++; return(newToken(KeyWord.BEGPAR));
	            case ')':	pardepth--; return(newToken(KeyWord.ENDPAR));
	            case '[':	return(newToken(KeyWord.BEGBRACKET));
	            case ']':	return(newToken(KeyWord.ENDBRACKET));
	            case '&':
				    if(getNext()=='&' || current=='-' || current=='+' || Character.isDigit(current)) 
					return (scanDigitsExp(null));
				
				    pushBack(current); return (newToken(KeyWord.CONC));
	            case '!':  return(scanComment());
	            case '\'': return(scanCharacterConstant());
	            case '\"': return(scanTextConstant());
	            case '0':case '1':case '2':case '3':case '4':
	            case '5':case '6':case '7':case '8':case '9':return(scanNumber());
	   
	            case EOF_MARK:
	            	if(Option.TRACE_SCAN) Util.BREAK("GOT END-OF-FILE");
	            	return(null);
	    	  
	            case '%': return(scanDirectiveLine());
	    	
	            case '\n':			/* NL (LF) */
	    	      if (editorMode) return(newToken(KeyWord.NEWLINE,Global.sourceLineNumber+1));
	            case ' ':
	            case '\b':			/* BS */
	            case '\t':			/* HT */
	           	//case '\v':		/* VT */
	            case '\f':			/* FF */
	            case '\r':			/* CR */
	            	break;
	            default: Util.error("Illegal character: "+(char)current+", Value="+(int)current);
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
    private Token javaKeyword(final String name) {
    	return(identifierToken(name+'$'));
    }
    private Token identifierToken(final String name) {
    	Token token=newToken(KeyWord.IDENTIFIER,name);
//    	if(Parser.prevToken.getKeyWord()==KeyWord.IDENTIFIER) Util.error("Misplaced identifier "+name+" directly after "+Parser.prevToken);
    	return(token);
    }
	private Token scanIdentifier() {
		String name=scanName();
	    if(Option.TRACE_SCAN) Util.TRACE("scanIdentifier: name=\""+name+"\"");
	    switch(name.toUpperCase().charAt(0)) {
	        case 'A':
		        if(name.equalsIgnoreCase("ABSTRACT"))	return(javaKeyword(name)); // Java KeyWord
		        if(name.equalsIgnoreCase("ACTIVATE"))   return(newToken(KeyWord.ACTIVATE));
		        if(name.equalsIgnoreCase("AFTER"))	    return(newToken(KeyWord.AFTER));
		        if(name.equalsIgnoreCase("AND"))		return(newToken(KeyWord.AND));
		        if(name.equalsIgnoreCase("AND_THEN"))	return(newToken(KeyWord.AND_THEN));
		        if(name.equalsIgnoreCase("ARRAY"))	    return(newToken(KeyWord.ARRAY));
		        if(name.equalsIgnoreCase("ASSERT"))	    return(javaKeyword(name)); // Java KeyWord
		        if(name.equalsIgnoreCase("AT"))		    return(newToken(KeyWord.AT));
		        break;
	        case 'B':
	        	if(name.equalsIgnoreCase("BEFORE"))     return(newToken(KeyWord.BEFORE));
	        	if(name.equalsIgnoreCase("BEGIN"))      return(newToken(KeyWord.BEGIN));
	        	if(name.equalsIgnoreCase("BOOLEAN"))    return(newToken(KeyWord.BOOLEAN));
	        	if(name.equalsIgnoreCase("BREAK"))	    return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("BYTE"))	    return(javaKeyword(name)); // Java KeyWord
	        	break;
	        case 'C':
	        	if(name.equalsIgnoreCase("CASE"))		return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("CATCH"))	    return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("CHAR"))  	    return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("CHARACTER"))  return(newToken(KeyWord.CHARACTER));
	        	if(name.equalsIgnoreCase("CLASS"))      return(newToken(KeyWord.CLASS));
	        	if(name.equalsIgnoreCase("COMMENT"))    return(scanComment());
	        	if(name.equalsIgnoreCase("CONST"))	    return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("CONTINUE"))	return(javaKeyword(name)); // Java KeyWord
	        	break;
	        case 'D':
	        	if(name.equalsIgnoreCase("DEFAULT"))	return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("DELAY"))      return(newToken(KeyWord.DELAY));
	        	if(name.equalsIgnoreCase("DO")) 	    return(newToken(KeyWord.DO));
	        	if(name.equalsIgnoreCase("DOUBLE"))	    return(javaKeyword(name)); // Java KeyWord
	        	break;
	        case 'E':
	        	if(name.equalsIgnoreCase("ELSE"))       return(newToken(KeyWord.ELSE));
	        	if(name.equalsIgnoreCase("END"))   	    return(scanEndComment());
	        	if(name.equalsIgnoreCase("ENUM"))		return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("EQ"))	        return(newToken(KeyWord.EQ));
	        	if(name.equalsIgnoreCase("EQV"))	    return(newToken(KeyWord.EQV));
	        	if(name.equalsIgnoreCase("EXTENDS"))	return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("EXTERNAL"))   return(newToken(KeyWord.EXTERNAL));
	        	break;
	        case 'F':
	        	if(name.equalsIgnoreCase("false"))  	return(newToken(KeyWord.BOOLEANKONST,false));
	        	if(name.equalsIgnoreCase("FINAL"))  	return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("FINALLY"))	return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("FLOAT"))	    return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("FOR"))    	return(newToken(KeyWord.FOR));
	        	break;
	        case 'G':
	        	if(name.equalsIgnoreCase("GE"))     return(newToken(KeyWord.GE));
	        	if(name.equalsIgnoreCase("GO"))     return(newToken(KeyWord.GO));
	        	if(name.equalsIgnoreCase("GOTO"))   return(newToken(KeyWord.GOTO));
	        	if(name.equalsIgnoreCase("GT"))     return(newToken(KeyWord.GT));
	        	break;
	        case 'H':
	        	if(name.equalsIgnoreCase("HIDDEN")) return(newToken(KeyWord.HIDDEN));
	        	break;
	        case 'I':
	        	if(name.equalsIgnoreCase("IF"))	        return(newToken(KeyWord.IF));
	        	if(name.equalsIgnoreCase("IMP"))   	    return(newToken(KeyWord.IMP));
	        	if(name.equalsIgnoreCase("IMPLEMENTS")) return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("IMPORT"))	    return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("IN"))   	    return(newToken(KeyWord.IN));
	        	if(name.equalsIgnoreCase("INNER"))	    return(newToken(KeyWord.INNER));
	        	if(name.equalsIgnoreCase("INSPECT")) 	return(newToken(KeyWord.INSPECT));
	        	if(name.equalsIgnoreCase("INSTANCEOF")) return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("INT"))		return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("INTEGER"))	return(newToken(KeyWord.INTEGER));
	        	if(name.equalsIgnoreCase("INTERFACE"))  return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("IS"))         return(newToken(KeyWord.IS));
	        	break;
	        case 'L':
	        	if(name.equalsIgnoreCase("LABEL")) return(newToken(KeyWord.LABEL));
	        	if(name.equalsIgnoreCase("LE"))    return(newToken(KeyWord.LE));
	        	if(name.equalsIgnoreCase("LONG"))  return(newToken(KeyWord.LONG));
	        	if(name.equalsIgnoreCase("LT"))    return(newToken(KeyWord.LT));
	        	break;
	        case 'N':
	        	if(name.equalsIgnoreCase("NAME"))   return(newToken(KeyWord.NAME));
	        	if(name.equalsIgnoreCase("NATIVE")) return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("NE"))     return(newToken(KeyWord.NE));
	        	if(name.equalsIgnoreCase("NEW"))    return(newToken(KeyWord.NEW));
	        	if(name.equalsIgnoreCase("NONE"))   return(newToken(KeyWord.NONE));
	        	if(name.equalsIgnoreCase("NOT"))    return(newToken(KeyWord.NOT));
	        	if(name.equalsIgnoreCase("NOTEXT")) return(newToken(KeyWord.NOTEXT));
	        	if(name.equalsIgnoreCase("NULL"))   return(javaKeyword(name)); // Java NullLiteral
	        	break;
	        case 'O':
	        	if(name.equalsIgnoreCase("OR"))         return(newToken(KeyWord.OR));
	        	if(name.equalsIgnoreCase("OR_ELSE"))    return(newToken(KeyWord.OR_ELSE));
	        	if(name.equalsIgnoreCase("OTHERWISE"))  return(newToken(KeyWord.OTHERWISE));
	        	break;
	        case 'P':
	        	if(name.equalsIgnoreCase("PACKAGE"))	return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("PRIOR"))      return(newToken(KeyWord.PRIOR));
	        	if(name.equalsIgnoreCase("PRIVATE"))	return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("PROCEDURE"))  return(newToken(KeyWord.PROCEDURE));
	        	if(name.equalsIgnoreCase("PROTECTED"))  return(newToken(KeyWord.PROTECTED));
	        	if(name.equalsIgnoreCase("PUBLIC"))	    return(javaKeyword(name)); // Java KeyWord
	        	break;
	        case 'Q':
	        	if(name.equalsIgnoreCase("QUA"))        return(newToken(KeyWord.QUA));
	        	break;
	        case 'R':
	        	if(name.equalsIgnoreCase("REACTIVATE")) return(newToken(KeyWord.REACTIVATE));
	        	if(name.equalsIgnoreCase("REAL"))       return(newToken(KeyWord.REAL));
	        	if(name.equalsIgnoreCase("REF"))        return(newToken(KeyWord.REF));
	        	if(name.equalsIgnoreCase("RETURN"))	    return(javaKeyword(name)); // Java KeyWord
	        	break;
	        case 'S':
	        	if(name.equalsIgnoreCase("SHORT"))  		return(newToken(KeyWord.SHORT));
	        	if(name.equalsIgnoreCase("STATIC"))	        return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("STEP"))   		return(newToken(KeyWord.STEP));
	        	if(name.equalsIgnoreCase("STRICTFP"))	    return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("SUPER"))	        return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("SWITCH")) 		return(newToken(KeyWord.SWITCH));
	        	if(name.equalsIgnoreCase("SYNCHRONIZED"))	return(javaKeyword(name)); // Java KeyWord
	        	break;
	        case 'T':
	        	if(name.equalsIgnoreCase("TEXT"))  	    return(newToken(KeyWord.TEXT));
	        	if(name.equalsIgnoreCase("THEN"))  	    return(newToken(KeyWord.THEN));
	        	if(name.equalsIgnoreCase("THIS"))   	return(newToken(KeyWord.THIS));
	        	if(name.equalsIgnoreCase("THROW"))	    return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("THROWS"))	    return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("TO"))         return(newToken(KeyWord.TO));
	        	if(name.equalsIgnoreCase("TRANSIENT"))  return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("true"))   	return(newToken(KeyWord.BOOLEANKONST,true));
	        	if(name.equalsIgnoreCase("TRY"))	  	return(javaKeyword(name)); // Java KeyWord
	        	break;
	        case 'U':
	        	if(name.equalsIgnoreCase("UNTIL"))     return(newToken(KeyWord.UNTIL));
	        	break;
	        case 'V':
	        	if(name.equalsIgnoreCase("VALUE"))     return(newToken(KeyWord.VALUE));
	        	if(name.equalsIgnoreCase("VIRTUAL"))   return(newToken(KeyWord.VIRTUAL));
	        	if(name.equalsIgnoreCase("VOID"))	   return(javaKeyword(name)); // Java KeyWord
	        	if(name.equalsIgnoreCase("VOLATILE"))  return(javaKeyword(name)); // Java KeyWord
	        	break;
	        case 'W':
	        	if(name.equalsIgnoreCase("WHEN"))  return(newToken(KeyWord.WHEN));
	        	if(name.equalsIgnoreCase("WHILE")) return(newToken(KeyWord.WHILE));
	        	break;
	    }
	    //return(newToken(KeyWord.IDENTIFIER,name));
	    return(identifierToken(name));
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
    private Token scanNumber() {
    	int radix=10;
    	char firstChar=(char)current;
    	if(Option.TRACE_SCAN) Util.TRACE("scanNumber, "+edcurrent());
    	Util.ASSERT(Character.isDigit((char)(current)),"scanNumber:Expecting a Digit");
    	StringBuilder number=new StringBuilder();
	
    	number.append((char)current);
    	if(getNext() == 'R' && (firstChar == '2' | firstChar == '4' | firstChar == '8')) {
    		radix=firstChar - '0';
    		if(Option.TRACE_SCAN) Util.TRACE("scanNumber, radix="+radix);
    		number.setLength(0);
    	} else if(firstChar == '1' && current == '6') { 
    		number.append((char)current);
    		if(getNext() == 'R') {
    			radix=16;
    			if(Option.TRACE_SCAN) Util.TRACE("scanNumber, radix="+radix);
    			number.setLength(0);
    		} else pushBack(current);
    	} else pushBack (current);
    
    	while ((radix==16 ? isHexDigit(getNext()) : Character.isDigit(getNext())) || current=='_')
    		if(current!='_') number.append((char)current);
    
    	if(current == '.' && radix == 10) { getNext(); return(scanDotDigit(number)); }
    
    	if(current == '&' && radix == 10) { getNext(); return(scanDigitsExp(number)); }
      
    	String result=number.toString(); number=null;
    	if(Option.TRACE_SCAN) Util.TRACE("scanNumber, result='"+result+"' radix="+radix);

    	pushBack(current);
    	return(newToken(KeyWord.INTEGERKONST,Long.parseLong(result,radix)));
    }


    //********************************************************************************
    //**	                                                              scanDotDigit 
    //********************************************************************************
    //** End-Condition: current is last character of construct                 CHECKED
    //**                getNext will return first character after construct
    //********************************************************************************
    private Token scanDotDigit(StringBuilder number) {
    	/* Behandling av tall som starter med tegnet '.' */
    	if(Option.TRACE_SCAN) Util.TRACE("scanDotDigit, "+edcurrent());
    	number.append('.');
    	if(Character.isDigit(current)) number.append((char)current);
    	while(Character.isDigit(getNext()) || current == '_')
    		if(current != '_') number.append((char)current);

    	if(current == '&') { getNext(); return(scanDigitsExp(number)); }
    
    	String result=number.toString(); number=null;
    	if(Option.TRACE_SCAN) Util.TRACE("scanDotDigit, result='"+result);
    	pushBack(current);
    	try {
    		return(newToken(KeyWord.REALKONST,Float.parseFloat(result)));
    	} catch(NumberFormatException e) {
    		Util.error("Illegal number: "+result);
    		return(newToken(KeyWord.REALKONST,null));
    	}
    }
	
    //********************************************************************************
    //**	                                                             scanDigitsExp 
    //********************************************************************************
    //** End-Condition: current is last character of construct                 CHECKED
    //**                getNext will return first character after construct
    //********************************************************************************
    private Token scanDigitsExp(StringBuilder number) {
    	String result;
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
    	try {
    		if(doubleAmpersand) return(newToken(KeyWord.REALKONST,Double.parseDouble(result)));
    		return(newToken(KeyWord.REALKONST,Float.parseFloat(result)));
    	} catch(NumberFormatException e) {
    		Util.error("Illegal number: "+result);
    		return(newToken(KeyWord.REALKONST,null));
    	}
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
    private String scanName() {
    	StringBuilder name=new StringBuilder();
    	if(Option.TRACE_SCAN) Util.TRACE("scanName, "+edcurrent());
    	Util.ASSERT(Character.isLetter((char)(current)),"Expecting a Letter");
    	name.append((char)current);
    	while ((Character.isLetter(getNext()) || Character.isDigit(current) || current == '_'))
    		name.append((char)current);
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
    private Token scanCharacterConstant() {
    	char result=0;
    	if(Option.TRACE_SCAN) Util.TRACE("scanCharacterConstant, "+edcurrent());
    	Util.ASSERT((char)(current)=='\'',"Expecting a character quote '");
    	if((isPrintable(getNext())) && current != '!') {
    		result=(char)current; getNext();
    	} else if(current == '!') {
    		result=(char)scanPossibleIsoCode(); getNext();
    	} else Util.error("Illegal character constant. "+edcurrent());
    	
    	if(current != '\'') {
    		Util.error("Character constant is not terminated. "+edcurrent());
    		pushBack(current);
    	}
    	if(Option.TRACE_SCAN) Util.TRACE("END scanCharacterConstant, result='"+result+"', "+edcurrent());
    	return(newToken(KeyWord.CHARACTERKONST,Character.valueOf(result)));
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
    private Token scanTextConstant() {
    	if(Option.TRACE_SCAN) Util.TRACE("scanTextConstant, "+edcurrent());
    	StringBuilder accumulatedTextConstant=new StringBuilder();
    	int firstLine=Global.sourceLineNumber;
    	int lastLine=firstLine;
    	LOOP:while(true) {
    		// Scan simple-string:
    		while(getNext() != '"') {
    			if(current=='!') accumulatedTextConstant.append((char)scanPossibleIsoCode());
    			else if(current == EOF_MARK) {
    				Util.error("Text constant is not terminated.");
    				String result=accumulatedTextConstant.toString(); accumulatedTextConstant=null;
    				if(Option.TRACE_SCAN) Util.TRACE("scanTextConstant(1): Result=\""+result+"\", "+edcurrent());
    				tokenQueue.add(newToken(KeyWord.TEXTKONST,result));
    				break LOOP;
    			} else accumulatedTextConstant.append((char)current);
    		}
    		if(editorMode) tokenQueue.add(newToken(KeyWord.STRING));
    		lastLine=Global.sourceLineNumber;
    		if(getNext() == '"') {
    			accumulatedTextConstant.append('"');
    			lastLine=Global.sourceLineNumber;
    		} else {
    			// Skip string-separator
    			while(currentIsStringSeparator()) getNext();
    			if(Option.TRACE_SCAN) Util.TRACE("scanTextConstant(2): "+edcurrent());
    			if(current!='"') {
    				pushBack(current);
    				String result=accumulatedTextConstant.toString(); accumulatedTextConstant=null;
    				if(Option.TRACE_SCAN) Util.TRACE("scanTextConstant(2): Result=\""+result+"\", "+edcurrent());
    				if(firstLine<lastLine) Util.warning("Text constant span mutiple source lines");
    				result=result.replace("\n","\\n");
    				tokenQueue.add(newToken(KeyWord.TEXTKONST,result));
    				break LOOP;
    			}
    		}
    	}
    	Token result=tokenQueue.remove();
    	return(result);
    }
	
    //********************************************************************************
  	//**	                                                  currentIsStringSeparator
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
    private boolean currentIsStringSeparator() {
    	if(current=='!') {
    		Token cc=scanComment();
    		if(editorMode) tokenQueue.add(cc);
    		current=' '; return(true);
    	} else if(Character.isLetter((char)current)) {
    		String name=scanName();
    		if(name.equalsIgnoreCase("COMMENT")) {
        		Token cc=scanComment();
        		if(editorMode) tokenQueue.add(cc);
    			current=' '; return(true);
    		} else pushBack(name);
    		return(false);
    	} else if(current=='%' && prevChar=='\n') {
			// Directive inside Text-Constant
    		Token cc=scanDirectiveLine();
    		if(editorMode) tokenQueue.add(cc);
			current=' '; return(true);
		}
    	return(isWhiteSpace(current));
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
	private int scanPossibleIsoCode() {
		char firstchar, secondchar, thirdchar;
		if (Option.TRACE_SCAN) Util.TRACE("scanPossibleIsoCode, " + edcurrent());
		Util.ASSERT((char) (current) == '!', "Expecting a character !");
		if (Character.isDigit(getNext())) {
			firstchar = (char) current;
			if (Character.isDigit(getNext())) {
				secondchar = (char) current;
				if (Character.isDigit(getNext())) {
					thirdchar = (char) current;
					if (getNext() == '!') { // ! digit digit digit ! Found
						int value = (((firstchar - '0') * 10 + secondchar - '0') * 10 + thirdchar - '0');
						if (Option.TRACE_SCAN) Util.TRACE("scanPossibleIsoCode:Got three digits: "+(char)firstchar+(char)secondchar+(char)thirdchar+"value="+value);
						if (value < 256)
							return (value);
						Util.warning("ISO-Code " + value + " is out of range (0:255)");
						pushBack(current);
						pushBack(thirdchar);
						pushBack(secondchar);
						pushBack(firstchar);
						return ('!');
					} else {
						pushBack(current);
						pushBack(thirdchar);
						pushBack(secondchar);
						pushBack(firstchar);
						return ('!');
					}
				} else if (current == '!') { // ! digit digit ! Found
					return ((char) ((firstchar - '0') * 10 + secondchar - '0'));
				} else {
					pushBack(current);
					pushBack(secondchar);
					pushBack(firstchar);
					return ('!');
				}
			} else if (current == '!') { // ! digit ! Found
				return ((char) (firstchar - '0'));
			} else {
				pushBack(current);
				pushBack(firstchar);
				return ('!');
			}
		} else {
			pushBack(current);
			return ('!');
		}
	}

    //********************************************************************************
    //**	                                                         scanDirectiveLine
    //********************************************************************************
    //**  Reference-Syntax:
    //**      directive
    //**       =  % { any character except end-of-line }
    //********************************************************************************
    //** End-Condition: current is last character of construct               UNCHECKED
    //**                getNext will return first character after construct
    //********************************************************************************
	private Token scanDirectiveLine() {
		getNext();
		if(current==' ') {
			readUntilEndofLine(); // Skip comment line
		    return (newToken(KeyWord.COMMENT));
		} else if(current=='+' || current=='-') {
			if(!lineSelected()) {
				//Util.println("SimulaScanner.scanDirectiveLine: NOT SELECTED char="+(char)current);
				readUntilEndofLine();
		    }
			//Util.println("SimulaScanner.scanDirectiveLine: RETURN char="+(char)current);
		    return (newToken(KeyWord.COMMENT));
		} else if(Character.isLetter(current)) {
			String id=scanName();
			if (id.equalsIgnoreCase("SELECT")) setSelectors();
			else Directive.treatDirectiveLine(this,id,readUntilEndofLine());
		}
	    return (newToken(KeyWord.COMMENT));
	}
	
	private String readUntilEndofLine() {
		StringBuilder line=new StringBuilder();
		while(getNext()!='\n') {
			line.append((char)current);
		}
		pushBack('\n');
		return(line.toString().trim());
	}

    /**
     * %SELECT select-character { select-character }
     * <p>
     * Set selectors for conditional compilation.
     */
    private void setSelectors() {
    	for(int i=0;i<255;i++) selector[i]=false;
    	getNext();
    	while(current==' ') getNext();
    	while(current!=' ' && current!='\n') {
    		selector[current]=true;
    		getNext();
    	}
    }
    
	private boolean lineSelected() {
		while (true) {
			if (current == '+') {
				getNext();
				while (Character.isLetter(current) | Character.isDigit(current)) {
					if (!selector[current])
						return (false); // then SKIPLINE;
					getNext();
				}
			} else if (current == '-') {
				getNext();
				while (Character.isLetter(current) | Character.isDigit(current)) {
					if (selector[current])
						return (false); // then SKIPLINE;
					getNext();
				}
			} else
				break;
		}
		while (current == ' ') getNext();
		pushBack(current);
		return (true); // Return to scan remainder part of line.
	}
  
	// ********************************************************************************
	// ** scanComment
	// ********************************************************************************
	// ** Reference-Syntax:
	// ** comment
	// ** = COMMENT { any character except semicolon } ;
	// ********************************************************************************
	// ** End-Condition: current is last character of construct CHECKED
	// ** getNext will return first character after construct
	// ********************************************************************************
	private Token scanComment() {
		StringBuilder skipped = new StringBuilder();
		if (Option.TRACE_SCAN) Util.TRACE("BEGIN scanComment, " + edcurrent());
		while ((getNext() != ';') && current != EOF_MARK)
			skipped.append((char) current);
		skipped.append((char) current);
		if (current == ';')
			current = ' '; // getNext();
		else {
			Util.error("Comment is not terminated with ';'.");
			pushBack(current);
		}
		if (Option.TRACE_SCAN) Util.TRACE("END scanComment: " + edcurrent() + "  skipped=\"" + skipped + '"');
		if (Option.TRACE_COMMENTS) Util.TRACE("COMMENT:\"" + skipped + "\" Skipped and replaced with a SPACE");
		return (newToken(KeyWord.COMMENT));
	}
	  
	// ********************************************************************************
	// ** scanCommentToEndOfLine
	// ********************************************************************************
	// ** Reference-Syntax:
	// ** comment
	// ** = -- { any character until end-of-line }
	// ********************************************************************************
	// ** End-Condition: current is last character of construct CHECKED
	// ** getNext will return first character after construct
	// ********************************************************************************
	private Token scanCommentToEndOfLine() {
		StringBuilder skipped = new StringBuilder();
		if (Option.TRACE_SCAN) Util.TRACE("BEGIN scanCommentToEndOfLine, " + edcurrent());
		while ((getNext() != '\n') && current != EOF_MARK)
			skipped.append((char) current);
		skipped.append((char) current);
		if (Option.TRACE_SCAN) Util.TRACE("END scanCommentToEndOfLine: " + edcurrent() + "  skipped=\"" + skipped + '"');
		if (Option.TRACE_COMMENTS) Util.TRACE("COMMENT:\"" + skipped + "\" Skipped and replaced with a SPACE");
		return (newToken(KeyWord.COMMENT));
	}
	
	// ********************************************************************************
	// ** scanEndComment
	// ********************************************************************************
	// ** reference-Syntax:
	// ** The sequence:
	// ** END { any sequence of printable characters not
	// ** containing END, ELSE, WHEN, OTHERWISE or ; }
	// ** is equivalent to:
	// ** END
	// ********************************************************************************
	// ** End-Condition: current is last character of construct
	// ** getNext will return first character after construct
	// ********************************************************************************
	private Token scanEndComment() {
		//Util.println("SimulaScanner.scanEndComment");
		tokenQueue.add(newToken(KeyWord.END));				   
		StringBuilder skipped = new StringBuilder();
		if (Option.TRACE_SCAN) Util.TRACE("scanEndComment, " + edcurrent());
		int firstLine = Global.sourceLineNumber;
		int lastLine = firstLine;
   LOOP:while (getNext() != EOF_MARK) {
			if(current=='%' && prevChar=='\n') {
				// Directive inside END-Comment
				Token cc=scanDirectiveLine();
				if(editorMode) tokenQueue.add(cc);				   
			}
			if (current == ';') {
				if (Option.TRACE_COMMENTS) Util.TRACE("ENDCOMMENT:\"" + skipped + '"');
				if (firstLine < lastLine && (skipped.length() > 0))
					Util.warning("END-Comment span mutiple source lines");
				if(editorMode && accum.length()>0) tokenQueue.add(newToken(KeyWord.COMMENT));
				tokenQueue.add(newToken(KeyWord.SEMICOLON)); break LOOP;  
			} else if (Character.isLetter(current)) {
				String name = scanName();
				if (name.equalsIgnoreCase("END") || name.equalsIgnoreCase("ELSE")
						|| name.equalsIgnoreCase("WHEN")
						|| name.equalsIgnoreCase("OTHERWISE")) {
					pushBack(name);
					if (Option.TRACE_COMMENTS) Util.TRACE("END-COMMENT:\"" + skipped + '"');
					if (firstLine < lastLine && (skipped.length() > 0))
						Util.warning("END-Comment span mutiple source lines");
					if(editorMode) tokenQueue.add(newToken(KeyWord.COMMENT)); break LOOP;		   
				}
				skipped.append(name); // lastLine=Global.sourceLineNumber;
			} else if (!isWhiteSpace(current)) {
				skipped.append((char) current);
				lastLine = Global.sourceLineNumber;
			}
		}
		
		if (skipped.length() > 0 && current==EOF_MARK) {
			//Util.warning("END-Comment is not terminated: Skipped="+skipped);
//			if(editorMode) tokenQueue.add(newToken(KeyWord.COMMENT));
		}
		if(editorMode && accum.length()>0) tokenQueue.add(newToken(KeyWord.COMMENT));
		if (Option.TRACE_COMMENTS)
			Util.TRACE("ENDCOMMENT:\"" + skipped + '"');
		Token res=tokenQueue.remove();
		return(res);
	}

	
    //********************************************************************************
    //**	                                                                 UTILITIES 
    //********************************************************************************
    private int prevChar;
    private int current;
    private int getNext() {
    	prevChar=current;
	    current=readNextCharacter();
	    if(editorMode) {
	        if(accum==null) accum=new StringBuilder();
	        if(current!='\r' && current!=EOF_MARK) {
	    	    accum.append((char)current);
	        }
	    }
	    return(current);
    }

    private int readNextCharacter() {
    	if(!puchBackStack.empty()) return(puchBackStack.pop());
		int c=sourceFileReader.read();

		if(c<0) { EOF_SEEN=true; return(EOF_MARK); }
		if(c=='\n') Global.sourceLineNumber++;
		
		if(c<32 && c!='\n') c=' '; // Whitespace
		return(c);
	}

    private void pushBack(final int chr) {
	    // push given value back into the input stream
    	if(editorMode) {
    		if(current!=EOF_MARK && accum.length()>0)
    		accum.deleteCharAt(accum.length()-1);
    	}
	    puchBackStack.push((char)chr);
	    current=' ';
    }
  
    private void pushBack(final String s) {
	    // put given value back into the input stream
	    int i=s.length();
		while((i--)>0) pushBack(s.charAt(i));
    }
  
	private Token newToken(final KeyWord keyWord, final Object value) {
		String text=null;
		if(editorMode) {
	        text=(accum==null)?"":accum.toString();
	        accum=new StringBuilder();
		}
		return(new Token(text,keyWord,value));
	  }

	private Token newToken(final KeyWord keyWord) {
		return (newToken(keyWord, null));
	}

	private String edcurrent() {
		if (current < 32)
			return ("Current code=" + current);
		return ("Current='" + (char) current + "' value=" + current);
	}
	
    private boolean isHexDigit(final int c) {
	    switch(c) {
	        case '0':case '1':case '2':case '3':case '4':
	        case '5':case '6':case '7':case '8':case '9':
	        case 'A':case 'B':case 'C':case 'D':case 'E':case 'F':
	        case 'a':case 'b':case 'c':case 'd':case 'e':case 'f': return(true);
	        default: return(false);
	    }
    }
	
	private boolean isPrintable(final int c) {
		if (c < 32) return (false);
		if (c > 126) return (false);
		return (true);
	}

	private boolean isWhiteSpace(final int c) {
		switch(c) {
		    case '\n':	/* NL (LF) */
		    case 32:    /* SPACE */
		    case '\b':	/* BS */
		    case '\t':	/* HT */
		    case 11:	/* VT */
		    case '\f':	/* FF */
		    case '\r':	/* CR */
			         return(true);
		    default: return(false);
		}  
	}

}
