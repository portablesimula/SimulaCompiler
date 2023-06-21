/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.statement;

import java.util.Iterator;
import java.util.Vector;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.declaration.ClassDeclaration;
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.Parameter;
import simula.compiler.expression.Expression;
import simula.compiler.expression.TypeConversion;
import simula.compiler.expression.Variable;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Token;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;


/**
 * For Statement.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *  ForStatement = FOR Variable :- ReferenceList DO Statement
 *               | FOR Variable := ValueList DO Statement
 *               
 * 		ReferenceList = ReferenceListElement { , ReferenceListElement }
 * 			ReferenceListElement = ReferenceExpression [ WHILE BooleanExpression ]
 * 
 * 		ValueList = ValueListElement { , ValueListElement }
 * 			ValueListElement = ValueExpression [ WHILE BooleanExpression ]
 *                           | ArithmeticExpression STEP ArithmeticExpression UNTIL ArithmeticExpression
 *
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public final class ForStatement extends Statement {
	private final Variable controlVariable;
	private final Token assignmentOperator; // := or :-
	private final Vector<ForListElement> forList = new Vector<ForListElement>();
	private final Statement doStatement;

	public ForStatement(final int line) {
		super(line);
		if (Option.TRACE_PARSE)
			Parser.TRACE("Parse ForStatement");
		controlVariable = new Variable(expectIdentifier());
		if (!Parser.accept(KeyWord.ASSIGNVALUE))
			Parser.expect(KeyWord.ASSIGNREF);
		assignmentOperator = Parser.prevToken;
		do {
			forList.add(parseForListElement());
		} while (Parser.accept(KeyWord.COMMA));
		Parser.expect(KeyWord.DO);
		Statement doStatement = Statement.doParse();
		if (doStatement == null) {
			Util.error("No statement following DO in For statement");
			doStatement = new DummyStatement(line);
		}
		this.doStatement=doStatement;
		if (Option.TRACE_PARSE)
			Util.TRACE("NEW ForStatement: " + toString());
		if(Option.TESTING) System.out.println("Line "+this.lineNumber+": ForStatement: "+this);
	}

	private ForListElement parseForListElement() {
		if (Option.TRACE_PARSE)
			Parser.TRACE("Parse ForListElement");
		Expression expr1 = Expression.parseExpression();
		if (Parser.accept(KeyWord.WHILE))
			return (new WhileElement(expr1, Expression.parseExpression()));
		if (Parser.accept(KeyWord.STEP)) {
			Expression expr2 = Expression.parseExpression();
			Parser.expect(KeyWord.UNTIL);
			return (new StepUntilElement(expr1, expr2, Expression.parseExpression()));
		} else
			return (new ForListElement(expr1));
	}
  
	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber = lineNumber;
		controlVariable.doChecking();
		this.type = controlVariable.type; // Type of control variable
		Declaration decl = controlVariable.meaning.declaredAs;
		if (decl instanceof Parameter par && par.mode == Parameter.Mode.name)
			Util.error("For-Statement's Controled Variable(" + controlVariable + ") can't be a formal parameter by Name");
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
		ForListElement singleElement=isOptimizable();
		if(singleElement!=null) { singleElement.doSimplifiedJavaCoding(); return; }

		// ------------------------------------------------------------
	    //	for(boolean CB_:new ForList(
	    //			 new SingleElt<Number>(n1)
	    //			,new SingleElt<Number>(n3)
	    //			,new StepUntil(n5,n3,n201)
	    //			,new WhileElt<Number>(n4,b1)
	    //       )) { if(!CB_) continue;
	    //	          // Statements ...
	    //	}
	    // ------------------------------------------------------------
		Global.sourceLineNumber=lineNumber;
		ASSERT_SEMANTICS_CHECKED(this);
		boolean refType=controlVariable.type.isReferenceType();
		String CB="CB_"+lineNumber;
	    GeneratedJavaClass.code("for(boolean "+CB+":new ForList(");
	    char del=' ';
	    for(ForListElement elt:forList) { 
	    	String classIdent=(refType)?elt.expr1.type.getJavaRefIdent():"Number";
	    	if(elt.expr1.type==Type.Character) classIdent="Character"; // AD'HOC
	    	if(elt.expr1.type==Type.Boolean) classIdent="Boolean"; // AD'HOC
	    	if(elt.expr1.type==Type.Text) {
	    		classIdent="_TXT"; // AD'HOC
	    	}
	    	GeneratedJavaClass.code("   "+del+elt.edCode(classIdent,elt.expr1.type));
	    	del=',';
	    }
	    GeneratedJavaClass.code("   )) { if(!"+CB+") continue;");
	    doStatement.doJavaCoding();
	    GeneratedJavaClass.code("}");
	}

	private ForListElement isOptimizable() {
		if(forList.size()!=1) return(null);
		ForListElement elt=forList.firstElement();
		return(elt.isOptimizable());
	}
  
    private String edControlVariableByName(final String classIdent,Type xType) {
    	String cv=controlVariable.toJavaCode();
    	String castVar="x_;";
    	if(controlVariable.type==Type.Integer) castVar="x_.intValue();";
    	else if(controlVariable.type==Type.Real) castVar="x_.floatValue();";
    	else if(controlVariable.type==Type.LongReal) castVar="x_.doubleValue();";
    	else if(controlVariable.type.isReferenceType()) {
    		ClassDeclaration qual=controlVariable.type.getQual();
    		if(!(controlVariable.type.equals(xType))) castVar="("+qual.getJavaIdentifier()+")x_;";
    	}
    	String cvName="new _NAME<"+classIdent+">()"+
    			"{ public "+classIdent+" put("+classIdent+" x_){"+cv+"="+castVar+" return(x_);};"+
    			"  public "+classIdent+" get(){return(("+classIdent+")"+cv+"); }	}";
    	return(cvName);
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
	public String toString() {
		String fl = forList.toString().replace('[', ' ').replace(']', ' ');
		return ("FOR " + controlVariable + " " + assignmentOperator + fl + " DO " + doStatement);
	}
  
	// ************************************************************************************
	// *** ForListElement  --  Single Value
	// ************************************************************************************
	private class ForListElement {
		Expression expr1;
		public ForListElement(final Expression expr1) {
			this.expr1=expr1;
		    if(Option.TRACE_PARSE) Util.TRACE("NEW ForListElement: "+toString());
		}  
		public void doChecking() {
			if(Option.TRACE_CHECKER) Util.TRACE("BEGIN ForListElement("+this+").doChecking - Current Scope Chain: "+Global.getCurrentScope().edScopeChain());
		    expr1.doChecking(); 
			expr1.backLink=ForStatement.this; // To ensure _RESULT from functions
		}
		public String edCode(final String classIdent,Type xType) {
			String forElt=(type==Type.Text && assignmentOperator.getKeyWord()==KeyWord.ASSIGNVALUE)?"TValElt":"Elt<"+classIdent+">";
		    return("new Single"+forElt+"("+edControlVariableByName(classIdent,xType)
		      +",new _NAME<"+classIdent+">() { public "+classIdent+" get(){return("+expr1.toJavaCode()+"); }})");
		}
		public ForListElement isOptimizable() {
			return(this);
		}
		public void doSimplifiedJavaCoding() {
	    	String cv=controlVariable.toJavaCode();
	    	String val=this.expr1.toJavaCode();
	    	if(expr1.type!=controlVariable.type) {
	    		if(controlVariable.type==Type.Integer) val="(int)"+val;
	    		else if(controlVariable.type==Type.Real) val="(float)"+val;
	    		else if(controlVariable.type==Type.LongReal) val="(double)"+val;
	        	else if(controlVariable.type.isReferenceType()) {
	        		ClassDeclaration qual=controlVariable.type.getQual();
	        		if(!(controlVariable.type.equals(this.expr1.type))) val="("+qual.getJavaIdentifier()+")"+val;
	        	}
	    	}
		    GeneratedJavaClass.code(cv+"="+val+"; {");
		    doStatement.doJavaCoding();
		    GeneratedJavaClass.code("}");		
		}
		@Override
		public String toString() { return(""+expr1); }
	}
  
	// ************************************************************************************
	// *** ForListElement  --  While Element
	// ************************************************************************************
	private class WhileElement extends ForListElement {
		final Expression expr2;
		public WhileElement(final Expression expr1,final Expression expr2) { super(expr1); this.expr2=expr2; }  
		@Override
		public void doChecking() {
			if(Option.TRACE_CHECKER) Util.TRACE("BEGIN WhileElement("+this+").doChecking - Current Scope Chain: "+Global.getCurrentScope().edScopeChain());
			expr1.doChecking();
			expr2.doChecking(); if(expr2.type!=Type.Boolean) Util.error("While "+expr2+" is not of type Boolean");
			expr1=TypeConversion.testAndCreate(controlVariable.type,expr1);
			expr1.backLink=ForStatement.this; // To ensure _RESULT from functions
			expr2.backLink=ForStatement.this; // To ensure _RESULT from functions
		}
		@Override
		public String edCode(final String classIdent,Type xType) {
			String forElt=(type==Type.Text && assignmentOperator.getKeyWord()==KeyWord.ASSIGNVALUE)?"TValElt":"Elt<"+classIdent+">";
			return("new While"+forElt+"("+edControlVariableByName(classIdent,xType)
			+",new _NAME<"+classIdent+">() { public "+classIdent+" get(){return("+expr1.toJavaCode()+"); }}"
			+",new _NAME<Boolean>() { public Boolean get(){return("+expr2.toJavaCode()+"); }})");
		}
		@Override
		public ForListElement isOptimizable() {
			return(this);
		}
		@Override
		public void doSimplifiedJavaCoding() {
	    	String cv=controlVariable.toJavaCode();
	    	String cond=this.expr2.toJavaCode();
	    	// ------------------------------------------------------------
	    	//  cv=expr1; while(cond) { Statements ...  cv=expr1; }
	    	// ------------------------------------------------------------
		    GeneratedJavaClass.code(cv+"="+this.expr1.toJavaCode()+";");
		    GeneratedJavaClass.code("while("+cond+") {");
		    doStatement.doJavaCoding();
		    GeneratedJavaClass.code(cv+"="+this.expr1.toJavaCode()+";");
		    GeneratedJavaClass.code("}");		
		}
		public String toString() { return(""+expr1+" while "+expr2); }
	}
  
	// ************************************************************************************
	// *** ForListElement  --  Step Until Element
	// ************************************************************************************
	private class StepUntilElement extends ForListElement {
		Expression expr2;
	    Expression expr3;
		public StepUntilElement(final Expression expr1,final Expression expr2,final Expression expr3) {
			super(expr1); this.expr2=expr2; this.expr3=expr3;
			if(expr1==null) Util.error("Missing expression before 'step' in ForStatement");
			if(expr2==null) Util.error("Missing expression after 'step' in ForStatement");
			if(expr3==null) Util.error("Missing expression after 'until' in ForStatement");
		}  
		@Override
		public void doChecking() {
			expr1.doChecking(); expr1=TypeConversion.testAndCreate(controlVariable.type,expr1);
			expr2.doChecking(); expr2=TypeConversion.testAndCreate(controlVariable.type,expr2);
			expr3.doChecking(); expr3=TypeConversion.testAndCreate(controlVariable.type,expr3);
			expr1.backLink=ForStatement.this; // To ensure _RESULT from functions
			expr2.backLink=ForStatement.this; // To ensure _RESULT from functions
			expr3.backLink=ForStatement.this; // To ensure _RESULT from functions
		}
		public String edCode(final String classIdent,Type xType) {
			return("new StepUntil("+edControlVariableByName(classIdent,xType)
	  	                     +",new _NAME<Number>() { public Number get(){return("+expr1.toJavaCode()+"); }}"
	  	                     +",new _NAME<Number>() { public Number get(){return("+expr2.toJavaCode()+"); }}"
	  	                     +",new _NAME<Number>() { public Number get(){return("+expr3.toJavaCode()+"); }})");
	      
		}
		@Override
		public ForListElement isOptimizable() {
			Number step=expr2.getNumber();
			if(step==null) return(null); 
			return(this);
		}
		@Override
		public void doSimplifiedJavaCoding() {
			int step=this.expr2.getNumber().intValue();
	    	String cv=controlVariable.toJavaCode();
	    	String stepClause,incrClause;
	    	if(step>=0) {
	    		// ------------------------------------------------------------
	    	    //	for(cv=expr1; cv<=expr3; cv=cv+step) { Statements ...	}
	    	    // ------------------------------------------------------------
	        	stepClause=cv+"<="+this.expr3.toJavaCode()+";";
	        	if(step==1) incrClause=cv+"++";
	        	else incrClause=cv+"="+cv+"+"+step;    		
	    	} else {
	    		// ------------------------------------------------------------
	    	    //	for(cv=expr1; cv>=expr3; cv=cv+step) { Statements ...	}
	    	    // ------------------------------------------------------------
	        	stepClause=cv+">="+this.expr3.toJavaCode()+";";
	        	if(step== -1) incrClause=cv+"--";
	        	else incrClause=cv+"="+cv+step;
	    	}
		    GeneratedJavaClass.code("for("+cv+"="+this.expr1.toJavaCode()+";"+stepClause+incrClause+") {");
		    doStatement.doJavaCoding();
		    GeneratedJavaClass.code("}");		
		}

		@Override
		public String toString() { return(""+expr1+" step "+expr2+ " until "+expr3); }
	}

}
