/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.utilities;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * 
 * @author Øystein Myhre Andersen
 *
 */
public class Util
{ 
  private static Writer writer;
  public static Writer setWriter(Writer _writer)
  { Writer prevWriter=writer;
	writer=_writer;
	return(prevWriter);  
  }
  
  public static void error(String msg)
  { System.err.println("Line "+Global.sourceLineNumber+" Error: "+msg);
    BREAK("");
  }

  public static void FATAL_ERROR(String s)
  { String msg="LINE "+Global.sourceLineNumber+": FATAL error - "+s;
    System.err.println(msg);
    try { throw new RuntimeException("FATAL error"); }
    catch(Exception e) { e.printStackTrace(); }
    System.exit(-1);
  }
  
  public static void warning(String msg)
  { if(Option.WARNINGS) System.err.println("LINE "+Global.sourceLineNumber+": WARNING: "+msg); }

  private static int prevLineNumber=0;
  public static void code(int indent,String line) {
	  ASSERT(Global.sourceLineNumber>0,"Invariant");
	  String s0=null;
	  String s=edIndent(indent)+line;
	  if(prevLineNumber!=Global.sourceLineNumber)
	  { String leadingBlanks="                          ";
	    s0=leadingBlanks+"// SourceLine "+Global.sourceLineNumber;
	    if(Option.TRACE_CODING) println("LINE "+Global.sourceLineNumber+s0);
	  }
	  if(Option.TRACE_CODING) println("CODE "+Global.sourceLineNumber+": "+s);
	  ASSERT(writer!=null,"Can't Output Code - writer==null"); 
	  try { if(s0!=null) writer.write(s0+'\n');
	        writer.write(s+'\n'); }
	  catch (IOException e) {
			System.out.println("Error Reading File");
			e.printStackTrace();
	  }
	  prevLineNumber=Global.sourceLineNumber;
  }
  private static String edIndent(int indent)
  { String s="";
	while((indent--)>0) s=s+"    ";
	return(s);  
  }

  public static void LIST(String msg) { TRACE("LIST",msg); }
  public static void TRACE(String msg) { TRACE("TRACE",msg); }
  
  public static void TRACE(String id,String msg)
  { if(Option.TRACING) println(id+" "+Global.sourceLineNumber+": "+msg); }
  
  public static void NOT_IMPLEMENTED(String s)
  { System.err.println("*** NOT IMPLEMENTED: "+s);
    BREAK("Continue ?");
  }
  
  public static void EXIT()
  { BREAK("FORCED EXIT");
    System.exit(-1);
  }
  
  public static void ASSERT(boolean test,String msg)
  { if(!test)
    { try { throw new RuntimeException("ASSERT("+msg+") -- FAILED"); }
      catch(Exception e) { e.printStackTrace(); }
      BREAK("Continue ?");
      //System.exit(-1);
    }
  }

  public static void BREAK(String title) { BREAK("BREAK",title); }
  public static void BREAK(String id,String title)
  { if(Option.BREAKING)
    { System.err.println(id+" "+Global.sourceLineNumber+": "+title+": <");
      { try
        { char c=(char)System.in.read();
          //System.err.println("INPUT "+c+"  "+(int)c);
          if(c=='Q'||c=='q')
          { //System.err.println("QUIT!");
            try { throw new RuntimeException("QUIT"); }
            catch(Exception e) { e.printStackTrace(); }
          }
          while(System.in.available()>0) System.in.read();
        }
        catch(Exception e) { e.printStackTrace();  System.exit(-1);}
      }
    }
  }

  public static void println(String s)
  { s=s.replace('\r',(char)0);
    s=s.replace('\n',(char)0);
    System.out.println(s);
  }
  
  
  //*******************************************************************************
  //*** Reflection Utilities
  //*******************************************************************************
  
	
	public static void listClass(Class<?> c)
	{ listConstructors(c);
	  listMethods(c);	
	}
	
	public static void listMethods(Class<?> c)
	{ Method[] allMethods = c.getDeclaredMethods();
		for(Method m:allMethods) listMethod(m);
	}
	
	public static void listConstructors(Class<?> c)
	{ Constructor<?>[] allConstructors = c.getConstructors();
		for (Constructor<?> constructor : allConstructors)
			listConstructor(constructor);
	}
	
	public static void listConstructor(Constructor<?> m)
	{ System.out.format("%s%n", m.toGenericString());
	  String  fmt = "%24s: %s%n";
	  Class<?>[] pType  = m.getParameterTypes();
	  Type[] gpType = m.getGenericParameterTypes();
	  for (int i = 0; i < pType.length; i++) {
      System.out.format(fmt,"ParameterType", pType[i]);
		System.out.format(fmt,"GenericParameterType", gpType[i]);
	  }
	  Class<?>[] xType  = m.getExceptionTypes();
	  Type[] gxType = m.getGenericExceptionTypes();
	  for (int i = 0; i < xType.length; i++) {
		System.out.format(fmt,"ExceptionType", xType[i]);
		System.out.format(fmt,"GenericExceptionType", gxType[i]);
	  }
	}
	
	public static void listMethod(Method m)
	{ System.out.format("%s%n", m.toGenericString());
	  String  fmt = "%24s: %s%n";

	  System.out.format(fmt, "ReturnType", m.getReturnType());
	  System.out.format(fmt, "GenericReturnType", m.getGenericReturnType());

	  Class<?>[] pType  = m.getParameterTypes();
	  Type[] gpType = m.getGenericParameterTypes();
	  for (int i = 0; i < pType.length; i++) {
      System.out.format(fmt,"ParameterType", pType[i]);
		System.out.format(fmt,"GenericParameterType", gpType[i]);
	  }
	  Class<?>[] xType  = m.getExceptionTypes();
	  Type[] gxType = m.getGenericExceptionTypes();
	  for (int i = 0; i < xType.length; i++) {
		System.out.format(fmt,"ExceptionType", xType[i]);
		System.out.format(fmt,"GenericExceptionType", gxType[i]);
	  }
	}
  
  
  
  
  
  
  
  
}
