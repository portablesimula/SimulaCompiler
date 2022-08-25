/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.parsing;

import java.io.File;
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
    SourceFileReader sourceFileReader;      // The source file reader;
    private Stack<Character> puchBackStack=new Stack<Character>();
    public static boolean selector[]=new boolean[256];
    
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
	void insert(File file) {
		this.sourceFileReader.insert(file);
	}

    //********************************************************************************
    //*** Read %MACRO line
    //********************************************************************************
	public String readMacroLine() {
		StringBuilder line=new StringBuilder();
		char c=(char)readNextCharacter();
		while(c != '\n') {
			line.append(c);
			c=(char)readNextCharacter();
		}
		return(line.toString());
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
	@Override
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
    		Token.lineNumberBeforeScanBasic = Global.sourceLineNumber; // TESTING

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
    	return(identifierToken('_'+name));
    }
    private Token identifierToken(final String name) {
    	Token token=newToken(KeyWord.IDENTIFIER,name);
    	return(token);
    }

	private Token scanIdentifier() {
		String name=scanName();
	    if(Option.TRACE_SCAN) Util.TRACE("scanIdentifier: name=\""+name+"\"");
	    String ident=(Option.CASE_SENSITIVE)?name:name.toLowerCase();
	    switch(Character.toLowerCase(ident.charAt(0))) {
	        case 'a':
		        if(ident.equals("abstract"))	return(javaKeyword(name)); // Java KeyWord
		        if(ident.equals("activate"))    return(newToken(KeyWord.ACTIVATE));
		        if(ident.equals("after"))	    return(newToken(KeyWord.AFTER));
		        if(ident.equals("and"))			return(newToken(KeyWord.AND));
		        if(ident.equals("and_then"))	return(newToken(KeyWord.AND_THEN));
		        if(ident.equals("array"))	    return(newToken(KeyWord.ARRAY));
		        if(ident.equals("assert"))	    return(javaKeyword(name)); // Java KeyWord
		        if(ident.equals("at"))		    return(newToken(KeyWord.AT));
		        break;
	        case 'b':
	        	if(ident.equals("before"))     return(newToken(KeyWord.BEFORE));
	        	if(ident.equals("begin"))      return(newToken(KeyWord.BEGIN));
	        	if(ident.equals("boolean"))    return(newToken(KeyWord.BOOLEAN));
	        	if(ident.equals("break"))	    return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("byte"))	    return(javaKeyword(name)); // Java KeyWord
	        	break;
	        case 'c':
	        	if(ident.equals("case"))		return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("catch"))	    return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("char"))  	    return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("character"))	return(newToken(KeyWord.CHARACTER));
	        	if(ident.equals("class"))       return(newToken(KeyWord.CLASS));
	        	if(ident.equals("comment"))     return(scanComment());
	        	if(ident.equals("const"))	    return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("continue"))	return(javaKeyword(name)); // Java KeyWord
	        	break;
	        case 'd':
	        	if(ident.equals("default"))		return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("delay"))   	return(newToken(KeyWord.DELAY));
	        	if(ident.equals("do")) 	    	return(newToken(KeyWord.DO));
	        	if(ident.equals("double"))	    return(javaKeyword(name)); // Java KeyWord
	        	break;
	        case 'e':
	        	if(ident.equals("else"))       return(newToken(KeyWord.ELSE));
	        	if(ident.equals("end"))   	    return(scanEndComment());
	        	if(ident.equals("enum"))		return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("eq"))	        return(newToken(KeyWord.EQ));
	        	if(ident.equals("eqv"))	    return(newToken(KeyWord.EQV));
	        	if(ident.equals("extends"))	return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("external"))   return(newToken(KeyWord.EXTERNAL));
	        	break;
	        case 'f':
	        	if(ident.equals("false"))  	return(newToken(KeyWord.BOOLEANKONST,false));
	        	if(ident.equals("final"))  	return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("finally"))	return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("float"))	    return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("for"))    	return(newToken(KeyWord.FOR));
	        	break;
	        case 'g':
	        	if(ident.equals("ge"))     return(newToken(KeyWord.GE));
	        	if(ident.equals("go"))     return(newToken(KeyWord.GO));
	        	if(ident.equals("goto"))   return(newToken(KeyWord.GOTO));
	        	if(ident.equals("gt"))     return(newToken(KeyWord.GT));
	        	break;
	        case 'h':
	        	if(ident.equals("hidden")) return(newToken(KeyWord.HIDDEN));
	        	break;
	        case 'i':
	        	if(ident.equals("if"))	        return(newToken(KeyWord.IF));
	        	if(ident.equals("imp"))   	    return(newToken(KeyWord.IMP));
	        	if(ident.equals("implements")) return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("import"))	    return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("in"))   	    return(newToken(KeyWord.IN));
	        	if(ident.equals("inner"))	    return(newToken(KeyWord.INNER));
	        	if(ident.equals("inspect")) 	return(newToken(KeyWord.INSPECT));
	        	if(ident.equals("instanceOf")) return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("int"))		return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("integer"))	return(newToken(KeyWord.INTEGER));
	        	if(ident.equals("interface"))  return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("is"))         return(newToken(KeyWord.IS));
	        	break;
	        case 'l':
	        	if(ident.equals("label")) return(newToken(KeyWord.LABEL));
	        	if(ident.equals("le"))    return(newToken(KeyWord.LE));
	        	if(ident.equals("long"))  return(newToken(KeyWord.LONG));
	        	if(ident.equals("lt"))    return(newToken(KeyWord.LT));
	        	break;
	        case 'n':
	        	if(ident.equals("name"))   return(newToken(KeyWord.NAME));
	        	if(ident.equals("native")) return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("ne"))     return(newToken(KeyWord.NE));
	        	if(ident.equals("new"))    return(newToken(KeyWord.NEW));
	        	if(ident.equals("none"))   return(newToken(KeyWord.NONE));
	        	if(ident.equals("not"))    return(newToken(KeyWord.NOT));
	        	if(ident.equals("notext")) return(newToken(KeyWord.NOTEXT));
	        	if(ident.equals("null"))   return(javaKeyword(name)); // Java NullLiteral
	        	break;
	        case 'o':
	        	if(ident.equals("or"))         return(newToken(KeyWord.OR));
	        	if(ident.equals("or_else"))    return(newToken(KeyWord.OR_ELSE));
	        	if(ident.equals("otherwise"))  return(newToken(KeyWord.OTHERWISE));
	        	break;
	        case 'p':
	        	if(ident.equals("package"))	return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("prior"))      return(newToken(KeyWord.PRIOR));
	        	if(ident.equals("private"))	return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("procedure"))  return(newToken(KeyWord.PROCEDURE));
	        	if(ident.equals("protected"))  return(newToken(KeyWord.PROTECTED));
	        	if(ident.equals("public"))	    return(javaKeyword(name)); // Java KeyWord
	        	break;
	        case 'q':
	        	if(ident.equals("qua"))        return(newToken(KeyWord.QUA));
	        	break;
	        case 'r':
	        	if(ident.equals("reactivate")) return(newToken(KeyWord.REACTIVATE));
	        	if(ident.equals("real"))       return(newToken(KeyWord.REAL));
	        	if(ident.equals("ref"))        return(newToken(KeyWord.REF));
	        	if(ident.equals("return"))	    return(javaKeyword(name)); // Java KeyWord
	        	break;
	        case 's':
	        	if(ident.equals("short"))  		return(newToken(KeyWord.SHORT));
	        	if(ident.equals("static"))	        return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("step"))   		return(newToken(KeyWord.STEP));
	        	if(ident.equals("strictfp"))	    return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("super"))	        return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("switch")) 		return(newToken(KeyWord.SWITCH));
	        	if(ident.equals("synchronized"))	return(javaKeyword(name)); // Java KeyWord
	        	break;
	        case 't':
	        	if(ident.equals("text"))  	    return(newToken(KeyWord.TEXT));
	        	if(ident.equals("then"))  	    return(newToken(KeyWord.THEN));
	        	if(ident.equals("this"))   	return(newToken(KeyWord.THIS));
	        	if(ident.equals("throw"))	    return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("throws"))	    return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("to"))         return(newToken(KeyWord.TO));
	        	if(ident.equals("transient"))  return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("true"))   	return(newToken(KeyWord.BOOLEANKONST,true));
	        	if(ident.equals("try"))	  	return(javaKeyword(name)); // Java KeyWord
	        	break;
	        case 'u':
	        	if(ident.equals("until"))     return(newToken(KeyWord.UNTIL));
	        	break;
	        case 'v':
	        	if(ident.equals("value"))     return(newToken(KeyWord.VALUE));
	        	if(ident.equals("virtual"))   return(newToken(KeyWord.VIRTUAL));
	        	if(ident.equals("void"))	   return(javaKeyword(name)); // Java KeyWord
	        	if(ident.equals("volatile"))  return(javaKeyword(name)); // Java KeyWord
	        	break;
	        case 'w':
	        	if(ident.equals("when"))  return(newToken(KeyWord.WHEN));
	        	if(ident.equals("while")) return(newToken(KeyWord.WHILE));
	        	break;
	    }
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
    	long res = 0;
    	try {
    		res=Long.parseLong(result,radix);
    	} catch (NumberFormatException e) {
    		
    	}
    	return(newToken(KeyWord.INTEGERKONST,res));
    }


    //********************************************************************************
    //**	                                                              scanDotDigit 
    //********************************************************************************
    //** End-Condition: current is last character of construct                 
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
    //** End-Condition: current is last character of construct                 
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
    // Scan identifier or reserved name.                                       
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
    //**  Reference-Syntax:                                                    
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
    //**  Reference-Syntax:                                                    
    //**      string
    //**       = simple-string  {  string-separator  simple-string  }
    //**      simple-string
    //**       = " { iso-code |  non-quote-character  |  ""  }  "
    //**      iso-code
    //**       = ! digit  [ digit ]  [ digit ]  !
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
//    	int firstLine=Global.sourceLineNumber;
//    	int lastLine=firstLine;
    	LOOP:while(true) {
        	int firstLine=Global.sourceLineNumber;
        	int lastLine=firstLine;
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
    				if(firstLine<lastLine)
    					//Util.warning("Text constant span mutiple source lines");
    					Util.warning("Illegal Text constant. Simple string span mutiple source lines. See Simula Standard 1.6");
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
						Util.warning("ISO-Code " + value + " is out of range (0:255)"
							+" interpreted as an ordinary sequence of characters: !" +value + "!  See Simula Standard 1.6");
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
    //** End-Condition: current is last character of construct
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
	// ** End-Condition: current is last character of construct 
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
	// ** End-Condition: current is last character of construct 
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
				if (Util.equals(name, "end") || Util.equals(name, "else")
				|| Util.equals(name, "when") || Util.equals(name, "otherwise")) {
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
