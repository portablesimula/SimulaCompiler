/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.editor;

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
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/editor/RTOption.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class RTOption {
	/** Runtime Option */ public static boolean VERBOSE = false;//true;
	/** Runtime Option */ public static boolean USE_CONSOLE=false;//true;
	/** Runtime Option */ public static boolean BLOCK_TRACING = false;// true;
	/** Runtime Option */ public static boolean GOTO_TRACING = false;// true;
	/** Runtime Option */ public static boolean QPS_TRACING = false; // true;
	/** Runtime Option */ public static boolean SML_TRACING = false; // true;
	/** Runtime Option */ public static String SPORT_SOURCE_FILE;

	/**
	 * The default constructor
	 */
	private RTOption() {}

	/**
	 * Initiate Runtime options with default values.
	 */
    public static void InitRuntimeOptions() {
		RTOption.VERBOSE = false;
		RTOption.USE_CONSOLE=true;
		RTOption.BLOCK_TRACING = false;
		RTOption.GOTO_TRACING = false;
		RTOption.QPS_TRACING = false;
		RTOption.SML_TRACING = false;
		RTOption.SPORT_SOURCE_FILE = null;
	}

    /**
     * Add Runtime options to the argument vector.
     * @param args the argument vector
     */
	public static void addRTArguments(Vector<String> args) {
		if(RTOption.VERBOSE) args.add("-verbose");
		if(RTOption.USE_CONSOLE) args.add("-useConsole");
		if(RTOption.BLOCK_TRACING) args.add("-blockTracing");
		if(RTOption.GOTO_TRACING) args.add("-gotoTracing");
		if(RTOption.QPS_TRACING) args.add("-qpsTracing");
		if(RTOption.SML_TRACING) args.add("-smlTracing");
		if(RTOption.SPORT_SOURCE_FILE!=null) {
			args.add("-SPORT_SOURCE_FILE");
			args.add(SPORT_SOURCE_FILE);
		}
	}
    
	/**
	 * Editor Utility: Select Runtime Options.
	 */
    static void selectRuntimeOptions() {
    	JPanel panel=new JPanel();
    	panel.setBackground(Color.white);
    	panel.add(checkBox("Verbose"));
        panel.add(checkBox("USE_CONSOLE"));
        panel.add(checkBox("BLOCK_TRACING"));
        panel.add(checkBox("GOTO_TRACING"));
        panel.add(checkBox("QPS_TRACING"));
        panel.add(checkBox("SML_TRACING"));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		Util.optionDialog(panel,"Select Runtime Options",JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,"Ok");
    }

	/**
	 * Editor Utility: Create a checkBox without tooltips.
	 * @param id option id
	 * @return the resulting check box
	 */
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

	/**
	 * Returns the option name 'id'
	 * @param id option id
	 * @return the option name 'id'
	 */
	private static boolean getOption(String id) {
		if(id.equalsIgnoreCase("VERBOSE")) return(VERBOSE); 
		if(id.equalsIgnoreCase("USE_CONSOLE")) return(USE_CONSOLE); 
		if(id.equalsIgnoreCase("BLOCK_TRACING")) return(BLOCK_TRACING); 
		if(id.equalsIgnoreCase("GOTO_TRACING")) return(GOTO_TRACING); 
		if(id.equalsIgnoreCase("QPS_TRACING")) return(QPS_TRACING); 
		if(id.equalsIgnoreCase("SML_TRACING")) return(SML_TRACING); 
		return(false);
	}

	/**
	 * Set the option named 'id' to the given value
	 * @param id option id
	 * @param val new option value
	 */
	private static void setOption(String id,boolean val) {
		if(id.equalsIgnoreCase("VERBOSE")) VERBOSE=val; 
		if(id.equalsIgnoreCase("USE_CONSOLE")) USE_CONSOLE=val;
		if(id.equalsIgnoreCase("BLOCK_TRACING")) BLOCK_TRACING=val; 
		if(id.equalsIgnoreCase("GOTO_TRACING")) GOTO_TRACING=val; 
		if(id.equalsIgnoreCase("QPS_TRACING")) QPS_TRACING=val; 
		if(id.equalsIgnoreCase("SML_TRACING")) SML_TRACING=val; 
	}

}