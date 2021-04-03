/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.statement;

import simula.compiler.JavaModule;

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
	
	public DummyStatement() {
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())	return;
		// No Checking
		SET_SEMANTICS_CHECKED();
	}

	public void doJavaCoding() { /* No Coding */
		ASSERT_SEMANTICS_CHECKED(this);
		JavaModule.code(";");
	}

	public void print(final int indent) {
	}

	public String toString() {
		return ("DUMMY");
	}

}
