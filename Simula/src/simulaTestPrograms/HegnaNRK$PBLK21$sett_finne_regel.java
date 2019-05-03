package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$sett_finne_regel extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$sett_finne_regel(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$sett_finne_regel STM$() {
        if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).finne_regel_antall$1<(((HegnaNRK$PBLK21)(CUR$.SL$)).max_finne_regel$1)))) {
            {
                ((HegnaNRK$PBLK21)(CUR$.SL$)).finne_regel_antall$1=(((HegnaNRK$PBLK21)(CUR$.SL$)).finne_regel_antall$1+(1));
                ((HegnaNRK$PBLK21)(CUR$.SL$)).finnefeltnr.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).finne_regel_antall$1-((HegnaNRK$PBLK21)(CUR$.SL$)).finnefeltnr.LB[0]]=((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr$1;
                ((HegnaNRK$PBLK21)(CUR$.SL$)).finnefeltpeker.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).finne_regel_antall$1-((HegnaNRK$PBLK21)(CUR$.SL$)).finnefeltpeker.LB[0]]=((HegnaNRK$PBLK21)(CUR$.SL$)).feltverdi$1;
            }
        } else
        new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),9);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure sett_finne_regel",1,780,14,783,16,785,19,786,21,787,25,789,29,790);
}
