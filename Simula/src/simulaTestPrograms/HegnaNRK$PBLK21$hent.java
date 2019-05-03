package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$hent extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int pnr=0;
    public HegnaNRK$PBLK21$hent(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$hent STM$() {
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Post nummer:"));
        pnr=new HegnaNRK$PBLK21$sikker_inint(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        if(VALUE$(((pnr<=(0))|((pnr>(((HegnaNRK$PBLK21)(CUR$.SL$)).max_antall_poster$1)))))) {
            new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),11);
        } else
        {
            new HegnaNRK$PBLK21$hent_post(((HegnaNRK$PBLK21)(CUR$.SL$)),pnr);
            if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).aktuell$1!=(pnr)))) {
                new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),12);
            } else
            new HegnaNRK$PBLK21$skjerm_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure hent",1,712,8,714,16,715,18,716,20,717,22,718,25,720,28,721,30,722,37,724);
}
