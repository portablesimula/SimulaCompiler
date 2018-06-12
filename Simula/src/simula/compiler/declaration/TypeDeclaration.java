/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.util.Vector;

import simula.compiler.expression.Expression;
import simula.compiler.expression.TypeConversion;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;

/**
 * Simple Variable Declaration.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *  SimpleVariableDeclaration
 *        =  Type  TypeList
 *
 *    TypeList
 *        =  TypeListElement  { , TypeListElement }
 *
 *    TypeListElement
 *        =  Identifier
 *        |  ConstantElement 
 * 
 *    ConstantElement
 *        =  Identifier  "="  ValueExpression
 *        |  Identifier  "="  TextExpression
 * 
 *   	Type ::= BOOLEAN | CHARACTER | INTEGER | REAL | REF(ClassIdentifier) | TEXT
 *   
 * </pre>
 * 
 * @see Type
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public class TypeDeclaration extends Declaration {
	// Type type;
	Expression constantElement;

	public TypeDeclaration(Type type, String identifier) {
		super(identifier);
		this.type=type;
		//Util.BREAK("TypeDeclaration: new "+type+" "+identifier);
	}
	
	public boolean isConstant() // Is used to prevent assignment of new value
	{ return(constantElement!=null); }
	   
	public static void parse(Type type,Vector<Declaration> declarationList)
	  { // identifier-list = identifier { , identifier }
	    if(Option.TRACE_PARSE) Parser.TRACE("Parse IdentifierList");
	    if(Parser.accept(KeyWord.PROCEDURE)) declarationList.add(BlockDeclaration.doParseProcedureDeclaration(type));
	    else if(Parser.accept(KeyWord.ARRAY)) ArrayDeclaration.parse(type,declarationList);
	    else
	    { do
	      { String ident=expectIdentifier();
	        TypeDeclaration typeDeclaration=new TypeDeclaration(type,ident);
	        if(Parser.accept(KeyWord.EQ))
	        {
	          typeDeclaration.constantElement=Expression.parseExpression();
	          //typeDeclaration.constantElement=TypeConversion.testAndCreate(type,Expression.parseExpression());
	        }
	        
	        declarationList.add(typeDeclaration);
	      } while(Parser.accept(KeyWord.COMMA)); 
	    }
	  } 

	public void doChecking() {
		//Util.BREAK("TypeDeclaration.doChecking("+this+")");
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		type.doChecking(Global.currentScope);
		if(constantElement!=null)
		{ constantElement.doChecking();
	      constantElement=TypeConversion.testAndCreate(type,constantElement);
		}
		SET_SEMANTICS_CHECKED();
	}

	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
		//Util.BREAK("TypeDeclaration.toJavaCode: scope="+scope.getClass().getName());
		String modifier = "";
		if (Global.currentScope.blockKind==BlockDeclaration.Kind.Class) modifier = "public ";
		if (this.isConstant()) modifier = modifier+"final ";
		String value=(constantElement!=null)?constantElement.toJavaCode():type.edDefaultValue();
		return (modifier + type.toJavaType() + ' ' + getJavaIdentifier() + '=' + value + ';');
	}

	public String toString() {
		String s = ""+type + ' ' + identifier;
		if(constantElement!=null) s=s+" = "+constantElement.toString();
		return (s);
	}
}
