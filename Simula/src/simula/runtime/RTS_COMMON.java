/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.io.File;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import javax.swing.JOptionPane;

/**
 * Utility class containing a lot of common stuff.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_COMMON.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class RTS_COMMON {
	/**
	 * Default constructor.
	 */
	private RTS_COMMON(){}

	/**
	 * The runtime console. May be null
	 */
	static RTS_ConsolePanel console;

	/**
	 * The program ident.
	 */
	static String progamIdent;
	
	/**
	 * The current module ident.
	 */
	static String currentModid;
	
	/**
	 * The current simula source line number.
	 */
	static int currentSimLine;
	
	/**
	 * Number of edit overflows.
	 */
	static int numberOfEditOverflows;

	/**
	 *  Runtime Options
	 *
	 */
	public static class Option {
		
		/**
		 * Default constructor.
		 */
		private Option() {}
		
		/**
		 * Output messages about what the RTS is doing.
		 * Default: false.
		 */
		public static boolean VERBOSE = false;
		
		/**
		 * Map sysout and sysin to a popUp Console.
		 * Default: false.
		 */
		public static boolean USE_CONSOLE = false;
		
		/**
		 * Debug: Trace enter and exit of blocks, classes and procedures.
		 * Default: false.
		 */
		public static boolean BLOCK_TRACING = false;
		
		/**
		 * Debug: Trace goto statements.
		 * Default: false.
		 */
		public static boolean GOTO_TRACING = false;
		
		/**
		 *  Debug: Trace detach, resume and call.
		 * Default: false.
		 */
		public static boolean QPS_TRACING = false;
		
		/**
		 * Debug: Trace Simulation events.
		 * Default: false.
		 */
		public static boolean SML_TRACING = false;
		
		/**
		 * Specify where Simula files (Outfile, Infile, ...) are written and read.
		 * Default: User working directory. System.property("user.dir")
		 */
		public static String RUNTIME_USER_DIR = "";
	}

	/**
	 *  S-PORT Options
	 *
	 */
	static class SPORT_Option {
		/**
		 * Default constructor.
		 */
		private SPORT_Option() {}
		
		/**
		 * Returns S-PORT Module name
		 * @return S-PORT Module name
		 */
		private static String getModuleName() {
			return (new File(SPORT_SourceFileName).getName());
		}

		/**
		 * S-PORT: Source directory name
		 */
		private static String SourceDirName = "C:/GitHub/SimulaCompiler/Simula/src/sport/rts";

		/**
		 * S-PORT: Source file name
		 */
		private static String SPORT_SourceFileName = SourceDirName + "/ModuleName";
		
		/**
		 * S-PORT: Sysinsert directory name.
		 */
		static String SPORT_SysInsertDirName = "C:/WorkSpaces/SPort-System/S-Port/src/sport/rts";

		/**
		 * Returns the source file name.
		 * <p>
		 * Used by ENVIRONMENT'getTextInfo
		 * @return the source file name
		 */
		static String getSourceFileName() {
			return (SPORT_SourceFileName);
		}

		/**
		 * The S-PORT listing file
		 */
		static String ListingFileName = "#sysout";

		/**
		 * Returns the S-Code file name.
		 * <p>
		 * Used by ENVIRONMENT'getTextInfo
		 * @return the S-Code file name
		 */
		static String getSCodeFileName() {
			return (createSubfileName("scode", getModuleName() + ".scd"));
		}

		/**
		 * Utility: Create sub-file-name
		 * @param subdir sub-directory
		 * @param name file-name
		 * @return the resulting file-name
		 */
		private static String createSubfileName(String subdir, String name) {
			String tempFileName = SourceDirName + "/" + subdir + "/" + name;
			File file = new File(tempFileName);
			file.getParentFile().mkdirs();
			return (tempFileName);
		}

		/**
		 * Returns the scratch file name.
		 * <p>
		 * Used by ENVIRONMENT'getTextInfo
		 * @return the scratch file name
		 */
		static String getScratchFileName() {
			return (createSubfileName("temp", getModuleName() + ".tmp"));
		}

		/**
		 * Returns the attribute output file name.
		 * <p>
		 * Used by ENVIRONMENT'getTextInfo
		 * @return the attribute output file name
		 */
		static String getAttributeOutputFileName() {
			return (createSubfileName("temp", currentModuleID + ".atr"));
		}

		/**
		 * Returns the external attribute file name.
		 * <p>
		 * Used by ENVIRONMENT'getTextInfo
		 * @return the external attribute file name
		 */
		static String getExternalAttributeFileName() {
			// 12 What is the name of the attribute file for an external declaration?
			// Before this request is issued, the environment will have received the
			// identifier (extIdent) and the
			// external identifier (extFile) for the external declaration through the
			// routine give_textinfo
			if (extFile != null) {
				return (extFile);
			}
			String fileName = createSubfileName("temp", extIdent + ".atr");
			File file = new File(fileName);
			if (!file.exists()) {
				String name = extIdent;
				int i = name.indexOf('.');
				if (i > 0)
					name = name.substring(0, i);
				fileName = SPORT_SysInsertDirName + "/temp/" + name + ".atr";
				file = new File(fileName);
				if (!file.exists())
					System.out.println("_RT.getExternalAttributeFileName: \"" + file + "\"  does NOT exists");
			}
			return (fileName);
		}

		/**
		 * Selectors for conditional compilation.
		 */
		static String Selectors = "AZ";

		// The following file is created when front-end compiling the RTS:
		/**
		 * Name of attribute file for the predefined classes etc. 
		 * <p>
		 * NOTE: This file is created when front-end compiling the RTS:
		 */
		static String PredefFileName = "C:/WorkSpaces/SPort-System/S-Port/Attrs/FEC/PREDEF.atr";

		/**
		 * Name of a file containing seldom used information for the front end compiler,
		 * such as extended error messages.
		 */
		static String XmessageFileName = "C:/WorkSpaces/SPort-System/S-Port/src/sport/fec/FECERROR.txt";
		
		/**
		 * Used by getIntInfo.
		 */
		static int GenerateScode = 1;
		/**
		 * Used by getIntInfo.
		 */
		static int MaxErrors = 50;
		/**
		 * Used by getIntInfo.
		 */
		static int GiveNotes = 1;
		/**
		 * Used by getIntInfo.
		 */
		static int TraceLevel = 0;
		/**
		 * Used by getIntInfo.
		 */
		static int Recompilation = 0;
		/**
		 * Used by getIntInfo.
		 */
		static int SimobLevel = 0;

		/**
		 * Used by giveTextInfo(1) The identifier of a class or procedure being separately compiled.
		 * E.g class or procedure identifier
		 */
		static String currentModuleID;
		/**
		 * Used by giveTextInfo(2)The identifier given in an external declaration that is being processed.
		 * E.g class or procedure identifier
		 */
		static String extIdent;
		/**
		 * Used by giveTextInfo(3) The external identification given in an external declaration that
		 * is being processed. E.g. FileName
		 */
		static String extFile;
	}

	/**
	 * Set runtime options.
	 * @param args argument array
	 */
	public static void setRuntimeOptions(final String[] args) {
		// Parse command line arguments.
		RTS_COMMON.Option.RUNTIME_USER_DIR = System.getProperty("user.dir", null);
		File file = null;
		for (int i = 0; i < args.length; i++) {
			String arg = args[i];
			if (arg.charAt(0) == '-') { // command line option
				// General RTS Options
				if (arg.equalsIgnoreCase("-help"))
					help();
				else if (arg.equalsIgnoreCase("-verbose"))
					RTS_COMMON.Option.VERBOSE = true;
				else if (arg.equalsIgnoreCase("-useConsole"))
					RTS_COMMON.Option.USE_CONSOLE = true;
				else if (arg.equalsIgnoreCase("-blockTracing"))
					RTS_COMMON.Option.BLOCK_TRACING = true;
				else if (arg.equalsIgnoreCase("-gotoTracing"))
					RTS_COMMON.Option.GOTO_TRACING = true;
				else if (arg.equalsIgnoreCase("-qpsTracing"))
					RTS_COMMON.Option.QPS_TRACING = true;
				else if (arg.equalsIgnoreCase("-smlTracing"))
					RTS_COMMON.Option.SML_TRACING = true;
				else if (arg.equalsIgnoreCase("-userDir"))
					RTS_COMMON.Option.RUNTIME_USER_DIR = args[++i];

				// Spesial S-Port Simula and Simuletta Options. Used by get/give ... info routines
				else if (arg.equalsIgnoreCase("-SPORT_SOURCE_FILE"))
					SPORT_Option.SPORT_SourceFileName = args[++i];
				else if (arg.equalsIgnoreCase("-select"))
					RTS_COMMON.SPORT_Option.Selectors = args[++i];
				else if (arg.equalsIgnoreCase("-listing"))
					RTS_COMMON.SPORT_Option.ListingFileName = args[++i];
				else if (arg.equalsIgnoreCase("-trace"))
					RTS_COMMON.SPORT_Option.TraceLevel = Integer.decode(args[++i]);
				else
					error("Unknown option " + arg);
			} else {
				if (file == null) {
					file = new File(arg);
					SPORT_Option.SourceDirName = file.getParent();
				} else
					error("multiple input files specified");
			}
		}
		if (Option.VERBOSE) {
			RTS_COMMON.println("Begin Execution of Simula Program using " + getJavaID());
			listRuntimeOptions();
		}
	}

	/**
	 * Print synopsis of standard options
	 */
	private static void help() {
		println(RTS_ENVIRONMENT.simulaReleaseID + " See: https://github.com/portablesimula\n");
		println("Usage: java -jar simula.jar  [options]\n\n"
				+ "jarFile			Any output jar file from the simula compiler\n\n" + "possible options include:\n"
				+ "  -help                 Print this synopsis of standard options\n"
				+ "  -verbose              Output messages about what the RTS is doing\n"
				+ "  -useConsole           Map sysout and sysin to a popUp Console\n"
				+ "  -blockTracing         Debug: Trace enter and exit of blocks, classes and procedures\n"
				+ "  -gotoTracing          Debug: Trace goto statements\n"
				+ "  -qpsTracing           Debug: Trace detach, resume and call\n"
				+ "  -smlTracing           Debug: Trace Simulation events\n"
				+ "  -userDir <directory>  Specify where Simula files (Outfile, Infile, ...) are written and read\n"
				+ "                        Default: User working directory. System.property(\"user.dir\")\n" + "");
		System.exit(0);
	}

	/**
	 * Utility: Print an error message in a popup panel.
	 * @param msg the error message
	 */
	private static void error(final String msg) {
		System.err.println("Simula: " + msg + "\n");
		popUpError(msg);
	}

	/**
	 * Popup an error message box.
	 * @param msg the error message
	 */
	static void popUpError(final String msg) {
		int res = optionDialog(msg + "\nDo you want to continue ?", "Error", JOptionPane.YES_NO_OPTION,
				JOptionPane.ERROR_MESSAGE, "Yes", "No");
		if (res != JOptionPane.YES_OPTION)
			System.exit(0);
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
	static int optionDialog(final Object msg, final String title, final int optionType, final int messageType, final String... option) {
		int answer = JOptionPane.showOptionDialog(null, msg, title, optionType, messageType, null, option, option[0]);
		return (answer);
	}

	/**
	 * List runtime options.
	 */
	static void listRuntimeOptions() {
		System.out.println("file.encoding=" + System.getProperty("file.encoding"));
		System.out.println("defaultCharset=" + Charset.defaultCharset());
		System.out.println("verbose=" + Option.VERBOSE);
		System.out.println("useConsole=" + Option.USE_CONSOLE);
		System.out.println("blockTracing=" + Option.BLOCK_TRACING);
		System.out.println("gotoTracing=" + Option.GOTO_TRACING);
		System.out.println("qpsTracing=" + Option.QPS_TRACING);
		System.out.println("smlTracing=" + Option.SML_TRACING);
		System.out.println("userDir=" + Option.RUNTIME_USER_DIR);
	}

	/**
	 * Print a line on the runtime console if present, otherwise on System.out
	 * @param msg the message to print
	 */
	static void println(final String msg) {
		if (console != null)
			console.write(msg + '\n');
		else
			System.out.println(msg);
	}

	/**
	 * Print an error on the runtime console if present, otherwise on System.out
	 * @param msg the message to print
	 */
	static void printError(final String msg) {
		if (console != null)
			console.writeError(msg + '\n');
		else
			System.out.println("\n" + msg);
	}

	/**
	 * Print a warning message on the runtime console if present, otherwise on System.out
	 * @param msg the message to print
	 */
	static void printWarning(final String msg) {
		if (console != null)
			console.writeWarning(msg + '\n');
		else
			System.out.println(msg);
	}

	/**
	 * TRACE Utility.
	 * @param msg a trace message
	 */
	static void TRACE(final String msg) {
		println(Thread.currentThread().toString() + ": " + msg);
	}

	/**
	 * Utility: Internal error.
	 * @param msg an error message
	 */
	static void IERR(final String msg) {
		printError(msg);
		Thread.dumpStack();
		System.exit(-1);
	}

	// *********************************************************************
	// *** GET JAVA VERSION
	// *********************************************************************

	/**
	 * Returns System property "java.vm.specification.version"
	 * @return System property "java.vm.specification.version"
	 */
	static String getJavaID() {
		return ("JDK version " + System.getProperty("java.version"));
	}

	// *********************************************************************
	// *** TRACING AND DEBUGGING UTILITIES
	// *********************************************************************

	/**
	 * Print static chain starting with the current instance.
	 */
	static void printStaticChain() {
		RTS_COMMON.printStaticChain(RTS_RTObject._CUR);
	}

	/**
	 * Print static chain starting with 'ins'
	 * @param ins argument
	 */
	static void printStaticChain(final RTS_RTObject ins) {
		RTS_RTObject x = ins;
		println("*** STATIC CHAIN:");
		while (x != null) {
			boolean qps = x.isQPSystemBlock();
			boolean dau = x.isDetachUsed();
			println(" - " + x.edObjectIdent() + "[QPSystemBlock=" + qps + ",detachUsed=" + dau + ",state=" + x._STATE
					+ ']');
			x = x._SL;
		}

	}

	/**
	 * Utility: Print Simula stack trace.
	 * @param start start index in Java stackTrace
	 */
	static void printSimulaStackTrace(final int start) {
		printSimulaStackTrace(Thread.currentThread().getStackTrace(), start);
	}

	/**
	 * Utility: Print Simula stack trace.
	 * @param e a Throwable
	 * @param start start index in Java stackTrace
	 */
	static void printSimulaStackTrace(final Throwable e, final int start) {
		printSimulaStackTrace(e.getStackTrace(), start);
	}

	/**
	 * Utility: Print Simula StackTrace.
	 * @param stackTraceElement Java stackTrace
	 * @param start start index in Java stackTrace
	 */
	private static void printSimulaStackTrace(final StackTraceElement stackTraceElement[], final int start) {
		if (currentModid != null) {
			RTS_COMMON.println("In " + currentModid + " at line " + currentSimLine);
		} else {
			int n = stackTraceElement.length;
			LOOP: for (int i = start; i < (n - 1); i++) {
				if (printSimulaLineInfo(stackTraceElement[i], " In "))
					break LOOP;
			}
		}
		if (RTS_COMMON.Option.VERBOSE) {
			RTS_COMMON.println("*** DYNAMIC CHAIN:");
//			Thread.dumpStack();
			int n = stackTraceElement.length;
			for (int i = start; i < (n - 1); i++) {
				printSimulaLineInfo(stackTraceElement[i], " - ");
				if (i > 30) {
					println("... SimulaStackTrace " + (n - 30) + " lines Truncated");
					return;
				}
			}
			printSimulaLineInfo(stackTraceElement[start], " - ");
			printStaticChain();
		} else {
			RTS_COMMON.println("(For more info: rerun with runtime option 'verbose')\n");
		}
	}

	/**
	 * Utility: Print SimulaLineInfo
	 * @param elt a StackTraceElement
	 * @param lead the keading string
	 * @return the resulting line info
	 */
	private static boolean printSimulaLineInfo(final StackTraceElement elt, final String lead) {
		try {
			Class<?> cls = Class.forName(elt.getClassName());
			Field field = cls.getField("_INFO");
			RTS_PROGINFO info = (RTS_PROGINFO) field.get(null);
			int[] lineMap = info.LINEMAP_;
			int x = 0;
			int javaLineNumber = elt.getLineNumber();
			try {
				while (lineMap[x] < javaLineNumber)
					x = x + 2;
				StringBuilder sb = new StringBuilder();
				sb.append(lead + info.ident);
				if (Option.VERBOSE)
					sb.append("(" + elt.getFileName() + ':' + elt.getLineNumber() + " " + elt.getMethodName() + ")");
				sb.append(" at Simula Source Line " + lineMap[x - 1] + "[" + info.file + "]");
				RTS_COMMON.println(sb.toString());
				return (true);
			} catch (Throwable t) {
				t.printStackTrace();
			}
		} catch (Exception e) {
//			if (RTS_COMMON.Option.VERBOSE)
//				e.printStackTrace();
		}
		return (false);
	}

	// **********************************************************************
	// *** Debugging utility: Procedure printThreadList
	// **********************************************************************
	/**
	 * Print Thread list.
	 */
	static void printThreadList() {
		printThreadList(false);
	}

	/**
	 * Print Thread list.
	 * @param withStackTrace argument
	 */
	static synchronized void printThreadList(boolean withStackTrace) {
		Thread[] t = new Thread[50];
		int i = Thread.enumerate(t);
		RTS_COMMON.println("ACTIVE THREAD LIST:");
		for (int j = 0; j < i; j++) {
			Thread T = t[j];
			String msg = "  - " + T;
			if (T == Thread.currentThread())
				msg = msg + " = CurrentThread";
			RTS_COMMON.println(msg + "   STATE=" + T.getState());
			if (withStackTrace) {
				RTS_COMMON.printSimulaStackTrace(T.getStackTrace(), 0);
				RTS_COMMON.println("");
			}
		}
		RTS_COMMON.println("-----------------------------------------------------------------------------------------------");
	}

	/**
	 * Utility: Set current modid and Simula source line number.
	 * @param modid new current modid
	 * @param simLine new Simula source line number
	 */
	public static void _LINE(String modid, int simLine) {
		currentModid = modid;
		currentSimLine = simLine;
	}

}
