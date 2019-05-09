package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$hent extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int pnr=0;
    public HegnaNRK$hent(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$hent STM$() {
        new HegnaNRK$lede_tekst(((HegnaNRK)(CUR$.SL$)),new TXT$("Post nummer:"));
        pnr=new HegnaNRK$sikker_inint(((HegnaNRK)(CUR$.SL$))).RESULT$;
        if(VALUE$(((pnr<=(0))|((pnr>(((HegnaNRK)(CUR$.SL$)).max_antall_poster$1)))))) {
            new HegnaNRK$feil(((HegnaNRK)(CUR$.SL$)),11);
        } else
        {
            new HegnaNRK$hent_post(((HegnaNRK)(CUR$.SL$)),pnr);
            if(VALUE$((((HegnaNRK)(CUR$.SL$)).aktuell$1!=(pnr)))) {
                new HegnaNRK$feil(((HegnaNRK)(CUR$.SL$)),12);
            } else
            new HegnaNRK$skjerm_intern_post(((HegnaNRK)(CUR$.SL$)));
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure hent",1,712,8,714,16,715,18,716,20,717,22,718,25,720,28,721,30,722,37,724);
}
