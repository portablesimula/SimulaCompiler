package simula.runtime;

import simula.compiler.utilities.Util;

public class Process$ extends Link$ {
	public boolean isDetachable() { return(true); }
	public EVENT_NOTICE$ EVENT = null;
	public boolean TERMINATED_ = false;

	// Constructor
    public Process$(RTObject$ staticLink) {
       super(staticLink);
       CODE$=new ClassBody(CODE$,this) {
          public void STM() {
             Util.BREAK("Process$ Before INNER");
             detach();
             if(inner!=null) inner.STM();
             Util.BREAK("Process$ After INNER");
             TERMINATED_=true;
//             ((Simulation$)CV$[1]).passivate();
             ((Simulation$)SL$).passivate();
     		 throw new RuntimeException("INTERNAL error:  Process passes through final end.");
       }};
    }
    public Process$ STM() { return((Process$)CODE$.EXEC$()); }
    public Process$ START() { START(this); return(this); }
    

	public boolean idle() {
		return (EVENT == null);
	}

	public boolean terminated() {
		return (TERMINATED_);
	}

	public double evtime() {
		if(idle()) throw new RuntimeException("Process.Evtime:  The process is idle.");
		return(EVENT.EVTIME);
	}

	public Process$ nextev() {
	    if(idle()) return(null);
		EVENT_NOTICE$ suc=EVENT.suc();
		if(suc==null) return(null);
		return(suc.PROC);
	}

	
	public String toString()
	{ return("Process$("+this.getClass().getSimpleName()+") TERMINATED_="+TERMINATED_); }

}
