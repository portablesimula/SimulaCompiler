package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$endre_intern_post extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$endre_intern_post(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$endre_intern_post STM$() {
        ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn$1=new HegnaNRK$PBLK21$les_feltnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        while((((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr$1!=(((HegnaNRK$PBLK21)(CUR$.SL$)).quit_felt$1))) {
            {
                ((HegnaNRK$PBLK21)(CUR$.SL$)).felttype$1=((HegnaNRK$PBLK21)(CUR$.SL$)).felttype_tabell.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr$1-((HegnaNRK$PBLK21)(CUR$.SL$)).felttype_tabell.LB[0]];
                new HegnaNRK$PBLK21$les_feltverdi(((HegnaNRK$PBLK21)(CUR$.SL$)));
                new HegnaNRK$PBLK21$legg_i_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
                ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn$1=new HegnaNRK$PBLK21$les_feltnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure endre_intern_post",1,579,14,582,16,583,18,585,21,586,23,587,25,588,31,590);
}
