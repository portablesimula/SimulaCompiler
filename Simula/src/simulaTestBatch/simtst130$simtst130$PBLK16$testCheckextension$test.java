package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testCheckextension$test extends PROC$ {
    public TXT$ p$t;
    public TXT$ p$defaultextension;
    public TXT$ p$expectedValue;
    public TXT$ res=null;
    public simtst130$simtst130$PBLK16$testCheckextension$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 3: p$t=(TXT$)objectValue(param); break;
                case 2: p$defaultextension=(TXT$)objectValue(param); break;
                case 1: p$expectedValue=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testCheckextension$test(RTObject$ SL$) {
        super(SL$,3);
    }
    public simtst130$simtst130$PBLK16$testCheckextension$test(RTObject$ SL$,TXT$ sp$t,TXT$ sp$defaultextension,TXT$ sp$expectedValue) {
        super(SL$);
        this.p$t = sp$t;
        this.p$defaultextension = sp$defaultextension;
        this.p$expectedValue = sp$expectedValue;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testCheckextension$test STM$() {
        res=simtst130$PBLK16.checkextension(p$t,copy(p$defaultextension));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  checkextension("),p$t),new TXT$(",")),p$defaultextension),new TXT$(") ==> '")),res),new TXT$("'   expectedValue=")),p$expectedValue));
        ;
        if(VALUE$(TXTREL$NE(res,p$expectedValue))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  checkextension FAILED: result="),res));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,129,10,130,38,131,41,132,48,133);
}
