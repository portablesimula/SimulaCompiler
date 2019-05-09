package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$stryk_finne_regel extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$stryk_finne_regel(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$stryk_finne_regel STM$() {
        ((HegnaNRK)(CUR$.SL$)).finne_regel_antall$1=0;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure stryk_finne_regel",1,774,14,777,18,778);
}
