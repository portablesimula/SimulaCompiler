package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testUpcompare$upcompare1 extends PROC$ {
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public TXT$ p$master;
    public TXT$ p$test;
    public simtst130$simtst130$PBLK16$testUpcompare$upcompare1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 2: p$master=(TXT$)objectValue(param); break;
                case 1: p$test=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testUpcompare$upcompare1(RTObject$ SL$) {
        super(SL$,2);
    }
    public simtst130$simtst130$PBLK16$testUpcompare$upcompare1(RTObject$ SL$,TXT$ sp$master,TXT$ sp$test) {
        super(SL$);
        this.p$master = sp$master;
        this.p$test = sp$test;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testUpcompare$upcompare1 STM$() {
        if(VALUE$((Math.addExact(TXT$.pos(p$master),TXT$.length(p$test))<=(Math.addExact(TXT$.length(p$master),1))))) {
            new simtst130$simtst130$PBLK16$testUpcompare$upcompare1$SubBlock1149((CUR$)).STM$();
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure upcompare1",1,1137,33,1138,35,1149,40,1149);
}
