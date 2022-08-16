package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testDepchar$test extends PROC$ {
    public TXT$ p$t;
    public int p$p;
    public char p$c;
    public TXT$ p$expectedValue;
    public simtst130$simtst130$PBLK16$testDepchar$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 4: p$t=(TXT$)objectValue(param); break;
                case 3: p$p=intValue(param); break;
                case 2: p$c=(char)objectValue(param); break;
                case 1: p$expectedValue=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testDepchar$test(RTObject$ SL$) {
        super(SL$,4);
    }
    public simtst130$simtst130$PBLK16$testDepchar$test(RTObject$ SL$,TXT$ sp$t,int sp$p,char sp$c,TXT$ sp$expectedValue) {
        super(SL$);
        this.p$t = sp$t;
        this.p$p = sp$p;
        this.p$c = sp$c;
        this.p$expectedValue = sp$expectedValue;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testDepchar$test STM$() {
        simtst130$PBLK16.depchar(p$t,p$p,p$c);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  depchar("),p$t),new TXT$(",")),ENVIRONMENT$.edit(p$p)),new TXT$(",")),ENVIRONMENT$.edit(p$c)),new TXT$("), ==> '")),p$t),new TXT$("'   expectedValue=")),p$expectedValue));
        ;
        if(VALUE$(TXTREL$NE(p$t,p$expectedValue))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  depchar FAILED: result="),p$t));
        }
        ;
        new simtst130$simtst130$PBLK16$testDepchar$depchar1((CUR$.SL$),p$t,p$p,p$c);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  depchar1("),p$t),new TXT$(",")),ENVIRONMENT$.edit(p$p)),new TXT$(",")),ENVIRONMENT$.edit(p$c)),new TXT$("), ==> '")),p$t),new TXT$("'   expectedValue=")),p$expectedValue));
        ;
        if(VALUE$(TXTREL$NE(p$t,p$expectedValue))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  depchar1 FAILED: result="),p$t));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,323,37,324,40,325,43,326,48,328,51,329,54,330,61,331);
}
