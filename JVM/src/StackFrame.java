import java.util.Stack;

public class StackFrame {
    private Stack<JValue> operands;
    private JValue[] locals;
    private int pc;
    private JMethod method;
    private StackFrame cf;
    // etc.
    public Stack<JValue> getOperands() { return(operands); }
    public JInstruction nextInstruction() { return(null); }
}