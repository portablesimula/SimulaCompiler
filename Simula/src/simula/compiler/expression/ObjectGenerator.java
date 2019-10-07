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

import simula.compiler.declaration.ClassDeclaration;
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.Parameter;
import simula.compiler.expression.Expression;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
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
 * ActualParameterList
 *         =  "("  ActualParameter  {  ,  ActualParameter  }  ")"
 *
 *    ActualParameter
 *        =  expression
 *        |  array-identifier-1
 *        |  switch-identifier
 *        |  procedure-identifier-1
 * 
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public final class ObjectGenerator extends Expression {
	private final String classIdentifier;
	private Meaning meaning;
	private final Vector<Expression> params;
	private final Vector<Expression> checkedParams = new Vector<Expression>();

	public ObjectGenerator(final String classIdentifier,final Vector<Expression> params) {
		this.classIdentifier = classIdentifier;
		this.type = Type.Ref(classIdentifier);
		this.params = params;
		if (Option.TRACE_PARSE)
			Util.TRACE("NEW ObjectGenerator: " + toString());
	}

	public static Expression parse() {
		if (Option.TRACE_PARSE)
			Util.TRACE("Parse ObjectGenerator, current=" + Parser.currentToken);
		String classIdentifier = expectIdentifier();
		Vector<Expression> params = new Vector<Expression>();
		if (Parser.accept(KeyWord.BEGPAR)) {
			if (!Parser.accept(KeyWord.ENDPAR)) {
				do {
					params.add(parseExpression());
				} while (Parser.accept(KeyWord.COMMA));
				Parser.expect(KeyWord.ENDPAR);
			}
		}
		Expression expr = new ObjectGenerator(classIdentifier, params);
		return (expr);
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber = lineNumber;
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN ObjectGenerator(" + classIdentifier + ").doChecking - Current Scope Chain: " + Global.currentScope.edScopeChain());
		meaning = Global.currentScope.findMeaning(classIdentifier);
		if (meaning == null) {
			Util.error("Undefined variable: " + classIdentifier);
			meaning = new Meaning(null, null); // Error Recovery: No Meaning
		}
		if (!(meaning.declaredAs instanceof ClassDeclaration)) {
			Util.error("NEW " + classIdentifier + ": Not a Class");
			return;
		}
		ClassDeclaration cls = (ClassDeclaration) meaning.declaredAs;
		// Check parameters
		Iterator<Parameter> formalIterator = cls.parameterIterator();
		Iterator<Expression> actualIterator = params.iterator();
		while (actualIterator.hasNext()) {
			if (!formalIterator.hasNext())
				Util.error("Wrong number of parameters to " + cls);
			Declaration formalParameter = formalIterator.next();
			Type formalType = formalParameter.type;
			if (Option.TRACE_CHECKER)
				Util.TRACE("Formal Parameter: " + formalParameter + ", Formal Type=" + formalType);
			Expression actualParameter = actualIterator.next();
			actualParameter.doChecking();

			Type actualType = actualParameter.type;
			if (Option.TRACE_CHECKER)
				Util.TRACE("Actual Parameter: " + actualType + " " + actualParameter + ", Actual Type=" + actualType);
			Expression checkedParameter = TypeConversion.testAndCreate(formalType, actualParameter);
			checkedParameter.backLink = this;
			checkedParams.add(checkedParameter);

		}
		if (formalIterator.hasNext())
			Util.error("Missing parameter("+formalIterator.next()+") to " + cls);
		if (Option.TRACE_CHECKER)
			Util.TRACE("END ObjectGenerator(" + classIdentifier + ").doChecking: type=" + type);
		SET_SEMANTICS_CHECKED();
	}

	// Returns true if this expression may be used as a statement.
	public boolean maybeStatement() {
		ASSERT_SEMANTICS_CHECKED(this);
		return (true);
	}

	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
		StringBuilder s = new StringBuilder();
		String classIdent = meaning.declaredAs.getJavaIdentifier();
		s.append("new ").append(classIdent).append('(');
		s.append(meaning.edUnqualifiedStaticLink());

		ClassDeclaration cls = (ClassDeclaration) meaning.declaredAs;
		Iterator<Parameter> formalIterator = cls.parameterIterator();
		for (Expression par : checkedParams) {
			Parameter formalParameter = formalIterator.next();
			if (formalParameter.mode == Parameter.Mode.value) {
				if (par.type == Type.Text)
					s.append(",copy(").append(par.toJavaCode()).append(')');
				else if (formalParameter.kind == Parameter.Kind.Array)
					s.append(",(").append(par.toJavaCode()).append(").COPY()");
				else
					s.append(',').append(par.toJavaCode());
			} else
				s.append(',').append(par.toJavaCode());
		}

		s.append(')');
		// if(((ClassDeclaration)meaning.declaredAs).isDetachUsed())
		if (cls.isDetachUsed()) {
			s.append(".START$()");
			String start="(("+classIdent+')'+s.toString()+')';
			//Util.BREAK("ObjectGenerator.toJavaCode: START="+start);
			return(start);
		} else
			s.append(".STM$()");

		return (s.toString());
	}

	public String toString() {
		return (("NEW " + classIdentifier + checkedParams).replace('[', '(').replace(']', ')'));
	}

}
