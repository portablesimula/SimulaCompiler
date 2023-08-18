/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.declaration;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Enumeration;
import java.util.Vector;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.parsing.Parse;
import simula.compiler.syntaxClass.SyntaxClass;
import simula.compiler.syntaxClass.Type;
import simula.compiler.syntaxClass.expression.Expression;
import simula.compiler.syntaxClass.expression.TypeConversion;
import simula.compiler.utilities.DeclarationList;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Array Declaration.
 * 
 * <pre>
 * 
 * Simula Standard: 5.2 Array declaration
 * 
 *   array-declaration = [ type ] ARRAY array-segment { , array-segment }
 *   
 *      array-segment = array-identifier { , array-identifier } "(" bound-pair-list ")"
 *      
 *         array-identifier = identifier
 *         
 *         bound-pair-list = bound-pair { , bound-pair }
 *         
 *            bound-pair = arithmetic-expression : arithmetic-expression 
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
 *           integer array a(2:20)                      ! 19 elements;
 *           real array  q(-7:if c &lt; 0 then 2 else 1)   ! 10 or 9 elements;
 *           array  a,b,c(7:n,2:m), s(-2:10)            ! any value of n or m legal;
 * </pre>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/declaration/ArrayDeclaration.java">
 * <b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public final class ArrayDeclaration extends Declaration implements Externalizable {
	// Type type; inherited

	/**
	 * Number of dimensions.
	 */
	public int nDim;
	
	/**
	 * The list of BoundPair.
	 */
	private Vector<BoundPair> boundPairList;

	/**
	 * Create a new ArrayDeclaration
	 * @param identifier the array identifier
	 * @param type the array type
	 * @param boundPairList The list of BoundPair
	 */
	private ArrayDeclaration(final String identifier, final Type type, final Vector<BoundPair> boundPairList) {
		super(identifier);
		this.declarationKind = Declaration.Kind.ArrayDeclaration;
		this.type = type;
		this.boundPairList = boundPairList;
		this.nDim = boundPairList.size();
		if (Option.TRACE_PARSE)
			Util.TRACE("END NEW ArrayDeclaration: " + toString());
	}

	/**
	 * Parse an array declaration and add it to the given declaration list.
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
	 * 	   BoundPair = ArithmeticExpression : ArithmeticExpression
	 *
	 * </pre>
	 * Precondition:  [ Type ] ARRAY  is already read.
	 * 
	 * @param type            the array's type
	 * @param declarationList the given declaration list
	 */
	static void expectArrayDeclaration(final Type type, final DeclarationList declarationList) {
		if (Option.TRACE_PARSE)
			Util.TRACE("Parse ArrayDeclaration, type=" + type + ", current=" + Parse.currentToken);
		do {
			if (Option.TRACE_PARSE)
				Parse.TRACE("Parse ArraySegment");
			// IdentifierList = Identifier { , Identifier }
			Vector<String> identList = new Vector<String>();
			do {
				identList.add(Parse.expectIdentifier());
			} while (Parse.accept(KeyWord.COMMA));
			Parse.expect(KeyWord.BEGPAR);
			// BoundPairList = BoundPair { , BoundPair }
			if (Option.TRACE_PARSE)
				Parse.TRACE("Parse BoundPairList");
			Vector<BoundPair> boundPairList = new Vector<BoundPair>();
			do {
				Expression LB = Expression.expectExpression();
				Parse.expect(KeyWord.COLON);
				Expression UB = Expression.expectExpression();
				boundPairList.add(new BoundPair(LB, UB));
			} while (Parse.accept(KeyWord.COMMA));
			Parse.expect(KeyWord.ENDPAR);
			for (Enumeration<String> e = identList.elements(); e.hasMoreElements();) {
				String identifier = e.nextElement();
				declarationList.add(new ArrayDeclaration(identifier.toString(), type, boundPairList));
			}
			
		} while (Parse.accept(KeyWord.COMMA));
	}

	/**
	 * Utility Class to hold a BoundPair.
	 * <pre>
	 * Syntax:
	 * 
	 *    BoundPair = ArithmeticExpression : ArithmeticExpression
	 * </pre>
	 */
	private static class BoundPair {
		/**
		 * The lower bound expression.
		 */
		Expression LB;
		/**
		 * The upper bound expression.
		 */
		Expression UB;

		/**
		 * Create a new BoundPair.
		 * @param LB The lower bound expression
		 * @param UB The upper bound expression
		 */
		BoundPair(final Expression LB, final Expression UB) {
			this.LB = LB;
			this.UB = UB;
		}

		/**
		 * Perform semantic checking.
		 */
		private void doChecking() {
			LB.doChecking();
			UB.doChecking();
			LB = (Expression) TypeConversion.testAndCreate(Type.Integer, LB);
			UB = (Expression) TypeConversion.testAndCreate(Type.Integer, UB);
		}

		@Override
		public String toString() {
			return ("" + LB + ':' + UB);
		}
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())
			return;
		Global.sourceLineNumber = lineNumber;
		if (type == null)
			type = Type.Real;
		if (boundPairList != null)
			for (BoundPair it : boundPairList)
				it.doChecking();
		SET_SEMANTICS_CHECKED();
	}

	@Override
	public void doJavaCoding() {
		Global.sourceLineNumber = lineNumber;
		ASSERT_SEMANTICS_CHECKED();
		// --------------------------------------------------------------------
		// public _FLOAT_GARRAY Tab=null;
		// --------------------------------------------------------------------
		String arrType = this.type.toJavaArrayType();
		String arrayIdent = this.getJavaIdentifier();
		GeneratedJavaClass.code("public " + arrType + " " + arrayIdent + "=null;");
	}

	@Override
	public void doDeclarationCoding() {
		Global.sourceLineNumber = lineNumber;
		ASSERT_SEMANTICS_CHECKED();
		// --------------------------------------------------------------------
		// integer array A(1:4,4:6,6:12);
		// --------------------------------------------------------------------
		// A = new RTS_INTEGER_ARRAY(new _BOUNDS(1,4),new _BOUNDS(4,6),new _BOUNDS(6,7));
		// --------------------------------------------------------------------
		String arrayIdent = this.getJavaIdentifier();
		String arrType = this.type.toJavaArrayType();
		StringBuilder sb = new StringBuilder();
		sb.append(arrayIdent).append("=new " + arrType);
		char sep = '(';
		for (BoundPair boundPair : boundPairList) {
			sb.append(sep);
			sep = ',';
			sb.append("new RTS_BOUNDS(").append(boundPair.LB.toJavaCode()).append(',').append(boundPair.UB.toJavaCode())
					.append(')');
		}
		sb.append(");");
		GeneratedJavaClass.code(sb.toString());
	}

	public void printTree(int indent) {
		System.out.println(SyntaxClass.edIndent(indent)+this.getClass().getSimpleName()+"    "+this);
	}

	@Override
	public String toString() {
		String s = "ARRAY " + identifier + ((boundPairList == null) ? "(?)" : boundPairList);
		if (type != null)
			s = type.toString() + " " + s;
		return (s);
	}

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	/**
	 * Default constructor used by Externalization.
	 */
	public ArrayDeclaration() {
		super(null);
		this.declarationKind = Declaration.Kind.ArrayDeclaration;
	}

	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
		Util.TRACE_OUTPUT("Array: " + type + ' ' + identifier + ", nDim=" + nDim);
		oupt.writeObject(identifier);
		oupt.writeObject(externalIdent);
		oupt.writeObject(type);
		oupt.writeInt(nDim);
	}

	@Override
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
		identifier = (String) inpt.readObject();
		externalIdent = (String) inpt.readObject();
		type = Type.inType(inpt);
		nDim = inpt.readInt();
		Util.TRACE_INPUT("Array: " + type + ' ' + identifier + ", nDim=" + nDim);
	}
}
