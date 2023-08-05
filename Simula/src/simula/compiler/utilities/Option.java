/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.utilities;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Compile Time Options.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/utilities/Option.java"><b>Source File</b></a>.
 * 
 * @author Øystein
 *
 */
public final class Option {

	public static boolean INLINE_TESTING = false; 
	public static boolean CaseSensitive=false;
	public static boolean verbose = false; 
	public static boolean WARNINGS=true;
	public static boolean noExecution = false;	// true: Don't execute generated .jar file.
	public static boolean EXTENSIONS=true;
	public static boolean SPORT=false;
	public static File keepJava = null;			// Used by Java-Coding to save the generated .java files.
												// If not set, a temp directory is used/created.

	// Overall TRACING Options
	public static boolean TRACING=false;
	public static boolean DEBUGGING=false;		// Set by EditorMenues - doDebugAction

	// Scanner Trace Options
	public static boolean TRACE_SCAN=false;
	public static boolean TRACE_COMMENTS=false;

	// Parser Trace Options
	public static boolean TRACE_PARSE=true;
	public static boolean TRACE_ATTRIBUTE_OUTPUT=false;
	public static boolean TRACE_ATTRIBUTE_INPUT=false;

	// Checker Trace Options
	public static boolean TRACE_CHECKER=false;
	public static boolean TRACE_CHECKER_OUTPUT=false;
	public static int TRACE_FIND_MEANING=0;

	// Java Coder Options
	public static boolean TRACE_CODING=false;
	public static boolean GNERATE_LINE_CALLS=false;

	// Byte code engineering Options
	public static boolean USE_FILE_CLASS_API=false;
	public static boolean TRACE_BYTECODE_OUTPUT=false;
	public static boolean LIST_REPAIRED_INSTRUCTION_LIST=false;
	public static boolean TRACE_REPAIRING=false;

	// Runtime Options
	public static String SOURCE_FILE="";
	public static String RUNTIME_USER_DIR="";



	public static void InitCompilerOptions() {
		Option.CaseSensitive=false;
		Option.verbose = false;
		Option.noExecution = false;
		Option.WARNINGS=true;
		Option.EXTENSIONS=true;
		Option.SPORT=false;

		// Overall TRACING Options
		Option.TRACING=false;
		Option.DEBUGGING=false;

		// Scanner Trace Options
		Option.TRACE_SCAN=false;
		Option.TRACE_COMMENTS=false;

		// Parser Trace Options
		Option.TRACE_PARSE=false;

		// Checker Trace Options
		Option.TRACE_CHECKER=false;
		Option.TRACE_CHECKER_OUTPUT=false;

		// Coder Trace Options
		Option.TRACE_CODING=false;

	}

	public static boolean getOption(String id) {
		if(id.equalsIgnoreCase("CaseSensitive")) return(CaseSensitive); 
		if(id.equalsIgnoreCase("VERBOSE")) return(verbose); 
		if(id.equalsIgnoreCase("noExecution")) return(noExecution); 
		if(id.equalsIgnoreCase("WARNINGS")) return(WARNINGS); 
		if(id.equalsIgnoreCase("EXTENSIONS")) return(EXTENSIONS); 
		if(id.equalsIgnoreCase("SPORT")) return(SPORT); 
		if(id.equalsIgnoreCase("TRACING")) return(TRACING); 
		if(id.equalsIgnoreCase("TRACE_SCAN")) return(TRACE_SCAN); 
		if(id.equalsIgnoreCase("TRACE_COMMENTS")) return(TRACE_COMMENTS); 
		if(id.equalsIgnoreCase("TRACE_PARSE")) return(TRACE_PARSE); 
		if(id.equalsIgnoreCase("TRACE_ATTRIBUTE_OUTPUT")) return(TRACE_ATTRIBUTE_OUTPUT); 
		if(id.equalsIgnoreCase("TRACE_ATTRIBUTE_INPUT")) return(TRACE_ATTRIBUTE_INPUT); 
		if(id.equalsIgnoreCase("TRACE_CHECKER")) return(TRACE_CHECKER); 
		if(id.equalsIgnoreCase("TRACE_CHECKER_OUTPUT")) return(TRACE_CHECKER_OUTPUT); 
		if(id.equalsIgnoreCase("TRACE_CODING")) return(TRACE_CODING); 
		if(id.equalsIgnoreCase("TRACE_BYTECODE_OUTPUT")) return(TRACE_BYTECODE_OUTPUT); 
		return(false);
	}


	public static void setOption(String id,boolean val) {
		if(id.equalsIgnoreCase("CaseSensitive")) CaseSensitive=val; 
		if(id.equalsIgnoreCase("VERBOSE")) verbose=val; 
		if(id.equalsIgnoreCase("noExecution")) noExecution=val; 
		if(id.equalsIgnoreCase("WARNINGS")) WARNINGS=val; 
		if(id.equalsIgnoreCase("EXTENSIONS")) EXTENSIONS=val; 
		if(id.equalsIgnoreCase("SPORT")) SPORT=val; 
		if(id.equalsIgnoreCase("TRACING")) TRACING=val; 
		if(id.equalsIgnoreCase("TRACE_SCAN")) TRACE_SCAN=val; 
		if(id.equalsIgnoreCase("TRACE_COMMENTS")) TRACE_COMMENTS=val; 
		if(id.equalsIgnoreCase("TRACE_PARSE")) TRACE_PARSE=val; 
		if(id.equalsIgnoreCase("TRACE_ATTRIBUTE_OUTPUT")) TRACE_ATTRIBUTE_OUTPUT=val; 
		if(id.equalsIgnoreCase("TRACE_ATTRIBUTE_INPUT")) TRACE_ATTRIBUTE_INPUT=val; 
		if(id.equalsIgnoreCase("TRACE_CHECKER")) TRACE_CHECKER=val; 
		if(id.equalsIgnoreCase("TRACE_CHECKER_OUTPUT")) TRACE_CHECKER_OUTPUT=val; 
		if(id.equalsIgnoreCase("TRACE_CODING")) TRACE_CODING=val; 
		if(id.equalsIgnoreCase("TRACE_BYTECODE_OUTPUT")) TRACE_BYTECODE_OUTPUT=val; 
	}

	public static void selectCompilerOptions() {
		JPanel panel=new JPanel();
		panel.setBackground(Color.white);
		panel.add(checkBox("CaseSensitive","Source file is case sensitive."));
		panel.add(checkBox("Verbose","Output messages about what the compiler is doing"));
		panel.add(checkBox("Warnings","Generate no warnings"));
		panel.add(checkBox("Extensions","Disable all language extensions. In other words, follow the Simula Standard literally"));
		panel.add(checkBox("noExecution","Don't execute generated .jar file"));
		panel.add(checkBox("TRACING","Debug option"));
		panel.add(checkBox("TRACE_SCAN","Debug option"));
		panel.add(checkBox("TRACE_COMMENTS","Debug option"));
		panel.add(checkBox("TRACE_PARSE","Debug option"));
		panel.add(checkBox("TRACE_ATTRIBUTE_OUTPUT","Debug option"));
		panel.add(checkBox("TRACE_ATTRIBUTE_INPUT","Debug option"));
		panel.add(checkBox("TRACE_CHECKER","Debug option"));
		panel.add(checkBox("TRACE_CHECKER_OUTPUT","Debug option"));
		panel.add(checkBox("TRACE_CODING","Debug option"));
		panel.add(checkBox("TRACE_BYTECODE_OUTPUT","Debug option"));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		Util.optionDialog(panel,"Select Compiler Options",JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,"Ok");
	}

	private static JCheckBox checkBox(String id,String info) {
        JCheckBox item = new JCheckBox(id);
    	item.setBackground(Color.white);
        item.setSelected(Option.getOption(id));
        item.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Option.setOption(id,item.isSelected());
		}});
        item.setToolTipText(info);
        item.addMouseListener(new MouseAdapter() {
            Color color = item.getBackground();
//            JFrame frame;
            public void mouseEntered(MouseEvent me) {
               color = item.getBackground();
               item.setBackground(Color.lightGray); // change the color to green when mouse over a button
//               frame=popup(item);
            }
            public void mouseExited(MouseEvent me) {
            	item.setBackground(color);
//            	frame.setVisible(false);
            }
         });
        return(item);
	}

	
//	public static JFrame popup(JCheckBox checkBox) {
//    	JFrame frame=new JFrame();
////        frame.setSize(800, 500); // Initial frame size
//        frame.setSize(950, 500); // Initial frame size
//        frame.setTitle("Runtime Console");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(checkBox);
//
//        frame.getContentPane().add(new JTextArea("Abracadab"));
//        frame.setVisible(true);
//        return(frame);
//    }

}