package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testChangeAll extends PROC$ {
    public simtst130$simtst130$PBLK16$testChangeAll(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testChangeAll STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST change --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("abracadabra")));
        ;
        new simtst130$simtst130$PBLK16$testChangeAll$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("bra"),new TXT$("BRA"),new TXT$("aBRAcadaBRA"),12);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("abracadabra")));
        ;
        new simtst130$simtst130$PBLK16$testChangeAll$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("a"),new TXT$("BRA"),new TXT$("abrBRAcBRAdBRAbrBRA"),20);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST change --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testChangeAll",1,98,13,120,16,121,21,122,26,123,31,125);
}
