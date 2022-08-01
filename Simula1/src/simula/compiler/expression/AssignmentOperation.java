/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import simula.compiler.declaration.ArrayDeclaration;
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.Parameter;
import simula.compiler.declaration.SimpleVariableDeclaration;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Meaning;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Assignment Operation.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 *   AssignmentOperation = Expression  AssignmentOperator  Expression
 *   
 *		AssignmentOperator =  :=  |  :-
 *   
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public final class AssignmentOperation extends Expression {
	public Expression lhs;
	public final KeyWord opr;
	public Expression rhs;
	private boolean textValueAssignment=false; // Set by doChecking
	
	  
	public AssignmentOperation(final Expression lhs,final KeyWord opr,final Expression rhs) {
		this.lhs=lhs; this.opr=opr; this.rhs=rhs;
		if(this.lhs==null) {
			Util.error("Missing operand before "+opr);
			this.lhs=new Variable("UNKNOWN$");
		}
		if(this.rhs==null) {
			Util.error("Missing operand after "+opr);
			this.rhs=new Variable("UNKNOWN$");
		}
	    this.lhs.backLink=this.rhs.backLink=this;
	}

	public void doChecking() {
		if(IS_SEMANTICS_CHECKED()) return;
	   	Global.sourceLineNumber=lineNumber;
		if(Option.TRACE_CHECKER) Util.TRACE("BEGIN Assignment"+toString()+".doChecking - Current Scope Chain: "+Global.getCurrentScope().edScopeChain());
	    lhs.doChecking(); Type toType=lhs.type;
	    if(lhs instanceof Variable) {
	    	Variable var=(Variable)lhs;
		    Meaning meaning=var.getMeaning();
		    if(meaning.declaredAs instanceof SimpleVariableDeclaration) {
		    	SimpleVariableDeclaration dcl=(SimpleVariableDeclaration)meaning.declaredAs;
		        if(dcl.isConstant()) Util.error("Assignment to Constant: '"+lhs+"' is Illegal");
		    }
	    } else {
	    	if(lhs.getWriteableVariable()==null) Util.error("Can't assign to "+lhs);
	    }
	    rhs.doChecking(); Type fromType=rhs.type;
		if(opr==KeyWord.ASSIGNVALUE) this.textValueAssignment=(toType==Type.Text);
		rhs=(Expression)TypeConversion.testAndCreate(toType,rhs);
		this.type=toType;
		if(this.type==null) Util.error("doAssignmentChecking: Illegal types: "+toType+" := "+fromType);
		SET_SEMANTICS_CHECKED();
	  }


	// Returns true if this expression may be used as a statement.
	public boolean maybeStatement() {
		ASSERT_SEMANTICS_CHECKED(this);
		return (true);
	}

	public String toJavaCode() {
		ASSERT_SEMANTICS_CHECKED(this);
		return (doCodeAssignment());
	}

	// ***********************************************************************
	// *** CODE: doCodeTextValueAssignment
	// ***********************************************************************
	private String doCodeTextValueAssignment() {
		StringBuilder s = new StringBuilder();
		if (rhs instanceof Constant) {
			Object value = ((Constant) rhs).value;
			if (value != null) {
				s.append("ASGSTR$(").append(lhs.toJavaCode()).append(",\"").append(value).append("\")");
				return (s.toString());
			}
		}
		s.append("ASGTXT$(").append(lhs.toJavaCode()).append(',').append(rhs.toJavaCode()).append(')');
		return (s.toString());
	}  

	// ***********************************************************************
	// *** CODE: doCodeAssignment -- TODO: FJERNES / RETTES //
	// ***********************************************************************
	private String doCodeAssignment() {
		StringBuilder s = new StringBuilder();
		if (this.textValueAssignment)
			s.append(doCodeTextValueAssignment());
		else {
			// -------------------------------------------------------------------------
			// CHECK FOR SPECIAL CASE:
			//     OBJECT DOT ARRAY(x1,x2,...) := Expression ;
			// SHOULD BE CODED LIKES:
			//     <Expression-1> . ARRAY.put(x1,x2,<Expression-2>) ;
			//     OBJECT . ARRAY.A[x+9- OBJECT.ARRAY.LB[0]]=134;
			// -------------------------------------------------------------------------
			if(lhs instanceof RemoteVariable) {
				Expression afterDot=((RemoteVariable)lhs).var;
				if(afterDot instanceof Variable &&  ((Variable)afterDot).hasArguments()) {
					Declaration decl = ((Variable) afterDot).meaning.declaredAs;
					Expression beforeDot = ((RemoteVariable) lhs).obj;
					if (decl instanceof ArrayDeclaration)
						return (assignToRemoteArray(beforeDot, (Variable) afterDot, rhs));
					else if (decl instanceof Parameter) {
						Parameter par = (Parameter) decl;
						if (par.kind == Parameter.Kind.Array)
							return (assignToRemoteArray(beforeDot, (Variable) afterDot, rhs));
					}

				}
			}
			s.append(lhs.put(rhs.get()));
		}
		return(s.toString());
	}
  
  
	// ***********************************************************************
	// *** CODE: assignToRemoteArray
	// ***********************************************************************
	private String assignToRemoteArray(final Expression beforeDot, final Variable array, final Expression rhs) {
		String lhs = doAccessRemoteArray(beforeDot, array);
		String asg = lhs + '=' + rhs.toJavaCode();
		return (asg);
	}
  
	// ***********************************************************************
	// *** CODE: doAccessRemoteArray
	// ***********************************************************************
	private String doAccessRemoteArray(final Expression beforeDot, final Variable array) {
		StringBuilder s = new StringBuilder();
		int nDim = 0;
		// Generate: obj.M.A[6-obj.M.LB[1]];
		String obj = beforeDot.toJavaCode();
		String remoteIdent = obj + '.' + array.edIdentifierAccess(true);
		StringBuilder ixs = new StringBuilder();
		String dimBrackets = "";
		for (Expression ix : array.checkedParams) {
			String index = "[" + ix.toJavaCode() + "-" + remoteIdent + ".LB[" + (nDim++) + "]]";
			ixs.append(index);
			dimBrackets = dimBrackets + "[]";
		}
		String eltType = type.toJavaType();
		String cast = "ARRAY$<" + eltType + dimBrackets + ">";
		String castedVar = "((" + cast + ")" + remoteIdent + ")";
		s.append(castedVar).append(".Elt").append(ixs);
		return (s.toString());
	}

	public String toString() {
		return ("(" + lhs + ' ' + opr + ' ' + rhs + ")");
	}

}
