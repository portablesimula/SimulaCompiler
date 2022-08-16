package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testDepchar extends PROC$ {
    public simtst130$simtst130$PBLK16$testDepchar(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testDepchar STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST testDepchar --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("Abracadab")));
        ;
        new simtst130$simtst130$PBLK16$testDepchar$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,4,'X',new TXT$("AbrXcadab"));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("Abracadab")));
        ;
        new simtst130$simtst130$PBLK16$testDepchar$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,(-(4)),'X',new TXT$("Abracadab"));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("Abracadab")));
        ;
        new simtst130$simtst130$PBLK16$testDepchar$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,9,'X',new TXT$("AbracadaX"));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("Abracadab")));
        ;
        new simtst130$simtst130$PBLK16$testDepchar$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,10,'X',new TXT$("Abracadab"));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("Abracadab")));
        ;
        new simtst130$simtst130$PBLK16$testDepchar$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,11,'X',new TXT$("Abracadab"));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST testDepchar --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testDepchar",1,319,13,333,16,334,21,335,26,336,31,337,36,338,41,339,46,341);
}
