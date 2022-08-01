/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.declaration;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import simula.compiler.JavaModule;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * Virtual Quantities.
 * <pre>
 *    VirtualPart  =  VIRTUAL  :  VirtualSpec  ;  {  VirtualSpec  ;  }
 *    VirtualSpec  =  VirtualSpecifier  IdentifierList
 *        |  PROCEDURE  ProcedureIdentifier  IS  ProcedureDeclaration
 *        
 *   	VirtualSpecifier = LABEL | SWITCH |  [ type ] PROCEDURE
 *    	IdentifierList  =  Identifier  { , Identifier }
 *
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class VirtualSpecification extends Declaration implements Externalizable {
	// String identifier;    // Inherited
	// String externalIdent; // Inherited
	// Type type;            // Inherited: Procedure's type if any
	
	public enum Kind { Procedure, Label, Switch	}
	public Kind kind;
	public ProcedureSpecification procedureSpec; // From: IS ProcedureSpecification
    public boolean hasDefaultMatch; // Set during doChecking

	private VirtualSpecification(final String identifier,final Type type,final Kind kind,final ProcedureSpecification procedureSpec) {
		super(identifier);
		this.declarationKind=Declaration.Kind.VirtualSpecification;
	 	this.externalIdent=identifier;
		this.type=type;
		this.kind=kind;
		this.procedureSpec=procedureSpec;
//		this.blockKind=BlockKind.Procedure;
	}
	
	public static void parseInto(final ClassDeclaration block) {
		Parser.expect(KeyWord.COLON);
   LOOP:while(true) {
		    Type type;
	        if(Parser.accept(KeyWord.SWITCH)) {
	    	    parseSimpleSpecList(block,Type.Label,Kind.Switch);
	        } else if(Parser.accept(KeyWord.LABEL)) {
	    	    parseSimpleSpecList(block,Type.Label,Kind.Label);
	        } else {
	    	    type=acceptType();
	            if(!Parser.accept(KeyWord.PROCEDURE)) break LOOP;
	      
	            String identifier=expectIdentifier();
		        ProcedureSpecification procedureSpec=null;
	            if(Parser.accept(KeyWord.IS)) {
	        	    Type procedureType=acceptType(); Parser.expect(KeyWord.PROCEDURE);
		            procedureSpec=ProcedureSpecification.doParseProcedureSpecification(procedureType); 
		            block.virtualSpecList.add(new VirtualSpecification(identifier,type,Kind.Procedure,procedureSpec));
	            } else {
	        	    block.virtualSpecList.add(new VirtualSpecification(identifier,type,Kind.Procedure,null));
	    	        if(Parser.accept(KeyWord.COMMA)) parseSimpleSpecList(block,type,Kind.Procedure);
	    	        else Parser.expect(KeyWord.SEMICOLON);
	            }
	        }
   		}
    }
	
	private static void parseSimpleSpecList(final ClassDeclaration block,final Type type,final Kind kind) {
		do { String identifier = expectIdentifier();
			 block.virtualSpecList.add(new VirtualSpecification(identifier, type, kind, null));
		} while (Parser.accept(KeyWord.COMMA));
		Parser.expect(KeyWord.SEMICOLON);
	}
	
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		Global.sourceLineNumber=lineNumber;
		if(procedureSpec!=null) procedureSpec.doChecking(this.declaredIn);
		// Label and switch attributes are implicit specified 'protected'
		if(kind==Kind.Label || kind==Kind.Switch)
			((ClassDeclaration)declaredIn).protectedList.add(new ProtectedSpecification((ClassDeclaration)declaredIn,identifier));
		SET_SEMANTICS_CHECKED();
	}

	public String getVirtualIdentifier() {
		ClassDeclaration specifiedIn=(ClassDeclaration)this.declaredIn; // TODO: Kan 'specifiedIn' fjernes
		return (getJavaIdentifier() + '$' + specifiedIn.prefixLevel() + "()");
	}
	  
    // ***********************************************************************************************
    // *** Utility: getVirtualSpecification
    // ***********************************************************************************************
	public static VirtualSpecification getVirtualSpecification(final Declaration decl) {
		if(!(decl.declaredIn instanceof ClassDeclaration)) return (null);
		ClassDeclaration scope=(ClassDeclaration) decl.declaredIn;
		VirtualSpecification virtSpec = scope.searchVirtualSpecList(decl.identifier);
		if (virtSpec != null) return (virtSpec);
		scope = scope.getPrefixClass();

		SEARCH: while (scope != null) {
			HiddenSpecification hdn = scope.searchHiddenList(decl.identifier);
			if (hdn != null) {
				scope = hdn.getScopeBehindHidden();
				continue SEARCH;
			}
			virtSpec = scope.searchVirtualSpecList(decl.identifier);
			if (virtSpec != null) return (virtSpec);
			scope = scope.getPrefixClass();
		}
		return (null);
	}

	public void doJavaCoding() {
		ASSERT_SEMANTICS_CHECKED(this);
	    String matchCode="{ throw new RuntimeException(\"No Virtual Match: "+identifier+"\"); }";
		String qnt = (kind == Kind.Label) ? "LABQNT$ " : "PRCQNT$ ";
		JavaModule.code("public " + qnt + getVirtualIdentifier() + matchCode);
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (type != null) s.append(type).append(' ');
		if (kind == Kind.Procedure)	s.append("PROCEDURE ");
		s.append(identifier);
		s.append("[Specified in ").append(declaredIn.identifier).append(']');
		if (procedureSpec != null) s.append('=').append(procedureSpec);
		return (s.toString());
	}

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	public VirtualSpecification() {
		super(null);
		this.declarationKind=Declaration.Kind.VirtualSpecification;
	}

	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
		Util.TRACE_OUTPUT("VirtualSpec: "+type+' '+identifier+' '+kind);
	    oupt.writeObject(identifier);
	    oupt.writeObject(externalIdent);
	    oupt.writeObject(type);
	    oupt.writeObject(kind);
	    oupt.writeObject(procedureSpec);
	}

	@Override
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
		identifier=(String)inpt.readObject();
		externalIdent=(String)inpt.readObject();
		type=Type.inType(inpt);
		kind=(Kind)inpt.readObject();
		procedureSpec=(ProcedureSpecification)inpt.readObject();
		Util.TRACE_INPUT("VirtualSpec: "+type+' '+identifier+' '+kind);
	}

}
