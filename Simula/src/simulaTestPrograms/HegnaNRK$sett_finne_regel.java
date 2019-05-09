package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$sett_finne_regel extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$sett_finne_regel(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$sett_finne_regel STM$() {
        if(VALUE$((((HegnaNRK)(CUR$.SL$)).finne_regel_antall$1<(((HegnaNRK)(CUR$.SL$)).max_finne_regel$1)))) {
            {
                ((HegnaNRK)(CUR$.SL$)).finne_regel_antall$1=(((HegnaNRK)(CUR$.SL$)).finne_regel_antall$1+(1));
                ((HegnaNRK)(CUR$.SL$)).finnefeltnr.Elt[((HegnaNRK)(CUR$.SL$)).finne_regel_antall$1-((HegnaNRK)(CUR$.SL$)).finnefeltnr.LB[0]]=((HegnaNRK)(CUR$.SL$)).feltnr$1;
                ((HegnaNRK)(CUR$.SL$)).finnefeltpeker.Elt[((HegnaNRK)(CUR$.SL$)).finne_regel_antall$1-((HegnaNRK)(CUR$.SL$)).finnefeltpeker.LB[0]]=((HegnaNRK)(CUR$.SL$)).feltverdi$1;
            }
        } else
        new HegnaNRK$feil(((HegnaNRK)(CUR$.SL$)),9);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure sett_finne_regel",1,780,14,783,16,785,19,786,21,787,25,789,29,790);
}
