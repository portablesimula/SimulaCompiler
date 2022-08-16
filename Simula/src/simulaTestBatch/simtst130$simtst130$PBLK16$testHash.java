package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testHash extends PROC$ {
    public simtst130$simtst130$PBLK16$testHash(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testHash STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST hash --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        new simtst130$simtst130$PBLK16$testHash$test((CUR$),new TXT$("Abracadabra"),17,3);
        ;
        new simtst130$simtst130$PBLK16$testHash$test((CUR$),new TXT$("Abracadabra"),37,26);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=new TXT$("Abraca      Abracadabra");
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=TXT$.sub(((simtst130$PBLK16)(CUR$.SL$)).t1$1,7,17);
        ;
        new simtst130$simtst130$PBLK16$testHash$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,133,104);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST hash --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testHash",1,570,13,596,16,597,19,598,22,599,29,600,34,602);
}
