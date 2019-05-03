package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$endre extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$endre(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$endre STM$() {
        if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).aktuell$1!=(0)))) {
            {
                new HegnaNRK$PBLK21$endre_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
                new HegnaNRK$PBLK21$stryk_aktuell_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
                new HegnaNRK$PBLK21$skriv_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
            }
        } else
        new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),10);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure endre",1,601,14,604,16,606,19,607,21,608,25,610,29,611);
}
