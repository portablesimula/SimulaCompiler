/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.lang.reflect.Array;
import java.util.Iterator;

/**
 * 
 * @author Øystein Myhre Andersen
 */
@SuppressWarnings("unchecked")
public abstract class RTObject$ {


	// BASICIO
	static final int INPUT_LINELENGTH_ = 80;
	static final int OUTPUT_LINELENGTH_ = 132;
	static infile$ SYSIN$;
	public static printfile$ SYSOUT$;
	public static infile$ sysin() { return (SYSIN$); }
	public static printfile$ sysout() { return (SYSOUT$); }
	private static long startTimeMs;

	// QPS
	public enum OperationalState {
		detached, resumed, attached, terminated, terminatingProcess
	}
	public OperationalState STATE$;
	public Coroutine CORUT$;

	// RTS
	public static final BASICIO$ CTX$ = new BASICIO$(null);
	public static RTObject$ CUR$ = CTX$; // Current Block Instance
	public int JTX$; // Jump Table Index used by STM$()

	public boolean isQPSystemBlock() { return (false); } // Needs Redefinition
	public boolean isDetachUsed() {	return (false);	} // Needs Redefinition

	/**
	 * This is a pointer to the object of the nearest textually enclosing block
	 * instance, also called 'static link'.
	 */
	public RTObject$ SL$; // Static Link

	/**
	 * If this block instance is attached this is a pointer to the object of the
	 * block instance to which the instance is attached (also called dynamic link),
	 * i.e. it points to the block instance which called this one.
	 */
	RTObject$ DL$; // Dynamic Link

	// ************************************************************
	// *** Constructor
	// ************************************************************

	/**
	 * Constructor
	 * 
	 * @param SL Static Link, may be null when creating CONTEXT, TEXTOBJ and TXTREF
	 */
	public RTObject$(final RTObject$ SL) {
		if (SL != null) {
			this.SL$ = SL;
			this.CORUT$ = Coroutine.getCurrentCoroutine();
		}
	}


	// ****************************************************
	// *** The Abstract Generic Class NAME$<T> supporting
	// *** Name-Parameters in Java Coding.
	// ****************************************************
	public abstract class NAME$<T> {
		public RTObject$ CUR$; // Thunk Environment

		public NAME$() { CUR$ = RTObject$.CUR$;	}

		public abstract T get();

		public T put(final T x) {
			throw new SimulaRuntimeError("Illegal assignment. Name parameter is not a variable");
		}
	}

	// ************************************************************
	// *** ARRAY BOUND CHECKING
	// ************************************************************
	public void BOUND_CHECK$(final int lb,final int ub) {
		if (lb > ub)
			throw new SimulaRuntimeError("ARRAY(" + lb + ':' + ub + ") - BOUND-CHECK FAILED");
	}

	// ************************************************************
	// *** ARRAY OBJECTS
	// ************************************************************
	static final String arrayError = "Illegal use of array";

	public int[] IX$(final int... ix) {
		return (ix);
	}

	public final class ARRAY$<T> {
		final public T Elt;
		final public int[] LB;
		final public int[] UB;

		public ARRAY$(final T Elt,final int[] LB,final int[] UB) {
			this.Elt = Elt;
			this.LB = LB;
			this.UB = UB;
		}

		public ARRAY$<T> COPY() {
			T CPY = copyMultiArray(Elt);
			ARRAY$<T> to = new ARRAY$<T>(CPY, LB, UB);
			return (to);
		}

		public int nDim() {
			return (LB.length);
		}

		public int size() {
			int s = 1;
			int nDim = LB.length;
			for (int i = 0; i < nDim; i++) {
				int length = UB[i] - LB[i] + 1;
				s = s * length;
			}
			return (s);
		}

		public String toString() {
			int nDim = LB.length;
			StringBuilder s = new StringBuilder();
			if (nDim == 1) {
				s.append("ARRAY$(").append(LB[0]).append(':').append(UB[0]).append("), ");
				int length = UB[0] - LB[0] + 1;
				s.append("LENGTH=").append(length);
			}
			return (s.toString());
		}
	}

	// *******************************************************************************
	// *** Utility: Multidimensional Array Copy
	// Taken from: https://coderanch.com/t/378421/java/Multidimensional-array-copy
	// *******************************************************************************
	public static <T> T copyMultiArray(final T arr) {
		return (T) copyMultiArrayObject(arr);
	}

	private static Object copyMultiArrayObject(final Object arr) {
		Class<?> clazz = arr.getClass();
		if (!clazz.isArray())
			throw new IllegalArgumentException("not an array: " + arr);
		Class<?> componentType = clazz.getComponentType();
		int length = Array.getLength(arr);
		Object copy = Array.newInstance(componentType, length);
		if (componentType.isArray())
			for (int i = 0; i < length; i++)
				Array.set(copy, i, copyMultiArrayObject(Array.get(arr, i)));
		else
			System.arraycopy(arr, 0, copy, 0, length);
		return copy;
	}

	public ARRAY$<?> arrayValue(final Object par) {
		if (par instanceof NAME$<?> arr) return((ARRAY$<?>)arr.get());
		return ((ARRAY$<?>) par);
	}

	public PRCQNT$ procValue(final Object par) {
		if (par instanceof NAME$<?> proc) return((PRCQNT$)proc.get());
		return ((PRCQNT$) par);
	}

	public Object objectValue(Object par) {
		if (par instanceof NAME$<?> npar) par = npar.get();
		if (par instanceof PRCQNT$ proc)  par = proc.CPF().RESULT$();
		return (par);
	}

	public int intValue(Object par) {
		if (par instanceof NAME$<?> npar) par = npar.get();
		if (par instanceof PRCQNT$ proc)  par = proc.CPF().RESULT$();
		if (par instanceof Float   f) return (f.intValue());
		if (par instanceof Double  d) return (d.intValue());
		if (par instanceof Integer i) return (i);
		throw new ClassCastException("Incompatible Types: int," + par.getClass().getSimpleName());
	}

	public float floatValue(Object par) {
		if (par instanceof NAME$<?> npar) par = npar.get();
		if (par instanceof PRCQNT$ proc)  par = proc.CPF().RESULT$();
		if (par instanceof Float   f) return (f);
		if (par instanceof Double  d) return (d.floatValue());
		if (par instanceof Integer i) return (i.floatValue());
		throw new ClassCastException("Incompatible Types: float," + par.getClass().getSimpleName());
	}

	public double doubleValue(Object par) {
		if (par instanceof NAME$<?> npar) par = npar.get();
		if (par instanceof PRCQNT$ proc)  par = proc.CPF().RESULT$();
		if (par instanceof Float   f) return (f.doubleValue());
		if (par instanceof Double  d) return (d);
		if (par instanceof Integer i) return (i.doubleValue());
		throw new ClassCastException("Incompatible Types: double," + par.getClass().getSimpleName());
	}

	// *******************************************************
	// *** FRAMEWORK for for-list iteration
	// *******************************************************

	public final class ForList implements Iterable<Boolean> {
		ForListIterator forListIterator;

		public ForList(final ForElt... forElt) {
			forListIterator = new ForListIterator(forElt);
		}

		public Iterator<Boolean> iterator() {
			return (forListIterator);
		}
	}

	public final class ForListIterator implements Iterator<Boolean> {
		final ForElt[] forElt;
		int i;

		public ForListIterator(final ForElt... forElt) {
			this.forElt = forElt;
		}

		public boolean hasNext() {
			return (i < forElt.length && forElt[i].hasNext());
		}

		public Boolean next() {
			Boolean val = forElt[i].next();
			if (!forElt[i].hasNext()) i++;
			return (val);
		}
	}

	public abstract class ForElt implements Iterator<Boolean> {
		boolean more;
		public ForElt() { more = true; }
		public boolean hasNext() { return (more); }
	}

	public final class SingleElt<T> extends ForElt {
		final NAME$<T> cvar;
		NAME$<T> nextValue;

		public SingleElt(final NAME$<T> cvar,final NAME$<T> init) {
			this.cvar = cvar;
			this.nextValue = init;
			more = true;
		}

		public boolean hasNext() {
			return (nextValue != null);
		}

		public Boolean next() {
			if (nextValue == null) return (false);
			T val = nextValue.get();
			cvar.put(val);
			nextValue = null;
			return (true);
		}
	}

	public final class SingleTValElt extends ForElt {
		// For t:= <TextExpr> // Text Value Assignment
		final NAME$<TXT$> cvar;
		NAME$<TXT$> nextValue;

		public SingleTValElt(final NAME$<TXT$> cvar,final NAME$<TXT$> init) {
			this.cvar = cvar;
			this.nextValue = init;
			more = true;
		}

		public boolean hasNext() { return (nextValue != null); }

		public Boolean next() {
			if (nextValue == null) return (false);
			TXT$ val = nextValue.get();
			ASGTXT$(cvar.get(), val);
			nextValue = null;
			return (true);
		}
	}

	/**
	 * <pre>
	 *  A1 step A2 until A3 C := A1;
     *                      DELTA := A2;
     *                      while DELTA*(C-A3) <= 0
     *                      do begin
     *                            S;
     *                            DELTA := A2;
     *                            C := C + DELTA;
     *                      end while;
     *                      ... next for list element
	 * </pre>
	 *
	 */
	public final class StepUntil extends ForElt {
		final NAME$<Number> cvar, init, step, until;
		Number nextValue;

		public StepUntil(final NAME$<Number> cvar,final NAME$<Number> init,final NAME$<Number> step,final NAME$<Number> until) {
			this.cvar = cvar;
			this.init = init;
			this.step = step;
			this.until = until;
		}

		public Boolean next() {
			try {
			Number stp;
			int sign;
			if (nextValue == null) {
				nextValue = init.get();
				stp=0;//new Integer(0);
				sign=(int) Math.signum(step.get().longValue());
			} // First value
			else {
				stp= step.get();
				sign=(int) Math.signum(stp.longValue());
			}
			Number val = nextValue;
			Number utl = until.get();
			if (val instanceof Double || stp instanceof Double) {
				nextValue = val.doubleValue() + stp.doubleValue();
				more = ( sign * (nextValue.doubleValue() - utl.doubleValue()) <= 0);
			} else if (val instanceof Float || stp instanceof Float) {
				nextValue =val.floatValue() + stp.floatValue();
				more = ( sign * (nextValue.floatValue() - utl.floatValue()) <= 0);
			} else if (val instanceof Long || stp instanceof Long) {
				nextValue = val.longValue() + stp.longValue();
				more = ( sign * (nextValue.longValue() - utl.longValue()) <= 0);
			} else {
				nextValue = val.intValue() + stp.intValue();
				more = ( sign * (nextValue.intValue() - utl.intValue()) <= 0);
			}
			cvar.put(nextValue);
			return (more);
			} catch(Throwable e) { e.printStackTrace(); return(null); }
		}
	}
	
	public final class WhileElt<T> extends ForElt {
		final NAME$<T> cvar, expr;
		NAME$<Boolean> cond;

		public WhileElt(final NAME$<T> cvar,final NAME$<T> expr,final NAME$<Boolean> cond) {
			this.cvar = cvar;
			this.expr = expr;
			this.cond = cond;
		}

		public Boolean next() {
			T val = expr.get();
			cvar.put(val);
			more = cond.get(); // IF not more return null - test i loopen: if(CB$==null) continue;
			return (more);
		}
	}

	public final class WhileTValElt extends ForElt {
		// For t:= <TextExpr> while <Cond> // Text Value Assignment
		final NAME$<TXT$> cvar, expr;
		NAME$<Boolean> cond;

		public WhileTValElt(final NAME$<TXT$> cvar,final NAME$<TXT$> expr,final NAME$<Boolean> cond) {
			this.cvar = cvar;
			this.expr = expr;
			this.cond = cond;
		}

		public Boolean next() {
			TXT$ val = expr.get();
			ASGTXT$(cvar.get(), val);
			more = cond.get(); // IF not more return null - test i loopen: if(CB$==null) continue;
			return (more);
		}
	}

	// *****************************************
	// *** Text utilities ***
	// *****************************************
	public final static TXT$ NOTEXT = new TXT$();

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
	public static TXT$ copy(final TXT$ T) {
		if (T == null) return (null);
		TXT$ U = blanks(T.LENGTH);
		ASGTXT$(U, T);
		return (U);
	}

	/**
	 * The operator & permits text concatenation.
	 * 
	 * @param T1
	 * @param T2
	 * @return
	 */
	public TXT$ CONC(TXT$ T1, TXT$ T2) {
		if (T1 == null)	T1 = NOTEXT;
		if (T2 == null)	T2 = NOTEXT;
		TXT$ U = blanks(TXT$.length(T1) + TXT$.length(T2));
		ASGTXT$(TXT$.sub(U, 1, TXT$.length(T1)), T1);
		ASGTXT$(TXT$.sub(U, 1 + TXT$.length(T1), TXT$.length(T2)), T2);
		return (U);
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
	 * "blanks(n)", with n > 0, references a new alterable main frame of length n,
	 * containing only blank characters. "blanks(0)" references notext.
	 * 
	 * @param n
	 * @return
	 */
	public static TXT$ blanks(final int n) {
		if (n < 0) throw new SimulaRuntimeError("Parmameter to blanks < 0");
		if (n == 0)	return (NOTEXT);
		TXT$ textRef = new TXT$();
		TEXTOBJ textObj = new TEXTOBJ(n, false);
		textObj.fill(' ');
		textRef.START = 0; // Note: Counting from zero in this implementation
		textRef.LENGTH = n;
		textRef.POS = 0; // Note: Counting from zero in this implementation
		textRef.OBJ = textObj;
		return (textRef);
	}

	public static TXT$ ASGTXT$(TXT$ T, TXT$ U) {
		if (T == null) T = NOTEXT;
		if (U == null) U = NOTEXT;
		int fromLength = U.LENGTH;
		if (fromLength > T.LENGTH)
			throw (new SimulaRuntimeError("RHS too long in text value assignment: RHS.length="+T.LENGTH+", LHS.length="+fromLength));
		for (int i = 0; i < fromLength; i++)
			T.OBJ.MAIN[T.START + i] = U.OBJ.MAIN[U.START + i];
		for (int i = fromLength; i < T.LENGTH; i++)
			T.OBJ.MAIN[T.START + i] = ' ';
		return (T);
	}

	public TXT$ ASGSTR$(TXT$ T,final String s) {
		if (T == null) T = NOTEXT;
		int fromLength = 0;
		if (s != null) fromLength = s.length();
		if (fromLength > T.LENGTH)
			throw (new SimulaRuntimeError("RHS too long in text value assignment: RHS.length="+T.LENGTH+", LHS.length="+fromLength));
		for (int i = 0; i < fromLength; i++)
			T.OBJ.MAIN[T.START + i] = s.charAt(i);
		for (int i = fromLength; i < T.LENGTH; i++)
			T.OBJ.MAIN[T.START + i] = ' ';
		return (T);
	}

	// **************************************************************
	// *** TXTREL - Text value relations
	// **************************************************************
	public static boolean TXTREL$LT(final TXT$ left,final TXT$ right) {
		return (TXTREL(left, right, 1));
	}

	public boolean TXTREL$EQ(final TXT$ left,final TXT$ right) {
		return (TXTREL(left, right, 2));
	}

	public boolean TXTREL$LE(final TXT$ left,final TXT$ right) {
		return (TXTREL(left, right, 3));
	}

	public boolean TXTREL$GT(final TXT$ left,final TXT$ right) {
		return (TXTREL(left, right, 4));
	}

	public boolean TXTREL$NE(final TXT$ left,final TXT$ right) {
		return (TXTREL(left, right, 5));
	}

	public boolean TXTREL$GE(final TXT$ left,final TXT$ right) {
		return (TXTREL(left, right, 6));
	}

	private static boolean TXTREL(TXT$ left, TXT$ right, int code) {
		int i; // Loop index.
		int dif; // Difference between lengths.
		int lng; // Length of common parts.
		if (left == null) left = NOTEXT;
		if (right == null) right = NOTEXT;
		lng = right.LENGTH;
		dif = lng - left.LENGTH;
		if (dif != 0) {
			if (code == 2) return (false);
			if (code == 5) return (true);
			if (dif > 0) lng = left.LENGTH;
		}
		i = 0;
		while (i < lng) {
			int rightChar = right.OBJ.MAIN[right.START + i];
			int leftChar = left.OBJ.MAIN[left.START + i];
			if (rightChar != leftChar) {
				dif = rightChar - leftChar;
				break;
			}
			i = i + 1;
		}
		switch (code) {
		case 1:	return (0 < dif);
		case 2:	return (0 == dif);
		case 3:	return (0 <= dif);
		case 4:	return (0 > dif);
		case 5:	return (0 != dif);
		case 6:	return (0 >= dif);
		default: throw new SimulaRuntimeError("Internal Error");
		}
	}

	// **************************************************************
	// *** TXTREL - Text reference relations. == =/=
	// **************************************************************
	public boolean TRF_EQ(TXT$ left, TXT$ right) {
		if (left == null) left = NOTEXT;
		if (right == null) right = NOTEXT;
		if (left.LENGTH != right.LENGTH) return (false);
		if (left.START != right.START) return (false);
		if (left.OBJ != right.OBJ) return (false);
		return (true);
	}

	public boolean TRF_NE(final TXT$ left,final TXT$ right) {
		return (!TRF_EQ(left, right));
	}

	// **************************************************************
	// *** USED IN CONDITIONAL STATEMENT TO PREVENT DEAD-CODE REMOVAL
	// **************************************************************
	public boolean VALUE$(boolean cond) {
		return (cond);
	}

	// ************************************************************
	// *** lOCAL JUMP/LABEL - Meant for Byte-Code Engineering
	// ************************************************************
	public static void LABEL$(final int labelIndex,final String ident) {
		// Local LABEL - Needs ByteCode Engineering.
	}

	public static void JUMPTABLE$(final int labelIndex) {
		// Local GOTO - Needs ByteCode Engineering.
		if (RT.Option.GOTO_TRACING)
			RT.TRACE("RTObject$.JUMPTABLE$: labelIndex=" + labelIndex);
		String msg = "FATAL ERROR: Local GOTO LABEL#" + labelIndex + " Needs ByteCode Engineering.";
		RT.println(msg);
		RT.printSimulaStackTrace(0);
		if (labelIndex == 0) return;
		RT.println(msg);
		throw new SimulaRuntimeError(msg);
	}

	// ************************************************************
	// *** FRAMEWORK for NonLocal Label-Parameters in Java Coding
	// ************************************************************
	public final class LABQNT$ extends RuntimeException { // RuntimeError {
		static final long serialVersionUID = 42L;
		public final RTObject$ SL$; // Static link, i.e. the block in which the label is defined.
		public final int index; // I.e. ordinal number of the Label within its Scope(staticLink).
		public final String identifier; // To improve error and trace messages.

		// Constructor
		public LABQNT$(final RTObject$ SL$,final int index,final String identifier) {
			this.SL$ = SL$;
			this.index = index;
			this.identifier = identifier;
		}

		public String toString() {
			return ("LABQNT$(" + SL$ + ", LABEL#" + index + ", identifier=" + identifier + ')');
		}
	}

	// ************************************************************
	// *** GOTO$ -- To avoid Java-error: "Unreachable code" after GOTO
	// ************************************************************
	public void GOTO$(final LABQNT$ q) {
		if (RT.Option.GOTO_TRACING)	RT.TRACE("RTObject$.GOTO: " + q );
		throw (q);
	}

	// ************************************************************
	// *** TRACING: TRACE_GOTO
	// ************************************************************
	public static void TRACE_GOTO(final String msg,final LABQNT$ q) {
		RT.TRACE(msg + " GOTO " + q);
	}

	// ************************************************************
	// *** UncaughtExceptionHandler
	// ************************************************************
	public class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
		public final RTObject$ obj;

		public UncaughtExceptionHandler(final RTObject$ obj) {
			this.obj = obj;
		}

		public void uncaughtException(Thread thread, Throwable e) {
			String who = "Thread:" + thread.getName() + '[' + obj + ']';
			if (RT.Option.GOTO_TRACING)	RT.println(who + " throws exception: " + e);
			if (RT.Option.GOTO_TRACING)	e.printStackTrace();
			if (e instanceof LABQNT$) {
				if (RT.Option.GOTO_TRACING)	System.err.println("POSSIBLE GOTO OUT OF COMPONENT " + obj.edObjectAttributes());
				if (RT.Option.GOTO_TRACING)	RT.println("POSSIBLE GOTO OUT OF COMPONENT " + obj.edObjectAttributes());
				RTObject$ DL = obj.DL$;
				if (DL != null && DL != CTX$) {
					if (RT.Option.GOTO_TRACING)	System.err.println("DL=" + DL.edObjectAttributes());
					if (RT.Option.GOTO_TRACING)	RT.println("DL=" + DL.edObjectAttributes());
					Coroutine.PENDING_EXCEPTION$ = (RuntimeException) e;
					DL.CORUT$.run();
				} else {
					String msg="Illegal GOTO " + ((LABQNT$)e).identifier;
					if(ENVIRONMENT$.EXCEPTION_HANDLER!=null) treatRuntimeError(msg);
					RT.println(who + ": SIMULA RUNTIME ERROR: " + msg);
					e.printStackTrace();
					endProgram(-1);
				}
			} else if (e instanceof RuntimeException) {
				String msg=getErrorMessage(e);
				
				if(ENVIRONMENT$.EXCEPTION_HANDLER!=null) treatRuntimeError(msg);
				RT.printError(who + ": SIMULA RUNTIME ERROR: " + msg);
				RT.printSimulaStackTrace(e, 0);
				e.printStackTrace();
				endProgram(-1);
			} else if (e instanceof Error) {
				String msg = e.getClass().getSimpleName();
//				if(ENVIRONMENT$.EXCEPTION_HANDLER!=null) treatRuntimeError(msg);
				RT.printError(who + ": SIMULA RUNTIME ERROR: " + msg);
				RT.printSimulaStackTrace(e, 0);
				e.printStackTrace();
				endProgram(-1);
			} else {
				RT.printError(who + ": UNCAUGHT EXCEPTION: " + e.getMessage());
				e.printStackTrace();
				endProgram(-1);
			}
			if (RT.Option.GOTO_TRACING)	ThreadUtils.printThreadList();
		}
		
		private void treatRuntimeError(String msg) {
  	       PRCQNT$ erh=ENVIRONMENT$.EXCEPTION_HANDLER;
  	       try { //System.out.println("Runtime Error(2): EXCEPTION_HANDLER="+ENVIRONMENT$.EXCEPTION_HANDLER);
	    	     ENVIRONMENT$.EXCEPTION_HANDLER=null;
	    	     erh.CPF().setPar(new TXT$(msg)).ENT$();
		   } catch (Throwable t) {
			     RT.printError("EXCEPTION IN SIMULA EXCEPTION_HANDLER: " + t);
			     RT.printError("EXCEPTION_HANDLER: " + erh);
		    	 t.printStackTrace();
		    }			
		}
	}

	
	public static String getErrorMessage(Throwable e) {
		String msg = e.getMessage();
		if (e instanceof NullPointerException) msg = "NONE-CHECK Failed";
		else if (e instanceof ArrayIndexOutOfBoundsException) msg = "ArrayIndexOutOfBounds";
		return(e.getClass().getSimpleName() + ": " + msg);
	}

	// ************************************************************
	// *** Procedure terminate_program;
	// *** begin ... ; goto STOP end terminate_program;
	// ************************************************************
	public static void terminate_program() {
		endProgram(0);
	}

	// ************************************************************
	// *** BPRG -- Begin Program
	// ************************************************************
	/**
	 * The begin program routine (BPRG) is the runtime system initialization
	 * routine. It will initiate the global data in the runtime system.
	 */
	public void BPRG(final String ident) {
		startTimeMs = System.currentTimeMillis( );
		Thread.currentThread().setUncaughtExceptionHandler(new UncaughtExceptionHandler(this));
		RT.progamIdent=ident;
		if (RT.Option.BLOCK_TRACING) RT.TRACE("Begin Execution of Simula Program: " + ident);
		if (SYSIN$ == null) {
			if (RT.Option.USE_CONSOLE) {
				RT.console = new RTConsolePanel();
				RT.console.popup();
			}
			SYSIN$ = new infile$(this, new TXT$("SYSIN"));
			SYSOUT$ = new printfile$(this, new TXT$("SYSOUT"));
			SYSIN$.open(blanks(INPUT_LINELENGTH_));
			SYSOUT$.open(blanks(OUTPUT_LINELENGTH_));
		}
		CUR$ = this;
	}

	// ************************************************************
	// *** BBLK - Begin Block
	// ************************************************************
	/**
	 * This routine is used to initiate a block instance. Its functions are:
	 * <p>
	 * <ul>
	 * <li>Attach the block to its dynamic environment.</li>
	 * <p>
	 * <li>Update the current instance pointer(CUR$).</li>
	 * </ul>
	 */
	public void BBLK() {
		DL$ = CUR$;	CUR$ = this;
		CORUT$ = DL$.CORUT$;
		STATE$ = OperationalState.attached;
		if (RT.Option.BLOCK_TRACING) RT.TRACE("BEGIN " + edObjectAttributes());
		RT.NoneCheck(SL$); // In case of Remote Call on Procedure x.Func, x==none
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
	 * <li>Terminate class instance.
	 * <p>
	 * The object is marked 'terminated' and the 'CUR$' pointer is updated.</li>
	 * <p>
	 * If the class instance is detached: The instance is marked as terminated. The
	 * sub-block or prefixed block representing the quasiparallel system of which
	 * the instance was a component is located. The main program of the system is
	 * then 'resumed'.
	 * <p>
	 * </li>
	 * </ul>
	 * Finally; Yield continuation and return to Compiler generated code.
	 * <p>
	 * However; If the program passes through its final end sysout.outimage is
	 * called. The the entire program is terminated.
	 * <p>
	 */
	public void EBLK() {
		switch(STATE$) {
			case attached -> {
					RT.ASSERT(CUR$ == this, "RTObject$.EBLK:invariant-1");
					STATE$ = OperationalState.terminated;
					CUR$ = DL$; // Make the dynamic enclosure the new current instance.
					if (RT.Option.BLOCK_TRACING) RT.TRACE("END ATTACHED BLOCK " + edObjectAttributes());
				}
			case resumed -> {
					RT.ASSERT(CUR$ == this, "RTObject$.EBLK:invariant-2");
					// Treat the case of a resumed and operating object.
					// It is the head of an object component. The class
					// object enters the terminated state, and the object component
					// disappears from its system. The main component of that system
					// takes its place as the operating component of the system.
					// Invariant: CUR$.STATE$ = resumed and CUR$.DL = main.SL
					STATE$ = OperationalState.terminated;
					// Find main component (and system) head. It must be the static
					// enclosure since the object has been RESUMEd.
					RTObject$ main = SL$;
					// The main component becomes the operating component.
					RTObject$ dl = DL$; DL$ = null;
					CUR$ = main.DL$; main.DL$ = dl;
					if (RT.Option.BLOCK_TRACING) RT.TRACE("END COMPONENT " + edObjectAttributes());
				}
			case terminatingProcess -> {
					//RT.TRACE("TERMINATING PROCESS "+edObjectAttributes());
					STATE$ = OperationalState.terminated;
					CORUT$ = null; // Leave it to the GarbageCollector
					return; // Let this Continuation R.I.P.
				}
			default -> throw new SimulaRuntimeError("RTObject$.EBLK: Internal Error " + edObjectAttributes());
		}
		if (CUR$ == null || CUR$ == CTX$) {
			if (RT.Option.BLOCK_TRACING) RT.TRACE("PROGRAM PASSES THROUGH FINAL END " + edObjectAttributes());
			endProgram(0);
		} else {
			if (this.CORUT$ != null && this.isDetachUsed()) {
				Coroutine.detach();
			}
		}
	}

	// *********************************************************************
	// *** QUASI PARALLEL SEQUENCING
	// *********************************************************************

	// *********************************************************************
	// *** DETACH  -  See Simula Standard 7.3.1 Detach
	// *********************************************************************
	/**
	 * Consider a call of the detach attribute of a block instance X.
	 * <p>
	 * If X is an instance of a prefixed block the detach statement has no
	 * effect. Assume that X is a class object. The following cases arise:
	 * <ol>
	 * <li>X is an attached object.<br>
	 * If X is not operating the detach statement constitutes an error. Assume X
	 * is operating. The effect of the detach statement is:
	 * <ul>
	 * <li>X becomes detached and thereby (the head of) a new non-operative
	 * object component, its reactivation point positioned immediately after the
	 * detach statement. As a consequence, that part of the operating chain
	 * which is dynamically enclosed by X becomes the (non-operating)
	 * reactivation chain of X.
	 * 
	 * <li>The PSC returns to the block instance to which X was attached and
	 * execution continues immediately after the associated object generator or
	 * call statement (see 7.3.2).
	 * </ul>
	 * If X is local to a system head, the new component becomes a member of the
	 * associated system. It is a consequence of the language definition that,
	 * prior to the execution of the detach statement, X was dynamically
	 * enclosed by the head of the operative component of this system. The
	 * operative component remains operative.
	 * 
	 * <li>X is a detached object.<br>
	 * The detach statement then constitutes an error.
	 * 
	 * <li>X is a resumed object.<br>
	 * X is then (the head of) an operative system component. Let S be the
	 * associated system. It is a consequence of the language definition that X
	 * must be operating. The effect of the detach statement is:
	 * <ul>
	 * <li>X enters the detached state and becomes non-operative, its
	 * reactivation point positioned immediately after the detach statement. As
	 * a consequence, that part of the operating chain which is dynamically
	 * enclosed by X becomes the (non-operating) reactivation chain of X.
	 * 
	 * <li>The PSC is moved to the current reactivation point of the main
	 * component of S, whereby this main component becomes operative and
	 * operating. As a consequence, all block instances on the reactivation
	 * chain of the main component also become operating.
	 * </ul>
	 * <li>X is a terminated object.<br>
	 * The detach statement then constitutes an error.
	 * </ol>
	 * </ul>
	 */
	public void detach(int sourceLine) {
		if (RT.Option.QPS_TRACING)
			RT.TRACE("LINE "+sourceLine+": BEGIN DETACH " + this.edObjectIdent() + " ==> " + CUR$.edObjectIdent());
		detach();
		if (RT.Option.QPS_TRACING)
			RT.TRACE("LINE "+sourceLine+": DETACH(" + this.edObjectIdent() + ") CONTINUE IN " + CUR$.edObjectIdent());
	}
	public static void detach(RTObject$ SL) {
		SL.detach();
	}
	public void detach() {
		//if (RT.Option.QPS_TRACING) RT.TRACE("BEGIN DETACH " + this.edObjectIdent() + " ==> " + CUR$.edObjectIdent());
		if (isQPSystemBlock()) return; // Detach QPS System Block is no-operation.
		// Make sure that this object is on the operating chain.
		// Note that a detached or terminated object cannot be on the operating chain.
		RTObject$ dl = CUR$;
		while (dl != this) {
			dl = dl.DL$;
			if (dl == null)
				throw new SimulaRuntimeError("x.Detach: x is not on the operating chain.");
		}
		switch(this.STATE$) {
			case resumed -> {
				// Find main component for component to be detached. The main
				// component head must be the static enclosure of the object.
				RTObject$ main = this.SL$;
				// Rotate the contents of 'CUR$', 'this.DL$' and 'main.DL$'.
				// <main.DL$,this.DL$,CUR$> := <this.DL$,CUR$,main.DL$>
				dl = main.DL$; main.DL$ = this.DL$; this.DL$ = CUR$; CUR$ = dl;
			} 
			case attached -> {
				// Swap the contents of object's 'this.DL$' and 'CUR$'.
				// <this.DL$,CUR$> := <CUR$,this.DL$>
				dl = this.DL$; this.DL$ = CUR$; CUR$ = dl;
			}
			default -> throw new SimulaRuntimeError("Illegal Detach");
		}
		this.STATE$ = OperationalState.detached;
 
		if (RT.Option.QPS_TRACING) RT.TRACE("DETACH " + this.edObjectIdent() + " ==> " + CUR$.edObjectIdent());
		Coroutine.detach();
	}

	// *********************************************************************
	// *** CALL - See Simula Standard 7.3.1 Call
	// *********************************************************************
	/**
	 * <p>
	 * "call" is formally a procedure with one object reference parameter qualified
	 * by a fictitious class 'CLASS' including all classes. Let Y denote the object
	 * referenced by a call statement.
	 * 
	 * <p>
	 * If Y is terminated, attached or resumed, or Y == none, the call statement
	 * constitutes an error.
	 * 
	 * <p>
	 * Assume Y is a detached object. The effect of the call statement is:
	 * <ul>
	 * <li>Y becomes attached to the block instance containing the call statement,
	 * whereby Y loses its status as a component head. As a consequence the system
	 * to which Y belongs (if any) loses the associated component.
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
	public void call(final RTObject$ ins,int sourceLine) {
		if (RT.Option.QPS_TRACING)
			RT.TRACE("LINE "+sourceLine+": BEGIN CALL " + this.edObjectIdent() + " ==> " + CUR$.edObjectIdent());
		call(ins);
		if (RT.Option.QPS_TRACING)
			RT.TRACE("LINE "+sourceLine+": CALL(" + this.edObjectIdent() + ") CONTINUE IN " + CUR$.edObjectIdent());
	}
	public void call(final RTObject$ ins) {
		RTObject$ dl; // Temporary reference to dynamic enclosure.
		if (ins == null) throw new SimulaRuntimeError("Call(x): x is none.");
		if (ins.STATE$ != OperationalState.detached)
			throw new SimulaRuntimeError("Call(x): x is not in detached state.");
		// The object to be attached cannot be on the operating chain,
		// because then its state would have been resumed and not detached.

		// Swap the contents of 'CUR$' and object's 'dl'.
		// <ins.DL$,CUR$>:=<CUR$,ins.DL$>;
		dl = ins.DL$; ins.DL$ = CUR$; CUR$ = dl;
		// From now on the object is in attached state.
		// It is no longer a component head.
		ins.STATE$ = OperationalState.attached;
		//if (RT.Option.QPS_TRACING) RT.TRACE("CALL " + this.edObjectIdent() + " ==> " + CUR$.edObjectIdent());
		swapCoroutines();
	}

	// *********************************************************************
	// *** RESUME - See Simula Standard 7.3.1 Resume
	// *********************************************************************
	/**
	 * <p>
	 * "resume" is formally a procedure with one object reference parameter
	 * qualified by a fictitious class 'CLASS' including all classes. Let Y denote
	 * the object referenced by a resume statement.
	 * 
	 * <p>
	 * If Y is not local to a system head, i.e. if Y is local to a class object or
	 * an instance of a procedure body, the resume statement constitutes an error.
	 * 
	 * <p>
	 * If Y is terminated or attached, or Y==none, the resume statement constitutes
	 * an error.
	 * 
	 * <p>
	 * If Y is a resumed object, the resume statement has no effect (it is a
	 * consequence of the language definition that Y must then be operating.)
	 * 
	 * <p>
	 * Assume Y is a detached object being (the head of) a non-operative system
	 * component. Let S be the associated system and let X denote (the head of) the
	 * current operative component of S. It is a consequence of the language
	 * definition that X must be operating, and that X is either the main component
	 * of S or local to the head of S. The effect of the resume statement is:
	 * <ul>
	 * <li>X becomes non-operative, its reactivation point positioned immediately
	 * after the resume statement. As a consequence, that part of the operating
	 * chain which is dynamically enclosed by X becomes the (non-operating)
	 * reactivation chain of X. If X is an object component its head enters the
	 * detached state.
	 * 
	 * <li>The PSC is moved to the reactivation point of Y, whereby Y enters the
	 * resumed state and becomes operative and operating. As a consequence, all
	 * block instances on the reactivation chain of Y also become operating.
	 * </ul>
	 * 
	 * @param ins
	 *            The object to be Resumed
	 */
	public void resume(final RTObject$ ins,int sourceLine) {
		if (RT.Option.QPS_TRACING) RT.TRACE("LINE "+sourceLine+": BEGIN RESUME " + this.edObjectIdent() + " ==> " + CUR$.edObjectIdent());
		resume(ins);
	}
	public void resume(final RTObject$ ins) {
		resume(ins,true); // Normal Case
	}
	public void resume(final RTObject$ ins,boolean doSwap) {
		RTObject$ comp;   // Component head.
		RTObject$ mainSL; // Static enclosure of main component head.
		RTObject$ main;   // The head of the main component and also
						  // the head of the quasi-parallel system.
		if (ins == null) throw new SimulaRuntimeError("Resume(x): x is none.");

		if (ins.STATE$ != OperationalState.resumed) { // A no-operation?
		    // The object to be resumed must be local to a system head.
			main = ins.SL$;
			if (!main.isQPSystemBlock())
				throw new SimulaRuntimeError("Resume(x): x is not local to sub-block or prefixed block.");
			if (ins.STATE$ != OperationalState.detached)
				throw new SimulaRuntimeError("Resume(x): x is not in detached state but " + ins.STATE$);
			// Find the operating component of the quasi-parallel system.
			comp = CUR$; mainSL = main.SL$;
			while (comp.DL$ != mainSL) comp = comp.DL$;
			if (comp.STATE$ == OperationalState.resumed)
				comp.STATE$ = OperationalState.detached;
			// Rotate the contents of 'ins.dl', 'comp.dl' and 'CUR$'.
			// Invariant: comp.DL$ = mainSL
			// <ins.DL$,comp.DL$,CUR$>=<comp.DL$,CUR$,ins.DL$>
			comp.DL$ = CUR$; CUR$ = ins.DL$; ins.DL$ = mainSL;
			ins.STATE$ = OperationalState.resumed;
			if (RT.Option.QPS_TRACING)
				RT.TRACE("RESUME " + this.edObjectIdent() + " ==> " + CUR$.edObjectIdent());
			if(doSwap) swapCoroutines();
		}
	}

	/**
	 * This method is virtual and must be redefined in blocks.
	 * 
	 * @return
	 */
	public RTObject$ STM$() { return (null); }

	// *********************************************************************
	// *** endProgram
	// *********************************************************************
	private static void endProgram(final int exitValue) {
		if (RT.Option.THREAD_TRACING) RT.TRACE("RTObject$.endProgram:");
		// SYSIN$.close();
		// SYSOUT$.close();
		SYSOUT$.outimage();
//		ThreadUtils.printThreadList();
		long timeUsed  = System.currentTimeMillis( ) - startTimeMs;
		if(RT.Option.VERBOSE) {
			RT.println("\nEnd program: " + RT.progamIdent);		      
			if (RT.numberOfEditOverflows > 0)
				RT.println(" -  WARNING " + RT.numberOfEditOverflows + " EditOverflows");
			Runtime runtime=Runtime.getRuntime();
			RT.println(" -  Memory(used="+runtime.totalMemory()+",free="+runtime.freeMemory()+')');
			RT.println(" -  nProcessors="+runtime.availableProcessors());
			RT.println(" -  "+(RT.Option.USE_VIRTUAL_THREAD?"Virtual":"")+"Thread Count = " + Coroutine.threadCount);
//			RT.println(" -  Active Thread Count = " + Thread.activeCount());
			RT.println(" -  Elapsed Time Approximately " + timeUsed/1000 + " sec.");
		} else if (RT.numberOfEditOverflows > 0)
			RT.println("End program: WARNING " + RT.numberOfEditOverflows + " EditOverflows");			
		if (RT.console == null)	System.exit(exitValue);
	}

	// *********************************************************************
	// *** swapCoroutines
	// *********************************************************************
	static void swapCoroutines() {
		Coroutine cont = Coroutine.getCurrentCoroutine();
		
		if(RT.Option.LOOM_TRACING) RT.TRACE("SWAP: CURRENT= "+cont);
		
		if (cont == null) {
			cont = CUR$.CORUT$;
			RTObject$ next = CUR$;
			while (next.CORUT$ != null) {
				if(RT.Option.LOOM_TRACING) RT.TRACE("SWAP: RUN NEXT "+next);
				next.CORUT$.run();
				// Return here when Coroutine is Detached or Done
				next = CUR$;
				if(RT.Option.LOOM_TRACING) RT.TRACE("SWAP: RUN RETURNED "+next);
			}
		} else {
			if(RT.Option.LOOM_TRACING) RT.TRACE("SWAP: YIELD "+cont);
			Coroutine.detach();
		}
	}

	// *********************************************************************
	// *** TRACING AND DEBUGGING UTILITIES
	// *********************************************************************

	public static TXT$ objectTraceIdentifier(final RTObject$ staticLink) {
		return (new TXT$(staticLink.edObjectIdent()));
	}

	public TXT$ objectTraceIdentifier() { return (new TXT$(edObjectIdent())); }

	public String edObjectIdent() {
		StringBuilder s = new StringBuilder();
		s.append(this.getClass().getSimpleName());
//		if (SEQU > 0) s.append('#').append(SEQU);
//		s.append('#').append(this.hashCode());
		return (s.toString());
	}

	public String edObjectAttributes() {
		StringBuilder s = new StringBuilder();
		s.append(edObjectIdent());
		s.append(" SL=").append((SL$ == null) ? "null" : SL$.edObjectIdent());
		s.append(" DL=").append((DL$ == null) ? "null" : DL$.edObjectIdent());
		s.append(" STATE=").append(STATE$);
		s.append(" CORUT$=").append(CORUT$);
		s.append(" CUR=").append(CUR$);
		return (s.toString());
	}

//	public void printStaticContextChain() {
//		RTObject$ x = this;
//		RT.println("STATIC CONTEXT CHAIN:");
//		while (x != null) {
//			RT.println(" - " + x.edObjectAttributes());
//			x = x.SL$;
//		}
//	}

	public String toString() {
		return (edObjectIdent());
	}

}