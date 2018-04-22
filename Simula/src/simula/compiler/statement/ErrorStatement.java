/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.statement;

/**
 * Error Statement.
 * 
 * @author Øystein Myhre Andersen
 */
public class ErrorStatement extends Statement {
	Throwable exception;

	public ErrorStatement(Throwable exception) {
		this.exception = exception;
	}

	public String toString() {
		return ("error " + exception);
	}
}
