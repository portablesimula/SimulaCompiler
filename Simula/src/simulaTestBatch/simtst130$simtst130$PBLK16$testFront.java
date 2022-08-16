package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testFront extends PROC$ {
    public simtst130$simtst130$PBLK16$testFront(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testFront STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST front --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=new TXT$("Abracadabra");
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,6);
        ;
        new simtst130$simtst130$PBLK16$testFront$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("Abrac"));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("fff12.378 ITEM2")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,4);
        ;
        new simtst130$simtst130$PBLK16$testFront$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("fff"));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("fff1.2378 ITEM2")));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=TXT$.sub(((simtst130$PBLK16)(CUR$.SL$)).t1$1,4,11);
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,8);
        ;
        new simtst130$simtst130$PBLK16$testFront$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("1.2378 "));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST front --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testFront",1,442,13,458,16,459,23,460,30,461,39,462,44,464);
}
