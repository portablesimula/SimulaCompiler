package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$les_formatnavn extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    TXT$ form=null;
    public HegnaNRK$PBLK21$les_formatnavn(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$les_formatnavn STM$() {
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Format:"));
        form=new HegnaNRK$PBLK21$les_navn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        ((HegnaNRK$PBLK21)(CUR$.SL$)).formatnr$1=new HegnaNRK$PBLK21$finn_format(((HegnaNRK$PBLK21)(CUR$.SL$)),form).RESULT$;
        while((((HegnaNRK$PBLK21)(CUR$.SL$)).formatnr$1==(0))) {
            {
                new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),16);
                form=new HegnaNRK$PBLK21$les_navn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                ((HegnaNRK$PBLK21)(CUR$.SL$)).formatnr$1=new HegnaNRK$PBLK21$finn_format(((HegnaNRK$PBLK21)(CUR$.SL$)),form).RESULT$;
            }
        }
        RESULT$=form;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_formatnavn",1,937,10,939,18,940,20,941,22,942,24,943,26,945,29,946,31,947,35,949,39,950);
}
