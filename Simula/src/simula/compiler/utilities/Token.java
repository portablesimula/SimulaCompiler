/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.utilities;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Utility class Token.
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/utilities/Token.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class Token implements Externalizable {
	/**
	 * The Token's text attribute
	 */
	private String text;
	/**
	 * The Token's keyWord attribute
	 */
	private KeyWord keyWord;
	/**
	 * The Token's value attribute
	 */
	private Object value;
	/**
	 * The Token's line number
	 */
	public int lineNumber;

	/**
	 * The line number before scan basic.
	 */
	public static int lineNumberBeforeScanBasic;

	/**
	 * The style codes used by Simula Editor.
	 */
	public enum StyleCode {
		/** Regular */
		regular,
		/** Keyword */
		keyword,
		/** Comment */
		comment,
		/** Constant */
		constant
	};

	/**
	 * Create a new Token.
	 * 
	 * @param text    the Token's text attribute
	 * @param keyWord the Token's keyword attribute
	 * @param value   the Token's value attribute
	 */
	public Token(final String text, final KeyWord keyWord, final Object value) {
		this.text = text;
		this.keyWord = keyWord;
		this.value = value;
		this.lineNumber = lineNumberBeforeScanBasic;
	}

	/**
	 * Create a new Token.
	 * 
	 * @param text    the Token's text attribute
	 * @param keyWord the Token's keyword attribute
	 */
	public Token(final String text, final KeyWord keyWord) {
		this(text, keyWord, null);
	}

	/**
	 * Create a new Token.
	 * 
	 * @param keyWord the Token's keyword attribute
	 * @param value   the Token's value attribute
	 */
	public Token(final KeyWord keyWord, final Object value) {
		this(null, keyWord, value);
	}

	/**
	 * Create a new Token.
	 * 
	 * @param keyWord the Token's keyword attribute
	 */
	public Token(final KeyWord keyWord) {
		this(keyWord, null);
	}

	/**
	 * The default constructor used by Externalization.
	 */
	public Token() {
	} // Externalization

	/**
	 * Set this Token's text attribute.
	 * 
	 * @param text new text attribute
	 */
	public void setText(final String text) {
		this.text = text;
	}

	/**
	 * Get this Token's text attribute.
	 * 
	 * @return this Token's text attribute
	 */
	public String getText() {
		if (text == null)
			return (toString());
		return (text);
	}

	/**
	 * Returns the style code for this Token's keyword.
	 * 
	 * @return the style code for this Token's keyword
	 */
	public StyleCode getStyleCode() {
		switch(keyWord) {
		    case ASSIGNVALUE: case ASSIGNREF: case COMMA: case COLON: case SEMICOLON:
		    case BEGPAR: case ENDPAR: case BEGBRACKET: case ENDBRACKET: case EQR: case NER:
		    case EQ: case GE: case GT: case LE: case LT: case NE:
		    case PLUS: case MINUS: case MUL: case DIV: case INTDIV: case EXP:
		    case IDENTIFIER: case DOT:
		    	 return(Token.StyleCode.regular);
		    	 
		    case BOOLEANKONST: case INTEGERKONST: case CHARACTERKONST:
		    case REALKONST: case TEXTKONST: case STRING:
		    	 return(Token.StyleCode.constant);
		    	 
		    case COMMENT:
		    	 return(Token.StyleCode.comment);
		    	 
		    default: return(Token.StyleCode.keyword);
		}
	}

	/**
	 * Get this Token's keyword attribute.
	 * 
	 * @return this Token's keyword attribute
	 */
	public KeyWord getKeyWord() {
		return (keyWord);
	}

	/**
	 * Get this Token's keyword code.
	 * 
	 * @return this Token's keyword code
	 */
	public int getKeyWordCode() {
		return (keyWord.ordinal());
	}

	/**
	 * Get this Token's value attribute.
	 * 
	 * @return this Token's value attribute
	 */
	public Object getValue() {
		return (value);
	}

	/**
	 * Get this Token's value string.
	 * 
	 * @return this Token's value string
	 */
	public String getIdentifier() {
		return ((String) value);
	}

	public boolean equals(final Object other) {
		Token othr = (Token) other;
		if (!this.keyWord.equals(othr.keyWord))
			return (false);
		if (this.value == othr.value)
			return (true);
		if (this.value == null)
			return (false);
		if (othr.value == null)
			return (false);
		if (!this.value.equals(othr.value))
			return (false);
		return (true);
	}

	public String toString() {
		switch (keyWord) {
		case COMMA:			return (",");
		case COLON:			return (":");
		case SEMICOLON:		return (";");
		case BEGPAR:		return ("(");
		case ENDPAR:		return (")");
		case BEGBRACKET:	return ("[");
		case ENDBRACKET:	return ("]");
		case EXP:			return ("**");
		case DOT:			return (".");
		case CONC:			return ("&");

		case EQ:			return ("=");
		case GE:			return (">=");
		case GT:			return (">");
		case LE:			return ("<=");
		case LT:			return ("<");
		case NE:			return ("<>");
		case EQR:			return ("==");
		case NER:			return ("=/=");
		case IN:			return ("IN");
		case IS:			return ("IS");
		case PLUS:			return ("+");
		case MINUS:			return ("-");
		case MUL:			return ("*");
		case DIV:			return ("/");
		case INTDIV:		return ("//");
		case ASSIGNVALUE:	return (":=");
		case ASSIGNREF:		return (":-");

		case INTEGERKONST:	return ("INTEGERKONST(" + (Long) value + ")");
		case REALKONST:		return ("REALKONST(" + (Number) value + ")");
		case CHARACTERKONST:return ("CHARACTERKONST(" + (Character) value + ")");
		case TEXTKONST:		return ("TEXTKONST(" + (String) value + ")");
		case BOOLEANKONST:	return ("BOOLEANKONST(" + (Boolean) value + ")");
		case IDENTIFIER:	return ("" + value);

		case INTEGER: case REAL: {
			// Possible SHORT or LONG in value part
			String res = keyWord.toString();
			if (value != null)
				res = value.toString() + ' ' + res;
			return (res);
		}
		default:
			return (keyWord.toLowerCase());
		}
	}

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************

	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
//		if(AttributeOutput.USE_ATTRIBUTE_IO) Util.IERR("");
		oupt.writeObject(keyWord);
		oupt.writeObject(value);
	}

	@Override
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
//		if(AttributeOutput.USE_ATTRIBUTE_IO) Util.IERR("");
		keyWord = (KeyWord) inpt.readObject();
		value = inpt.readObject();
	}

}
