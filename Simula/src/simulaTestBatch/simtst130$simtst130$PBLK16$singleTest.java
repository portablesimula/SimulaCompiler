package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$singleTest extends PROC$ {
    public simtst130$simtst130$PBLK16$singleTest(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$singleTest STM$() {
        ;
        new simtst130$simtst130$PBLK16$testFront((CUR$.SL$));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure singleTest",1,1238,14,1262,19,1287);
}
