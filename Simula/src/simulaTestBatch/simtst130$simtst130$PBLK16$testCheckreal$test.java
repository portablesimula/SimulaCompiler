package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testCheckreal$test extends PROC$ {
    public TXT$ p$t;
    public int p$expectedValue;
    public int p$expectedPosAfter;
    public int res=0;
    public simtst130$simtst130$PBLK16$testCheckreal$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 3: p$t=(TXT$)objectValue(param); break;
                case 2: p$expectedValue=intValue(param); break;
                case 1: p$expectedPosAfter=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testCheckreal$test(RTObject$ SL$) {
        super(SL$,3);
    }
    public simtst130$simtst130$PBLK16$testCheckreal$test(RTObject$ SL$,TXT$ sp$t,int sp$expectedValue,int sp$expectedPosAfter) {
        super(SL$);
        this.p$t = sp$t;
        this.p$expectedValue = sp$expectedValue;
        this.p$expectedPosAfter = sp$expectedPosAfter;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testCheckreal$test STM$() {
        res=simtst130$PBLK16.checkreal(new NAME$<TXT$>(){ public TXT$ get() { return(p$t); } public TXT$ put(TXT$ x$) { return(p$t=(TXT$)x$); } });
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  checkreal("),p$t),new TXT$(") ==> '")),ENVIRONMENT$.edit(res)),new TXT$("'   expectedValue=")),ENVIRONMENT$.edit(p$expectedValue)),new TXT$(", expectedPosAfter=")),ENVIRONMENT$.edit(p$expectedPosAfter)));
        ;
        if(VALUE$((res!=(p$expectedValue)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  checkreal FAILED: result="),ENVIRONMENT$.edit(res)));
        }
        ;
        if(VALUE$((TXT$.pos(p$t)!=(p$expectedPosAfter)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  checkreal FAILED: t.pos="),ENVIRONMENT$.edit(TXT$.pos(p$t))));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,179,10,180,36,181,39,182,42,183,47,184,54,185);
}
