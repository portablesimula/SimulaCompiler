package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testInitem extends PROC$ {
    public final int nTests=(int)(10);
    public simtst130$simtst130$PBLK16$testInitem(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testInitem STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST initem --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        new simtst130$simtst130$PBLK16$testInitem$createImagefile((CUR$),new outfile$(CTX$,new TXT$("simtst130-TEMP1")).STM$());
        ;
        new simtst130$simtst130$PBLK16$testInitem$testImagefile((CUR$),new TXT$("simtst130-TEMP1"));
        ;
        new simtst130$simtst130$PBLK16$testInitem$createDirectfile((CUR$),new directfile$(CTX$,new TXT$("simtst130-TEMP2")).STM$());
        ;
        new simtst130$simtst130$PBLK16$testInitem$testDirectfile((CUR$),new TXT$("simtst130-TEMP2"));
        ;
        new simtst130$simtst130$PBLK16$testInitem$createBytefile((CUR$),new outbytefile$(CTX$,new TXT$("simtst130-TEMP3")).STM$());
        ;
        new simtst130$simtst130$PBLK16$testInitem$testBytefile((CUR$),new TXT$("simtst130-TEMP3"));
        ;
        new simtst130$simtst130$PBLK16$testInitem$createDirectBytefile((CUR$),new directbytefile$(CTX$,new TXT$("simtst130-TEMP4")).STM$());
        ;
        new simtst130$simtst130$PBLK16$testInitem$testDirectBytefile((CUR$),new TXT$("simtst130-TEMP4"));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST initem --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testInitem",1,604,7,625,15,717,18,718,23,719,28,720,33,721,38,722,43,724);
}
