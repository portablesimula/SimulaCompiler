/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Vector;

import simula.compiler.JavaModule;
import simula.compiler.expression.Constant;
import simula.compiler.expression.Expression;
import simula.compiler.expression.TypeConversion;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

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
public class TypeDeclaration extends Declaration implements Externalizable {
	// String identifier;    // Inherited
	// String externalIdent; // Inherited
	// Type type;            // Inherited
	private boolean constant;
	public Expression constantElement;

	public TypeDeclaration(final Type type,final String identifier) {
		super(identifier);
		this.type=type;
		//Util.BREAK("TypeDeclaration: new "+type+" "+identifier);
	}

	public TypeDeclaration(final Type type,final String identifier,final boolean constant,final Constant constantElement) {
		this(type,identifier);
		this.constant=constant;
		this.constantElement=constantElement;
		//Util.BREAK("TypeDeclaration: new "+type+" "+identifier);
	}
	
	public boolean isConstant() { // Is used to prevent assignment of new value
		return(constant || constantElement!=null);	
	}
	   
	public static void parse(final Type type,final Vector<Declaration> declarationList) {
		// identifier-list = identifier { , identifier }
	    if(Option.TRACE_PARSE) Parser.TRACE("Parse IdentifierList");
	    if(Parser.accept(KeyWord.PROCEDURE)) declarationList.add(ProcedureDeclaration.doParseProcedureDeclaration(type));
	    else if(Parser.accept(KeyWord.ARRAY)) ArrayDeclaration.parse(type,declarationList);
	    else {
	    	do { 
	    	    String ident=expectIdentifier();
	            TypeDeclaration typeDeclaration=new TypeDeclaration(type,ident);
	            if(Parser.accept(KeyWord.EQ)) typeDeclaration.constantElement=Expression.parseExpression();
	            declarationList.add(typeDeclaration);
	        } while(Parser.accept(KeyWord.COMMA)); 
	    }
	} 

	public void doChecking() {
		//Util.BREAK("TypeDeclaration.doChecking("+this+")");
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		type.doChecking(Global.currentScope);
		if(constantElement!=null) {
			constantElement.doChecking();
	        constantElement=TypeConversion.testAndCreate(type,constantElement);
		    //Util.BREAK("TypeDeclaration.doChecking("+this+") - Constant'type="+constantElement.type+" --> "+type);
	        constantElement.type=type;
		}
		if(Global.currentScope instanceof ClassDeclaration) {
			ClassDeclaration cls=(ClassDeclaration)Global.currentScope;
			if(cls.prefixLevel()>0) externalIdent=identifier+'$'+cls.prefixLevel();
			else externalIdent=identifier;
		}
		SET_SEMANTICS_CHECKED();
	}

	public void doDeclarationCoding() {
		//Util.BREAK("TypeDeclaration.doDeclarationCoding: "+this);	        			
        if(constantElement!=null && !(constantElement instanceof Constant)) {
        	// Initiate Final Variable
//			Util.BREAK("TypeDeclaration.doDeclarationCoding: type="+type);	        			
//			Util.BREAK("TypeDeclaration.doDeclarationCoding: constantElement.type="+constantElement.type);	        			
			String value=constantElement.toJavaCode();
			JavaModule.code(getJavaIdentifier() + '=' + value + ';');
//			Util.BREAK("TypeDeclaration.doDeclarationCoding: CODE("+getJavaIdentifier() + '=' + value);	        			
		}
	}
	
	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
		//Util.BREAK("TypeDeclaration.toJavaCode: scope="+scope.getClass().getName());
		String modifier = "";
		if (Global.currentScope.blockKind==BlockKind.Class) modifier = "public ";
		if (this.isConstant()) modifier = modifier+"final ";
		if(constantElement!=null) {
			constantElement=TypeConversion.testAndCreate(type,constantElement.evaluate());
	        //Util.BREAK("TypeDeclaration.toJavaCode: constantElement="+constantElement);
	        constantElement.doChecking();
	        if(constantElement instanceof Constant) {
				String value=constantElement.toJavaCode();
				String putValue=TypeConversion.mayBeConvert(constantElement.type,type,value);
				return (modifier + type.toJavaType() + ' ' + getJavaIdentifier() + putValue);
	        } else {
				return (modifier + type.toJavaType() + ' ' + getJavaIdentifier() + ';');	        			
	        }
		}
		String value=type.edDefaultValue();
		return (modifier + type.toJavaType() + ' ' + getJavaIdentifier() + '=' + value + ';');
	}

	public String toString() {
		String s = ""+type + ' ' + identifier;
		if(constantElement!=null) s=s+" = "+constantElement.toString();
		return (s);
	}

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	public TypeDeclaration() { super(null); }

	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
		Util.TRACE_OUTPUT("Variable: "+type+' '+identifier+", constant="+isConstant()+", const="+constantElement);
//		Util.BREAK("TypeDeclaration.writeExternal: "+type+' '+identifier+", constant="+isConstant()+", const="+constantElement);
	    oupt.writeObject(identifier);
	    oupt.writeObject(externalIdent);
	    oupt.writeObject(type);
	    oupt.writeBoolean(isConstant());
		if(constantElement instanceof Constant)
		     oupt.writeObject(constantElement);
		else oupt.writeObject(null);
	}

	@Override
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
		identifier=(String)inpt.readObject();
		externalIdent=(String)inpt.readObject();
		type=Type.inType(inpt);
	    constant=inpt.readBoolean();
	    constantElement=(Constant)inpt.readObject();
	    Util.TRACE_INPUT("Variable: "+type+' '+identifier+", constant="+constant+", constantElement="+constantElement);
//		Util.BREAK("TypeDeclaration.readExternal: "+type+' '+identifier+", constant="+isConstant()+", const="+constantElement);
	}
}
