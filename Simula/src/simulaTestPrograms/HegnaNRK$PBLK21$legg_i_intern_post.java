package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$legg_i_intern_post extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int fnr=0;
    public HegnaNRK$PBLK21$legg_i_intern_post(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$legg_i_intern_post STM$() {
        fnr=new HegnaNRK$PBLK21$finn_intern_feltnr(((HegnaNRK$PBLK21)(CUR$.SL$)),((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr$1).RESULT$;
        if(VALUE$((fnr==(0)))) {
            {
                if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall$1>=(((HegnaNRK$PBLK21)(CUR$.SL$)).max_intern_felt$1)))) {
                    new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),8);
                } else
                ((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall$1=(((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall$1+(1));
                fnr=((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall$1;
                ((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.Elt[fnr-((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.LB[0]]=((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr$1;
            }
        }
        ((HegnaNRK$PBLK21)(CUR$.SL$)).intern_felt.Elt[fnr-((HegnaNRK$PBLK21)(CUR$.SL$)).intern_felt.LB[0]]=new HegnaNRK$PBLK21$felt_kopi(((HegnaNRK$PBLK21)(CUR$.SL$)),((HegnaNRK$PBLK21)(CUR$.SL$)).feltverdi$1).RESULT$;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure legg_i_intern_post",1,852,8,854,16,855,18,856,20,858,23,859,27,860,29,861,33,863,37,864);
}
