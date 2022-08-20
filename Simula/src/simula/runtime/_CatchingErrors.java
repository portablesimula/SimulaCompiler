/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
 * The class CatchingErrors is used to implement runtime error catching.
 * The basic idea is to enclose the 'inner' statement by a Java try-catch
 * construction and, in the catch section to call a virtual procedure 'onError'
 * to deal with the error situation.
 * 
 * To achieve this, the class CatchingErrors is hand-coded as a standard class.
 * 
 *       class CatchingErrors;
 *       virtual: procedure onError;
 *       begin
 *       -- code: try {
 *                    inner;
 *       -- code: } catch(RuntimeException e) {
 *       -- code:     _CUR=this; // As iff non-local goto here
 *       -- code:     _onError(e,onError);
 *       -- code: }
 *       
 *       end;  
 * 
 * Usage:
 * 
 *       CatchingErrors begin
 *           procedure onError(message); text message; begin
 *               ... treating error
 *           end;
 *           ... any error here will cause calling onError
 *       end;
 * 
 * There are three ways to return from the procedure onError:
 * 
 *    1) goto a non-local label.
 *    
 *    2) calling terminate_program or error
 *    
 *    3) falling through procedure end which has the same effect as ending the prefixed block.
 *    
 * Example: Safe version of getint returns maxint when it fails.
 * 
 *     integer procedure safeGetint(t); text t; begin
 *         CatchingErrors begin
 *             procedure onError(message); text message; begin
 *                 safeGetint:=maxint;
 *             end;
 *             safeGetint:=t.getint;
 *         end;
 *     end;    
 * 
 * @author Øystein Myhre Andersen
 *
 */
public abstract class _CatchingErrors extends _CLASS {
    public _PRCQNT _onError_0(){ throw new _SimulaRuntimeError("No Virtual Match: onError"); }

    public _CatchingErrors(_RTObject staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
    }
    
    public void _onError(RuntimeException e,_PRCQNT match) {
    	if(e instanceof _LABQNT) throw(e);
    	try {
    		String message=getErrorMessage(e);
    		if(_RT.Option.VERBOSE) {
    			System.out.println("GOT _SimulaRuntimeError:"+message);
    			e.printStackTrace(System.out);
    			_RT.printSimulaStackTrace(1);
    		}
    		match.CPF().setPar(new _NAME<_TXT>() {
    			public _TXT get() { return(new _TXT(message)); } })._ENT();
    	} catch(_LABQNT q) { throw(q);
    	} catch(RuntimeException x) {
    		System.out.println("RuntimeException within onError: "+getErrorMessage(e));
    		e.printStackTrace(System.out);
    		System.exit(-1);
    	}
    }

}
