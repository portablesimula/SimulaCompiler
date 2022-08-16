package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testCompress extends PROC$ {
    public simtst130$simtst130$PBLK16$testCompress(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testCompress STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST compress --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("AxBxCxDx")));
        ;
        new simtst130$simtst130$PBLK16$testCompress$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,'x',new TXT$("ABCD"),new TXT$("ABCDCxDx"));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("AxBxCxDx")));
        ;
        new simtst130$simtst130$PBLK16$testCompress$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,'y',new TXT$("AxBxCxDx"),new TXT$("AxBxCxDx"));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST compress --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testCompress",1,196,13,225,16,228,21,229,26,230,31,232);
}
