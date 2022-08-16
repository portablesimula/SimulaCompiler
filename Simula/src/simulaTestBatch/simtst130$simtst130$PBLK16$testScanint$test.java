package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testScanint$test extends PROC$ {
    public TXT$ p$t;
    public int p$expectedPosAfter;
    public int i1=0;
    public int i2=0;
    public TXT$ x=null;
    public int pos=0;
    public simtst130$simtst130$PBLK16$testScanint$test setPar(Object param) {
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
    public simtst130$simtst130$PBLK16$testScanint$test(RTObject$ SL$) {
        super(SL$,2);
    }
    public simtst130$simtst130$PBLK16$testScanint$test(RTObject$ SL$,TXT$ sp$t,int sp$expectedPosAfter) {
        super(SL$);
        this.p$t = sp$t;
        this.p$expectedPosAfter = sp$expectedPosAfter;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testScanint$test STM$() {
        pos=TXT$.pos(p$t);
        ;
        x=ENVIRONMENT$.copy(copy(p$t));
        ;
        TXT$.setpos(x,pos);
        ;
        i1=simtst130$PBLK16.scanint(new NAME$<TXT$>(){ public TXT$ get() { return(p$t); } public TXT$ put(TXT$ x$) { return(p$t=(TXT$)x$); } });
        ;
        i2=new simtst130$simtst130$PBLK16$testScanint$scanint1((CUR$.SL$),new NAME$<TXT$>(){ public TXT$ get() { return(x); } public TXT$ put(TXT$ x$) { return(x=(TXT$)x$); } }).RESULT$;
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(new TXT$("Test  scanint("),p$t),new TXT$(") ==> '")),ENVIRONMENT$.edit(i1)),new TXT$("'")));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(new TXT$("Test scanint1("),p$t),new TXT$(") ==> '")),ENVIRONMENT$.edit(i2)),new TXT$("'")));
        ;
        if(VALUE$((i1!=(i2)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),new TXT$("Test  scanint FAILED"));
        }
        ;
        if(VALUE$((TXT$.pos(p$t)!=(p$expectedPosAfter)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  scanint FAILED: t.pos="),ENVIRONMENT$.edit(TXT$.pos(p$t))));
        }
        ;
        if(VALUE$((TXT$.pos(x)!=(p$expectedPosAfter)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  scanint1 FAILED: x.pos="),ENVIRONMENT$.edit(TXT$.pos(x))));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,944,9,945,12,946,39,947,44,948,49,949,52,950,55,951,60,952,65,953,72,954);
}
