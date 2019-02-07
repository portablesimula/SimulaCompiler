/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;

/**
 * Runtime Options
 * 
 * @author Øystein
 *
 */
public final class RTOption {
	
	public static boolean VERBOSE = false;//true;
	public static boolean USE_CONSOLE=false;//true;
	public static boolean CODE_STEP_TRACING = false;// true;
	public static boolean BLOCK_TRACING = false;// true;
	public static boolean GOTO_TRACING = false;// true;
	public static boolean THREAD_TRACING = false;// true;
	public static boolean THREADSWAP_TRACING = false;// true;
	public static boolean QPS_TRACING = false; // true;
	public static boolean SML_TRACING = false; // true;

	public static String getRTArguments() {
		String args="";
		if(RTOption.VERBOSE) args=args+" -VERBOSE";
		if(RTOption.USE_CONSOLE) args=args+" -USE_CONSOLE";
		if(RTOption.CODE_STEP_TRACING) args=args+" -CODE_STEP_TRACING";
		if(RTOption.BLOCK_TRACING) args=args+" -BLOCK_TRACING";
		if(RTOption.GOTO_TRACING) args=args+" -GOTO_TRACING";
		if(RTOption.THREAD_TRACING) args=args+" -THREAD_TRACING";
		if(RTOption.THREADSWAP_TRACING) args=args+" -THREADSWAP_TRACING";
		if(RTOption.QPS_TRACING) args=args+" -QPS_TRACING";
		if(RTOption.SML_TRACING) args=args+" -SML_TRACING";
		return(args);
	}
		
	public static boolean getOption(String id) {
		if(id.equalsIgnoreCase("VERBOSE")) return(VERBOSE); 
		if(id.equalsIgnoreCase("USE_CONSOLE")) return(USE_CONSOLE); 
		if(id.equalsIgnoreCase("CODE_STEP_TRACING")) return(CODE_STEP_TRACING); 
		if(id.equalsIgnoreCase("BLOCK_TRACING")) return(BLOCK_TRACING); 
		if(id.equalsIgnoreCase("GOTO_TRACING")) return(GOTO_TRACING); 
		if(id.equalsIgnoreCase("THREAD_TRACING")) return(THREAD_TRACING); 
		if(id.equalsIgnoreCase("THREADSWAP_TRACING")) return(THREADSWAP_TRACING); 
		if(id.equalsIgnoreCase("QPS_TRACING")) return(QPS_TRACING); 
		if(id.equalsIgnoreCase("SML_TRACING")) return(SML_TRACING); 
		return(false);
	}

	public static void setOption(String id,boolean val) {
		if(id.equalsIgnoreCase("VERBOSE")) VERBOSE=val; 
		if(id.equalsIgnoreCase("USE_CONSOLE")) USE_CONSOLE=val; 
		if(id.equalsIgnoreCase("CODE_STEP_TRACING")) CODE_STEP_TRACING=val; 
		if(id.equalsIgnoreCase("BLOCK_TRACING")) BLOCK_TRACING=val; 
		if(id.equalsIgnoreCase("GOTO_TRACING")) GOTO_TRACING=val; 
		if(id.equalsIgnoreCase("THREAD_TRACING")) THREAD_TRACING=val; 
		if(id.equalsIgnoreCase("THREADSWAP_TRACING")) THREADSWAP_TRACING=val; 
		if(id.equalsIgnoreCase("QPS_TRACING")) QPS_TRACING=val; 
		if(id.equalsIgnoreCase("SML_TRACING")) SML_TRACING=val; 
	}

	public static JCheckBoxMenuItem checkItem(String id) {
        JCheckBoxMenuItem item = new JCheckBoxMenuItem(id);
        item.setSelected(RTOption.getOption(id));
		//Util.println("RTOption.checkItem("+id+") Selected="+item.isSelected());
        item.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//Util.println(id+"Item.actionPerformed: e="+e);
        		RTOption.setOption(id,item.isSelected());
        		//Util.println(id+"Item.actionPerformed: Option."+id+"="+RTOption.getOption(id));            		
		}});
        return(item);
	}

}