package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testDaytime extends PROC$ {
    public simtst130$simtst130$PBLK16$testDaytime(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testDaytime STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST testDaytime --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=new simtst130$simtst130$PBLK16$testDaytime$daytime1((CUR$)).RESULT$;
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(CONC(CONC(new TXT$("Test daytime1 ==> '"),((simtst130$PBLK16)(CUR$.SL$)).t1$1),new TXT$("'   pos=")),ENVIRONMENT$.edit(TXT$.pos(((simtst130$PBLK16)(CUR$.SL$)).t1$1))));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t2$1=simtst130$PBLK16.daytime();
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(CONC(CONC(new TXT$("Test  daytime ==> '"),((simtst130$PBLK16)(CUR$.SL$)).t1$1),new TXT$("'   pos=")),ENVIRONMENT$.edit(TXT$.pos(((simtst130$PBLK16)(CUR$.SL$)).t1$1))));
        ;
        if(VALUE$(TXTREL$NE(((simtst130$PBLK16)(CUR$.SL$)).t1$1,((simtst130$PBLK16)(CUR$.SL$)).t2$1))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$),new TXT$("Test  daytime FAILED"));
        }
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST testDaytime --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testDaytime",1,308,13,311,16,312,21,313,26,314,31,315,36,317);
}
