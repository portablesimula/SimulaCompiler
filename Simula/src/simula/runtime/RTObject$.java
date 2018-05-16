/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.lang.reflect.Constructor;
import java.util.Iterator;

import simula.compiler.utilities.Util;

/**
* 
* @author Øystein Myhre Andersen
*/
public abstract class RTObject$ extends ENVIRONMENT$  implements Runnable {
	private static final boolean DEBUG=true;
	protected static boolean BLOCK_TRACING=false;//true;
	protected static boolean THREAD_TRACING=false;//true;
	private static final boolean CTX_TRACING=false; //true; //false; //true;
	protected static final boolean QPS_TRACING=false; //true;
	protected static final boolean SML_TRACING=false; //true;

	public static void warning(String msg) { System.err.println("Warning: "+msg); }
	
	// BASICIO
	static final int INPUT_LINELENGTH_ = 80;
	static final int OUTPUT_LINELENGTH_ = 132;
    static InFile$ SYSIN$;
	public InFile$ sysin() { return (SYSIN$); }

	public static PrintFile$ SYSOUT$;
	public PrintFile$ sysout() { return (SYSOUT$); }

	// QPS
	enum OperationalState { detached,resumed,attached,terminated }
	protected OperationalState STATE$;
	private Thread THREAD$;
	protected ClassBody CODE$;
	
	// RTS
	public static BASICIO$ CTX$=new BASICIO$(null);
	public static RTObject$ PRG$; // Current Program
	public static RTObject$[] CV$=new RTObject$[50]; // Context Vector
	public static RTObject$ CUR$=CTX$; // Current Block Instance

	public boolean isQPSystemBlock() { return(false); } // Needs Redefinition
	public boolean isDetachable() { return(false); } // Needs Redefinition

	/**
	 * This is a pointer to the object of the nearest textually enclosing block
	 * instance, also called 'static link'.
	 */
	protected RTObject$ SL$; // Static Link

	/**
	 * If this block instance is attached this is a pointer to the
	 * object of the block instance to which the instance is attached (also
	 * called dynamic link), i.e. it points to the block instance
	 * which called this one.
	 */
	RTObject$ DL$; // Dynamic Link

	/**
	 * Static block level.
	 */
	int BL$;

	// ************************************************************
	// *** Constructor
	// ************************************************************
	/**
	 * Constructor
	 * @param SL Static Link, may be null when creating CONTEXT, TEXTOBJ and TXTREF
	 */
	public RTObject$(RTObject$ SL)
	{ if(SL!=null) { this.BL$=SL.BL$+1; this.SL$=SL; }	}

	
	// *********************************************************************
	// *** PROCEDURE HANDLING
	// *********************************************************************
	/**
	 * This method is virtual and must be redefined in all procedure blocks
	 * @param obj Procedure's Parameter Value Object
     * @return
	 */
    public RTObject$ setPar(Object obj) { return(this); }

    /**
	 * This method is virtual and must be redefined in all type procedure blocks
     * @return
     */
    public Object $result() { return(null); }
    
	// *******************************************************
	// *** FRAMEWORK for Procedure-Parameters in Java Coding
	// *******************************************************
	public class $PRCQNT
	{ RTObject$ staticLink;
	  Class<?> procedure;
		  
	  // Constructor
	  public $PRCQNT(RTObject$ staticLink,Class<?> procedure)
	  { this.staticLink=staticLink; this.procedure=procedure; }
			  
	  public RTObject$ CPF()
	  { //Util.BREAK("CPF: procedure="+procedure+", Qual="+procedure.getClass().getSimpleName());
	    try
		{ Constructor<?> constr = procedure.getConstructor(new Class[]{RTObject$.class});
		  //Util.BREAK("CPF2: constr="+constr+", Qual="+procedure.getClass().getSimpleName());
		  Object obj=constr.newInstance(staticLink);
		  //Util.BREAK("CPF3: obj="+obj+", Qual="+obj.getClass().getSimpleName());
		  return((RTObject$)obj);  
		}
		catch(Throwable e)
		{ //Util.listConstructors(procedure);
		  //Util.listMethods(procedure);	
		  throw new RuntimeException("FATAL error - Impossible situation",e);
		}  
	  }
		  
	  public String toString()
	  { return("Simula $PRCQNT("+staticLink+','+procedure+')'); }
		  
	}
	
	public $ARRAY<?> arrayValue(Object par)
	{ //Util.BREAK("RTObject.arrayValue: par="+par);
	  //Util.BREAK("RTObject.arrayValue: par'Qual="+par.getClass().getSimpleName());
	  if(par instanceof $NAME<?>) return((($NAME<$ARRAY<?>>)par).get());
	  return(($ARRAY<?>)par);
	}
	
	public $PRCQNT procValue(Object par)
	{ //Util.BREAK("RTObject.arrayValue: par="+par);
	  //Util.BREAK("RTObject.arrayValue: par'Qual="+par.getClass().getSimpleName());
	  if(par instanceof $NAME<?>) return((($NAME<$PRCQNT>)par).get());
	  return(($PRCQNT)par);
	}
	
//	public TXT$ TXT$Value(Object par)
//	{ Util.BREAK("RTObject.TXT$Value: par="+par);
//	  Util.BREAK("RTObject.TXT$Value: par'Qual="+par.getClass().getSimpleName());
//	  Util.BREAK("RTObject.TXT$Value: par'super'Qual="+par.getClass().getSuperclass().getSimpleName());
//	  if(par instanceof $NAME<?>) par=(($NAME<TXT$>)par).get();
//	  if(par instanceof $PRCQNT) par=(($PRCQNT)par).CPF().$result();
//	  return((TXT$)par);
//	}
	
	public Object objectValue(Object par)
	{ //Util.BREAK("RTObject.objectValue: par="+par);
	  //Util.BREAK("RTObject.objectValue: par'Qual="+par.getClass().getSimpleName());
//	  if(par instanceof $NAME<?>) return((($NAME<?>)par).get());
	  if(par instanceof $NAME<?>) par=(($NAME<?>)par).get();
	  if(par instanceof $PRCQNT) par=(($PRCQNT)par).CPF().$result();
	  return(par);
	}
	
	public int intValue(Object par)
	{ //Util.BREAK("RTObject.intValue: par="+par);
	  //Util.BREAK("RTObject.intValue: par'Qual="+par.getClass().getSimpleName());
	  //Util.BREAK("RTObject.intValue: par'super'Qual="+par.getClass().getSuperclass().getSimpleName());
	  if(par instanceof $NAME<?>) par=(($NAME<?>)par).get();
	  if(par instanceof $PRCQNT) par=(($PRCQNT)par).CPF().$result();
	  if(par instanceof Float) return((int)par);
	  if(par instanceof Double) return((int)(double)par);
	  if(par instanceof Short) return((int)(short)par);
	  if(par instanceof Integer) return((int)par);
	  throw new ClassCastException("Incompatible Types: int,"+par.getClass().getSimpleName());
	}
	
	public short shortValue(Object par)
	{ if(par instanceof $NAME<?>) par=(($NAME<?>)par).get();
	  if(par instanceof $PRCQNT) par=(($PRCQNT)par).CPF().$result();
	  if(par instanceof Float) return((short)(float)par);
	  if(par instanceof Double) return((short)(double)par);
	  if(par instanceof Short) return((short)par);
	  if(par instanceof Integer) return((short)(int)par);
	  throw new ClassCastException("Incompatible Types: short,"+par.getClass().getSimpleName());
	}
	
	public float floatValue(Object par)
	{ if(par instanceof $NAME<?>) par=(($NAME<?>)par).get();
	  if(par instanceof $PRCQNT) par=(($PRCQNT)par).CPF().$result();
	  if(par instanceof Float) return((float)par);
	  if(par instanceof Double) return((float)(double)par);
	  if(par instanceof Short) return((float)(short)par);
	  if(par instanceof Integer) return((float)(int)par);
	  throw new ClassCastException("Incompatible Types: float,"+par.getClass().getSimpleName());
	}
	
	public double doubleValue(Object par)
	{ if(par instanceof $NAME<?>) par=(($NAME<?>)par).get();
	  if(par instanceof $PRCQNT) par=(($PRCQNT)par).CPF().$result();
	  if(par instanceof Float) return((double)(float) par);
	  if(par instanceof Double) return((double)(double)par);
	  if(par instanceof Short) return((double)(short)par);
	  if(par instanceof Integer) return((double)(int)par);
	  throw new ClassCastException("Incompatible Types: double,"+par.getClass().getSimpleName());
	}

    
	// *******************************************************
	// *** FRAMEWORK for for-list iteration 
	// *******************************************************
	
	public class ForList implements Iterable<Boolean>
	{ ForListIterator forListIterator;
	  public ForList(ForElt... forElt)
	  {	forListIterator=new ForListIterator(forElt);  }
	  public Iterator<Boolean> iterator() { return(forListIterator); }
	}

	public class ForListIterator implements Iterator<Boolean>
	{ ForElt[] forElt; int i;
	  public ForListIterator(ForElt... forElt)
	  { this.forElt=forElt; }
	  public boolean hasNext() {return(i<forElt.length && forElt[i].hasNext()); }
	  public Boolean next()
	  { Boolean val=forElt[i].next();
	    if(!forElt[i].hasNext()) i++;
	    return(val);
	  }
	}
	
	public abstract class ForElt implements Iterator<Boolean>
	{ boolean more;
	  public ForElt() { more=true; }
	  public boolean hasNext() {return(more); }
	}
	
	public class SingleElt<T> extends ForElt
	{ $NAME<T> cvar,nextValue; //boolean more;
	  public SingleElt($NAME<T> cvar,$NAME<T> init)
	  { this.cvar=cvar; this.nextValue=init; more=true; }
	  public boolean hasNext() {return(nextValue!=null); }
	  public Boolean next()
	  { if(nextValue==null) return(false);
	    T val=nextValue.get();
	    cvar.put(val); nextValue=null;
	    //Util.BREAK("SingleElt.next: return="+val);
	    return(true);
	  }
	}
	
	public class SingleTValElt extends ForElt
	{ // For t:= <TextExpr>  // Text Value Assignment
	  $NAME<TXT$> cvar,nextValue; //boolean more;
	  public SingleTValElt($NAME<TXT$> cvar,$NAME<TXT$> init)
	  { this.cvar=cvar; this.nextValue=init; more=true; }
	  public boolean hasNext() {return(nextValue!=null); }
	  public Boolean next()
	  { if(nextValue==null) return(false);
	    TXT$ val=nextValue.get();
	    ASGTXT$(cvar.get(),val);
	    nextValue=null;
	    //Util.BREAK("SingleElt.next: return="+val);
	    return(true);
	  }
	}
	
	public class StepUntil extends ForElt
	{ $NAME<Number> cvar,init,step,until;
	  Number nextValue;
	  public StepUntil($NAME<Number> cvar,$NAME<Number> init,$NAME<Number> step,$NAME<Number> until)
	  { this.cvar=cvar; this.init=init; this.step=step; this.until=until; }
	  public Boolean next()
	  { if(nextValue==null) { nextValue=init.get(); cvar.put(nextValue); return(true); } // First value
	    Number val=nextValue;
//	    nextValue=val+step;
//      more:= step*(nextValue-until) <= 0
	    Number stp=step.get();
	    Number utl=until.get();
	    if(val instanceof Double || stp instanceof Double) {
	    	nextValue=new Double(val.doubleValue() + stp.doubleValue());
	        more=( stp.floatValue()*(nextValue.floatValue()-utl.floatValue()) <= 0 );
	    } else if(val instanceof Float || stp instanceof Float) {
	    	nextValue=new Float(val.floatValue() + stp.floatValue());
	        more=( stp.floatValue()*(nextValue.floatValue()-utl.floatValue()) <= 0 );
	    } else if(val instanceof Long || stp instanceof Long) {
	    	nextValue=new Float(val.longValue() + stp.longValue());
	        more=( stp.longValue()*(nextValue.longValue()-utl.longValue()) <= 0 );
	    } else {
	    	nextValue=new Integer(val.intValue() + stp.intValue());
	        more=( stp.intValue()*(nextValue.intValue()-utl.intValue()) <= 0 );
	    }
	    //Util.BREAK("StepUntil.next: return="+val+", nextValue="+nextValue+", more="+more);
	    cvar.put(nextValue);
		return(more);
	  }
	}
	
	public class WhileElt<T> extends ForElt
	{ $NAME<T> cvar,expr; $NAME<Boolean> cond;
	  public WhileElt($NAME<T> cvar,$NAME<T> expr,$NAME<Boolean> cond)
	  { this.cvar=cvar; this.expr=expr; this.cond=cond; }
	  public Boolean next()
	  { T val=expr.get();
	    cvar.put(val);
	    more=cond.get();    // IF not more return null - test i loopen: if(CB$==null) continue;
	    //Util.BREAK("WhileElt.next: return="+val);
		return(more);
	  }
	}
	
	public class WhileTValElt extends ForElt
	{ // For t:= <TextExpr> while <Cond>  // Text Value Assignment
	  $NAME<TXT$> cvar,expr; $NAME<Boolean> cond;
	  public WhileTValElt($NAME<TXT$> cvar,$NAME<TXT$> expr,$NAME<Boolean> cond)
	  { this.cvar=cvar; this.expr=expr; this.cond=cond; }
	  public Boolean next()
	  { TXT$ val=expr.get();
//	    cvar.put(val);
	    ASGTXT$(cvar.get(),val);
	    more=cond.get();    // IF not more return null - test i loopen: if(CB$==null) continue;
	    //Util.BREAK("WhileElt.next: return="+val);
		return(more);
	  }
	}
	
//	int cv;
//	private void TEST()
//	{ int gg=0;
//	
//	  $NAME<Number> cvn1=new $NAME<Number>()
//	  { public Number put(Number x){cv=(int)x; return(cv);};
//	    public Number get(){return(cv); }
//	  };
//
//	  $NAME<Number> n1=new $NAME<Number>() { public Number get(){return(1); }};
//	  $NAME<Number> n2=new $NAME<Number>() { public Number get(){return(2); }};
//	  $NAME<Number> n3=new $NAME<Number>() { public Number get(){return(3); }};
//	  $NAME<Number> n4=new $NAME<Number>() { public Number get(){return(4); }};
//	  $NAME<Number> n5=new $NAME<Number>() { public Number get(){return(5); }};
//	  $NAME<Number> n201=new $NAME<Number>() { public Number get(){return(201); }};
//	  $NAME<Boolean> b1=new $NAME<Boolean>() { public Boolean get(){return(2>01); }};
//	  for(boolean CB$:new ForList(
//			 new SingleElt<Number>(cvn1,n1)
//			,new SingleElt<Number>(cvn1,n3)
//			,new StepUntil(cvn1,n5,n3,n201)
//			,new WhileElt<Number>(cvn1,n4,b1) ))
//	  { if(!CB$) continue;
//	    // Statements ...
//	  }
//	}
	

	// ************************************************************
	// *** lOCAL label  - Meant for Byte-Code Engineering
	// ************************************************************
	public class LABEL
	{ String ident;
	  public int index; // I.e. ordinal number of the labeled statement.
	  public LABEL(String ident) { this.ident=ident; }
	}
	
	public void GOTO(LABEL L) {} // Local GOTO - Needs ByteCode Engineering.

	
	
	// ************************************************************
	// *** FRAMEWORK for NonLocal Label-Parameters in Java Coding
	// ************************************************************
	public class $LABQNT
	{ RTObject$ SL; // Static link, i.e. the block in which the label is defined.
	  LABEL L;     // Local Label Identifier within its Scope(staticLink).
	  
	  // Constructor
	  public $LABQNT(RTObject$ staticLink,LABEL L)
	  { this.SL=staticLink; this.L=L; }

	  public void GOTO() // GOTO Non-Local Label
	  { //Util.BREAK("GOTO: $LABQNT="+this);
	    RTObject$ dl;     // Temporary to 'CUR$.dl'.
//	    RTObject main;   // The head of the main component and also
//	                     // the head of the quasi-parallel system.

	    while(CUR$!=this.SL) // follow operating chain, instance by instance.
	    { //  If we are jumping somewhere we shouldn't, report the error.
	      if(CUR$==null) throw new RuntimeException("Illegal goto destination.");
	      if(CUR$.STATE$==OperationalState.attached)
	      { dl=CUR$.DL$; CUR$.STATE$=OperationalState.terminated;
	        CUR$.DL$=null; CUR$=dl;
	  //-      elsif CUR$.sort = S_RES                    //- REMOVED 4/10-84 //-
	  //-      then //  Terminate this component head, enter the main component.
	  //-           CUR$.sort:=S_TRM; main:=CUR$.sl; // Behave as if DETACH.
	  //-           //-  Ignore any temporary(aStack) objects.
	  //-           repeat while main.dl.$LSC = nowhere
	  //-           do main:=main.dl endrepeat;
	  //-           //-  The main component becomes the operating component.
	  //-           dl:=CUR$.dl; CUR$.dl:=none;
	  //-           CUR$:=main.dl; main.dl:=dl;
	      } else CUR$=CUR$.DL$;
	    }

	    // Have updated current instance. Goto local label.
	    CUR$.GOTO(L);
	  }
	  
	  public String toString()
	  { return("$LABQNT("+SL+','+L+')'); }
	  
	}

	// ************************************************************
	// *** Update Context Vector.
	// ************************************************************
	/**
	 * Update Context Vector.
	 * <p>
	 * The Context Vector must be updated whenever the value of CUR$ is changed.
	 * In general this is done by calling the updateContextVector routine. In certain
	 * cases (e.g. begin sub-block, enter normal procedure) this is simply a
	 * matter of adding a new level and is done by inline coding. In other cases
	 * (e.g. exit from a sub-block or prefixed block) the current level is simply
	 * deleted and therefore no action is necessary at all.
	 */
	public static void updateContextVector() {
		if(DEBUG) for(int i=0;i<CV$.length;i++) CV$[i]=null;
		CV$[0]=CTX$;
		RTObject$ x = CUR$;
		//Util.BREAK("updateContextVector: CUR$="+CUR$.edString());
		if(x!=null) 
		do {
			//Util.BREAK("updateContextVector: ["+x.BL$+"] ==> "+x.edString());
			CV$[x.BL$] = x;
			x = x.SL$;
		} while (x!=null && x.BL$ > 0);
		if(CTX_TRACING) printContextVector();
	}


	// ************************************************************
	// *** BPRG  --  Begin Program
	// ************************************************************
	/**
	 * The begin program routine (BPRG) is the runtime system initialization
	 * routine. It will initiate the global data in the runtime system.
	 */
	public void BPRG(String ident) {
		if(BLOCK_TRACING) TRACE("Begin Execution of Simula Program: "+ident);
		if(SYSIN$==null)
		{ SYSIN$ = new InFile$(this,new TXT$("SYSIN"));
		  SYSOUT$ = new PrintFile$(this,new TXT$("SYSOUT"));
		  SYSIN$.open(blanks(INPUT_LINELENGTH_));
		  SYSOUT$.open(blanks(OUTPUT_LINELENGTH_));
		}
		PRG$=this; CUR$=CTX$;
		BBLK();
	}
	
	// ************************************************************
	// *** BBLK - Begin Block
	// ************************************************************
	/**
	 * This routine is used to initiate a block instance.
	 * Its functions are:
	 * <p>
	 * <ul>
	 * <li>Attach the block to its dynamic environment.</li>
	 * <p>
	 * <li>Update the current instance pointer(CUR$).</li>
	 * <p>
	 * <li>Update the Context Vector(CV$[]).</li>
	 * <p>
	 * <li>Return to the block's declaration code.</li>
	 * </ul>
	 */
	public void BBLK() {
		DL$=CUR$; CUR$=this;
		this.THREAD$=Thread.currentThread(); 
	    STATE$=OperationalState.attached;
		if(BLOCK_TRACING) TRACE("BEGIN "+edString());
		Util.ASSERT(SL$!=null,"Invariant");
		updateContextVector();
	}

	// *********************************************************************
	// *** EBLK - End Block
	// *********************************************************************
	/**
	 * End Block.
	 * <p>
	 * This routine is used to terminate a block instance when control passes
	 * through the final end (of the outermost prefix for class and prefixed block).
	 * <p>
	 * According to the different categories of block instances, we have the
	 * following cases:
	 * <p>
	 * <ul>
	 * <li>Terminate prefixed block instance.
	 * <p>
	 * Update the 'CUR$' pointer and return to Compiler generated code.</li>
	 * <p>
	 * <li>
	 * Terminate class instance.
	 * <p>
	 * The object is marked 'terminated' and the 'CUR$' pointer is updated.</li>
	 * <p>
	 * If the class instance is detached:
	 * The instance is marked as terminated. The sub-block or prefixed block
	 * representing the quasiparallel system of which the instance was a
	 * component is located. The main program of the system is then 'resumed'.
	 * <p>
	 * </li>
	 * </ul>
	 * Finally; Update update context vector, swap threads and
	 * return to Compiler generated code.
	 * <p>
	 * However; If the program passes through its final end sysout.outimage
	 * is called. The the entire program is terminated.
	 * <p>
	 */
	public void EBLK()
	  { RTObject$ dl;   // A temporary to the instance dynamically
	                    // enclosing the resumed object ('CUR$').
	    RTObject$ main; // The head of the main component and also
	                    // the head of the quasi-parallel system.
	    //Util.BREAK("ECB "+edString());
	    if(BLOCK_TRACING) TRACE("END BLOCK(1) "+edString());
	    // Treat the attached case first, it is probably most common.
	    if(CUR$.STATE$==OperationalState.attached) {
	    	CUR$.STATE$=OperationalState.terminated;
	        //  Make the dynamic enclosure the new current instance.
	        CUR$=CUR$.DL$;
		    if(BLOCK_TRACING) TRACE("END BLOCK "+edString());
	    } else if(CUR$.STATE$==OperationalState.resumed) {
	    	// Treat the case of a resumed and operating object.
	        //  It is the head of an object component. The class
	        //  object enters the terminated state, and the object component
	        //  disappears from its system. The main component of that system
	        //  takes its place as the operating component of the system.
	        //  Invariant:  CUR$.STATE$ = resumed  and  CUR$.DL = main.SL
	        CUR$.STATE$=OperationalState.terminated;
	        //  Find main component (and system) head. It must be the static
	        //  enclosure since the object has been RESUMEd.
	        main=CUR$.SL$;
	        //  The main component becomes the operating component.
	        dl=CUR$.DL$; CUR$.DL$=null;
	        CUR$=main.DL$; main.DL$=dl;
		    if(BLOCK_TRACING) TRACE("END COMPONENT "+edString());
//	    } else {
//	        //  Treat the case of a prefixed block instance.
//	        CUR$=CUR$.DL$;
//		    if(BLOCK_TRACING) TRACE("END PREFIXED BLOCK "+edString());
	    }
	    if(CUR$==null || CUR$==CTX$) {
	       //SYSIN$.close();
		   //SYSOUT$.close();
	       SYSOUT$.outimage();
		   //Util.BREAK("PROGRAM PASSES THROUGH FINAL END "+edString());
		   if(BLOCK_TRACING) TRACE("PROGRAM PASSES THROUGH FINAL END "+edString());
		   if(CTX_TRACING) printContextVector();
		   if(THREAD_TRACING) printThreadList(); 
		   System.exit(0);
	    } else {
		   updateContextVector();
	       if(this.THREAD$!=CUR$.THREAD$)
	       { if(QPS_TRACING) TRACE("Resume "+CUR$.THREAD$);
	         CUR$.THREAD$.resume();
	         if(QPS_TRACING) TRACE("Terminate "+this.THREAD$);
	         this.THREAD$=null; // Leave it to the GarbageCollector
	       }
	    }
	  }


	// *********************************************************************
	// *** QUASI PARALLEL SEQUENCING 
	// *********************************************************************

	// *********************************************************************
	// *** DETACH  -  MOVED TO CLASS$ -- See Simula Standard 7.3.1 Detach
	// *********************************************************************
	
	// *********************************************************************
	// *** CALL  -  See Simula Standard 7.3.1 Call
	// *********************************************************************
	/**
	 * <p>
	 * "call" is formally a procedure with one object reference parameter
	 * qualified by a fictitious class 'CLASS' including all classes.
	 * Let Y denote the object referenced by a call statement.
	 * 
	 * <p>
	 * If Y is terminated, attached or resumed, or Y == none, the call statement
	 * constitutes an error.
	 * 
	 * <p>
	 * Assume Y is a detached object. The effect of the call statement is:
	 * <ul>
	 * <li>Y becomes attached to the block instance containing the call
	 * statement, whereby Y loses its status as a component head. As a
	 * consequence the system to which Y belongs (if any) loses the associated
	 * component.
	 * 
	 * <li>The PSC is moved to the (former) reactivation point of Y. As a
	 * consequence, all block instances on the reactivation chain of Y become
	 * operating.
	 * </ul>
	 * <p>
	 * 
	 * @param obj
	 *            The object to be Called (Coroutine)
	 */
	public void call(RTObject$ ins)
	{ RTObject$ dl;     //  Temporary reference to dynamic enclosure.
	  if(ins==null) throw new RuntimeException("Call(x): x is none.");
	  if(QPS_TRACING) TRACE("BEGIN CALL "+ins.edString());
	  if(ins.STATE$!=OperationalState.detached) throw
	        new RuntimeException("Call(x): x is not in detached state.");
	  // The object to be attached cannot be on the operating chain,
	  // because then its state would have been resumed and not detached.

	  // Swap the contents of 'CUR$' and object's 'dl'.
	  //  <ins.DL$,CUR$>:=<CUR$,ins.DL$>;
	  dl=ins.DL$; ins.DL$=CUR$; CUR$=dl;
	  // From now on the object is in attached state.
	  // It is no longer a component head.
	  ins.STATE$=OperationalState.attached;
	  updateContextVector(); // TODO: ???
	  if(QPS_TRACING) TRACE("END CALL "+ins.edString());
	  swapThreads(ins.DL$);
	}

	// *********************************************************************
	// *** RESUME  -  See Simula Standard 7.3.1 Resume
	// *********************************************************************
	/**
	 * <p>
	 * "resume" is formally a procedure with one object reference parameter
	 * qualified by a fictitious class 'CLASS' including all classes.
	 * Let Y denote the object referenced by a resume statement.
	 * 
	 * <p>
	 * If Y is not local to a system head, i.e. if Y is local to a class object
	 * or an instance of a procedure body, the resume statement constitutes an
	 * error.
	 * 
	 * <p>
	 * If Y is terminated or attached, or Y==none, the resume statement
	 * constitutes an error.
	 * 
	 * <p>
	 * If Y is a resumed object, the resume statement has no effect (it is a
	 * consequence of the language definition that Y must then be operating.)
	 * 
	 * <p>
	 * Assume Y is a detached object being (the head of) a non-operative system
	 * component. Let S be the associated system and let X denote (the head of)
	 * the current operative component of S. It is a consequence of the language
	 * definition that X must be operating, and that X is either the main
	 * component of S or local to the head of S. The effect of the resume
	 * statement is:
	 * <ul>
	 * <li>X becomes non-operative, its reactivation point positioned
	 * immediately after the resume statement. As a consequence, that part of
	 * the operating chain which is dynamically enclosed by X becomes the
	 * (non-operating) reactivation chain of X. If X is an object component its
	 * head enters the detached state.
	 * 
	 * <li>The PSC is moved to the reactivation point of Y, whereby Y enters the
	 * resumed state and becomes operative and operating. As a consequence, all
	 * block instances on the reactivation chain of Y also become operating.
	 * </ul>
	 * 
	 * @param obj
	 *            The object to be Resumed
	 */
	public void resume(RTObject$ ins)
	{ RTObject$ comp;   //  Component head.
	  RTObject$ mainSL; //  Static enclosure of main component head.
	  RTObject$ main;   //  The head of the main component and also
	                    //  the head of the quasi-parallel system.
	  if(ins==null) throw new RuntimeException("Resume(x): x is none.");
	  if(QPS_TRACING) TRACE("BEGIN RESUME "+ins.edString());
	 
	  if(ins.STATE$!=OperationalState.resumed) // A no-operation?
	  { // The object to be resumed must be local to a system head.
	    main=ins.SL$;
	    if(!main.isQPSystemBlock()) throw
	  	     new RuntimeException("Resume(x): x is not local to sub-block or prefixed block.");

	    if(ins.STATE$!=OperationalState.detached) throw
	         new RuntimeException("Resume(x): x is not in detached state but "+ins.STATE$);
	    // Find the operating component of the quasi-parallel system.
	    comp=CUR$; mainSL=main.SL$;
	    while(comp.DL$!=mainSL)
	    { Util.ASSERT(comp.DL$!=comp,"Invariant");
	    	comp=comp.DL$;
	    }
	    if(comp.STATE$==OperationalState.resumed) comp.STATE$=OperationalState.detached;
	    // Rotate the contents of 'ins.dl', 'comp.dl' and 'CUR$'.
	    // Invariant:   comp.DL$ = mainSL
	    //  <ins.DL$,comp.DL$,CUR$>=<comp.DL$,CUR$,ins.DL$>
	    comp.DL$=CUR$; CUR$=ins.DL$; ins.DL$=mainSL;
	    ins.STATE$=OperationalState.resumed;
		updateContextVector(); // TODO: ???
		if(QPS_TRACING) TRACE("END RESUME "+ins.edString());
	    swapThreads(comp.DL$);
	  }
	}

	
  /**
   * This method is virtual and may be redefined in blocks.
   * This default version is suitable for classes.
   * @return
   */
    public RTObject$ STM() { return(CODE$.EXEC$()); }


//    // Runnable Body
    public RTObject$ START() { START(this); return(this); }
    public void run() { STM(); }
	public void START(RTObject$ ins)
	{ // Start Object in a new Thread
//	  this.THREAD$=Thread.currentThread(); 
//	  Util.ASSERT(Thread.currentThread()==this.THREAD$,"Invariant");
      THREAD$=new Thread(ins,ins.getClass().getSimpleName());
      if(THREAD_TRACING) TRACE("Start "+THREAD$);
      THREAD$.start();
      if(THREAD_TRACING) TRACE("Suspend "+Thread.currentThread());
      Thread.currentThread().suspend();
	}
		
	protected void swapThreads(RTObject$ prev)
	{ Util.ASSERT(Thread.currentThread()==prev.THREAD$,"Invariant");
//      TRACE("Resume "+CUR$.THREAD$);
	  if(THREAD_TRACING) TRACE("swapThreads:Resume "+CUR$.edString());
	  CUR$.THREAD$.resume();
//      TRACE("Suspend "+prev.THREAD$);
	  if(THREAD_TRACING) TRACE("swapThreads:Suspend "+prev.edString());
	  prev.THREAD$.suspend();
	}

	
	// *********************************************************************
	// *** TRACING AND DEBUGGING UTILITIES
	// *********************************************************************
	
	public void TRACE(String msg)
	{ Thread THREAD$=Thread.currentThread(); 
	  System.out.println(THREAD$.toString()+": "+msg);
	}
	
	
	public String edString()
	{ StringBuilder s=new StringBuilder();
	  s.append(this.getClass().getSimpleName());
	  s.append(" BlockLevel=").append(BL$);
	  s.append(" SL=").append((SL$==null)?"null":SL$.getClass().getSimpleName());
	  s.append(" DL=").append((DL$==null)?"null":DL$.getClass().getSimpleName());
	  s.append(" STATE=").append(STATE$);
	  s.append(" THREAD=").append(THREAD$);
	  return(s.toString());
	}
	
	public static void printContextVector()
	{ System.out.println("CURRENT CONTEXT VECTOR - CURRENT = "+((CUR$==null)?"null":CUR$.edString()));		  
	  for(int j=0;j<50;j++) if(CV$[j]!=null) System.out.println("  - CV$["+j+"]="+CV$[j].edString());
	  System.out.println("-------------------");
	}
	
	public void printThreadList()
	{ Thread[] t=new Thread[50];
	  int i=Thread.enumerate(t);
	  System.out.println("ACTIVE THREAD LIST:");
      for(int j=0;j<i;j++) System.out.println("  - "+t[j]);
	  System.out.println("-------------------");
	}

}
