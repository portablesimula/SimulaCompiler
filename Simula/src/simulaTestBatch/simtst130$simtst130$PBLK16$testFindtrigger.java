package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testFindtrigger extends PROC$ {
    public simtst130$simtst130$PBLK16$testFindtrigger(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testFindtrigger STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST findtrigger --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        new simtst130$simtst130$PBLK16$testFindtrigger$test((CUR$),new TXT$("master"),new TXT$("es"),'s',4);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("fff12.378 ITEM2")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,4);
        ;
        new simtst130$simtst130$PBLK16$testFindtrigger$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("TM"),'T',13);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("fff1.2378 ITEM2")));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=TXT$.sub(((simtst130$PBLK16)(CUR$.SL$)).t1$1,4,11);
        ;
        new simtst130$simtst130$PBLK16$testFindtrigger$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("TM"),'T',10);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST findtrigger --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testFindtrigger",1,384,13,413,16,414,19,415,26,416,33,417,38,419);
}
