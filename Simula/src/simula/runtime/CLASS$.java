package simula.runtime;


/**
* 
* @author SIMULA Standards Group
* @author Øystein Myhre Andersen
*/
//public abstract class CLASS$ extends RTObject$ {
public abstract class CLASS$ extends BASICIO$ {  // CORR-PREFIX

	// Constructor
	public CLASS$(RTObject$ staticLink) {
		super(staticLink);
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
	public void detach()
	{ RTObject$ ins;   //  Instance to be detached.
	  RTObject$ dl;    //  Temporary reference to dynamical enclosure.
	  RTObject$ main;  //  The head of the main component and also
		               //  the head of the quasi-parallel system.
	  ins=this;
	  if(RT.Option.QPS_TRACING) RT.TRACE("BEGIN DETACH "+edObjectAttributes());
	  RT.ASSERT(CUR$.DL$!=CUR$,"Invariant");
	  //  Detach on a prefixed block is a no-operation.
	  if(!CUR$.isQPSystemBlock())
	  { // Make sure that the object is on the operating chain.
		// Note that a detached or terminated object cannot be on
		// the operating chain.
		dl=CUR$;
		while(dl!=ins) {
		    dl=dl.DL$;
		    if(dl==null) throw
		      new RuntimeException("x.Detach: x is not on the operating chain.");
		}
		// Treat the case resumed and operating first,
		// because it is probably the dynamically most common.
		if(ins.STATE$==OperationalState.resumed) {
		    ins.STATE$=OperationalState.detached;
		    // Find main component for component to be detached. The main
		    // component head must be the static enclosure of the object,
		    // since the object has OperationalState.resumed.
		    main=ins.SL$;
		    // Rotate the contents of 'CUR$', 'ins.DL$' and 'main.DL$'.
		    // <main.DL$,ins.DL$,CUR$>:=<ins.DL$,CUR$,main.DL$>
		    dl=main.DL$; main.DL$=ins.DL$; ins.DL$=CUR$; CUR$=dl;
		} else {
		    RT.ASSERT(ins.STATE$==OperationalState.attached,"Invariant");
		    ins.STATE$=OperationalState.detached;
		    // Swap the contents of object's 'DL$' and 'CUR$'.
		    // <ins.DL$,CUR$>:=<CUR$,ins.DL$>
		    dl=ins.DL$; ins.DL$=CUR$; CUR$=dl;
		}
		RT.ASSERT(CUR$.DL$!=CUR$,"Invariant");
	    if(RT.Option.QPS_TRACING) RT.TRACE("END DETACH "+edObjectAttributes());
	    swapThreads(ins.DL$);
	  }
	}


}
