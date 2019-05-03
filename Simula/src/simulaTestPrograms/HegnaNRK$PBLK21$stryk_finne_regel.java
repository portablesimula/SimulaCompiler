package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$stryk_finne_regel extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$stryk_finne_regel(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$stryk_finne_regel STM$() {
        ((HegnaNRK$PBLK21)(CUR$.SL$)).finne_regel_antall$1=0;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure stryk_finne_regel",1,774,14,777,18,778);
}
