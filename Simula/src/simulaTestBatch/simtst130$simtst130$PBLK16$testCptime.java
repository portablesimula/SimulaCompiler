package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testCptime extends PROC$ {
    public simtst130$simtst130$PBLK16$testCptime(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testCptime STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST cptime --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).lr$1=((double)(new simtst130$simtst130$PBLK16$testCptime$cptime1((CUR$)).RESULT$));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("Test cptime1 ==> "),ENVIRONMENT$.edfix(((simtst130$PBLK16)(CUR$.SL$)).lr$1,4)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).lr$1=simtst130$PBLK16.cptime();
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("Test  cptime ==> "),ENVIRONMENT$.edfix(((simtst130$PBLK16)(CUR$.SL$)).lr$1,4)));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST cptime --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testCptime",1,275,13,279,16,280,21,281,26,282,31,284);
}
