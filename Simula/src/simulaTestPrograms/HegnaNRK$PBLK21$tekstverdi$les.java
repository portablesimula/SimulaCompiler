package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$tekstverdi$les extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$tekstverdi$les(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$tekstverdi$les STM$() {
        if(VALUE$((!(TXT$.more(sysin().image))))) {
            sysin().inimage();
        }
        while(TXTREL$EQ(TXT$.sub(sysin().image,TXT$.pos(sysin().image),1),new TXT$(" "))) {
            {
                sysin().inchar();
                if(VALUE$((!(TXT$.more(sysin().image))))) {
                    sysin().inimage();
                }
            }
        }
        if(VALUE$(TXTREL$EQ(TXT$.sub(sysin().image,TXT$.pos(sysin().image),1),new TXT$("=")))) {
            {
                sysin().inchar();
                if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).siste_felt_verdi_lest.Elt[((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnr$1-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).siste_felt_verdi_lest.LB[0]]!=(null)))) {
                    ((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$)).tekst$1=copy(copy(((HegnaNRK$PBLK21$tekstverdi)(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).siste_felt_verdi_lest.Elt[((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnr$1-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).siste_felt_verdi_lest.LB[0]])).tekst$1));
                } else
                ((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$)).tekst$1=null;
            }
        } else
        new HegnaNRK$PBLK21$tekstverdi$les$SubBlock129(CUR$).STM$();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les",1,114,14,115,18,116,20,117,23,118,29,120,31,122,34,123,36,124,39,126,43,143,47,144);
}
