/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.statement;

import simula.compiler.GeneratedJavaClass;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Dummy Statement.
 * 
 * <pre>
 * 
 * Syntax:
 * 
 * DummyStatement = Empty
 * 
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 */
public final class DummyStatement extends Statement {
	
	DummyStatement(final int line) {
		super(line);
		if (Option.TRACE_PARSE) Util.TRACE("Line "+lineNumber+": DummyStatement: "+this);
	}

	@Override
	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		// No Checking
		SET_SEMANTICS_CHECKED();
	}

	@Override
	public void doJavaCoding() { /* No Coding */
		ASSERT_SEMANTICS_CHECKED(this);
		GeneratedJavaClass.code(";");
	}

	@Override
	public void print(final int indent) {
	}

	@Override
	public String toString() {
		return ("DUMMY");
	}

}
