package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$stryk_intern_post extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$stryk_intern_post(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$stryk_intern_post STM$() {
        ((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall$1=0;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure stryk_intern_post",1,573,14,576,18,577);
}
