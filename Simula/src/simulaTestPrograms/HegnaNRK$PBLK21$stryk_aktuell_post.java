package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$stryk_aktuell_post extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$stryk_aktuell_post(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$stryk_aktuell_post STM$() {
        if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).aktuell$1!=(0)))) {
            {
                ((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).aktuell$1-((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.LB[0]]=null;
                ((HegnaNRK$PBLK21)(CUR$.SL$)).aktuell$1=0;
                ((HegnaNRK$PBLK21)(CUR$.SL$)).antall_poster$1=(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_poster$1-(1));
            }
        } else
        new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),10);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure stryk_aktuell_post",1,825,14,828,16,830,19,831,21,832,25,834,29,835);
}
