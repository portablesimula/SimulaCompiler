/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.statement;

import java.util.Vector;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.parsing.Parse;
import simula.compiler.syntaxClass.Type;
import simula.compiler.syntaxClass.expression.Expression;
import simula.compiler.syntaxClass.expression.TypeConversion;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Switch Statement.
 * 
 * This is a S-PORT extension to the language.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 * switch-statement = SWITCH ( lowKey : hiKey ) switchKey BEGIN { switch-case } [ none-case ] END [ otherwise-case ]
 * 
 *      switch-case = WHEN caseKey-list do statement ;
 *      
 *      none-case   = WHEN NONE do statement ;
 *      
 *      otherwise-case = OTHERWISE statement ;
 *      
 *         caseKey-list = caseKey { , caseKey }
 *      
 *            caseKey = caseConstant  | caseConstant : caseConstant
 *            
 *               caseConstant = integer-or-character-constant
 *      
 *      lowKey = integer-or-character-expression
 *      hiKey = integer-or-character-expression
 *      switchKey = integer-or-character-expression
 *
 * Translated into a Java Switch Statement with break after each statement.
 * 
 * Example:
 * 
 *   <b>switch</b>(lowkey:hikey) key
 *   <b>begin</b>
 *      <b>when</b> 0 <b>do</b> statement-0 ;
 *      ...
 *      <b>when</b> <b>none</b> <b>do</b> statement-e ;
 *   <b>end</b>
 *   
 *   Is compiled into Java-code:
 *   
 *   if(key &lt; lowkey || key > hikey) throw new RTS_SimulaRuntimeError("Switch key outside key interval");
 *   switch(key) {
 *       case 0: statement-0; break;
 *       ...
 *       default: statement-e; break;
 *   }
 *   
 * </pre>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/statement/SwitchStatement.java">
 * <b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public final class SwitchStatement extends Statement {
	
	/**
	 * The low key.
	 */
	private final Expression lowKey;
	
	/**
	 * The high key
	 */
	private final Expression hiKey;
	
	/**
	 * The switchKey
	 */
	private Expression switchKey;
	
	/**
	 * The list of When parts
	 */
	private final Vector<WhenPart> switchCases=new Vector<WhenPart>();

	/**
	 * Create a new SwitchStatement.
	 * @param line the source line number
	 */
	SwitchStatement(int line) {
		super(line);
		if (Option.TRACE_PARSE)	Parse.TRACE("Parse SwitchStatement: line="+line);
		Parse.expect(KeyWord.BEGPAR);
		lowKey = Expression.expectExpression();
		Parse.expect(KeyWord.COLON);
		hiKey = Expression.expectExpression();
		Parse.expect(KeyWord.ENDPAR);
		switchKey = Expression.expectExpression();
		switchKey.backLink=this;
		Parse.expect(KeyWord.BEGIN);
    	boolean noneCaseUsed=false;
		while (Parse.accept(KeyWord.WHEN)) {
			Vector<SwitchInterval> caseKeyList=new Vector<SwitchInterval>();
			if (Parse.accept(KeyWord.NONE)) {
				caseKeyList.add(null);
				if(noneCaseUsed) Util.error("NONE Case is already used");
				noneCaseUsed=true;
			}
			else {
				caseKeyList.add(expectCasePair());
				while(Parse.accept(KeyWord.COMMA)) caseKeyList.add(expectCasePair());
			}
			Parse.expect(KeyWord.DO);
			Statement statement = Statement.expectStatement();
			Parse.accept(KeyWord.SEMICOLON);
			switchCases.add(new WhenPart(caseKeyList, statement));
		}
		Parse.expect(KeyWord.END);
		if (Option.TRACE_PARSE)	Util.TRACE("Line "+lineNumber+": SwitchStatement: "+this);
	}

	/**
	 * Parse Utility: Expect case pair.
	 * @return the resulting SwitchInterval
	 */
	private SwitchInterval expectCasePair() {
		Expression lowCase=Expression.expectExpression();
		Expression hiCase=null;
		if(Parse.accept(KeyWord.COLON)) hiCase=Expression.expectExpression();
		return(new SwitchInterval(lowCase,hiCase));
	}

	/**
	 * Utility class SwitchInterval
	 */
    private class SwitchInterval {
    	/**
    	 * The lower case key
    	 */
    	Expression lowCase;
    	
    	/**
    	 * The high case key
    	 */
    	Expression hiCase;
    	
    	/**
    	 * Utility class: SwitchInterval
    	 * @param lowCase lower case
    	 * @param hiCase high case
    	 */
    	private SwitchInterval(Expression lowCase,Expression hiCase) {
    		this.lowCase=lowCase; this.hiCase=hiCase;
    	}
    	
    	@Override
    	public String toString() {
    		if(hiCase==null) return(""+lowCase);
    		return("["+lowCase+":"+hiCase+']');
    	}
    }
    
    /**
     * Utility class WhenPart.
     */
    private class WhenPart {
    	
    	/**
    	 * The case key list.
    	 */
    	Vector<SwitchInterval> caseKeyList;
    	
    	/**
    	 * The statement
    	 */
    	Statement statement;
    	
    	/**
    	 * Create a new WhenPart.
    	 * @param caseKeyList the case key list
    	 * @param statement the statement
    	 */
    	private WhenPart(Vector<SwitchInterval> caseKeyList,Statement statement)	{
    		this.caseKeyList=caseKeyList;
    		this.statement=statement;
    		if(Option.TRACE_PARSE) Util.TRACE("NEW WhenPart: " + toString());
    	}
	
    	/**
    	 * Coding Utility: Edit this when-part.
    	 * @param first true if this when-part is the first being edited
    	 */
    	private void doCoding(final boolean first)	{
    		ASSERT_SEMANTICS_CHECKED();
    		for(SwitchInterval casePair:caseKeyList)
    		if(casePair==null)
    			 GeneratedJavaClass.code("default:");
    		else {
    			int low=casePair.lowCase.getInt();
    			if(casePair.hiCase!=null) {
        			int hi=casePair.hiCase.getInt();
        			for(int i=low;i<=hi;i++)
        			GeneratedJavaClass.code("case "+i+": ");
    			} else GeneratedJavaClass.code("case "+low+": ");
    		}
    		statement.doJavaCoding();
    		GeneratedJavaClass.code("break;");
    	}
	
    	/**
    	 * Utility method print.
    	 * @param indent the indentation
    	 */
    	private void print(final int indent) {
        	String spc=edIndent(indent);
    		System.out.print(spc+edWhen());
    		statement.print(indent);
    	}
    	
    	/**
    	 * Utility: Edit when clause.
    	 * @return the resulting string
    	 */
    	private String edWhen() {
    		StringBuilder s=new StringBuilder();
    		s.append("WHEN ");
    		for(SwitchInterval casePair:caseKeyList)
    		   s.append((casePair==null)?"NONE":casePair).append(": ");
    		s.append("DO ");
    		return(s.toString());
    	}
    	
    	public void printTree(final int indent) {
    		System.out.println(edTreeIndent(indent)+edWhen());
    		statement.printTree(indent+1);
    	}
	
    	@Override
    	public String toString() {
    		return(edWhen()+" ...");
    	}
    }

	@Override
    public void doChecking() {
    	if(IS_SEMANTICS_CHECKED()) return;
    	Global.sourceLineNumber=lineNumber;
    	if(Option.TRACE_CHECKER) Util.TRACE("BEGIN SwitchStatement("+toString()+").doChecking - Current Scope Chain: "+Global.getCurrentScope().edScopeChain());    
    	lowKey.doChecking(); hiKey.doChecking();
    	switchKey.doChecking();
		if(switchKey.type==Type.Character) {
			switchKey=TypeConversion.testAndCreate(Type.Character,switchKey);
		} else
			switchKey=TypeConversion.testAndCreate(Type.Integer,switchKey);
    	for(WhenPart when:switchCases) {
    		for(SwitchInterval casePair:when.caseKeyList)
			if(casePair!=null) {
				casePair.lowCase.doChecking();
				if(casePair.hiCase!=null) casePair.hiCase.doChecking();
			}
    		when.statement.doChecking();
    	}
    	SET_SEMANTICS_CHECKED();
    }
	
	
	@Override
    public void doJavaCoding() {
    	Global.sourceLineNumber=lineNumber;
	    ASSERT_SEMANTICS_CHECKED();
	    StringBuilder sb=new StringBuilder();
	    sb.append("if(").append(switchKey.toJavaCode()).append("<").append(lowKey.toJavaCode());
	    sb.append(" || ").append(switchKey.toJavaCode()).append(">").append(hiKey.toJavaCode());
	    sb.append(") throw new RTS_SimulaRuntimeError(\"Switch key outside key interval\");");
	    GeneratedJavaClass.code(sb.toString());
        GeneratedJavaClass.code("switch("+switchKey.toJavaCode()+") { // BEGIN SWITCH STATEMENT");
        for(WhenPart when:switchCases) when.doCoding(false);
        GeneratedJavaClass.code("} // END SWITCH STATEMENT");
    }
  
    // ***********************************************************************************************
    // *** Printing Utility: print
    // ***********************************************************************************************
	@Override
    public void print(final int indent) {
    	String spc=edIndent(indent);
    	Util.println(spc+"SWITCH("+lowKey+':'+hiKey+") "+switchKey);
    	Util.println(spc+"BEGIN");
    	for(WhenPart when:switchCases) when.print(indent+1);
        Util.println(spc+"END"); 
    }
	
	@Override
	public void printTree(final int indent) {
		System.out.println(edTreeIndent(indent)+"SWITCH("+lowKey+':'+hiKey+") "+switchKey);
		for (WhenPart when : switchCases) when.printTree(indent+1);
	}

	@Override
    public String toString() {
    	return("SWITCH("+lowKey+':'+hiKey+") "+switchKey+" ...");
    }
  
}
