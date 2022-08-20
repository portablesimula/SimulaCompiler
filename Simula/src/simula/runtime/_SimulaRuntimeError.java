package simula.runtime;

// ************************************************************
// *** Simula Runtime Errors
// ************************************************************
public class _SimulaRuntimeError extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public _SimulaRuntimeError(String message) { super(message); }
	public _SimulaRuntimeError(String message,Throwable cause) { super(message,cause); }
	public _SimulaRuntimeError(Throwable cause) { super(cause.getMessage(),cause); }
}
