package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testCheckfrac extends PROC$ {
    public simtst130$simtst130$PBLK16$testCheckfrac(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testCheckfrac STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST checkfrac --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("fff12 378 ITEM2")));
        ;
        new simtst130$simtst130$PBLK16$testCheckfrac$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,(-(1)),1);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("fff123 78 ITEM2")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,4);
        ;
        new simtst130$simtst130$PBLK16$testCheckfrac$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,1,10);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("fff12 37 8 ITEM2")));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=TXT$.sub(((simtst130$PBLK16)(CUR$.SL$)).t1$1,4,11);
        ;
        new simtst130$simtst130$PBLK16$testCheckfrac$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,1,8);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("12378 9999 999999 999 99999 999999 999999 99999 99999 999999 999999999")));
        ;
        new simtst130$simtst130$PBLK16$testCheckfrac$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,(-(1)),1);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST checkfrac --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testCheckfrac",1,142,13,151,16,152,21,153,28,154,35,155,40,156,45,158);
}
