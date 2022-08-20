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
public abstract class _RTObject {


	// BASICIO
	static final int INPUT_LINELENGTH_ = 80;
	static final int OUTPUT_LINELENGTH_ = 132;
	static _InFile SYSIN_;
	public static _PrintFile SYSOUT_;
	public static _InFile sysin() { return (SYSIN_); }
	public static _PrintFile sysout() { return (SYSOUT_); }
	private static long startTimeMs;

	// QPS
	public enum OperationalState {
		detached, resumed, attached, terminated, terminatingProcess
	}
	public OperationalState STATE_;
	public _Coroutine CORUT_;

	// RTS
	public static final _BASICIO CTX_ = new _BASICIO(null);
	public static _RTObject _CUR = CTX_; // Current Block Instance
	public int _JTX; // Jump Table Index used by _STM()

	public boolean isQPSystemBlock() { return (false); } // Needs Redefinition
	public boolean isDetachUsed() {	return (false);	} // Needs Redefinition

	/**
	 * This is a pointer to the object of the nearest textually enclosing block
	 * instance, also called 'static link'.
	 */
	public _RTObject _SL; // Static Link

	/**
	 * If this block instance is attached this is a pointer to the object of the
	 * block instance to which the instance is attached (also called dynamic link),
	 * i.e. it points to the block instance which called this one.
	 */
	_RTObject DL_; // Dynamic Link

	// ************************************************************
	// *** Constructor
	// ************************************************************

	/**
	 * Constructor
	 * 
	 * @param SL Static Link, may be null when creating CONTEXT, TEXTOBJ and TXTREF
	 */
	public _RTObject(final _RTObject SL) {
		if (SL != null) {
			this._SL = SL;
			this.CORUT_ = _Coroutine.getCurrentCoroutine();
		}
	}


	// ****************************************************
	// *** The Abstract Generic Class _NAME<T> supporting
	// *** Name-Parameters in Java Coding.
	// ****************************************************
	public abstract class _NAME<T> {
		public _RTObject _CUR; // Thunk Environment

		public _NAME() { _CUR = _RTObject._CUR;	}

		public abstract T get();

		public T put(final T x) {
			throw new _SimulaRuntimeError("Illegal assignment. Name parameter is not a variable");
		}
	}

	// ************************************************************
	// *** ARRAY BOUND CHECKING
	// ************************************************************
	public void _BOUND_CHECK(final int lb,final int ub) {
		if (lb > ub)
			throw new _SimulaRuntimeError("ARRAY(" + lb + ':' + ub + ") - BOUND-CHECK FAILED");
	}

	// ************************************************************
	// *** ARRAY OBJECTS
	// ************************************************************
	static final String arrayError = "Illegal use of array";

	public int[] _IX(final int... ix) {
		return (ix);
	}

	public final class _ARRAY<T> {
		final public T Elt;
		final public int[] LB;
		final public int[] UB;

		public _ARRAY(final T Elt,final int[] LB,final int[] UB) {
			this.Elt = Elt;
			this.LB = LB;
			this.UB = UB;
		}

		public _ARRAY<T> COPY() {
			T CPY = copyMultiArray(Elt);
			_ARRAY<T> to = new _ARRAY<T>(CPY, LB, UB);
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
				s.append("_ARRAY(").append(LB[0]).append(':').append(UB[0]).append("), ");
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

	public _ARRAY<?> arrayValue(final Object par) {
		if (par instanceof _NAME<?> arr) return((_ARRAY<?>)arr.get());
		return ((_ARRAY<?>) par);
	}

	public _PRCQNT procValue(final Object par) {
		if (par instanceof _NAME<?> proc) return((_PRCQNT)proc.get());
		return ((_PRCQNT) par);
	}

	public Object objectValue(Object par) {
		if (par instanceof _NAME<?> npar) par = npar.get();
		if (par instanceof _PRCQNT proc)  par = proc.CPF()._RESULT();
		return (par);
	}

	public int intValue(Object par) {
		if (par instanceof _NAME<?> npar) par = npar.get();
		if (par instanceof _PRCQNT proc)  par = proc.CPF()._RESULT();
		if (par instanceof Float   f) return (f.intValue());
		if (par instanceof Double  d) return (d.intValue());
		if (par instanceof Integer i) return (i);
		throw new ClassCastException("Incompatible Types: int," + par.getClass().getSimpleName());
	}

	public float floatValue(Object par) {
		if (par instanceof _NAME<?> npar) par = npar.get();
		if (par instanceof _PRCQNT proc)  par = proc.CPF()._RESULT();
		if (par instanceof Float   f) return (f);
		if (par instanceof Double  d) return (d.floatValue());
		if (par instanceof Integer i) return (i.floatValue());
		throw new ClassCastException("Incompatible Types: float," + par.getClass().getSimpleName());
	}

	public double doubleValue(Object par) {
		if (par instanceof _NAME<?> npar) par = npar.get();
		if (par instanceof _PRCQNT proc)  par = proc.CPF()._RESULT();
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
		final _NAME<T> cvar;
		_NAME<T> nextValue;

		public SingleElt(final _NAME<T> cvar,final _NAME<T> init) {
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
		final _NAME<_TXT> cvar;
		_NAME<_TXT> nextValue;

		public SingleTValElt(final _NAME<_TXT> cvar,final _NAME<_TXT> init) {
			this.cvar = cvar;
			this.nextValue = init;
			more = true;
		}

		public boolean hasNext() { return (nextValue != null); }

		public Boolean next() {
			if (nextValue == null) return (false);
			_TXT val = nextValue.get();
			_ASGTXT(cvar.get(), val);
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
		final _NAME<Number> cvar, init, step, until;
		Number nextValue;

		public StepUntil(final _NAME<Number> cvar,final _NAME<Number> init,final _NAME<Number> step,final _NAME<Number> until) {
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
		final _NAME<T> cvar, expr;
		_NAME<Boolean> cond;

		public WhileElt(final _NAME<T> cvar,final _NAME<T> expr,final _NAME<Boolean> cond) {
			this.cvar = cvar;
			this.expr = expr;
			this.cond = cond;
		}

		public Boolean next() {
			T val = expr.get();
			cvar.put(val);
			more = cond.get(); // IF not more return null - test i loopen: if(_CB==null) continue;
			return (more);
		}
	}

	public final class WhileTValElt extends ForElt {
		// For t:= <TextExpr> while <Cond> // Text Value Assignment
		final _NAME<_TXT> cvar, expr;
		_NAME<Boolean> cond;

		public WhileTValElt(final _NAME<_TXT> cvar,final _NAME<_TXT> expr,final _NAME<Boolean> cond) {
			this.cvar = cvar;
			this.expr = expr;
			this.cond = cond;
		}

		public Boolean next() {
			_TXT val = expr.get();
			_ASGTXT(cvar.get(), val);
			more = cond.get(); // IF not more return null - test i loopen: if(_CB==null) continue;
			return (more);
		}
	}

	// *****************************************
	// *** Text utilities ***
	// *****************************************
	public final static _TXT NOTEXT = new _TXT();

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
	public static _TXT copy(final _TXT T) {
		if (T == null) return (null);
		_TXT U = blanks(T.LENGTH);
		_ASGTXT(U, T);
		return (U);
	}

	/**
	 * The operator & permits text concatenation.
	 * 
	 * @param T1
	 * @param T2
	 * @return
	 */
	public _TXT CONC(_TXT T1, _TXT T2) {
		if (T1 == null)	T1 = NOTEXT;
		if (T2 == null)	T2 = NOTEXT;
		_TXT U = blanks(_TXT.length(T1) + _TXT.length(T2));
		_ASGTXT(_TXT.sub(U, 1, _TXT.length(T1)), T1);
		_ASGTXT(_TXT.sub(U, 1 + _TXT.length(T1), _TXT.length(T2)), T2);
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
	public static _TXT blanks(final int n) {
		if (n < 0) throw new _SimulaRuntimeError("Parmameter to blanks < 0");
		if (n == 0)	return (NOTEXT);
		_TXT textRef = new _TXT();
		_TEXTOBJ textObj = new _TEXTOBJ(n, false);
		textObj.fill(' ');
		textRef.START = 0; // Note: Counting from zero in this implementation
		textRef.LENGTH = n;
		textRef.POS = 0; // Note: Counting from zero in this implementation
		textRef.OBJ = textObj;
		return (textRef);
	}

	public static _TXT _ASGTXT(_TXT T, _TXT U) {
		if (T == null) T = NOTEXT;
		if (U == null) U = NOTEXT;
		int fromLength = U.LENGTH;
		if (fromLength > T.LENGTH)
			throw (new _SimulaRuntimeError("RHS too long in text value assignment: RHS.length="+T.LENGTH+", LHS.length="+fromLength));
		for (int i = 0; i < fromLength; i++)
			T.OBJ.MAIN[T.START + i] = U.OBJ.MAIN[U.START + i];
		for (int i = fromLength; i < T.LENGTH; i++)
			T.OBJ.MAIN[T.START + i] = ' ';
		return (T);
	}

	public _TXT _ASGSTR(_TXT T,final String s) {
		if (T == null) T = NOTEXT;
		int fromLength = 0;
		if (s != null) fromLength = s.length();
		if (fromLength > T.LENGTH)
			throw (new _SimulaRuntimeError("RHS too long in text value assignment: RHS.length="+T.LENGTH+", LHS.length="+fromLength));
		for (int i = 0; i < fromLength; i++)
			T.OBJ.MAIN[T.START + i] = s.charAt(i);
		for (int i = fromLength; i < T.LENGTH; i++)
			T.OBJ.MAIN[T.START + i] = ' ';
		return (T);
	}

	// **************************************************************
	// *** TXTREL - Text value relations
	// **************************************************************
	public static boolean _TXTREL_LT(final _TXT left,final _TXT right) {
		return (TXTREL(left, right, 1));
	}

	public boolean _TXTREL_EQ(final _TXT left,final _TXT right) {
		return (TXTREL(left, right, 2));
	}

	public boolean _TXTREL_LE(final _TXT left,final _TXT right) {
		return (TXTREL(left, right, 3));
	}

	public boolean _TXTREL_GT(final _TXT left,final _TXT right) {
		return (TXTREL(left, right, 4));
	}

	public boolean _TXTREL_NE(final _TXT left,final _TXT right) {
		return (TXTREL(left, right, 5));
	}

	public boolean _TXTREL_GE(final _TXT left,final _TXT right) {
		return (TXTREL(left, right, 6));
	}

	private static boolean TXTREL(_TXT left, _TXT right, int code) {
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
		default: throw new _SimulaRuntimeError("Internal Error");
		}
	}

	// **************************************************************
	// *** TXTREL - Text reference relations. == =/=
	// **************************************************************
	public boolean TRF_EQ(_TXT left, _TXT right) {
		if (left == null) left = NOTEXT;
		if (right == null) right = NOTEXT;
		if (left.LENGTH != right.LENGTH) return (false);
		if (left.START != right.START) return (false);
		if (left.OBJ != right.OBJ) return (false);
		return (true);
	}

	public boolean TRF_NE(final _TXT left,final _TXT right) {
		return (!TRF_EQ(left, right));
	}

	// **************************************************************
	// *** USED IN CONDITIONAL STATEMENT TO PREVENT DEAD-CODE REMOVAL
	// **************************************************************
	public boolean _VALUE(boolean cond) {
		return (cond);
	}

	// ************************************************************
	// *** lOCAL JUMP/LABEL - Meant for Byte-Code Engineering
	// ************************************************************
	public static void _LABEL(final int labelIndex,final String ident) {
		// Local LABEL - Needs ByteCode Engineering.
	}

	public static void _JUMPTABLE(final int labelIndex) {
		// Local GOTO - Needs ByteCode Engineering.
		if (_RT.Option._GOTOTRACING)
			_RT.TRACE("_RTObject._JUMPTABLE: labelIndex=" + labelIndex);
		String msg = "FATAL ERROR: Local GOTO LABEL#" + labelIndex + " Needs ByteCode Engineering.";
		_RT.println(msg);
		_RT.printSimulaStackTrace(0);
		if (labelIndex == 0) return;
		_RT.println(msg);
		throw new _SimulaRuntimeError(msg);
	}

	// ************************************************************
	// *** FRAMEWORK for NonLocal Label-Parameters in Java Coding
	// ************************************************************
	public final class _LABQNT extends RuntimeException { // RuntimeError {
		static final long serialVersionUID = 42L;
		public final _RTObject _SL; // Static link, i.e. the block in which the label is defined.
		public final int index; // I.e. ordinal number of the Label within its Scope(staticLink).
		public final String identifier; // To improve error and trace messages.

		// Constructor
		public _LABQNT(final _RTObject _SL,final int index,final String identifier) {
			this._SL = _SL;
			this.index = index;
			this.identifier = identifier;
		}

		public String toString() {
			return ("_LABQNT(" + _SL + ", LABEL#" + index + ", identifier=" + identifier + ')');
		}
	}

	// ************************************************************
	// *** _GOTO -- To avoid Java-error: "Unreachable code" after GOTO
	// ************************************************************
	public void _GOTO(final _LABQNT q) {
		if (_RT.Option._GOTOTRACING)	_RT.TRACE("_RTObject.GOTO: " + q );
		throw (q);
	}

	// ************************************************************
	// *** TRACING: TRACE_GOTO
	// ************************************************************
	public static void TRACE_GOTO(final String msg,final _LABQNT q) {
		_RT.TRACE(msg + " GOTO " + q);
	}

	// ************************************************************
	// *** UncaughtExceptionHandler
	// ************************************************************
	public class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
		public final _RTObject obj;

		public UncaughtExceptionHandler(final _RTObject obj) {
			this.obj = obj;
		}

		public void uncaughtException(Thread thread, Throwable e) {
			String who = "Thread:" + thread.getName() + '[' + obj + ']';
			if (_RT.Option._GOTOTRACING)	_RT.println(who + " throws exception: " + e);
			if (_RT.Option._GOTOTRACING)	e.printStackTrace();
			if (e instanceof _LABQNT) {
				if (_RT.Option._GOTOTRACING)	System.err.println("POSSIBLE GOTO OUT OF COMPONENT " + obj.edObjectAttributes());
				if (_RT.Option._GOTOTRACING)	_RT.println("POSSIBLE GOTO OUT OF COMPONENT " + obj.edObjectAttributes());
				_RTObject DL = obj.DL_;
				if (DL != null && DL != CTX_) {
					if (_RT.Option._GOTOTRACING)	System.err.println("DL=" + DL.edObjectAttributes());
					if (_RT.Option._GOTOTRACING)	_RT.println("DL=" + DL.edObjectAttributes());
					_Coroutine._PENDING_EXCEPTION = (RuntimeException) e;
					DL.CORUT_.run();
				} else {
					String msg="Illegal GOTO " + ((_LABQNT)e).identifier;
					if(_ENVIRONMENT.EXCEPTION_HANDLER!=null) treatRuntimeError(msg);
					_RT.println(who + ": SIMULA RUNTIME ERROR: " + msg);
					e.printStackTrace();
					endProgram(-1);
				}
			} else if (e instanceof RuntimeException) {
				String msg=getErrorMessage(e);
				
				if(_ENVIRONMENT.EXCEPTION_HANDLER!=null) treatRuntimeError(msg);
				_RT.printError(who + ": SIMULA RUNTIME ERROR: " + msg);
				_RT.printSimulaStackTrace(e, 0);
				e.printStackTrace();
				endProgram(-1);
			} else if (e instanceof Error) {
				String msg = e.getClass().getSimpleName();
//				if(_ENVIRONMENT.EXCEPTION_HANDLER!=null) treatRuntimeError(msg);
				_RT.printError(who + ": SIMULA RUNTIME ERROR: " + msg);
				_RT.printSimulaStackTrace(e, 0);
				e.printStackTrace();
				endProgram(-1);
			} else {
				_RT.printError(who + ": UNCAUGHT EXCEPTION: " + e.getMessage());
				e.printStackTrace();
				endProgram(-1);
			}
			if (_RT.Option._GOTOTRACING)	_ThreadUtils.printThreadList();
		}
		
		private void treatRuntimeError(String msg) {
  	       _PRCQNT erh=_ENVIRONMENT.EXCEPTION_HANDLER;
  	       try { //System.out.println("Runtime Error(2): EXCEPTION_HANDLER="+_ENVIRONMENT.EXCEPTION_HANDLER);
	    	     _ENVIRONMENT.EXCEPTION_HANDLER=null;
	    	     erh.CPF().setPar(new _TXT(msg))._ENT();
		   } catch (Throwable t) {
			     _RT.printError("EXCEPTION IN SIMULA EXCEPTION_HANDLER: " + t);
			     _RT.printError("EXCEPTION_HANDLER: " + erh);
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
		_RT.progamIdent=ident;
		if (_RT.Option.BLOCK_TRACING) _RT.TRACE("Begin Execution of Simula Program: " + ident);
		if (SYSIN_ == null) {
			if (_RT.Option.USE_CONSOLE) {
				_RT.console = new _RTConsolePanel();
				_RT.console.popup();
			}
			SYSIN_ = new _InFile(this, new _TXT("SYSIN"));
			SYSOUT_ = new _PrintFile(this, new _TXT("SYSOUT"));
			SYSIN_.open(blanks(INPUT_LINELENGTH_));
			SYSOUT_.open(blanks(OUTPUT_LINELENGTH_));
		}
		_CUR = this;
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
	 * <li>Update the current instance pointer(_CUR).</li>
	 * </ul>
	 */
	public void BBLK() {
		DL_ = _CUR;	_CUR = this;
		CORUT_ = DL_.CORUT_;
		STATE_ = OperationalState.attached;
		if (_RT.Option.BLOCK_TRACING) _RT.TRACE("BEGIN " + edObjectAttributes());
		_RT.NoneCheck(_SL); // In case of Remote Call on Procedure x.Func, x==none
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
	 * Update the '_CUR' pointer and return to Compiler generated code.</li>
	 * <p>
	 * <li>Terminate class instance.
	 * <p>
	 * The object is marked 'terminated' and the '_CUR' pointer is updated.</li>
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
		switch(STATE_) {
			case attached -> {
					if (_RT.Option.BLOCK_TRACING) _RT.TRACE("END ATTACHED BLOCK " + edObjectAttributes());
					_RT.ASSERT(_CUR == this, "_RTObject.EBLK:invariant-1: CUR="+_CUR+", this="+this);
					STATE_ = OperationalState.terminated;
					_CUR = DL_; // Make the dynamic enclosure the new current instance.
//					if (_RT.Option.BLOCK_TRACING) _RT.TRACE("END ATTACHED BLOCK " + edObjectAttributes());
				}
			case resumed -> {
					_RT.ASSERT(_CUR == this, "_RTObject.EBLK:invariant-2");
					// Treat the case of a resumed and operating object.
					// It is the head of an object component. The class
					// object enters the terminated state, and the object component
					// disappears from its system. The main component of that system
					// takes its place as the operating component of the system.
					// Invariant: _CUR.STATE_ = resumed and _CUR.DL = main.SL
					STATE_ = OperationalState.terminated;
					// Find main component (and system) head. It must be the static
					// enclosure since the object has been RESUMEd.
					_RTObject main = _SL;
					// The main component becomes the operating component.
					_RTObject dl = DL_; DL_ = null;
					_CUR = main.DL_; main.DL_ = dl;
					if (_RT.Option.BLOCK_TRACING) _RT.TRACE("END COMPONENT " + edObjectAttributes());
				}
			case terminatingProcess -> {
					//_RT.TRACE("TERMINATING PROCESS "+edObjectAttributes());
					STATE_ = OperationalState.terminated;
					CORUT_ = null; // Leave it to the GarbageCollector
					return; // Let this Continuation R.I.P.
				}
			default -> throw new _SimulaRuntimeError("_RTObject.EBLK: Internal Error " + edObjectAttributes());
		}
		if (_CUR == null || _CUR == CTX_) {
			if (_RT.Option.BLOCK_TRACING) _RT.TRACE("PROGRAM PASSES THROUGH FINAL END " + edObjectAttributes());
			endProgram(0);
		} else {
			if (this.CORUT_ != null && this.isDetachUsed()) {
				_Coroutine.detach();
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
		if (_RT.Option.QPS_TRACING)
			_RT.TRACE("LINE "+sourceLine+": BEGIN DETACH " + this.edObjectIdent() + " ==> " + _CUR.edObjectIdent());
		detach();
		if (_RT.Option.QPS_TRACING)
			_RT.TRACE("LINE "+sourceLine+": DETACH(" + this.edObjectIdent() + ") CONTINUE IN " + _CUR.edObjectIdent());
	}
	public static void detach(_RTObject SL) {
		SL.detach();
	}
	public void detach() {
		//if (_RT.Option.QPS_TRACING) _RT.TRACE("BEGIN DETACH " + this.edObjectIdent() + " ==> " + _CUR.edObjectIdent());
		if (isQPSystemBlock()) return; // Detach QPS System Block is no-operation.
		// Make sure that this object is on the operating chain.
		// Note that a detached or terminated object cannot be on the operating chain.
		_RTObject dl = _CUR;
		while (dl != this) {
			dl = dl.DL_;
			if (dl == null)
				throw new _SimulaRuntimeError("x.Detach: x is not on the operating chain.");
		}
		switch(this.STATE_) {
			case resumed -> {
				// Find main component for component to be detached. The main
				// component head must be the static enclosure of the object.
				_RTObject main = this._SL;
				// Rotate the contents of '_CUR', 'this.DL_' and 'main.DL_'.
				// <main.DL_,this.DL_,_CUR> := <this.DL_,_CUR,main.DL_>
				dl = main.DL_; main.DL_ = this.DL_; this.DL_ = _CUR; _CUR = dl;
			} 
			case attached -> {
				// Swap the contents of object's 'this.DL_' and '_CUR'.
				// <this.DL_,_CUR> := <_CUR,this.DL_>
				dl = this.DL_; this.DL_ = _CUR; _CUR = dl;
			}
			default -> throw new _SimulaRuntimeError("Illegal Detach");
		}
		this.STATE_ = OperationalState.detached;
 
		if (_RT.Option.QPS_TRACING) _RT.TRACE("DETACH " + this.edObjectIdent() + " ==> " + _CUR.edObjectIdent());
		_Coroutine.detach();
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
	public void call(final _RTObject ins,int sourceLine) {
		if (_RT.Option.QPS_TRACING)
			_RT.TRACE("LINE "+sourceLine+": BEGIN CALL " + this.edObjectIdent() + " ==> " + _CUR.edObjectIdent());
		call(ins);
		if (_RT.Option.QPS_TRACING)
			_RT.TRACE("LINE "+sourceLine+": CALL(" + this.edObjectIdent() + ") CONTINUE IN " + _CUR.edObjectIdent());
	}
	public void call(final _RTObject ins) {
		_RTObject dl; // Temporary reference to dynamic enclosure.
		if (ins == null) throw new _SimulaRuntimeError("Call(x): x is none.");
		if (ins.STATE_ != OperationalState.detached)
			throw new _SimulaRuntimeError("Call(x): x is not in detached state.");
		// The object to be attached cannot be on the operating chain,
		// because then its state would have been resumed and not detached.

		// Swap the contents of '_CUR' and object's 'dl'.
		// <ins.DL_,_CUR>:=<_CUR,ins.DL_>;
		dl = ins.DL_; ins.DL_ = _CUR; _CUR = dl;
		// From now on the object is in attached state.
		// It is no longer a component head.
		ins.STATE_ = OperationalState.attached;
		//if (_RT.Option.QPS_TRACING) _RT.TRACE("CALL " + this.edObjectIdent() + " ==> " + _CUR.edObjectIdent());
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
	public void resume(final _RTObject ins,int sourceLine) {
		if (_RT.Option.QPS_TRACING) _RT.TRACE("LINE "+sourceLine+": BEGIN RESUME " + this.edObjectIdent() + " ==> " + _CUR.edObjectIdent());
		resume(ins);
	}
	public void resume(final _RTObject ins) {
		resume(ins,true); // Normal Case
	}
	public void resume(final _RTObject ins,boolean doSwap) {
		_RTObject comp;   // Component head.
		_RTObject mainSL; // Static enclosure of main component head.
		_RTObject main;   // The head of the main component and also
						  // the head of the quasi-parallel system.
		if (ins == null) throw new _SimulaRuntimeError("Resume(x): x is none.");

		if (ins.STATE_ != OperationalState.resumed) { // A no-operation?
		    // The object to be resumed must be local to a system head.
			main = ins._SL;
			if (!main.isQPSystemBlock())
				throw new _SimulaRuntimeError("Resume(x): x is not local to sub-block or prefixed block.");
			if (ins.STATE_ != OperationalState.detached)
				throw new _SimulaRuntimeError("Resume(x): x is not in detached state but " + ins.STATE_);
			// Find the operating component of the quasi-parallel system.
			comp = _CUR; mainSL = main._SL;
			while (comp.DL_ != mainSL) comp = comp.DL_;
			if (comp.STATE_ == OperationalState.resumed)
				comp.STATE_ = OperationalState.detached;
			// Rotate the contents of 'ins.dl', 'comp.dl' and '_CUR'.
			// Invariant: comp.DL_ = mainSL
			// <ins.DL_,comp.DL_,_CUR>=<comp.DL_,_CUR,ins.DL_>
			comp.DL_ = _CUR; _CUR = ins.DL_; ins.DL_ = mainSL;
			ins.STATE_ = OperationalState.resumed;
			if (_RT.Option.QPS_TRACING)
				_RT.TRACE("RESUME " + this.edObjectIdent() + " ==> " + _CUR.edObjectIdent());
			if(doSwap) swapCoroutines();
		}
	}

	/**
	 * This method is virtual and must be redefined in blocks.
	 * 
	 * @return
	 */
	public _RTObject _STM() { return (null); }

	// *********************************************************************
	// *** endProgram
	// *********************************************************************
	private static void endProgram(final int exitValue) {
		if (_RT.Option.THREAD_TRACING) _RT.TRACE("_RTObject.endProgram:");
		// SYSIN_.close();
		// SYSOUT_.close();
		SYSOUT_.outimage();
//		ThreadUtils.printThreadList();
		long timeUsed  = System.currentTimeMillis( ) - startTimeMs;
		if(_RT.Option.VERBOSE) {
			_RT.println("\nEnd program: " + _RT.progamIdent);		      
			if (_RT.numberOfEditOverflows > 0)
				_RT.println(" -  WARNING " + _RT.numberOfEditOverflows + " EditOverflows");
			Runtime runtime=Runtime.getRuntime();
			_RT.println(" -  Memory(used="+runtime.totalMemory()+",free="+runtime.freeMemory()+')');
			_RT.println(" -  nProcessors="+runtime.availableProcessors());
			_RT.println(" -  "+(_RT.Option.USE_VIRTUAL_THREAD?"Virtual":"")+"Thread Count = " + _Coroutine.threadCount);
//			_RT.println(" -  Active Thread Count = " + Thread.activeCount());
			_RT.println(" -  Elapsed Time Approximately " + timeUsed/1000 + " sec.");
		} else if (_RT.numberOfEditOverflows > 0)
			_RT.println("End program: WARNING " + _RT.numberOfEditOverflows + " EditOverflows");			
		if (_RT.console == null)	System.exit(exitValue);
	}

	// *********************************************************************
	// *** swapCoroutines
	// *********************************************************************
	static void swapCoroutines() {
		_Coroutine cont = _Coroutine.getCurrentCoroutine();
		
		if(_RT.Option.LOOM_TRACING) _RT.TRACE("SWAP: CURRENT= "+cont);
		
		if (cont == null) {
			cont = _CUR.CORUT_;
			_RTObject next = _CUR;
			while (next.CORUT_ != null) {
				if(_RT.Option.LOOM_TRACING) _RT.TRACE("SWAP: RUN NEXT "+next);
				next.CORUT_.run();
				// Return here when Coroutine is Detached or Done
				next = _CUR;
				if(_RT.Option.LOOM_TRACING) _RT.TRACE("SWAP: RUN RETURNED "+next);
			}
		} else {
			if(_RT.Option.LOOM_TRACING) _RT.TRACE("SWAP: YIELD "+cont);
			_Coroutine.detach();
		}
	}

	// *********************************************************************
	// *** TRACING AND DEBUGGING UTILITIES
	// *********************************************************************

	public static _TXT objectTraceIdentifier(final _RTObject staticLink) {
		return (new _TXT(staticLink.edObjectIdent()));
	}

	public _TXT objectTraceIdentifier() { return (new _TXT(edObjectIdent())); }

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
		s.append(" SL=").append((_SL == null) ? "null" : _SL.edObjectIdent());
		s.append(" DL=").append((DL_ == null) ? "null" : DL_.edObjectIdent());
		s.append(" STATE=").append(STATE_);
		s.append(" CORUT_=").append(CORUT_);
		s.append(" CUR=").append(_CUR);
		return (s.toString());
	}

//	public void printStaticContextChain() {
//		_RTObject x = this;
//		_RT.println("STATIC CONTEXT CHAIN:");
//		while (x != null) {
//			_RT.println(" - " + x.edObjectAttributes());
//			x = x._SL;
//		}
//	}

	public String toString() {
		return (edObjectIdent());
	}

}