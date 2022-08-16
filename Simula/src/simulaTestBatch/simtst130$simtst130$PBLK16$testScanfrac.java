package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testScanfrac extends PROC$ {
    public simtst130$simtst130$PBLK16$testScanfrac(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testScanfrac STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST scanfrac --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("12 37 8")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,1);
        ;
        new simtst130$simtst130$PBLK16$testScanfrac$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,8);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("+12 37 8")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,1);
        ;
        new simtst130$simtst130$PBLK16$testScanfrac$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,9);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("-12 37 8")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,1);
        ;
        new simtst130$simtst130$PBLK16$testScanfrac$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,9);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("&12 37 8")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,1);
        ;
        new simtst130$simtst130$PBLK16$testScanfrac$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,1);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("&12 37 8")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,2);
        ;
        new simtst130$simtst130$PBLK16$testScanfrac$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,9);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("-21 474 836 50")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,1);
        ;
        new simtst130$simtst130$PBLK16$testScanfrac$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,1);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("+214 748 365 0")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,1);
        ;
        new simtst130$simtst130$PBLK16$testScanfrac$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,1);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST scanfrac --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testScanfrac",1,900,13,921,16,922,23,923,30,924,37,925,44,926,51,927,58,928,65,929,70,931);
}
