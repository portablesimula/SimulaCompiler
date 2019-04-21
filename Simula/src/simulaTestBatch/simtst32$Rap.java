package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Fri Apr 19 09:17:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst32$Rap extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public simtst32$A RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public simtst32$Rap(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst32$Rap STM$() {
        RESULT$=new simtst32$A(((simtst32)(CUR$.SL$))).STM$();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst32.sim","Procedure Rap",1,61,19,61);
}
