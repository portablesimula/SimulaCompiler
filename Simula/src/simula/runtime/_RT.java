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

import simula.compiler.utilities.Global;

/**
 * Utility class _RT.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/_RT.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class _RT {
	private _RT(){}

	static _RTConsolePanel console;
	static boolean someConsolePresent;

	static String progamIdent;
	static String currentModid;
	static int currentSimLine;
	static int numberOfEditOverflows;

	/**
	 *  Runtime Options
	 *
	 */
	public static class Option {
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
		private SPORT_Option() {}
		private static String getModuleName() {
			return (new File(SPORT_SourceFileName).getName());
		}

		static String SourceDirName = "C:/GitHub/SimulaCompiler/Simula/src/sport/rts";
		static String SPORT_SysInsertDirName = "C:/WorkSpaces/SPort-System/S-Port/src/sport/rts";
		static String SPORT_SourceFileName = SourceDirName + "/ModuleName";

		// Used by getTextInfo
		static String getSourceFileName() {
			return (SPORT_SourceFileName);
		}

		static String ListingFileName = "#sysout";

		static String getSCodeFileName() {
			return (createSubfileName("scode", getModuleName() + ".scd"));
		}

		private static String createSubfileName(String subdir, String name) {
			String tempFileName = SourceDirName + "/" + subdir + "/" + name;
			File file = new File(tempFileName);
			file.getParentFile().mkdirs();
			return (tempFileName);
		}

		static String getScratchFileName() {
			return (createSubfileName("temp", getModuleName() + ".tmp"));
		}

		static String getAttributeOutputFileName() {
			return (createSubfileName("temp", currentModuleID + ".atr"));
		}

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

		static String Selectors = "AZ";

		// The following file is created when front-end compiling the RTS:
		static String PredefFileName = "C:/WorkSpaces/SPort-System/S-Port/Attrs/FEC/PREDEF.atr";

		static String XmessageFileName = "C:/WorkSpaces/SPort-System/S-Port/src/sport/fec/FECERROR.txt";

		// getIntInfo
		static int GenerateScode = 1;
		static int MaxErrors = 50;
		static int GiveNotes = 1;
		static int TraceLevel = 0;
		static int Recompilation = 0;
		static int SimobLevel = 0;

		// giveTextInfo
		// Index: Interpretation:
		// 1 The string info is the identifier of a class or procedure being separately
		// compiled.
		// 2 The string info is the identifier given in an external declaration that is
		// being processed.
		// 3 The string info is the external identification given in an external
		// declaration that is being processed.
		static String currentModuleID;	// 1 The identifier of a class or procedure being separately compiled. E.g
												// class or procedure identifier
		static String extIdent;			// 2 The identifier given in an external declaration that is being processed.
												// E.g class or procedure identifier
		static String extFile;			// 3 The external identification given in an external declaration that is being
												// processed. E.g. FileName
	}

	static void setRuntimeOptions(final String[] args) {
		// Parse command line arguments.
		_RT.Option.RUNTIME_USER_DIR = System.getProperty("user.dir", null);
		File file = null;
		for (int i = 0; i < args.length; i++) {
			String arg = args[i];
			if (arg.charAt(0) == '-') { // command line option
				// General RTS Options
				if (arg.equalsIgnoreCase("-help"))
					help();
				else if (arg.equalsIgnoreCase("-verbose"))
					_RT.Option.VERBOSE = true;
				else if (arg.equalsIgnoreCase("-useConsole"))
					_RT.Option.USE_CONSOLE = true;
				else if (arg.equalsIgnoreCase("-blockTracing"))
					_RT.Option.BLOCK_TRACING = true;
				else if (arg.equalsIgnoreCase("-gotoTracing"))
					_RT.Option.GOTO_TRACING = true;
				else if (arg.equalsIgnoreCase("-qpsTracing"))
					_RT.Option.QPS_TRACING = true;
				else if (arg.equalsIgnoreCase("-smlTracing"))
					_RT.Option.SML_TRACING = true;
				else if (arg.equalsIgnoreCase("-userDir"))
					_RT.Option.RUNTIME_USER_DIR = args[++i];

				// Spesial S-Port Simula and Simuletta Options. Used by get/give ... info routines
				else if (arg.equalsIgnoreCase("-SPORT_SOURCE_FILE"))
					SPORT_Option.SPORT_SourceFileName = args[++i];
				else if (arg.equalsIgnoreCase("-select"))
					_RT.SPORT_Option.Selectors = args[++i];
				else if (arg.equalsIgnoreCase("-listing"))
					_RT.SPORT_Option.ListingFileName = args[++i];
				else if (arg.equalsIgnoreCase("-trace"))
					_RT.SPORT_Option.TraceLevel = Integer.decode(args[++i]);
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
			_RT.println("Begin Execution of Simula Program using " + getJavaID());
			listRuntimeOptions();
		}
	}

	private static void help() {
		println(Global.simulaReleaseID + " See: https://github.com/portablesimula\n");
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

	private static void error(final String msg) {
		System.err.println("Simula: " + msg + "\n");
		popUpError(msg);
	}

	static void popUpError(final String msg) {
		int res = optionDialog(msg + "\nDo you want to continue ?", "Error", JOptionPane.YES_NO_OPTION,
				JOptionPane.ERROR_MESSAGE, "Yes", "No");
		if (res != JOptionPane.YES_OPTION)
			System.exit(0);
	}

	static int optionDialog(final Object msg, final String title, final int optionType, final int messageType, final String... option) {
		int answer = JOptionPane.showOptionDialog(null, msg, title, optionType, messageType, null, option, option[0]);
		return (answer);
	}

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

	static void println(final String s) {
		if (console != null)
			console.write(s + '\n');
		else
			System.out.println(s);
	}

	static void printError(final String s) {
		if (console != null)
			console.writeError(s + '\n');
		else
			System.out.println("\n" + s);
	}

	/**
	 * Print a warning message.
	 * @param msg the message to print
	 */
	static void printWarning(final String msg) {
		if (console != null)
			console.writeWarning(msg + '\n');
		else
			System.out.println(msg);
	}

	static void TRACE(final String msg) {
		println(Thread.currentThread().toString() + ": " + msg);
	}

	static void IERR(final String s) {
		printError(s);
		Thread.dumpStack();
		System.exit(-1);
	}

	static void NOT_IMPLEMENTED(final String s) {
		IERR("*** NOT IMPLEMENTED: " + s);
	}

	static void ASSERT(final boolean test, final String msg) {
		if (!test) {
			if (_RT.console == null) {
				_RT.console = new _RTConsolePanel();
				_RT.console.popup("Runtime Console");
			}
			IERR("ASSERT(" + msg + ") -- FAILED");
		}
	}

	static void ASSERT_CUR_(final _RTObject obj, final String msg) {
		if (_RTObject._CUR != obj) {
			println(msg + ": _CUR=" + _RTObject._CUR.edObjectAttributes());
			println(msg + ":  obj=" + obj.edObjectAttributes());
			_RT.ASSERT(_RTObject._CUR == obj, msg);
		}
	}

	// *********************************************************************
	// *** GET JAVA VERSION
	// *********************************************************************

	static String getJavaID() {
		return ("JVM version " + System.getProperty("java.vm.specification.version"));
	}

	// *********************************************************************
	// *** TRACING AND DEBUGGING UTILITIES
	// *********************************************************************

	static void printStaticChain() {
		_RT.printStaticChain(_RTObject._CUR);
	}

	static void printStaticChain(final _RTObject ins) {
		_RTObject x = ins;
		println("*** STATIC CHAIN:");
		while (x != null) {
			boolean qps = x.isQPSystemBlock();
			boolean dau = x.isDetachUsed();
			println(" - " + x.edObjectIdent() + "[QPSystemBlock=" + qps + ",detachUsed=" + dau + ",state=" + x.STATE_
					+ ']');
			x = x._SL;
		}

	}

	static void printSimulaStackTrace(final Thread thread, final int start) {
		printSimulaStackTrace(thread.getStackTrace(), start);
	}

	static void printSimulaStackTrace(final int start) {
		printSimulaStackTrace(Thread.currentThread(), start);
	}

	static void printSimulaStackTrace(final Throwable e, final int start) {
		printSimulaStackTrace(e.getStackTrace(), start);
	}

	private static void printSimulaStackTrace(final StackTraceElement stackTraceElement[], final int start) {
		if (currentModid != null) {
			_RT.println("In " + currentModid + " at line " + currentSimLine);
		} else {
			int n = stackTraceElement.length;
			LOOP: for (int i = start; i < (n - 1); i++) {
				if (printSimulaLineInfo(stackTraceElement[i], " In "))
					break LOOP;
			}
		}
		if (_RT.Option.VERBOSE) {
			_RT.println("*** DYNAMIC CHAIN:");
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
			_RT.println("(For more info: rerun with runtime option 'verbose')\n");
		}
	}

	private static boolean printSimulaLineInfo(final StackTraceElement elt, final String lead) {
		try {
			Class<?> cls = Class.forName(elt.getClassName());
			Field field = cls.getField("_INFO");
			_PROGINFO info = (_PROGINFO) field.get(null);
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
				_RT.println(sb.toString());
				return (true);
			} catch (Throwable t) {
				t.printStackTrace();
			}
		} catch (Exception e) {
			if (_RT.Option.VERBOSE)
				e.printStackTrace();
		}
		return (false);
	}

	// **********************************************************************
	// *** Debugging utility: Procedure printThreadList
	// **********************************************************************
	static void printThreadList() {
		printThreadList(false);
	}

	static synchronized void printThreadList(boolean withStackTrace) {
		Thread[] t = new Thread[50];
		int i = Thread.enumerate(t);
		_RT.println("ACTIVE THREAD LIST:");
		for (int j = 0; j < i; j++) {
			Thread T = t[j];
			String msg = "  - " + T;
			if (T == Thread.currentThread())
				msg = msg + " = CurrentThread";
			_RT.println(msg + "   STATE=" + T.getState());
			if (withStackTrace) {
				_RT.printSimulaStackTrace(T, 0);
				_RT.println("");
			}
		}
		_RT.println("-----------------------------------------------------------------------------------------------");
	}

	static void _LINE(String modid, int simLine) {
		currentModid = modid;
		currentSimLine = simLine;
	}

}
