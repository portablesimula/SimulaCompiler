package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$avslutt_databasen extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$avslutt_databasen(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$avslutt_databasen STM$() {
        new HegnaNRK$PBLK21$slutt_melding(((HegnaNRK$PBLK21)(CUR$.SL$)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure avslutt_databasen",1,300,14,303,18,304);
}
