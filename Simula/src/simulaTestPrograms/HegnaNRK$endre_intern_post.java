package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$endre_intern_post extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$endre_intern_post(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$endre_intern_post STM$() {
        ((HegnaNRK)(CUR$.SL$)).feltnavn$1=new HegnaNRK$les_feltnavn(((HegnaNRK)(CUR$.SL$))).RESULT$;
        while((((HegnaNRK)(CUR$.SL$)).feltnr$1!=(((HegnaNRK)(CUR$.SL$)).quit_felt$1))) {
            {
                ((HegnaNRK)(CUR$.SL$)).felttype$1=((HegnaNRK)(CUR$.SL$)).felttype_tabell.Elt[((HegnaNRK)(CUR$.SL$)).feltnr$1-((HegnaNRK)(CUR$.SL$)).felttype_tabell.LB[0]];
                new HegnaNRK$les_feltverdi(((HegnaNRK)(CUR$.SL$)));
                new HegnaNRK$legg_i_intern_post(((HegnaNRK)(CUR$.SL$)));
                ((HegnaNRK)(CUR$.SL$)).feltnavn$1=new HegnaNRK$les_feltnavn(((HegnaNRK)(CUR$.SL$))).RESULT$;
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure endre_intern_post",1,579,14,582,16,583,18,585,21,586,23,587,25,588,31,590);
}
