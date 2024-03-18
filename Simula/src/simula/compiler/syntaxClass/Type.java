/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.syntaxClass;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import simula.compiler.syntaxClass.declaration.ClassDeclaration;
import simula.compiler.syntaxClass.declaration.ConnectionBlock;
import simula.compiler.syntaxClass.declaration.Declaration;
import simula.compiler.syntaxClass.declaration.DeclarationScope;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Token;
import simula.compiler.utilities.Util;

/**
 * Utility class Type.
 * <pre>
 * Syntax: 
 *     type = value-type
 *          | reference-type
 *          
 *        value-type = arithmetic-type
 *                   | boolean
 *                   | character
 *                   
 *           arithmetic-type = integer-type
 *                           | real-type
 *                           
 *              integer-type = [ short ] integer
 *              
 *              real-type = [ long ] real
 *              
 *              reference-type = object-reference-type
 *                             | text
 *                             
 *                 object-reference-type = ref "(" qualification ")"
 *                 
 *                    qualification = class-identifier
 * </pre>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/utilities/Type.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public sealed class Type extends SyntaxClass implements Externalizable permits OverLoad {
	/**
	 * Simula's Integer type
	 */
	public static final Type Integer = new Type(new Token(KeyWord.INTEGER));
	
	/**
	 * Simula's Real type
	 */
	public static final Type Real = new Type(new Token(KeyWord.REAL));

	/**
	 * Simula's Long Real type
	 */
	public static final Type LongReal = new Type(new Token(KeyWord.REAL, KeyWord.LONG));
	
	/**
	 * Simula's Boolean type
	 */
	public static final Type Boolean = new Type(new Token(KeyWord.BOOLEAN));
	
	/**
	 * Simula's Character type
	 */
	public static final Type Character = new Type(new Token(KeyWord.CHARACTER));
	
	/**
	 * Simula's Text type
	 */
	public static final Type Text = new Type(new Token(KeyWord.TEXT));
	
	/**
	 * Simula's Ref() type
	 */
	public static final Type Ref = new Type(new Token(KeyWord.REF));
	
	/**
	 * Simula's Ref(className) type
	 * @param className the class name
	 * @return a new ref(className) type.
	 */
	public static final Type Ref(String className) { return (new Type(className)); }
	
	/**
	 * Simula's Procedure type
	 */
	public static final Type Procedure = new Type(new Token(KeyWord.PROCEDURE));
	
	/**
	 * Simula's Label type
	 */
	public static final Type Label = new Type(new Token(KeyWord.LABEL));
	
	/**
	 * Qual in case of ref(Qual) type. Set by doChecking
	 */
	protected ClassDeclaration qual;   // Qual in case of ref(Qual) type; Set by doChecking below
	
	/**
	 * Qual's scope in case of ref(Qual) type. Set by doChecking
	 */
	public ConnectionBlock declaredIn; // Qual'scope in case of ref(Qual) type; Set by Variable'doChecking

	/**
	 * Returns the qualifying ClassDeclaration or null.
	 * @return the qualifying ClassDeclaration or null
	 */
	public ClassDeclaration getQual() {
		ASSERT_SEMANTICS_CHECKED();
		return (qual);
	}

	/**
	 * KeyWord or ref(classIdentifier)
	 */
	Token key;
	
	/**
	 * Returns the keyWord or the ref-identifier.
	 * @return the keyWord or the ref-identifier
	 */
	public KeyWord getKeyWord() { return(key.getKeyWord()); }
	

	/**
	 * Default constructor used by Externalization.
	 */
	public Type() {} // Externalization
	  
	/**
	 * Create a new simple Type with the given key Token
	 * @param key the given key Token
	 */
	public Type(Token key) { this.key=key; }

	/**
	 * Create a new ref(className) type.
	 * @param className the class name
	 */
	public Type(String className) {
		if(className==null) className="UNKNOWN"; // Error recovery
		if(Option.CaseSensitive)
			 this.key=new Token(KeyWord.REF,className);
		else this.key=new Token(KeyWord.REF,className.toUpperCase());
	}
	
	/**
	 * Create a new Type based on the given Type and ConnectionBlock.
	 * @param tp the given Type
	 * @param declaredIn the ConnectionBlock
	 */
	public Type(Type tp,ConnectionBlock declaredIn) {
		this.key=tp.key;
		this.qual=tp.qual;
		this.declaredIn=declaredIn;
	}
	
	/**
	 * Returns the ref-identifier or null.
	 * @return the ref-identifier or null
	 */
	public String getRefIdent() {
		if(key.getKeyWord()==KeyWord.REF) {
			if(key.getValue()==null) return(null);
			return(key.getValue().toString());
		}
		return(null); 
	}
  
	/**
	 * Returns the Java ref-identifier or null.
	 * @return the Java ref-identifier or null
	 */
	public String getJavaRefIdent() {
		if(key.getKeyWord()==KeyWord.REF) {
			if(key.getValue()==null) return("RTS_RTObject");
			if(!IS_SEMANTICS_CHECKED()) this.doChecking(Global.getCurrentScope());
			if(qual==null) return("UNKNOWN");
			return(qual.getJavaIdentifier());
		}
		return(null); 
	}
	
    /**
     * Perform semantic checking in the given scope.
	 * @param scope the given scope
	 */
	public void doChecking(final DeclarationScope scope) {
		if(qual!=null) SET_SEMANTICS_CHECKED(); // This Ref-Type is read from attribute file
		if(IS_SEMANTICS_CHECKED()) return;
		Global.enterScope(scope);
		String refIdent=getRefIdent();
		if(refIdent!=null) {
			if(!refIdent.equals("RTS_LABEL") && !refIdent.equals("_UNKNOWN")) {
				Declaration decl=scope.findMeaning(refIdent).declaredAs;
			    if(decl instanceof ClassDeclaration cdecl) qual=cdecl;
			    else Util.error("Illegal Type: "+this.toString()+" - "+refIdent+" is not a Class");
			}
		}
		Global.exitScope();
		SET_SEMANTICS_CHECKED();
	}

	/**
	 * Returns true if this type is an arithmetic type.
	 * Integer, real or long real.
	 * @return true if this type is an arithmetic type.
	 */
	public boolean isArithmeticType() {
		return(this==Type.Integer||this==Type.Real||this==Type.LongReal); }
  
	/**
	 * Returns true if this type is ref() type.
	 * @return true if this type is ref() type
	 */
	public boolean isReferenceType() {
		if(key.getKeyWord()==KeyWord.REF) return(true);
		if(this.equals(Type.Text)) return(true);
		return(getRefIdent()!=null);
	}
  
	public boolean equals(final Object obj) {
		Type other=(Type) obj;
		return(this.key.equals(other.key));
	}
  
	/**
	 * Utility enum ConversionKind.
	 *
	 */
    public enum ConversionKind { 
    	/**
    	 * Type conversion is illegal.
    	 */
    	Illegal,
    	
    	/**
    	 * No type-conversion is necessary. E.g. integer to integer
    	 */
    	DirectAssignable,
    	
    	/**
    	 * Type-conversion with possible Runtime check is necessary. E.g. real to integer.
    	 */
    	ConvertValue,
    	
    	/**
    	 * Type-conversion with Runtime check is necessary. E.g. ref(A) to ref(B) where B is a subclass of A.
    	 */
    	ConvertRef
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
     * </ul>
     * @param to the to type-
     * @return the resulting ConversionKind
     */
    public ConversionKind isConvertableTo(final Type to) {
	    ConversionKind result;
	    if(to==null) result=ConversionKind.Illegal;
	    else if(this.equals(to)) result=ConversionKind.DirectAssignable;
	    else if(this.isArithmeticType()&&to.isArithmeticType()) result=ConversionKind.ConvertValue;
	    else if(this.isSubReferenceOf(to)) result=ConversionKind.DirectAssignable;  
	    else if(to.isSubReferenceOf(this)) result=ConversionKind.ConvertRef; // Needs Runtime-Check
	    else result=ConversionKind.Illegal;
		//System.out.println("Type.isConvertableTo: "+this+"  ==>  " + to + "   RESULT=" + result);
	    return(result); 
    }
  
    /**
     * Utility method isSubReferenceOf.
     * <p>
     * ref(B) is a sub-reference of ref(A) iff B is a subclass of A.
     * <p>
     * Any ref is a sub-reference of NONE
     * 
     * @param other the other type
     * @return true if the condition holds
     */
	public boolean isSubReferenceOf(final Type other) {
		String thisRef=this.getRefIdent(); // May be null for NONE
		String otherRef=other.getRefIdent(); // May be null for NONE
		boolean result;		
		if(otherRef==null) result=false;  // No ref is a super-reference of NONE
		else if(thisRef==null) result=true; // Any ref is a sub-reference of NONE
		else {
			ClassDeclaration thisDecl=(ClassDeclaration)Global.getCurrentScope().findMeaning(thisRef).declaredAs;
			ClassDeclaration otherDecl=(ClassDeclaration)Global.getCurrentScope().findMeaning(otherRef).declaredAs;
			if(thisDecl==null) result=false; // Error Recovery
			else result=thisDecl.isSubClassOf(otherDecl);
		}
		//System.out.println("Type.isSubReferenceOf: "+thisRef+"  ==>  " + otherRef + "   RESULT="+result);
		return(result); 
	}
  
	/**
	 * Returns the type to which both types can be converted.
	 * @param type1 argument
	 * @param type2 argument
	 * @return the resulting Type
	 */
	public static Type commonRefType(final Type type1,final Type type2) {
		if(type1.isSubReferenceOf(type2)) return(type2);
	    if(type2.isSubReferenceOf(type1)) return(type1);
		return(type1);
	}
  
	/**
	 * Returns the type to which both types can be converted.
	 * @param type1 argument
	 * @param type2 argument
	 * @return the resulting Type
	 */
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
	
	/**
	 * Returns the most dominant type.
	 * @param type1 argument
	 * @param type2 argument
	 * @return the most dominant type
	 */
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
  
	/**
	 * Returns an edited default value of this Type.
	 * @return an edited default value of this Type
	 */
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
  
	/**
	 * Codeing utility: toJavaType.
	 * @return the resulting code string.
	 */
	public String toJavaType() {
		if(key==null) return("void");
	    //if(this.equals(Array)) return("array"); // ARRAY Elements 
		if(key.getKeyWord()==KeyWord.REF) return(getJavaRefIdent());
		if(this.equals(LongReal)) return("double");
		if(this.equals(Real)) return("float");
		if(this.equals(Integer)) return("int");
		if(this.equals(Boolean)) return("boolean");
		if(this.equals(Character)) return("char");
		if(this.equals(Text)) return("RTS_TXT");
		if(this.equals(Procedure)) return("RTS_PRCQNT");
		if(this.equals(Label)) return("RTS_LABEL");
		return(this.toString());
	}
	 
	/**
	 * Codeing utility: toJavaTypeClass.
	 * @return the resulting code string.
	 */
	public String toJavaTypeClass() {
		if(key==null) return("void");
		if(key.getKeyWord()==KeyWord.REF) return(getJavaRefIdent());
		if(this.equals(LongReal)) return("Double");
		if(this.equals(Real)) return("Float");
		if(this.equals(Integer)) return("Integer");
		if(this.equals(Boolean)) return("Boolean");
		if(this.equals(Character)) return("Character");
		if(this.equals(Text)) return("RTS_TXT");
		return(this.toString());
	}
	
	/**
	 * Codeing utility: toJavaArrayType.
	 * @return the resulting code string.
	 */
	public String toJavaArrayType() {
		if(key.getKeyWord()==KeyWord.REF) {
			String rtQual=getJavaRefIdent();
			return("RTS_REF_ARRAY<"+rtQual+">");
		}
		if(this.equals(LongReal)) return("RTS_LONG_REAL_ARRAY");
		if(this.equals(Real)) return("RTS_REAL_ARRAY");
		if(this.equals(Integer)) return("RTS_INTEGER_ARRAY");
		if(this.equals(Boolean)) return("RTS_BOOLEAN_ARRAY");
		if(this.equals(Character)) return("RTS_CHARACTER_ARRAY");
		if(this.equals(Text)) return("RTS_TEXT_ARRAY");
//		if(this.equals(Procedure)) return("RTS_PRCQNT");
//		if(this.equals(Label)) return("RTS_LABEL");
		Util.IERR("");
		return(this.toString());
	}
	
	public String getArrayType() {
		if(this==Type.Integer)     return("RTS_INTEGER_ARRAY");
		if(this==Type.Character)   return("RTS_CHARACTER_ARRAY");
		if(this==Type.Boolean)     return("RTS_BOOLEAN_ARRAY");
		if(this==Type.Real)        return("RTS_REAL_ARRAY");
		if(this==Type.LongReal)    return("RTS_LONG_REAL_ARRAY");
		if(this==Type.Text)        return("RTS_TEXT_ARRAY");
		if(this.isReferenceType()) return("RTS_REF_ARRAY");
		Util.IERR("IMPOSSIBLE");   return(null);
	}
	  
	@Override
	public String toString() {
		if(key==null) return("null");
		if(key.getKeyWord()==KeyWord.REF) {
			if(declaredIn==null) {
				if(qual==null) return("ref("+key.getValue()+')');
				return("ref("+key.getValue()+") qualified by Class "+qual.identifier+" with block level "+qual.ctBlockLevel);
			}
			return("ref("+key.getValue()+") declared in "+declaredIn.identifier+" with block level "+declaredIn.ctBlockLevel);
		}
		if(this.equals(LongReal)) return("LONG REAL"); 
		return(key.toString().toUpperCase());
	}
	
	/**
	 * Read a type from an ObjectInput file.
	 * @param inpt the ObjectInput
	 * @return the resulting Type
	 * @throws IOException if an IOException occur
	 * @throws ClassNotFoundException if the operation failed
	 */
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

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************

	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
//		if(AttributeOutput.USE_ATTRIBUTE_IO) Util.IERR("");
		oupt.writeObject(key);
		oupt.writeObject(qual);
		oupt.writeObject(declaredIn);
	}

	@Override
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
//		if(AttributeOutput.USE_ATTRIBUTE_IO) Util.IERR("");
		key=(Token)inpt.readObject();
		qual=(ClassDeclaration) inpt.readObject();
		declaredIn=(ConnectionBlock) inpt.readObject();
	}
	
}
