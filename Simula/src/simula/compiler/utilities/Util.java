/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * A set of all static Utility Methods
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class Util
{ 
  
  public static int nError;
  public static void error(final String msg)
  { String err="Line "+Global.sourceLineNumber+" Error: "+msg;
    nError++;
    System.err.println(err);
    if(Global.console!=null) Global.console.writeError(err+'\n');
    BREAK("Continue ?");
  }

  public static void FATAL_ERROR(final String s)
  { String msg="LINE "+Global.sourceLineNumber+": FATAL error - "+s;
    System.err.println(msg);
    try { throw new RuntimeException("FATAL error"); }
    catch(Exception e) { e.printStackTrace(); }
    System.exit(-1);
  }
  
  public static void warning(final String msg) {
	  String line="LINE "+Global.sourceLineNumber+": WARNING: "+msg;
	  if(Option.WARNINGS) System.err.println(line);
	    if(Global.console!=null) Global.console.writeWarning(line+'\n');
  }
  
  public static void message(final String msg) {
	  if(Option.WARNINGS) System.err.println(msg);
	    if(Global.console!=null) Global.console.write(msg+'\n');
  }


  public static void LIST(final String msg) { TRACE("LIST",msg); }
  public static void TRACE(final String msg) { TRACE("TRACE",msg); }
  
  public static void TRACE(final String id,String msg)
  { if(Option.TRACING) println(id+" "+Global.sourceLineNumber+": "+msg);
    //Util.BREAK("");
  }
  
  public static void NOT_IMPLEMENTED(final String s)
  { System.err.println("*** NOT IMPLEMENTED: "+s);
    BREAK("Continue ?");
  }
  
  public static void EXIT()
  { System.out.println("FORCED EXIT");
    BREAK("FORCED EXIT");
    System.exit(-1);
  }
  
  public static void ASSERT(final boolean test,final String msg)
  { if(!test)
    { try { throw new RuntimeException("ASSERT("+msg+") -- FAILED"); }
      catch(Exception e) { e.printStackTrace(); }
      BREAK("Continue ?");
      //System.exit(-1);
    }
  }

  public static void BREAK(final String title) { BREAK("BREAK",title); }
  public static void BREAK(final String id,final String title)
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

  public static void println(final String s)
  { String u=s.replace('\r',(char)0);
    u=u.replace('\n',(char)0);
    System.out.println(u);
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
	public static int IPOW(int b, int x) {
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
  
  //*******************************************************************************
  //*** Reflection Utilities
  //*******************************************************************************
  
	
	public static void listClass(final Class<?> c)
	{ listConstructors(c);
	  listMethods(c);	
	}
	
	public static void listMethods(final Class<?> c)
	{ Method[] allMethods = c.getDeclaredMethods();
		for(Method m:allMethods) listMethod(m);
	}
	
	public static void listConstructors(final Class<?> c)
	{ Constructor<?>[] allConstructors = c.getConstructors();
		for (Constructor<?> constructor : allConstructors)
			listConstructor(constructor);
	}
	
	public static void listConstructor(final Constructor<?> m)
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
	
	public static void listMethod(final Method m)
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
