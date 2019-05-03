package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$fjern extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$fjern(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$fjern STM$() {
        new HegnaNRK$PBLK21$stryk_aktuell_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
        new HegnaNRK$PBLK21$stryk_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure fjern",1,753,14,756,16,757,20,758);
}
