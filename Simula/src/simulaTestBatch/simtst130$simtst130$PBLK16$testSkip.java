package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testSkip extends PROC$ {
    public simtst130$simtst130$PBLK16$testSkip(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testSkip STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST skip --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        new simtst130$simtst130$PBLK16$testSkip$test((CUR$),new TXT$("..........TEST END"),'.',11);
        ;
        new simtst130$simtst130$PBLK16$testSkip$test((CUR$),new TXT$("..........TEST END"),';',1);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST skip --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testSkip",1,1052,13,1072,16,1073,19,1074,22,1075,27,1077);
}
