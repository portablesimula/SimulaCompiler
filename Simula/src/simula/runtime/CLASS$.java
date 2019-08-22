/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.lang.RuntimeException;

import simula.runtime.loom.Continuation;

/**
* 
* @author SIMULA Standards Group
* @author Øystein Myhre Andersen
*/
public abstract class CLASS$ extends BASICIO$ implements Runnable {
	// Constructor
	public CLASS$(final RTObject$ staticLink) {
		super(staticLink);
	}

	// Runnable Body
	public RTObject$ START$() {
		beginContinuation();
//		System.out.println("CLASS$.START$: beginContinuation RETURNS");
		return(this);
	}
  
	public void run() {
		STM$();
	}

	
	// *********************************************************************
	// *** BEGIN QPS COMPONENT IN A SEPARATE CONTINUATION
	// *********************************************************************
	private void beginContinuation() {
		this.CONT$=new Continuation(continuationScope,this);
		if(RT.Option.QPS_TRACING) RT.TRACE("START "+this.edObjectIdent());
		RT.ASSERT(CUR$==this,"CLASS$.START:Invariant-1");
		swapContinuations();
	}

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
	public void detach() {
		if (isQPSystemBlock()) return; // Detach QPS System Block is no-operation.
		// Make sure that this object is on the operating chain.
		// Note that a detached or terminated object cannot be on the operating chain.
		RTObject$ dl = CUR$;
		while (dl != this) {
			dl = dl.DL$;
			if (dl == null)
				throw new RuntimeException("x.Detach: x is not on the operating chain.");
		}
		switch(this.STATE$) {
			case resumed: {
				// Find main component for component to be detached. The main
				// component head must be the static enclosure of the object.
				RTObject$ main = this.SL$;
				// Rotate the contents of 'CUR$', 'this.DL$' and 'main.DL$'.
				// <main.DL$,this.DL$,CUR$> := <this.DL$,CUR$,main.DL$>
				dl = main.DL$; main.DL$ = this.DL$; this.DL$ = CUR$; CUR$ = dl;
			} break;
			case attached: {
				// Swap the contents of object's 'this.DL$' and 'CUR$'.
				// <this.DL$,CUR$> := <CUR$,this.DL$>
				dl = this.DL$; this.DL$ = CUR$; CUR$ = dl;
			} break;
			default: throw new RuntimeException("Illegal Detach");
		}
		this.STATE$ = OperationalState.detached;
 
		if (RT.Option.QPS_TRACING) RT.TRACE("DETACH " + this.edObjectIdent() + " ==> " + CUR$.edObjectIdent());
		Continuation.yield(continuationScope);
	}

}