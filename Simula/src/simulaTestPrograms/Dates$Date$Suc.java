package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed May 08 17:45:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Suc extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public Dates$Date RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public Dates$Date$Suc(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Dates$Date$Suc STM$() {
        RESULT$=new Dates$Date$Plus(((Dates$Date)(CUR$.SL$)),1).RESULT$;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure Suc",1,45,16,47,20,48);
}
