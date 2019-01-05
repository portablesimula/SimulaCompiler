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
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.TypeDeclaration;
import simula.compiler.expression.Constant;
import simula.compiler.expression.Expression;
import simula.compiler.expression.TypeConversion;
import simula.compiler.expression.Variable;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
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
	Expression lowKey,hiKey,switchKey;
    //int lowIndex,hiIndex;  // Set during Checking
    Vector<WhenPart> switchCases=new Vector<WhenPart>();

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
//			Parser.expect(KeyWord.SEMICOLON);
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
	
    	public void doCoding(boolean first)	{
    		ASSERT_SEMANTICS_CHECKED(this);
    		for(CasePair casePair:caseKeyList)
    		if(casePair==null)
    			 JavaModule.code("default:");
    		else {
    			int low=intConstant(casePair.lowCase);
    			if(casePair.hiCase!=null) {
        			int hi=intConstant(casePair.hiCase);
        			for(int i=low;i<=hi;i++)
        			JavaModule.code("case "+i+": ");
    			} else JavaModule.code("case "+low+": ");
    		}
    		statement.doJavaCoding();
    	}
	
    	public void print(String indent) {
    		System.out.print(indent+edWhen());
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

//    	lowIndex=intConstant(lowKey);
//    	hiIndex=intConstant(hiKey);
//    	if(lowIndex > hiIndex) Util.error("Switch Statement: "+lowKey+"("+lowIndex+")"+" > "+hiKey+"("+hiIndex+")");
    	switchKey.doChecking();
		//System.out.println("SwitchStatement.doChecking: switchKey'type="+switchKey.type);
		if(switchKey.type==Type.Character) {
			
		} else switchKey=TypeConversion.testAndCreate(Type.Integer,switchKey);
//    	boolean[] used=new boolean[hiIndex-lowIndex+1];
    	for(WhenPart when:switchCases) {
			//System.out.println("SwitchStatement.doChecking: when="+when);
    		for(CasePair casePair:when.caseKeyList)
			if(casePair!=null) {
				casePair.lowCase.doChecking();
				if(casePair.hiCase!=null) casePair.hiCase.doChecking();
			}
    		when.statement.doChecking();
    	}
    	SET_SEMANTICS_CHECKED();
    }

	private int intConstant(Expression e) {
		//System.out.println("SwitchStatement.intConstant: e="+e+", QUAL="+e.getClass().getSimpleName());
		if(e instanceof Constant) {
			Object value=((Constant)e).value;
			//System.out.println("SwitchStatement.intConstant: value="+value+", QUAL="+value.getClass().getSimpleName());
			if(value instanceof Number) {
				int intValue=((Number)value).intValue();
				//System.out.println("SwitchStatement.intConstant: longValue="+intValue);
				return(intValue);
			} else if(value instanceof Character) {
				char charValue=((Character)value).charValue();
				//System.out.println("SwitchStatement.intConstant: charValue="+charValue);
				return((int)charValue);
			}
		}
		if(e instanceof Variable) {
			Variable var=(Variable)e;
			Meaning meaning=var.meaning;
			//System.out.println("SwitchStatement.intConstant: meaning="+meaning);
			Declaration declaredAs=meaning.declaredAs;
			//System.out.println("SwitchStatement.intConstant: declaredAs="+declaredAs+", QUAL="+declaredAs.getClass().getSimpleName());
			if(declaredAs instanceof TypeDeclaration) {
				TypeDeclaration tp=(TypeDeclaration)declaredAs;
				Expression constElt=tp.constantElement;
				//System.out.println("SwitchStatement.intConstant: constElt="+constElt);
				if(constElt!=null) {
				    //System.out.println("SwitchStatement.intConstant: constElt="+constElt+", QUAL="+constElt.getClass().getSimpleName());
					if(constElt instanceof Constant) {
						Object value=((Constant)constElt).value;
						//System.out.println("SwitchStatement.intConstant: value="+value+", QUAL="+value.getClass().getSimpleName());
						if(value instanceof Number) {
							int intValue=((Number)value).intValue();
							//System.out.println("SwitchStatement.intConstant: longValue="+intValue);
							return(intValue);
						} else if(value instanceof Character) {
							char charValue=((Character)value).charValue();
							//System.out.println("SwitchStatement.intConstant: charValue="+charValue);
							return((int)charValue);
						}
					}
				}
			}
		}
		Util.error("Switch Statement: "+e+" is not a Constant");
		return(0);
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
    public void print(String indent) {
    	System.out.println(indent+"SWITCH("+lowKey+':'+hiKey+") "+switchKey);
    	System.out.println(indent+"BEGIN");
    	for(WhenPart when:switchCases) when.print(indent+"   ");
        System.out.println(indent+"END"); 
    }

    public String toString() {
    	return("SWITCH("+lowKey+':'+hiKey+") "+switchKey+" ...");
    }
  
}
