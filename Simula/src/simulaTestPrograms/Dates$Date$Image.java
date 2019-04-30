package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Apr 30 13:19:49 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Image extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public Dates$Date$Image(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Dates$Date$Image STM$() {
        RESULT$=CONC(CONC(CONC(CONC(new Dates$Date$N_image(((Dates$Date)(CUR$.SL$)),((Dates$Date)(CUR$.SL$)).p$D).RESULT$,new TXT$(".")),new Dates$Date$N_image(((Dates$Date)(CUR$.SL$)),((Dates$Date)(CUR$.SL$)).p$M).RESULT$),new TXT$(".")),new Dates$Date$N_image(((Dates$Date)(CUR$.SL$)),((Dates$Date)(CUR$.SL$)).p$Y).RESULT$);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure Image",1,190,16,192,20,193);
}
