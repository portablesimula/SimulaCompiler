package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testLowc extends PROC$ {
    public simtst130$simtst130$PBLK16$testLowc(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testLowc STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST lowc --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        for(((simtst130$PBLK16)(CUR$.SL$)).i$1=0;((simtst130$PBLK16)(CUR$.SL$)).i$1<=127;((simtst130$PBLK16)(CUR$.SL$)).i$1++) {
            new simtst130$simtst130$PBLK16$testLowc$test((CUR$),ENVIRONMENT$.char$(((simtst130$PBLK16)(CUR$.SL$)).i$1));
        }
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST lowc --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testLowc",1,773,13,787,17,788,21,789,26,791);
}
