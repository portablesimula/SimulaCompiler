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
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class RT { 
	static boolean BREAKING=true;//false;//true;
	private static final boolean TRACING=true;//false;//true;
	public  static boolean DEBUGGING=false;//true;
  
	public static RTConsolePanel console;
  
	public static String progamIdent;
	public static int numberOfEditOverflows;

	public static class Option {
		public static boolean VERBOSE = false;//true;
		public static boolean USE_CONSOLE=false;//true;
		public static boolean CODE_STEP_TRACING = false;// true;
		public static boolean BLOCK_TRACING = false;// true;
		public static boolean GOTO_TRACING = false;// true;
		public static boolean THREAD_TRACING = false;// true;
		public static boolean LOOM_TRACING = false;// true;
		public static boolean QPS_TRACING = false; // true;
		public static boolean SML_TRACING = false; // true;
		public static boolean USE_VIRTUAL_THREAD=true;
		public static String  RUNTIME_USER_DIR="";
	}

	public static class SPORT_Option {
	    public static String ModuleName="ModuleName";
		public static String SourceDirName="C:\\GitHub\\SimulaCompiler\\Simula\\src\\sport\\rts";
		public static String SPORT_SysInsertDirName="CCCC:/WorkSpaces/SPort-System/S-Port/src/sport/rts";
//		public static String SCodeDirName="C:\\GitHub\\SimulaCompiler\\Simula\\src\\sport\\rts\\scode";
//		public static String TempDirName="C:\\GitHub\\SimulaCompiler\\Simula\\src\\sport\\rts\\temp";
//		public static String SourceFileName="C:\\GitHub\\SimulaCompiler\\Simula\\src\\sport\\rts\\RT.DEF";
		
		// getTextInfo
		public static String getSourceFileName() { return(SourceDirName+"\\"+ModuleName); }
//	    public static String ListingFileName=null;//"sysout";
	    public static String ListingFileName="sysout";
	    public static String getSCodeFileName() { return(createSubfileName("scode",ModuleName+".scd")); }
	    
	    private static String createSubfileName(String subdir,String name) {
	    	String tempFileName=SourceDirName+"\\"+subdir+"\\"+name;
	    	File file=new File(tempFileName);
	    	file.getParentFile().mkdirs();
	    	return(tempFileName);
	    }
	    
	    public static String getScratchFileName() {	return(createSubfileName("temp",ModuleName+".tmp")); }
	    public static String getAttributeOutputFileName() { return(createSubfileName("temp",ModuleName+".atr")); }
	    public static String getAttributeFileName() {
	    	//return(createSubfileName("temp",moduleIdent+".atr"));
	    	String fileName=SourceDirName+"\\"+"temp"+"\\"+ModuleName+".atr";
	    	File file=new File(fileName);
	    	if(!file.exists()) {
		    	String name=moduleIdent;
		    	int i=name.indexOf('.');
		    	if(i>0) name=name.substring(0,i);
	    		fileName=SPORT_SysInsertDirName+"/temp/"+name+".atr";
		    	file=new File(fileName);
	    		if(!file.exists()) System.out.println("getAttributeFileName: "+file+"  does NOT exists");
	    	}
	    	return(fileName);
	    }
	    public static String Selectors="AZ";
//	    public static String PredefFileName="PredefRTS-FileName";
//	    public static String PredefFileName="C:/Simuletta/Attrs/FEC/simulaRTS/COMBINE.atr"; 
	    public static String PredefFileName="C:/WorkSpaces/Predefiner/Predefiner/src/Attrs/FEC/PREDEF.atr";

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
	    public static String moduleIdent; // 1 The identifier of a class or procedure being separately compiled.
	    public static String xDecl1; // 2 The identifier given in an external declaration that is being processed.
	    public static String xDecl2; // 3 The external identification given in an external declaration that is being processed.
	}
	
	
	public static void setRuntimeOptions(final String[] args) {
		// Parse command line arguments.
		File file = null;
		for(int i=0;i<args.length;i++) {
			String arg=args[i];
			if (arg.charAt(0) == '-') { // command line option
				// General RTS Options
				if(arg.equalsIgnoreCase("-VERBOSE")) Option.VERBOSE=true;
				else if(arg.equalsIgnoreCase("-DEBUGGING")) DEBUGGING=true;
				else if(arg.equalsIgnoreCase("-USE_CONSOLE")) Option.USE_CONSOLE=true;
				else if(arg.equalsIgnoreCase("-CODE_STEP_TRACING")) Option.CODE_STEP_TRACING=true;
				else if(arg.equalsIgnoreCase("-BLOCK_TRACING")) Option.BLOCK_TRACING=true;
				else if(arg.equalsIgnoreCase("-GOTO_TRACING")) Option.GOTO_TRACING=true;
				else if(arg.equalsIgnoreCase("-THREAD_TRACING")) Option.THREAD_TRACING=true;
				else if(arg.equalsIgnoreCase("-LOOM_TRACING")) Option.LOOM_TRACING=true;
				else if(arg.equalsIgnoreCase("-QPS_TRACING")) Option.QPS_TRACING=true;
				else if(arg.equalsIgnoreCase("-SML_TRACING")) Option.SML_TRACING=true;
				else if(arg.equalsIgnoreCase("-USE_VIRTUAL_THREAD")) Option.USE_VIRTUAL_THREAD=true;
				else if (arg.equalsIgnoreCase("-RUNTIME_USER_DIR")) Option.RUNTIME_USER_DIR=args[++i];
				// Spesial S-Port Simula and Simuletta Options
				else if (arg.equalsIgnoreCase("-noexec")) ;//Option.noExecution=true;
				else if (arg.equalsIgnoreCase("-nowarn")) ;//{ Option.noJavacWarnings=true; Option.WARNINGS=false; }
				else if (arg.equalsIgnoreCase("-select")) RT.SPORT_Option.Selectors=args[++i];
				else if (arg.equalsIgnoreCase("-listing")) SPORT_Option.ListingFileName=args[++i];
				else if (arg.equalsIgnoreCase("-keepJava")) ;//setKeepJava(args[++i]);
				else if (arg.equalsIgnoreCase("-output")) ;//setOutputDir(args[++i]);
				else if (arg.equalsIgnoreCase("-trace")) RT.SPORT_Option.TraceLevel=Integer.decode(args[++i]);
				else error("Unknown option "+arg);
			} else {
				if(file==null) {
					file=new File(arg);
					SPORT_Option.SourceDirName=file.getParent();
					SPORT_Option.ModuleName=file.getName();
				}
				else error("multiple input files specified");
			}
		}	

		
		if(Option.VERBOSE) {
			listRuntimeOptions();
			RT.println("Begin Execution of Simula Program using "+getJavaID());
		}
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
		System.out.println("VERBOSE="+Option.VERBOSE);
		System.out.println("DEBUGGING="+DEBUGGING);
		System.out.println("USE_CONSOLE="+Option.USE_CONSOLE);
		System.out.println("CODE_STEP_TRACING="+Option.CODE_STEP_TRACING);
		System.out.println("BLOCK_TRACING="+Option.BLOCK_TRACING);
		System.out.println("GOTO_TRACING="+Option.GOTO_TRACING);
		System.out.println("THREAD_TRACING="+Option.THREAD_TRACING);
		System.out.println("LOOM_TRACING="+Option.LOOM_TRACING);
		System.out.println("QPS_TRACING="+Option.QPS_TRACING);
		System.out.println("SML_TRACING="+Option.SML_TRACING);
		System.out.println("USE_VIRTUAL_THREAD="+Option.USE_VIRTUAL_THREAD);
	}
	

	public static void println(final String s) {
		if(console!=null) console.write(s+'\n');
		else System.out.println(s);
	}

	public static void printError(final String s) {
		if(console!=null) console.writeError(s+'\n');
		else System.out.println(s);
	}

	public static void printWarning(final String s) {
		if(console!=null) console.writeWarning(s+'\n');
		else System.out.println(s);
	}
	
	public static void warning(final String msg) {
		printWarning("Simula Runtime Warning: "+msg);
		printSimulaStackTrace(0);
	}
  
	public static void TRACE(final String msg) {
		if (TRACING) println(Thread.currentThread().toString() + ": " + msg);
	}
  
	public static void NOT_IMPLEMENTED(final String s) {
		println("*** NOT IMPLEMENTED: " + s);
		BREAK("Press [ENTER] Continue or [Q] for a Stack-Trace");
	}

	public static void NoneCheck(final Object x) {
		if (x == null) // && !Continuation.SHUTING_DOWN$)
			throw new SimulaRuntimeError("NONE-CHECK FAILED");
	}
  
	public static void ASSERT(final boolean test,final String msg) {
		if (!test) {
			if (RT.console==null) { RT.console = new RTConsolePanel(); RT.console.popup(); }
			printError("ASSERT(" + msg + ") -- FAILED");
			if(BREAKING) BREAK("Press [ENTER] Continue or [Q] for a Stack-Trace");
			else { Thread.dumpStack(); System.exit(-1); }
		}
	}

	public static void ASSERT_CUR$(final RTObject$ obj,final String msg) {
		if (RTObject$.CUR$ != obj) {
			println(msg + ": CUR$=" + RTObject$.CUR$.edObjectAttributes());
			println(msg + ":  obj=" + obj.edObjectAttributes());
			RT.ASSERT(RTObject$.CUR$ == obj, msg);
		}
	}

	public static void BREAK(final String msg) {
		if (BREAKING) {
			if (RT.Option.CODE_STEP_TRACING) {
				printWarning(msg + ": <");
				try { Thread.sleep(2000);
				} catch (Exception e) {	e.printStackTrace(); }
				return;
			}
			if (RT.console==null) { RT.console = new RTConsolePanel(); RT.console.popup(); }
			printError("BREAK["+Thread.currentThread().getName()+"]: " + msg);
			char c=RT.console.read();
			if (c == 'Q' || c == 'q') { // System.err.println("QUIT!");
				printWarning("STACK-TRACE");
				ThreadUtils.printStackTrace();
				printSimulaStackTrace(2);
			}
		}
	}

	
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
		} catch (Exception e) {}
		return (0);
	}
	
	public static String getJavaID() {
        String javaID="Java version "+System.getProperty("java.version");
        if(Option.USE_VIRTUAL_THREAD) javaID=javaID+"-Virtual Threads";
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
//		System.out.print("RT.storeProperties: SIMULA ");
//		simulaProperties.list(System.out);
//		try { simulaProperties.storeToXML(new FileOutputStream(simulaPropertiesFile),"Simula Properties");
//		} catch(Exception e) { e.printStackTrace(); }
//	}

	// *********************************************************************
	// *** TRACING AND DEBUGGING UTILITIES
	// *********************************************************************
	  
	public static void printStaticChain() { RT.printStaticChain(RTObject$.CUR$); }
  
	public static void printStaticChain(final RTObject$ ins) {
		RTObject$ x = ins;
		println("*** STATIC CHAIN:");
		while (x != null) {
			boolean qps = x.isQPSystemBlock();
			boolean dau = x.isDetachUsed();
			println(" - " + x.edObjectIdent() + "[QPSystemBlock=" + qps + ",detachUsed=" + dau + ",state=" + x.STATE$+']');
			x = x.SL$;
		}

	}
	
	public static void printSimulaStackTrace(final Thread thread,final int start) {
		StackTraceElement stackTraceElement[] = thread.getStackTrace();
		int n = stackTraceElement.length;
		for (int i = start; i < n; i++)
			printSimulaLineInfo(stackTraceElement[i]);
	}
	
	public static void printSimulaStackTrace(final int start) {
		printSimulaStackTrace(Thread.currentThread(),start);
	}

	
	public static void printSimulaStackTrace(final Throwable e,final int start) {
		StackTraceElement stackTraceElement[] = e.getStackTrace();
		int n = stackTraceElement.length;
		for (int i = start; i < n; i++) {
			printSimulaLineInfo(stackTraceElement[i]);
			if(i>30) {
				println("... SimulaStackTrace "+(n-30)+" lines Truncated");
				return;
			}
		}
		
	}

	public static void printSimulaLineInfo(final StackTraceElement elt)	{
		try { 
		    Class<?> cls=Class.forName(elt.getClassName());
		    //RT.println("ENVIRONMENT$.getSimulaLineNumber: cls="+cls);
		    Field field=cls.getField("INFO$");
		    //RT.println("ENVIRONMENT$.getSimulaLineNumber: field="+field);
		    PROGINFO$ info=(PROGINFO$)field.get(null);
		    int[] lineMap=info.LINEMAP$;
	        int x=0; int javaLineNumber=elt.getLineNumber();
	        try { while(lineMap[x]<javaLineNumber) x=x+2;
	        	  RT.println("IN "+info.ident+'('+elt.getFileName()+':'+elt.getLineNumber()+" "+elt.getMethodName()+") at Simula Source Line "+lineMap[x-1]+"["+info.file+"]");
	        } catch(Throwable t) { }
	    } catch (Exception e) {
	    	//e.printStackTrace();
	    }
	}

  
}
