package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$trykk extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$trykk(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$trykk STM$() {
        sysout().outimage();
        new HegnaNRK$skjerm_intern_post(((HegnaNRK)(CUR$.SL$)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure trykk",1,747,14,749,16,750,20,751);
}
