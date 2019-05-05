package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:34:06 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$N_days extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    int Sum=0;
    int Ix=0;
    public Dates$Date$N_days(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Dates$Date$N_days STM$() {
        Sum=(((((((Dates$Date)(CUR$.SL$)).p$Y-(1))*(365))+(((((Dates$Date)(CUR$.SL$)).p$Y-(1))/(4))))-(((((Dates$Date)(CUR$.SL$)).p$Y-(1))/(100))))+(((((Dates$Date)(CUR$.SL$)).p$Y-(1))/(400))));
        for(boolean CB$21:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){Ix=(int)x$; return(x$);};  public Number get(){return((Number)Ix); }	},new NAME$<Number>() { public Number get(){return((((Dates$Date)(CUR$.SL$)).p$M-(1))); }},new NAME$<Number>() { public Number get(){return((-(1))); }},new NAME$<Number>() { public Number get(){return(1); }})
           )) { if(!CB$21) continue;
        Sum=(Sum+(new Dates$M_leng(((Dates)(CUR$.SL$.SL$)),Ix,((Dates$Date)(CUR$.SL$)).p$Y).RESULT$));
    }
    RESULT$=(Sum+(((Dates$Date)(CUR$.SL$)).p$D));
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure N_days",1,16,10,18,19,20,21,21,25,22,28,23,32,24);
}
