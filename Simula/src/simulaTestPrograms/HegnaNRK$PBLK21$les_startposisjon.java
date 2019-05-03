package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$les_startposisjon extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    int i=0;
    public HegnaNRK$PBLK21$les_startposisjon(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$les_startposisjon STM$() {
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Start-posisjon:"));
        i=new HegnaNRK$PBLK21$sikker_inint(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        while(((i<(0))&((i>(128))))) {
            {
                new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),8);
                i=new HegnaNRK$PBLK21$sikker_inint(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
            }
        }
        RESULT$=i;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_startposisjon",1,980,10,981,18,982,20,983,22,984,24,986,27,987,31,989,35,990);
}
