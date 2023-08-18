/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass.expression;

import simula.compiler.syntaxClass.Type;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Relational Operation.
 * 
 * <pre>
 * 
 * Simula Standard: 3.3 Relations
 * 
 * </pre>
 * 
 * <h2>Syntax used during Parsing:</h2>
 * 
 * <pre>
 * 
 *   relational-operation = expression  relational-operator  expression
 *   
 *      relational-operator = value-relational-operator | reference-comparator
 *      
 *         value-relational-operator =  &lt; | &lt;= | = | >= | > | &lt;>
 *         
 *         reference-comparator =  == | =/= 
 * </pre>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/expression/RelationalOperation.java">
 * <b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
public final class RelationalOperation extends Expression {

	/**
	 * The left hand side
	 */
	private Expression lhs;

	/**
	 * The relational operation
	 */
	private final KeyWord opr;

	/**
	 * The right hand side
	 */
	private Expression rhs;

	/**
	 * Create a new RelationalOperation.
	 * @param lhs the left hand side
	 * @param opr the relation
	 * @param rhs the right hand side
	 */
	RelationalOperation(final Expression lhs,final KeyWord opr,final Expression rhs) {
		this.lhs = lhs;
		this.opr = opr;
		this.rhs = rhs;
		if (this.lhs == null) {
			Util.error("Missing operand before " + opr);
			this.lhs = new VariableExpression("UNKNOWN_");
		}
		if (this.rhs == null) {
			Util.error("Missing operand after " + opr);
			this.rhs = new VariableExpression("UNKNOWN_");
		}
		this.lhs.backLink = this.rhs.backLink = this;
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber = lineNumber;
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN RelationalOperation" + toString() + ".doChecking - Current Scope Chain: "	+ Global.getCurrentScope().edScopeChain());
		switch (opr) {
		case LT: case LE: case EQ: case NE: case GE: case GT: {
			lhs.doChecking();
			rhs.doChecking();
			Type type1 = lhs.type;
			Type type2 = rhs.type;
			if (type1 == Type.Text && type2 == Type.Text) {
				this.type = Type.Boolean;
				break;
			}
			if (type1 == Type.Character && type2 == Type.Character) {
				this.type = Type.Boolean;
				break;
			}
			if (type1 == Type.Boolean && type2 == Type.Boolean) {
				this.type = Type.Boolean;
				break;
			}
			// Arithmetic Relation
			Type atype = Type.arithmeticTypeConversion(type1, type2);
			if (atype == null)
				Util.error("Incompatible types in binary operation: " + toString());
			this.type = Type.Boolean;
			lhs = (Expression) TypeConversion.testAndCreate(atype, lhs);
			rhs = (Expression) TypeConversion.testAndCreate(atype, rhs);
			break;
		}
		case EQR: case NER: {
			// Object =/= Object or Object == Object
			lhs.doChecking();
			rhs.doChecking();
			Type type1 = lhs.type;
			Type type2 = rhs.type;
			if ((!type1.isReferenceType()) || (!type2.isReferenceType()))
				Util.error("RelationalOperation: Illegal types: " + type1 + " " + opr + " " + type2);

			this.type = Type.Boolean;
			break;
		}
		default:
			Util.IERR("*** NOT IMPLEMENTED: " +"RelationalOperation -- Util.error(Something went wrong) opr=" + opr);
			this.type = rhs.type;
		}
		if (Option.TRACE_CHECKER)
			Util.TRACE("END RelationalOperation" + toString() + ".doChecking - Result type=" + this.type);
		SET_SEMANTICS_CHECKED();
	}

	// Returns true if this expression may be used as a statement.
	@Override
	public boolean maybeStatement() {
		ASSERT_SEMANTICS_CHECKED();
		return (false);
	}

	@Override
	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED();
		switch (opr) {
			case LT: case LE: case EQ: case NE: case GE: case GT: {
				Type type1 = lhs.type;
				Type type2 = rhs.type;
				if ((type1 == Type.Text) && (type2 == Type.Text))
					return (doCodeTextValueRelation());
			}
			case EQR: case NER: {
				Type type1 = lhs.type;
				Type type2 = rhs.type;
				if ((type1 == Type.Text) && (type2 == Type.Text))
					return (doCodeTextRefRelation());
			}
			default: {
				if (this.backLink == null)
					 return (lhs.get() + opr.toJavaCode() + '(' + rhs.get() + ')');
				else return ("(" + lhs.get() + opr.toJavaCode() + '(' + rhs.get() + "))");
			}
		}
	}

	// ***********************************************************************
	// *** CODE: doCodeTextValueRelation
	// ***********************************************************************
	/**
	 * Coding Utility: Code text value relation
	 * @return the resulting Java source code
	 */
	private String doCodeTextValueRelation() {
		StringBuilder s = new StringBuilder();
		String fnc = "??";
		switch (opr) {
		    case LT -> fnc = "LT(";
		    case EQ -> fnc = "EQ(";
		    case LE -> fnc = "LE(";
		    case GT -> fnc = "GT(";
		    case NE -> fnc = "NE(";
		    case GE -> fnc = "GE(";
		    default -> Util.IERR("Unexpected value: " + opr);
		}
		s.append("_TXTREL_").append(fnc);
		s.append(lhs.get()).append(',');
		s.append(rhs.get()).append(')');
		return (s.toString());
	}

	// ***********************************************************************
	// *** CODE: doCodeTextRefRelation
	// ***********************************************************************
	/**
	 * Coding Utility: Code text reference relation
	 * @return the resulting Java source code
	 */
	private String doCodeTextRefRelation() {
		String fnc = "TRF_EQ(";
		StringBuilder s = new StringBuilder();
		if (opr == KeyWord.NER)	fnc = "TRF_NE(";
		s.append(fnc);
		s.append(lhs.get()).append(',');
		s.append(rhs.get()).append(')');
		return (s.toString());
	}

	@Override
	public String toString() {
		return ("(" + lhs + ' ' + opr + ' ' + rhs + ")");
	}

}
