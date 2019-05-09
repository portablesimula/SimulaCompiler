package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$main extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int kommandonr=0;
    public HegnaNRK$main(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$main STM$() {
        new HegnaNRK$start_databasen(((HegnaNRK)(CUR$.SL$)));
        kommandonr=new HegnaNRK$les_kommando(((HegnaNRK)(CUR$.SL$))).RESULT$;
        while((kommandonr!=(((HegnaNRK)(CUR$.SL$)).quit_kommando$1))) {
            {
                new HegnaNRK$do_kommando(((HegnaNRK)(CUR$.SL$)),kommandonr);
                kommandonr=new HegnaNRK$les_kommando(((HegnaNRK)(CUR$.SL$))).RESULT$;
            }
        }
        new HegnaNRK$avslutt_databasen(((HegnaNRK)(CUR$.SL$)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure main",1,265,8,267,16,268,18,269,20,270,22,272,25,273,29,275,33,276);
}
