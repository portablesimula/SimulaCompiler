package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:34:06 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Weekday_english extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public Dates$Date$Weekday_english(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Dates$Date$Weekday_english STM$() {
        RESULT$=copy(copy(((Dates)(CUR$.SL$.SL$)).WE_tab.Elt[new Dates$Date$Weekday(((Dates$Date)(CUR$.SL$))).RESULT$-((Dates)(CUR$.SL$.SL$)).WE_tab.LB[0]]));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure Weekday_english",1,109,16,111,20,112);
}
