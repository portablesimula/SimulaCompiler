package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testGetitem extends PROC$ {
    public simtst130$simtst130$PBLK16$testGetitem(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testGetitem STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST getitem --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=ENVIRONMENT$.copy(copy(new TXT$("XXXIF car.wheel\u005fsize > 13.5")));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).t1$1=TXT$.sub(((simtst130$PBLK16)(CUR$.SL$)).t1$1,4,Math.subtractExact(TXT$.length(((simtst130$PBLK16)(CUR$.SL$)).t1$1),3));
        ;
        new simtst130$simtst130$PBLK16$testGetitem$test((CUR$),new NAME$<TXT$>(){ public TXT$ get() { return(((simtst130$PBLK16)(CUR$.SL$)).t1$1); } public TXT$ put(TXT$ x$) { return(((simtst130$PBLK16)(CUR$.SL$)).t1$1=(TXT$)x$); } },new TXT$("IF"),3);
        ;
        new simtst130$simtst130$PBLK16$testGetitem$test((CUR$),new NAME$<TXT$>(){ public TXT$ get() { return(((simtst130$PBLK16)(CUR$.SL$)).t1$1); } public TXT$ put(TXT$ x$) { return(((simtst130$PBLK16)(CUR$.SL$)).t1$1=(TXT$)x$); } },new TXT$("car"),7);
        ;
        new simtst130$simtst130$PBLK16$testGetitem$test((CUR$),new NAME$<TXT$>(){ public TXT$ get() { return(((simtst130$PBLK16)(CUR$.SL$)).t1$1); } public TXT$ put(TXT$ x$) { return(((simtst130$PBLK16)(CUR$.SL$)).t1$1=(TXT$)x$); } },new TXT$("."),8);
        ;
        new simtst130$simtst130$PBLK16$testGetitem$test((CUR$),new NAME$<TXT$>(){ public TXT$ get() { return(((simtst130$PBLK16)(CUR$.SL$)).t1$1); } public TXT$ put(TXT$ x$) { return(((simtst130$PBLK16)(CUR$.SL$)).t1$1=(TXT$)x$); } },new TXT$("wheel"),13);
        ;
        new simtst130$simtst130$PBLK16$testGetitem$test((CUR$),new NAME$<TXT$>(){ public TXT$ get() { return(((simtst130$PBLK16)(CUR$.SL$)).t1$1); } public TXT$ put(TXT$ x$) { return(((simtst130$PBLK16)(CUR$.SL$)).t1$1=(TXT$)x$); } },new TXT$("\u005f"),14);
        ;
        new simtst130$simtst130$PBLK16$testGetitem$test((CUR$),new NAME$<TXT$>(){ public TXT$ get() { return(((simtst130$PBLK16)(CUR$.SL$)).t1$1); } public TXT$ put(TXT$ x$) { return(((simtst130$PBLK16)(CUR$.SL$)).t1$1=(TXT$)x$); } },new TXT$("size"),18);
        ;
        new simtst130$simtst130$PBLK16$testGetitem$test((CUR$),new NAME$<TXT$>(){ public TXT$ get() { return(((simtst130$PBLK16)(CUR$.SL$)).t1$1); } public TXT$ put(TXT$ x$) { return(((simtst130$PBLK16)(CUR$.SL$)).t1$1=(TXT$)x$); } },new TXT$(">"),20);
        ;
        new simtst130$simtst130$PBLK16$testGetitem$test((CUR$),new NAME$<TXT$>(){ public TXT$ get() { return(((simtst130$PBLK16)(CUR$.SL$)).t1$1); } public TXT$ put(TXT$ x$) { return(((simtst130$PBLK16)(CUR$.SL$)).t1$1=(TXT$)x$); } },new TXT$("13.5"),25);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST getitem --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testGetitem",1,520,13,559,16,563,21,564,30,565,39,566,44,568);
}
