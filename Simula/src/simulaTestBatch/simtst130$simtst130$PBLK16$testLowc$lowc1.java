package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testLowc$lowc1 extends PROC$ {
    public char RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public char p$c;
    public simtst130$simtst130$PBLK16$testLowc$lowc1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$c=(char)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testLowc$lowc1(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst130$simtst130$PBLK16$testLowc$lowc1(RTObject$ SL$,char sp$c) {
        super(SL$);
        this.p$c = sp$c;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testLowc$lowc1 STM$() {
        RESULT$=(((!(ENVIRONMENT$.letter(p$c))))?(p$c):((((p$c<('a')))?(ENVIRONMENT$.char$(Math.addExact(Math.subtractExact(ENVIRONMENT$.rank(p$c),ENVIRONMENT$.rank('A')),ENVIRONMENT$.rank('a')))):(p$c))));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure lowc1",1,774,30,775,34,777);
}
