package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$leggut extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$leggut(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$leggut STM$() {
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Database-navn:"));
        ((HegnaNRK$PBLK21)(CUR$.SL$)).utbase_navn$1=new HegnaNRK$PBLK21$open_utbase(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        new HegnaNRK$PBLK21$skriv_utbase(((HegnaNRK$PBLK21)(CUR$.SL$)));
        new HegnaNRK$PBLK21$lukk_utbase(((HegnaNRK$PBLK21)(CUR$.SL$)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure leggut",1,1136,14,1139,16,1140,18,1141,20,1142,24,1143);
}
