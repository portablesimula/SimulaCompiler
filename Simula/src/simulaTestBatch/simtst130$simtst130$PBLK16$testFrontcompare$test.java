package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testFrontcompare$test extends PROC$ {
    public TXT$ p$t1;
    public TXT$ p$t2;
    public boolean p$expectedValue;
    public boolean res=false;
    public boolean rs1=false;
    public simtst130$simtst130$PBLK16$testFrontcompare$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 3: p$t1=(TXT$)objectValue(param); break;
                case 2: p$t2=(TXT$)objectValue(param); break;
                case 1: p$expectedValue=(boolean)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testFrontcompare$test(RTObject$ SL$) {
        super(SL$,3);
    }
    public simtst130$simtst130$PBLK16$testFrontcompare$test(RTObject$ SL$,TXT$ sp$t1,TXT$ sp$t2,boolean sp$expectedValue) {
        super(SL$);
        this.p$t1 = sp$t1;
        this.p$t2 = sp$t2;
        this.p$expectedValue = sp$expectedValue;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testFrontcompare$test STM$() {
        res=simtst130$PBLK16.frontcompare(p$t1,p$t2);
        ;
        rs1=new simtst130$simtst130$PBLK16$testFrontcompare$frontcompare1((CUR$.SL$),p$t1,p$t2).RESULT$;
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  frontcompare("),p$t1),new TXT$(",")),p$t2),new TXT$("), t1.pos=")),ENVIRONMENT$.edit(TXT$.pos(p$t1))),new TXT$(" ==> '")),ENVIRONMENT$.edit(res)),new TXT$("'   expectedValue=")),ENVIRONMENT$.edit(p$expectedValue)));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test frontcompare1("),p$t1),new TXT$(",")),p$t2),new TXT$("), t1.pos=")),ENVIRONMENT$.edit(TXT$.pos(p$t1))),new TXT$(" ==> '")),ENVIRONMENT$.edit(rs1)),new TXT$("'   expectedValue=")),ENVIRONMENT$.edit(p$expectedValue)));
        ;
        if(VALUE$((res!=(p$expectedValue)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  frontcompare FAILED: result="),ENVIRONMENT$.edit(res)));
        }
        ;
        if(VALUE$((rs1!=(p$expectedValue)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  frontcompare1 FAILED: result="),ENVIRONMENT$.edit(rs1)));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,471,10,472,37,473,40,474,43,475,46,476,49,477,54,478,61,479);
}
