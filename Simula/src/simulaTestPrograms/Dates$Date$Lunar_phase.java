package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:08:22 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Lunar_phase extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public float RESULT$;
    public Object RESULT$() { return(RESULT$); }
    double Ph=0.0d;
    public Dates$Date$Lunar_phase(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Dates$Date$Lunar_phase STM$() {
        Ph=((((double)(new Dates$Date$Diff(new Dates$Date(((Dates)(CUR$.SL$.SL$)),14,11,1997).STM$(),((Dates$Date)(CUR$.SL$))).RESULT$))-(((((double)(3))+((12.0d/(((double)(60))))))/(((double)(24))))))/(((Dates)(CUR$.SL$.SL$)).Lunar_period));
        RESULT$=((float)((Ph-(((double)(entier(Ph)))))));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure Lunar_phase",1,71,10,73,18,75,20,77,24,78);
}
