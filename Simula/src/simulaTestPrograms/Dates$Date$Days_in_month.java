package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:08:22 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Days_in_month extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public Dates$Date$Days_in_month(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Dates$Date$Days_in_month STM$() {
        RESULT$=new Dates$M_leng(((Dates)(CUR$.SL$.SL$)),((Dates$Date)(CUR$.SL$)).p$M,((Dates$Date)(CUR$.SL$)).p$Y).RESULT$;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure Days_in_month",1,121,16,123,20,124);
}
