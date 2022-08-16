package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testConcatenations$testConc3 extends PROC$ {
    public TXT$ p$t1;
    public TXT$ p$t2;
    public TXT$ p$t3;
    public TXT$ p$expectedValue;
    public TXT$ res=null;
    public simtst130$simtst130$PBLK16$testConcatenations$testConc3 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 4: p$t1=(TXT$)objectValue(param); break;
                case 3: p$t2=(TXT$)objectValue(param); break;
                case 2: p$t3=(TXT$)objectValue(param); break;
                case 1: p$expectedValue=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testConcatenations$testConc3(RTObject$ SL$) {
        super(SL$,4);
    }
    public simtst130$simtst130$PBLK16$testConcatenations$testConc3(RTObject$ SL$,TXT$ sp$t1,TXT$ sp$t2,TXT$ sp$t3,TXT$ sp$expectedValue) {
        super(SL$);
        this.p$t1 = sp$t1;
        this.p$t2 = sp$t2;
        this.p$t3 = sp$t3;
        this.p$expectedValue = sp$expectedValue;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testConcatenations$testConc3 STM$() {
        res=simtst130$PBLK16.conc3(p$t1,p$t2,p$t3);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  conc3("),p$t1),new TXT$(",")),p$t2),new TXT$(",")),p$t3),new TXT$(") ==> '")),res),new TXT$("'   expectedValue=")),p$expectedValue));
        ;
        if(VALUE$(TXTREL$NE(res,p$expectedValue))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  testConc3 FAILED: result="),res));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testConc3",1,247,11,248,41,249,44,250,51,251);
}
