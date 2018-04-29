/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import simula.compiler.SyntaxClass;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;


/**
 * Expression.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *  Expression = DesignationalExpression | ReferenceExpression | ValueExpression
 *  
 * 		DesignationalExpression = SimpleDesignationalExpression
 *                              | Ifclause SimpleDesignationalExpression ELSE DesignationalExpression
 *			SimpleDesignationalExpression = Label | SwitchDesignator | "(" DesignationalExpression ")"
 *				SwitchDesignator = SwitchIdentifier [ ArithmeticExpression ]
 *
 *		ReferenceExpression = ObjectExpression | TextExpression
 *			ObjectExpression = SimpleObjectExpression
 *                           | Ifclause SimpleObjectExpression ELSE ObjectExpression
 *				SimpleObjectExpression = NONE | Variable | FunctionDesignator | ObjectGenerator
 *                                     | LocalObject | QualifiedObject | ( ObjectExpression)
 * 			TextExpression = SimpleTextExpression
 *                         | Ifclause SimpleTextExpression ELSE TextExpression
 *
 * 		ValueExpression = ArithmeticExpression | BooleanExpression | CharacterExpression | TextValueExpression
 *			CharacterExpression = SimpleCharacterExpression
 *                              | Ifclause SimpleCharacterExpression ELSE CharacterExpression
 * 			TextValueExpression = SimpleTextValue
 *                              | Ifclause SimpleTextValue ELSE TextValueExpression
 * 
 * 				Ifclause = IF BooleanExpression THEN
 * 
 * 
 * 
 *  Expression = ConditionalExpression | SimpleExpression
 *  	ConditionalExpression = IF Expression THEN SimpleExpression ELSE Expression
 *  
 *  	SimpleExpression = ValuePrimary | SimpleExpression BinaryOperator SimpleExpression 
 *   
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public abstract class Expression extends SyntaxClass
{ public SyntaxClass backLink; // True: This Expression is part of <backLink>Expression/Statement

  public String toString() { return("NO EXPRESSION"); }
	
  public static Expression parseExpression()
  { //Parser.BREAK("Expression: ParseExpression");
    if(Parser.accept(KeyWord.IF))
    { Expression condition=parseExpression();
      Parser.expect(KeyWord.THEN); Expression thenExpression=parseSimpleExpression();
      Parser.expect(KeyWord.ELSE); Expression elseExpression=parseExpression();
      Expression expr=new ConditionalExpression(Type.Boolean,condition,thenExpression,elseExpression);
      if(Option.TRACE_PARSE) Util.TRACE("Expression: ParseExpression, result="+expr);
      return(expr);
    } else return(parseSimpleExpression());
  }  

  protected static Expression parseSimpleExpression()
  { //Parser.BREAK("Expression: parseSimpleExpression");   
//  return(parseBinaryOperation2(13));  // 13: assignment
    return(parseBinaryOperation(14));  // 14: assignment
  }

  private static Expression parseUnaryOperation()
  { // Parser.TRACE("Expression: parseUnaryOperation");
    Expression expr=new UnaryOperation(Parser.prevToken.getKeyWord(),parsePrimaryExpression());
    return(expr);
  }
  
  // Vet ikke hvorfor dette virker !
  private static Expression parseBinaryOperation(final int level)
  { //Parser.BREAK("Expression: parseBinaryOperation, level="+level);
	Expression expr=(level>0)?parseBinaryOperation(level-1):parsePrimaryExpression();
    //if(DEBUG) Util.BREAK("Expression: parseBinaryOperation(2), level="+level+", expr="+expr);
    while(Parser.acceptBinaryOperator(level))
    { KeyWord opr=Parser.prevToken.getKeyWord();
      if(level==0) expr=new BinaryOperation(expr,opr,parsePrimaryExpression());
      else if(opr==KeyWord.ASSIGNVALUE || opr==KeyWord.ASSIGNREF)
    	   expr=new BinaryOperation(expr,opr,parseExpression());
      else expr=new BinaryOperation(expr,opr,parseBinaryOperation(level-1));
    }
    return(expr);
  }
  
  
  private static Expression parseBooleanPrimary()
  { return(parseBooleanPrimary(7)); }
  // Vet ikke hvorfor dette virker ! 
  private static Expression parseBooleanPrimary(final int level)
  { //if(DEBUG) Parser.BREAK("Expression.parseBooleanPrimary: level="+level);
//	Expression expr=(level>0)?parseOperation(level-1):parseBooleanPrimary();
	Expression expr=(level>0)?parseBooleanPrimary(level-1):parsePrimaryExpression();
    //if(DEBUG) Util.BREAK("Expression.parseBooleanPrimary(2): level="+level+", expr="+expr);
    while(Parser.acceptOperatorLevel(level))
    { KeyWord opr=Parser.prevToken.getKeyWord();
      if(level==0) expr=new BinaryOperation(expr,opr,parsePrimaryExpression());
      else expr=new BinaryOperation(expr,opr,parseBooleanPrimary(level-1));
    }
    return(expr);
  }
  
  public static Expression parsePrimaryExpression()
  { // PrimaryExpression =  ( Expression ) | Constant | ObjectGenerator
    //                   | LocalObject | UnaryOperation | Variable | SubscriptedVariable
	//		Constant = IntegerConstant | RealConstant | CharacterConstant | TextConstant | BooleanConstant | SymbolicValue  
	//			BooleanConstant = TRUE | FALSE
	//      Boolean-secondary =  [ NOT ]  Boolean-primary  
	//			SymbolicValue = NONE | NOTEXT
	//		LocalObject = THIS ClassIdentifier
    if(Option.TRACE_PARSE) Parser.TRACE("Expression: parsePrimaryExpression");
    if (Parser.accept(KeyWord.BEGPAR)) { Expression expr=parseExpression(); Parser.expect(KeyWord.ENDPAR); return(expr); }
    else if(Parser.accept(KeyWord.INTEGERKONST)) return(new Constant(Type.Integer,Parser.prevToken.getValue()));
    else if(Parser.accept(KeyWord.REALKONST)) return(new Constant(Type.LongReal,Parser.prevToken.getValue()));
    else if(Parser.accept(KeyWord.BOOLEANKONST)) return(new Constant(Type.Boolean,Parser.prevToken.getValue()));
    else if(Parser.accept(KeyWord.CHARACTERKONST)) return(new Constant(Type.Character,Parser.prevToken.getValue()));
    else if(Parser.accept(KeyWord.TEXTKONST)) return(new Constant(Type.Text,Parser.prevToken.getValue()));
    else if(Parser.accept(KeyWord.NONE)) return(new Constant(Type.Ref,null));
    else if(Parser.accept(KeyWord.NOTEXT)) return(new Constant(Type.Text,null));
    else if(Parser.accept(KeyWord.NEW)) return(ObjectGenerator.parse()); // TODO 
    else if(Parser.accept(KeyWord.THIS)) return(LocalObject.acceptThisIdentifier()); // TODO 
    else if(Parser.accept(KeyWord.PLUS)) return(parseUnaryOperation());
	else if(Parser.accept(KeyWord.MINUS)) return(parseUnaryOperation());
	else if(Parser.accept(KeyWord.NOT))
	{ // Boolean-secondary =  [ NOT ]  Boolean-primary
	  Expression expr=parseBooleanPrimary();
	  expr=new UnaryOperation(KeyWord.NOT,expr);
	  return(expr);

	}
	else if(Parser.accept(KeyWord.IF))
    { Expression condition=parseExpression();
      Parser.expect(KeyWord.THEN); Expression thenExpression=parseSimpleExpression();
      Parser.expect(KeyWord.ELSE); Expression elseExpression=parseExpression();
      Expression expr=new ConditionalExpression(Type.Boolean,condition,thenExpression,elseExpression);
      if(Option.TRACE_PARSE) Util.TRACE("Expression: parsePrimaryExpression, result="+expr);
      return(expr);
    }
    else
    { String ident=acceptIdentifier();
      if(ident!=null) return(Variable.parse(ident));
      return(null);
    }
  }
  
  public boolean isRemoteVariable() { return(false); }  // Is redefined in BinaryOperation(DOT)
  public Variable getVariable() // { return(null); } // Is redefined in (Variable and) BinaryOperation(DOT)
  { if(this instanceof Variable) return((Variable)this);
	return(null);
  }
  
  // Generate code for getting the value of this Expression
  public String get()
  { return(this.toJavaCode()); }

  // Generate code for putting the value into this Expression
  public String put(String evaluated)
  { return(this.toJavaCode()+'='+evaluated); }

}
