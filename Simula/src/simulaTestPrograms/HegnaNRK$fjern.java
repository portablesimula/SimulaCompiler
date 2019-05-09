package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$fjern extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$fjern(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$fjern STM$() {
        new HegnaNRK$stryk_aktuell_post(((HegnaNRK)(CUR$.SL$)));
        new HegnaNRK$stryk_intern_post(((HegnaNRK)(CUR$.SL$)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure fjern",1,753,14,756,16,757,20,758);
}
