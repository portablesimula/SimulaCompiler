/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.utilities;

/**
 * The Simula Keywords and some additional symbols.
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/utilities/ConsolePanel.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public enum KeyWord {
	// Simula Reserved Words
	/** Simula Keyword */ACTIVATE, /** Simula Keyword */AND, /** Simula Keyword */AFTER, /** Simula Keyword */ARRAY,
	/** Simula Keyword */AT, /** Simula Keyword */BEFORE, /** Simula Keyword */BEGIN, /** Simula Keyword */BOOLEAN,
	/** Simula Keyword */CHARACTER, /** Simula Keyword */CLASS, /** Simula Keyword */COMMENT, /** Simula Keyword */CONC,
	/** Simula Keyword */DELAY, /** Simula Keyword */DO, /** Simula Keyword */ELSE, /** Simula Keyword */END, /** Simula Keyword */EQ,
	/** Simula Keyword */EQV, /** Simula Keyword */EXTERNAL, /** Simula Keyword */FALSE, /** Simula Keyword */FOR,
	/** Simula Keyword */GE, /** Simula Keyword */GO, /** Simula Keyword */GOTO, /** Simula Keyword */GT, /** Simula Keyword */HIDDEN,
	/** Simula Keyword */IF, /** Simula Keyword */IMP, /** Simula Keyword */IN, /** Simula Keyword */INNER, /** Simula Keyword */INSPECT,
	/** Simula Keyword */INTEGER, /** Simula Keyword */IS, /** Simula Keyword */LABEL, /** Simula Keyword */LE, /** Simula Keyword */LONG,
	/** Simula Keyword */LT, /** Simula Keyword */NAME, /** Simula Keyword */NE, /** Simula Keyword */NEW, /** Simula Keyword */NONE,
	/** Simula Keyword */NOT, /** Simula Keyword */NOTEXT, /** Simula Keyword */OR, /** Simula Keyword */OTHERWISE, /** Simula Keyword */PRIOR,
	/** Simula Keyword */PROCEDURE, /** Simula Keyword */PROTECTED, /** Simula Keyword */QUA, /** Simula Keyword */REACTIVATE,
	/** Simula Keyword */REAL, /** Simula Keyword */REF, /** Simula Keyword */SHORT, /** Simula Keyword */STEP, /** Simula Keyword */SWITCH,
	/** Simula Keyword */TEXT, /** Simula Keyword */THEN, /** Simula Keyword */THIS, /** Simula Keyword */TO, /** Simula Keyword */TRUE,
	/** Simula Keyword */UNTIL, /** Simula Keyword */VALUE, /** Simula Keyword */VIRTUAL, /** Simula Keyword */WHEN, /** Simula Keyword */WHILE,
	// Other Symbols
	/** Simula Symbol */ASSIGNVALUE, /** Simula Symbol */ASSIGNREF, /** Simula Symbol */COMMA, /** Simula Symbol */COLON, /** Simula Symbol */SEMICOLON, /** Simula Symbol */BEGPAR, /** Simula Symbol */ENDPAR, /** Simula Symbol */BEGBRACKET, /** Simula Symbol */ENDBRACKET, /** Simula Symbol */EQR, /** Simula Symbol */NER, /** Simula Symbol */PLUS, /** Simula Symbol */MINUS, /** Simula Symbol */MUL,
	/** Simula Symbol */DIV, /** Simula Symbol */INTDIV, /** Simula Symbol */EXP, /** Simula Symbol */IDENTIFIER, /** Simula Symbol */BOOLEANKONST, /** Simula Symbol */INTEGERKONST, /** Simula Symbol */CHARACTERKONST, /** Simula Symbol */REALKONST, /** Simula Symbol */TEXTKONST, /** Simula Symbol */OR_ELSE, /** Simula Symbol */AND_THEN,
	/** Simula Symbol */DOT, /** Simula Symbol */NEWLINE, /** Simula Symbol */STRING;

	/**
	 * Returns the lower case version.
	 * @return the lower case version
	 */
	public String toLowerCase() {
		return (this.toString().toLowerCase());
	}

	/**
	 * Returns the corresponding Java code.
	 * @return the corresponding Java code
	 */
	public String toJavaCode() {
		  switch (this) {
	  case NONE: return("null");
	  case NOTEXT: return("null");
	  case ASSIGNVALUE: return(":=");
	  case ASSIGNREF: return(":-");
      case EQ: return ("==");
      case GE: return (">=");
      case GT: return (">");
      case LE: return ("<=");
      case LT: return ("<");
      case NE: return ("!=");
      case EQR: return ("==");
      case NER: return ("!=");
      case IN: return (" instanceof ");
      case PLUS: return ("+");
      case MINUS: return ("-");
      case MUL: return ("*");
      case DIV: return ("/");
      case INTDIV: return ("/");  
	  case EXP: return ("^"); 
      case NOT: return ("!");
      case AND: return ("&");
	  case OR: return ("|");
	  case IMP: return (" imp "); //  x -> y   ==>   !x | y
	  case EQV: return (" == ");
	  case AND_THEN: return ("&&");
	  case OR_ELSE: return ("||");
	  case DOT: return (".");
	  default: return (toString());
	  }
  }

}
