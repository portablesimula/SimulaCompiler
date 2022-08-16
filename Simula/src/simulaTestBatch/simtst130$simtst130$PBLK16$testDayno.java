package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testDayno extends PROC$ {
    public simtst130$simtst130$PBLK16$testDayno(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testDayno STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST testDayno --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).i$1=new simtst130$simtst130$PBLK16$testDayno$dayno1((CUR$)).RESULT$;
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(CONC(CONC(new TXT$("Test dayno1 ==> '"),ENVIRONMENT$.edit(((simtst130$PBLK16)(CUR$.SL$)).i$1)),new TXT$("'   pos=")),ENVIRONMENT$.edit(TXT$.pos(((simtst130$PBLK16)(CUR$.SL$)).t1$1))));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).j$1=simtst130$PBLK16.dayno();
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(CONC(CONC(new TXT$("Test  dayno ==> '"),ENVIRONMENT$.edit(((simtst130$PBLK16)(CUR$.SL$)).j$1)),new TXT$("'   pos=")),ENVIRONMENT$.edit(TXT$.pos(((simtst130$PBLK16)(CUR$.SL$)).t1$1))));
        ;
        if(VALUE$((((simtst130$PBLK16)(CUR$.SL$)).i$1!=(((simtst130$PBLK16)(CUR$.SL$)).j$1)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$),new TXT$("Test  dayno FAILED"));
        }
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST testDayno --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testDayno",1,286,13,289,16,290,21,291,26,292,31,293,36,295);
}
