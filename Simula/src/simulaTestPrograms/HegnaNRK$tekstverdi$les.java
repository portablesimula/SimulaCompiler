package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$tekstverdi$les extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$tekstverdi$les(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$tekstverdi$les STM$() {
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
                if(VALUE$((((HegnaNRK)(CUR$.SL$.SL$)).siste_felt_verdi_lest.Elt[((HegnaNRK)(CUR$.SL$.SL$)).feltnr$1-((HegnaNRK)(CUR$.SL$.SL$)).siste_felt_verdi_lest.LB[0]]!=(null)))) {
                    ((HegnaNRK$tekstverdi)(CUR$.SL$)).tekst$1=copy(copy(((HegnaNRK$tekstverdi)(((HegnaNRK)(CUR$.SL$.SL$)).siste_felt_verdi_lest.Elt[((HegnaNRK)(CUR$.SL$.SL$)).feltnr$1-((HegnaNRK)(CUR$.SL$.SL$)).siste_felt_verdi_lest.LB[0]])).tekst$1));
                } else
                ((HegnaNRK$tekstverdi)(CUR$.SL$)).tekst$1=null;
            }
        } else
        new HegnaNRK$tekstverdi$les$SubBlock129(CUR$).STM$();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les",1,114,14,115,18,116,20,117,23,118,29,120,31,122,34,123,36,124,39,126,43,143,47,144);
}
