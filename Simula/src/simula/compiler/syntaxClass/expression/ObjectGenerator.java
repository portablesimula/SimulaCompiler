/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.expression;

import java.util.Iterator;
import java.util.Vector;

import simula.compiler.parsing.Parse;
import simula.compiler.syntaxClass.Type;
import simula.compiler.syntaxClass.declaration.ClassDeclaration;
import simula.compiler.syntaxClass.declaration.Declaration;
import simula.compiler.syntaxClass.declaration.Parameter;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * ObjectGenerator i.e. new Object expression.
 * 
 * <pre>
 * 
 * Simula Standard: 3.8 Object expressions
 * 
 * object-generator = NEW class-identifier [ ( actual-parameter-part ) ]
 * 
 *    actual-parameter-part
 *         =  "("  actual-parameter  {  ,  actual-parameter  }  ")"
 *
 *       actual-parameter
 *           =  expression
 *           |  array-identifier-1
 *           |  switch-identifier
 *           |  procedure-identifier-1
 * 
 * </pre>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/expression/ObjectGenerator.java"><b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public final class ObjectGenerator extends Expression {
	
	/**
	 * The class-identifier
	 */
	private final String classIdentifier;
	
	/**
	 * The semantic meaning 
	 */
	private Meaning meaning;
	
	/**
	 * The actual parameters before checking
	 */
	private final Vector<Expression> params;
	
	/**
	 * The actual parameters after checking
	 */
	private final Vector<Expression> checkedParams = new Vector<Expression>();

	/**
	 * Create a new ObjectGenerator
	 * @param ident class-identifier
	 * @param params the actual parameters
	 */
	private ObjectGenerator(final String ident,final Vector<Expression> params) {
		this.classIdentifier = ident;
		this.type = Type.Ref(classIdentifier);
		this.params = params;
		if (Option.TRACE_PARSE) Util.TRACE("NEW ObjectGenerator: " + toString());
	}

	/**
	 * Parse an object generator
	 * <pre>
	 * object-generator = NEW class-identifier [ ( actual-parameter-part ) ]
	 * 
	 *    actual-parameter-part
	 *         =  "("  actual-parameter  {  ,  actual-parameter  }  ")"
	 * </pre>
	 * @return the newly created ObjectGenerator.
	 */
	static Expression expectNew() {
		if (Option.TRACE_PARSE)
			Util.TRACE("Parse ObjectGenerator, current=" + Parse.currentToken);
		String classIdentifier = Parse.expectIdentifier();
		Vector<Expression> params = new Vector<Expression>();
		if (Parse.accept(KeyWord.BEGPAR)) {
			do {
				Expression par=acceptExpression();
				if(par==null) Util.error("Missing class parameter");
				else params.add(par);
			} while (Parse.accept(KeyWord.COMMA));
			Parse.expect(KeyWord.ENDPAR);
		}

		Expression expr = new ObjectGenerator(classIdentifier, params);
		return (expr);
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber = lineNumber;
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN ObjectGenerator(" + classIdentifier + ").doChecking - Current Scope Chain: " + Global.getCurrentScope().edScopeChain());
		meaning = Global.getCurrentScope().findMeaning(classIdentifier);
		if (meaning == null) {
			Util.error("Undefined class identifier: " + classIdentifier);
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
	@Override
	public boolean maybeStatement() {
		ASSERT_SEMANTICS_CHECKED();
		return (true);
	}

	@Override
	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED();
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
				else if (formalParameter.kind == Parameter.Kind.Array) {
					String cast=par.type.toJavaArrayType();
					s.append(",((").append(cast).append(')').append(par.toJavaCode()).append(").COPY()");
				}
				else
					s.append(',').append(par.toJavaCode());
			} else
				s.append(',').append(par.toJavaCode());
		}

		s.append(')');
		if (cls.isDetachUsed()) {
			s.append("._START()");
			String start=s.toString();
			if(backLink!=null) start="(("+classIdent+')'+start+')';
			return(start);
		} else
			s.append("._STM()");
		return (s.toString());
	}

	@Override
	public String toString() {
		return (("NEW " + classIdentifier + params).replace('[', '(').replace(']', ')'));
	}

}
