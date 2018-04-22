import java.util.Stack;

public class IAdd extends JInstruction {
   public IAdd(String label) { super(label); }
    public IAdd() { this(null); }
    
    public void execute(JVM context) {
        // get operands stack from the JVM's top frame:
        Stack<JValue> stack = context.getTopFrame().getOperands();

        if (stack.size() < 2) {
            System.out.println("not enough operands on stack");
            System.exit(1);
        }

        // remove top 2 items from stack
        JValue val1 = stack.pop();
        JValue val2 = stack.pop();
        
        if (!(val1 instanceof JInteger) || 
            !(val2 instanceof JInteger)) {
               System.out.println("IAdd can't add non integers");
               System.exit(1);
        }
        
        JInteger int1 = (JInteger)val1;
        JInteger int2 = (JInteger)val2;
        JInteger result = int1.add(int2);
        
        // push sum onto stack:
        stack.push(result);
    }
}