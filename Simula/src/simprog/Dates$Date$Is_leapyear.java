package simprog;
// Simula-Beta-0.3 Compiled at Fri May 10 11:44:24 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Is_leapyear extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public Dates$Date$Is_leapyear(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Dates$Date$Is_leapyear STM$() {
        RESULT$=new Dates$L_year(((Dates)(CUR$.SL$.SL$)),((Dates$Date)(CUR$.SL$)).p$Y).RESULT$;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure Is_leapyear",1,127,16,129,20,130);
}
