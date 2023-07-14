package simula.runtime;

/**
 * Simula Runtime Error
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/_Head.java"><b>Source File</b></a>.

 * @author Øystein Myhre Andersen
 *
 */
public class _SimulaRuntimeError extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new _SimulaRuntimeError with the specified detail message.
	 * @param message the detail message
	 */
	public _SimulaRuntimeError(String message) {
		super(message);
	}

	/**
	 * Constructs a new exception with the specified detail message and cause.
	 * @param message the detail message
	 * @param cause the cause
	 */
	public _SimulaRuntimeError(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a new exception with the specified detail cause.
	 * @param cause the cause
	 */
	public _SimulaRuntimeError(Throwable cause) {
		super(cause.getMessage(), cause);
	}
}
