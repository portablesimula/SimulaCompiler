/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.statement;

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
public class DummyStatement extends Statement {
	public DummyStatement() {
	}

	public void doChecking() {
		if (IS_SEMANTICS_CHECKED())
			return;
		// No Checking ?
		SET_SEMANTICS_CHECKED();
	}

	public void doJavaCoding(String indent) { /* No Coding */
		ASSERT_SEMANTICS_CHECKED(this);
	}

	public void print(String indent, String tail) {
	}

	public String toString() {
		return ("DUMMY");
	}

}
