/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Binary Operation.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *   RelationalOperation = Expression  RelationalOperator  Expression
 * 
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public final class RelationalOperation extends Expression {
	public Expression lhs;
	public final KeyWord opr;
	public Expression rhs;

	public RelationalOperation(final Expression lhs,final KeyWord opr,final Expression rhs) {
		this.lhs = lhs;
		this.opr = opr;
		this.rhs = rhs;
		if (this.lhs == null) {
			Util.error("Missing operand before " + opr);
			this.lhs = new Variable("UNKNOWN$");
		}
		if (this.rhs == null) {
			Util.error("Missing operand after " + opr);
			this.rhs = new Variable("UNKNOWN$");
		}
		this.lhs.backLink = this.rhs.backLink = this;
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber = lineNumber;
		if (Option.TRACE_CHECKER)
			Util.TRACE("BEGIN RelationalOperation" + toString() + ".doChecking - Current Scope Chain: "	+ Global.currentScope.edScopeChain());
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
			Util.NOT_IMPLEMENTED("RelationalOperation -- Util.error(Something went wrong) opr=" + opr);
			this.type = rhs.type;
		}
		if (Option.TRACE_CHECKER)
			Util.TRACE("END RelationalOperation" + toString() + ".doChecking - Result type=" + this.type);
		SET_SEMANTICS_CHECKED();
	}

	// Returns true if this expression may be used as a statement.
	public boolean maybeStatement() {
		ASSERT_SEMANTICS_CHECKED(this);
		return (false);
	}

	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
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
	private String doCodeTextValueRelation() {
		StringBuilder s = new StringBuilder();
		String fnc = "??";
		switch (opr) {
		    case LT: fnc = "LT("; break;
		    case EQ: fnc = "EQ("; break;
		    case LE: fnc = "LE("; break;
		    case GT: fnc = "GT("; break;
		    case NE: fnc = "NE("; break;
		    case GE: fnc = "GE("; break;
		    default:
		}
		s.append("TXTREL$").append(fnc);
		s.append(lhs.get()).append(',');
		s.append(rhs.get()).append(')');
		return (s.toString());
	}

	// ***********************************************************************
	// *** CODE: doCodeTextRefRelation
	// ***********************************************************************
	private String doCodeTextRefRelation() {
		String fnc = "TRF_EQ(";
		StringBuilder s = new StringBuilder();
		if (opr == KeyWord.NER)	fnc = "TRF_NE(";
		s.append(fnc);
		s.append(lhs.get()).append(',');
		s.append(rhs.get()).append(')');
		return (s.toString());
	}

	public String toString() {
		return ("(" + lhs + ' ' + opr + ' ' + rhs + ")");
	}

}
