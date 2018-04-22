public abstract class JInstruction {
	private String label; // = null if no label

	public abstract void execute(JVM context);
	// etc.
	public JInstruction(String label)
	{ this.label=label; }
}