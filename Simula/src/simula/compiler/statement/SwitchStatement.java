/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.statement;

import java.util.Vector;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.expression.Expression;
import simula.compiler.expression.TypeConversion;
import simula.compiler.parsing.Parse;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
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
 *      switch-case = WHEN <caseKey-list> do <statement> ;
 *      none-case   = WHEN NONE do <statement> ;
 *      otherwise-case   = OTHERWISE <statement> ;
 *      <caseKey-list> = caseKey { , caseKey }
 *      caseKey = caseConstant  | caseConstant : caseConstant
 *      
 *      lowKey = integer-or-character-expression
 *      hiKey = integer-or-character-expression
 *      switchKey = integer-or-character-expression
 *      caseConstant = integer-or-character-constant
 *
 * Example:
 * 
 *   switch(lowkey:hikey) key
 *   begin
 *      when 0 do <statement-0> ;
 *      ...
 *      when NONE do <statement-e> ;
 *   end
 *   
 *   Is compiled into Java-code:
 *   
 *   if(key<lowkey || key>hikey) throw new _SimulaRuntimeError("Switch key outside key interval");
 *   switch(key) {
 *       case 0: <statement-0> ;
 *       ...
 *       default: <statement-e> ;
 *   }
 *   
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public final class SwitchStatement extends Statement {
	private final Expression lowKey,hiKey;
	private Expression switchKey;
	private final Vector<WhenPart> switchCases=new Vector<WhenPart>();

	SwitchStatement(int line) {
		super(line);
		if (Option.TRACE_PARSE)	Parse.TRACE("Parse SwitchStatement: line="+line);
		Parse.expect(KeyWord.BEGPAR);
		lowKey = Expression.parseExpression();
		Parse.expect(KeyWord.COLON);
		hiKey = Expression.parseExpression();
		Parse.expect(KeyWord.ENDPAR);
		switchKey = Expression.parseExpression();
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
				caseKeyList.add(parseCasePair());
				while(Parse.accept(KeyWord.COMMA)) caseKeyList.add(parseCasePair());
			}
			Parse.expect(KeyWord.DO);
			Statement statement = Statement.doParse();
			Parse.accept(KeyWord.SEMICOLON);
			switchCases.add(new WhenPart(caseKeyList, statement));
		}
		Parse.expect(KeyWord.END);
		if (Option.TRACE_PARSE)	Util.TRACE("Line "+lineNumber+": SwitchStatement: "+this);
	}

	private SwitchInterval parseCasePair() {
		Expression lowCase=Expression.parseExpression();
		Expression hiCase=null;
		if(Parse.accept(KeyWord.COLON)) hiCase=Expression.parseExpression();
		return(new SwitchInterval(lowCase,hiCase));
	}

	
    private class SwitchInterval {
    	Expression lowCase,hiCase;
    	private SwitchInterval(Expression lowCase,Expression hiCase) {
    		this.lowCase=lowCase; this.hiCase=hiCase;
    	}
    	
    	@Override
    	public String toString() {
    		if(hiCase==null) return(""+lowCase);
    		return("["+lowCase+":"+hiCase+']');
    	}
    }
    
    private class WhenPart {
    	Vector<SwitchInterval> caseKeyList;
    	Statement statement;
    	private WhenPart(Vector<SwitchInterval> caseKeyList,Statement statement)	{
    		this.caseKeyList=caseKeyList;
    		this.statement=statement;
    		if(Option.TRACE_PARSE) Util.TRACE("NEW WhenPart: " + toString());
    	}
	
    	private void doCoding(final boolean first)	{
    		ASSERT_SEMANTICS_CHECKED(this);
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
	
    	private void print(final int indent) {
        	String spc=edIndent(indent);
    		System.out.print(spc+edWhen());
    		statement.print(indent);
    	}
    	
    	private String edWhen() {
    		StringBuilder s=new StringBuilder();
    		s.append("WHEN ");
    		for(SwitchInterval casePair:caseKeyList)
    		   s.append((casePair==null)?"NONE":casePair).append(": ");
    		s.append("DO ");
    		return(s.toString());
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
	    ASSERT_SEMANTICS_CHECKED(this);
	    StringBuilder sb=new StringBuilder();
	    sb.append("if(").append(switchKey.toJavaCode()).append("<").append(lowKey.toJavaCode());
	    sb.append(" || ").append(switchKey.toJavaCode()).append(">").append(hiKey.toJavaCode());
	    sb.append(") throw new _SimulaRuntimeError(\"Switch key outside key interval\");");
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
    public String toString() {
    	return("SWITCH("+lowKey+':'+hiKey+") "+switchKey+" ...");
    }
  
}
