package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$trykk extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$trykk(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$trykk STM$() {
        sysout().outimage();
        new HegnaNRK$PBLK21$skjerm_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure trykk",1,747,14,749,16,750,20,751);
}
