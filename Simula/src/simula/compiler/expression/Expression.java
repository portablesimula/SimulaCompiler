/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import simula.compiler.SyntaxClass;
import simula.compiler.declaration.ClassDeclaration;
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.SimpleVariableDeclaration;
import simula.compiler.parsing.Parse;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;


/**
 * Expression.
 * 
 * <pre>
 * 
 * Syntax used during Parsing:
 * 
 * Expression  =  SimpleExpression
 *	           |  IF  BooleanExpression  THEN  SimpleExpression  ELSE  Expression
 *
 *  SimpleExpression  =  BooleanTertiary  { OR ELSE  BooleanTertiary }
 *  BooleanTertiary   =  Equivalence  { AND THEN  Equivalence }
 *  Equivalence       =  Implication  { EQV  Implication }
 *  Implication       =  BooleanTerm  { IMP  BooleanTerm }
 *  BooleanTerm       =  BooleanFactor  { OR  BooleanFactor }
 *  BooleanFactor     =  BooleanSecondary  { AND  BooleanSecondary }
 *  BooleanSecondary  =  [ NOT ]  BooleanPrimary
 *  BooleanPrimary    =  TextPrimary  { &amp; TextPrimary }
 *  TextPrimary       =  SimpleArithmeticExpression  [ RelationOperator  SimpleArithmeticExpression ]
 *       RelationOperator  =  &lt;  |  &lt;=  |  =  |  >=  |  >  |  &lt;> |  ==  |  =/=
 *  SimpleArithmeticExpression  =  [ + | - ]  Term  {  ( + | - )  Term }
 *  Term    =  Factor  {  ( * | / | // )  Factor }
 *  Factor  =  BasicExpression  { **  BasicExpression }
 *              
 *  
 *  BasicExpression  =  PrimaryExpression  |  {  RemoteIdentifier  |  ObjectRelation  |  QualifiedObject   }
 *		RemoteIdentifier =  PrimaryExpression  .  AttributeIdentifier
 *		ObjectRelation   =  PrimaryExpression ( IS | IN )  ClassIdentifier
 *		QualifiedObject  =  PrimaryExpression  QUA  ClassIdentifier
 * 
 *  PrimaryExpression =  ( Expression ) | Constant | ObjectGenerator | LocalObject | Variable | SubscriptedVariable
 *		Constant = IntegerConstant | RealConstant | CharacterConstant | TextConstant | BooleanConstant | SymbolicValue  
 *				BooleanConstant = TRUE | FALSE
 *				SymbolicValue   = NONE | NOTEXT
 *                ... other constants as delivered by the scanner
 *		ObjectGenerator  =  NEW  Identifier  "("  Expression  {  ,  Expression  }  ")"
 *		LocalObject = THIS ClassIdentifier
 *		Variable  =  Identifier
 *		SubscriptedVariable  =  Identifier  "("  Expression  {  ,  Expression  }  ")"
 *   
 * </pre>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/expression/Expression.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 * @author Stein Krogdahl
 */
public abstract class Expression extends SyntaxClass {
	
	/**
	 * This Expression is part of  backLink Expression/Statement.
	 */
	public SyntaxClass backLink;

	/**
	 * Expression.
	 */
	Expression(){}
	
	@Override
	public String toString() { return("NO EXPRESSION"); }


	/**
	 * Parse expression.
	 * <pre>
	 * Expression  =  SimpleExpression
	 *	         |  IF  BooleanExpression  THEN  SimpleExpression  ELSE  Expression
	 * </pre>
	 * @return Expression or null if no expression is found.
	 */
	public static Expression parseExpression() {
		if(Parse.accept(KeyWord.IF)) {
			Expression condition=parseExpression();
			Parse.expect(KeyWord.THEN); Expression thenExpression=parseSimpleExpression();
			Parse.expect(KeyWord.ELSE); Expression elseExpression=parseExpression();
			Expression expr=new ConditionalExpression(Type.Boolean,condition,thenExpression,elseExpression);
			if(Option.TRACE_PARSE) Util.TRACE("Expression: ParseExpression, result="+expr);
			return(expr);
		} else return(parseSimpleExpression());
	}  

	/**
	 * Parse simple expression.
	 * <pre>
	 *  SimpleExpression  =  BooleanTertiary  { OR ELSE  BooleanTertiary }
	 *  BooleanTertiary   =  Equivalence  { AND THEN  Equivalence }
	 *  Equivalence       =  Implication  { EQV  Implication }
	 *  Implication       =  BooleanTerm  { IMP  BooleanTerm }
	 *  BooleanTerm       =  BooleanFactor  { OR  BooleanFactor }
	 *  BooleanFactor     =  BooleanSecondary  { AND  BooleanSecondary }
	 *  BooleanSecondary  =  [ NOT ]  BooleanPrimary
	 *  BooleanPrimary    =  TextPrimary  { &amp; TextPrimary }
	 *  TextPrimary       =  SimpleArithmeticExpression  [ RelationOperator  SimpleArithmeticExpression ]
	 *       RelationOperator  =  &lt;  |  &lt;=  |  =  |  >=  |  >  |  &lt;> |  ==  |  =/=
	 *  SimpleArithmeticExpression  =  [ + | - ]  Term  {  ( + | - )  Term }
	 *  Term    =  Factor  {  ( * | / | // )  Factor }
	 *  Factor  =  BasicExpression  { **  BasicExpression }
	 * </pre>             
	 *        
	 * @return Expression or null if no expression is found.
	 */
	protected static Expression parseSimpleExpression()  {   
		Expression expr = parseANDTHEN();
		while(Parse.accept(KeyWord.OR_ELSE))  {
			expr=new BooleanExpression(expr,KeyWord.OR_ELSE,parseANDTHEN());
		}
		return(expr);
	}

	// BooleanTertiary =  Equivalence  { AND THEN  Equivalence }
	private static Expression parseANDTHEN() {
		Expression expr = parseEQV();
		while(Parse.accept(KeyWord.AND_THEN))
			expr=new BooleanExpression(expr,KeyWord.AND_THEN,parseEQV());
		return(expr);
	}

	// Equivalence  =  Implication  { EQV  Implication }
	private static Expression parseEQV() { 
		Expression expr=parseIMP();
		while(Parse.accept(KeyWord.EQV))
			expr=new BooleanExpression(expr,KeyWord.EQV,parseIMP());
		return(expr);
	}

	// Implication =  BooleanTerm  { IMP  BooleanTerm }
	private static Expression parseIMP() {
		Expression expr=parseOR();
		while(Parse.accept(KeyWord.IMP))
			expr=new BooleanExpression(expr,KeyWord.IMP,parseOR());
		return(expr);
	}

	// BooleanTerm  =  BooleanFactor  { OR  BooleanFactor }
	private static Expression parseOR() {
		Expression expr=parseAND();
		while(Parse.accept(KeyWord.OR))
			expr=new BooleanExpression(expr,KeyWord.OR,parseAND());
		return(expr);
	}

	// BooleanFactor =  BooleanSecondary  { AND  BooleanSecondary }
	private static Expression parseAND() {
		Expression expr=parseNOT();
		while(Parse.accept(KeyWord.AND))
			expr=new BooleanExpression(expr,KeyWord.AND,parseNOT());
		return(expr);
	}

	// BooleanSecondary  =  [ NOT ]  BooleanPrimary
	private static Expression  parseNOT() {
		Expression expr;
		if(Parse.accept(KeyWord.NOT)) {
			expr=UnaryOperation.create(KeyWord.NOT,parseTEXTCONC());
		} else expr = parseTEXTCONC();
		return(expr);
	}

	// BooleanPrimary  =  TextPrimary  { &amp; TextPrimary }
	private static Expression parseTEXTCONC() {
		Expression expr=parseREL();
		while(Parse.accept(KeyWord.CONC))
			expr=new TextExpression(expr,parseREL());
		return(expr);
	}

	// TextPrimary =  SimpleArithmeticExpression  [ RelationOperator  SimpleArithmeticExpression ]
	//    RelationOperator  =  <  |  <=  |  =  |  >=  |  >  |  <> |  ==  |  =/=
	private static Expression parseREL() {   // Metode-form      
		Expression expr = parseAdditiveOperation();
		if(Parse.acceptRelationalOperator())   { 
			KeyWord opr=Parse.prevToken.getKeyWord();
			expr=new RelationalOperation(expr,opr,parseAdditiveOperation());
		}
		return(expr);
	}

	// SimpleArithmeticExpression  =  [ + | - ]  Term  {  ( + | - )  Term }
	// SimpleArithmeticExpression  =  UnaryTerm  {  ( + | - )  Term }
	private static Expression parseAdditiveOperation() {
		Expression expr=parseUNIMULDIV();
		while(Parse.accept(KeyWord.PLUS,KeyWord.MINUS)) { 
			KeyWord opr=Parse.prevToken.getKeyWord();
			expr=ArithmeticExpression.create(expr,opr,parseMULDIV());
		}
		return(expr);
	}

	// UnaryTerm  =  [ + | - ]  Term
	private static Expression parseUNIMULDIV() {
		Expression expr;
		if(Parse.accept(KeyWord.PLUS,KeyWord.MINUS)) {
			KeyWord opr=Parse.prevToken.getKeyWord();
			if(opr==KeyWord.PLUS) expr=parseMULDIV();
			else expr=UnaryOperation.create(opr,parseMULDIV());
		} else expr = parseMULDIV();
		return(expr);
	}

	// Term  =  Factor  {  ( * | / | // )  Factor }
	private static Expression parseMULDIV() {
		Expression expr=parseEXPON();
		while(Parse.accept(KeyWord.MUL,KeyWord.DIV,KeyWord.INTDIV)) {
			KeyWord opr=Parse.prevToken.getKeyWord();
			expr=ArithmeticExpression.create(expr,opr,parseEXPON());
			//expr=ArithmeticOperation.newArithmeticOperation(expr,opr,parseEXPON());
		}
		return(expr);
	}

	// Factor  =  BasicExpression  { **  BasicExpression }
	private static Expression parseEXPON() {
		Expression expr=parseBASICEXPR();
		while(Parse.accept(KeyWord.EXP))
			expr=ArithmeticExpression.create(expr,KeyWord.EXP,parseBASICEXPR());
		//expr=ArithmeticOperation.newArithmeticOperation(expr,KeyWord.EXP,parseBASICEXPR());
		return(expr);
	}


	/**
	 * Parse basic expression.
	 * <pre>
	 *  BasicExpression  =  PrimaryExpression  |  {  RemoteIdentifier  |  ObjectRelation  |  QualifiedObject   }
	 *		RemoteIdentifier =  PrimaryExpression  .  AttributeIdentifier
	 *		ObjectRelation   =  PrimaryExpression ( IS | IN )  ClassIdentifier
	 *		QualifiedObject  =  PrimaryExpression  QUA  ClassIdentifier
	 * 
	 *  PrimaryExpression =  ( Expression ) | Constant | ObjectGenerator | LocalObject | Variable | SubscriptedVariable
	 *		Constant = IntegerConstant | RealConstant | CharacterConstant | TextConstant | BooleanConstant | SymbolicValue  
	 *				BooleanConstant = TRUE | FALSE
	 *				SymbolicValue   = NONE | NOTEXT
	 *                ... other constants as delivered by the scanner
	 *		ObjectGenerator  =  NEW  Identifier  "("  Expression  {  ,  Expression  }  ")"
	 *		LocalObject = THIS ClassIdentifier
	 *		Variable  =  Identifier
	 *		SubscriptedVariable  =  Identifier  "("  Expression  {  ,  Expression  }  ")"
	 * </pre>
	 * @return Expression or null if no expression is found.
	 */
	private static Expression parseBASICEXPR() {
		// Dette er vel kanskje det samme som “primary”?
		// Merk: Alt som kan stå foran et postfix (DOT, IS, IN og QUA) må være et BASICEXPR
		if(Option.TRACE_PARSE) Parse.TRACE("Expression: parseBasicExpression");
		Expression expr=null;
		if(Parse.accept(KeyWord.BEGPAR)) { expr = parseExpression(); Parse.expect(KeyWord.ENDPAR); }
		else if(Parse.accept(KeyWord.INTEGERKONST)) expr = new Constant(Type.Integer,Parse.prevToken.getValue());
		else if(Parse.accept(KeyWord.REALKONST)) expr = Constant.createRealType(Parse.prevToken.getValue());
		else if(Parse.accept(KeyWord.BOOLEANKONST)) expr = new Constant(Type.Boolean,Parse.prevToken.getValue());
		else if(Parse.accept(KeyWord.CHARACTERKONST)) expr = new Constant(Type.Character,Parse.prevToken.getValue());
		else if(Parse.accept(KeyWord.TEXTKONST)) expr = new Constant(Type.Text,Parse.prevToken.getValue());
		else if(Parse.accept(KeyWord.NONE)) expr = new Constant(Type.Ref,null);
		else if(Parse.accept(KeyWord.NOTEXT)) expr = new Constant(Type.Text,null);
		else if(Parse.accept(KeyWord.NEW)) expr =ObjectGenerator.parse();
		else if(Parse.accept(KeyWord.THIS)) expr =LocalObject.acceptThisIdentifier(); 
		else { String ident=Parse.acceptIdentifier();
			if(ident!=null) expr=Variable.parse(ident);
			else {
				if(Option.TRACE_PARSE) Parse.TRACE("Expression: parseBASICEXPR returns: NULL, prevKeyword="+Parse.prevToken.getKeyWord());
				if(Parse.prevToken.getKeyWord()==KeyWord.SEMICOLON) Parse.skipMisplacedCurrentSymbol(); // Ad'Hoc
				return(null);
			}
		}
		// Så kan det komme en sekvens av postfikser, som bygger tre “oppover mot høyre”
		while (Parse.acceptPostfixOprator()) {
			KeyWord opr=Parse.prevToken.getKeyWord(); // opr == DOT || opr== IS || opr == IN || opr == QUA
			if (opr == KeyWord.DOT ) 
				expr=new RemoteVariable(expr,parseVariable());
			else {  // Vet at opr == IS or opr == IN or opr == QUA.  Alle skal ha et klassenavn etter seg
				String classIdentifier=Parse.expectIdentifier();
				if(opr==KeyWord.QUA)
					expr=new QualifiedObject(expr,classIdentifier);
				else expr=new ObjectRelation(expr,opr,classIdentifier);
			}
		}
		if(Option.TRACE_PARSE) Parse.TRACE("Expression: parseBasicExpression returns: "+expr);
		return(expr);
	}
  
	/**
	 * <pre>
	 * Variable  =  Identifier  |  SubscriptedVariable
	 *	SubscriptedVariable  =  Identifier  "("  Expression  {  ,  Expression  }  ")"
	 * </pre>
	 * NOTE: That a SubscriptedVariable may be an subscripted array or a function designator.
	 * @return
	 */
	private static Variable parseVariable() { 
		// Et navn med valgfri argument-parentes etter.  Er også det som kan stå etter DOT
		// Altså: Enkelt-variabel, array-aksess eller prosedyre-kall. 
		String ident=Parse.expectIdentifier();
		return(Variable.parse(ident));
	}


	/**
	 * Get a writeable variable.
	 * <p>
	 * This method is redefined in Variable, RemoteVariable and TypeConversion
	 * @return a writeable variable or null
	 */
	public Variable getWriteableVariable() { return(null); } 

	private static ClassDeclaration getQualification(final Expression simpleObjectExpression) {
		String refIdent=simpleObjectExpression.type.getRefIdent();
		Declaration objDecl = Global.getCurrentScope().findMeaning(refIdent).declaredAs;
		if(objDecl instanceof ClassDeclaration cls)	return(cls);
		Util.error("Illegal ref(" + refIdent + "): " + refIdent + " is not a class");
		return(null);
	}

	/**
	 * Get qualification.
	 * @param classIdentifier a class identifier
	 * @return the ClassDeclaration with same identifier
	 */
	public static ClassDeclaration getQualification(final String classIdentifier) {
		Declaration classDecl=Global.getCurrentScope().findMeaning(classIdentifier).declaredAs;
		if(classDecl instanceof ClassDeclaration cls) return(cls);
		Util.error("Illegal: " + classIdentifier + " is not a class");
		return(null);
	}

	/**
	 * Check compatibility between simpleObjectExpression and a classDeclaration.
	 * @param simpleObjectExpression a simple object expression
	 * @param classIdentifier a class identifier
	 * @return true if compatible, otherwise false
	 */
	public static boolean checkCompatibility(final Expression simpleObjectExpression,final String classIdentifier) {
		ClassDeclaration objDecl=getQualification(simpleObjectExpression);
		ClassDeclaration quaDecl=getQualification(classIdentifier);
		if(quaDecl==objDecl) ; // Nothing: Util.warning("Unneccessary QUA/IS/IN "+ classIdentifier);
		else if(quaDecl==null) Util.error("Illegal QUA -- " + classIdentifier + " is not a class");
		else if(!(objDecl.isCompatibleClasses(quaDecl))) return(false);
		return(true);
	}

	/**
	 * Try to Compile-time Evaluate this expression
	 * @return the resulting evaluated expression
	 */
	public Expression evaluate() { return(this); }

	/**
	 * Returns true if this expression may be used as a statement.
	 * @return true if this expression may be used as a statement
	 */
	public abstract boolean maybeStatement();

	/**
	 * Generate code for getting the value of this Expression
	 * @return the resulting Java code
	 */
	protected String get() {
		return (this.toJavaCode());
	}

	/**
	 * Generate code for putting the value into this Expression
	 * @param evaluated a evaluated expression.
	 * @return the resulting Java code
	 */
	String put(String evaluated) {
		return (this.toJavaCode() + '=' + evaluated);
	}
	
	/**
	 * Try to evaluate this expression to a number.
	 * @return the resulting number or null
	 */
    public Number getNumber() {
    	if(this instanceof UnaryOperation u) {
    		if(u.oprator==KeyWord.MINUS) {
    			Number val=u.operand.getNumber();
    			if(val!=null) return(-val.intValue());
    		}
    	} else if(this instanceof Constant cnst) {
		    if(cnst.value instanceof Number num) return(num);
	    } else if(this instanceof Variable var) {
		    Meaning meaning=Global.getCurrentScope().findMeaning(var.identifier);
		    if(meaning==null) return(null);
		    Declaration declaredAs=meaning.declaredAs;
		    if(declaredAs instanceof SimpleVariableDeclaration tp) {
			    Expression constElt=tp.constantElement;
			    if(constElt!=null && constElt instanceof Constant cnst)
			    	if(cnst.value instanceof Number num) return(num);
		    }
		    return(null);
	    } else if(this instanceof TypeConversion conv) {
	    	return(conv.expression.getNumber()); // Hva hvis   (int)3.14  som real
	    }
	    return(null);
    }
	
	/**
	 * Try to evaluate this expression to an integer.
	 * @return the resulting int or 0
	 */
	public int getInt() {
		if(this instanceof Constant cnst) {
			if(cnst.value instanceof Number num)	return(num.intValue());
			if(cnst.value instanceof Character chr) return((int)chr.charValue());
		}
		if(this instanceof Variable var) {
			Meaning meaning=var.meaning;
			Declaration declaredAs=meaning.declaredAs;
			if(declaredAs instanceof SimpleVariableDeclaration tp) {
				Expression constElt=tp.constantElement;
				if(constElt!=null) {
					if(constElt instanceof Constant constant) {
						Object value=constant.value;
						if(value instanceof Number num)	return(num.intValue());
						if(value instanceof Character chr) return((int)chr.charValue());
					}
				}
			}
		}
		Util.error("Expression: "+this+" is not a Constant");
		return(0);
	}

    
}
