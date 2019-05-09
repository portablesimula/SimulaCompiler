package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$endre extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$endre(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$endre STM$() {
        if(VALUE$((((HegnaNRK)(CUR$.SL$)).aktuell$1!=(0)))) {
            {
                new HegnaNRK$endre_intern_post(((HegnaNRK)(CUR$.SL$)));
                new HegnaNRK$stryk_aktuell_post(((HegnaNRK)(CUR$.SL$)));
                new HegnaNRK$skriv_intern_post(((HegnaNRK)(CUR$.SL$)));
            }
        } else
        new HegnaNRK$feil(((HegnaNRK)(CUR$.SL$)),10);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure endre",1,601,14,604,16,606,19,607,21,608,25,610,29,611);
}
