package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$sortermengde extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$sortermengde(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$sortermengde STM$() {
        if(VALUE$((((HegnaNRK)(CUR$.SL$)).mengde$1==(null)))) {
            new HegnaNRK$feil(((HegnaNRK)(CUR$.SL$)),18);
        } else
        new HegnaNRK$sortermengde$SubBlock1381(CUR$).STM$();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure sortermengde",1,1376,14,1379,16,1380,19,1393,23,1394);
}
