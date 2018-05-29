/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import java.util.Iterator;
import java.util.Vector;

import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.declaration.Parameter;
import simula.compiler.expression.Expression;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.ParameterKind;
import simula.compiler.utilities.ParameterMode;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * ObjectGenerator i.e. new Object expression.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 * ObjectGenerator = NEW ClassIdentifier [ ( ActualParameterList ) ]
 * 
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public class ObjectGenerator extends Expression {
	private String classIdentifier;
	private Meaning meaning;
	private Vector<Expression> params;
	private Vector<Expression> checkedParams = new Vector<Expression>();

	public ObjectGenerator(String classIdentifier, Vector<Expression> params) {
		this.classIdentifier = classIdentifier;
		this.type=Type.Ref(classIdentifier);
		this.params = params;
		if (Option.TRACE_PARSE)	Util.TRACE("NEW ObjectGenerator: " + toString());
	}
	
//	public Type getType()
//	{ return(Type.Ref(classIdentifier)); }

	public static Expression parse() {
		if (Option.TRACE_PARSE)
			Util.TRACE("Parse ObjectGenerator, current=" + Parser.currentToken);
		String classIdentifier = expectIdentifier();
		Vector<Expression> params = new Vector<Expression>();
		if (Parser.accept(KeyWord.BEGPAR)) {
			if (!Parser.accept(KeyWord.ENDPAR)) {
				do { params.add(parseSimpleExpression());
				} while (Parser.accept(KeyWord.COMMA));
				Parser.expect(KeyWord.ENDPAR);
			}
		}
		Expression expr = new ObjectGenerator(classIdentifier, params);
		return(expr);
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Util.setLine(lineNumber);
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN ObjectGenerator(" + classIdentifier
					+ ").doChecking - Current Scope Chain: "
					+ Global.currentScope.edScopeChain());
		meaning = Global.currentScope.findMeaning(classIdentifier);
		if (meaning == null) Util.error("Undefined variable: " + classIdentifier);
		Declaration declaredAs=meaning.declaredAs;
		if (declaredAs instanceof BlockDeclaration) // Declared Procedure/Class ...
		{	BlockDeclaration cls = (BlockDeclaration)declaredAs;
			Util.ASSERT(this.type.equals(cls.type),"Umulig situasjon ?");
			// Check parameters
			Iterator<Parameter> formalIterator = cls.parameterIterator();
			Iterator<Expression> actualIterator = params.iterator();
			while (actualIterator.hasNext()) {
				if (!formalIterator.hasNext())
					Util.error("Wrong number of parameters to " + cls);
				Declaration formalParameter = formalIterator.next();
				Type formalType = formalParameter.type;
				if (Option.TRACE_CHECKER)
					Util.TRACE("Formal Parameter: " + formalParameter
							+ ", Formal Type=" + formalType);
				Expression actualParameter = actualIterator.next();
				actualParameter.doChecking();
				// Util.BREAK("ObjectGenerator.doChecking Parameter  "+formalParameter+" := "+actualParameter);

				Type actualType = actualParameter.type;
				if (Option.TRACE_CHECKER)
					Util.TRACE("Actual Parameter: " + actualType + " "
							+ actualParameter + ", Actual Type=" + actualType);
				Expression checkedParameter=TypeConversion.testAndCreate(formalType,actualParameter);
				checkedParameter.backLink=this;
				checkedParams.add(checkedParameter);

			}
			if (formalIterator.hasNext())
				Util.error("Wrong number of parameters to " + cls);
		} else if (declaredAs instanceof Parameter) // Parameter Procedure
		{	Parameter spec = (Parameter) declaredAs;
			Util.ASSERT(this.type.equals(spec.type),"Umulig situasjon ?");
			ParameterKind kind = spec.kind;
			if (kind != ParameterKind.Procedure)
				Util.error("ObjectGenerator("+classIdentifier+") is matched to a parameter "+kind);
			Util.warning("ObjectGenerator("+classIdentifier+") - Parameter Checking is postponed to Runtime");
		}
		if (Option.TRACE_CHECKER)
			Util.TRACE("END ObjectGenerator(" + classIdentifier
					+ ").doChecking: type=" + type);
		// Debug.BREAK("END ObjectGenerator");
		SET_SEMANTICS_CHECKED();
	}

	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
		StringBuilder s = new StringBuilder();
		String classIdent=meaning.declaredAs.getJavaIdentifier();
		s.append("new ").append(classIdent).append('(');
	    s.append(meaning.edStaticLink());

//		for (Expression par:checkedParams) {
//			s.append(',').append(par.toJavaCode());
//		}
	    BlockDeclaration cls = (BlockDeclaration)meaning.declaredAs;
	    Iterator<Parameter> formalIterator = cls.parameterIterator();
		for (Expression par:checkedParams) {
			Parameter formalParameter = formalIterator.next();
			if(formalParameter.mode==ParameterMode.value)
			{ if(par.type==Type.Text) s.append(",copy(").append(par.toJavaCode()).append(')');
			  else if(formalParameter.kind==ParameterKind.Array) s.append(",(").append(par.toJavaCode()).append(").COPY()");
			  else s.append(',').append(par.toJavaCode());
			}
			else s.append(',').append(par.toJavaCode());
		}
		
		s.append(')');
		if(((BlockDeclaration)meaning.declaredAs).isDetachUsed()) 
			 s.append(".START()");
		else s.append(".STM()");

		return (s.toString());
	}

	public String toString() {
		return (("NEW " + classIdentifier + checkedParams).replace('[', '(')
				.replace(']', ')'));
	}

}
