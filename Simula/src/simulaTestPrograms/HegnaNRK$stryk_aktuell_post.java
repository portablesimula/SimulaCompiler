package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$stryk_aktuell_post extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$stryk_aktuell_post(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$stryk_aktuell_post STM$() {
        if(VALUE$((((HegnaNRK)(CUR$.SL$)).aktuell$1!=(0)))) {
            {
                ((HegnaNRK)(CUR$.SL$)).post_peker.Elt[((HegnaNRK)(CUR$.SL$)).aktuell$1-((HegnaNRK)(CUR$.SL$)).post_peker.LB[0]]=null;
                ((HegnaNRK)(CUR$.SL$)).aktuell$1=0;
                ((HegnaNRK)(CUR$.SL$)).antall_poster$1=(((HegnaNRK)(CUR$.SL$)).antall_poster$1-(1));
            }
        } else
        new HegnaNRK$feil(((HegnaNRK)(CUR$.SL$)),10);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure stryk_aktuell_post",1,825,14,828,16,830,19,831,21,832,25,834,29,835);
}
