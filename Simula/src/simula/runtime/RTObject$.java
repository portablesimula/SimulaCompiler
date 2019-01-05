/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.Iterator;

/**
* 
* @author Øystein Myhre Andersen
*/
@SuppressWarnings("unchecked")
public abstract class RTObject$  implements Runnable {
//	protected static boolean CODE_STEP_TRACING=false;//true;
//	protected static boolean BLOCK_TRACING=false;//true;
//	protected static boolean GOTO_TRACING=false;//true;
//	protected static boolean THREAD_TRACING=false;//true;
//	protected static boolean THREADSWAP_TRACING=false;//true;
//	protected static final boolean QPS_TRACING=false; //true;
//	protected static final boolean SML_TRACING=false; //true;
//
//	protected static final boolean USE_DEPRECATED_QPS_METHODS=false; //true;
//
//	public static void warning(String msg) { System.err.println("Warning: "+msg); }
	
	// BASICIO
	static final int INPUT_LINELENGTH_ = 80;
	static final int OUTPUT_LINELENGTH_ = 132;
    static InFile$ SYSIN$;
	public InFile$ sysin() { return (SYSIN$); }

	public static PrintFile$ SYSOUT$;
	public PrintFile$ sysout() { return (SYSOUT$); }

	// QPS
	public enum OperationalState { detached,resumed,attached,terminated,terminatingProcess }
	public OperationalState STATE$;
	public Thread THREAD$;
	protected ClassBody CODE$;
	
	// RTS
	public static BASICIO$ CTX$=new BASICIO$(null);
	public static RTObject$ PRG$; // Current Program
	public static RTObject$ CUR$=CTX$; // Current Block Instance
	public int JTX$; // Jump Table Index used by STM$()

	public boolean isQPSystemBlock() { return(false); } // Needs Redefinition
	public boolean isDetachable() { return(false); } // Needs Redefinition
//    public int[] getLINEMAP$() { return(null); } // Needs Redefinition


	/**
	 * This is a pointer to the object of the nearest textually enclosing block
	 * instance, also called 'static link'.
	 */
	public RTObject$ SL$; // Static Link

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

    private static int objSEQU=0; // Used by TRACE-methods
    private int SEQU;             // Used by TRACE-methods
	// ************************************************************
	// *** Constructor
	// ************************************************************
	/**
	 * Constructor
	 * @param SL Static Link, may be null when creating CONTEXT, TEXTOBJ and TXTREF
	 */
	public RTObject$(RTObject$ SL)
	{ if(SL!=null)
	  { this.BL$=SL.BL$+1; this.SL$=SL;
		this.THREAD$=Thread.currentThread();
	    this.SEQU=objSEQU++;      // Used by TRACE-methods
	  }
	}

	
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
    public Object RESULT$() { return(null); }
    
	// *******************************************************
	// *** FRAMEWORK for Procedure-Parameters in Java Coding
	// *******************************************************
	public final class PRCQNT$
	{ RTObject$ staticLink;
	  Class<?> procedure;
		  
	  // Constructor
	  public PRCQNT$(RTObject$ staticLink,Class<?> procedure)
	  { this.staticLink=staticLink; this.procedure=procedure; }
			  
	  public RTObject$ CPF()
	  { //RT.BREAK("CPF: procedure="+procedure+", Qual="+procedure.getClass().getSimpleName());
	    try
		{ Constructor<?> constr = procedure.getConstructor(new Class[]{RTObject$.class});
		  //RT.BREAK("CPF2: constr="+constr+", Qual="+procedure.getClass().getSimpleName());
		  Object obj=constr.newInstance(staticLink);
		  //RT.BREAK("CPF3: obj="+obj+", Qual="+obj.getClass().getSimpleName());
		  return((RTObject$)obj);  
		}
		catch(Throwable e)
		{ //Util.listConstructors(procedure);
		  //Util.listMethods(procedure);	
		  throw new RuntimeException("FATAL error - Impossible situation",e);
		}  
	  }
		  
	  public String toString()
	  { return("Simula PRCQNT$("+staticLink+','+procedure+')'); }
		  
	}
	
	public RTObject$ ENT$()  // Enter Formal Procedure
	{ //RT.BREAK("RTObject.ENT: CUR="+CUR$);
	  BBLK();
	  //RT.BREAK("RTObject.ENT: CUR="+CUR$);
	  STM$();
	  return(this);
	}

	
	// ****************************************************
	// *** The Abstract Generic Class NAME$<T> supporting
	// *** Name-Parameters in Java Coding.
	// ****************************************************
	public abstract class NAME$<T> {
		public RTObject$ CUR$; // Thunk Environment
		public NAME$() { CUR$=RTObject$.CUR$; }
		public abstract T get();
		public T put(T x) { throw new RuntimeException("Illegal assignment. Name parameter is not a variable"); }
	}


	// ************************************************************
	// *** ARRAY BOUND CHECKING
	// ************************************************************
	public void BOUND_CHECK$(int lb,int ub) {
		if(lb>ub) throw new RuntimeException("ARRAY("+lb+':'+ub+") - BOUND-CHECK FAILED");
	}

	// ************************************************************
	// *** ARRAY OBJECTS
	// ************************************************************
	static final String arrayError="Illegal use of array";
	public int[] IX$(int...ix) { return(ix); }

	public final class ARRAY$<T>
	{ public T Elt;
	  public int[] LB;
	  public int[] UB;
	  public ARRAY$(T Elt,int[] LB,int[] UB)
	  { this.Elt=Elt; this.LB=LB; this.UB=UB; }
	  public ARRAY$<T> COPY()
	  {	T CPY=copyMultiArray(Elt);
	    //RT.BREAK("ARRAY.COPY: Elt="+Elt.getClass().getName()+" at "+Elt);
	    //RT.BREAK("ARRAY.COPY: CPY="+CPY.getClass().getName()+" at "+CPY);
		ARRAY$<T> to=new ARRAY$<T>(CPY,LB,UB);  // TODO: DETTE MÅ SJEKKES
	    //RT.BREAK("ARRAY.COPY: to="+to.getClass().getSimpleName()+" == "+to);
		return(to);
	  }
	  public int nDim() { return(LB.length); }
	  public int size()
	  { int s=1;
		int nDim=LB.length;
		for(int i=0;i<nDim;i++)
		{ int length=UB[i]-LB[i]+1;
		  s=s*length;
		}
		return(s);
	  }
	  public String toString()
	  { int nDim=LB.length;
		StringBuilder s=new StringBuilder();
		if(nDim==1)
		{ s.append("ARRAY$(").append(LB[0]).append(':').append(UB[0]).append("), ");
		  int length=UB[0]-LB[0]+1;
		  s.append("LENGTH=").append(length);
		}
		return(s.toString());
	  }
	}

	// *******************************************************************************
	// *** Utility: Multidimensional Array Copy
	// Taken from: https://coderanch.com/t/378421/java/Multidimensional-array-copy
	// *******************************************************************************
	public static <T> T copyMultiArray(T arr) {
	    return (T) copyMultiArrayObject(arr);
	}
	private static Object copyMultiArrayObject(Object arr) {
	    Class<?> clazz = arr.getClass();
	    if (!clazz.isArray())
	        throw new IllegalArgumentException("not an array: " + arr);
	    Class<?> componentType = clazz.getComponentType();
	    int length = Array.getLength(arr);
	    Object copy = Array.newInstance(componentType, length);
	    if (componentType.isArray())
	        for (int i = 0; i < length; i++)
	            Array.set(copy, i, copyMultiArrayObject(Array.get(arr, i)));
	    else System.arraycopy(arr, 0, copy, 0, length);
	    return copy;
	}
	
	
	public ARRAY$<?> arrayValue(Object par)
	{ //RT.BREAK("RTObject.arrayValue: par="+par);
	  //RT.BREAK("RTObject.arrayValue: par'Qual="+par.getClass().getSimpleName());
	  if(par instanceof NAME$<?>) return(((NAME$<ARRAY$<?>>)par).get());
	  return((ARRAY$<?>)par);
	}
	
	public PRCQNT$ procValue(Object par)
	{ //RT.BREAK("RTObject.arrayValue: par="+par);
	  //RT.BREAK("RTObject.arrayValue: par'Qual="+par.getClass().getSimpleName());
	  if(par instanceof NAME$<?>) return(((NAME$<PRCQNT$>)par).get());
	  return((PRCQNT$)par);
	}
	
//	public TXT$ TXT$Value(Object par)
//	{ RT.BREAK("RTObject.TXT$Value: par="+par);
//	  RT.BREAK("RTObject.TXT$Value: par'Qual="+par.getClass().getSimpleName());
//	  RT.BREAK("RTObject.TXT$Value: par'super'Qual="+par.getClass().getSuperclass().getSimpleName());
//	  if(par instanceof NAME$<?>) par=((NAME$<TXT$>)par).get();
//	  if(par instanceof PRCQNT$) par=((PRCQNT$)par).CPF().RESULT$();
//	  return((TXT$)par);
//	}
	
	public Object objectValue(Object par)
	{ //RT.BREAK("RTObject.objectValue: par="+par);
	  //RT.BREAK("RTObject.objectValue: par'Qual="+par.getClass().getSimpleName());
	  if(par instanceof NAME$<?>) par=((NAME$<?>)par).get();
	  if(par instanceof PRCQNT$) par=((PRCQNT$)par).CPF().RESULT$();
	  return(par);
	}
	
	public int intValue(Object par)
	{ //RT.BREAK("RTObject.intValue: par="+par);
	  //RT.BREAK("RTObject.intValue: par'Qual="+par.getClass().getSimpleName());
	  //RT.BREAK("RTObject.intValue: par'super'Qual="+par.getClass().getSuperclass().getSimpleName());
	  if(par instanceof NAME$<?>) par=((NAME$<?>)par).get();
	  if(par instanceof PRCQNT$) par=((PRCQNT$)par).CPF().RESULT$();
	  if(par instanceof Float) return((int)par);
	  if(par instanceof Double) return((int)(double)par);
	  if(par instanceof Integer) return((int)par);
	  throw new ClassCastException("Incompatible Types: int,"+par.getClass().getSimpleName());
	}
	
	public float floatValue(Object par)
	{ if(par instanceof NAME$<?>) par=((NAME$<?>)par).get();
	  if(par instanceof PRCQNT$) par=((PRCQNT$)par).CPF().RESULT$();
	  if(par instanceof Float) return((float)par);
	  if(par instanceof Double) return((float)(double)par);
	  if(par instanceof Integer) return((float)(int)par);
	  throw new ClassCastException("Incompatible Types: float,"+par.getClass().getSimpleName());
	}
	
	public double doubleValue(Object par)
	{ if(par instanceof NAME$<?>) par=((NAME$<?>)par).get();
	  if(par instanceof PRCQNT$) par=((PRCQNT$)par).CPF().RESULT$();
	  if(par instanceof Float) return((double)(float) par);
	  if(par instanceof Double) return((double)(double)par);
	  if(par instanceof Integer) return((double)(int)par);
	  throw new ClassCastException("Incompatible Types: double,"+par.getClass().getSimpleName());
	}

    
	// *******************************************************
	// *** FRAMEWORK for for-list iteration 
	// *******************************************************
	
	public final class ForList implements Iterable<Boolean>
	{ ForListIterator forListIterator;
	  public ForList(ForElt... forElt)
	  {	forListIterator=new ForListIterator(forElt);  }
	  public Iterator<Boolean> iterator() { return(forListIterator); }
	}

	public final class ForListIterator implements Iterator<Boolean>
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
	
	public final class SingleElt<T> extends ForElt
	{ NAME$<T> cvar,nextValue; //boolean more;
	  public SingleElt(NAME$<T> cvar,NAME$<T> init)
	  { this.cvar=cvar; this.nextValue=init; more=true; }
	  public boolean hasNext() {return(nextValue!=null); }
	  public Boolean next()
	  { if(nextValue==null) return(false);
	    T val=nextValue.get();
	    cvar.put(val); nextValue=null;
	    //RT.BREAK("SingleElt.next: return="+val);
	    return(true);
	  }
	}
	
	public final class SingleTValElt extends ForElt
	{ // For t:= <TextExpr>  // Text Value Assignment
	  NAME$<TXT$> cvar,nextValue; //boolean more;
	  public SingleTValElt(NAME$<TXT$> cvar,NAME$<TXT$> init)
	  { this.cvar=cvar; this.nextValue=init; more=true; }
	  public boolean hasNext() {return(nextValue!=null); }
	  public Boolean next()
	  { if(nextValue==null) return(false);
	    TXT$ val=nextValue.get();
	    ASGTXT$(cvar.get(),val);
	    nextValue=null;
	    //RT.BREAK("SingleElt.next: return="+val);
	    return(true);
	  }
	}
	
	public final class StepUntil extends ForElt
	{ NAME$<Number> cvar,init,step,until;
	  Number nextValue;
	  public StepUntil(NAME$<Number> cvar,NAME$<Number> init,NAME$<Number> step,NAME$<Number> until)
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
	    //RT.BREAK("StepUntil.next: return="+val+", nextValue="+nextValue+", more="+more);
	    cvar.put(nextValue);
		return(more);
	  }
	}
	
	public final class WhileElt<T> extends ForElt
	{ NAME$<T> cvar,expr; NAME$<Boolean> cond;
	  public WhileElt(NAME$<T> cvar,NAME$<T> expr,NAME$<Boolean> cond)
	  { this.cvar=cvar; this.expr=expr; this.cond=cond; }
	  public Boolean next()
	  { T val=expr.get();
	    cvar.put(val);
	    more=cond.get();    // IF not more return null - test i loopen: if(CB$==null) continue;
	    //RT.BREAK("WhileElt.next: return="+val);
		return(more);
	  }
	}
	
	public final class WhileTValElt extends ForElt
	{ // For t:= <TextExpr> while <Cond>  // Text Value Assignment
	  NAME$<TXT$> cvar,expr; NAME$<Boolean> cond;
	  public WhileTValElt(NAME$<TXT$> cvar,NAME$<TXT$> expr,NAME$<Boolean> cond)
	  { this.cvar=cvar; this.expr=expr; this.cond=cond; }
	  public Boolean next()
	  { TXT$ val=expr.get();
//	    cvar.put(val);
	    ASGTXT$(cvar.get(),val);
	    more=cond.get();    // IF not more return null - test i loopen: if(CB$==null) continue;
	    //RT.BREAK("WhileElt.next: return="+val);
		return(more);
	  }
	}
	
	

	// *****************************************
	// *** Text utilities ***
	// *****************************************
    public final static TXT$ NOTEXT=new TXT$();

	/**
	 * <pre>
	 * text procedure copy(T); text T;
	 *            if T =/= notext
	 *            then begin text U;
	 *               U.OBJ    :- new TEXTOBJ(T.LENGTH,false);
	 *               U.START  := 1;
	 *               U.LENGTH := T.LENGTH;
	 *               U.POS    := 1;
	 *               U        := T;
	 *               copy     :- U
	 *            end copy;
	 * </pre>
	 * 
	 * "copy(T)", with T =/= notext, references a new alterable main frame which
	 * contains a text value identical to that of T.
	 * 
	 * @param U
	 * @return
	 */
	public TXT$ copy(TXT$ T) {
		if (T == null) return (null);
		TXT$ U = blanks(T.LENGTH);
		ASGTXT$(U,T);
		return (U);
	}
	
	/**
	 * The operator & permits text concatenation. 
	 * @param T1
	 * @param T2
	 * @return
	 */
    public TXT$ CONC (TXT$ T1,TXT$ T2) {
       if(T1==null) T1=NOTEXT;
       if(T2==null) T2=NOTEXT;
       TXT$ U=blanks(T1.length()+T2.length());
       ASGTXT$(U.sub(1,T1.length()),T1);
       ASGTXT$(U.sub(1+T1.length(),T2.length()),T2);
       return(U);
    }


	/**
	 * <pre>
	 * text procedure blanks(n); integer n;
	 *            if        n < 0 then error("..." ! Parm. to blanks < 0;)
	 *            else if   n > 0
	 *            then begin text T;
	 *               T.OBJ    :- new TEXTOBJ(n,false);
	 *               T.START  := 1;
	 *               T.LENGTH := n;
	 *               T.POS    := 1;
	 *               T        := notext;    ! blank-fill, see 4.1.2;
	 *               blanks   :- T
	 *            end blanks;
	 * </pre>
	 * 
	 * "blanks(n)", with n > 0, references a new alterable main frame of length
	 * n, containing only blank characters. "blanks(0)" references notext.
	 * 
	 * @param n
	 * @return
	 */
	public TXT$ blanks(int n) {
		if (n < 0)
			throw new RuntimeException("Parmameter to blanks < 0");
		if (n == 0)
			return (NOTEXT);
		TXT$ textRef = new TXT$();
		TEXTOBJ textObj = new TEXTOBJ(n, false);
		textObj.fill(' ');
		textRef.START = 0; // Note: Counting from zero in this implementation
		textRef.LENGTH = n;
		textRef.POS = 0; // Note: Counting from zero in this implementation
		textRef.OBJ = textObj;
		return (textRef);
	}

	public TXT$ ASGTXT$(TXT$ T,TXT$ U) {
	    if(T==null) T=NOTEXT;
	    if(U==null) U=NOTEXT;
		int fromLength = U.LENGTH;
		if(fromLength > T.LENGTH) throw(new RuntimeException("RHS too long in text value assignment"));
		for (int i = 0; i < fromLength; i++)
			T.OBJ.MAIN[T.START+i] = U.OBJ.MAIN[U.START+i];
		for (int i = fromLength; i < T.LENGTH; i++)
			T.OBJ.MAIN[T.START+i] = ' ';
		return(T);
	}

	public TXT$ ASGSTR$(TXT$ T,String s) {
	    if(T==null) T=NOTEXT;
		int fromLength = 0;
		if (s != null) fromLength = s.length();
		if(fromLength > T.LENGTH) throw(new RuntimeException("RHS too long in text value assignment"));
		for (int i = 0; i < fromLength; i++)
			T.OBJ.MAIN[T.START+i] = s.charAt(i);
		for (int i = fromLength; i < T.LENGTH; i++)
			T.OBJ.MAIN[T.START+i] = ' ';
		return(T);
	}
	
	//**************************************************************
	//*** TXTREL - Text value relations
	//**************************************************************
	public boolean TXTREL$LT(TXT$ left,TXT$ right) { return(TXTREL(left,right,1)); }
	public boolean TXTREL$EQ(TXT$ left,TXT$ right) { return(TXTREL(left,right,2)); }
	public boolean TXTREL$LE(TXT$ left,TXT$ right) { return(TXTREL(left,right,3)); }
	public boolean TXTREL$GT(TXT$ left,TXT$ right) { return(TXTREL(left,right,4)); }
	public boolean TXTREL$NE(TXT$ left,TXT$ right) { return(TXTREL(left,right,5)); }
	public boolean TXTREL$GE(TXT$ left,TXT$ right) { return(TXTREL(left,right,6)); }
	private boolean TXTREL(TXT$ left,TXT$ right,int code)
	{ int i;      // Loop index.
	  int dif;    // Difference between lengths.
	  int lng;    // Length of common parts.
	  if(left==null) left=NOTEXT;
	  if(right==null) right=NOTEXT;
	  //RT.BREAK("ENVIRONMENT.TXTREL("+code+") Left= \""+left.edText()+'"');
	  //RT.BREAK("ENVIRONMENT.TXTREL("+code+") Right=\""+right.edText()+'"');
	  lng=right.LENGTH; dif=lng-left.LENGTH;
	  //RT.BREAK("ENVIRONMENT.TXTREL("+code+") dif="+dif);
	  if(dif!=0)
	  { if(code==2) return(false);
	    if(code==5) return(true);
	    if(dif>0) lng=left.LENGTH;
	  }
	  i=0;
	  while(i<lng)
	  {	int rightChar=right.OBJ.MAIN[right.START+i];     
	    int leftChar=left.OBJ.MAIN[left.START+i];  
	    if(rightChar!=leftChar)
	    {
	  	  //RT.BREAK("ENVIRONMENT.TXTREL("+code+") pos="+i);
	  	  //RT.BREAK("ENVIRONMENT.TXTREL("+code+") leftChar="+(char)leftChar+", code="+leftChar);
	  	  //RT.BREAK("ENVIRONMENT.TXTREL("+code+") rightChar="+(char)rightChar+", code="+rightChar);
	      dif=rightChar-leftChar; break;
	    }
	    i=i + 1;
	  };
	  //RT.BREAK("ENVIRONMENT.TXTREL("+code+") dif="+dif);
	  switch(code)
	  { case 1: return(0 <  dif);
	    case 2: return(0 == dif);
	    case 3: return(0 <= dif);
	    case 4: return(0 >  dif);
	    case 5: return(0 != dif);
	    case 6: return(0 >= dif);
	    default: throw new RuntimeException("Internal Error");
	  }
	}

	//**************************************************************
	//*** TXTREL - Text reference relations. ==  =/=
	//**************************************************************
	public boolean TRF_EQ(TXT$ left,TXT$ right)
	{ //RT.BREAK("TRF_EQ: left="+left);
	  //RT.BREAK("TRF_EQ: right="+right);
	  if(left==null) left=NOTEXT;
	  if(right==null) right=NOTEXT;
	  if(left.LENGTH!=right.LENGTH) return(false);
	  if(left.START!=right.START) return(false);
	  if(left.OBJ!=right.OBJ) return(false);
	  return(true);
	}
	public boolean TRF_NE(TXT$ left,TXT$ right)
	{ return(!TRF_EQ(left,right)); }

	// ************************************************************
	// *** lOCAL JUMP/LABEL  - Meant for Byte-Code Engineering
	// ************************************************************
	public static void LABEL$(int labelIndex) {}  // Local LABEL - Needs ByteCode Engineering.
	public static void JUMPTABLE$(int labelIndex) // Local GOTO  - Needs ByteCode Engineering.
	{ if(labelIndex==0) return;
	  String msg="Local GOTO LABEL#"+labelIndex+" Needs ByteCode Engineering.";
	  RT.println("NOTE: "+msg);
	  throw new RuntimeException(msg);
	}

	
	
	// ************************************************************
	// *** FRAMEWORK for NonLocal Label-Parameters in Java Coding
	// ************************************************************
	public final class LABQNT$ extends RuntimeException
	{ static final long serialVersionUID = 42L;
	  public RTObject$ SL$; // Static link, i.e. the block in which the label is defined.
	  public int prefixLevel; // PrefixLevel for classes, zero otherwise.
	  public int index; // I.e. ordinal number of the Label within its Scope(staticLink).
	  
	  // Constructors
	  public LABQNT$(RTObject$ SL$,int prefixLevel,int index)
	  { this.SL$=SL$; this.prefixLevel=prefixLevel; this.index=index;
	    //RT.ASSERT(this.index>0,"Invariant");
	    //RT.BREAK("NEW LABQNT: SL="+SL$+", index="+index);
	  }
	  
	  public String toString()
	  { return("LABQNT$("+SL$+",prefixLevel="+prefixLevel+", LABEL#"+index+')'); }
	  
	}

	// ************************************************************
	// *** GOTO$ -- To avoid Java-error: "Unreachable code" after GOTO
	// ************************************************************
    public void GOTO$(LABQNT$ q)
    { if(RT.Option.GOTO_TRACING) RT.TRACE("RTObject$.GOTO: "+q);
      throw(q);
    }

	// ************************************************************
	// *** TRACING:  TRACE_GOTO
	// ************************************************************
    public static void TRACE_GOTO(String msg,LABQNT$ q)
    { String s=msg+" GOTO "+q;
      RT.TRACE(s);
      //RT.BREAK("END RTObject$.TRACE_GOTO");
    }


	// ************************************************************
	// *** UncaughtExceptionHandler
	// ************************************************************
	class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
		public RTObject$ obj;
	
	    public UncaughtExceptionHandler(RTObject$ obj)  {
	    	this.obj=obj;
	    }
	  
        public void uncaughtException(Thread thread, Throwable e) {
        	String who="Thread:"+thread.getName()+'['+obj+']';
        	if(RT.Option.GOTO_TRACING) RT.println(who + " throws exception: " + e);
            if(RT.Option.GOTO_TRACING) e.printStackTrace(); 
            if(e instanceof LABQNT$) {
            	if(RT.Option.GOTO_TRACING) System.err.println("POSSIBLE GOTO OUT OF COMPONENT "+obj.edObjectAttributes());
            	if(RT.Option.GOTO_TRACING) RT.println("POSSIBLE GOTO OUT OF COMPONENT "+obj.edObjectAttributes());
            	RTObject$ DL=obj.DL$;
            	if(DL!=null && DL!=CTX$)
            	{ if(RT.Option.GOTO_TRACING) System.err.println("DL="+DL.edObjectAttributes());
            	  if(RT.Option.GOTO_TRACING) RT.println("DL="+DL.edObjectAttributes());
//            	  DL.PENDING_EXCEPTION$=(RuntimeException)e;
            	  PENDING_EXCEPTION$=(RuntimeException)e;
//            	  DL.resumeThread();
            	  resumeThread(DL.THREAD$);
            	} else {
            		RT.println(who+": SIMULA RUNTIME ERROR: Illegal GOTO "+e); e.printStackTrace();
            	    shutDown(-1);
            	}
            }
            else if(e instanceof TerminateException) {}
            else if(e instanceof RuntimeException)
            { String msg=e.getMessage();
              if(e instanceof NullPointerException) msg="NONE-CHECK Failed";
              else if(e instanceof ArrayIndexOutOfBoundsException) msg="ArrayIndexOutOfBounds";
              else {
            	  msg=e.getClass().getSimpleName()+" "+msg;
              }
              if(SHUTING_DOWN$) {
            	  if(RT.Option.VERBOSE) {
                	  msg=msg+" -- DURING SHUTDOWN";
                	  RT.println(who+": SIMULA RUNTIME ERROR: "+msg);
                	  //ENVIRONMENT$.printStackTrace(2);
                	  ENVIRONMENT$.printStackTrace(e,0);
                	  //e.printStackTrace();
                	  shutDown(-1);             		  
            	  }
              } else {
            	  RT.println(who+": SIMULA RUNTIME ERROR: "+msg);
            	  //ENVIRONMENT$.printStackTrace(2);
            	  ENVIRONMENT$.printStackTrace(e,0);
            	  e.printStackTrace();
            	  shutDown(-1);  
              }
            }
            else { RT.println(who+": UNCAUGHT EXCEPTION: "+e.getMessage()); e.printStackTrace(); shutDown(-1); }
            if(RT.Option.GOTO_TRACING) ENVIRONMENT$.printThreadList(); 
        }
	}
    
	// ************************************************************
	// *** TerminateException
	// ************************************************************
	class TerminateException extends RuntimeException
	{ static final long serialVersionUID=1234;
	  public TerminateException(String msg) { super(msg); }
	}
	
	// ************************************************************
	// *** Procedure terminate_program;
	// *** begin ... ;  goto STOP  end terminate_program;
	// ************************************************************
	public void terminate_program() {
		System.exit(0);
	}
    
	// ************************************************************
	// *** BPRG  --  Begin Program
	// ************************************************************
	/**
	 * The begin program routine (BPRG) is the runtime system initialization
	 * routine. It will initiate the global data in the runtime system.
	 */
	public void BPRG(String ident) {
		CTX$.THREAD$=Thread.currentThread();
		CTX$.THREAD$.setUncaughtExceptionHandler(new UncaughtExceptionHandler(this));
		if(RT.Option.BLOCK_TRACING) RT.TRACE("Begin Execution of Simula Program: "+ident);
		if(SYSIN$==null)
		{ if(RT.Option.USE_CONSOLE) RT.console=new RTConsole();
		  SYSIN$ = new InFile$(this,new TXT$("SYSIN"));
		  SYSOUT$ = new PrintFile$(this,new TXT$("SYSOUT"));
		  SYSIN$.open(blanks(INPUT_LINELENGTH_));
		  SYSOUT$.open(blanks(OUTPUT_LINELENGTH_));
		}
		PRG$=this;
//		CUR$=CTX$;// TODO: Check Konsekvenser av å fjerne denne
		CUR$=this;// TODO: Check Konsekvenser av å fjerne denne
		//BBLK();   // TODO: Check Konsekvenser av å fjerne denne
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
		if(RT.Option.BLOCK_TRACING) RT.TRACE("BEGIN "+edObjectAttributes());
		RT.NoneCheck(SL$); // In case of Remote Call on Procedure  x.Func, x==none
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
	    if(RT.Option.BLOCK_TRACING) RT.TRACE("END BLOCK(1) "+edObjectAttributes());
	    
	    if(this.STATE$==OperationalState.terminatingProcess) {
	    	//RT.TRACE("TERMINATING PROCESS "+edObjectAttributes());
	        this.STATE$=OperationalState.terminated;
	        this.THREAD$=null; // Leave it to the GarbageCollector
	    	return;            // Let this Thread R.I.P.
	    }
	    if(CUR$!=this) {
//	        RT.println("RTObject.EBLK: CUR$="+CUR$.edObjectIdent());
//	        RT.println("RTObject.EBLK: this="+this.edObjectIdent());
	        RT.println("RTObject.EBLK: CUR$="+CUR$.edObjectAttributes());
	        RT.println("RTObject.EBLK: this="+this.edObjectAttributes());
	    }
	    RT.ASSERT(CUR$==this,"invariant");
	    
	    if(CUR$.STATE$==OperationalState.attached) {
	    	CUR$.STATE$=OperationalState.terminated;
	        //  Make the dynamic enclosure the new current instance.
	        CUR$=CUR$.DL$;
		    if(RT.Option.BLOCK_TRACING) RT.TRACE("END ATTACHED BLOCK "+edObjectAttributes());
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
		    if(RT.Option.BLOCK_TRACING) RT.TRACE("END COMPONENT "+edObjectAttributes());
//	    } else {
//	        //  Treat the case of a prefixed block instance.
//	        CUR$=CUR$.DL$;
//		    if(RT.Option.BLOCK_TRACING) RT.TRACE("END PREFIXED BLOCK "+edObjectAttributes());
	    }
	    if(RT.Option.BLOCK_TRACING) RT.TRACE("END BLOCK(2) "+CUR$);
	    if(CUR$==null || CUR$==CTX$) {
//	    if(CUR$==null) {
	       //SYSIN$.close();
		   //SYSOUT$.close();
	       SYSOUT$.outimage();
		   //RT.BREAK("PROGRAM PASSES THROUGH FINAL END "+edObjectAttributes());
		   if(RT.Option.BLOCK_TRACING) RT.TRACE("PROGRAM PASSES THROUGH FINAL END "+edObjectAttributes());
		   shutDown(0);
//		   System.exit(0);
	    } else {
	       if(this.THREAD$!=CUR$.THREAD$)
	       { if(RT.Option.QPS_TRACING) RT.TRACE("Resume "+CUR$.THREAD$);
	       
//	         CUR$.resumeThread();
	         resumeThread(CUR$.THREAD$);
	         
	         if(RT.Option.QPS_TRACING) RT.TRACE("Terminate "+this.THREAD$);
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
	  if(RT.Option.QPS_TRACING) RT.TRACE("BEGIN CALL "+ins.edObjectAttributes());
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
	  if(RT.Option.QPS_TRACING) RT.TRACE("END CALL "+ins.edObjectAttributes());
	  swapThreads(CUR$.THREAD$);
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
	public void resume(RTObject$ ins) { resume(ins,false); }
	public void resume(RTObject$ ins,boolean terminatingProcess)
	{ RTObject$ comp;   //  Component head.
	  RTObject$ mainSL; //  Static enclosure of main component head.
	  RTObject$ main;   //  The head of the main component and also
	                    //  the head of the quasi-parallel system.
	  if(ins==null) throw new RuntimeException("Resume(x): x is none.");
	  if(RT.Option.QPS_TRACING) RT.TRACE("BEGIN RESUME "+ins.edObjectAttributes());
	 
	  if(ins.STATE$!=OperationalState.resumed) // A no-operation?
	  { // The object to be resumed must be local to a system head.
	    main=ins.SL$;
	    if(!main.isQPSystemBlock())
	    { //printStaticChain(ins);
	      throw new RuntimeException("Resume(x): x is not local to sub-block or prefixed block.");
	    }
	    if(ins.STATE$!=OperationalState.detached) throw
	         new RuntimeException("Resume(x): x is not in detached state but "+ins.STATE$);
	    // Find the operating component of the quasi-parallel system.
	    comp=CUR$; mainSL=main.SL$;
	    while(comp.DL$!=mainSL)
	    { RT.ASSERT(comp.DL$!=comp,"Invariant");
	    	comp=comp.DL$;
	    }
	    if(comp.STATE$==OperationalState.resumed) comp.STATE$=OperationalState.detached;
	    // Rotate the contents of 'ins.dl', 'comp.dl' and 'CUR$'.
	    // Invariant:   comp.DL$ = mainSL
	    //  <ins.DL$,comp.DL$,CUR$>=<comp.DL$,CUR$,ins.DL$>
	    comp.DL$=CUR$; CUR$=ins.DL$; ins.DL$=mainSL;
	    ins.STATE$=OperationalState.resumed;
		if(RT.Option.QPS_TRACING) RT.TRACE("END RESUME "+ins.edObjectAttributes());
//	    if(terminatingProcess) CUR$.resumeThread();
	    if(terminatingProcess) resumeThread(CUR$.THREAD$);
	    else swapThreads(CUR$.THREAD$);
	  }
	}

	
  /**
   * This method is virtual and may be redefined in blocks.
   * This default version is suitable for classes.
   * @return
   */
    public RTObject$ STM$()
    { RT.BREAK("RTObject.STM$: CUR="+CUR$);
      RT.BREAK("RTObject.STM$: CODE$="+CODE$);
      RT.ASSERT(CODE$!=null,"Invariant");
      return(CODE$.EXEC$());
    }


//    // Runnable Body
    public RTObject$ START() { START(this); return(this); }
    public void run()
    { STM$();
      //RT.TRACE("Object TERMINATES: "+this.edObjectAttributes());
      //RT.printThreadList();
    }
    
	public void START(RTObject$ ins)
    { if(RT.Option.THREAD_TRACING) RT.TRACE("START: ins="+ins.edObjectAttributes());
      //if(RT.Option.THREAD_TRACING) RT.TRACE("START: CUR$="+CUR$.edObjectAttributes());
      RTObject$ CALLER=CUR$.DL$;
      if(RT.Option.THREAD_TRACING) RT.TRACE("START: CALLER="+CALLER.edObjectAttributes());
	  RT.ASSERT(CUR$.THREAD$==Thread.currentThread(),"Invariant");
	  // Start Object in a new Thread
      ins.THREAD$=new Thread(ins,ins.edObjectIdent());
	  ins.THREAD$.setUncaughtExceptionHandler(new UncaughtExceptionHandler(ins));
      if(RT.Option.THREAD_TRACING) RT.TRACE("Start "+ins.THREAD$);
      ins.THREAD$.start();
      if(RT.Option.THREAD_TRACING) RT.TRACE("START:Suspend "+Thread.currentThread());
//	  RT.println("START: THIS="+this.edObjectAttributes());
//	  RT.println("START: CUR$="+CUR$.edObjectAttributes());
//	  RT.println("START: CUR$.DL$="+CUR$.DL$.edObjectAttributes());
//	  RT.println("START: CUR$.DL$.THREAD$="+CUR$.DL$.THREAD$);

      Thread prev=Thread.currentThread();
      Thread next=ins.THREAD$;
      suspendCurrentThread();
      
//	  RT.TRACE("END START: PREV="+prev+", Thread.STATE="+prev.getState());
//	  RT.TRACE("END START: NEXT="+next+", Thread.STATE="+next.getState());
	  RT.ASSERT(prev.getState()==Thread.State.RUNNABLE,"Invariant");
    
	  while(next.getState()==Thread.State.RUNNABLE) Thread.yield();  

	  RT.ASSERT(next.getState()!=Thread.State.RUNNABLE,"Invariant");
//    ENVIRONMENT$.checkMaxOneRunableSimulaThread();

	}

	
	
	static boolean SHUTING_DOWN$=false;
	private static RuntimeException PENDING_EXCEPTION$=null;


	private static void suspendCurrentThread() {
		Thread thread=Thread.currentThread();
		synchronized (thread) {
			try { thread.wait(); } catch (InterruptedException ex) { ex.printStackTrace(); }
		}
//		ENVIRONMENT$.checkMaxOneRunableSimulaThread(); ??
		if (RT.Option.THREADSWAP_TRACING) RT.TRACE("RTObject$.suspendThread: RESTARTING "+thread);
		if (SHUTING_DOWN$) PENDING_EXCEPTION$ = CUR$.new TerminateException("EXIT");
		if (PENDING_EXCEPTION$ != null) {
			RuntimeException t = PENDING_EXCEPTION$;
			PENDING_EXCEPTION$ = null;
			if (RT.Option.GOTO_TRACING) RT.TRACE("RTObject$.suspendThread: Re-throw " + t);
			if(t!=null) throw (t);
		}
		if (RT.Option.THREAD_TRACING)	RT.TRACE("RTObject$.suspendThread: END " + thread);
		if (RT.Option.THREAD_TRACING)	ENVIRONMENT$.printThreadList();
	}

	private static void resumeThread(final Thread thread)
	{ synchronized (thread) {
	     thread.notify();
      }
    }
	

	private static void shutDown(int exitValue) {
		if (RT.Option.THREADSWAP_TRACING)	RT.TRACE("RTObject$.shutDown:");
		//RT.BREAK("RTObject$.shutDown:");
		SHUTING_DOWN$ = true;
		Thread[] t = new Thread[50];
		int i = Thread.enumerate(t);
		for (int j = 0; j < i; j++) {
			Thread T = t[j];
			// RT.BREAK("RTObject$.shutDown: Notify "+T);
			if (T != Thread.currentThread()) {
				// RT.BREAK("RTObject$.shutDown: Notify "+T);
				synchronized (T) { T.notify(); }
				// Shutting Down Components one at a time:
			    while(T.getState()==Thread.State.RUNNABLE) Thread.yield();  
			}
		}
		if(RT.numberOfEditOverflows>0) RT.println("End program: WARNING "+RT.numberOfEditOverflows+" EditOverflows");
		if(RT.console==null) System.exit(exitValue);
	}		
	
	
    protected static void swapThreads(final Thread next)
    { // Suspend CurrentThread and Resume 'next' in one operation
    	
      Thread prev=Thread.currentThread();
//      RT.TRACE("BEGIN swapThread: PREV="+prev+", Thread.STATE="+prev.getState());
//      RT.TRACE("BEGIN swapThread: NEXT="+next+", Thread.STATE="+next.getState());
      RT.ASSERT(prev.getState()==Thread.State.RUNNABLE,"Invariant");
      RT.ASSERT(next.getState()!=Thread.State.RUNNABLE,"Invariant");

  	  // Resume 'next'	
  	  synchronized (next) { next.notify(); }
      
  	  suspendCurrentThread();
      
//      RT.TRACE("END swapThread: PREV="+prev+", Thread.STATE="+prev.getState());
//      RT.TRACE("END swapThread: NEXT="+next+", Thread.STATE="+next.getState());
      RT.ASSERT(prev.getState()==Thread.State.RUNNABLE,"Invariant");
      
      while(next.getState()==Thread.State.RUNNABLE) Thread.yield();  

      RT.ASSERT(next.getState()!=Thread.State.RUNNABLE,"Invariant");
//      ENVIRONMENT$.checkMaxOneRunableSimulaThread();
    }

	
	// *********************************************************************
	// *** TRACING AND DEBUGGING UTILITIES
	// *********************************************************************
    
    private void BCODE$(int simulaSourceLine,String msg)
    { if(!RT.Option.CODE_STEP_TRACING) return;
      StackTraceElement elt=Thread.currentThread().getStackTrace()[4];
      String line;
      if(simulaSourceLine<=1)
           line="J"+elt.getLineNumber();
      else line="S"+simulaSourceLine;
//      RT.println(elt.getFileName()+" LINE "+line+": "+msg);    	
      RT.BREAK("  STEP_TRACE  "+elt.getFileName()+" LINE "+line+": "+msg);    	
//      printStaticContextChain();
      ENVIRONMENT$.printStackTrace(2); // TESTING
    }
	
    public void TRACE_BEGIN_DCL$(String ident) { TRACE_BEGIN_DCL$(ident,-1); }
    public void TRACE_BEGIN_DCL$(String ident,int simulaSourceLine)
    { BCODE$(simulaSourceLine,"BEGIN  "+ident+".DCL");  }
	
    public void TRACE_BEGIN_STM$(String ident) { TRACE_BEGIN_STM$(ident,-1,null); }
    public void TRACE_BEGIN_STM$(String ident,int simulaSourceLine) { TRACE_BEGIN_STM$(ident,simulaSourceLine,null); }
    public void TRACE_BEGIN_STM$(String ident,ClassBody inner) { TRACE_BEGIN_STM$(ident,-1,inner); }
    public void TRACE_BEGIN_STM$(String ident,int simulaSourceLine,ClassBody inner)
    { BCODE$(simulaSourceLine,"BEGIN  "+ident+".STM$, inner="+inner);  }
    public void TRACE_BEGIN_STM_AFTER_INNER$(String ident,int simulaSourceLine)
    { BCODE$(simulaSourceLine,"BEGIN  "+ident+".STM$(After inner)");  }
	
    public void TRACE_END_STM$(String ident) { TRACE_END_STM$(ident,-1); }
    public void TRACE_END_STM$(String ident,int simulaSourceLine)
    { BCODE$(simulaSourceLine,"END  "+ident+".STM$");  }
	
	public static TXT$ objectTraceIdentifier(RTObject$ staticLink) { return(new TXT$(staticLink.edObjectIdent())); }
	public TXT$ objectTraceIdentifier() { return(new TXT$(edObjectIdent())); }
	public String edObjectIdent()
	{ StringBuilder s=new StringBuilder();
	  s.append(this.getClass().getSimpleName());
      if(SEQU>0) s.append('#').append(SEQU);
      return(s.toString());
	}
	
	public String edObjectAttributes()
	{ StringBuilder s=new StringBuilder();
	  s.append(edObjectIdent());
	  s.append(" BlockLevel=").append(BL$);
	  s.append(" SL=").append((SL$==null)?"null":SL$.edObjectIdent());
	  s.append(" DL=").append((DL$==null)?"null":DL$.edObjectIdent());
	  s.append(" STATE=").append(STATE$);
	  s.append(" THREAD=").append(THREAD$);
	  s.append(" CUR=").append(CUR$);
	  return(s.toString());
	}
	
//	public void printStaticContextChain()
//	{
//	  RTObject$ x=this;
//	  RT.println("STATIC CONTEXT CHAIN:");
//	  while(x!=null)
//	  {
//    	RT.println("  - "+x.edObjectAttributes());
//		  x=x.SL$;
//	  }
//	}
	
	public String toString()
	{
		return(edObjectIdent());
	}

}