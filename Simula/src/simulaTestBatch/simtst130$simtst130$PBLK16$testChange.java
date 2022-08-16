package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testChange extends PROC$ {
    public simtst130$simtst130$PBLK16$testChange(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testChange STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST change --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("abracadabra")));
        ;
        new simtst130$simtst130$PBLK16$testChange$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("dab"),new TXT$("DAB"),true,new TXT$("abracaDABra"),10);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("abracadabra")));
        ;
        new simtst130$simtst130$PBLK16$testChange$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("dab"),new TXT$("DA"),true,new TXT$("abracaDAra"),9);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("abracadabra")));
        ;
        new simtst130$simtst130$PBLK16$testChange$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("dab"),new TXT$("DABER"),true,new TXT$("abracaDABERra"),12);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("abracadabra")));
        ;
        new simtst130$simtst130$PBLK16$testChange$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("DAS"),new TXT$("DO"),false,new TXT$("abracadabra"),12);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("...AA...AA...CCCCAA")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,11);
        ;
        new simtst130$simtst130$PBLK16$testChange$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("AA"),new TXT$("CC"),true,new TXT$("...AA...AA...CCCCCC"),20);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("...AA...AA...CCCCAA")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,11);
        ;
        new simtst130$simtst130$PBLK16$testChange$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("AA"),new TXT$("DDD"),true,new TXT$("...AA...AA...CCCCDDD"),21);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("...AA...AA...CCCCAA")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,11);
        ;
        new simtst130$simtst130$PBLK16$testChange$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("AA"),new TXT$("F"),true,new TXT$("...AA...AA...CCCCF"),19);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("...AA...AA...CCCCAA")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,7);
        ;
        new simtst130$simtst130$PBLK16$testChange$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("AA"),new TXT$("CC"),true,new TXT$("...AA...CC...CCCCAA"),11);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("...AA...AA...CCCCAA")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,7);
        ;
        new simtst130$simtst130$PBLK16$testChange$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("AA"),new TXT$("DDD"),true,new TXT$("...AA...DDD...CCCCAA"),12);
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("...AA...AA...CCCCAA")));
        ;
        TXT$.setpos(((simtst130$PBLK16)(CUR$.SL$)).t1$1,7);
        ;
        new simtst130$simtst130$PBLK16$testChange$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).t1$1,new TXT$("AA"),new TXT$("F"),true,new TXT$("...AA...F...CCCCAA"),10);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST change --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testChange",1,43,13,81,16,82,21,83,26,84,31,85,36,87,43,88,50,89,57,91,64,92,71,93,78,94,83,95);
}
