package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:08:22 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Weekday extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public Dates$Date$Weekday(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Dates$Date$Weekday STM$() {
        RESULT$=mod(new Dates$Date$N_days(((Dates$Date)(CUR$.SL$))).RESULT$,7);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure Weekday",1,91,16,93,20,94);
}
