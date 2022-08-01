/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.utilities;

/**
 * 
 * @author Øystein Myhre Andersen
 *
 */
public enum KeyWord
{ // Simula Reserved Words
  ACTIVATE,AND,AFTER,ARRAY,AT,
  BEFORE,BEGIN,BOOLEAN,
  CHARACTER,CLASS,COMMENT,CONC,
  DELAY,DO,
  ELSE,END,EQ,EQV,EXTERNAL,
  FALSE,FOR,
  GE,GO,GOTO,GT,HIDDEN,
  IF,IMP,IN,INNER,INSPECT,INTEGER,IS,
  LABEL,LE,LONG,LT,
  NAME,NE,NEW,NONE,NOT,NOTEXT,
  OR,OTHERWISE,
  PRIOR,PROCEDURE,PROTECTED,
  QUA,
  REACTIVATE,REAL,REF,
  SHORT,STEP,SWITCH,
  TEXT,THEN,THIS,TO,TRUE,
  UNTIL,
  VALUE,VIRTUAL,
  WHEN,WHILE,

  // Other Symbols
  ASSIGNVALUE,ASSIGNREF,
  COMMA,COLON,SEMICOLON,
  BEGPAR,ENDPAR,BEGBRACKET,ENDBRACKET,
  EQR,NER,PLUS,MINUS,MUL,DIV,INTDIV,EXP,
  IDENTIFIER,BOOLEANKONST,INTEGERKONST,CHARACTERKONST,REALKONST,TEXTKONST,
  OR_ELSE,
  AND_THEN,
  DOT,NEWLINE,STRING;
  
  public String toJavaCode()
  { switch (this)
	{ case NONE: return("null");
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
