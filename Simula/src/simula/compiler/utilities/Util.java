/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.utilities;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * A set of all static Utility Methods
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/utilities/Util.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class Util { 
	/**
	 * Default constructor.
	 */
	Util(){}
	
	/**
	 * Pop up a message box.
	 * @param msg the message
	 */
	public static void popUpMessage(final Object msg) {
		Util.optionDialog(msg,"Message",JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, "OK");
	}
	
	/**
	 * Pop up an error message box.
	 * @param msg the error message
	 */
	public static void popUpError(final String msg) {
		int res=Util.optionDialog(msg+"\nDo you want to continue ?","Error",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, "Yes", "No");
		if(res!=JOptionPane.YES_OPTION) System.exit(0);
	}

	/**
	 * Brings up an option dialog.
	 * @param msg the message to display
	 * @param title the title string for the dialog
	 * @param optionType an integer designating the options available on the dialog
	 * @param messageType an integer designating the kind of message this is
	 * @param option an array of objects indicating the possible choices the user can make
	 * @return an integer indicating the option chosen by the user, or CLOSED_OPTION if the user closed the dialog
	 */
	public static int optionDialog(final Object msg, final String title, final int optionType, final int messageType,
			final String... option) {
		Object OptionPaneBackground = UIManager.get("OptionPane.background");
		Object PanelBackground = UIManager.get("Panel.background");
		UIManager.put("OptionPane.background", Color.WHITE);
		UIManager.put("Panel.background", Color.WHITE);
		int answer = JOptionPane.showOptionDialog(null, msg, title, optionType, messageType, Global.sIcon, option, option[0]);
		// System.out.println("doClose.saveDialog: answer="+answer);
		UIManager.put("OptionPane.background", OptionPaneBackground);
		UIManager.put("Panel.background", PanelBackground);
		return (answer);
	}

	/**
	 * Number of error messages.
	 */
	public static int nError;

	/**
	 * Print a error message.
	 * @param msg the message
	 */
	public static void error(final String msg) {
		String err = edLINE(": Error: " + msg);
		nError++;
		printError(err);
	}

	/**
	 * Print a internal error message.
	 * @param msg the message
	 */
	public static void IERR(final String msg) {
		String err = edLINE(": Internal error - " + msg);
		nError++;
		printError(err);
		Thread.dumpStack();
		FORCED_EXIT();
	}

	/**
	 * Perform FORCED EXIT.
	 */
	private static void FORCED_EXIT() {
		System.out.println("FORCED EXIT");
		if (Global.console == null) System.exit(-1);
	}

	/**
	 * Print a internal error message.
	 * @param msg the message
	 * @param e any Throwable
	 */
	public static void IERR(final String msg,final Throwable e) {
		String err = edLINE(": Internal error - " + msg +"  "+ e);
		nError++;
		printError(err);
		e.printStackTrace();
		FORCED_EXIT();
	}

	/**
	 * Print a warning message.
	 * @param msg the message
	 */
	public static void warning(final String msg) {
		String line = edLINE(": WARNING: " + msg);
		if (Option.WARNINGS) {
			printWarning(line);
		}
	}
	
	/**
	 * Edit a line with source line number etc.
	 * @param s the line string
	 * @return the resulting string
	 */
	private static String edLINE(String s) {		
		String line = "LINE " + Global.sourceLineNumber + s;
		if(Global.insertName!=null) line = Global.insertName + ':' + line;
		return(line);
	}

	/**
	 * Utility method: TRACE
	 * @param msg the message to print
	 */
	public static void TRACE(final String msg) {
		if (Option.TRACING)
			println("TRACE " + Global.sourceLineNumber + ": " + msg);
	}

	/**
	 * Utility method: TRACE_OUTPUT
	 * @param msg the message to print
	 */
	public static void TRACE_OUTPUT(final String msg) {
		if (Option.TRACE_ATTRIBUTE_OUTPUT)
			Util.println("ATTR OUTPUT: " + msg);
	}

	/**
	 * Utility method: TRACE_INPUT
	 * @param msg the message to print
	 */
	public static void TRACE_INPUT(final String msg) {
		if (Option.TRACE_ATTRIBUTE_INPUT)
			Util.println("ATTR INPUT: " + msg);
	}

	/**
	 * Utility method: ASSERT
	 * @param test this test must be true
	 * @param msg the message when test = false
	 */
	public static void ASSERT(final boolean test, final String msg) {
		if (!test) {
			IERR("ASSERT(" + msg + ") -- FAILED");
		}
	}

	/**
	 * Print a string.
	 * @param s the string
	 */
	public static void println(final String s) {
		if (Global.console != null) {
			String u = s.replace('\r', (char) 0);
			u = u.replace('\n', (char) 0);
			Global.console.write(u + '\n');
		}
		else System.out.println(s);
	}  

	/**
	 * Print a error message.
	 * @param s the message
	 */
	public static void printError(final String s) {
		String u = s.replace('\r', (char) 0);
		if (Global.console != null)	Global.console.writeError(u + '\n');
		else System.err.println(u);
	}  

	/**
	 * Print a warning message.
	 * @param s the message
	 */
	public static void printWarning(final String s) {
		String u = s.replace('\r', (char) 0);
		if (Global.console != null)	Global.console.writeWarning(u + '\n');
		else System.err.println(u);
	}  

    //*******************************************************************************
    //*** isJavaIdentifier - Check if 'ident' is a legal Java Identifier
    //*******************************************************************************
	/**
	 * Check if 'ident' is a legal Java Identifier.
	 * @param ident the given identifier
	 * @return true if 'ident' is a legal Java Identifier otherwise false
	 */
	public static boolean isJavaIdentifier(final String ident) {
		if (ident.length() == 0 || !Character.isJavaIdentifierStart(ident.charAt(0))) {
			return false;
		}
		for (int i = 1; i < ident.length(); i++) {
			if (!Character.isJavaIdentifierPart(ident.charAt(i))) {
				return false;
			}
		}
		return true;
	}

    //*******************************************************************************
    //*** makeJavaIdentifier - Make 'ident' a legal Java Identifier
    //*******************************************************************************
	/**
	 * Make 'ident' a legal Java Identifier.
	 * @param ident the given identifier
	 * @return the resulting Java identifier
	 */
	public static String makeJavaIdentifier(final String ident) {
		StringBuilder sb=new StringBuilder();
		char c=ident.charAt(0);
		if (ident.length() == 0 || !Character.isJavaIdentifierStart(c)) c='_';
		sb.append(c);
		
		for (int i = 1; i < ident.length(); i++) {
			c=ident.charAt(i);
			if (!Character.isJavaIdentifierPart(c)) c='_';
			sb.append(c);
		}
		return(sb.toString());
	}
  
    //*******************************************************************************
    //*** 
    //*******************************************************************************
	/**
	 * Returns true if the two specified strings are equal to one another.
	 * @param s1 argument string
	 * @param s2 argument string
	 * @return true if the two specified strings are equal to one another
	 */
	public static boolean equals(String s1,String s2) {
		if(Option.CaseSensitive)
			 return(s1.equals(s2));			
		else return(s1.equalsIgnoreCase(s2));
	}
	
    //*******************************************************************************
    //*** IPOW - Integer Power: b ** x
    //*******************************************************************************
	/**
	 * Utility: Integer Power: b ** x
	 * @param base argument base
	 * @param x argument x
	 * @return Returns the value of 'base' raised to the power of 'x'
	 */
	public static int IPOW(final long base, long x) {
//		System.out.println("Util.IPOW: base="+base+", x="+x);
		if (x == 0) {
			if (base == 0)
				error("Exponentiation: " + base + " ** " + x + "  Result is undefined.");
			return (1); // any ** 0 ==> 1
		} else if (x < 0)
			error("Exponentiation: " + base + " ** " + x + "  Result is undefined.");
		else if (base == 0)
			return (0); // 0 ** non_zero ==> 0
		
		long res=(long) Math.pow((double)base,(double)x);
//		System.out.println("Util.IPOW: base="+base+", x="+x+" ==> "+res);
		if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
			error("Arithmetic overflow: "+base+" ** "+x+" ==> "+res
					+" which is outside integer value range["+Integer.MIN_VALUE+':'+Integer.MAX_VALUE+']');
		return((int)res);
	}
  

	// ***************************************************************
	// *** LIST .class file
	// ***************************************************************
	/**
	 * Print a .class file listing.
	 * 
	 * @param classFileName the .class file name
	 */
	public static void doListClassFile(final String classFileName) {
		try {
			execute("javap", "-c", "-l", "-p", "-s", "-verbose", classFileName);
		} catch (IOException e) {
			Util.IERR("Impossible", e);
		}
	}

	// ***************************************************************
	// *** EXECUTE OS COMMAND
	// ***************************************************************
	/**
	 * Execute OS Command
	 * @param cmd command vector
	 * @return return value from the OS
	 * @throws IOException if something went wrong
	 */
	public static int execute(final Vector<String> cmd) throws IOException {
		String[] cmds = new String[cmd.size()];
		cmd.copyInto(cmds);
		return (execute(cmds));
	}

	/**
	 * Execute an OS command
	 * 
	 * @param cmdarray command array
	 * @return exit value
	 * @throws IOException if an I/O error occurs
	 */
	public static int execute(final String... cmdarray) throws IOException {
		Runtime runtime = Runtime.getRuntime();
		if (Option.verbose) {
			String line = "";
			for (int i = 0; i < cmdarray.length; i++)
				line = line + " " + cmdarray[i];
			Util.println("Execute: " + line);
		}
		Process process = runtime.exec(cmdarray);
		InputStream err = process.getErrorStream();
		InputStream inp = process.getInputStream();
		StringBuilder error = new StringBuilder();
		while (process.isAlive()) {
			while (err.available() > 0) {
				char c = (char) err.read();
				System.err.append(c);
				error.append(c);
			}
			while (inp.available() > 0) {
				if (Global.console != null)
					Global.console.write("" + (char) inp.read());
				else
					System.out.append((char) inp.read());
			}
		}
		if (error.length() > 0)
			Util.error(error.toString());
		return (process.exitValue());
	}
  
  
}
