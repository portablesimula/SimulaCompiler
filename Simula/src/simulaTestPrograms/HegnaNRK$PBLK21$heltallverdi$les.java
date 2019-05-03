package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$heltallverdi$les extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$heltallverdi$les(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$heltallverdi$les STM$() {
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
                    ((HegnaNRK$PBLK21$heltallverdi)(CUR$.SL$)).tall$1=((HegnaNRK$PBLK21$heltallverdi)(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).siste_felt_verdi_lest.Elt[((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnr$1-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).siste_felt_verdi_lest.LB[0]])).tall$1;
                } else
                ((HegnaNRK$PBLK21$heltallverdi)(CUR$.SL$)).tall$1=0;
            }
        } else
        {
            ((HegnaNRK$PBLK21$heltallverdi)(CUR$.SL$)).tall$1=new HegnaNRK$PBLK21$sikker_inint(((HegnaNRK$PBLK21)(CUR$.SL$.SL$))).RESULT$;
            ((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).siste_felt_verdi_lest.Elt[((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnr$1-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).siste_felt_verdi_lest.LB[0]]=((HegnaNRK$PBLK21$verdi)(((HegnaNRK$PBLK21$heltallverdi)(CUR$.SL$)).kopi$0().CPF().RESULT$()));
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les",1,84,14,85,18,86,20,87,23,88,29,90,31,92,34,93,36,94,39,96,43,100,46,101,51,103);
}
