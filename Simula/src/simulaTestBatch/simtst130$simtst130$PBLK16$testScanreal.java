package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testScanreal extends PROC$ {
    public simtst130$simtst130$PBLK16$testScanreal(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testScanreal STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST scanreal --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("123.78")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,1);
        ;
        new simtst130$simtst130$PBLK16$testScanreal$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,7);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("+123.78")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,1);
        ;
        new simtst130$simtst130$PBLK16$testScanreal$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,8);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("-123.78")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,1);
        ;
        new simtst130$simtst130$PBLK16$testScanreal$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,8);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("&123.78")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,1);
        ;
        new simtst130$simtst130$PBLK16$testScanreal$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,1);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("123.78 ITEM2")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,2);
        ;
        new simtst130$simtst130$PBLK16$testScanreal$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,7);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("ITEM1 ITEM2")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,2);
        ;
        new simtst130$simtst130$PBLK16$testScanreal$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,2);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST scanreal --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testScanreal",1,966,13,990,16,991,23,992,30,993,37,994,44,995,51,996,58,997,63,999);
}
