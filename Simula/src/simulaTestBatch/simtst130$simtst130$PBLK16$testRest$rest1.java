package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testRest$rest1 extends PROC$ {
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public TXT$ p$t;
    public simtst130$simtst130$PBLK16$testRest$rest1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$t=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testRest$rest1(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst130$simtst130$PBLK16$testRest$rest1(RTObject$ SL$,TXT$ sp$t) {
        super(SL$);
        this.p$t = sp$t;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testRest$rest1 STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(new TXT$("rest1("),p$t),new TXT$(") t.pos=")),ENVIRONMENT$.edit(sysout().pos())));
        ;
        RESULT$=TXT$.sub(p$t,TXT$.pos(p$t),Math.subtractExact(Math.addExact(TXT$.length(p$t),1),TXT$.pos(p$t)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure rest1",1,853,30,854,33,855,38,856);
}
