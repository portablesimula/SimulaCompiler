/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
 * Additional System class CatchingErrors.
 * <p>
 * This class is used to implement runtime error catching.
 * The basic idea is to enclose the 'inner' statement by a Java try-catch
 * construction and, in the catch section to call a virtual procedure 'onError'
 * to deal with the error situation.
 * <p>
 * To achieve this, the class CatchingErrors is hand-coded as a standard class.
 * <pre>
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
 * </pre>
 * Usage:
 * <pre>
 *       CatchingErrors begin
 *           procedure onError(message); text message; begin
 *               ... treating error
 *           end;
 *           ... any error here will cause calling onError
 *       end;
 * </pre>
 * There are three ways to return from the procedure onError:
 * <p>
 *    1) goto a non-local label.
 * <p>   
 *    2) calling terminate_program or error
 * <p>   
 *    3) falling through procedure end which has the same effect as ending the prefixed block.
 * <p>   
 * Example: Safe version of getint returns maxint when it fails.
 * <pre>
 *     integer procedure safeGetint(t); text t; begin
 *         CatchingErrors begin
 *             procedure onError(message); text message; begin
 *                 safeGetint:=maxint;
 *             end;
 *             safeGetint:=t.getint;
 *         end;
 *     end;    
 * </pre>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_CatchingErrors.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public abstract class RTS_CatchingErrors extends RTS_CLASS {
	
	/**
	 * Default virtual match for procedure onError.
	 * @return nothing
	 * @throws RTS_SimulaRuntimeError always
	 */
	public RTS_PRCQNT _onError_0() {
		throw new RTS_SimulaRuntimeError("No Virtual Match: onError");
	}

	/**
	 * Create a new _CatchingErrors instance.
	 * @param staticLink the static link
	 */
	public RTS_CatchingErrors(RTS_RTObject staticLink) {
		super(staticLink);
		BBLK(); // Iff no prefix
	}

	/**
	 * This method is called when a RuntimeException occur.
	 * @param e a RuntimeException
	 * @param match virtual match procedure 
	 */
	public void _onError(RuntimeException e, RTS_PRCQNT match) {
		if (e instanceof RTS_LABEL)
			throw (e);
		try {
			String message = getErrorMessage(e);
			if (RTS_COMMON.Option.VERBOSE) {
				System.out.println("GOT _SimulaRuntimeError:" + message);
				e.printStackTrace(System.out);
				RTS_COMMON.printSimulaStackTrace(1);
			}
			match.CPF().setPar(new RTS_NAME<RTS_TXT>() {
				public RTS_TXT get() {
					return (new RTS_TXT(message));
				}
			})._ENT();
		} catch (RTS_LABEL q) {
			throw (q);
		} catch (RuntimeException x) {
			System.out.println("RuntimeException within onError: " + getErrorMessage(e));
			e.printStackTrace(System.out);
			System.exit(-1);
		}
	}

}
