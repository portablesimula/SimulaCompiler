package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$les_nytt_formatnavn extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    TXT$ form=null;
    public HegnaNRK$les_nytt_formatnavn(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$les_nytt_formatnavn STM$() {
        new HegnaNRK$lede_tekst(((HegnaNRK)(CUR$.SL$)),new TXT$("Nytt format:"));
        form=new HegnaNRK$les_navn(((HegnaNRK)(CUR$.SL$))).RESULT$;
        ((HegnaNRK)(CUR$.SL$)).formatnr$1=new HegnaNRK$finn_format(((HegnaNRK)(CUR$.SL$)),form).RESULT$;
        while((((HegnaNRK)(CUR$.SL$)).formatnr$1!=(0))) {
            {
                new HegnaNRK$feil(((HegnaNRK)(CUR$.SL$)),17);
                form=new HegnaNRK$les_navn(((HegnaNRK)(CUR$.SL$))).RESULT$;
                ((HegnaNRK)(CUR$.SL$)).formatnr$1=new HegnaNRK$finn_format(((HegnaNRK)(CUR$.SL$)),form).RESULT$;
            }
        }
        RESULT$=form;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_nytt_formatnavn",1,952,10,954,18,955,20,956,22,957,24,958,26,960,29,961,31,962,35,964,39,965);
}
