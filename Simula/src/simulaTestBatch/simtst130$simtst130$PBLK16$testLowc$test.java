package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testLowc$test extends PROC$ {
    public char p$c;
    public char c1=0;
    public char c2=0;
    public simtst130$simtst130$PBLK16$testLowc$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$c=(char)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testLowc$test(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst130$simtst130$PBLK16$testLowc$test(RTObject$ SL$,char sp$c) {
        super(SL$);
        this.p$c = sp$c;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testLowc$test STM$() {
        c1=simtst130$PBLK16.lowc(p$c);
        ;
        c2=new simtst130$simtst130$PBLK16$testLowc$lowc1((CUR$.SL$),p$c).RESULT$;
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(new TXT$("Test  lowc("),ENVIRONMENT$.edit(p$c)),new TXT$(") ")),new TXT$(" ==> '")),ENVIRONMENT$.edit(c1)),new TXT$("'")));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(new TXT$("Test lowc1("),ENVIRONMENT$.edit(p$c)),new TXT$(") ")),new TXT$(" ==> '")),ENVIRONMENT$.edit(c2)),new TXT$("'")));
        ;
        if(VALUE$((c1!=(c2)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),new TXT$("Test  lowc FAILED"));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,779,8,780,31,781,36,782,39,783,42,784,49,785);
}
