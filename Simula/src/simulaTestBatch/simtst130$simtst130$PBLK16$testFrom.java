package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testFrom extends PROC$ {
    public simtst130$simtst130$PBLK16$testFrom(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testFrom STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST from --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        new simtst130$simtst130$PBLK16$testFrom$test((CUR$),new TXT$("master file"),8,new TXT$("file"));
        ;
        new simtst130$simtst130$PBLK16$testFrom$test((CUR$),new TXT$("master file"),(-(8)),new TXT$("master file"));
        ;
        new simtst130$simtst130$PBLK16$testFrom$test((CUR$),new TXT$("master file"),18,null);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST from --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testFrom",1,421,13,434,16,435,19,436,22,437,25,438,30,440);
}
