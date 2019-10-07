/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.expression;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Type.ConversionKind;
import simula.compiler.utilities.Util;

public final class TypeConversion extends Expression {
	final Expression expression;

	private TypeConversion(final Type type,final Expression expression) {
		this.type=type;
		this.expression = expression; expression.backLink=this;
	    this.doChecking();
	}

	// Test if a TypeConversion is necessary and then do it.
	public static String mayBeConvert(final Type fromType,final Type toType,final String expr) {
		if(fromType==Type.Real || fromType==Type.LongReal)
		{ if(toType==Type.Integer)
              return("=(int)Math.round("+expr+");");
		}
        return("=("+toType.toJavaType()+")("+expr+");");
	}

	// Test if a TypeConversion is necessary and then create it.
	public static Expression testAndCreate(final Type toType,final Expression expression) {
		if (testCastNeccessary(toType, expression)) {
			if(expression instanceof Constant) {
				Number val=(Number)((Constant)expression).value;
				Type fromType=expression.type;
				if(toType==Type.Integer) {
					if(fromType==Type.Real) val=(int)Math.round(val.floatValue());
					else if(fromType==Type.LongReal) val=(int)Math.round(val.doubleValue());
				}
				else if(toType==Type.Real) val=val.floatValue();
				else if(toType==Type.LongReal) val=val.doubleValue();
				else Util.FATAL_ERROR("IMPOSSIBLE - TypeConversion.testAndCreate: "+expression);
				Constant c=new Constant(toType,val); c.doChecking();
				return(c);
			}
			return (new TypeConversion(toType, expression));
		} return (expression);
	}

	// Test if a TypeConversion is necessary.
	private static boolean testCastNeccessary(final Type toType,final Expression expression) {
		if (toType == null)	return (false);
		Type fromType = expression.type;
		if(fromType==null) {
			Util.error("Expression "+expression+" has no type - can't be converted to "+toType);
			return(false);
		}
		ConversionKind conversionKind = fromType.isConvertableTo(toType);
		switch (conversionKind) {
			case DirectAssignable:	return (false);
			case ConvertValue:
			case ConvertRef:		return (true);
			case Illegal:
				Util.error("TypeConversion: Illegal cast: (" + toType + ") " + expression);
			default: return (false);
		}
	}
	
	// Is redefined in Variable, RemoteVariable and TypeConversion
	public Variable getWriteableVariable() {
		return(expression.getWriteableVariable());
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		type.doChecking(Global.currentScope);
		expression.doChecking();
		Type type = expression.type;
		if (type.isConvertableTo(this.type) == Type.ConversionKind.Illegal)
			Util.error("Illegal Type Conversion " + type + " ==> " + this.type);
		SET_SEMANTICS_CHECKED();
	}

	  // Returns true if this expression may be used as a statement.
	  public boolean maybeStatement()
	  {	ASSERT_SEMANTICS_CHECKED(this);
		return(false);  
	  }

	  public String toJavaCode() {
		  ASSERT_SEMANTICS_CHECKED(this);
		  String evaluated = expression.toJavaCode();
		  if (type == Type.Integer) {
			  Type fromType = expression.type;
			  if (fromType == Type.Real || fromType == Type.LongReal)
				  return("(int)Math.round(" + evaluated + ")");
		  }
		  return ("((" + type.toJavaType() + ")(" + evaluated + "))");
	  }

	public String toString() {
		return ("((" + type + ")(" + expression + "))");
	}

}
