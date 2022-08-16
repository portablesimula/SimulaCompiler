package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testScanchar extends PROC$ {
    public simtst130$simtst130$PBLK16$testScanchar(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testScanchar STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST scanchar --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("Abracadabra")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,4);
        ;
        new simtst130$simtst130$PBLK16$testScanchar$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,'a',5);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("Abracadabra")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,TXT$.length(((simtst130$PBLK16)(CUR$.SL$)).t1$1));
        ;
        new simtst130$simtst130$PBLK16$testScanchar$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,'a',12);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("Abracadabra")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,Math.addExact(TXT$.length(((simtst130$PBLK16)(CUR$.SL$)).t1$1),1));
        ;
        new simtst130$simtst130$PBLK16$testScanchar$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,((char)0),12);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST scanchar --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testScanchar",1,875,13,892,16,893,23,894,30,895,37,896,42,898);
}
