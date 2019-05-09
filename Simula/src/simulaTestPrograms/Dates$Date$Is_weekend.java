package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed May 08 17:45:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Is_weekend extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    int Dx=0;
    public Dates$Date$Is_weekend(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Dates$Date$Is_weekend STM$() {
        Dx=new Dates$Date$Weekday(((Dates$Date)(CUR$.SL$))).RESULT$;
        RESULT$=((Dx==(((Dates)(CUR$.SL$.SL$)).Sunday))|((Dx==(((Dates)(CUR$.SL$.SL$)).Saturday))));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure Is_weekend",1,133,10,135,18,137,20,138,24,139);
}
