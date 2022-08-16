package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testUpcompare extends PROC$ {
    public simtst130$simtst130$PBLK16$testUpcompare(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testUpcompare STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST upcompare --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        new simtst130$simtst130$PBLK16$testUpcompare$test((CUR$),new TXT$("begin"),new TXT$("BEG"),true);
        ;
        new simtst130$simtst130$PBLK16$testUpcompare$test((CUR$),new TXT$("begin"),new TXT$("beg"),false);
        ;
        new simtst130$simtst130$PBLK16$testUpcompare$test((CUR$),new TXT$("begin"),new TXT$("BEG"),true);
        ;
        new simtst130$simtst130$PBLK16$testUpcompare$test((CUR$),new TXT$("begin"),new TXT$("beg"),false);
        ;
        new simtst130$simtst130$PBLK16$testUpcompare$test((CUR$),new TXT$("xxxxx"),new TXT$("BEG"),false);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("begin procedure XXX")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,7);
        ;
        new simtst130$simtst130$PBLK16$testUpcompare$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("PROC"),true);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST upcompare --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testUpcompare",1,1136,13,1161,16,1162,19,1163,22,1164,25,1165,28,1166,31,1167,36,1168,39,1169,44,1171);
}
