/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.statement;

import java.util.Vector;

import simula.compiler.JavaModule;
import simula.compiler.expression.Expression;
import simula.compiler.expression.TypeConversion;
import simula.compiler.parsing.Parser;
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
 * switch-statement = SWITCH ( lowKey : hiKey ) switchKey BEGIN { switch-case } [ none-case ] END
 *      switch-case = WHEN <caseKey-list> do <statement> ;
 *      none-case   = WHEN NONE do <statement> ;
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
    //int lowIndex,hiIndex;  // Set during Checking
	private final Vector<WhenPart> switchCases=new Vector<WhenPart>();

	public SwitchStatement() {
		if (Option.TRACE_PARSE)	Parser.TRACE("Parse SwitchStatement");
		Parser.expect(KeyWord.BEGPAR);
		lowKey = Expression.parseExpression();
		Parser.expect(KeyWord.COLON);
		hiKey = Expression.parseExpression();
		Parser.expect(KeyWord.ENDPAR);
		switchKey = Expression.parseExpression();
		Parser.expect(KeyWord.BEGIN);
    	boolean noneCaseUsed=false;
		while (Parser.accept(KeyWord.WHEN)) {
			Vector<CasePair> caseKeyList=new Vector<CasePair>();
			if (Parser.accept(KeyWord.NONE)) {
				caseKeyList.add(null);
				if(noneCaseUsed) Util.error("NONE Case is already used");
				noneCaseUsed=true;
			}
			else {
				caseKeyList.add(parseCasePair());
				while(Parser.accept(KeyWord.COMMA)) caseKeyList.add(parseCasePair());
			}
			Parser.expect(KeyWord.DO);
			Statement statement = Statement.doParse();
			Parser.accept(KeyWord.SEMICOLON);
			switchCases.add(new WhenPart(caseKeyList, statement));
		}
		Parser.expect(KeyWord.END);
		if (Option.TRACE_PARSE)	Util.TRACE("END NEW ConnectionStatement: " + toString());
	}

	public CasePair parseCasePair() {
		Expression lowCase=Expression.parseExpression();
		Expression hiCase=null;
		if(Parser.accept(KeyWord.COLON)) hiCase=Expression.parseExpression();
		return(new CasePair(lowCase,hiCase));
	}

	
    class CasePair {
    	Expression lowCase,hiCase;
    	public CasePair(Expression lowCase,Expression hiCase) {
    		this.lowCase=lowCase; this.hiCase=hiCase;
    	}
    	
    	public String toString() {
    		if(hiCase==null) return(""+lowCase);
    		return("["+lowCase+":"+hiCase+']');
    	}
    }
    
    class WhenPart {
    	Vector<CasePair> caseKeyList;
    	Statement statement;
    	public WhenPart(Vector<CasePair> caseKeyList,Statement statement)	{
    		this.caseKeyList=caseKeyList;
    		this.statement=statement;
    		if(Option.TRACE_PARSE) Util.TRACE("NEW WhenPart: " + toString());
    	}
	
    	public void doCoding(final boolean first)	{
    		ASSERT_SEMANTICS_CHECKED(this);
    		for(CasePair casePair:caseKeyList)
    		if(casePair==null)
    			 JavaModule.code("default:");
    		else {
    			int low=casePair.lowCase.getInt();
    			if(casePair.hiCase!=null) {
        			int hi=casePair.hiCase.getInt();
        			for(int i=low;i<=hi;i++)
        			JavaModule.code("case "+i+": ");
    			} else JavaModule.code("case "+low+": ");
    		}
    		statement.doJavaCoding();
    	}
	
    	public void print(final int indent) {
        	String spc=edIndent(indent);
    		System.out.print(spc+edWhen());
    		statement.print(indent);
    	}
    	
    	private String edWhen() {
    		StringBuilder s=new StringBuilder();
    		s.append("WHEN ");
    		for(CasePair casePair:caseKeyList)
    		   s.append((casePair==null)?"NONE":casePair).append(": ");
    		s.append("DO ");
    		return(s.toString());
    	}
	
    	public String toString() {
    		return(edWhen()+" ...");
    	}
    }

    public void doChecking() {
    	if(IS_SEMANTICS_CHECKED()) return;
    	Global.sourceLineNumber=lineNumber;
    	if(Option.TRACE_CHECKER) Util.TRACE("BEGIN SwitchStatement("+toString()+").doChecking - Current Scope Chain: "+Global.currentScope.edScopeChain());    
    	lowKey.doChecking(); hiKey.doChecking();
    	switchKey.doChecking();
		if(switchKey.type==Type.Character) {
			Util.NOT_IMPLEMENTED("Switch Statement: Keytype Character");
		} else switchKey=TypeConversion.testAndCreate(Type.Integer,switchKey);
    	for(WhenPart when:switchCases) {
    		for(CasePair casePair:when.caseKeyList)
			if(casePair!=null) {
				casePair.lowCase.doChecking();
				if(casePair.hiCase!=null) casePair.hiCase.doChecking();
			}
    		when.statement.doChecking();
    	}
    	SET_SEMANTICS_CHECKED();
    }
	
	
    public void doJavaCoding() {
    	Global.sourceLineNumber=lineNumber;
	    ASSERT_SEMANTICS_CHECKED(this);
        JavaModule.code("switch("+switchKey.toJavaCode()+") { // BEGIN SWITCH STATEMENT");
        for(WhenPart when:switchCases) when.doCoding(false);
        JavaModule.code("} // END SWITCH STATEMENT");
    }
  
    // ***********************************************************************************************
    // *** Printing Utility: print
    // ***********************************************************************************************
    public void print(final int indent) {
    	String spc=edIndent(indent);
    	Util.println(spc+"SWITCH("+lowKey+':'+hiKey+") "+switchKey);
    	Util.println(spc+"BEGIN");
    	for(WhenPart when:switchCases) when.print(indent+1);
        Util.println(spc+"END"); 
    }

    public String toString() {
    	return("SWITCH("+lowKey+':'+hiKey+") "+switchKey+" ...");
    }
  
}
