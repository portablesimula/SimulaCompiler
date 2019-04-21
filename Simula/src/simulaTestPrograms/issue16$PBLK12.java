package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:25:19 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue16$PBLK12 extends Simulation$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    final int k$2;
    int kkk$2=0;
    public issue16$PBLK12(RTObject$ staticLink) {
        super(staticLink);
        k$2=((issue16)(CUR$.SL$)).inspect$10$0.pos()-(1);
    }
    public issue16$PBLK12 STM$() {
        kkk$2=((int)((int)Math.round(sqrt(((double)(4))))));
        ((issue16)(CUR$.SL$)).inspect$10$0.setpos((((issue16)(CUR$.SL$)).inspect$10$0.pos()-(1)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("issue16.sim","PrefixedBlock issue16$PBLK12",1,12,11,13,18,13,20,15,24,17);
}
