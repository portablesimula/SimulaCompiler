package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testFetchar$test extends PROC$ {
    public TXT$ p$t;
    public int p$p;
    public char p$expectedValue;
    public char res=0;
    public char rs1=0;
    public simtst130$simtst130$PBLK16$testFetchar$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 3: p$t=(TXT$)objectValue(param); break;
                case 2: p$p=intValue(param); break;
                case 1: p$expectedValue=(char)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testFetchar$test(RTObject$ SL$) {
        super(SL$,3);
    }
    public simtst130$simtst130$PBLK16$testFetchar$test(RTObject$ SL$,TXT$ sp$t,int sp$p,char sp$expectedValue) {
        super(SL$);
        this.p$t = sp$t;
        this.p$p = sp$p;
        this.p$expectedValue = sp$expectedValue;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testFetchar$test STM$() {
        res=simtst130$PBLK16.fetchar(p$t,p$p);
        ;
        rs1=new simtst130$simtst130$PBLK16$testFetchar$fetchar1((CUR$.SL$),p$t,p$p).RESULT$;
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  fetchar("),p$t),new TXT$(",")),ENVIRONMENT$.edit(p$p)),new TXT$(") ==> '")),ENVIRONMENT$.edit(res)),new TXT$("'   expectedValue=")),ENVIRONMENT$.edit(p$expectedValue)));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test fetchar1("),p$t),new TXT$(",")),ENVIRONMENT$.edit(p$p)),new TXT$(") ==> '")),ENVIRONMENT$.edit(rs1)),new TXT$("'   expectedValue=")),ENVIRONMENT$.edit(p$expectedValue)));
        ;
        if(VALUE$((res!=(p$expectedValue)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  fetchar FAILED: result="),ENVIRONMENT$.edit(res)));
        }
        ;
        if(VALUE$((rs1!=(p$expectedValue)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  fetchar1 FAILED: result="),ENVIRONMENT$.edit(rs1)));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,366,10,367,37,368,40,369,43,370,46,371,49,372,54,373,61,374);
}
