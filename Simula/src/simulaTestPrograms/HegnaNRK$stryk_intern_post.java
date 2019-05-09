package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$stryk_intern_post extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$stryk_intern_post(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$stryk_intern_post STM$() {
        ((HegnaNRK)(CUR$.SL$)).felt_antall$1=0;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure stryk_intern_post",1,573,14,576,18,577);
}
