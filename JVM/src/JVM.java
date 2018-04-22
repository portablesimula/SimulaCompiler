public class JVM {

	private StackFrame topFrame;
	private Heap heap;
	private ClassArea classes;

	public void run() {
		while (topFrame != null) {
			JInstruction next = topFrame.nextInstruction();
			next.execute(this);
		}
	}

	public StackFrame getTopFrame() {
		return (topFrame);
	}
}