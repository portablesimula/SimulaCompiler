/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.util.Enumeration;
import java.util.Iterator;
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
 * Array Declaration.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 * ArrayDeclaration = [ Type ] ARRAY ArraySegment { , ArraySegment }
 *   ArraySegment = IdentifierList "(" BoundPairList ")"
 * 
 * 	IdentifierList = Identifier { , Identifier }
 * 
 * 	BoundPairList = BoundPair { , BoundPair }
 * 	 BoundPair = ArithmeticExpression : ArithmeticExpression
 *
 * </pre>
 * 
 * An array declaration declares one or several identifiers to represent
 * multi-dimensional arrays of subscripted variables and gives the dimensions of
 * the arrays, the bounds of the subscripts, and the type of the variables.
 * <p>
 * The subscript bounds for any array are given in the first subscript brackets
 * following the identifier of this array in the form of a bound pair list. Each
 * bound pair gives the lower bound of a subscript followed by : followed by the
 * upper bound. The bound pair list gives the bounds of all subscripts taken in
 * order from left to right.
 * <p>
 * NOTE: An initial "-" in upper bound may follow : directly (cf. 1.3).
 * The scanner will treat ":-" within parentheses (round brackets) as two
 * separate symbols ":" and "-" thus solving this ambiguity in the syntax. 
 * <p>
 * The dimension is given as the number of entries in the bound pair lists.
 * <p>
 * All arrays declared in one declaration are of the same quoted type. If no
 * type declarator is given the type real is understood.
 * <p>
 * The expressions are evaluated in the same way as subscript expressions. This
 * evaluation takes place once at each entrance into the block through the block
 * head. The expressions cannot include any identifier that is declared, either
 * explicitly or implicitly, in the same block head as the array in question.
 * <p>
 * An array has elements only when the values of all upper bounds are not
 * smaller than those of the corresponding lower bounds. If any lower bound
 * value is greater than the corresponding upper bound value, the array has no
 * elements. An attempt to access an element of an empty array leads to a
 * run-time error. The array may, however, be created at block entry and it may
 * be passed as a parameter.
 * <p>
 * The value of an array identifier is the ordered set of values of the
 * corresponding array of subscripted variables.
 * 
 * <pre>
 * Examples
 * 
 *           integer array a(2:20)                    ! 19 elements;
 *           real array  q(-7:if c<0 then 2 else 1)   ! 10 or 9 elements;
 *           array  a,b,c(7:n,2:m), s(-2:10)      ! any value of n or m legal;
 * </pre>
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public final class ArrayDeclaration extends Declaration {
	// Type type; inherited
	Vector<BoundPair> boundPairList;
	public int nDim() { return(boundPairList.size()); }

	public Vector<BoundPair> getBoundPairList() {
		return (boundPairList);
	}

	private ArrayDeclaration(String identifier, Type type,
			Vector<BoundPair> boundPairList) {
		super(identifier);
		this.type=type;
		this.boundPairList = boundPairList;
		if (Option.TRACE_PARSE)
			Util.TRACE("END NEW ArrayDeclaration: " + toString());
	}

	public static void parse(Type type, Vector<Declaration> declarationList) {
		if (Option.TRACE_PARSE)
			Util.TRACE("Parse ArrayDeclaration, type=" + type + ", current="
					+ Parser.currentToken);
		do {
			parseArraySegment(type, declarationList);
		} while (Parser.accept(KeyWord.COMMA));
	}

	private static void parseArraySegment(Type type,
			Vector<Declaration> declarationList) {
		if (Option.TRACE_PARSE)
			Parser.TRACE("Parse ArraySegment");
		// IdentifierList = Identifier { , Identifier }
		Vector<String> identList = new Vector<String>();
		do {
			identList.add(expectIdentifier());
		} while (Parser.accept(KeyWord.COMMA));
		Parser.expect(KeyWord.BEGPAR);
		// BoundPairList = BoundPair { , BoundPair }
		if (Option.TRACE_PARSE)	Parser.TRACE("Parse BoundPairList");
		Vector<BoundPair> boundPairList = new Vector<BoundPair>();
		do {
			Expression LB = Expression.parseExpression();
			Parser.expect(KeyWord.COLON);
			Expression UB = Expression.parseExpression();
			boundPairList.add(new BoundPair(LB, UB));
		} while (Parser.accept(KeyWord.COMMA));
		Parser.expect(KeyWord.ENDPAR);
		for (Enumeration<String> e = identList.elements(); e.hasMoreElements();) {
			String identifier = e.nextElement();
			declarationList.add(new ArrayDeclaration(identifier.toString(),type, boundPairList));
		}
	}

	public static class BoundPair {
		// BoundPair = ArithmeticExpression : ArithmeticExpression
		public Expression LB, UB;

		public Expression getLowerBound() {
			return (LB);
		}

		BoundPair(Expression LB, Expression UB) {
			this.LB = LB;
			this.UB = UB;
		}

		public void doChecking() {
			// TODO: Hvis konstante grenser s� eveluerer vi her !
			LB.doChecking();
			UB.doChecking();
			//Util.warning("Only Arrays with lower bound zero is fully supported");
			LB=(Expression)TypeConversion.testAndCreate(Type.Integer,LB);
			UB=(Expression)TypeConversion.testAndCreate(Type.Integer,UB);

			// TODO: Her mangler mye
		}

		public String toString() {
			return ("" + LB + ':' + UB);
		}
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		if (type == null) type=Type.Real;
		for (Iterator<BoundPair> it = boundPairList.iterator(); it.hasNext();) {
			it.next().doChecking();
		}
		SET_SEMANTICS_CHECKED();
	}

    public void doJavaCoding() // TODO: NEW ARRAY CODE
	{ Global.sourceLineNumber=lineNumber;
	  ASSERT_SEMANTICS_CHECKED(this);
	  // --------------------------------------------------------------------
	  // public ARRAY$<float[]> Tab=null;
	  // --------------------------------------------------------------------
	  String arrType=this.type.toJavaType();
	  int nDim=boundPairList.size();
	  for(int i=0;i<nDim;i++) arrType=arrType+"[]";
	  String arrayIdent=this.getJavaIdentifier();
	  arrType="ARRAY$<"+arrType+'>';
	  JavaModule.code("public "+arrType+""+arrayIdent+"=null;");
	}

    public void doDeclarationCoding() // TODO: NEW ARRAY CODE
	{ Global.sourceLineNumber=lineNumber;
	  ASSERT_SEMANTICS_CHECKED(this);
	  // --------------------------------------------------------------------
	  // integer array A(1:4,4:6,6:12);
	  // --------------------------------------------------------------------
	  // int[] A$LB=new int[3]; int[] A$UB=new int[3];
	  // A$LB[0]=1; A$UB[0]=4;
	  // A$LB[1]=4; A$UB[1]=6;
	  // A$LB[2]=6; A$UB[2]=12;
	  // A=new ARRAY$<int[][][]>(new int[A$UB[0]-A$LB[0]+1][A$UB[1]-A$LB[1]+1][A$UB[2]-A$LB[2]+1],A$LB,A$UB);
	  // --------------------------------------------------------------------
	  String arrayIdent=this.getJavaIdentifier();
	  String arrType=this.type.toJavaType();
	  String arrGen=arrType;
	  int nDim=boundPairList.size();
	  JavaModule.code("int[] "+arrayIdent+"$LB=new int["+nDim+"]; int[] "+arrayIdent+"$UB=new int["+nDim+"];");
	  int n=0;
	  for(BoundPair boundPair:boundPairList)
	  {	arrType=arrType+"[]";
	    String LBid=arrayIdent+"$LB["+n+"]";
	    String UBid=arrayIdent+"$UB["+(n++)+"]";
		String size=UBid+"-"+LBid+"+1";
		arrGen=arrGen+'['+size+']';
		JavaModule.code(""+LBid+'='+boundPair.LB.toJavaCode()+"; "+UBid+'='+boundPair.UB.toJavaCode()+';');
	  }	
	  arrType="ARRAY$<"+arrType+'>';
	  JavaModule.code(""+arrayIdent+"=new "+arrType+"(new "+arrGen+","+arrayIdent+"$LB,"+arrayIdent+"$UB);");
	}

	public String toString() {
		String s = "ARRAY " + identifier + boundPairList;
		if (type != null)
			s = type.toString() + " " + s;
		return (s);
	}
}
