package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$les_formatnavn extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    TXT$ form=null;
    public HegnaNRK$les_formatnavn(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$les_formatnavn STM$() {
        new HegnaNRK$lede_tekst(((HegnaNRK)(CUR$.SL$)),new TXT$("Format:"));
        form=new HegnaNRK$les_navn(((HegnaNRK)(CUR$.SL$))).RESULT$;
        ((HegnaNRK)(CUR$.SL$)).formatnr$1=new HegnaNRK$finn_format(((HegnaNRK)(CUR$.SL$)),form).RESULT$;
        while((((HegnaNRK)(CUR$.SL$)).formatnr$1==(0))) {
            {
                new HegnaNRK$feil(((HegnaNRK)(CUR$.SL$)),16);
                form=new HegnaNRK$les_navn(((HegnaNRK)(CUR$.SL$))).RESULT$;
                ((HegnaNRK)(CUR$.SL$)).formatnr$1=new HegnaNRK$finn_format(((HegnaNRK)(CUR$.SL$)),form).RESULT$;
            }
        }
        RESULT$=form;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_formatnavn",1,937,10,939,18,940,20,941,22,942,24,943,26,945,29,946,31,947,35,949,39,950);
}
