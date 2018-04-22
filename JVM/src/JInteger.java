
public class JInteger extends JValue {
	int value;
	public JInteger(int value) { this.value=value; }
	JInteger add(JInteger other) { return(new JInteger(value+other.value)); }
	JInteger mul(JInteger other) { return(new JInteger(value*other.value)); }
	JInteger sub(JInteger other) { return(new JInteger(value-other.value)); }
	JInteger div(JInteger other) { return(new JInteger(value/other.value)); }
	JInteger rem(JInteger other) { return(new JInteger(value^other.value)); }

}
