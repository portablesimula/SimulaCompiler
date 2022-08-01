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
import java.util.Iterator;
import java.util.Vector;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Type;
import simula.compiler.utilities.Util;

/**
 * 
 * @author Øystein Myhre Andersen
 */
public final class ProcedureSpecification implements Externalizable {
	public String identifier;
	public Type type;
	public Vector<Parameter> parameterList;

	// ***********************************************************************************************
	// *** CONSTRUCTORS
	// ***********************************************************************************************
	private ProcedureSpecification(final String identifier, final Type type, final Vector<Parameter> parameterList) {
		this.identifier = identifier;
		this.type = type;
		this.parameterList = parameterList;
	}

	// ***********************************************************************************************
	// *** Parsing: doParseProcedureSpecification
	// ***********************************************************************************************
	/**
	 * Procedure Specification.
	 * 
	 * <pre>
	 * Syntax:
	 * 
	 * ProcedureSpecification
	 *     = [ type ] PROCEDURE ProcedureIdentifier ProcedureHead EmptyBody
	 *     
	 * ProcedureHead
	 *     = [ FormalParameterPart ; [ ModePart ] ProcedureSpecificationPart  ] ;
	 *         
	 * EmptyBody = DummyStatement
	 * 
	 * ProcedureIdentifier = Identifier
	 * 
	 * </pre>
	 */
	public static ProcedureSpecification doParseProcedureSpecification(final Type type) {
		ProcedureDeclaration block = ProcedureDeclaration.doParseProcedureDeclaration(type);
		if (Option.TRACE_PARSE)	Util.TRACE("END ProcedureSpecification: " + block);
//		Global.currentScope = block.declaredIn;
		Global.setScope(block.declaredIn);
		ProcedureSpecification procedureSpecification = new ProcedureSpecification(block.identifier, type, block.parameterList);
		return (procedureSpecification);
	}

	// ***********************************************************************************************
	// *** Utility: doChecking
	// ***********************************************************************************************
	public void doChecking(final DeclarationScope scope) {
		if (type != null) type.doChecking(scope);
		// Check parameters
		for (Parameter par : parameterList)	par.doChecking();
	}

	// ***********************************************************************************************
	// *** Utility: checkCompatible --
	// ***********************************************************************************************
	public boolean checkCompatible(final ProcedureDeclaration proc) {
		if (type != null && !type.equals(proc.type)) return (false);
		// Check parameters
		Iterator<Parameter> formalIterator = parameterList.iterator();
		Iterator<Parameter> actualIterator = proc.parameterList.iterator();
		while (actualIterator.hasNext()) {
			if (!formalIterator.hasNext())
				return (false); // Util.error("Wrong number of parameters to " + block);
			Parameter formalParameter = (Parameter) formalIterator.next();
			Parameter actualParameter = actualIterator.next();
			if (!formalParameter.equals(actualParameter)) return (false);
		}
		if (formalIterator.hasNext())
			return (false); // Util.error("Wrong number of parameters to " + block);
		return (true);
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (type != null) s.append(type).append(' ');
		s.append("PROCEDURE ").append(identifier).append(Parameter.editParameterList(parameterList));
		return (s.toString());
	}

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	public ProcedureSpecification() {}

	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
		Util.TRACE_OUTPUT("BEGIN Write ProcedureSpecification: "+identifier);
		oupt.writeObject(identifier);
		oupt.writeObject(type);

		oupt.writeObject(parameterList);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
		identifier=(String)inpt.readObject();
		type=Type.inType(inpt);
		
		parameterList=(Vector<Parameter>) inpt.readObject();
		Util.TRACE_INPUT("END Read ProcedureSpecification: "+identifier);
	}

}
