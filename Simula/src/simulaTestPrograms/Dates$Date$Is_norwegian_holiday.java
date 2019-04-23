package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Apr 23 08:19:09 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Is_norwegian_holiday extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    Dates$Date Ex=null;
    public Dates$Date$Is_norwegian_holiday(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Dates$Date$Is_norwegian_holiday STM$() {
        Ex=new Dates$Easter(((Dates)(CUR$.SL$.SL$)),((Dates$Date)(CUR$.SL$)).p$Y).RESULT$;
        RESULT$=(((((((((((new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date(((Dates)(CUR$.SL$.SL$)),1,1,((Dates$Date)(CUR$.SL$)).p$Y).STM$()).RESULT$|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date(((Dates)(CUR$.SL$.SL$)),1,5,((Dates$Date)(CUR$.SL$)).p$Y).STM$()).RESULT$))|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date(((Dates)(CUR$.SL$.SL$)),17,5,((Dates$Date)(CUR$.SL$)).p$Y).STM$()).RESULT$))|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date(((Dates)(CUR$.SL$.SL$)),25,12,((Dates$Date)(CUR$.SL$)).p$Y).STM$()).RESULT$))|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date(((Dates)(CUR$.SL$.SL$)),26,12,((Dates$Date)(CUR$.SL$)).p$Y).STM$()).RESULT$))|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date$Minus(Ex,3).RESULT$).RESULT$))|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date$Minus(Ex,2).RESULT$).RESULT$))|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),Ex).RESULT$))|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date$Plus(Ex,1).RESULT$).RESULT$))|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date$Plus(Ex,39).RESULT$).RESULT$))|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date$Plus(Ex,49).RESULT$).RESULT$))|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date$Plus(Ex,50).RESULT$).RESULT$));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure Is_norwegian_holiday",1,169,10,171,18,173,20,174,24,187);
}
