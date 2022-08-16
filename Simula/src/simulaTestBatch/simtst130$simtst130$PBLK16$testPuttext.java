package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testPuttext extends PROC$ {
    public simtst130$simtst130$PBLK16$testPuttext(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testPuttext STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST puttext --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("fff12 378 ITEM2")));
        ;
        new simtst130$simtst130$PBLK16$testPuttext$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("newt"),true,5);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("fff123 78 ITEM2")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,4);
        ;
        new simtst130$simtst130$PBLK16$testPuttext$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("newt"),true,8);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("fff12 37 8 ITEM2")));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=TXT$.sub(((simtst130$PBLK16)(CUR$.SL$)).t1$1,4,11);
        ;
        new simtst130$simtst130$PBLK16$testPuttext$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("newt"),true,5);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("fff12 378 ITEM2")));
        ;
        new simtst130$simtst130$PBLK16$testPuttext$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("newtxxxxxxxxxxxxxxxx"),false,1);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("fff123 78 ITEM2")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,4);
        ;
        new simtst130$simtst130$PBLK16$testPuttext$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("newtzzzzzzzzz"),false,4);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("fff12 37 8 ITEM2")));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=TXT$.sub(((simtst130$PBLK16)(CUR$.SL$)).t1$1,4,11);
        ;
        new simtst130$simtst130$PBLK16$testPuttext$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("newtyyyyyyyy"),false,1);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST puttext --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testPuttext",1,815,13,840,16,841,21,842,28,843,35,845,40,846,47,847,54,848,59,850);
}
