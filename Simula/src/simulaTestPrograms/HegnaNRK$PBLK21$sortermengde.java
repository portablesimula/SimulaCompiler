package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$sortermengde extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$sortermengde(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$sortermengde STM$() {
        if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).mengde$1==(null)))) {
            new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),18);
        } else
        new HegnaNRK$PBLK21$sortermengde$SubBlock1381(CUR$).STM$();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure sortermengde",1,1376,14,1379,16,1380,19,1393,23,1394);
}
