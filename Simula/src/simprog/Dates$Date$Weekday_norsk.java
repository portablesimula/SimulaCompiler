package simprog;
// Simula-Beta-0.3 Compiled at Fri May 10 11:44:24 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Weekday_norsk extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public Dates$Date$Weekday_norsk(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Dates$Date$Weekday_norsk STM$() {
        RESULT$=copy(copy(((Dates)(CUR$.SL$.SL$)).WN_tab.Elt[new Dates$Date$Weekday(((Dates$Date)(CUR$.SL$))).RESULT$-((Dates)(CUR$.SL$.SL$)).WN_tab.LB[0]]));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure Weekday_norsk",1,115,16,117,20,118);
}
