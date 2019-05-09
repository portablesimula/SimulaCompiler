package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$avslutt_databasen extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$avslutt_databasen(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$avslutt_databasen STM$() {
        new HegnaNRK$slutt_melding(((HegnaNRK)(CUR$.SL$)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure avslutt_databasen",1,300,14,303,18,304);
}
