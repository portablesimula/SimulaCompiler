package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testScanint extends PROC$ {
    public simtst130$simtst130$PBLK16$testScanint(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testScanint STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST scanint --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("12378")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,1);
        ;
        new simtst130$simtst130$PBLK16$testScanint$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,6);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("+12378")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,1);
        ;
        new simtst130$simtst130$PBLK16$testScanint$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,7);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("-12378")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,1);
        ;
        new simtst130$simtst130$PBLK16$testScanint$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,7);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("&12378")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,1);
        ;
        new simtst130$simtst130$PBLK16$testScanint$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,1);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("&12378")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,2);
        ;
        new simtst130$simtst130$PBLK16$testScanint$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,7);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST scanint --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testScanint",1,933,13,956,16,957,23,958,30,959,37,960,44,961,51,962,56,964);
}
