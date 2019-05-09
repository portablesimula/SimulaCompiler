package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$les_startposisjon extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    int i=0;
    public HegnaNRK$les_startposisjon(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$les_startposisjon STM$() {
        new HegnaNRK$lede_tekst(((HegnaNRK)(CUR$.SL$)),new TXT$("Start-posisjon:"));
        i=new HegnaNRK$sikker_inint(((HegnaNRK)(CUR$.SL$))).RESULT$;
        while(((i<(0))&((i>(128))))) {
            {
                new HegnaNRK$feil(((HegnaNRK)(CUR$.SL$)),8);
                i=new HegnaNRK$sikker_inint(((HegnaNRK)(CUR$.SL$))).RESULT$;
            }
        }
        RESULT$=i;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_startposisjon",1,980,10,981,18,982,20,983,22,984,24,986,27,987,31,989,35,990);
}
