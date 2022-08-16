package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testFront$test extends PROC$ {
    public TXT$ p$t;
    public TXT$ p$expectedValue;
    public TXT$ res=null;
    public TXT$ rs1=null;
    public simtst130$simtst130$PBLK16$testFront$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 2: p$t=(TXT$)objectValue(param); break;
                case 1: p$expectedValue=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testFront$test(RTObject$ SL$) {
        super(SL$,2);
    }
    public simtst130$simtst130$PBLK16$testFront$test(RTObject$ SL$,TXT$ sp$t,TXT$ sp$expectedValue) {
        super(SL$);
        this.p$t = sp$t;
        this.p$expectedValue = sp$expectedValue;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testFront$test STM$() {
        res=simtst130$PBLK16.front(p$t);
        ;
        rs1=new simtst130$simtst130$PBLK16$testFront$front1((CUR$.SL$),p$t).RESULT$;
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  front("),p$t),new TXT$("), t.pos=")),ENVIRONMENT$.edit(TXT$.pos(p$t))),new TXT$(" ==> '")),res),new TXT$("'   expectedValue=")),p$expectedValue));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test front1("),p$t),new TXT$("), t.pos=")),ENVIRONMENT$.edit(TXT$.pos(p$t))),new TXT$(" ==> '")),rs1),new TXT$("'   expectedValue=")),p$expectedValue));
        ;
        if(VALUE$(TXTREL$NE(res,p$expectedValue))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  front FAILED: result="),res));
        }
        ;
        if(VALUE$(TXTREL$NE(rs1,p$expectedValue))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  front1 FAILED: result="),rs1));
        }
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(new TXT$("front & from ==> '"),res),simtst130$PBLK16.from(p$t,TXT$.pos(p$t))),new TXT$("'")));
        ;
        if(VALUE$(TXTREL$NE(CONC(res,simtst130$PBLK16.from(p$t,TXT$.pos(p$t))),p$t))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(CONC(CONC(new TXT$("Test  front1 FAILED: res & from(t,t.pos)='"),res),simtst130$PBLK16.from(p$t,TXT$.pos(p$t))),new TXT$("'")));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,446,9,447,34,448,37,449,40,450,43,451,46,452,51,453,56,454,59,455,66,456);
}
