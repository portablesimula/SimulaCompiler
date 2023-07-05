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
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class _RT { 
//	static boolean BREAKING=true;//false;//true;
	private static final boolean TRACING=true;//false;//true;
//	public  static boolean DEBUGGING=false;//true;
  
	public static _RTConsolePanel console;
	public static boolean someConsolePresent;
  
	public static String progamIdent;
	public static String currentModid;
	public static int currentSimLine;
	public static int numberOfEditOverflows;

	public static class Option {
		public static boolean VERBOSE = false;//true;
		public static boolean USE_CONSOLE=false;//true;
		public static boolean BLOCK_TRACING = false;// true;
		public static boolean GOTO_TRACING = false;// true;
		public static boolean QPS_TRACING = false; // true;
		public static boolean SML_TRACING = false; // true;
		public static String  RUNTIME_USER_DIR="";
	}

	public static class SPORT_Option {
	    private static String getModuleName() { return(new File(SPORT_SourceFileName).getName()); }
		public static String SourceDirName="C:/GitHub/SimulaCompiler/Simula/src/sport/rts";
		public static String SPORT_SysInsertDirName="C:/WorkSpaces/SPort-System/S-Port/src/sport/rts";
		public static String SPORT_SourceFileName=SourceDirName+"/ModuleName";
		
		// Used by getTextInfo
		public static String getSourceFileName() { return(SPORT_SourceFileName); }
	    public static String ListingFileName="#sysout";
	    public static String getSCodeFileName() {
	    	return(createSubfileName("scode",getModuleName()+".scd"));
	    }
	    
	    private static String createSubfileName(String subdir,String name) {
	    	String tempFileName=SourceDirName+"/"+subdir+"/"+name;
	    	File file=new File(tempFileName);
	    	file.getParentFile().mkdirs();
	    	return(tempFileName);
	    }
	    
	    public static String getScratchFileName() {	return(createSubfileName("temp",getModuleName()+".tmp")); }
	    public static String getAttributeOutputFileName() { return(createSubfileName("temp",currentModuleID+".atr")); }

	    public static String getExternalAttributeFileName() {
	        // 12 What is the name of the attribute file for an external declaration?
	        //      Before this request is issued, the environment will have received the identifier (extIdent) and the
	        //      external identifier (extFile) for the external declaration through the routine give_textinfo
//    		System.out.println("_RT.getExternalAttributeFileName: currentModuleID=\""+currentModuleID+"\"");
//    		System.out.println("_RT.getExternalAttributeFileName: extIdent=\""+extIdent+"\"");
//    		System.out.println("_RT.getExternalAttributeFileName: extFile=\""+extFile+"\"");
//    		System.out.println("_RT.getExternalAttributeFileName: TRY: \""+extFile+"\"");
    		if(extFile!=null) {
//        		System.out.println("_RT.getExternalAttributeFileName: extFile != null "+extFile.length());
    			return(extFile);
    		}
    		
    	    String fileName=createSubfileName("temp",extIdent+".atr");
//	    	String fileName=SourceDirName+"/"+"temp"+"/"+getModuleName()+".atr";
    	    
	    	File file=new File(fileName);
//    		System.out.println("_RT.getExternalAttributeFileName: TRY: \""+file+"\"  exists="+file.exists());
	    	if(!file.exists()) {
		    	String name=extIdent;
		    	int i=name.indexOf('.');
		    	if(i>0) name=name.substring(0,i);
	    		fileName=SPORT_SysInsertDirName+"/temp/"+name+".atr";
		    	file=new File(fileName);
	    		if(!file.exists()) System.out.println("_RT.getExternalAttributeFileName: \""+file+"\"  does NOT exists");
	    	}
	    	return(fileName);
	    }
	    public static String Selectors="AZ";
	    
		// The following file is created when front-end compiling the RTS:
	    public static String PredefFileName="C:/WorkSpaces/SPort-System/S-Port/Attrs/FEC/PREDEF.atr";

//	    public static String XmessageFileName="X-MSG";
//	    public static String XmessageFileName="C:/GitHub/SimulaCompiler/Simula/src/sportFEC/sim/FECERROR.txt";
	    public static String XmessageFileName="C:/WorkSpaces/SPort-System/S-Port/src/sport/fec/FECERROR.txt";
	    
	    // getIntInfo
	    public static int GenerateScode=1;
	    public static int MaxErrors=50;
	    public static int GiveNotes=1;
	    public static int TraceLevel=0;
	    public static int Recompilation=0;
	    public static int SimobLevel=0;

	    // giveTextInfo
	    //  Index: Interpretation:
	    //    1  The string info is the identifier of a class or procedure being separately compiled.
	    //    2  The string info is the identifier given in an external declaration that is being processed.
	    //    3  The string info is the external identification given in an external declaration that is being processed.
//	    public static String extIdent; // 1 The identifier given in an external declaration that is being processed. E.g class or procedure identifier
//	    public static String currentModuleID; // 2 The identifier of a class or procedure being separately compiled. E.g class or procedure identifier
//	    public static String extFile;  // 3 The external identification given in an external declaration that is being processed. E.g. FileName
	    public static String currentModuleID; // 1 The identifier of a class or procedure being separately compiled. E.g class or procedure identifier
	    public static String extIdent; // 2 The identifier given in an external declaration that is being processed. E.g class or procedure identifier
	    public static String extFile;  // 3 The external identification given in an external declaration that is being processed. E.g. FileName
	}
	
	
	public static void setRuntimeOptions(final String[] args) {
		// Parse command line arguments.
//		System.out.println("_RT.setRuntimeOptions: Parse command line arguments: "+args.length);
		_RT.Option.RUNTIME_USER_DIR=System.getProperty("user.dir",null);
		File file = null;
		for(int i=0;i<args.length;i++) {
			String arg=args[i];
//			System.out.println("_RT.setRuntimeOptions: Parse command line argument: "+arg);
			if (arg.charAt(0) == '-') { // command line option
				// General RTS Options
				if (arg.equalsIgnoreCase("-help")) help();
				else if(arg.equalsIgnoreCase("-verbose"))      _RT.Option.VERBOSE=true;
				else if(arg.equalsIgnoreCase("-useConsole"))   _RT.Option.USE_CONSOLE=true;
				else if(arg.equalsIgnoreCase("-blockTracing")) _RT.Option.BLOCK_TRACING=true;
				else if(arg.equalsIgnoreCase("-gotoTracing"))  _RT.Option.GOTO_TRACING=true;
				else if(arg.equalsIgnoreCase("-qpsTracing"))   _RT.Option.QPS_TRACING=true;
				else if(arg.equalsIgnoreCase("-smlTracing"))   _RT.Option.SML_TRACING=true;
				else if (arg.equalsIgnoreCase("-userDir"))     _RT.Option.RUNTIME_USER_DIR=args[++i];

				// Spesial S-Port Simula and Simuletta Options. Used by  get/give ... info routines
				else if (arg.equalsIgnoreCase("-SPORT_SOURCE_FILE"))  SPORT_Option.SPORT_SourceFileName=args[++i];
				else if (arg.equalsIgnoreCase("-select"))  _RT.SPORT_Option.Selectors=args[++i];
				else if (arg.equalsIgnoreCase("-listing")) _RT.SPORT_Option.ListingFileName=args[++i];
				else if (arg.equalsIgnoreCase("-trace"))   _RT.SPORT_Option.TraceLevel=Integer.decode(args[++i]);
				else error("Unknown option "+arg);
			} else {
				if(file==null) {
					file=new File(arg);
					SPORT_Option.SourceDirName=file.getParent();
//					SPORT_Option.getModuleName()=file.getName();
				}
				else error("multiple input files specified");
			}
		}	
		if(Option.VERBOSE) {
			_RT.println("Begin Execution of Simula Program using "+getJavaID());
			listRuntimeOptions();
		}
	}
	private static void help() {
		println(Global.simulaReleaseID+" See: https://github.com/portablesimula\n");
		println("Usage: java -jar simula.jar  [options]\n\n"
				+ "jarFile			Any output jar file from the simula compiler\n\n"
				+ "possible options include:\n"
				+ "  -help                 Print this synopsis of standard options\n"
				+ "  -verbose              Output messages about what the compiler is doing\n"
				+ "  -useConsole           Map sysout and sysin to a popUp Console\n"
				+ "  -blockTracing         Debug: Trace enter and exit of blocks, classes and procedures\n"
				+ "  -gotoTracing          Debug: Trace goto statements\n"
				+ "  -qpsTracing           Debug: Trace detach, resume and call\n"
				+ "  -smlTracing           Debug: Trace Simulation events\n"
				+ "  -userDir <directory>  Specify where Simula files (Outfile, Infile, ...) are written and read\n"
				+ "                        Default: User working directory. System.property(\"user.dir\")\n"
				+ "");
		System.exit(0);
	}

	private static void error(final String msg) {
		System.err.println("Simula: " + msg + "\n");
		popUpError(msg);
		//help();
	}

	public static void popUpError(final String msg) {
		int res=optionDialog(msg+"\nDo you want to continue ?","Error",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, "Yes", "No");
		if(res!=JOptionPane.YES_OPTION) System.exit(0);
	}

	public static int optionDialog(final Object msg,final String title,final int optionType,final int messageType,final String... option) {
		int answer = JOptionPane.showOptionDialog(null,msg,title,optionType,messageType,null,option,option[0]);
		return(answer);
	}

	public static void listRuntimeOptions() {
		System.out.println("file.encoding="+System.getProperty("file.encoding"));
		System.out.println("defaultCharset="+Charset.defaultCharset());
		System.out.println("verbose="+Option.VERBOSE);
		System.out.println("useConsole="+Option.USE_CONSOLE);
		System.out.println("blockTracing="+Option.BLOCK_TRACING);
		System.out.println("gotoTracing="+Option.GOTO_TRACING);
		System.out.println("qpsTracing="+Option.QPS_TRACING);
		System.out.println("smlTracing="+Option.SML_TRACING);
		System.out.println("userDir="+Option.RUNTIME_USER_DIR);
	}
	

	public static void println(final String s) {
		if(console!=null) console.write(s+'\n');
		else System.out.println(s);
	}

	public static void printError(final String s) {
		if(console!=null) console.writeError(s+'\n');
		else System.out.println("\n"+s);
	}

	public static void printWarning(final String s) {
		if(console!=null) console.writeWarning(s+'\n');
		else System.out.println(s);
	}
	
	public static void warning(final String msg) {
		printWarning("Simula Runtime Warning: "+msg);
		//printSimulaStackTrace(0);
	}
  
	public static void TRACE(final String msg) {
		if (TRACING) println(Thread.currentThread().toString() + ": " + msg);
	}
	  
	public static void IERR(final String s) {
		printError(s);
		Thread.dumpStack(); System.exit(-1);
	}
  
	public static void NOT_IMPLEMENTED(final String s) {
		IERR("*** NOT IMPLEMENTED: " + s);
	}

	public static void NoneCheck(final Object x) {
		if (x == null) // && !Continuation.SHUTING_DOWN_)
			throw new _SimulaRuntimeError("NONE-CHECK FAILED");
	}
  
	public static void ASSERT(final boolean test,final String msg) {
		if (!test) {
			if (_RT.console==null) { _RT.console = new _RTConsolePanel(); _RT.console.popup("Runtime Console"); }
			IERR("ASSERT(" + msg + ") -- FAILED");
		}
	}

	public static void ASSERT_CUR_(final _RTObject obj,final String msg) {
		if (_RTObject._CUR != obj) {
			println(msg + ": _CUR=" + _RTObject._CUR.edObjectAttributes());
			println(msg + ":  obj=" + obj.edObjectAttributes());
			_RT.ASSERT(_RTObject._CUR == obj, msg);
		}
	}

//	public static void BREAK(final String msg) {
//		if (BREAKING) {
//			if (_RT.Option.CODE_STEP_TRACING) {
//				printWarning(msg + ": <");
//				try { Thread.sleep(2000);
//				} catch (Exception e) {	e.printStackTrace(); }
//				return;
//			}
//			if (_RT.console==null) { _RT.console = new _RTConsolePanel(); _RT.console.popup("Runtime Console"); }
//			printError("BREAK["+Thread.currentThread().getName()+"]: " + msg);
//			char c=_RT.console.read();
//			if (c == 'Q' || c == 'q') { // System.err.println("QUIT!");
//				printWarning("STACK-TRACE");
//				Thread.dumpStack();
//				printSimulaStackTrace(2);
//			}
//		}
//	}

	
	// *********************************************************************
	// *** GET JAVA VERSION
	// *********************************************************************

	public static int getJavaVersion() {
		String ver = System.getProperty("java.version");
		try {
			if (ver.startsWith("1.")) {
				return (ver.charAt(2) - '0');
			} else {
				ver = ver.substring(0, 2);
				return (Integer.parseInt(ver));
			}
		} catch (Exception e) {
			if(_RT.Option.VERBOSE) e.printStackTrace();
		}
		return (0);
	}
	
	public static String getJavaID() {
//        String javaID="Java version "+System.getProperty("java.version");
        String javaID="JVM version "+System.getProperty("java.vm.specification.version");
//		if(Option.USE_VIRTUAL_THREAD) javaID=javaID+"-Virtual Threads";
        return(javaID);
	}

//	// *********************************************************************
//	// *** SIMULA RUNTIME PROPERTIES
//	// *********************************************************************
//
//    private static File simulaPropertiesFile;
//    private static Properties simulaProperties;
//    
//	public static String getProperty(final String key,final String defaultValue) {
//		if(simulaProperties==null) loadProperties();
//		return(simulaProperties.getProperty(key,defaultValue));
//	}
//	
//	public static void setProperty(final String key,final String value) {
//		if(simulaProperties==null) loadProperties();
//		simulaProperties.setProperty(key,value);
//		storeProperties();
//	}
//	
//	private static void loadProperties() {
//		String USER_HOME=System.getProperty("user.home");
//		//System.out.println("USER_HOME="+USER_HOME);
//		File simulaPropertiesDir=new File(USER_HOME+File.separatorChar+".simula");
//		//System.out.println("simulaPropertiesDir="+simulaPropertiesDir);
//		simulaPropertiesDir.mkdirs();
//		simulaPropertiesFile=new File(simulaPropertiesDir,"simulaProperties.xml");
//		simulaProperties = new Properties();
//		try { simulaProperties.loadFromXML(new FileInputStream(simulaPropertiesFile));
//		} catch(Exception e) {}
//	}
//	
//	private static void storeProperties() {
//		System.out.print("_RT.storeProperties: SIMULA ");
//		simulaProperties.list(System.out);
//		try { simulaProperties.storeToXML(new FileOutputStream(simulaPropertiesFile),"Simula Properties");
//		} catch(Exception e) { e.printStackTrace(); }
//	}

	// *********************************************************************
	// *** TRACING AND DEBUGGING UTILITIES
	// *********************************************************************
	  
	public static void printStaticChain() { _RT.printStaticChain(_RTObject._CUR); }
  
	public static void printStaticChain(final _RTObject ins) {
		_RTObject x = ins;
		println("*** STATIC CHAIN:");
		while (x != null) {
			boolean qps = x.isQPSystemBlock();
			boolean dau = x.isDetachUsed();
			println(" - " + x.edObjectIdent() + "[QPSystemBlock=" + qps + ",detachUsed=" + dau + ",state=" + x.STATE_+']');
			x = x._SL;
		}

	}
	
	public static void printSimulaStackTrace(final Thread thread,final int start) {
		printSimulaStackTrace(thread.getStackTrace(),start);
	}
	
	public static void printSimulaStackTrace(final int start) {
		printSimulaStackTrace(Thread.currentThread(),start);
	}

	
	public static void printSimulaStackTrace(final Throwable e,final int start) {
		printSimulaStackTrace(e.getStackTrace(),start);
	}
	
	private static void printSimulaStackTrace(final StackTraceElement stackTraceElement[],final int start) {
		if(currentModid!=null) {
			_RT.println("In "+currentModid+" at line "+currentSimLine);
		}else {
			int n = stackTraceElement.length;
			LOOP:for (int i = start; i < (n-1); i++) {
				if(printSimulaLineInfo(stackTraceElement[i]," In ")) break LOOP;
			}
		}
		if(_RT.Option.VERBOSE) {
			_RT.println("*** DYNAMIC CHAIN:");
			int n = stackTraceElement.length;
			for (int i = start; i < (n-1); i++) {
				printSimulaLineInfo(stackTraceElement[i]," - ");
				if(i>30) {
					println("... SimulaStackTrace "+(n-30)+" lines Truncated");
					return;
				}
			}
			printSimulaLineInfo(stackTraceElement[start]," - ");
			printStaticChain();
		} else {
			_RT.println("(For more info: rerun with runtime option 'verbose')\n");			
		}
	}

	private static boolean printSimulaLineInfo(final StackTraceElement elt,final String lead)	{
		try { 
		    Class<?> cls=Class.forName(elt.getClassName());
		    //_RT.println("ENVIRONMENT.getSimulaLineNumber: "+elt.getClassName()+" = "+cls);
		    Field field=cls.getField("_INFO");
		    //_RT.println("ENVIRONMENT.getSimulaLineNumber: "+"GOT field="+field);
		    _PROGINFO info=(_PROGINFO)field.get(null);
		    int[] lineMap=info.LINEMAP_;
	        int x=0; int javaLineNumber=elt.getLineNumber();
	        try { while(lineMap[x]<javaLineNumber) x=x+2;
	              StringBuilder sb=new StringBuilder();
	        	  sb.append(lead+info.ident);
	        	  if(Option.VERBOSE) sb.append("("+elt.getFileName()+':'+elt.getLineNumber()+" "+elt.getMethodName()+")");
	        	  sb.append(" at Simula Source Line "+lineMap[x-1]+"["+info.file+"]");
	        	  _RT.println(sb.toString());
	        	  return(true);
	        } catch(Throwable t) { t.printStackTrace(); }
	    } catch (Exception e) {
	    	if(_RT.Option.VERBOSE) e.printStackTrace();
	    }
		return(false);
	}

	
	// **********************************************************************
	// *** Debugging utility: Procedure printThreadList
	// **********************************************************************
	public static void printThreadList() {
		printThreadList(false);
	}
	
	public static synchronized void printThreadList(boolean withStackTrace) {
		Thread[] t = new Thread[50];
		int i = Thread.enumerate(t);
		_RT.println("ACTIVE THREAD LIST:");
		for (int j = 0; j < i; j++) {
			Thread T = t[j];
			String msg="  - " + T;
			if (T == Thread.currentThread())
				msg=msg+" = CurrentThread";
			_RT.println(msg+"   STATE="+T.getState());
			if(withStackTrace) {
				_RT.printSimulaStackTrace(T,0);
				_RT.println("");
			}
		}
		//_RT.ASSERT(Thread.currentThread()==_CUR._THREAD,"Invariant: Thread.currentThread()==_CUR._THREAD");
		_RT.println("-----------------------------------------------------------------------------------------------");
	}

	public static void _LINE(String modid, int simLine) {
		currentModid=modid;
		currentSimLine=simLine;
	}  
  
}
