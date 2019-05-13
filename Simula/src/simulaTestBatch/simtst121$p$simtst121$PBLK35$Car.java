package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 17:37:32 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst121$p$simtst121$PBLK35$Car extends Process$ {
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    public TXT$ p3$pname;
    public simtst121$p$simtst121$PBLK35$Car(RTObject$ staticLink,TXT$ sp3$pname) {
        super(staticLink);
        this.p3$pname = sp3$pname;
        TRACE_BEGIN_DCL$("Car",37);
    }
    public simtst121$p$simtst121$PBLK35$Car STM$() {
        detach();
        new simtst121$trace(((simtst121)(CUR$.SL$.SL$.SL$)),CONC(p3$pname,new TXT$(" is initiating")));
        while(true) {
            {
                new simtst121$trace(((simtst121)(CUR$.SL$.SL$.SL$)),CONC(p3$pname,new TXT$(" is active 1")));
                ((simtst121$PBLK35)(CUR$.SL$)).hold(((double)(4)));
                new simtst121$trace(((simtst121)(CUR$.SL$.SL$.SL$)),CONC(p3$pname,new TXT$(" is active 2")));
                GOTO$(((simtst121)(CUR$.SL$.SL$.SL$)).EXIT_LABEL);
            }
            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
        }
        terminate();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst121.sim","Class Car",1,37,16,1,18,39,20,40,22,42,25,43,27,44,29,45,34,1,36,39,39,47);
}
