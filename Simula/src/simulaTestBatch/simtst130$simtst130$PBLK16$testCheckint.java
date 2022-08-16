package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testCheckint extends PROC$ {
    public simtst130$simtst130$PBLK16$testCheckint(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testCheckint STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST checkint --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("fff12378 ITEM2")));
        ;
        new simtst130$simtst130$PBLK16$testCheckint$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,(-(1)),1);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("fff12378 ITEM2")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,4);
        ;
        new simtst130$simtst130$PBLK16$testCheckint$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,1,9);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("fff12378 ITEM2")));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=TXT$.sub(((simtst130$PBLK16)(CUR$.SL$)).t1$1,4,9);
        ;
        new simtst130$simtst130$PBLK16$testCheckint$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,1,6);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("123789999999999999999999999999999999999999999999999999999999")));
        ;
        new simtst130$simtst130$PBLK16$testCheckint$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,(-(1)),1);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST checkint --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testCheckint",1,160,13,169,16,170,21,171,28,172,35,173,40,174,45,176);
}
