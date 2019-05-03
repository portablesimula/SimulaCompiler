package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$les_nytt_formatnavn extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    TXT$ form=null;
    public HegnaNRK$PBLK21$les_nytt_formatnavn(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$les_nytt_formatnavn STM$() {
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Nytt format:"));
        form=new HegnaNRK$PBLK21$les_navn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        ((HegnaNRK$PBLK21)(CUR$.SL$)).formatnr$1=new HegnaNRK$PBLK21$finn_format(((HegnaNRK$PBLK21)(CUR$.SL$)),form).RESULT$;
        while((((HegnaNRK$PBLK21)(CUR$.SL$)).formatnr$1!=(0))) {
            {
                new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),17);
                form=new HegnaNRK$PBLK21$les_navn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                ((HegnaNRK$PBLK21)(CUR$.SL$)).formatnr$1=new HegnaNRK$PBLK21$finn_format(((HegnaNRK$PBLK21)(CUR$.SL$)),form).RESULT$;
            }
        }
        RESULT$=form;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_nytt_formatnavn",1,952,10,954,18,955,20,956,22,957,24,958,26,960,29,961,31,962,35,964,39,965);
}
