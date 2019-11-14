/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.utilities;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * A set of all static Utility Methods
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class Util { 
	
	public static void popUpMessage(final Object msg) {
		Util.optionDialog(msg,"Message",JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, "OK");
	}
	
	public static void popUpError(final String msg) {
		int res=Util.optionDialog(msg+"\nDo you want to continue ?","Error",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, "Yes", "No");
		if(res!=JOptionPane.YES_OPTION) System.exit(0);
	}

	public static int optionDialog(final Object msg,final String title,final int optionType,final int messageType,final String... option) {
		Object OptionPaneBackground=UIManager.get("OptionPane.background");
		Object PanelBackground=UIManager.get("Panel.background");
 		UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
		int answer = JOptionPane.showOptionDialog(null,msg,title,optionType,messageType,Global.sIcon, option, option[0]);
		//System.out.println("doClose.saveDialog: answer="+answer);
		UIManager.put("OptionPane.background",OptionPaneBackground);
        UIManager.put("Panel.background",PanelBackground);
		return(answer);
	}

	
	public static int nError;

	public static void error(final String msg) {
		String err = "Line " + Global.sourceLineNumber + " Error: " + msg;
		nError++;
		printError(err);
		BREAK("Press [ENTER] Continue or [Q] for a Stack-Trace");
	}

	public static void INTERNAL_ERROR(final String msg,final Throwable e) {
		String err = "Line " + Global.sourceLineNumber + " Internal Error: " + msg +"  "+ e;
		nError++;
		printError(err);
		e.printStackTrace();
		FORCED_EXIT();
	}

	public static void FATAL_ERROR(final String s) {
		String msg = "LINE " + Global.sourceLineNumber + ": FATAL error - " + s;
		nError++;
		printError(msg);
		println("STACK-TRACE");
		printStackTrace();
		FORCED_EXIT();
	}

	public static void warning(final String msg) {
		String line = "LINE " + Global.sourceLineNumber + ": WARNING: " + msg;
		if (Option.WARNINGS) {
			printWarning(line);
		}
	}

	public static void message(final String msg) {
		println(msg);
	}

	public static void LIST(final String msg) {
		TRACE("LIST", msg);
	}

	public static void TRACE(final String msg) {
		TRACE("TRACE", msg);
	}

	public static void TRACE(final String id,final String msg) {
		if (Option.TRACING)
			println(id + " " + Global.sourceLineNumber + ": " + msg);
	}

	public static void TRACE_OUTPUT(final String msg) {
		if (Option.TRACE_ATTRIBUTE_OUTPUT)
			Util.println("ATTR OUTPUT: " + msg);
	}

	public static void TRACE_INPUT(final String msg) {
		if (Option.TRACE_ATTRIBUTE_INPUT)
			Util.println("ATTR INPUT: " + msg);
	}

	public static void NOT_IMPLEMENTED(final String s) {
		System.err.println("*** NOT IMPLEMENTED: " + s);
		BREAK("Press [ENTER] Continue or [Q] for a Stack-Trace");
	}

	public static void FORCED_EXIT() {
		System.out.println("FORCED EXIT");
		BREAK("FORCED EXIT");
		if (Global.console == null) System.exit(-1);
	}

	public static void ASSERT(final boolean test, final String msg) {
		if (!test) {
			println("ASSERT(" + msg + ") -- FAILED");
			BREAK("Press [ENTER] Continue or [Q] for a Stack-Trace");
		}
	}

	public static void BREAK(final String title) {
		BREAK("BREAK", title);
	}

	public static void BREAK(final String id, final String title) {
		if (Option.BREAKING) {
			if(Global.console!=null) {
				Global.console.writeError(id + " " + Global.sourceLineNumber + ": " + title + ": <");
				char c=Global.console.read();
				if (c == 'Q' || c == 'q') {
					println("\n\n:STACK-TRACE");
					printStackTrace();
				}
			} else try {
				System.err.println(id + " " + Global.sourceLineNumber + ": " + title + ": <");
				char c=(char) System.in.read();
				if (c == 'Q' || c == 'q') {
					println("STACK-TRACE");
					printStackTrace();
				}
				while (System.in.available() > 0) System.in.read();
			} catch (Exception e) {
				e.printStackTrace();
				//System.exit(-1);
				FORCED_EXIT();
			}
		}
	}

	public static void printStackTrace() {
		StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
		int n = stackTraceElement.length;
		for (int i = 2; i < n; i++)
			println("   at "+stackTraceElement[i]);
	}

	public static void println(final String s) {
		String u = s.replace('\r', (char) 0);
		u = u.replace('\n', (char) 0);
		if (Global.console != null)	Global.console.write(u + '\n');
		else System.out.println(u);
	}  

	public static void printError(final String s) {
		String u = s.replace('\r', (char) 0);
		if (Global.console != null)	Global.console.writeError(u + '\n');
		else System.err.println(u);
	}  

	public static void printWarning(final String s) {
		String u = s.replace('\r', (char) 0);
		if (Global.console != null)	Global.console.writeWarning(u + '\n');
		else System.err.println(u);
	}  

    //*******************************************************************************
    //*** isJavaIdentifier - Check if 's' is a legal Java Identifier
    //*******************************************************************************
	public static boolean isJavaIdentifier(final String s) {
		if (s.length() == 0 || !Character.isJavaIdentifierStart(s.charAt(0))) {
			return false;
		}
		for (int i = 1; i < s.length(); i++) {
			if (!Character.isJavaIdentifierPart(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

    //*******************************************************************************
    //*** makeJavaIdentifier - Make 's' a legal Java Identifier
    //*******************************************************************************
	public static String makeJavaIdentifier(final String s) {
		StringBuilder sb=new StringBuilder();
		char c=s.charAt(0);
		if (s.length() == 0 || !Character.isJavaIdentifierStart(c)) c='_';
		sb.append(c);
		
		for (int i = 1; i < s.length(); i++) {
			c=s.charAt(i);
			if (!Character.isJavaIdentifierPart(c)) c='_';
			sb.append(c);
		}
		return(sb.toString());
	}
  
    //*******************************************************************************
    //*** IPOW - Integer Power: b ** x
    //*******************************************************************************
	/**
	 * Integer Power: b ** x
	 * 
	 * @param b
	 * @param x
	 * @return
	 */
	public static int IPOW(final int b, int x) {
		// RT.println("IPOW("+b+','+x+')');
		if (x == 0) {
			if (b == 0)
				error("Exponentiation: " + b + " ** " + x + "  Result is undefined.");
			return (1); // any ** 0 ==> 1
		} else if (x < 0)
			error("Exponentiation: " + b + " ** " + x + "  Result is undefined.");
		else if (b == 0)
			return (0); // 0 ** non_zero ==> 0
		int v = b;
		while ((--x) > 0)
			v = v * b;
		return (v);
	}
  
//	//*******************************************************************************
//	//*** Reflection Utilities
//	//*******************************************************************************
//  
//	public static void listClass(final Class<?> c) {
//		listConstructors(c);
//		listMethods(c);	
//	}
//	
//	private static void listMethods(final Class<?> c) {
//		Method[] allMethods = c.getDeclaredMethods();
//		for(Method m:allMethods) listMethod(m);
//	}
//	
//	private static void listConstructors(final Class<?> c) {
//		Constructor<?>[] allConstructors = c.getConstructors();
//		for (Constructor<?> constructor : allConstructors)
//			listConstructor(constructor);
//	}
//	
//	private static void listConstructor(final Constructor<?> m)	{
//		System.out.format("%s%n", m.toGenericString());
//		String  fmt = "%24s: %s%n";
//		Class<?>[] pType  = m.getParameterTypes();
//		Type[] gpType = m.getGenericParameterTypes();
//		for (int i = 0; i < pType.length; i++) {
//			System.out.format(fmt,"ParameterType", pType[i]);
//			System.out.format(fmt,"GenericParameterType", gpType[i]);
//		}
//		Class<?>[] xType  = m.getExceptionTypes();
//		Type[] gxType = m.getGenericExceptionTypes();
//		for (int i = 0; i < xType.length; i++) {
//			System.out.format(fmt,"ExceptionType", xType[i]);
//			System.out.format(fmt,"GenericExceptionType", gxType[i]);
//		}
//	}
//	
//	private static void listMethod(final Method m) {
//		System.out.format("%s%n", m.toGenericString());
//		String  fmt = "%24s: %s%n";
//	
//		System.out.format(fmt, "ReturnType", m.getReturnType());
//		System.out.format(fmt, "GenericReturnType", m.getGenericReturnType());
//	
//		Class<?>[] pType  = m.getParameterTypes();
//		Type[] gpType = m.getGenericParameterTypes();
//		for (int i = 0; i < pType.length; i++) {
//	        System.out.format(fmt,"ParameterType", pType[i]);
//			System.out.format(fmt,"GenericParameterType", gpType[i]);
//		}
//		Class<?>[] xType  = m.getExceptionTypes();
//		Type[] gxType = m.getGenericExceptionTypes();
//		for (int i = 0; i < xType.length; i++) {
//			System.out.format(fmt,"ExceptionType", xType[i]);
//			System.out.format(fmt,"GenericExceptionType", gxType[i]);
//		}
//	}
  
  
}
