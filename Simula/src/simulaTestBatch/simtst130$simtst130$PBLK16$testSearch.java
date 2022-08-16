package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testSearch extends PROC$ {
    public simtst130$simtst130$PBLK16$testSearch(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testSearch STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST search --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        new simtst130$simtst130$PBLK16$testSearch$test((CUR$),new TXT$("Abracadabra"),new TXT$("cadab"),5);
        ;
        new simtst130$simtst130$PBLK16$testSearch$test((CUR$),new TXT$("Abracadabra"),new TXT$("newYork"),12);
        ;
        new simtst130$simtst130$PBLK16$testSearch$test((CUR$),null,new TXT$("cadab"),0);
        ;
        new simtst130$simtst130$PBLK16$testSearch$test((CUR$),new TXT$("Abracadabra"),null,0);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST search --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testSearch",1,1036,13,1043,16,1044,19,1045,22,1046,25,1047,28,1048,33,1050);
}
