package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testUpto extends PROC$ {
    public simtst130$simtst130$PBLK16$testUpto(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testUpto STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST upto --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        new simtst130$simtst130$PBLK16$testUpto$test((CUR$),new TXT$(""),6);
        ;
        new simtst130$simtst130$PBLK16$testUpto$test((CUR$),new TXT$("abracadab"),(-(6)));
        ;
        new simtst130$simtst130$PBLK16$testUpto$test((CUR$),new TXT$("abracadab"),26);
        ;
        new simtst130$simtst130$PBLK16$testUpto$test((CUR$),new TXT$("abracadab"),6);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST upto --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testUpto",1,1173,13,1183,16,1184,19,1185,22,1186,25,1187,28,1188,33,1190);
}
