package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$definer extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$definer(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$definer STM$() {
        ((HegnaNRK)(CUR$.SL$)).feltnavn$1=new HegnaNRK$les_register(((HegnaNRK)(CUR$.SL$))).RESULT$;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure definer",1,462,14,465,18,466);
}
