package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 17:37:32 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst121$PBLK35 extends Simulation$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    simtst121$p$simtst121$PBLK35$Car car1$2=null;
    public simtst121$PBLK35(RTObject$ staticLink) {
        super(staticLink);
    }
    public simtst121$PBLK35 STM$() {
        new simtst121$trace(((simtst121)(CUR$.SL$.SL$)),new TXT$("START SIMULATION"));
        car1$2=((simtst121$p$simtst121$PBLK35$Car)new simtst121$p$simtst121$PBLK35$Car(((simtst121$PBLK35)CUR$),new TXT$("Bil 1")).START$());
        new simtst121$trace(((simtst121)(CUR$.SL$.SL$)),CONC(car1$2.p3$pname,new TXT$(" is scheduled for 4.0")));
        ((simtst121$PBLK35)CUR$).ActivateAt(false,car1$2,4.0f,false);
        hold(((double)(12)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst121.sim","PrefixedBlock simtst121$PBLK35",1,35,15,49,17,50,19,51,21,52,23,53,27,55);
}
