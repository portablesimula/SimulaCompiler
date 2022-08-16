package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testUpcompare$test extends PROC$ {
    public TXT$ p$master;
    public TXT$ p$test;
    public boolean p$expectedResult;
    public boolean result=false;
    public boolean result1=false;
    public simtst130$simtst130$PBLK16$testUpcompare$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 3: p$master=(TXT$)objectValue(param); break;
                case 2: p$test=(TXT$)objectValue(param); break;
                case 1: p$expectedResult=(boolean)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testUpcompare$test(RTObject$ SL$) {
        super(SL$,3);
    }
    public simtst130$simtst130$PBLK16$testUpcompare$test(RTObject$ SL$,TXT$ sp$master,TXT$ sp$test,boolean sp$expectedResult) {
        super(SL$);
        this.p$master = sp$master;
        this.p$test = sp$test;
        this.p$expectedResult = sp$expectedResult;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testUpcompare$test STM$() {
        result=simtst130$PBLK16.upcompare(p$master,p$test);
        ;
        result1=new simtst130$simtst130$PBLK16$testUpcompare$upcompare1((CUR$.SL$),p$master,p$test).RESULT$;
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(new TXT$("Test  upcompare("),p$master),new TXT$(",")),p$test),new TXT$(") ==> ")),ENVIRONMENT$.edit(result)));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(new TXT$("Test upcompare1("),p$master),new TXT$(",")),p$test),new TXT$(") ==> ")),ENVIRONMENT$.edit(result1)));
        ;
        if(VALUE$((result!=(result1)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(new TXT$("Test upcompare("),p$master),new TXT$(",")),p$test),new TXT$(") FAILED - not equal")));
        }
        ;
        if(VALUE$((result!=(p$expectedResult)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(new TXT$("Test upcompare("),p$master),new TXT$(",")),p$test),new TXT$(") FAILED - Wrong result")));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,1151,10,1152,37,1153,40,1154,43,1155,46,1156,49,1157,54,1158,61,1159);
}
