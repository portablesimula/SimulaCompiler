/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
 * System class Simulation.
 * <p>
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
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/_Simulation.java"><b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 */
public class _Simulation extends _Simset {
	/**
	 * Always true in this class.
	 */
	@Override
	public boolean isDetachUsed() {
		return (true);
	}

	/**
	 * The sequencing set.
	 */
	final _Ranking sqs;
	
	/**
	 * The main program.
	 */
	public final _MAIN_PROGRAM main_1;

	/**
	 * Create a new _Simulation.
	 * @param SL staticLink
	 */
	public _Simulation(_RTObject SL) {
		super(SL);
		sqs = new _Ranking();// ("MAIN");
		sqs.bl = sqs;
		sqs.ll = sqs;
		sqs.rl = sqs;

		main_1 = (_MAIN_PROGRAM) new _MAIN_PROGRAM((_Simulation) _CUR)._START();
		main_1.EVENT = new _EVENT_NOTICE(0, main_1);
		_Ranking.INTO(main_1.EVENT, sqs, 0);
	}

	@Override
	public _Simulation _STM() {
		EBLK();
		return (this);
	}

	private _EVENT_NOTICE SQS_FIRST() {
		return ((_EVENT_NOTICE) this.sqs.bl);
	}

//	private _EVENT_NOTICE SQS_LAST() {
//		return ((_EVENT_NOTICE) this.sqs.ll);
//	}

	/**
	 * Returns the current simulation time.
	 * <pre>
	 * 		long real procedure time; time := FIRSTEV.EVTIME;
	 * </pre>
	 * @return the current simulation time
	 */
	public double time() {
		return (SQS_FIRST().EVTIME());
	}

	/*
	 * <pre> ref (process) procedure current; current :- FIRSTEV.PROC; </pre>
	 */
	/**
	 * Returns the current process.
	 * <pre>
	 * 		ref (process) procedure current; current :- FIRSTEV.PROC;
	 * </pre>
	 * @return the current process
	 */
	public _Process current() {
		return (SQS_FIRST().PROC);
	}

	/**
	 * Procedure hold.
	 * <p>
	 * The statement "hold(T)", where T is a long real number greater than or equal to zero, halts the
	 * active phase of the currently active process object, and schedules its next active phase at the system
	 * time "time + T". The statement thus represents an inactive period of duration T. During the inactive
	 * period the reactivation point is positioned within the "hold" statement. The process object becomes
	 * suspended.
	 * <pre>
	 * 		procedure hold(T); long real T;
	 * 		inspect FIRSTEV do begin
	 * 			if T > 0 then EVTIME:= EVTIME + T;
	 * 			if suc =/= none and then suc.EVTIME &lt;= EVTIME
	 * 			then begin out; RANK_IN_SQS(false);
	 * 				resume(current)
	 * 			end if
	 * 		end hold;
	 * </pre>
	 * @param time holding time
	 */
	public void hold(double time) {
		SIM_TRACE("Hold " + time);
		_Process x = current();
		if (time > 0) {
			time = x.evtime() + time;
			x.EVENT.SET_EVTIME(time);
		} else
			time = x.evtime();

		_Ranking suc = _Ranking.SUC(x.EVENT);
		if (suc != null) {
			if (suc.rnk <= time) {
				_Ranking.INTO(x.EVENT, sqs, time);
				// simblk.cur:=suc;
				resume(current());
			}
		}
	}

	/**
	 * The procedure passivate. It stops the active phase of the currently active process object and deletes
	 * its event notice. The process object becomes passive. Its next active phase must be scheduled from
	 * outside the process object. The statement thus represents an inactive period of indefinite duration.
	 * The reactivation point of the process object is positioned within the "passivate" statement.
	 * <pre>
	 * 		procedure passivate; begin
	 * 			inspect current do begin
	 * 				EVENT.out; EVENT :- none
	 * 			end;
	 * 			if SQS.empty then error("...") else resume(current)
	 * 		end passivate;
	 * </pre>
	 */
	public void passivate() {
		_Process nxtcur = passivate1();
		SIM_TRACE("END Passivate Resume[" + nxtcur.edObjectIdent() + ']');
		resume(nxtcur);
		SIM_TRACE("END Passivate AFTER Resume[" + nxtcur.edObjectIdent() + ']');
	}

	/**
	 * Special version of 'passivate'
	 * @return next Process
	 */
	_Process passivate1() { // Used directly by Process_.TERMINATE
		_Process cur = current();
		SIM_TRACE("Passivate " + cur.edObjectIdent());
		if (cur != null) {
			_Ranking.OUT(cur.EVENT);
			cur.EVENT = null;
		}
		if (_Ranking.EMPTY(sqs))
			throw new _SimulaRuntimeError("Cancel,Passivate or Wait empties SQS");

		_Process nxtcur = current();
		return (nxtcur);
	}

	/**
	 * The procedure wait. It includes the currently active process object in a referenced set,
	 * and then calls the procedure "passivate".
	 * <pre>
	 *		procedure wait(S); ref (head) S;
	 *		begin current.into(S); passivate end wait;
	 * </pre>
	 * @param S the head of the set
	 */
	public void wait(final _Head S) {
		SIM_TRACE("Wait in Queue " + S);
		current().into(S);
		passivate();
	}

	/**
	 * The Procedure cancel.
	 * <br>
	 * The statement "cancel(X)", where X is a reference to a process object, deletes the corresponding
	 * event notice, if any. If the process object is currently active or suspended, it becomes passive.
	 * Otherwise, the statement has no effect. The statement "cancel(current)" is equivalent to "passivate".
	 * <pre>
	 *		procedure cancel(X); ref (process) X;
	 *		if X == current then passivate
	 *		else inspect X do
	 *			if EVENT =/= none
	 *			then begin EVENT.out; EVENT :- none
	 *		end cancel;
	 * </pre>
	 * @param x the argument process
	 */
	public void cancel(final _Process x) {
		SIM_TRACE("Cancel " + x);
		if (x == current())
			passivate();
		else if (x != null && x.EVENT != null) {
			_Ranking.OUT(x.EVENT);
			x.EVENT = null;
		}
	}

	/**
	 * Utility procedure accum.
	 * <pre>
	 *		procedure accum (a,b,c,d);  name a,b,c;  long real a,b,c,d;
	 *		begin
	 *			a:= a + c * (time-b);  b:= time;  c:= c + d
	 *		end accum;
	 * </pre>
	 * 
	 * A statement of the form "accum (A,B,C,D)" may be used to accumulate the
	 * "system time integral" of the variable C, interpreted as a step function of
	 * system time. The integral is accumulated in the variable A. The variable B
	 * contains the system time at which the variables were last updated. The value
	 * of D is the current increment of the step function.
	 * 
	 * @param a argument a
	 * @param b argument b
	 * @param c argument c
	 * @param d argument d
	 */
	public void accum(final _NAME<Double> a, final _NAME<Double> b, final _NAME<Double> c, final double d) {
		a.put(a.get() + (c.get() * (time() - b.get())));
		b.put(time());
		c.put(c.get() + d);
	}

	/**
	 * Direct activation: (re)activate x
	 * @param REAC signals reactivation
	 * @param X the Process to avtivate
	 */
	public void ActivateDirect(final boolean REAC, final _Process X) {
		if (X == null)
			TRACE_ACTIVATE(REAC, "none");
		else if (X.STATE_ == OperationalState.terminated)
			TRACE_ACTIVATE(REAC, "terminated process");
		else if (X.EVENT != null && !REAC)
			TRACE_ACTIVATE(REAC, "scheduled process");
		else {
			TRACE_ACTIVATE(REAC, X.edObjectIdent());
			_Process z;
			_EVENT_NOTICE EV = null;
			if (REAC)
				EV = X.EVENT;
			else if (X.EVENT != null)
				return;
			z = current();
			X.EVENT = new _EVENT_NOTICE(time(), X);
			// X.EVENT.precede(FIRSTEV());
			_Ranking.INTO(X.EVENT, sqs, X.EVENT.rnk);
			removePrevEvent(EV);
			if (z != current())
				resume(current());
		}
	}

	private void removePrevEvent(_EVENT_NOTICE EV) {
		if (EV != null) {
			// EV.out();
			_Ranking.OUT(EV);
			if (_Ranking.EMPTY(sqs))
				throw new _SimulaRuntimeError("(Re)Activate empties SQS.");
		}
	}

	/**
	 * Delayed activation: (re)activate x delay t [ prior ]
	 * @param REAC signals reactivation
	 * @param X the Process to activate
	 * @param T the delay time
	 * @param PRIO indicates priority
	 */
	public void ActivateDelay(final boolean REAC, final _Process X, final double T, final boolean PRIO) {
		ActivateAt(REAC, X, time() + T, PRIO);
	}

	/**
	 * Activate at: (re)activate x at t [ prior ]
	 * @param REAC signals reactivation
	 * @param X the Process to activate
	 * @param T the activation time
	 * @param PRIO indicates priority
	 */
	public void ActivateAt(final boolean REAC, final _Process X, double T, final boolean PRIO) {
		if (X == null)
			TRACE_ACTIVATE(REAC, "none");
		else if (X.STATE_ == OperationalState.terminated)
			TRACE_ACTIVATE(REAC, "terminated process");
		else if (X.EVENT != null && !REAC)
			TRACE_ACTIVATE(REAC, "scheduled process");
		else {
			TRACE_ACTIVATE(REAC, X.edObjectIdent() + " at " + T + ((PRIO) ? "prior" : ""));
			_Process z;
			_EVENT_NOTICE EV = null;
			if (REAC)
				EV = X.EVENT;
			else if (X.EVENT != null)
				return;
			z = current();
			if (T < time())
				T = time();
			X.EVENT = new _EVENT_NOTICE(T, X);
			if (PRIO)
				_Ranking.INTO_PRIOR(X.EVENT, sqs, T);
			else
				_Ranking.INTO(X.EVENT, sqs, T);
			removePrevEvent(EV);
			if (z != current())
				resume(current());
		}
	}

	/**
	 * Activate before: (re)Activate x before y
	 * @param REAC signals reactivation
	 * @param X the Process to activate
	 * @param Y the Process to precede 
	 */
	public void ActivateBefore(final boolean REAC, final _Process X, final _Process Y) {
		ACTIVATE3(REAC, X, true, Y);
	}

	/**
	 * Activate after: (re)Activate x after y
	 * @param REAC signals reactivation
	 * @param X the Process to activate
	 * @param Y the Process to succeed 
	 */
	public void ActivateAfter(final boolean REAC, final _Process X, final _Process Y) {
		ACTIVATE3(REAC, X, false, Y);
	}

	private void ACTIVATE3(final boolean REAC, final _Process X, final boolean BEFORE, final _Process Y) {
		if (X == null)
			TRACE_ACTIVATE(REAC, " none");
		else if (X.STATE_ == OperationalState.terminated)
			TRACE_ACTIVATE(REAC, " terminated process");
		else if (X.EVENT != null && !REAC)
			TRACE_ACTIVATE(REAC, " scheduled process");
		else if (X == Y)
			TRACE_ACTIVATE(REAC, " before/after itself");
		else {
			TRACE_ACTIVATE(REAC, X.edObjectIdent() + ((BEFORE) ? " BEFORE " : " AFTER ") + Y.edObjectIdent());
			_Process z;
			_EVENT_NOTICE EV = null;
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
				double EVTIME = Y.EVENT.EVTIME();
				X.EVENT = new _EVENT_NOTICE(EVTIME, X);
				if (BEFORE)
					_Ranking.FOLLOW(X.EVENT, Y.EVENT);
				else
					_Ranking.PRECEDE(X.EVENT, Y.EVENT);
			}
			removePrevEvent(EV);
			if (z != current()) {
				_Process nxtcur = current();
				SIM_TRACE("END ACTIVATE3 Resume[" + nxtcur.edObjectIdent() + ']');
				resume(nxtcur);
			} else
				SIM_TRACE("END ACTIVATE3 Continue[" + z.edObjectIdent() + ']');

		}
	}

	// *********************************************************************
	// *** TRACING AND DEBUGGING UTILITIES
	// *********************************************************************

	private void TRACE_ACTIVATE(final boolean REAC, final String msg) {
		String act = (REAC) ? "REACTIVATE " : "ACTIVATE ";
		SIM_TRACE(act + msg);
	}

	private void SIM_TRACE(final String msg) {
		if (_RT.Option.SML_TRACING) {
			Thread thread = Thread.currentThread();
			_RT.println(thread.toString() + ": Time=" + time() + "  " + msg + ", SQS=" + sqs);
		}
	}

	@Override
	public String toString() {
		return ("Simulation_ SQS=" + sqs);
	}

}
