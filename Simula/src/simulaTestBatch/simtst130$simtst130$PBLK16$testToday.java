package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testToday extends PROC$ {
    public simtst130$simtst130$PBLK16$testToday(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testToday STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST today --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("Test  today ==> "),simtst130$PBLK16.today()));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("Test today1 ==> "),new simtst130$simtst130$PBLK16$testToday$today1((CUR$)).RESULT$));
        ;
        if(VALUE$(TXTREL$NE(simtst130$PBLK16.today(),new simtst130$simtst130$PBLK16$testToday$today1((CUR$)).RESULT$))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$),new TXT$("Test  today FAILED"));
        }
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST today --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testToday",1,297,13,300,16,301,19,302,22,303,27,304,32,306);
}
