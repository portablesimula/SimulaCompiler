package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testCptime$cptime1 extends PROC$ {
    public float RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public simtst130$simtst130$PBLK16$testCptime$cptime1(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testCptime$cptime1 STM$() {
        RESULT$=((float)(ENVIRONMENT$.cputime()));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure cptime1",1,276,15,277,20,277);
}
