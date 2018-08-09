/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
 * 
 * The system class "simulation" may be considered an "application package"
 * oriented towards simulation problems. It has the class "simset" as prefix,
 * and set-handling facilities are thus immediately available.
 * <p>
 * The concepts defined in "simulation" are explained with respect to a prefixed
 * block, whose prefix part is an instance of the body of "simulation" or of a
 * subclass. The prefixed block instance acts as the head of a quasi-parallel
 * system which may represent a "discrete event" simulation model.
 * 
 * <pre>
 simset class simulation;
        begin  ref (head) SQS;
      link class EVENT_NOTICE (EVTIME, PROC);
                     long real EVTIME; ref (process) PROC;
           begin
              ref (EVENT_NOTICE) procedure suc;
                 suc:- if SUC is EVENT_NOTICE then SUC else none;

              ref (EVENT_NOTICE) procedure pred;   pred:- PRED;

              procedure RANK_IN_SQS (afore); Boolean afore;
              begin ref (EVENT_NOTICE) evt;
                 evt:- SQS.last;
                 while evt.EVTIME > EVTIME do    evt :- evt.pred;
                 if afore then
                    while evt.EVTIME = EVTIME do evt :- evt.pred;
                 follow(evt)
              end RANK_IN_SQS;
           end EVENT_NOTICE;

           ref (MAIN_PROGRAM) main;

           ref (EVENT_NOTICE) procedure FIRSTEV;  FIRSTEV :- SQS.first;
           ref (process) procedure current; current :- FIRSTEV.PROC;
           long real procedure time; time := FIRSTEV.EVTIME;

      link class process;  .................... 12.1;
           procedure ACTIVAT .................. 12.3;
           procedure hold ..................... 12.4;
           procedure passivate ................ 12.4;
           procedure wait ..................... 12.4;
           procedure cancel ................... 12.4;
   process class MAIN_PROGRAM ................. 12.5;
           procedure accum .................... 12.6;

           SQS        :- new head;
           main       :- new MAIN_PROGRAM;
           main.EVENT :- new EVENT_NOTICE(0,main);
           main.EVENT.into(SQS)
        end simulation;
 * </pre>
 * 
 * When used as a prefix to a block or a class, "simulation" introduces
 * simulation-oriented features through the class "process" and associated
 * procedures.
 * <p>
 * The variable SQS refers to a set which is called the "sequencing set", and
 * serves to represent the system time axis. The members of the sequencing set
 * are event notices ranked according to increasing value of the attribute
 * "EVTIME". An event notice refers through its attribute PROC to a "process"
 * object and represents an event which is the next active phase of that object,
 * scheduled to take place at system time EVTIME. There may be at most one event
 * notice referencing any given process object.
 * <p>
 * The event notice at the lower end of the sequencing set refers to the
 * currently active process object. The object can be referenced through the
 * procedure "current". The value of EVTIME for this event notice is identified
 * as the current value of system time. It may be accessed through the procedure
 * "time".
 * <p>
 * Note: Since the statements and procedures introduced by "simulation" make
 * implicit use of the sequencing procedures (detach, call and resume) explicit
 * sequencing by these procedures should be done with care.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public class Simulation$ extends Simset$ {
	public boolean isDetachable() {
		return (true);
	}

	public Head$ SQS = null;
	public MAIN_PROGRAM$ main = null;

	// Constructor
	public Simulation$(RTObject$ staticLink) {
	super(staticLink);
//	public Simulation$(ENVIRONMENT$ staticLink) {
//	    super((RTObject$)staticLink);
		TRACE_BEGIN_DCL$("Simulation$");
		// Create Class Body
		CODE$ = new ClassBody(CODE$, this,1) {
			public void STM() {
				TRACE_BEGIN_STM$("Simulation$",inner);
				SQS = (Head$) new Head$(Simulation$.this).STM();
				main = (MAIN_PROGRAM$) new MAIN_PROGRAM$((Simulation$) CUR$).START();
				main.EVENT = (EVENT_NOTICE$) new EVENT_NOTICE$((Simulation$) CUR$, 0, main).STM();
	        	//RT.BREAK("GOT NEW EVENT_NOTICE: "+main.EVENT);
				main.EVENT.into(SQS);
				if (inner != null)
					inner.STM();
				TRACE_END_STM$("Simulation$");
			}
		};
	}

	public Simulation$ STM() {
		return ((Simulation$) CODE$.EXEC$());
	}

	public Simulation$ START() {
		START(this);
		return (this);
	}

	public double time() {
		return (FIRSTEV().EVTIME);
	}

	public EVENT_NOTICE$ FIRSTEV() {
		EVENT_NOTICE$ FIRSTEV = ((EVENT_NOTICE$) (SQS.first()));
		return (FIRSTEV);
	}

	/*
	 * <pre>
	 * ref (process) procedure current; current :- FIRSTEV.PROC;
	 * </pre>
	 */
	public Process$ current() {
		return (FIRSTEV().PROC);
	}

	public void hold(double T) {
		SIM_TRACE("Hold " + T);
		EVENT_NOTICE$ first = FIRSTEV();
		if (first != null) {
			if (T > 0)
				first.EVTIME = first.EVTIME + T;
			EVENT_NOTICE$ suc = first.suc();
			if (suc != null) {
				if (suc.EVTIME <= first.EVTIME) {
					first.out();
					first.RANK(false);
					resume(current());
				}
			}
		}
	}

	/*
	 * <pre>
	 * procedure passivate;
     * begin
     *    inspect current do begin  EVENT.out; EVENT :- none  end;
     *    if SQS.empty then error("...") else resume(current)
     * end passivate;
     * </pre>
	 */
	public void passivate() { passivate(false); }

	public void passivate(boolean terminatingProcess) {
		Process$ cur = current();
		SIM_TRACE("Passivate " + cur.edObjectIdent());
		// System.out.println("Passivate: "+cur.edObjectIdent()+", SQS="+this.edSQS());
		if (cur != null) {
			cur.EVENT.out();
			cur.EVENT = null;
		}
		if (SQS.empty())
			throw new RuntimeException("Cancel,Passivate or Wait empties SQS");
		Process$ nxtcur = current();
		// System.out.println("END Passivate: next current="+nxtcur.edObjectIdent()+",
		// SQS="+this.edSQS());
		SIM_TRACE("END Passivate Resume[" + nxtcur.edObjectIdent() + ']');
		resume(nxtcur, terminatingProcess);
		SIM_TRACE("END Passivate AFTER Resume[" + nxtcur.edObjectIdent() + ']');
		// RT.BREAK("Passivate: AFTER Resume(next)");
	}

//	public void terminate() {
//		Process$ cur = current();
//		SIM_TRACE("Terminate "+cur.edObjectIdent());
//		//System.out.println("Terminate: "+cur.edObjectIdent()+", SQS="+this.edSQS());
//		if (cur != null) {
//			cur.EVENT.out();
//			cur.EVENT = null;
//		}
//		if (SQS.empty())
//			throw new RuntimeException("Cancel,Passivate or Wait empties SQS");
//		Process$ nxtcur=current();
//		//System.out.println("END Terminate: next current="+nxtcur.edObjectIdent()+", SQS="+this.edSQS());
//		SIM_TRACE("END Terminate Resume["+nxtcur.edObjectIdent()+']');
//		resume(nxtcur,true);
//		SIM_TRACE("END Terminate AFTER Resume["+nxtcur.edObjectIdent()+']');
//		//RT.BREAK("Terminate: AFTER Resume(next)");
//	}

	public void wait(Head$ S) {
		SIM_TRACE("Wait in Queue " + S);
		current().into(S);
		passivate();
	}

	public void cancel(Process$ x) {
		SIM_TRACE("Cancel " + x);
		if (x == current())
			passivate();
		else if (x != null && x.EVENT != null) {
			x.EVENT.out();
			x.EVENT = null;
		}
	}

	public void ActivateDirect(boolean REAC, Process$ X) {
		if (X == null)
			TRACE_ACTIVATE(REAC, "none");
		else if (X.STATE$ == OperationalState.terminated)
			TRACE_ACTIVATE(REAC, "terminated process");
		else if (X.EVENT != null && !REAC)
			TRACE_ACTIVATE(REAC, "scheduled process");
		else {
			TRACE_ACTIVATE(REAC, X.edObjectIdent());
			Process$ z;
			EVENT_NOTICE$ EV = null;
			if (REAC)
				EV = X.EVENT;
			else if (X.EVENT != null)
				return;
			z = current();
			X.EVENT = (EVENT_NOTICE$) new EVENT_NOTICE$(this, (float) time(), X).STM();
			X.EVENT.precede(FIRSTEV());
			if (EV != null) {
				EV.out();
				if (SQS.empty())
					throw new RuntimeException("(Re)Activate empties SQS.");
			}
			if (z != current())
				resume(current());
		}
	}

	public void ActivateDelay(boolean REAC, Process$ X, double T, boolean PRIO) {
		ActivateAt(REAC, X, time() + T, PRIO);
	}

	public void ActivateAt(boolean REAC, Process$ X, double T, boolean PRIO) {
		if (X == null)
			TRACE_ACTIVATE(REAC, "none");
		else if (X.STATE$ == OperationalState.terminated)
			TRACE_ACTIVATE(REAC, "terminated process");
		else if (X.EVENT != null && !REAC)
			TRACE_ACTIVATE(REAC, "scheduled process");
		else {
			TRACE_ACTIVATE(REAC, X.edObjectIdent() + " at " + T + ((PRIO) ? "prior" : ""));
			Process$ z;
			EVENT_NOTICE$ EV = null;
			if (REAC)
				EV = X.EVENT;
			else if (X.EVENT != null)
				return;
			z = current();
			if (T < time())
				T = time();
			X.EVENT = (EVENT_NOTICE$) new EVENT_NOTICE$(this, (float) T, X).STM();
			if (T == time() && PRIO)
				X.EVENT.precede(FIRSTEV());
			else
				X.EVENT.RANK(PRIO);
			if (EV != null) {
				EV.out();
				if (SQS.empty())
					throw new RuntimeException("(Re)Activate empties SQS.");
			}
			if (z != current())
				resume(current());
		}
	}

	public void ActivateBefore(boolean REAC, Process$ X, Process$ Y) {
		ACTIVATE3(REAC, X, true, Y);
	}

	public void ActivateAfter(boolean REAC, Process$ X, Process$ Y) {
		ACTIVATE3(REAC, X, false, Y);
	}

	private void ACTIVATE3(boolean REAC, Process$ X, boolean BEFORE, Process$ Y) {
		if (X == null)
			TRACE_ACTIVATE(REAC, " none");
		else if (X.STATE$ == OperationalState.terminated)
			TRACE_ACTIVATE(REAC, " terminated process");
		else if (X.EVENT != null && !REAC)
			TRACE_ACTIVATE(REAC, " scheduled process");
		else if (X == Y)
			TRACE_ACTIVATE(REAC, " before/after itself");
		else {
			TRACE_ACTIVATE(REAC, X.edObjectIdent() + ((BEFORE) ? " BEFORE " : " AFTER ") + Y.edObjectIdent());
			Process$ z;
			EVENT_NOTICE$ EV = null;
			if (REAC)
				EV = X.EVENT;
			else if (X.EVENT != null)
				return;
			z = current();
			if (Y == null || Y.EVENT == null)
				X.EVENT = null;
			else {
				if (X == Y)
					return; // reactivate X before/after X;
				X.EVENT = (EVENT_NOTICE$) new EVENT_NOTICE$(this, (float) Y.EVENT.EVTIME, X).STM();
				if (BEFORE)
					X.EVENT.precede(Y.EVENT);
				else
					X.EVENT.follow(Y.EVENT);
			}
			if (EV != null) {
				EV.out();
				if (SQS.empty())
					throw new RuntimeException("(Re)Activate empties SQS.");
			}
			if (z != current())
			{ Process$ nxtcur=current();
			    SIM_TRACE("END ACTIVATE3 Resume["+nxtcur.edObjectIdent()+']');
				resume(nxtcur);
			} else SIM_TRACE("END ACTIVATE3 Continue["+z.edObjectIdent()+']');

		}
	}

	// *********************************************************************
	// *** TRACING AND DEBUGGING UTILITIES
	// *********************************************************************

	private void TRACE_ACTIVATE(boolean REAC, String msg) {
		String act = (REAC) ? "REACTIVATE " : "ACTIVATE ";
		SIM_TRACE(act + msg);

	}

	public void SIM_TRACE(String msg) {
		//checkSQS();
		if (RT.Option.SML_TRACING) {
			Thread thread = Thread.currentThread();
			System.out.println(thread.toString() + ": Time=" + time() + "  " + msg +", SQS="+ edSQS());
		}
	}

	private String checkSQS() {
		StringBuilder s = new StringBuilder();
		Link$ x = SQS.first();
		s.append(", SQS =");
		while (x != null) {
			EVENT_NOTICE$ ev = (EVENT_NOTICE$) x;
			if(ev.PROC.STATE$==OperationalState.terminated)
				throw new RuntimeException("SQS CONTAIN TERMINATED ELEMENT: "+ev.PROC);
			x = x.suc();
		}
		return (s.toString());
	}

	private String edSQS() {
		//checkSQS();
		StringBuilder s = new StringBuilder();
		Link$ x = SQS.first();
		if(x==null) s.append("EMPTY");
		while (x != null) {
			EVENT_NOTICE$ ev = (EVENT_NOTICE$) x;
			s.append(' ').append(ev.PROC.edObjectIdent()).append('[').append(ev.EVTIME).append(']');
//			s.append('\n');
			x = x.suc();
		}
		return (s.toString());
	}

	public String toString() {
		return ("Simulation$ SQS=" + SQS);
	}

}
