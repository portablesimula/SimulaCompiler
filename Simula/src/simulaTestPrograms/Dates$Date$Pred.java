package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed May 08 17:45:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Pred extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public Dates$Date RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public Dates$Date$Pred(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Dates$Date$Pred STM$() {
        RESULT$=new Dates$Date$Minus(((Dates$Date)(CUR$.SL$)),1).RESULT$;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure Pred",1,58,16,60,20,61);
}
