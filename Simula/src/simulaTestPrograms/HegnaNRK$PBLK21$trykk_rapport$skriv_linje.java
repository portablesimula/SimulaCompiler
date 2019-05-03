package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$trykk_rapport$skriv_linje extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$trykk_rapport$skriv_linje(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$trykk_rapport$skriv_linje STM$() {
        ((HegnaNRK$PBLK21$trykk_rapport)(CUR$.SL$)).felt_linje=(((HegnaNRK$PBLK21$trykk_rapport)(CUR$.SL$)).felt_linje+(1));
        sysout().outimage();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure skriv_linje",1,1094,14,1096,16,1097,20,1098);
}
