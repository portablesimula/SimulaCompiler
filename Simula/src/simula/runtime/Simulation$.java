/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import simula.compiler.utilities.Util;


public class Simulation$ extends Simset$ {
	public boolean isDetachable() { return(true); } 
	public Head$ SQS = null;
	public MAIN_PROGRAM$ main = null;

	// Constructor
    public Simulation$(RTObject$ staticLink) {
      super(staticLink);
      // Create Class Body
      CODE$=new ClassBody(CODE$,this) {
         public void STM() {
         	Util.BREAK("Simulation$ Before INNER");
     		Util.BREAK("Simulation$.STM: SQS="+SQS);
        	SQS=(Head$)new Head$(Simulation$.this).STM();
     		Util.BREAK("Simulation$.STM: SQS="+SQS);
            main=(MAIN_PROGRAM$)new MAIN_PROGRAM$((Simulation$)CUR$).START();
            main.EVENT=new EVENT_NOTICE$((Simulation$)CUR$,0,main);
            main.EVENT.into(SQS);
            if(inner!=null) inner.STM();
         	Util.BREAK("Simulation$ After INNER");
      }};
    }
    public Simulation$ STM() { return((Simulation$)CODE$.EXEC$()); }
    public Simulation$ START() { START(this); return(this); }
		
	public double time() { return(FIRSTEV().EVTIME); }
	
	public EVENT_NOTICE$ FIRSTEV() {
		Util.BREAK("Simulation$.FIRSTEV: SQS="+SQS);
		EVENT_NOTICE$ FIRSTEV = ((EVENT_NOTICE$) (SQS.first()));
		Util.BREAK("Simulation$.FIRSTEV: "+FIRSTEV);
		Util.BREAK("Simulation$.FIRSTEV: "+FIRSTEV.getClass().getSimpleName());
		return (FIRSTEV);
	}

	public Process$ current() {
		return(FIRSTEV().PROC);
	}

	public void hold(double T) {
		SIM_TRACE("Hold "+T);
		EVENT_NOTICE$ first=FIRSTEV();
		if(first!=null) { 
			if(T>0) first.EVTIME=first.EVTIME + T;
			EVENT_NOTICE$ suc=first.suc();
			if(suc!=null) {
				if(suc.EVTIME <= first.EVTIME) {
					first.out();
					first.RANK(false);
					resume(current());
				}
			}
		}
	}

	public void passivate() {
		SIM_TRACE("Passivate");
		Util.BREAK("Passivate "+this);
		Process$ cur=current();
		Util.BREAK("Passivate: current="+cur);
		Util.BREAK("Passivate: current.EVENT="+cur.EVENT);
//		if(current()!=null) { current().EVENT.out(); current().EVENT =null;	}
		if(cur!=null) { cur.EVENT.out(); cur.EVENT =null;	}
        if(SQS.empty()) throw new RuntimeException("Cancel,Passivate or Wait empties SQS");
		resume(current());
	}

	public void wait(Head$ S) {
		SIM_TRACE("Wait in Queue "+S);
		current().into(S);
		passivate();
	}

	public void cancel(Process$ x) {
		SIM_TRACE("Cancel "+x);
		if(x==current()) passivate();
		else if(x!=null && x.EVENT!=null)
		{ x.EVENT.out(); x.EVENT=null; }
	}



  public void TRC_SML(int code,RTObject$ ent)
  { //label lsc; lsc:=curins.lsc;
    //  curins.lsc:=envir_OUTERMOST; status:=0;
    //bio.obs_evt=EVT_SML; call PSIMOB(smb)(code,ent,none);
    //  curins.lsc:=lsc;
  }

  
  private void TRACE_ACTIVATE(boolean REAC,String msg)
  { String act=(REAC)?"REACTIVATE ":"ACTIVATE ";
	  SIM_TRACE(act+msg);
	  
  }
  
  public void ActivateDirect(boolean REAC, Process$ X)
  { if(X==null) TRACE_ACTIVATE(REAC,"none"); // (re)activate none
	else if(X.STATE$==OperationalState.terminated)
	     TRACE_ACTIVATE(REAC,"terminated process"); // (re)activate none
	else if(X.EVENT!=null && !REAC)
	     TRACE_ACTIVATE(REAC,"scheduled process"); // (re)activate none
	else
    { TRACE_ACTIVATE(REAC,X.toString()); // (re)activate X
	  Process$ z; EVENT_NOTICE$ EV=null;
      if(REAC) EV=X.EVENT;
      else if(X.EVENT!=null) return;
      z=current();
      X.EVENT=new EVENT_NOTICE$(this,(float)time(),X);
      X.EVENT.precede(FIRSTEV());
      //if bio.trc
      //   then TRC_SML(if REAC then SML_RACT else SML_ACTI,X) endif;
    if(EV!=null)
    { EV.out(); if(SQS.empty()) throw new RuntimeException("(Re)Activate empties SQS."); }
      if(z!=current()) resume(current());
    }
  }
	 

  public void ActivateDelay(boolean REAC, Process$ X, double T, boolean PRIO)
  {	ActivateAt(REAC, X, time()+T, PRIO); }
  
  public void ActivateAt(boolean REAC, Process$ X, double T, boolean PRIO)
  { //inspect X do if not TERMINATED then
    //else
    if(X==null)
    { //if(bio.trc) //  --- (re)activate none
      //   TRC_SML(if reac then SML_RAC1 else SML_ACT1,x);
    }
    else if(X.STATE$==OperationalState.terminated)
    { //if bio.trc  --- (re)activate terminated process
      //then TRC_SML(if reac then SML_RAC2 else SML_ACT2,x) endif;
    }
    else if(X.EVENT!=null && !REAC)
    { // if bio.trc  --- activate scheduled process
      //       then TRC_SML(SML_ACT3,x) endif;
    }
    else
    { Process$ z; EVENT_NOTICE$ EV=null;
      if(REAC) EV=X.EVENT;
      else if(X.EVENT!=null) return;
      z=current();
      if(T < time()) T=time();
      X.EVENT=new EVENT_NOTICE$(this,(float)T, X);
      if(T==time() && PRIO) X.EVENT.precede(FIRSTEV());
      else X.EVENT.RANK(PRIO);
      //if bio.trc
      //   then TRC_SML(if REAC then SML_RACT else SML_ACTI,X) endif;
      if(EV!=null)
      { EV.out(); if(SQS.empty()) throw new RuntimeException("(Re)Activate empties SQS."); }
      if(z!=current()) resume(current());
    }
  }


  public void ActivateBefore(boolean REAC,Process$ X,Process$ Y){ACTIVATE3(REAC,X,true,Y);}
  public void ActivateAfter(boolean REAC,Process$ X,Process$ Y){ACTIVATE3(REAC,X,false,Y);}
  
  public void ACTIVATE3(boolean REAC, Process$ X, boolean BEFORE, Process$ Y)
  { //inspect X do if not TERMINATED then
	//else
	if(X==null)
	{ //if(bio.trc) //  --- (re)activate none
	  //   TRC_SML(if reac then SML_RAC1 else SML_ACT1,x);
	}
	else if(X.STATE$==OperationalState.terminated)
	{ //if bio.trc  --- (re)activate terminated process
	  //then TRC_SML(if reac then SML_RAC2 else SML_ACT2,x) endif;
	}
	else if(X.EVENT!=null && !REAC)
	{ // if bio.trc  --- activate scheduled process
	  //       then TRC_SML(SML_ACT3,x) endif;
	}
	else if(X==Y)
	{ //if bio.trc  --- reactivate  x  before/after  x
	  //    then TRC_SML(SML_RAC3,x) endif;
	}
	else
    { Process$ z; EVENT_NOTICE$ EV=null;
      if(REAC) EV=X.EVENT;
      else if(X.EVENT!=null) return;
      z=current();
 	  if(Y == null || Y.EVENT == null) X.EVENT=null;
      else
      { if(X==Y) return; // reactivate X before/after X;
        X.EVENT=new EVENT_NOTICE$(this,(float)Y.EVENT.EVTIME, X);
        if(BEFORE)
             X.EVENT.precede(Y.EVENT);
        else X.EVENT.follow(Y.EVENT);
        //if(bio.trc) TRC_SML(if REAC then SML_RACT else SML_ACTI,X);
      } //end before or after;
      if(EV!=null)
      { EV.out(); if(SQS.empty()) throw new RuntimeException("(Re)Activate empties SQS."); }
      if(z!=current()) resume(current());
    }
  }

  // Complete ACTIVATE Method for reference:
//  private void ACTIVATE(boolean REAC, Process$ X, ActivationCode CODE, double T, Process$ Y, boolean PRIO)
//  { //inspect X do if not TERMINATED then
//	//else
//	if(X==null)
//	{ //if(bio.trc) //  --- (re)activate none
//	  //   TRC_SML(if reac then SML_RAC1 else SML_ACT1,x);
//	}
//	else if(X.STATE$==OperationalState.terminated)
//	{ //if bio.trc  --- (re)activate terminated process
//	  //then TRC_SML(if reac then SML_RAC2 else SML_ACT2,x) endif;
//	}
//	else if(X.EVENT!=null && !REAC)
//	{ // if bio.trc  --- activate scheduled process
//	  //       then TRC_SML(SML_ACT3,x) endif;
//	}
//	else if(X==Y)
//	{ //if bio.trc  --- reactivate  x  before/after  x
//	  //    then TRC_SML(SML_RAC3,x) endif;
//	}
//	else
//    { Process$ z; EVENT_NOTICE$ EV=null;
//      if(REAC) EV=X.EVENT;
//      else if(X.EVENT!=null) return;
//      z=current();
//      switch(CODE)
//      { case direct:
//           X.EVENT=new EVENT_NOTICE$(this,(float)time(),X);
//           X.EVENT.precede(FIRSTEV());
//     	   //if bio.trc
//     	   //   then TRC_SML(if REAC then SML_RACT else SML_ACTI,X) endif;
//           break;     
//        case delay: T= T + time(); // intentionally no break;
//        case at:
//           if(T < time()) T=time();
//           X.EVENT=new EVENT_NOTICE$(this,(float)T, X);
//           if(T==time() && PRIO) X.EVENT.precede(FIRSTEV());
//           else X.EVENT.RANK(PRIO);
//     	   //if bio.trc
//     	   //   then TRC_SML(if REAC then SML_RACT else SML_ACTI,X) endif;
//           break;         
//        case before:
//        case after:
//    	   if(Y == null || Y.EVENT == null) X.EVENT=null;
//           else
//           { if(X==Y) return; // reactivate X before/after X;
//             X.EVENT=new EVENT_NOTICE$(this,(float)Y.EVENT.EVTIME, X);
//             if(CODE==ActivationCode.before)
//                  X.EVENT.precede(Y.EVENT);
//             else X.EVENT.follow(Y.EVENT);
//       	     //if(bio.trc) TRC_SML(if REAC then SML_RACT else SML_ACTI,X);
//           } //end before or after;
//      }
//         
//      if(EV!=null)
//      { EV.out(); if(SQS.empty()) throw new RuntimeException("(Re)Activate empties SQS."); }
//      if(z!=current()) resume(current());
//    }
//  }
  
	
	// *********************************************************************
	// *** TRACING AND DEBUGGING UTILITIES
	// *********************************************************************
	
	public void SIM_TRACE(String msg)
	{ Thread thread=Thread.currentThread(); 
	  System.out.println(thread.toString()+": Time="+time()+"  "+msg);
	}

	public String toString()
	{ return("Simulation$ SQS="+SQS); }


}
