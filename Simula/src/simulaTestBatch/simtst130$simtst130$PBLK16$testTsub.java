package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testTsub extends PROC$ {
    public simtst130$simtst130$PBLK16$testTsub(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testTsub STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST tsub --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t$1=ENVIRONMENT$.copy(copy(new TXT$("Dette er en tekst")));
        ;
        new simtst130$simtst130$PBLK16$testTsub$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t$1,7,6);
        ;
        new simtst130$simtst130$PBLK16$testTsub$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t$1,(-(7)),6);
        ;
        new simtst130$simtst130$PBLK16$testTsub$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t$1,7,26);
        ;
        new simtst130$simtst130$PBLK16$testTsub$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t$1,7,(-(6)));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST tsub --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testTsub",1,1097,13,1108,16,1109,19,1110,22,1111,25,1112,28,1113,31,1114,36,1116);
}
