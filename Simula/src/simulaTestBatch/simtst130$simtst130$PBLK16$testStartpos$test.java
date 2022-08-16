package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testStartpos$test extends PROC$ {
    public TXT$ p$t;
    public simtst130$simtst130$PBLK16$testStartpos$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$t=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testStartpos$test(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst130$simtst130$PBLK16$testStartpos$test(RTObject$ SL$,TXT$ sp$t) {
        super(SL$);
        this.p$t = sp$t;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testStartpos$test STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(new TXT$("Test  startpos ==> "),ENVIRONMENT$.edit(simtst130$PBLK16.startpos(p$t))));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(new TXT$("Test startpos1 ==> "),ENVIRONMENT$.edit(new simtst130$simtst130$PBLK16$testStartpos$startpos1((CUR$.SL$),p$t).RESULT$)));
        ;
        if(VALUE$((simtst130$PBLK16.startpos(p$t)!=(new simtst130$simtst130$PBLK16$testStartpos$startpos1((CUR$.SL$),p$t).RESULT$)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),new TXT$("Test  startpos FAILED"));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,1083,28,1084,31,1085,34,1086,41,1087);
}
