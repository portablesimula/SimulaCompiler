package simula.runtime;

/**
 * Simula Runtime Error
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_SimulaRuntimeError.java"><b>Source File</b></a>.

 * @author Øystein Myhre Andersen
 *
 */
@SuppressWarnings("serial")
public class RTS_SimulaRuntimeError extends RuntimeException {

	/**
	 * Constructs a new RTS_SimulaRuntimeError with the specified detail message.
	 * @param message the detail message
	 */
	public RTS_SimulaRuntimeError(String message) {
		super(message);
	}

	/**
	 * Constructs a new exception with the specified detail message and cause.
	 * @param message the detail message
	 * @param cause the cause
	 */
	public RTS_SimulaRuntimeError(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a new exception with the specified detail cause.
	 * @param cause the cause
	 */
	public RTS_SimulaRuntimeError(Throwable cause) {
		super(cause.getMessage(), cause);
	}
}
