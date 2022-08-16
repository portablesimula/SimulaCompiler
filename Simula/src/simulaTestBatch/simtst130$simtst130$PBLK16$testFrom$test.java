package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testFrom$test extends PROC$ {
    public TXT$ p$t;
    public int p$p;
    public TXT$ p$expectedValue;
    public TXT$ res=null;
    public TXT$ rs1=null;
    public simtst130$simtst130$PBLK16$testFrom$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 3: p$t=(TXT$)objectValue(param); break;
                case 2: p$p=intValue(param); break;
                case 1: p$expectedValue=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testFrom$test(RTObject$ SL$) {
        super(SL$,3);
    }
    public simtst130$simtst130$PBLK16$testFrom$test(RTObject$ SL$,TXT$ sp$t,int sp$p,TXT$ sp$expectedValue) {
        super(SL$);
        this.p$t = sp$t;
        this.p$p = sp$p;
        this.p$expectedValue = sp$expectedValue;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testFrom$test STM$() {
        res=simtst130$PBLK16.from(p$t,p$p);
        ;
        rs1=simtst130$PBLK16.from(p$t,p$p);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  from("),p$t),new TXT$(",")),ENVIRONMENT$.edit(p$p)),new TXT$(") ==> '")),res),new TXT$("'   expectedValue=")),p$expectedValue));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test from1("),p$t),new TXT$(",")),ENVIRONMENT$.edit(p$p)),new TXT$(") ==> '")),rs1),new TXT$("'   expectedValue=")),p$expectedValue));
        ;
        if(VALUE$(TXTREL$NE(res,rs1))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),new TXT$("Test  from FAILED"));
        }
        ;
        if(VALUE$(TXTREL$NE(res,p$expectedValue))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  from FAILED: result="),res));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,425,10,426,37,427,42,428,45,429,48,430,53,431,60,432);
}
