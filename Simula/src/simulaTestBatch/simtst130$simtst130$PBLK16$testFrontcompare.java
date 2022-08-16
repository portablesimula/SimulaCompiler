package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testFrontcompare extends PROC$ {
    public simtst130$simtst130$PBLK16$testFrontcompare(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testFrontcompare STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST frontcompare --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=new TXT$("Abracadabra");
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,1);
        ;
        new simtst130$simtst130$PBLK16$testFrontcompare$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("Abrac"),true);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=new TXT$("Abracadabra");
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,6);
        ;
        new simtst130$simtst130$PBLK16$testFrontcompare$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("Abrac"),false);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=new TXT$("Abracadabra");
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,8);
        ;
        new simtst130$simtst130$PBLK16$testFrontcompare$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("abra"),true);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("Abracadabra")));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=TXT$.sub(((simtst130$PBLK16)(CUR$.SL$)).t1$1,4,8);
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,4);
        ;
        new simtst130$simtst130$PBLK16$testFrontcompare$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("Abracabra"),false);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("Abracadabra")));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=TXT$.sub(((simtst130$PBLK16)(CUR$.SL$)).t1$1,4,8);
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,4);
        ;
        new simtst130$simtst130$PBLK16$testFrontcompare$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("dabra"),true);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST frontcompare --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testFrontcompare",1,466,13,481,16,482,23,483,30,484,37,485,46,486,55,487,60,489);
}
