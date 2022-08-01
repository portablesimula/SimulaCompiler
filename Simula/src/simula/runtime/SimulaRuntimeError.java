package simula.runtime;

// ************************************************************
// *** Simula Runtime Errors
// ************************************************************
public class SimulaRuntimeError extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public SimulaRuntimeError(String message) { super(message); }
	public SimulaRuntimeError(String message,Throwable cause) { super(message,cause); }
	public SimulaRuntimeError(Throwable cause) { super(cause.getMessage(),cause); }
}
