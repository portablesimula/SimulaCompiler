package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testUpc extends PROC$ {
    public simtst130$simtst130$PBLK16$testUpc(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testUpc STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST upc --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        for(((simtst130$PBLK16)(CUR$.SL$)).i$1=0;((simtst130$PBLK16)(CUR$.SL$)).i$1<=127;((simtst130$PBLK16)(CUR$.SL$)).i$1++) {
            new simtst130$simtst130$PBLK16$testUpc$test((CUR$),ENVIRONMENT$.char$(((simtst130$PBLK16)(CUR$.SL$)).i$1));
        }
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST upc --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testUpc",1,1118,13,1130,17,1131,21,1132,26,1134);
}
