package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testScanchar$test extends PROC$ {
    public TXT$ p$t;
    public char p$expectedValue;
    public int p$expectedPosAfter;
    public char c1=0;
    public char c2=0;
    public TXT$ x=null;
    public int pos=0;
    public simtst130$simtst130$PBLK16$testScanchar$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 3: p$t=(TXT$)objectValue(param); break;
                case 2: p$expectedValue=(char)objectValue(param); break;
                case 1: p$expectedPosAfter=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testScanchar$test(RTObject$ SL$) {
        super(SL$,3);
    }
    public simtst130$simtst130$PBLK16$testScanchar$test(RTObject$ SL$,TXT$ sp$t,char sp$expectedValue,int sp$expectedPosAfter) {
        super(SL$);
        this.p$t = sp$t;
        this.p$expectedValue = sp$expectedValue;
        this.p$expectedPosAfter = sp$expectedPosAfter;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testScanchar$test STM$() {
        pos=TXT$.pos(p$t);
        ;
        x=ENVIRONMENT$.copy(copy(p$t));
        ;
        TXT$.setpos(x,pos);
        ;
        c1=simtst130$PBLK16.scanchar(new NAME$<TXT$>(){ public TXT$ get() { return(p$t); } public TXT$ put(TXT$ x$) { return(p$t=(TXT$)x$); } });
        ;
        c2=new simtst130$simtst130$PBLK16$testScanchar$scanchar1((CUR$.SL$),new NAME$<TXT$>(){ public TXT$ get() { return(x); } public TXT$ put(TXT$ x$) { return(x=(TXT$)x$); } }).RESULT$;
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  scanchar("),p$t),new TXT$(") ==> '")),p$t),new TXT$("':")),ENVIRONMENT$.edit(c1)),new TXT$("   expectedValue=")),ENVIRONMENT$.edit(p$expectedValue)),new TXT$(", expectedPosAfter=")),ENVIRONMENT$.edit(p$expectedPosAfter)));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test scanchar1("),x),new TXT$(") ==> '")),x),new TXT$("':")),ENVIRONMENT$.edit(c2)),new TXT$("   expectedValue=")),ENVIRONMENT$.edit(p$expectedValue)),new TXT$(", expectedPosAfter=")),ENVIRONMENT$.edit(p$expectedPosAfter)));
        ;
        if(VALUE$((c1!=(p$expectedValue)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  scanchar FAILED: result="),ENVIRONMENT$.edit(c1)));
        }
        ;
        if(VALUE$((c2!=(p$expectedValue)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  scanchar1 FAILED: result="),ENVIRONMENT$.edit(c2)));
        }
        ;
        if(VALUE$((TXT$.pos(p$t)!=(p$expectedPosAfter)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  scanchar FAILED: t.pos="),ENVIRONMENT$.edit(TXT$.pos(p$t))));
        }
        ;
        if(VALUE$((TXT$.pos(x)!=(p$expectedPosAfter)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  scanchar1 FAILED: x.pos="),ENVIRONMENT$.edit(TXT$.pos(x))));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,879,10,880,39,881,46,883,51,884,54,885,57,886,62,887,67,888,72,889,79,890);
}
