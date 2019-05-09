package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$les_finne_regel extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$les_finne_regel(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$les_finne_regel STM$() {
        new HegnaNRK$stryk_finne_regel(((HegnaNRK)(CUR$.SL$)));
        ((HegnaNRK)(CUR$.SL$)).feltnavn$1=new HegnaNRK$les_feltnavn(((HegnaNRK)(CUR$.SL$))).RESULT$;
        while((((HegnaNRK)(CUR$.SL$)).feltnr$1!=(((HegnaNRK)(CUR$.SL$)).quit_felt$1))) {
            {
                ((HegnaNRK)(CUR$.SL$)).felttype$1=((HegnaNRK)(CUR$.SL$)).felttype_tabell.Elt[((HegnaNRK)(CUR$.SL$)).feltnr$1-((HegnaNRK)(CUR$.SL$)).felttype_tabell.LB[0]];
                new HegnaNRK$les_feltverdi(((HegnaNRK)(CUR$.SL$)));
                new HegnaNRK$sett_finne_regel(((HegnaNRK)(CUR$.SL$)));
                ((HegnaNRK)(CUR$.SL$)).feltnavn$1=new HegnaNRK$les_feltnavn(((HegnaNRK)(CUR$.SL$))).RESULT$;
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_finne_regel",1,760,14,763,16,764,18,765,20,767,23,768,25,769,27,770,33,772);
}
