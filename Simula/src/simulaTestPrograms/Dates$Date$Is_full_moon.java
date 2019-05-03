package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:08:22 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Is_full_moon extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    final float Limit;
    float Phase=0.0f;
    public Dates$Date$Is_full_moon(RTObject$ SL$) {
        super(SL$);
        BBLK();
        Limit=((float)((((double)(0.5f))/(((Dates)(CUR$.SL$.SL$)).Lunar_period))));
        STM$();
    }
    public Dates$Date$Is_full_moon STM$() {
        Phase=new Dates$Date$Lunar_phase(((Dates$Date)(CUR$.SL$))).RESULT$;
        RESULT$=((Phase<(Limit))|((Phase>=((((float)(1))-(Limit))))));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure Is_full_moon",1,81,10,83,12,84,21,86,23,87,27,88);
}
