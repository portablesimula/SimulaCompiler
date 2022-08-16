package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testInsinglechar extends PROC$ {
    public simtst130$simtst130$PBLK16$testInsinglechar(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testInsinglechar STM$() {
        while(true) {
            if(VALUE$((new simtst130$simtst130$PBLK16$testInsinglechar$prompt((CUR$),new TXT$("Continue ? "),true).RESULT$==('q')))) {
                simtst130$PBLK16.abort(new TXT$(" Abort"));
            }
            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testInsinglechar",1,726,13,735,15,736,24,739);
}
