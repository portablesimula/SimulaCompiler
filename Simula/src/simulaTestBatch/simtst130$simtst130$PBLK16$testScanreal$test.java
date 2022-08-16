package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testScanreal$test extends PROC$ {
    public TXT$ p$t;
    public int p$expectedPosAfter;
    public double lr1=0.0d;
    public double lr2=0.0d;
    public TXT$ x=null;
    public int pos=0;
    public simtst130$simtst130$PBLK16$testScanreal$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 2: p$t=(TXT$)objectValue(param); break;
                case 1: p$expectedPosAfter=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testScanreal$test(RTObject$ SL$) {
        super(SL$,2);
    }
    public simtst130$simtst130$PBLK16$testScanreal$test(RTObject$ SL$,TXT$ sp$t,int sp$expectedPosAfter) {
        super(SL$);
        this.p$t = sp$t;
        this.p$expectedPosAfter = sp$expectedPosAfter;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testScanreal$test STM$() {
        pos=TXT$.pos(p$t);
        ;
        x=ENVIRONMENT$.copy(copy(p$t));
        ;
        TXT$.setpos(x,pos);
        ;
        lr1=((double)(simtst130$PBLK16.scanreal(new NAME$<TXT$>(){ public TXT$ get() { return(p$t); } public TXT$ put(TXT$ x$) { return(p$t=(TXT$)x$); } })));
        ;
        lr2=new simtst130$simtst130$PBLK16$testScanreal$scanreal1((CUR$.SL$),new NAME$<TXT$>(){ public TXT$ get() { return(x); } public TXT$ put(TXT$ x$) { return(x=(TXT$)x$); } }).RESULT$;
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(new TXT$("Test  scanreal("),p$t),new TXT$(") ==> '")),ENVIRONMENT$.edit(lr1)),new TXT$("'  ExpectedPosAfter=")),ENVIRONMENT$.edit(p$expectedPosAfter)));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(new TXT$("Test scanreal1("),p$t),new TXT$(") ==> '")),ENVIRONMENT$.edit(lr2)),new TXT$("'  ExpectedPosAfter=")),ENVIRONMENT$.edit(p$expectedPosAfter)));
        ;
        if(VALUE$((lr1!=(lr2)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),new TXT$("Test  scanreal FAILED"));
        }
        ;
        if(VALUE$((TXT$.pos(p$t)!=(p$expectedPosAfter)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  scanreal FAILED: t.pos="),ENVIRONMENT$.edit(TXT$.pos(p$t))));
        }
        ;
        if(VALUE$((TXT$.pos(x)!=(p$expectedPosAfter)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  scanreal1 FAILED: x.pos="),ENVIRONMENT$.edit(TXT$.pos(x))));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,978,9,979,12,980,39,981,44,982,49,983,52,984,55,985,60,986,65,987,72,988);
}
