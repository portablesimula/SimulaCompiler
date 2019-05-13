package simprog;
// Simula-Beta-0.3 Compiled at Fri May 10 11:44:24 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Weeknum extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    Dates$Date Jan1=null;
    Dates$Date Dx=null;
    public Dates$Date$Weeknum(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Dates$Date$Weeknum STM$() {
        Dx=((Dates$Date)(CUR$.SL$));
        while((new Dates$Date$Weekday(Dx).RESULT$!=(((Dates)(CUR$.SL$.SL$)).Sunday))) {
            Dx=new Dates$Date$Suc(Dx).RESULT$;
        }
        Jan1=new Dates$Date(((Dates)(CUR$.SL$.SL$)),1,1,((Dates$Date)(CUR$.SL$)).p$Y).STM$();
        RESULT$=((new Dates$Date$Diff(Jan1,Dx).RESULT$+(4))/(7));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure Weeknum",1,97,10,99,19,101,21,102,25,104,27,105,31,106);
}
