package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$leggut extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$leggut(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$leggut STM$() {
        new HegnaNRK$lede_tekst(((HegnaNRK)(CUR$.SL$)),new TXT$("Database-navn:"));
        ((HegnaNRK)(CUR$.SL$)).utbase_navn$1=new HegnaNRK$open_utbase(((HegnaNRK)(CUR$.SL$))).RESULT$;
        new HegnaNRK$skriv_utbase(((HegnaNRK)(CUR$.SL$)));
        new HegnaNRK$lukk_utbase(((HegnaNRK)(CUR$.SL$)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure leggut",1,1136,14,1139,16,1140,18,1141,20,1142,24,1143);
}
