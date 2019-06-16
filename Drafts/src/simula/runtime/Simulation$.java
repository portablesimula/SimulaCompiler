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
    public boolean isDetachUsed() { return(true); }
    
    public static final boolean USE_NEW_SQS=true;//false;//true;
    public static final boolean DEBUG=false;//true;

	public final Head$ OLD_SQS; // = null;
	public final SequencingSet$ SQS;
	public final MAIN_PROGRAM$ main;
	
	// Constructor
	public Simulation$(RTObject$ staticLink) {
		super(staticLink);
		if(USE_NEW_SQS) {
			SQS=new SequencingSet$();
			OLD_SQS=null;
			main = (MAIN_PROGRAM$) new MAIN_PROGRAM$((Simulation$) CUR$).START$();
			main.EVENT = new EVENT_NOTICE$(0, main);
			SQS.add(main.EVENT,false);
		} else {
			OLD_SQS = (Head$) new Head$(Simulation$.this).STM$();
			SQS=null;
			main = (MAIN_PROGRAM$) new MAIN_PROGRAM$((Simulation$) CUR$).START$();
			main.xEVENT = (OLD_EVENT_NOTICE$) new OLD_EVENT_NOTICE$((Simulation$) CUR$, 0, main).STM$();
			main.xEVENT.into(OLD_SQS);
		}
	}

	public Simulation$ STM$() {
//		OLD_SQS = (Head$) new Head$(Simulation$.this).STM$();
//		main = (MAIN_PROGRAM$) new MAIN_PROGRAM$((Simulation$) CUR$).START$();
//		main.EVENT = (EVENT_NOTICE$) new EVENT_NOTICE$((Simulation$) CUR$, 0, main).STM$();
//		main.EVENT.into(OLD_SQS);
        EBLK();
		return(this);
	}

	public double time() {
		if(USE_NEW_SQS) {
			return (SQS.first().EVTIME);			
		}
		return (FIRSTEV().EVTIME);
	}

	private OLD_EVENT_NOTICE$ FIRSTEV() {
		OLD_EVENT_NOTICE$ FIRSTEV = ((OLD_EVENT_NOTICE$) (OLD_SQS.first()));
		return (FIRSTEV);
	}

//	private EVENT_NOTICE$ NEW_FIRSTEV() {
//		EVENT_NOTICE$ FIRSTEV = SQS.first();
//		return (FIRSTEV);			
//	}

	/*
	 * <pre>
	 * ref (process) procedure current; current :- FIRSTEV.PROC;
	 * </pre>
	 */
	public Process$ current() {
		if(USE_NEW_SQS) {
			return (SQS.first().PROC);			
		}
		return (FIRSTEV().PROC);
	}

	public void hold(final double T) {
		if(USE_NEW_SQS) {
			NEW_hold(T); return;
		}
		SIM_TRACE("Hold " + T);
		OLD_EVENT_NOTICE$ first = FIRSTEV();
		if (first != null) {
			if (T > 0)
				first.EVTIME = first.EVTIME + T;
			OLD_EVENT_NOTICE$ suc = first.suc();
			if (suc != null) {
				if (suc.EVTIME <= first.EVTIME) {
					first.out();
					first.RANK(false);
					resume(current());
				}
			}
		}
	}

	public void NEW_hold(final double T) {
		SIM_TRACE("Hold " + T);
		EVENT_NOTICE$ first = SQS.pollFirst();
		if (first != null) {
			if (T > 0) first.EVTIME = first.EVTIME + T;
			EVENT_NOTICE$ suc = SQS.first();
			SQS.add(first,false);
			if (suc != null) {
				if (suc.EVTIME <= first.EVTIME) {
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
	public void passivate() {
		Process$ nxtcur = passivate1();
		SIM_TRACE("END Passivate Resume[" + nxtcur.edObjectIdent() + ']');
		resume(nxtcur);
		SIM_TRACE("END Passivate AFTER Resume[" + nxtcur.edObjectIdent() + ']');
	}
	
	Process$ passivate1() { // Used directly by Process$.TERMINATE
		Process$ cur = current();
		SIM_TRACE("Passivate " + cur.edObjectIdent());
		// RT.println("Passivate: "+cur.edObjectIdent()+", SQS="+this.edSQS());
		if(USE_NEW_SQS) {
			if (cur != null) {
				SQS.remove(cur.EVENT);
				cur.EVENT = null;
			}
			if (SQS.isEmpty())
				throw new RuntimeException("Cancel,Passivate or Wait empties SQS");

		} else {
			if (cur != null) {
				cur.xEVENT.out();
				cur.xEVENT = null;
			}
			if (OLD_SQS.empty())
				throw new RuntimeException("Cancel,Passivate or Wait empties SQS");
		}
		Process$ nxtcur = current();
		// RT.println("END Passivate: next current="+nxtcur.edObjectIdent()+", SQS="+this.edSQS());
		return(nxtcur);
	}

	public void wait(final Head$ S) {
		SIM_TRACE("Wait in Queue " + S);
		current().into(S);
		passivate();
	}

	public void cancel(final Process$ x) {
		SIM_TRACE("Cancel " + x);
		if(USE_NEW_SQS) {
			if (x == current())	passivate();
			else if (x != null && x.EVENT != null) {
				SQS.remove(x.EVENT);
				x.EVENT = null;
			}
		} else {
			if (x == current())	passivate();
			else if (x != null && x.xEVENT != null) {
				x.xEVENT.out();
				x.xEVENT = null;
			}
		}
	}

	/**
	 * <pre>
	 * procedure accum (a,b,c,d);  name a,b,c;  long real a,b,c,d;
	       begin
	          a:= a+c * (time-b);  b:= time;  c:= c + d
	       end accum;
	 * </pre>
	 * 
	 * A statement of the form "accum (A,B,C,D)" may be used to accumulate the
	 * "system time integral" of the variable C, interpreted as a step function of
	 * system time. The integral is accumulated in the variable A. The variable B
	 * contains the system time at which the variables were last updated. The value
	 * of D is the current increment of the step function.
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 */
	public void accum(final NAME$<Double> a,final NAME$<Double> b,final NAME$<Double> c,final double d) {
		a.put(a.get() + (c.get() * (time() - b.get())));
		b.put(time());
		c.put(c.get() + d);
	}

	public void ActivateDirect(final boolean REAC,final Process$ X) {
		if (X == null)
			TRACE_ACTIVATE(REAC, "none");
		else if (X.STATE$ == OperationalState.terminated)
			TRACE_ACTIVATE(REAC, "terminated process");
		else if (X.xEVENT != null && !REAC)
			TRACE_ACTIVATE(REAC, "scheduled process");
		else if (X.EVENT != null && !REAC)
			TRACE_ACTIVATE(REAC, "scheduled process");
		else {
			TRACE_ACTIVATE(REAC, X.edObjectIdent());
			Process$ z;
			if(USE_NEW_SQS) {
				EVENT_NOTICE$ EV = null;
				if (REAC) EV = X.EVENT;
				else if (X.EVENT != null) return;
				z = current();
				X.EVENT = new EVENT_NOTICE$(time(), X);
				//X.EVENT.precede(FIRSTEV());
				SQS.add(X.EVENT,true);
				if (EV != null) {
					//EV.out();
					SQS.remove(EV);
					if (SQS.isEmpty())
						throw new RuntimeException("(Re)Activate empties SQS.");
				}

			} else {
				OLD_EVENT_NOTICE$ EV = null;
				if (REAC) EV = X.xEVENT;
				else if (X.xEVENT != null) return;
				z = current();
				X.xEVENT = (OLD_EVENT_NOTICE$) new OLD_EVENT_NOTICE$(this, (float) time(), X).STM$();
				X.xEVENT.precede(FIRSTEV());
				if (EV != null) {
					EV.out();
					if (OLD_SQS.empty())
						throw new RuntimeException("(Re)Activate empties SQS.");
				}
			}
			if (z != current())
				resume(current());
		}
	}

	public void ActivateDelay(final boolean REAC,final Process$ X,final double T,final boolean PRIO) {
		ActivateAt(REAC, X, time() + T, PRIO);
	}

	public void ActivateAt(final boolean REAC,final Process$ X,double T,final boolean PRIO) {
		if (X == null)
			TRACE_ACTIVATE(REAC, "none");
		else if (X.STATE$ == OperationalState.terminated)
			TRACE_ACTIVATE(REAC, "terminated process");
		else if (X.xEVENT != null && !REAC)
			TRACE_ACTIVATE(REAC, "scheduled process");
		else if (X.EVENT != null && !REAC)
			TRACE_ACTIVATE(REAC, "scheduled process");
		else {
			TRACE_ACTIVATE(REAC, X.edObjectIdent() + " at " + T + ((PRIO) ? "prior" : ""));
			Process$ z;
			
			if(USE_NEW_SQS) {
				EVENT_NOTICE$ EV = null;
				if (REAC) EV = X.EVENT;
				else if (X.EVENT != null) return;
				z = current();
				if (T < time())	T = time();
				X.EVENT = new EVENT_NOTICE$(T, X);
				SQS.add(X.EVENT,PRIO);
				if (EV != null) {
					SQS.remove(EV);
					if (SQS.isEmpty())
						throw new RuntimeException("(Re)Activate empties SQS.");
				}
			} else {
				OLD_EVENT_NOTICE$ EV = null;
				if (REAC) EV = X.xEVENT;
				else if (X.xEVENT != null) return;
				z = current();
				if (T < time())	T = time();
				X.xEVENT = (OLD_EVENT_NOTICE$) new OLD_EVENT_NOTICE$(this, (float) T, X).STM$();
				if (T == time() && PRIO)
					X.xEVENT.precede(FIRSTEV());
				else
					X.xEVENT.RANK(PRIO);
				if (EV != null) {
					EV.out();
					if (OLD_SQS.empty())
						throw new RuntimeException("(Re)Activate empties SQS.");
				}
			}
			
			if (z != current())	resume(current());
		}
	}

	public void ActivateBefore(final boolean REAC,final Process$ X,final Process$ Y) {
		ACTIVATE3(REAC, X, true, Y);
	}

	public void ActivateAfter(final boolean REAC,final Process$ X,final Process$ Y) {
		ACTIVATE3(REAC, X, false, Y);
	}

	private void ACTIVATE3(final boolean REAC,final Process$ X,final boolean BEFORE,final Process$ Y) {
		if(USE_NEW_SQS) {
			NEW_ACTIVATE3(REAC,X,BEFORE,Y); 
			return;
		}
		if (X == null)
			TRACE_ACTIVATE(REAC, " none");
		else if (X.STATE$ == OperationalState.terminated)
			TRACE_ACTIVATE(REAC, " terminated process");
		else if (X.xEVENT != null && !REAC)
			TRACE_ACTIVATE(REAC, " scheduled process");
		else if (X == Y)
			TRACE_ACTIVATE(REAC, " before/after itself");
		else {
			TRACE_ACTIVATE(REAC, X.edObjectIdent() + ((BEFORE) ? " BEFORE " : " AFTER ") + Y.edObjectIdent());
			Process$ z;
			OLD_EVENT_NOTICE$ EV = null;
			if (REAC) EV = X.xEVENT;
			else if (X.xEVENT != null) return;
			z = current();
			if (Y == null || Y.xEVENT == null) X.xEVENT = null;
			else {
				if (X == Y)	return; // reactivate X before/after X;
				X.xEVENT = (OLD_EVENT_NOTICE$) new OLD_EVENT_NOTICE$(this, (float) Y.xEVENT.EVTIME, X).STM$();
				if (BEFORE)
					X.xEVENT.precede(Y.xEVENT);
				else X.xEVENT.follow(Y.xEVENT);
			}
			if (EV != null) {
				EV.out();
				if (OLD_SQS.empty())
					throw new RuntimeException("(Re)Activate empties SQS.");					
			}
			if (z != current())
			{ Process$ nxtcur=current();
			    SIM_TRACE("END ACTIVATE3 Resume["+nxtcur.edObjectIdent()+']');
				resume(nxtcur);
			} else SIM_TRACE("END ACTIVATE3 Continue["+z.edObjectIdent()+']');

		}
	}

	private void NEW_ACTIVATE3(final boolean REAC,final Process$ X,final boolean BEFORE,final Process$ Y) {
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
			if (REAC) EV = X.EVENT;
			else if (X.EVENT != null) return;
			z = current();
			if (Y == null || Y.EVENT == null) X.EVENT = null;
			else {
				if (X == Y)	return; // reactivate X before/after X;
				double EVTIME=Y.EVENT.EVTIME;
				X.EVENT = new EVENT_NOTICE$(EVTIME, X);
				SQS.add(X.EVENT,BEFORE);
			}
			if (EV != null) {
				SQS.remove(EV);
				if (SQS.isEmpty())
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

	private void TRACE_ACTIVATE(final boolean REAC,final String msg) {
		String act = (REAC) ? "REACTIVATE " : "ACTIVATE ";
		SIM_TRACE(act + msg);

	}

	public void SIM_TRACE(final String msg) {
		//checkSQS();
		if (RT.Option.SML_TRACING) {
			Thread thread = Thread.currentThread();
			RT.println(thread.toString() + ": Time=" + time() + "  " + msg +", SQS="+ edSQS());
		}
	}

//	private String checkSQS() {
//		StringBuilder s = new StringBuilder();
//		Link$ x = SQS.first();
//		s.append(", SQS =");
//		while (x != null) {
//			EVENT_NOTICE$ ev = (EVENT_NOTICE$) x;
//			if(ev.PROC.STATE$==OperationalState.terminated)
//				throw new RuntimeException("SQS CONTAIN TERMINATED ELEMENT: "+ev.PROC);
//			x = x.suc();
//		}
//		return (s.toString());
//	}

	private String edSQS() {
		if(USE_NEW_SQS) return(SQS.edNEW_SQS());
		//checkSQS();
		StringBuilder s = new StringBuilder();
		Link$ x = OLD_SQS.first();
		if(x==null) s.append("EMPTY");
		while (x != null) {
			OLD_EVENT_NOTICE$ ev = (OLD_EVENT_NOTICE$) x;
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
