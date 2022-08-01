/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.utilities;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.declaration.ClassDeclaration;
import simula.compiler.declaration.Declaration;
import simula.compiler.declaration.DeclarationScope;

public class Type implements Externalizable {
	public static final Type Integer = new Type(new Token(KeyWord.INTEGER));
	public static final Type Real = new Type(new Token(KeyWord.REAL));
	public static final Type LongReal = new Type(new Token(KeyWord.REAL, KeyWord.LONG));
	public static final Type Boolean = new Type(new Token(KeyWord.BOOLEAN));
	public static final Type Character = new Type(new Token(KeyWord.CHARACTER));
	public static final Type Text = new Type(new Token(KeyWord.TEXT));
	public static final Type Ref = new Type(new Token(KeyWord.REF));
	public static final Type Ref(String className) { return (new Type(className)); }
	public static final Type Procedure = new Type(new Token(KeyWord.PROCEDURE));
	public static final Type Label = new Type(new Token(KeyWord.LABEL));

	private ClassDeclaration qual; // Qual in case of ref(Qual) type; Set by doChecking

	public ClassDeclaration getQual() {
		Util.ASSERT(CHECKED, "Type is not Checked");
		return (qual);
	}

	Token key;  // KeyWord or ref(classIdentifier)
	public KeyWord getKeyWord() { return(key.getKeyWord()); }
	

	public Type() {} // Externalization
	  
	public Type(Token key) { this.key=key; }

	public Type(String className) {
		if(className==null) className="UNKNOWN"; // Error recovery
		this.key=new Token(KeyWord.REF,className.toUpperCase());
	}
  
	public String getRefIdent() {
		if(key.getKeyWord()==KeyWord.REF) {
			if(key.getValue()==null) return(null);
			return(key.getValue().toString());
		}
		return(null); 
	}
  
	public String getJavaRefIdent() {
		if(key.getKeyWord()==KeyWord.REF) {
			if(key.getValue()==null) return("RTObject$");
			if(!CHECKED) this.doChecking(Global.currentScope);
			if(qual==null) return("UNKNOWN");
			return(qual.getJavaIdentifier());
		}
		return(null); 
	}
  
	private boolean CHECKED=false; // Set true when doChecking is called
	public void doChecking(final DeclarationScope scope) {
		if (CHECKED) return;
		String refIdent=getRefIdent();
		if(refIdent!=null) {
			if(!refIdent.equals("LABQNT$") && !refIdent.equals("$UNKNOWN")) {
				Declaration decl=scope.findMeaning(refIdent).declaredAs;
			    if(decl instanceof ClassDeclaration) {
			    	qual=(ClassDeclaration)decl;
			    } else Util.error("Illegal Type: "+this.toString()+" - "+refIdent+" is not a Class");
			}
		}
		CHECKED=true;
	}

	public boolean isArithmeticType() {
		return(this==Type.Integer||this==Type.Real||this==Type.LongReal); }
  
	public boolean isReferenceType() {
		if(key.getKeyWord()==KeyWord.REF) return(true);
		if(this.equals(Type.Text)) return(true);
		return(getRefIdent()!=null);
	}
  
	public boolean equals(final Object other) {
		Token thisKey=this.key;  
		Token otherKey=((Type)other).key;  
		return(thisKey.equals(otherKey));
	}
  
  
	/**
     * Checks if a type-conversion is legal.
     * <p>
     * The possible return values are:
     * <ul>
     * <li>DirectAssignable - No type-conversion is necessary. E.g. integer to integer
     * <li>ConvertValue - Type-conversion with possible Runtime check is necessary. E.g. real to integer.
     * <li>ConvertRef - Type-conversion with Runtime check is necessary. E.g. ref(A) to ref(B) where B is a subclass of A.
     * <li>Illegal - Conversion is illegal
     */
    public enum ConversionKind { Illegal, DirectAssignable, ConvertValue, ConvertRef }
    public ConversionKind isConvertableTo(final Type to) {
	    ConversionKind result;
	    if(to==null) result=ConversionKind.Illegal;
	    else if(this.equals(to)) result=ConversionKind.DirectAssignable;
	    else if(this.isArithmeticType()&&to.isArithmeticType()) result=ConversionKind.ConvertValue;
	    else if(this.isSubReferenceOf(to)) result=ConversionKind.DirectAssignable;  
	    else if(to.isSubReferenceOf(this)) result=ConversionKind.ConvertRef; // Needs Runtime-Check
	    else result=ConversionKind.Illegal;
	    return(result); 
    }
  
	// ref(B) is a sub-reference of ref(A) iff B is a subclass of A
	// any ref is a sub-reference of NONE
	public boolean isSubReferenceOf(final Type other) {
		String thisRef=this.getRefIdent(); // May be null for NONE
		String otherRef=other.getRefIdent(); // May be null for NONE
		boolean result;
		if(otherRef==null) result=false;  // No ref is a super-reference of NONE
		else if(thisRef==null) result=true; // Any ref is a sub-reference of NONE
		else {
			BlockDeclaration thisDecl=(BlockDeclaration)Global.currentScope.findMeaning(thisRef).declaredAs;
			BlockDeclaration otherDecl=(BlockDeclaration)Global.currentScope.findMeaning(otherRef).declaredAs;
			if(thisDecl==null) result=false; // Error Recovery
			else result=((ClassDeclaration)thisDecl).isSubClassOf((ClassDeclaration)otherDecl);
		}
		return(result); 
	}
  
	public static Type commonRefType(final Type type1,final Type type2) {
		if(type1.isSubReferenceOf(type2)) return(type2);
	    if(type2.isSubReferenceOf(type1)) return(type1);
		return(type1);
	}
  
	public static Type commonTypeConversion(final Type type1,final Type type2) {
		if(type1.equals(type2)) return(type1);
		Type atype=arithmeticTypeConversion(type1,type2);
		if(atype!=null) return(atype);
		if(type1.isReferenceType() && type2.isReferenceType()) {
			if(type1.isSubReferenceOf(type2)) return(type2);
		    if(type2.isSubReferenceOf(type1)) return(type1);
		    Util.error("Incompatible types: "+type1+", "+type2);
		    return(type1);
		}
		Util.error("Incompatible types: "+type1+", "+type2);
		return(null);
	}
  
	public static Type arithmeticTypeConversion(final Type type1,final Type type2) {
		if(type1==Type.Integer)	{
			if(type2==Type.Integer) return(Type.Integer); 
			else if(type2==Type.Real) return(Type.Real);
			else if(type2==Type.LongReal) return(Type.LongReal);
		}
		else if(type1==Type.Real) {
			if(type2==Type.Integer) return(Type.Real); 
			else if(type2==Type.Real) return(Type.Real);
			else if(type2==Type.LongReal) return(Type.LongReal);
		}
		else if(type1==Type.LongReal) {
			if(type2==Type.Integer) return(Type.LongReal); 
			else if(type2==Type.Real) return(Type.LongReal);
			else if(type2==Type.LongReal) return(Type.LongReal);
		}
		return(null);  
	}
  
	public String edDefaultValue() {
		if(key==null) return("void");
		if(key.getKeyWord()==KeyWord.IDENTIFIER) return(null);
		if(key.getKeyWord()==KeyWord.REF) return("null");
		if(this.equals(LongReal)) return("0.0d");
		if(this.equals(Real)) return("0.0f");
		if(this.equals(Integer)) return("0");
		if(this.equals(Boolean)) return("false");
		if(this.equals(Character)) return("0");
		if(this.equals(Text)) return("null");
		if(this.equals(Label)) return("null");
		return(this.toString());
	}
  
	public String toJavaType() {
		if(key==null) return("void");
	    //if(this.equals(Array)) return("array"); // ARRAY Elements 
		if(key.getKeyWord()==KeyWord.REF) return(getJavaRefIdent());
		if(this.equals(LongReal)) return("double");
		if(this.equals(Real)) return("float");
		if(this.equals(Integer)) return("int");
		if(this.equals(Boolean)) return("boolean");
		if(this.equals(Character)) return("char");
		if(this.equals(Text)) return("TXT$");
		if(this.equals(Procedure)) return("PRCQNT$");
		if(this.equals(Label)) return("LABQNT$");
		return(this.toString());
	}
	 
	public String toJavaTypeClass() {
		if(key==null) return("void");
	    //Util.BREAK("Type.toJavaTypeClass: key="+key);
		if(key.getKeyWord()==KeyWord.REF) return(getJavaRefIdent());
		if(this.equals(LongReal)) return("Double");
		if(this.equals(Real)) return("Float");
		if(this.equals(Integer)) return("Integer");
		if(this.equals(Boolean)) return("Boolean");
		if(this.equals(Character)) return("Character");
		if(this.equals(Text)) return("TXT$");
		return(this.toString());
	}
	  
	public String toString() {
		if(key==null) return("null");
		if(key.getKeyWord()==KeyWord.REF) return("Ref("+key.getValue()+')');
		if(this.equals(LongReal)) return("LONG REAL"); 
		return(key.toString());
	}
	
	public static Type inType(ObjectInput inpt) throws IOException, ClassNotFoundException {
		Type tp=(Type)inpt.readObject();
		if(tp==null) return(null);
		KeyWord key=tp.key.getKeyWord();
		if(key==KeyWord.INTEGER) return(Type.Integer);
		if(key==KeyWord.REAL) {
			if(tp.key.getValue()==KeyWord.LONG) return(Type.LongReal);
			return(Type.Real);
		}
		if(key==KeyWord.BOOLEAN) return(Type.Boolean);
		if(key==KeyWord.CHARACTER) return(Type.Character);
		if(key==KeyWord.TEXT) return(Type.Text);
		if(key==KeyWord.PROCEDURE) return(Type.Procedure);
		if(key==KeyWord.LABEL) return(Type.Label);
		return(tp);

	}

	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
		oupt.writeObject(key);
	}

	@Override
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
		key=(Token)inpt.readObject();
	}
	
}
