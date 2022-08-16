package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testFrontstrip extends PROC$ {
    public simtst130$simtst130$PBLK16$testFrontstrip(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testFrontstrip STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST frontstrip --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=new TXT$("     Abracadabra");
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,1);
        ;
        new simtst130$simtst130$PBLK16$testFrontstrip$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("Abracadabra"));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=new TXT$("Abraca      Abracadabra");
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=TXT$.sub(((simtst130$PBLK16)(CUR$.SL$)).t1$1,7,17);
        ;
        new simtst130$simtst130$PBLK16$testFrontstrip$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("Abracadabra"));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST frontstrip --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testFrontstrip",1,491,13,513,16,514,23,515,30,516,35,518);
}
