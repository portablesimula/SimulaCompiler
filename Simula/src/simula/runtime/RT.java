/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Properties;

import simula.common.ConsolePanel;
import simula.runtime.loom.ThreadUtils;

/**
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class RT { 
	private static final boolean BREAKING=true;//false;//true;
	private static final boolean TRACING=true;//false;//true;
	public  static boolean DEBUGGING=false;//true;
  
//	public static RTConsole console;
	public static ConsolePanel console;
  
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
	}
	  
	public static void setRuntimeOptions(final String[] args) {
		for(int i=0;i<args.length;i++) {
			String arg=args[i];
			if(arg.equalsIgnoreCase("-VERBOSE")) Option.VERBOSE=true;
			if(arg.equalsIgnoreCase("-DEBUGGING")) DEBUGGING=true;
//			if(arg.equalsIgnoreCase("-USE_CONTINUATIONS")) USE_LOOM=true;
			if(arg.equalsIgnoreCase("-USE_CONSOLE")) Option.USE_CONSOLE=true;
			if(arg.equalsIgnoreCase("-CODE_STEP_TRACING")) Option.CODE_STEP_TRACING=true;
			if(arg.equalsIgnoreCase("-BLOCK_TRACING")) Option.BLOCK_TRACING=true;
			if(arg.equalsIgnoreCase("-GOTO_TRACING")) Option.GOTO_TRACING=true;
			if(arg.equalsIgnoreCase("-THREAD_TRACING")) Option.THREAD_TRACING=true;
			if(arg.equalsIgnoreCase("-LOOM_TRACING")) Option.LOOM_TRACING=true;
			if(arg.equalsIgnoreCase("-QPS_TRACING")) Option.QPS_TRACING=true;
			if(arg.equalsIgnoreCase("-SML_TRACING")) Option.SML_TRACING=true;
		}
		//listRuntimeOptions();
	}
		  
	public static void listRuntimeOptions() {
		System.out.println("file.encoding="+System.getProperty("file.encoding"));
		System.out.println("defaultCharset="+Charset.defaultCharset());
		System.out.println("VERBOSE="+Option.VERBOSE);
		System.out.println("DEBUGGING="+DEBUGGING);
//		System.out.println("USE_CONTINUATIONS="+USE_LOOM);
		System.out.println("USE_CONSOLE="+Option.USE_CONSOLE);
		System.out.println("CODE_STEP_TRACING="+Option.CODE_STEP_TRACING);
		System.out.println("BLOCK_TRACING="+Option.BLOCK_TRACING);
		System.out.println("GOTO_TRACING="+Option.GOTO_TRACING);
		System.out.println("THREAD_TRACING="+Option.THREAD_TRACING);
		System.out.println("LOOM_TRACING="+Option.LOOM_TRACING);
		System.out.println("QPS_TRACING="+Option.QPS_TRACING);
		System.out.println("SML_TRACING="+Option.SML_TRACING);
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
			throw new RuntimeException("NONE-CHECK FAILED");
	}
  
	public static void ASSERT(final boolean test,final String msg) {
		if (!test) {
			printError("ASSERT(" + msg + ") -- FAILED");
			Thread.dumpStack();
			System.exit(-1);
			BREAK("Press [ENTER] Continue or [Q] for a Stack-Trace");
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
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return;
			}
			printError("BBREAK["+Thread.currentThread().getName()+"]: " + msg);
			char c=' ';//'q';
			if(RT.Option.USE_CONSOLE) {
				InFile$ sysin = RTObject$.SYSIN$;
				if (sysin != null) {
					sysin.inimage();
					c = sysin.inchar();
				}
			} else {
//				try {
//					c=(char) System.in.read();
//					System.out.println("GOT character: c="+(char)c);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
			if (c == 'Q' || c == 'q') { // System.err.println("QUIT!");
				printWarning("STACK-TRACE");
				ThreadUtils.printStackTrace();
				printSimulaStackTrace(2);
			}

		}
	}

	

	// *********************************************************************
	// *** SIMULA RUNTIME PROPERTIES
	// *********************************************************************

    private static File simulaPropertiesFile;
    private static Properties simulaProperties;
    
	public static String getProperty(final String key,final String defaultValue) {
		if(simulaProperties==null) loadProperties();
		return(simulaProperties.getProperty(key,defaultValue));
	}
	
	public static void setProperty(final String key,final String value) {
		if(simulaProperties==null) loadProperties();
		simulaProperties.setProperty(key,value);
		storeProperties();
	}
	
	private static void loadProperties() {
		String USER_HOME=System.getProperty("user.home");
		//System.out.println("USER_HOME="+USER_HOME);
		File simulaPropertiesDir=new File(USER_HOME+File.separatorChar+".simula");
		//System.out.println("simulaPropertiesDir="+simulaPropertiesDir);
		simulaPropertiesDir.mkdirs();
		simulaPropertiesFile=new File(simulaPropertiesDir,"simulaProperties.xml");
		simulaProperties = new Properties();
		try { simulaProperties.loadFromXML(new FileInputStream(simulaPropertiesFile));
		} catch(Exception e) {}
	}
	
	private static void storeProperties() {
		System.out.print("RT.storeProperties: SIMULA ");
		simulaProperties.list(System.out);
		try { simulaProperties.storeToXML(new FileOutputStream(simulaPropertiesFile),"Simula Properties");
		} catch(Exception e) { e.printStackTrace(); }
	}

	// *********************************************************************
	// *** TRACING AND DEBUGGING UTILITIES
	// *********************************************************************
  
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
		for (int i = start; i < n; i++)
			printSimulaLineInfo(stackTraceElement[i]);
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
	              //return(lineMap[x-1]);
	        	  RT.println("IN "+info.ident+'('+elt.getFileName()+':'+elt.getLineNumber()+" "+elt.getMethodName()+") at Simula Source Line "+lineMap[x-1]+"["+info.file+"]");
	        } catch(Throwable t) { }
	    } catch (Exception e) {
	    	//e.printStackTrace();
	    }
	}

  
}
