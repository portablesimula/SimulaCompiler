package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testConcatenations extends PROC$ {
    public simtst130$simtst130$PBLK16$testConcatenations(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testConcatenations STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST conc --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        new simtst130$simtst130$PBLK16$testConcatenations$testConc((CUR$),new TXT$("abra"),new TXT$("cadabra"),new TXT$("abracadabra"));
        ;
        new simtst130$simtst130$PBLK16$testConcatenations$testConc2((CUR$),new TXT$("abra"),new TXT$("cadabra"),new TXT$("abracadabra"));
        ;
        new simtst130$simtst130$PBLK16$testConcatenations$testConc3((CUR$),new TXT$("abra"),new TXT$("ca"),new TXT$("dabra"),new TXT$("abracadabra"));
        ;
        new simtst130$simtst130$PBLK16$testConcatenations$testConc4((CUR$),new TXT$("ab"),new TXT$("ra"),new TXT$("ca"),new TXT$("dabra"),new TXT$("abracadabra"));
        ;
        new simtst130$simtst130$PBLK16$testConcatenations$testConc5((CUR$),new TXT$("ab"),new TXT$("ra"),new TXT$("ca"),new TXT$("da"),new TXT$("bra"),new TXT$("abracadabra"));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST conc --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testConcatenations",1,234,13,265,16,266,19,267,22,268,25,269,28,270,31,271,36,273);
}
