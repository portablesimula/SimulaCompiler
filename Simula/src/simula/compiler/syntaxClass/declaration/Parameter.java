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
import simula.compiler.utilities.Util;
	
/**
 * Parameter Declaration.
 * <p>
 * A parameter models class and procedure parameters.
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/syntaxClass/declaration/Parameter.java">
 * <b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class Parameter extends Declaration implements Externalizable {
	// String identifier; // Inherited
	// String externalIdent; // Inherited
	// Type type; // Inherited:
	
	/**
	 * Parameter transfer Mode.
	 */
	public Parameter.Mode mode;
	
	/**
	 * Parameter Kind.
	 */
	public Parameter.Kind kind;
	
	/**
	 * Parameter's number of dimension in case of array kind.
	 * Set during doChecking
	 */
	public int nDim = -1;

	/**
	 * Procedure parameter transfer Mode.
	 */
	public enum Mode {
		/**
		 * Parameter transfered by value
		 */
		value,
		/**
		 * Parameter transfered by name
		 */
		name
	}

	/**
	 * Procedure parameter Kind.
	 */
	public enum Kind {
		/**
		 * Simple parameter.
		 */
		Simple,
		/**
		 * Procedure parameter.
		 */
		Procedure,
		/**
		 * Array parameter.
		 */
		Array,
		/**
		 * Label parameter.
		 */
		Label
	}

	/**
	 * Create a new Parameter.
	 * @param identifier parameter identifier
	 */
	Parameter(final String identifier) {
		super(identifier);
		this.declarationKind = Declaration.Kind.Parameter;
	}

	/**
	 * Create a new Parameter.
	 * @param identifier parameter identifier
	 * @param type parameter type
	 * @param kind parameter kind
	 */
	Parameter(final String identifier, final Type type, final Parameter.Kind kind) {
		this(identifier);
		this.type = type;
		this.kind = kind;
	}

	/**
	 * Create a new Parameter.
	 * @param identifier parameter identifier
	 * @param type parameter type
	 * @param kind parameter kind
	 * @param nDim parameter's number of dimension in case of array kind.
	 */
	public Parameter(final String identifier, final Type type, final Parameter.Kind kind, final int nDim) {
		this(identifier, type, kind);
		this.nDim = nDim;
	}

	// ***********************************************************************************************
	// *** Utility: into
	// ***********************************************************************************************
	/**
	 * Add this parameter to the given parameter list.
	 * @param parameterList the given parameter list
	 */
	void into(final Vector<Parameter> parameterList) {
		for (Parameter par : parameterList)
			if (Util.equals(par.identifier, this.identifier)) {
				Util.error("Parameter already defined: " + identifier);
				return;
			}
		parameterList.add(this);
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Parameter))
			return (false);
		Parameter otherPar = (Parameter) other;
		if (!type.equals(otherPar.type))
			return (false);
		if (kind != otherPar.kind)
			return (false);
		if (mode != otherPar.mode)
			return (false);
		return (true);
	}

	/**
	 * Utility: Set new parameter mode.
	 * @param mode the new mode
	 */
	void setMode(final Parameter.Mode mode) {
		if (this.mode != null)
			Util.error("Parameter " + identifier + " is already specified by " + this.mode);
		this.mode = mode;
	}

	/**
	 * Utility: Set new type and kind.
	 * @param type the new type
	 * @param kind the new kind
	 */
	void setTypeAndKind(final Type type, final Parameter.Kind kind) {
		this.type = type;
		this.kind = kind;
	}

	/**
	 * Utility: Set new external identifier based on the given prefix level.
	 * @param prefixLevel the given prefix level
	 */
	void setExternalIdentifier(final int prefixLevel) {
		if (prefixLevel > 0)
			externalIdent = "p" + prefixLevel + '_' + identifier;
		else
			externalIdent = "p_" + identifier;
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())
			return;
		Global.sourceLineNumber = lineNumber;
		if (kind == null) {
			Util.error("Parameter " + identifier + " is not specified -- assumed Simple Integer");
			kind = Kind.Simple;
			type = Type.Integer;
		}
		if (type != null)
			type.doChecking(Global.getCurrentScope().declaredIn);
		if (!legalTransmitionMode())
			Util.error("Illegal transmission mode: " + mode + ' ' + kind + ' ' + identifier + " by "
					+ ((mode != null) ? mode : "default") + " is not allowed");
		SET_SEMANTICS_CHECKED();
	}

	/**
	 * Check if the parameter has a legal transmission mode.
	 * <p>
	 * The available transmission modes for the different kinds of parameters to
	 * procedures.
	 * 
	 * <pre>
	 *     --------------------------------------------------------------
	 *    |                       |         Transmission modes           |
	 *    |   Parameter           | - - - - - - - - - - - - - - - - - - -|
	 *    |                       |  by value | by reference |  by name  |
	 *    |--------------------------------------------------------------|
	 *    |   value type          |     D     |       I      |     O     |
	 *    |   object ref. type    |     I     |       D      |     O     |
	 *    |   text                |     O     |       D      |     O     |
	 *    |   value type array    |     O     |       D      |     O     |
	 *    |   reference type array|     I     |       D      |     O     |
	 *    |   procedure           |     I     |       D      |     O     |
	 *    |   type procedure      |     I     |       D      |     O     |
	 *    |   label               |     I     |       D      |     O     |
	 *    |   switch              |     I     |       D      |     O     |
	 *     --------------------------------------------------------------
	 *
	 *        D:  default mode       O:  optional mode       I:  illegal
	 * </pre>
	 * @return true if the parameter has a legal transmission mode
	 */
	private boolean legalTransmitionMode() {
		boolean illegal = false;
		switch (kind) {
		case Simple:
			if (type == Type.Text)
				break; // Simple Text
			else if (type.isReferenceType()) {
				if (mode == Parameter.Mode.value)
					illegal = true;
			} // Simple ref(ClassIdentifier)
			else if (mode == null)
				mode = Parameter.Mode.value; // Simple Type Integer, Real, Character
			break;
		case Array:
			if (type.isReferenceType() && mode == Parameter.Mode.value)
				illegal = true;
			break;
		case Procedure:
		case Label:
			if (mode == Parameter.Mode.value)
				illegal = true;
			break;
		default:
		}
		return (!illegal);
	}

	/**
	 * Coding utility: edit Java code version of this parameter's type.
	 * @return the resulting Java code
	 */
	String toJavaType() {
		ASSERT_SEMANTICS_CHECKED();
		if (mode == Parameter.Mode.name) {
			switch (kind) {
			case Simple:
				if (type == Type.Label)
					return ("RTS_NAME<RTS_LABEL>");
				return ("RTS_NAME<" + type.toJavaTypeClass() + ">");
			case Procedure:
				return ("RTS_NAME<RTS_PRCQNT>");
			case Label:
				return ("RTS_NAME<RTS_LABEL>");
			case Array:
				return ("RTS_NAME<RTS_ARRAY>");
			}
		}
		switch (kind) {
		case Array:
			return ("RTS_ARRAY");
		case Label:
			return ("RTS_LABEL");
		case Procedure:
			return ("RTS_PRCQNT");
		case Simple: // Fall through
		}
		return (type.toJavaType());
	}

	@Override
	public String toJavaCode() {
		return (toJavaType() + ' ' + externalIdent);
	}

	// ***********************************************************************************************
	// *** Printing Utility: editParameterList
	// ***********************************************************************************************
	/**
	 * Printing Utility: edit parameter list.
	 * @param parameterList the given parameter list
	 * @return the resulting string
	 */
	static String editParameterList(Vector<Parameter> parameterList) {
		StringBuilder s = new StringBuilder();
		s.append('(');
		boolean first = true;
		for (Parameter par : parameterList) {
			if (!first)
				s.append(',');
			s.append(par);
			first = false;
		}
		s.append(");");
		return (s.toString());
	}
	
	@Override
	public void printTree(final int indent) {
		System.out.println(edTreeIndent(indent)+this);
	}
	
	@Override
	public String toString() {
		String s = "";
		if (type != null)
			s = s + type;
		else
			s = "NOTYPE";
		if (mode != null)
			s = "" + mode + " " + type;
		if (kind == null)
			s = s + " NOKIND";
		if (nDim > 0)
			s = s + " " + nDim + "-Dimentional";
		else if (kind != Parameter.Kind.Simple)
			s = s + " " + kind;
		return (s + ' ' + identifier + "(" + externalIdent + ')');
	}

	// ***********************************************************************************************
	// *** Externalization
	// ***********************************************************************************************
	/**
	 * Default constructor used by Externalization.
	 */
	public Parameter() {
		super(null);
		this.declarationKind = Declaration.Kind.Parameter;
	}

	@Override
	public void writeExternal(ObjectOutput oupt) throws IOException {
		Util.TRACE_OUTPUT("Parameter: " + type + ' ' + identifier + ' ' + kind + ' ' + mode);
		oupt.writeObject(identifier);
		oupt.writeObject(externalIdent);
		oupt.writeObject(type);
		oupt.writeObject(kind);
		oupt.writeObject(mode);
	}

	@Override
	public void readExternal(ObjectInput inpt) throws IOException, ClassNotFoundException {
		identifier = (String) inpt.readObject();
		externalIdent = (String) inpt.readObject();
		type = Type.inType(inpt);
		kind = (Parameter.Kind) inpt.readObject();
		mode = (Parameter.Mode) inpt.readObject();
		Util.TRACE_INPUT("Parameter: " + type + ' ' + identifier + ' ' + kind + ' ' + mode);
	}

}
