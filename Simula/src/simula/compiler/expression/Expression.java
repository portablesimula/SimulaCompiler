/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import simula.compiler.SyntaxClass;
import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.declaration.Declaration;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
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
 *
 *  SimpleExpression  =  BooleanTertiary  { OR ELSE  BooleanTertiary }
 *  BooleanTertiary   =  Equivalence  { AND THEN  Equivalence }
 *  Equivalence       =  Implication  { EQV  Implication }
 *  Implication       =  BooleanTerm  { IMP  BooleanTerm }
 *  BooleanTerm       =  BooleanFactor  { OR  BooleanFactor }
 *  BooleanFactor     =  BooleanSecondary  { AND  BooleanSecondary }
 *  BooleanSecondary  =  [ NOT ]  BooleanPrimary
 *  BooleanPrimary    =  SimpleArithmeticExpression  [ RelationOperator  SimpleArithmeticExpression ]
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
public abstract class Expression extends SyntaxClass
{ public SyntaxClass backLink; // True: This Expression is part of <backLink>Expression/Statement

  public String toString() { return("NO EXPRESSION"); }
	
  /**
   * <pre>
   * Expression  =  SimpleExpression
   *	         |  IF  BooleanExpression  THEN  SimpleExpression  ELSE  Expression
   * </pre>
   * @return Expression or null if no expression is found.
   */
  public static Expression parseExpression()
  { if(Parser.accept(KeyWord.IF))
    { Expression condition=parseExpression();
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
   *  BooleanPrimary    =  SimpleArithmeticExpression  [ RelationOperator  SimpleArithmeticExpression ]
   *       RelationOperator  =  <  |  <=  |  =  |  >=  |  >  |  <> |  ==  |  =/=
   *  SimpleArithmeticExpression  =  [ + | - ]  Term  {  ( + | - )  Term }
   *  Term    =  Factor  {  ( * | / | // )  Factor }
   *  Factor  =  BasicExpression  { **  BasicExpression }
   * </pre>             
   *        
   * @return Expression or null if no expression is found.
   */
  protected static Expression parseSimpleExpression()
  { //Parser.BREAK("Expression: parseSimpleExpression");   
	  Expression retExpr = parseANDTHEN();
      while(Parser.accept(KeyWord.OR_ELSE))  {
    	  retExpr=new BinaryOperation(retExpr,KeyWord.OR_ELSE,parseANDTHEN());
      }
      return retExpr;
  }

  //BooleanTertiary =  Equivalence  { AND THEN  Equivalence }
  private static Expression parseANDTHEN() {   // Metode-form 9: Kan ha en eller flere operander, tolkes venstreassos.
	 Util.BREAK("Expression.parseANDTHEN");
     Expression retExpr = parseEQV();
     while(Parser.accept(KeyWord.AND_THEN))  {
          retExpr=new BinaryOperation(retExpr,KeyWord.AND_THEN,parseEQV());
     }
     return retExpr;
  }

  //  Equivalence  =  Implication  { EQV  Implication }
  private static Expression parseEQV() {   // Metode-form 2: Kan ha EN eller TO operander
	 Util.BREAK("Expression.parseEQV");
	 Expression retExpr=parseIMP();
//   if  -- MYH: Måtte bytte denne til While !!
     while(Parser.accept(KeyWord.EQV)) {
          retExpr=new BinaryOperation(retExpr,KeyWord.EQV,parseIMP());
	 }
	 return retExpr;
  }

  // Implication =  BooleanTerm  { IMP  BooleanTerm }
  private static Expression parseIMP() {   // Metode-form 2: Kan ha EN eller TO operander
	 Util.BREAK("Expression.parseIMP");
	 Expression retExpr=parseOR();
//     if  -- MYH: Måtte bytte denne til While !!
     while
     (Parser.accept(KeyWord.IMP)) {
          retExpr=new BinaryOperation(retExpr,KeyWord.IMP,parseOR());
	 }
	 return retExpr;
  }

  // BooleanTerm  =  BooleanFactor  { OR  BooleanFactor }
  private static Expression parseOR() {   // Metode-form 9: Kan ha en eller flere operander, tolkes venstreassos.
	 Expression retExpr=parseAND();
     while(Parser.accept(KeyWord.OR)) {
          retExpr=new BinaryOperation(retExpr,KeyWord.OR,parseAND());
	 }
	 return retExpr;
  }

  // BooleanFactor =  BooleanSecondary  { AND  BooleanSecondary }
  private static Expression parseAND() {   // Metode-form 9: Kan ha en eller flere operander, tolkes venstreassos.
	 Expression retExpr=parseNOT();
     while(Parser.accept(KeyWord.AND)) {
          retExpr=new BinaryOperation(retExpr,KeyWord.AND,parseNOT());
	 }
	 return retExpr;
  }

  // BooleanSecondary  =  [ NOT ]  BooleanPrimary
  private static Expression  parseNOT() {   // Metode-form 1:  Unær prefiks-operasjon, EN operand
	 Expression retExpr;
     if(Parser.accept(KeyWord.NOT)) {
          retExpr=new UnaryOperation(KeyWord.NOT,parseREL());
     } else {
          retExpr = parseREL();
     }
     return retExpr;
  }

  // BooleanPrimary =  SimpleArithmeticExpression  [ RelationOperator  SimpleArithmeticExpression ]
  //  RelationOperator  =  <  |  <=  |  =  |  >=  |  >  |  <> |  ==  |  =/=
  private static Expression parseREL() {   // Metode-form      
	 Expression retExpr = parseADDSUB();
	 if(Parser.acceptRelationalOperator())   {  // Om det er en av relasjons-operasjonene
	      KeyWord opr=Parser.prevToken.getKeyWord();
	      retExpr=new BinaryOperation(retExpr,opr,parseADDSUB());
	 }
	 return retExpr;
  }

  // SimpleArithmeticExpression  =  [ + | - ]  Term  {  ( + | - )  Term }
  private static Expression parseADDSUB() {   // Metode-form 9: Kan ha en eller flere operander, tolkes venstreassos.
	 Expression retExpr=parseUNIADDSUB();
     while(Parser.accept(KeyWord.PLUS,KeyWord.MINUS,KeyWord.CONC)) {  // MYH: Måtte legge til  CONC
	      KeyWord opr=Parser.prevToken.getKeyWord();
          retExpr=new BinaryOperation(retExpr,opr,parseUNIADDSUB());
	 }
	 return retExpr;
  }

  private static Expression parseUNIADDSUB() {   // Metode-form 1:  Unær prefiks-operasjon, EN operand
	 Expression retExpr;
     if(Parser.accept(KeyWord.PLUS,KeyWord.MINUS)) {
	      KeyWord opr=Parser.prevToken.getKeyWord();
          retExpr=new UnaryOperation(opr,parseMULDIV());
     } else {
          retExpr = parseMULDIV();
     }
     return retExpr;
  }

  // Term  =  Factor  {  ( * | / | // )  Factor }
  private static Expression parseMULDIV() {   // Metode-form 9: Kan ha en eller flere operander, tolkes venstreassos.
	 Expression retExpr=parseEXPON();
     while(Parser.accept(KeyWord.MUL,KeyWord.DIV,KeyWord.INTDIV)) {
	      KeyWord opr=Parser.prevToken.getKeyWord();
          retExpr=new BinaryOperation(retExpr,opr,parseEXPON());
	 }
	 return retExpr;
  }

  // Factor  =  BasicExpression  { **  BasicExpression }
  private static Expression parseEXPON() {   // Metode-form 9: Kan ha en eller flere operander, tolkes venstreassos.
	 Expression retExpr=parseBASICEXPR();
     while(Parser.accept(KeyWord.EXP)) {
          retExpr=new BinaryOperation(retExpr,KeyWord.EXP,parseBASICEXPR());
	 }
	 return retExpr;
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
  private static Expression parseBASICEXPR() {      // Dette er vel kanskje det samme som “primary”?
	 // Merk: Alt som kan stå foran et postfix (DOT, IS, IN og QUA) må være et BASICEXPR
     if(Option.TRACE_PARSE) Parser.TRACE("Expression: parseBasicExpression");
	 Expression retExpr=null;
	 if(Parser.accept(KeyWord.BEGPAR)) { retExpr = parseExpression(); Parser.expect(KeyWord.ENDPAR); }
	 else if(Parser.accept(KeyWord.INTEGERKONST)) retExpr = new Constant(Type.Integer,Parser.prevToken.getValue());
	 else if(Parser.accept(KeyWord.REALKONST)) retExpr = Constant.createRealType(Parser.prevToken.getValue());
	 else if(Parser.accept(KeyWord.BOOLEANKONST)) retExpr = new Constant(Type.Boolean,Parser.prevToken.getValue());
	 else if(Parser.accept(KeyWord.CHARACTERKONST)) retExpr = new Constant(Type.Character,Parser.prevToken.getValue());
	 else if(Parser.accept(KeyWord.TEXTKONST)) retExpr = new Constant(Type.Text,Parser.prevToken.getValue());
	 else if(Parser.accept(KeyWord.NONE)) retExpr = new Constant(Type.Ref,null);
	 else if(Parser.accept(KeyWord.NOTEXT)) retExpr = new Constant(Type.Text,null);
     else if(Parser.accept(KeyWord.NEW)) retExpr =ObjectGenerator.parse();
     else if(Parser.accept(KeyWord.THIS)) retExpr =LocalObject.acceptThisIdentifier(); 
	 else { String ident=acceptIdentifier();
	        if(ident!=null) retExpr=Variable.parse(ident);
	        else { if(Option.TRACE_PARSE) Parser.TRACE("Expression: parseBasicExpression returns: NULL");
	    	       return(null);
	        }
	 }
	 // Så kan det komme en sekvens av postfikser, som bygger tre “oppover mot høyre”
	 while (Parser.acceptPostfixOprator()) {
	      KeyWord opr=Parser.prevToken.getKeyWord(); // opr == DOT || opr== IS || opr == IN || opr == QUA
	      if (opr == KeyWord.DOT ) 
	           retExpr=new BinaryOperation(retExpr,KeyWord.DOT,parseVARARRCALL());
	      else {  // Vet at opr == IS or opr == IN or opr == QUA.  Alle skal ha et klassenavn etter seg
	    	   String classIdentifier=expectIdentifier();
	           retExpr=new BinaryISINQUAOperation(retExpr,opr,classIdentifier);
	      }
	 }
     if(Option.TRACE_PARSE) Parser.TRACE("Expression: parseBasicExpression returns: "+retExpr);
	 return(retExpr);
  }
  
  private static Expression parseVARARRCALL() { 
	  // Et navn med valgfri argument-parentes etter.  Er også det som kan stå etter DOT
	  // Altså: Enkelt-variabel, array-aksess eller prosedyre-kall. 
	  String ident=expectIdentifier();
      return(Variable.parse(ident));
  }
  
  public boolean isRemoteVariable() { return(false); }  // Is redefined in BinaryOperation(DOT)
  public Variable getVariable() // { return(null); } // Is redefined in (Variable and) BinaryOperation(DOT)
  { if(this instanceof Variable) return((Variable)this);
	return(null);
  }

  private static BlockDeclaration getQualification(Expression simpleObjectExpression) {
		String refIdent=simpleObjectExpression.type.getRefIdent();
		Declaration objDecl = Global.currentScope.findMeaning(refIdent).declaredAs;
		if(objDecl instanceof BlockDeclaration)	return((BlockDeclaration)objDecl);
		Util.error("Illegal ref(" + refIdent + "): " + refIdent + " is not a class");
		return(null);
  }
	  
  public static BlockDeclaration getQualification(String classIdentifier) {
		Declaration classDecl=Global.currentScope.findMeaning(classIdentifier).declaredAs;
		if(classDecl instanceof BlockDeclaration) return((BlockDeclaration)classDecl);
			Util.error("Illegal: " + classIdentifier + " is not a class");
		return(null);
  }
	  
  public static boolean checkCompatability(Expression simpleObjectExpression,String classIdentifier) {
		BlockDeclaration objDecl=getQualification(simpleObjectExpression);
		BlockDeclaration quaDecl=getQualification(classIdentifier);
		if(quaDecl==objDecl) Util.warning("Unneccessary QUA "+ classIdentifier);
		else if(quaDecl==null) Util.error("Illegal QUA -- " + classIdentifier + " is not a class");
		else if(!(objDecl.isCompatibleClasses(quaDecl))) return(false);
		return(true);
  }
  
  // Generate code for getting the value of this Expression
  public String get()
  { return(this.toJavaCode()); }

  // Generate code for putting the value into this Expression
  public String put(String evaluated)
  { return(this.toJavaCode()+'='+evaluated); }

}
