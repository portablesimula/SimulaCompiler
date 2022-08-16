package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testEnterdebug extends PROC$ {
    public simtst130$simtst130$PBLK16$testEnterdebug(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testEnterdebug STM$() {
        simtst130$PBLK16.enterdebug(true);
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testEnterdebug",1,343,13,344,18,345);
}
