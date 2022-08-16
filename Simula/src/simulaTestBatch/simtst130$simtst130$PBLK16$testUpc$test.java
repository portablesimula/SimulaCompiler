package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testUpc$test extends PROC$ {
    public char p$c;
    public simtst130$simtst130$PBLK16$testUpc$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$c=(char)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testUpc$test(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst130$simtst130$PBLK16$testUpc$test(RTObject$ SL$,char sp$c) {
        super(SL$);
        this.p$c = sp$c;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testUpc$test STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(new TXT$("Test  upc("),ENVIRONMENT$.edit(p$c)),new TXT$(") ==> ")),ENVIRONMENT$.edit(simtst130$PBLK16.upc(p$c))));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(new TXT$("Test upc1("),ENVIRONMENT$.edit(p$c)),new TXT$(") ==> ")),ENVIRONMENT$.edit(new simtst130$simtst130$PBLK16$testUpc$upc1((CUR$.SL$),p$c).RESULT$)));
        ;
        if(VALUE$((simtst130$PBLK16.upc(p$c)!=(new simtst130$simtst130$PBLK16$testUpc$upc1((CUR$.SL$),p$c).RESULT$)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(CONC(new TXT$("Test upc("),ENVIRONMENT$.edit(p$c)),new TXT$(") FAILED")));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,1124,28,1125,31,1126,34,1127,41,1128);
}
