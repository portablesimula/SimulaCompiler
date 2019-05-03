package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$tainn extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$tainn(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$tainn STM$() {
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Database-navn:"));
        ((HegnaNRK$PBLK21)(CUR$.SL$)).innbase_navn$1=new HegnaNRK$PBLK21$open_innbase(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        new HegnaNRK$PBLK21$hent_innbase(((HegnaNRK$PBLK21)(CUR$.SL$)));
        new HegnaNRK$PBLK21$lukk_innbase(((HegnaNRK$PBLK21)(CUR$.SL$)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure tainn",1,1127,14,1130,16,1131,18,1132,20,1133,24,1134);
}
