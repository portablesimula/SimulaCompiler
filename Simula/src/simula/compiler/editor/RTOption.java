/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.editor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import simula.compiler.utilities.Util;

/**
 * Runtime Options
 * 
 * @author Øystein
 *
 */
public final class RTOption {
	
	public static boolean VERBOSE = false;//true;
	public static boolean DEBUGGING = false;//true;
	public static boolean USE_CONSOLE=false;//true;
	public static boolean CODE_STEP_TRACING = false;// true;
	public static boolean BLOCK_TRACING = false;// true;
	public static boolean GOTO_TRACING = false;// true;
	public static boolean THREAD_TRACING = false;// true;
	public static boolean LOOM_TRACING = false;// true;
	public static boolean QPS_TRACING = false; // true;
	public static boolean SML_TRACING = false; // true;
	public static boolean USE_VIRTUAL_THREAD=true;
	public static String SPORT_SOURCE_FILE;
	public static Vector<String> SPORT_SOURCE_FILES;

    public static void InitRuntimeOptions() {
		RTOption.VERBOSE = false;//true;
		RTOption.DEBUGGING = false;//true;
		RTOption.USE_CONSOLE=true;//false;//true;
		RTOption.CODE_STEP_TRACING = false;// true;
		RTOption.BLOCK_TRACING = false;// true;
		RTOption.GOTO_TRACING = false;// true;
		RTOption.THREAD_TRACING = false;// true;
		RTOption.LOOM_TRACING = false;// true;
		RTOption.QPS_TRACING = false; // true;
		RTOption.SML_TRACING = false; // true;
		RTOption.USE_VIRTUAL_THREAD = true;
		RTOption.SPORT_SOURCE_FILE = null;
	}

	public static void addRTArguments(Vector<String> args) {
		if(RTOption.VERBOSE) args.add("-VERBOSE");
		if(RTOption.DEBUGGING) args.add("-DEBUGGING");
		if(RTOption.USE_CONSOLE) args.add("-USE_CONSOLE");
		if(RTOption.CODE_STEP_TRACING) args.add("-CODE_STEP_TRACING");
		if(RTOption.BLOCK_TRACING) args.add("-BLOCK_TRACING");
		if(RTOption.GOTO_TRACING) args.add("-GOTO_TRACING");
		if(RTOption.THREAD_TRACING) args.add("-THREAD_TRACING");
		if(RTOption.LOOM_TRACING) args.add("-LOOM_TRACING");
		if(RTOption.QPS_TRACING) args.add("-QPS_TRACING");
		if(RTOption.SML_TRACING) args.add("-SML_TRACING");
		if(RTOption.USE_VIRTUAL_THREAD) args.add("-USE_VIRTUAL_THREAD");
		if(RTOption.SPORT_SOURCE_FILE!=null) {
			args.add("-SPORT_SOURCE_FILE");
			args.add(SPORT_SOURCE_FILE);
		}
		if(RTOption.SPORT_SOURCE_FILES!=null) {
			for(String fname:RTOption.SPORT_SOURCE_FILES) {
			args.add("-SPORT_SOURCE_FILES");
			args.add(fname);
			}
		}
	}

//	public static String getRTArguments() {
//		String args="";
//		if(RTOption.VERBOSE) args=args+" -VERBOSE";
//		if(RTOption.DEBUGGING) args=args+" -DEBUGGING";
//		if(RTOption.USE_CONSOLE) args=args+" -USE_CONSOLE";
//		if(RTOption.CODE_STEP_TRACING) args=args+" -CODE_STEP_TRACING";
//		if(RTOption.BLOCK_TRACING) args=args+" -BLOCK_TRACING";
//		if(RTOption.GOTO_TRACING) args=args+" -GOTO_TRACING";
//		if(RTOption.THREAD_TRACING) args=args+" -THREAD_TRACING";
//		if(RTOption.LOOM_TRACING) args=args+" -LOOM_TRACING";
//		if(RTOption.QPS_TRACING) args=args+" -QPS_TRACING";
//		if(RTOption.SML_TRACING) args=args+" -SML_TRACING";
//		if(RTOption.USE_VIRTUAL_THREAD) args=args+" -USE_VIRTUAL_THREAD";
//		return(args);
//	}
		
	public static boolean getOption(String id) {
		if(id.equalsIgnoreCase("VERBOSE")) return(VERBOSE); 
		if(id.equalsIgnoreCase("DEBUGGING")) return(DEBUGGING); 
		if(id.equalsIgnoreCase("USE_CONSOLE")) return(USE_CONSOLE); 
		if(id.equalsIgnoreCase("CODE_STEP_TRACING")) return(CODE_STEP_TRACING); 
		if(id.equalsIgnoreCase("BLOCK_TRACING")) return(BLOCK_TRACING); 
		if(id.equalsIgnoreCase("GOTO_TRACING")) return(GOTO_TRACING); 
		if(id.equalsIgnoreCase("THREAD_TRACING")) return(THREAD_TRACING); 
		if(id.equalsIgnoreCase("LOOM_TRACING")) return(LOOM_TRACING); 
		if(id.equalsIgnoreCase("QPS_TRACING")) return(QPS_TRACING); 
		if(id.equalsIgnoreCase("SML_TRACING")) return(SML_TRACING); 
		if(id.equalsIgnoreCase("USE_VIRTUAL_THREAD")) return(USE_VIRTUAL_THREAD); 
		return(false);
	}

	public static void setOption(String id,boolean val) {
		if(id.equalsIgnoreCase("VERBOSE")) VERBOSE=val; 
		if(id.equalsIgnoreCase("DEBUGGING")) DEBUGGING=val; 
		if(id.equalsIgnoreCase("USE_CONSOLE")) USE_CONSOLE=val; 
		if(id.equalsIgnoreCase("CODE_STEP_TRACING")) CODE_STEP_TRACING=val; 
		if(id.equalsIgnoreCase("BLOCK_TRACING")) BLOCK_TRACING=val; 
		if(id.equalsIgnoreCase("GOTO_TRACING")) GOTO_TRACING=val; 
		if(id.equalsIgnoreCase("THREAD_TRACING")) THREAD_TRACING=val; 
		if(id.equalsIgnoreCase("LOOM_TRACING")) LOOM_TRACING=val; 
		if(id.equalsIgnoreCase("QPS_TRACING")) QPS_TRACING=val; 
		if(id.equalsIgnoreCase("SML_TRACING")) SML_TRACING=val; 
		if(id.equalsIgnoreCase("USE_VIRTUAL_THREAD")) USE_VIRTUAL_THREAD=val; 
	}
    
    public static void selectRuntimeOptions() {
    	JPanel panel=new JPanel();
    	panel.setBackground(Color.white);
    	panel.add(checkBox("Verbose"));
    	panel.add(checkBox("DEBUGGING"));
        panel.add(checkBox("USE_CONSOLE"));
        panel.add(checkBox("CODE_STEP_TRACING"));
        panel.add(checkBox("BLOCK_TRACING"));
        panel.add(checkBox("GOTO_TRACING"));
        panel.add(checkBox("THREAD_TRACING"));
        panel.add(checkBox("LOOM_TRACING"));
        panel.add(checkBox("QPS_TRACING"));
        panel.add(checkBox("SML_TRACING"));
        panel.add(checkBox("USE_VIRTUAL_THREAD"));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		Util.optionDialog(panel,"Select Runtime Options",JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,"Ok");
    }

	private static JCheckBox checkBox(String id) {
        JCheckBox item = new JCheckBox(id);
    	item.setBackground(Color.white);
        item.setSelected(RTOption.getOption(id));
        item.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		RTOption.setOption(id,item.isSelected());
		}});
        return(item);
	}

}