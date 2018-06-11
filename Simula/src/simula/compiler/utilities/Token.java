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
public class Token
{ private KeyWord keyWord;
  private Object value;
  
  public Token(KeyWord keyWord,Object value)
  { this.keyWord=keyWord;
    this.value=value;
  }
  
  public Token(KeyWord keyWord)
  { this(keyWord,null); }

  public KeyWord getKeyWord() { return(keyWord); }
  public int getKeyWordCode() { return(keyWord.ordinal()); }
  public Object getValue() { return(value); }
  public String getIdentifier() { return((String)value); }
  
  public boolean equals(Object other)
  { Token othr=(Token)other;
	if(!this.keyWord.equals(othr.keyWord)) return(false);
	if(this.value==othr.value) return(true);
	if(this.value==null) return(false);
	if(othr.value==null) return(false);
    if(!this.value.equals(othr.value)) return(false);
	return(true);
  }

  public String toString()
  { switch (keyWord)
	{ case COMMA: return (","); 
	  case COLON: return (":"); 
	  case SEMICOLON: return (";"); 
	  case BEGPAR: return ("("); 
	  case ENDPAR: return (")"); 
	  case BEGBRACKET: return ("["); 
	  case ENDBRACKET: return ("]"); 
	  case EXP: return ("**"); 
	  case DOT: return ("."); 
	  case CONC: return ("&");
	  
	  case EQ: return ("=");
	  case GE: return (">=");
	  case GT: return (">");
	  case LE: return ("<=");
	  case LT: return ("<");
	  case NE: return ("<>");
	  case EQR: return ("==");
	  case NER: return ("=/=");
	  case IN: return ("IN");
	  case IS: return ("IS");
	  case PLUS: return ("+");
	  case MINUS: return ("-");
	  case MUL: return ("*");
	  case DIV: return ("/");
	  case INTDIV: return ("//");
	  case ASSIGNVALUE: return (":=");
	  case ASSIGNREF: return (":-");

	  case INTEGERKONST: return("INTEGERKONST("+(Long)value+")"); 
//	  case REALKONST: return("REALKONST("+(Double)value+")");
	  case REALKONST: return("REALKONST("+(Number)value+")");
	  case CHARACTERKONST: return("CHARACTERKONST("+(Character)value+")");
	  case TEXTKONST: return("TEXTKONST("+(String)value+")");
	  case BOOLEANKONST: return("BOOLEANKONST("+(Boolean)value+")");
	  case IDENTIFIER: return(""+value);

	  case INTEGER: case REAL:  // Possible SHORT  or  LONG  in value part
	       { String res=keyWord.toString(); if(value!=null) res=value.toString()+' '+res; return(res); } 
      default: return(keyWord.toString());
    }
  }

}
