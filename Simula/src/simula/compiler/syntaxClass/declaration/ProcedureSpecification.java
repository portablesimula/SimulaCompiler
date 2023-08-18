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
import java.util.Vector;

import simula.compiler.syntaxClass.Type;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Procedure Specification.
 * <pre>
 * Simula Standard: 5.5.3 Virtual quantities
 * Simula Standard: 6.3 External procedure declaration
 * 
 * procedure-specification
 *     = [ type ] PROCEDURE procedure-identifier procedure-head empty-body
 *     
 *    procedure-head
 *        = [ formal-parameter-part ; [ mode-part ] specification-part  ] ;
 *         
 *    empty-body = dummy-statement
 * 
 *    procedure-identifier = identifier
 * 
 *       formal-parameter-part = "(" formal-parameter { , formal-parameter } ")"
 *       
 *          formal-parameter = identifier
 *          
 *       specification-part = specifier identifier-list ; { specifier identifier-list ; }
 *       
 *          specifier
 *             = type [ array | procedure ]
 *             | label
 *             | switch
 *             
 *       mode-part 
 *          = name-part [ value-part ]
 *          | value-part [ name-part ]
 *          
 *          name-part = name identifier-list ;
 *          value-part = value identifier-list ;
 *          
 *             identifier-list = identifier { , identifier }
 * </pre>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/declaration/ProcedureSpecification.java">
 * <b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public final class ProcedureSpecification implements Externalizable {
	
	/**
	 * The procedure identifier.
	 */
	private String identifier;

	/**
	 * The procedure's type.
	 */
	public Type type;
	
	/**
	 * The parameter list.
	 */
	public Vector<Parameter> parameterList;

	// ***********************************************************************************************
	// *** CONSTRUCTORS
	// ***********************************************************************************************
	/**
	 * Create a new ProcedureSpecification
	 * @param identifier procedure-identifier
	 * @param type procedure's type or null
	 * @param pList the parameter lList
	 */
	private ProcedureSpecification(final String identifier, final Type type, final Vector<Parameter> pList) {
		this.identifier = identifier;
		this.type = type;
		this.parameterList = pList;
	}

	// ***********************************************************************************************
	// *** Parsing: expectProcedureSpecification
	// ***********************************************************************************************
	/**
	 * Procedure Specification.
	 * 
	 * <pre>
	 * Syntax:
	 * 
	 * procedure-specification
	 *     = [ type ] PROCEDURE procedure-identifier procedure-head empty-body
	 *     
	 *    procedure-head
	 *        = [ formal-parameter-part ; [ mode-part ] procedure-specification-part  ] ;
	 *         
	 *    empty-body = dummy-statement
	 * 
	 *    procedure-identifier = identifier
	 * 
	 * </pre>
	 * Precondition:  [ type ] PROCEDURE  is already read.
	 * @param type procedure's type
	 * @return a newly created ProcedureSpecification
	 */
	static ProcedureSpecification expectProcedureSpecification(final Type type) {
		ProcedureDeclaration block = ProcedureDeclaration.expectProcedureDeclaration(type);
		if (Option.TRACE_PARSE)
			Util.TRACE("END ProcedureSpecification: " + block);
		Global.setScope(block.declaredIn);
		ProcedureSpecification procedureSpecification = new ProcedureSpecification(block.identifier, type,
				block.parameterList);
		return (procedureSpecification);
	}

	// ***********************************************************************************************
	// *** Utility: doChecking
	// ***********************************************************************************************
	/**
	 * Perform semantic checking.
	 * 
	 * @param scope the DeclarationScope
	 */
	void doChecking(final DeclarationScope scope) {
		if (type != null)
			type.doChecking(scope);
		// Check parameters
		for (Parameter par : parameterList)
			par.doChecking();
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (type != null)
			s.append(type).append(' ');
		s.append("PROCEDURE ").append(identifier).append(Parameter.editParameterList(parameterList));
		return (s.toString());
	}

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	/**
	 * Default constructor used by Externalization.
	 */
	public ProcedureSpecification() {
	}

	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
		Util.TRACE_OUTPUT("BEGIN Write ProcedureSpecification: " + identifier);
		oupt.writeObject(identifier);
		oupt.writeObject(type);

		oupt.writeObject(parameterList);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
		identifier = (String) inpt.readObject();
		type = Type.inType(inpt);

		parameterList = (Vector<Parameter>) inpt.readObject();
		Util.TRACE_INPUT("END Read ProcedureSpecification: " + identifier);
	}

}
