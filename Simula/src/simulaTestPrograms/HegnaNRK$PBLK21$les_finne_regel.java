package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$les_finne_regel extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$les_finne_regel(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$les_finne_regel STM$() {
        new HegnaNRK$PBLK21$stryk_finne_regel(((HegnaNRK$PBLK21)(CUR$.SL$)));
        ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn$1=new HegnaNRK$PBLK21$les_feltnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        while((((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr$1!=(((HegnaNRK$PBLK21)(CUR$.SL$)).quit_felt$1))) {
            {
                ((HegnaNRK$PBLK21)(CUR$.SL$)).felttype$1=((HegnaNRK$PBLK21)(CUR$.SL$)).felttype_tabell.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr$1-((HegnaNRK$PBLK21)(CUR$.SL$)).felttype_tabell.LB[0]];
                new HegnaNRK$PBLK21$les_feltverdi(((HegnaNRK$PBLK21)(CUR$.SL$)));
                new HegnaNRK$PBLK21$sett_finne_regel(((HegnaNRK$PBLK21)(CUR$.SL$)));
                ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn$1=new HegnaNRK$PBLK21$les_feltnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_finne_regel",1,760,14,763,16,764,18,765,20,767,23,768,25,769,27,770,33,772);
}
