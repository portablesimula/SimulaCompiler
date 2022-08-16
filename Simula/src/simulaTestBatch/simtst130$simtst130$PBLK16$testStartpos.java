package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testStartpos extends PROC$ {
    public simtst130$simtst130$PBLK16$testStartpos(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testStartpos STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST startpos --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.blanks(100);
        ;
        new simtst130$simtst130$PBLK16$testStartpos$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1);
        ;
        new simtst130$simtst130$PBLK16$testStartpos$test((CUR$),TXT$.sub(((simtst130$PBLK16)(CUR$.SL$)).t1$1,30,10));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST startpos --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testStartpos",1,1079,13,1089,16,1090,19,1091,22,1092,25,1093,30,1095);
}
