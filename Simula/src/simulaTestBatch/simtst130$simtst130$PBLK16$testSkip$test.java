package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testSkip$test extends PROC$ {
    public TXT$ p$t;
    public char p$c;
    public int p$expectedPosAfter;
    public TXT$ t1=null;
    public TXT$ t2=null;
    public TXT$ x=null;
    public simtst130$simtst130$PBLK16$testSkip$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 3: p$t=(TXT$)objectValue(param); break;
                case 2: p$c=(char)objectValue(param); break;
                case 1: p$expectedPosAfter=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testSkip$test(RTObject$ SL$) {
        super(SL$,3);
    }
    public simtst130$simtst130$PBLK16$testSkip$test(RTObject$ SL$,TXT$ sp$t,char sp$c,int sp$expectedPosAfter) {
        super(SL$);
        this.p$t = sp$t;
        this.p$c = sp$c;
        this.p$expectedPosAfter = sp$expectedPosAfter;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testSkip$test STM$() {
        x=ENVIRONMENT$.copy(copy(p$t));
        ;
        t1=simtst130$PBLK16.skip(new NAME$<TXT$>(){ public TXT$ get() { return(p$t); } public TXT$ put(TXT$ x$) { return(p$t=(TXT$)x$); } },p$c);
        ;
        t2=new simtst130$simtst130$PBLK16$testSkip$skip1((CUR$.SL$),new NAME$<TXT$>(){ public TXT$ get() { return(x); } public TXT$ put(TXT$ x$) { return(x=(TXT$)x$); } },p$c).RESULT$;
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  skip("),p$t),new TXT$(",")),ENVIRONMENT$.edit(p$c)),new TXT$(") ==> '")),t1),new TXT$("'   expectedPosAfter=")),ENVIRONMENT$.edit(p$expectedPosAfter)));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test skip1("),p$t),new TXT$(",")),ENVIRONMENT$.edit(p$c)),new TXT$(") ==> '")),t2),new TXT$("'   expectedPosAfter=")),ENVIRONMENT$.edit(p$expectedPosAfter)));
        ;
        if(VALUE$(TXTREL$NE(t1,t2))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),new TXT$("Test  skip FAILED"));
        }
        ;
        if(VALUE$((TXT$.pos(p$t)!=(p$expectedPosAfter)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  skip FAILED: t.pos="),ENVIRONMENT$.edit(TXT$.pos(p$t))));
        }
        ;
        if(VALUE$((TXT$.pos(x)!=(p$expectedPosAfter)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  skip1 FAILED: x.pos="),ENVIRONMENT$.edit(TXT$.pos(x))));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,1063,10,1064,44,1065,47,1066,50,1067,55,1068,60,1069,67,1070);
}
