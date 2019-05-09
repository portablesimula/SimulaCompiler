package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$tainn extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$tainn(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$tainn STM$() {
        new HegnaNRK$lede_tekst(((HegnaNRK)(CUR$.SL$)),new TXT$("Database-navn:"));
        ((HegnaNRK)(CUR$.SL$)).innbase_navn$1=new HegnaNRK$open_innbase(((HegnaNRK)(CUR$.SL$))).RESULT$;
        new HegnaNRK$hent_innbase(((HegnaNRK)(CUR$.SL$)));
        new HegnaNRK$lukk_innbase(((HegnaNRK)(CUR$.SL$)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure tainn",1,1127,14,1130,16,1131,18,1132,20,1133,24,1134);
}
