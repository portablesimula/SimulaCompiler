package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$main extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int kommandonr=0;
    public HegnaNRK$PBLK21$main(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$main STM$() {
        new HegnaNRK$PBLK21$start_databasen(((HegnaNRK$PBLK21)(CUR$.SL$)));
        kommandonr=new HegnaNRK$PBLK21$les_kommando(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        while((kommandonr!=(((HegnaNRK$PBLK21)(CUR$.SL$)).quit_kommando$1))) {
            {
                new HegnaNRK$PBLK21$do_kommando(((HegnaNRK$PBLK21)(CUR$.SL$)),kommandonr);
                kommandonr=new HegnaNRK$PBLK21$les_kommando(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
            }
        }
        new HegnaNRK$PBLK21$avslutt_databasen(((HegnaNRK$PBLK21)(CUR$.SL$)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure main",1,265,8,267,16,268,18,269,20,270,22,272,25,273,29,275,33,276);
}
