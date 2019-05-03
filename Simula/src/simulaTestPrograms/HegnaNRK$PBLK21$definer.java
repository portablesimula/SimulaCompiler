package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$definer extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$definer(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$definer STM$() {
        ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn$1=new HegnaNRK$PBLK21$les_register(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure definer",1,462,14,465,18,466);
}
