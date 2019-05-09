package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$neste extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$neste(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$neste STM$() {
        new HegnaNRK$finn_og_hent(((HegnaNRK)(CUR$.SL$)),((HegnaNRK)(CUR$.SL$)).aktuell$1);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure neste",1,707,14,710,18,710);
}
