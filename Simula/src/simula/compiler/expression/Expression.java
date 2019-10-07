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
import simula.compiler.parsing.Parser;
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
 *  BooleanPrimary    =  TextPrimary  { & TextPrimary }
 *  TextPrimary       =  SimpleArithmeticExpression  [ RelationOperator  SimpleArithmeticExpression ]
 *       RelationOperator  =  <  |  <=  |  =  |  >=  |  >  |  <> |  ==  |  =/=
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
 * 
 * @author Øystein Myhre Andersen
 * @author Stein Krogdahl
 */
public abstract class Expression extends SyntaxClass {
	public SyntaxClass backLink; // True: This Expression is part of <backLink>Expression/Statement

	public String toString() { return("NO EXPRESSION"); }

	/**
	 * <pre>
	 * Expression  =  SimpleExpression
	 *	         |  IF  BooleanExpression  THEN  SimpleExpression  ELSE  Expression
	 * </pre>
	 * @return Expression or null if no expression is found.
	 */
	public static Expression parseExpression() {
		if(Parser.accept(KeyWord.IF)) {
			Expression condition=parseExpression();
			Parser.expect(KeyWord.THEN); Expression thenExpression=parseSimpleExpression();
			Parser.expect(KeyWord.ELSE); Expression elseExpression=parseExpression();
			Expression expr=new ConditionalExpression(Type.Boolean,condition,thenExpression,elseExpression);
			if(Option.TRACE_PARSE) Util.TRACE("Expression: ParseExpression, result="+expr);
			return(expr);
		} else return(parseSimpleExpression());
	}  

	/**
	 * <pre>
	 *  SimpleExpression  =  BooleanTertiary  { OR ELSE  BooleanTertiary }
	 *  BooleanTertiary   =  Equivalence  { AND THEN  Equivalence }
	 *  Equivalence       =  Implication  { EQV  Implication }
	 *  Implication       =  BooleanTerm  { IMP  BooleanTerm }
	 *  BooleanTerm       =  BooleanFactor  { OR  BooleanFactor }
	 *  BooleanFactor     =  BooleanSecondary  { AND  BooleanSecondary }
	 *  BooleanSecondary  =  [ NOT ]  BooleanPrimary
	 *  BooleanPrimary    =  TextPrimary  { & TextPrimary }
	 *  TextPrimary       =  SimpleArithmeticExpression  [ RelationOperator  SimpleArithmeticExpression ]
	 *       RelationOperator  =  <  |  <=  |  =  |  >=  |  >  |  <> |  ==  |  =/=
	 *  SimpleArithmeticExpression  =  [ + | - ]  Term  {  ( + | - )  Term }
	 *  Term    =  Factor  {  ( * | / | // )  Factor }
	 *  Factor  =  BasicExpression  { **  BasicExpression }
	 * </pre>             
	 *        
	 * @return Expression or null if no expression is found.
	 */
	protected static Expression parseSimpleExpression()  {   
		Expression expr = parseANDTHEN();
		while(Parser.accept(KeyWord.OR_ELSE))  {
			expr=new BooleanOperation(expr,KeyWord.OR_ELSE,parseANDTHEN());
		}
		return(expr);
	}

	// BooleanTertiary =  Equivalence  { AND THEN  Equivalence }
	private static Expression parseANDTHEN() {
		Expression expr = parseEQV();
		while(Parser.accept(KeyWord.AND_THEN))
			expr=new BooleanOperation(expr,KeyWord.AND_THEN,parseEQV());
		return(expr);
	}

	// Equivalence  =  Implication  { EQV  Implication }
	private static Expression parseEQV() { 
		Expression expr=parseIMP();
		while(Parser.accept(KeyWord.EQV))
			expr=new BooleanOperation(expr,KeyWord.EQV,parseIMP());
		return(expr);
	}

	// Implication =  BooleanTerm  { IMP  BooleanTerm }
	private static Expression parseIMP() {
		Expression expr=parseOR();
		while(Parser.accept(KeyWord.IMP))
			expr=new BooleanOperation(expr,KeyWord.IMP,parseOR());
		return(expr);
	}

	// BooleanTerm  =  BooleanFactor  { OR  BooleanFactor }
	private static Expression parseOR() {
		Expression expr=parseAND();
		while(Parser.accept(KeyWord.OR))
			expr=new BooleanOperation(expr,KeyWord.OR,parseAND());
		return(expr);
	}

	// BooleanFactor =  BooleanSecondary  { AND  BooleanSecondary }
	private static Expression parseAND() {
		Expression expr=parseNOT();
		while(Parser.accept(KeyWord.AND))
			expr=new BooleanOperation(expr,KeyWord.AND,parseNOT());
		return(expr);
	}

	// BooleanSecondary  =  [ NOT ]  BooleanPrimary
	private static Expression  parseNOT() {
		Expression expr;
		if(Parser.accept(KeyWord.NOT)) {
			expr=new UnaryOperation(KeyWord.NOT,parseTEXTCONC());
		} else expr = parseTEXTCONC();
		return(expr);
	}

	// BooleanPrimary  =  TextPrimary  { & TextPrimary }
	private static Expression parseTEXTCONC() {
		Expression expr=parseREL();
		while(Parser.accept(KeyWord.CONC))
			expr=new TextOperation(expr,parseREL());
		return(expr);
	}

	// TextPrimary =  SimpleArithmeticExpression  [ RelationOperator  SimpleArithmeticExpression ]
	//    RelationOperator  =  <  |  <=  |  =  |  >=  |  >  |  <> |  ==  |  =/=
	private static Expression parseREL() {   // Metode-form      
		Expression expr = parseAdditiveOperation();
		if(Parser.acceptRelationalOperator())   { 
			KeyWord opr=Parser.prevToken.getKeyWord();
			expr=new RelationalOperation(expr,opr,parseAdditiveOperation());
		}
		return(expr);
	}

	// SimpleArithmeticExpression  =  [ + | - ]  Term  {  ( + | - )  Term }
	// SimpleArithmeticExpression  =  UnaryTerm  {  ( + | - )  Term }
	private static Expression parseAdditiveOperation() {
		Expression expr=parseUNIMULDIV();
		while(Parser.accept(KeyWord.PLUS,KeyWord.MINUS)) { 
			KeyWord opr=Parser.prevToken.getKeyWord();
			expr=new ArithmeticOperation(expr,opr,parseMULDIV());
		}
		return(expr);
	}

	// UnaryTerm  =  [ + | - ]  Term
	private static Expression parseUNIMULDIV() {
		Expression expr;
		if(Parser.accept(KeyWord.PLUS,KeyWord.MINUS)) {
			KeyWord opr=Parser.prevToken.getKeyWord();
			if(opr==KeyWord.PLUS) expr=parseMULDIV();
			else expr=new UnaryOperation(opr,parseMULDIV());
		} else expr = parseMULDIV();
		return(expr);
	}

	// Term  =  Factor  {  ( * | / | // )  Factor }
	private static Expression parseMULDIV() {
		Expression expr=parseEXPON();
		while(Parser.accept(KeyWord.MUL,KeyWord.DIV,KeyWord.INTDIV)) {
			KeyWord opr=Parser.prevToken.getKeyWord();
			expr=new ArithmeticOperation(expr,opr,parseEXPON());
			//expr=ArithmeticOperation.newArithmeticOperation(expr,opr,parseEXPON());
		}
		return(expr);
	}

	// Factor  =  BasicExpression  { **  BasicExpression }
	private static Expression parseEXPON() {
		Expression expr=parseBASICEXPR();
		while(Parser.accept(KeyWord.EXP))
			expr=new ArithmeticOperation(expr,KeyWord.EXP,parseBASICEXPR());
		//expr=ArithmeticOperation.newArithmeticOperation(expr,KeyWord.EXP,parseBASICEXPR());
		return(expr);
	}


	/**
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
		if(Option.TRACE_PARSE) Parser.TRACE("Expression: parseBasicExpression");
		Expression expr=null;
		if(Parser.accept(KeyWord.BEGPAR)) { expr = parseExpression(); Parser.expect(KeyWord.ENDPAR); }
		else if(Parser.accept(KeyWord.INTEGERKONST)) expr = new Constant(Type.Integer,Parser.prevToken.getValue());
		else if(Parser.accept(KeyWord.REALKONST)) expr = Constant.createRealType(Parser.prevToken.getValue());
		else if(Parser.accept(KeyWord.BOOLEANKONST)) expr = new Constant(Type.Boolean,Parser.prevToken.getValue());
		else if(Parser.accept(KeyWord.CHARACTERKONST)) expr = new Constant(Type.Character,Parser.prevToken.getValue());
		else if(Parser.accept(KeyWord.TEXTKONST)) expr = new Constant(Type.Text,Parser.prevToken.getValue());
		else if(Parser.accept(KeyWord.NONE)) expr = new Constant(Type.Ref,null);
		else if(Parser.accept(KeyWord.NOTEXT)) expr = new Constant(Type.Text,null);
		else if(Parser.accept(KeyWord.NEW)) expr =ObjectGenerator.parse();
		else if(Parser.accept(KeyWord.THIS)) expr =LocalObject.acceptThisIdentifier(); 
		else { String ident=acceptIdentifier();
			if(ident!=null) expr=Variable.parse(ident);
			else {
				if(Option.TRACE_PARSE) Parser.TRACE("Expression: parseBASICEXPR returns: NULL, prevKeyword="+Parser.prevToken.getKeyWord());
				if(Parser.prevToken.getKeyWord()==KeyWord.SEMICOLON) Parser.skipMissplacedCurrentSymbol(); // Ad'Hoc
				return(null);
			}
		}
		// Så kan det komme en sekvens av postfikser, som bygger tre “oppover mot høyre”
		while (Parser.acceptPostfixOprator()) {
			KeyWord opr=Parser.prevToken.getKeyWord(); // opr == DOT || opr== IS || opr == IN || opr == QUA
			if (opr == KeyWord.DOT ) 
				expr=new RemoteVariable(expr,parseVariable());
			else {  // Vet at opr == IS or opr == IN or opr == QUA.  Alle skal ha et klassenavn etter seg
				String classIdentifier=expectIdentifier();
				if(opr==KeyWord.QUA)
					expr=new QualifiedObject(expr,classIdentifier);
				else expr=new ObjectRelation(expr,opr,classIdentifier);
			}
		}
		if(Option.TRACE_PARSE) Parser.TRACE("Expression: parseBasicExpression returns: "+expr);
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
		String ident=expectIdentifier();
		return(Variable.parse(ident));
	}


	// Is redefined in Variable, RemoteVariable and TypeConversion
	public Variable getWriteableVariable() { return(null); } 

	private static ClassDeclaration getQualification(final Expression simpleObjectExpression) {
		String refIdent=simpleObjectExpression.type.getRefIdent();
		Declaration objDecl = Global.currentScope.findMeaning(refIdent).declaredAs;
		if(objDecl instanceof ClassDeclaration)	return((ClassDeclaration)objDecl);
		Util.error("Illegal ref(" + refIdent + "): " + refIdent + " is not a class");
		return(null);
	}

	public static ClassDeclaration getQualification(final String classIdentifier) {
		Declaration classDecl=Global.currentScope.findMeaning(classIdentifier).declaredAs;
		if(classDecl instanceof ClassDeclaration) return((ClassDeclaration)classDecl);
		Util.error("Illegal: " + classIdentifier + " is not a class");
		return(null);
	}

	public static boolean checkCompatability(final Expression simpleObjectExpression,final String classIdentifier) {
		ClassDeclaration objDecl=getQualification(simpleObjectExpression);
		ClassDeclaration quaDecl=getQualification(classIdentifier);
		if(quaDecl==objDecl) Util.warning("Unneccessary QUA/IS/IN "+ classIdentifier);
		else if(quaDecl==null) Util.error("Illegal QUA -- " + classIdentifier + " is not a class");
		else if(!(objDecl.isCompatibleClasses(quaDecl))) return(false);
		return(true);
	}

	// Try to Compile-time Evaluate this expression
	public Expression evaluate() { return(this); }

	// Returns true if this expression may be used as a statement.
	public abstract boolean maybeStatement();

	// Generate code for getting the value of this Expression
	public String get() {
		return (this.toJavaCode());
	}

	// Generate code for putting the value into this Expression
	public String put(String evaluated) {
		return (this.toJavaCode() + '=' + evaluated);
	}
	
    public Number getNumber() {
    	if(this instanceof UnaryOperation) {
    		UnaryOperation u=(UnaryOperation)this;
    		if(u.oprator==KeyWord.MINUS) {
    			Number val=u.operand.getNumber();
    			return(-val.intValue());
    		}
    	} else if(this instanceof Constant) {
		    Object value=((Constant)this).value;
		    if(value instanceof Number) {
		    	return((Number)value);
		    }
	    } else if(this instanceof Variable) {
		    Variable var=(Variable)this;
		    Meaning meaning=Global.currentScope.findMeaning(var.identifier);
		    if(meaning==null) {
		    	return(null);
		    }
		    Declaration declaredAs=meaning.declaredAs;
		    if(declaredAs instanceof SimpleVariableDeclaration) {
			    SimpleVariableDeclaration tp=(SimpleVariableDeclaration)declaredAs;
			    Expression constElt=tp.constantElement;
			    if(constElt!=null) {
				    if(constElt instanceof Constant) {
					    Object value=((Constant)constElt).value;
					    if(value instanceof Number) {
					    	return((Number)value);
					    }
				    }
			    }
		    }
		    return(null);
	    } else if(this instanceof TypeConversion) {
	    	return(((TypeConversion)this).expression.getNumber()); // TODO: Hva hvis   (int)3.14  som real
	    }
	    return(null);
    }
	
	public int getInt() {
		if(this instanceof Constant) {
			Object value=((Constant)this).value;
			if(value instanceof Number) {
				int intValue=((Number)value).intValue();
				return(intValue);
			} else if(value instanceof Character) {
				char charValue=((Character)value).charValue();
				return((int)charValue);
			}
		}
		if(this instanceof Variable) {
			Variable var=(Variable)this;
			Meaning meaning=var.meaning;
			Declaration declaredAs=meaning.declaredAs;
			if(declaredAs instanceof SimpleVariableDeclaration) {
				SimpleVariableDeclaration tp=(SimpleVariableDeclaration)declaredAs;
				Expression constElt=tp.constantElement;
				if(constElt!=null) {
					if(constElt instanceof Constant) {
						Object value=((Constant)constElt).value;
						if(value instanceof Number) {
							int intValue=((Number)value).intValue();
							return(intValue);
						} else if(value instanceof Character) {
							char charValue=((Character)value).charValue();
							return((int)charValue);
						}
					}
				}
			}
		}
		Util.error("Switch Statement: "+this+" is not a Constant");
		return(0);
	}

    
}
