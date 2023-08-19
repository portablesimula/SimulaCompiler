/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.statement;

import java.util.Iterator;
import java.util.Vector;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.parsing.Parse;
import simula.compiler.syntaxClass.Type;
import simula.compiler.syntaxClass.declaration.ClassDeclaration;
import simula.compiler.syntaxClass.declaration.Declaration;
import simula.compiler.syntaxClass.declaration.Parameter;
import simula.compiler.syntaxClass.expression.Expression;
import simula.compiler.syntaxClass.expression.TypeConversion;
import simula.compiler.syntaxClass.expression.VariableExpression;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Token;
import simula.compiler.utilities.Util;


/**
 * For Statement.
 * 
 * <pre>
 * 
 * Simula Standard: 4.4 For-statement
 * 
 *  for-statement = FOR variable :- reference-list DO statement
 *                | FOR variable := value-list DO statement
 *               
 *      reference-list = reference-list-element { , reference-list-element }
 * 
 *          reference-list-element = reference-expression [ WHILE Boolean-expression ]
 * 
 *      value-list = value-list-element { , value-list-element }
 * 
 *          value-list-element = value-expression [ WHILE Boolean-expression ]
 *                             | arithmetic-expression STEP arithmetic-expression UNTIL arithmetic-expression
 *
 * </pre>
 * The Implementation of the for-statement is a bit tricky. The basic idea is to create a
 * ForList iterator that iterates over a set of ForElt iterators. The following subclasses of
 * ForElt are defined:
 * <pre>
 *                - SingleElt&lt;T>    for basic types T control variable
 *                - SingleTValElt   for Text type control variable
 *                - StepUntil       for numeric types
 *                - WhileElt&lt;T>     for basic types T control variable
 *                - WhileTValElt    representing For t:= &lt;TextExpr> while &lt;Cond>
 *                                  With text value assignment
 * </pre>
 * Each of which deliver a boolean value 'CB' used to indicate whether this for-element is
 * exhausted. All parameters to these classes are transferred 'by name'. This is done to
 * ensure that all expressions are evaluated in the right order. The assignment to the
 * 'control variable' is done within the various for-elements when the 'next' method is
 * invoked. To get a full overview of all the details you are encouraged to study the
 * generated code together with the 'FRAMEWORK for for-list iteration' found in the
 * runtime class RTS_RTObject.
 * <p>
 * Example, the following for-statement:
 * <pre>
 *           for i:=1,6,13 step 6 until 66,i+1 while i &lt; 80 do j:=j+i;
 * </pre>
 * Is compiled to:
 * <pre>
 *           for(boolean CB:new ForList(
 *               new SingleElt&lt;Number>(...)
 *              ,new SingleElt&lt;Number>(...)
 *              ,new StepUntil(...)
 *              ,new WhileElt&lt;Number>(...)
 *           )) { if(!CB) continue;
 *                j=j+i;
 *              }
 *              </pre>
 * Another example with control variable of type Text:
 * <pre>
 *           for t:="one",other while k &lt; 7 do &lt;statement>
 * </pre>
 * Where 'other' is a text procedure, is compiled to:
 * <pre>
 *           for(boolean CB:new ForList(
 *               new SingleTValElt(...)
 *              ,new WhileTValElt(...)
 *            )) { if(!CB) continue;
 *                 … // Statement
 *               }
 * </pre>
 * 
 * <h2>Optimized For-Statement</h2>
 * However; most of the for-statements with only one for-list element are optimized.
 * <p>
 * Single for step-until statements are optimized when the step-expression is constant.
 * I.e. the following for-statements:
 * <pre>
 *           for i:=&lt;expr-1> step 1  until &lt;expr-2> do &lt;statements>
 *           for i:=&lt;expr-1> step -1 until &lt;expr-2> do &lt;statements>
 *           for i:=&lt;expr-1> step 6  until &lt;expr-2> do &lt;statements>
 *           for i:=&lt;expr-1> step -6 until &lt;expr-2> do &lt;statements>
 * </pre>
 * are compiled to:
 * <pre>
 *           for(i = &lt;expr-1>; i &lt;= &lt;expr-2>; i++) { &lt;statements> }
 *           for(i = &lt;expr-1>; i >= &lt;expr-2>; i--) { &lt;statements> }
 *           for(i = &lt;expr-1>; i &lt;= &lt;expr-2>; i=i+6) { &lt;statements> }
 *           for(i = &lt;expr-1>; i >= &lt;expr-2>; i=i-6) { &lt;statements> }
 * </pre>
 * The other kinds of single elements are optimized in these ways:
 * <pre>
 *           for i:=&lt;expr> do &lt;statements>
 *           for i:=&lt;expr> while &lt;cond> do &lt;statements>
 * </pre>
 * are compiled to:
 * <pre>
 *           i = &lt;expr>; { &lt;statements> }
 *           
 *           i = &lt;expr>;
 *           While( &lt;cond> ) {
 *                  &lt;statements>;
 *                  i = &lt;expr>;
 *           }
 * </pre>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/statement/ForStatement.java">
 * <b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public final class ForStatement extends Statement {
	
	/**
	 * The control variable
	 */
	private final VariableExpression controlVariable;
	
	/**
	 * Assignment operator  := or :-
	 */
	private final Token assignmentOperator; // := or :-
	
	/**
	 * The list of ForList elements.
	 */
	private final Vector<ForListElement> forList = new Vector<ForListElement>();
	
	/**
	 * The statement after DO.
	 */
	private final Statement doStatement;

	/**
	 * Create a new ForStatement.
	 * 
	 * @param line the source line number
	 */
	ForStatement(final int line) {
		super(line);
		if (Option.TRACE_PARSE)
			Parse.TRACE("Parse ForStatement");
		controlVariable = new VariableExpression(Parse.expectIdentifier());
		if (!Parse.accept(KeyWord.ASSIGNVALUE))
			Parse.expect(KeyWord.ASSIGNREF);
		assignmentOperator = Parse.prevToken;
		do {
			forList.add(expectForListElement());
		} while (Parse.accept(KeyWord.COMMA));
		Parse.expect(KeyWord.DO);
		Statement doStatement = Statement.expectStatement();
		if (doStatement == null) {
			Util.error("No statement following DO in For statement");
			doStatement = new DummyStatement(line);
		}
		this.doStatement = doStatement;
		if (Option.TRACE_PARSE)
			Util.TRACE("Line " + this.lineNumber + ": ForStatement: " + this);
	}

	/**
	 * Parse a for-list element.
	 * @return the resulting ForListElement
	 */
	private ForListElement expectForListElement() {
		if (Option.TRACE_PARSE)
			Parse.TRACE("Parse ForListElement");
		Expression expr1 = Expression.expectExpression();
		if (Parse.accept(KeyWord.WHILE))
			return (new WhileElement(expr1, Expression.expectExpression()));
		if (Parse.accept(KeyWord.STEP)) {
			Expression expr2 = Expression.expectExpression();
			Parse.expect(KeyWord.UNTIL);
			return (new StepUntilElement(expr1, expr2, Expression.expectExpression()));
		} else
			return (new ForListElement(expr1));
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())
			return;
		Global.sourceLineNumber = lineNumber;
		controlVariable.doChecking();
		Type type = controlVariable.type; // Type of control variable
		Declaration decl = controlVariable.meaning.declaredAs;
		if (decl instanceof Parameter par && par.mode == Parameter.Mode.name)
			Util.error(
					"For-Statement's Controled Variable(" + controlVariable + ") can't be a formal parameter by Name");
		if (type != Type.Text && assignmentOperator.getKeyWord() == KeyWord.ASSIGNVALUE && type.isReferenceType())
			Util.error("Illegal For-Statement with object value assignment ( := )");
		Iterator<ForListElement> iterator = forList.iterator();
		while (iterator.hasNext()) {
			iterator.next().doChecking();
		}
		doStatement.doChecking();
		SET_SEMANTICS_CHECKED();
	}

	@Override
	public void doJavaCoding() {
		ForListElement singleElement = getSingleOptimizableElement();
		if (singleElement != null) {
			singleElement.doSimplifiedJavaCoding();
			return;
		}

		// ------------------------------------------------------------
		// Example:
		//
		// for(boolean CB_:new ForList(
		//     new SingleElt<Number>(n1)
		//    ,new SingleElt<Number>(n3)
		//    ,new StepUntil(n5,n3,n201)
		//    ,new WhileElt<Number>(n4,b1)
		// )) { if(!CB_) continue;
		//      // Statements ...
		// }
		// ------------------------------------------------------------
		Global.sourceLineNumber = lineNumber;
		ASSERT_SEMANTICS_CHECKED();
		boolean refType = controlVariable.type.isReferenceType();
		String CB = "CB_" + lineNumber;
		GeneratedJavaClass.code("for(boolean " + CB + ":new ForList(");
		char del = ' ';
		for (ForListElement elt : forList) {
			String classIdent = (refType) ? elt.expr1.type.getJavaRefIdent() : "Number";
			if (elt.expr1.type == Type.Character)
				classIdent = "Character"; // AD'HOC
			if (elt.expr1.type == Type.Boolean)
				classIdent = "Boolean"; // AD'HOC
			if (elt.expr1.type == Type.Text) {
				classIdent = "RTS_TXT"; // AD'HOC
			}
			GeneratedJavaClass.code("   " + del + elt.edCode(classIdent, elt.expr1.type));
			del = ',';
		}
		GeneratedJavaClass.code("   )) { if(!" + CB + ") continue;");
		doStatement.doJavaCoding();
		GeneratedJavaClass.code("}");
	}

	/**
	 * Check if this ForListElement is a single optimizable element.
	 * @return a single optimizable element or null
	 */
	private ForListElement getSingleOptimizableElement() {
		if (forList.size() != 1)
			return (null);
		ForListElement elt = forList.firstElement();
		return (elt.isOptimizable());
	}

	/**
	 * Coding Utility: Edit control variable by name.
	 * @param classIdent Java class identifier
	 * @param xType control variable's type
	 * @return the resulting Java source code for this ForListElement
	 */
	private String edControlVariableByName(final String classIdent, Type xType) {
		String cv = controlVariable.toJavaCode();
		String castVar = "x_;";
		if (controlVariable.type == Type.Integer)
			castVar = "x_.intValue();";
		else if (controlVariable.type == Type.Real)
			castVar = "x_.floatValue();";
		else if (controlVariable.type == Type.LongReal)
			castVar = "x_.doubleValue();";
		else if (controlVariable.type.isReferenceType()) {
			ClassDeclaration qual = controlVariable.type.getQual();
			if (!(controlVariable.type.equals(xType)))
				castVar = "(" + qual.getJavaIdentifier() + ")x_;";
		}
		String cvName = "new RTS_NAME<" + classIdent + ">()" + "{ public " + classIdent + " put(" + classIdent + " x_){"
				+ cv + "=" + castVar + " return(x_);};" + "  public " + classIdent + " get(){return((" + classIdent
				+ ")" + cv + "); }	}";
		return (cvName);
	}

	@Override
	public void print(final int indent) {
		String spc = edIndent(indent);
		String fl = forList.toString().replace('[', ' ').replace(']', ' ');
		Util.println(spc + "FOR " + controlVariable + " " + assignmentOperator + fl + "DO");
		if (doStatement != null)
			doStatement.print(indent);
	}

	@Override
	public void printTree(final int indent) {
		String fl = forList.toString().replace('[', ' ').replace(']', ' ');
		System.out.println(edTreeIndent(indent)+"FOR " + controlVariable + " " + assignmentOperator + fl + " DO ");
		doStatement.printTree(indent+1);
	}

	@Override
	public String toString() {
		String fl = forList.toString().replace('[', ' ').replace(']', ' ');
		return ("FOR " + controlVariable + " " + assignmentOperator + fl + " DO " + doStatement);
	}

	// ************************************************************************************
	// *** ForListElement -- Single Value
	// ************************************************************************************
	/**
	 * Utility class ForListElement implementing a single value element.
	 */
	private class ForListElement {
		/**
		 * The first expression
		 */
		Expression expr1;

		/**
		 * Create a new ForListElement.
		 * @param expr1 The first expression
		 */
		public ForListElement(final Expression expr1) {
			this.expr1 = expr1;
			if (Option.TRACE_PARSE)
				Util.TRACE("NEW ForListElement: " + toString());
		}

		/**
		 * Perform semantic checking.
		 */
		public void doChecking() {
			if (Option.TRACE_CHECKER)
				Util.TRACE("BEGIN ForListElement(" + this + ").doChecking - Current Scope Chain: "
						+ Global.getCurrentScope().edScopeChain());
			expr1.doChecking();
			expr1.backLink = ForStatement.this; // To ensure _RESULT from functions
		}

		/**
		 * Edit Java source code for this ForListElement.
		 * @param classIdent Java class identifier
		 * @param xType control variable's type
		 * @return the resulting Java source code for this ForListElement
		 */
		public String edCode(final String classIdent, Type xType) {
			String forElt = (controlVariable.type == Type.Text && assignmentOperator.getKeyWord() == KeyWord.ASSIGNVALUE) ? "TValElt"
					: "Elt<" + classIdent + ">";
			return ("new Single" + forElt + "(" + edControlVariableByName(classIdent, xType) + ",new RTS_NAME<"
					+ classIdent + ">() { public " + classIdent + " get(){return(" + expr1.toJavaCode() + "); }})");
		}

		/**
		 * Checks if this ForListElement can be optimized.
		 * @return this ForListElement if it can be optimized
		 */
		public ForListElement isOptimizable() {
			return (this);
		}

		/**
		 * Perform simplified JavaCoding.
		 */
		public void doSimplifiedJavaCoding() {
			String cv = controlVariable.toJavaCode();
			String val = this.expr1.toJavaCode();
			if (expr1.type != controlVariable.type) {
				if (controlVariable.type == Type.Integer)
					val = "(int)" + val;
				else if (controlVariable.type == Type.Real)
					val = "(float)" + val;
				else if (controlVariable.type == Type.LongReal)
					val = "(double)" + val;
				else if (controlVariable.type.isReferenceType()) {
					ClassDeclaration qual = controlVariable.type.getQual();
					if (!(controlVariable.type.equals(this.expr1.type)))
						val = "(" + qual.getJavaIdentifier() + ")" + val;
				}
			}
			GeneratedJavaClass.code(cv + "=" + val + "; {");
			doStatement.doJavaCoding();
			GeneratedJavaClass.code("}");
		}

		@Override
		public String toString() {
			return ("" + expr1);
		}
	}

	// ************************************************************************************
	// *** ForListElement -- While Element
	// ************************************************************************************
	/**
	 * Utility class: For-list While element.
	 */
	private class WhileElement extends ForListElement {
		
		/**
		 * The second expression.
		 */
		final Expression expr2;

		/**
		 * Create a new WhileElement.
		 * @param expr1 first expression 
		 * @param expr2 second expression
		 */
		public WhileElement(final Expression expr1, final Expression expr2) {
			super(expr1);
			this.expr2 = expr2;
		}

		@Override
		public void doChecking() {
			if (Option.TRACE_CHECKER)
				Util.TRACE("BEGIN WhileElement(" + this + ").doChecking - Current Scope Chain: "
						+ Global.getCurrentScope().edScopeChain());
			expr1.doChecking();
			expr2.doChecking();
			if (expr2.type != Type.Boolean)
				Util.error("While " + expr2 + " is not of type Boolean");
			expr1 = TypeConversion.testAndCreate(controlVariable.type, expr1);
			expr1.backLink = ForStatement.this; // To ensure _RESULT from functions
			expr2.backLink = ForStatement.this; // To ensure _RESULT from functions
		}

		@Override
		public String edCode(final String classIdent, Type xType) {
			String forElt = (controlVariable.type == Type.Text && assignmentOperator.getKeyWord() == KeyWord.ASSIGNVALUE) ? "TValElt"
					: "Elt<" + classIdent + ">";
			return ("new While" + forElt + "(" + edControlVariableByName(classIdent, xType) + ",new RTS_NAME<"
					+ classIdent + ">() { public " + classIdent + " get(){return(" + expr1.toJavaCode() + "); }}"
					+ ",new RTS_NAME<Boolean>() { public Boolean get(){return(" + expr2.toJavaCode() + "); }})");
		}

		@Override
		public ForListElement isOptimizable() {
			return (this);
		}

		@Override
		public void doSimplifiedJavaCoding() {
			String cv = controlVariable.toJavaCode();
			String cond = this.expr2.toJavaCode();
			// ------------------------------------------------------------
			// cv=expr1; while(cond) { Statements ... cv=expr1; }
			// ------------------------------------------------------------
			GeneratedJavaClass.code(cv + "=" + this.expr1.toJavaCode() + ";");
			GeneratedJavaClass.code("while(" + cond + ") {");
			doStatement.doJavaCoding();
			GeneratedJavaClass.code(cv + "=" + this.expr1.toJavaCode() + ";");
			GeneratedJavaClass.code("}");
		}

		public String toString() {
			return ("" + expr1 + " while " + expr2);
		}
	}

	// ************************************************************************************
	// *** ForListElement -- Step Until Element
	// ************************************************************************************
	/**
	 * Utility class: For-list Step until element.
	 */
	private class StepUntilElement extends ForListElement {
		/**
		 * The second expression.
		 */
		Expression expr2;
		
		/**
		 * The third expression.
		 */
		Expression expr3;

		/**
		 * Create a new StepUntilElement.
		 * @param expr1 The first expression
		 * @param expr2 The second expression
		 * @param expr3 The third expression
		 */
		public StepUntilElement(final Expression expr1, final Expression expr2, final Expression expr3) {
			super(expr1);
			this.expr2 = expr2;
			this.expr3 = expr3;
			if (expr1 == null)
				Util.error("Missing expression before 'step' in ForStatement");
			if (expr2 == null)
				Util.error("Missing expression after 'step' in ForStatement");
			if (expr3 == null)
				Util.error("Missing expression after 'until' in ForStatement");
		}

		@Override
		public void doChecking() {
			expr1.doChecking();
			expr1 = TypeConversion.testAndCreate(controlVariable.type, expr1);
			expr2.doChecking();
			expr2 = TypeConversion.testAndCreate(controlVariable.type, expr2);
			expr3.doChecking();
			expr3 = TypeConversion.testAndCreate(controlVariable.type, expr3);
			expr1.backLink = ForStatement.this; // To ensure _RESULT from functions
			expr2.backLink = ForStatement.this; // To ensure _RESULT from functions
			expr3.backLink = ForStatement.this; // To ensure _RESULT from functions
		}

		@Override
		public String edCode(final String classIdent, Type xType) {
			return ("new StepUntil(" + edControlVariableByName(classIdent, xType)
					+ ",new RTS_NAME<Number>() { public Number get(){return(" + expr1.toJavaCode() + "); }}"
					+ ",new RTS_NAME<Number>() { public Number get(){return(" + expr2.toJavaCode() + "); }}"
					+ ",new RTS_NAME<Number>() { public Number get(){return(" + expr3.toJavaCode() + "); }})");

		}

		@Override
		public ForListElement isOptimizable() {
			Number step = expr2.getNumber();
			if (step == null)
				return (null);
			return (this);
		}

		@Override
		public void doSimplifiedJavaCoding() {
			int step = this.expr2.getNumber().intValue();
			String cv = controlVariable.toJavaCode();
			String stepClause, incrClause;
			if (step >= 0) {
				// ------------------------------------------------------------
				// for(cv=expr1; cv<=expr3; cv=cv+step) { Statements ... }
				// ------------------------------------------------------------
				stepClause = cv + "<=" + this.expr3.toJavaCode() + ";";
				if (step == 1)
					incrClause = cv + "++";
				else
					incrClause = cv + "=" + cv + "+" + step;
			} else {
				// ------------------------------------------------------------
				// for(cv=expr1; cv>=expr3; cv=cv+step) { Statements ... }
				// ------------------------------------------------------------
				stepClause = cv + ">=" + this.expr3.toJavaCode() + ";";
				if (step == -1)
					incrClause = cv + "--";
				else
					incrClause = cv + "=" + cv + step;
			}
			GeneratedJavaClass
					.code("for(" + cv + "=" + this.expr1.toJavaCode() + ";" + stepClause + incrClause + ") {");
			doStatement.doJavaCoding();
			GeneratedJavaClass.code("}");
		}

		@Override
		public String toString() {
			return ("" + expr1 + " step " + expr2 + " until " + expr3);
		}
	}

}
