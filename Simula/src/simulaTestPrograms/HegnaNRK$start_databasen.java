package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$start_databasen extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$start_databasen(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$start_databasen STM$() {
        new HegnaNRK$hilse_melding(((HegnaNRK)(CUR$.SL$)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure start_databasen",1,294,14,297,18,298);
}
