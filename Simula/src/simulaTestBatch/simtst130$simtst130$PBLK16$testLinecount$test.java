package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testLinecount$test extends PROC$ {
    public printfile$ p$pf;
    public int p$expectedValue;
    public int c1=0;
    public int c2=0;
    public simtst130$simtst130$PBLK16$testLinecount$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 2: p$pf=(printfile$)objectValue(param); break;
                case 1: p$expectedValue=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testLinecount$test(RTObject$ SL$) {
        super(SL$,2);
    }
    public simtst130$simtst130$PBLK16$testLinecount$test(RTObject$ SL$,printfile$ sp$pf,int sp$expectedValue) {
        super(SL$);
        this.p$pf = sp$pf;
        this.p$expectedValue = sp$expectedValue;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testLinecount$test STM$() {
        c1=simtst130$PBLK16.linecount(p$pf);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(new TXT$("Test  linecount ==> '"),ENVIRONMENT$.edit(c1)),new TXT$("'   expectedValue=")),ENVIRONMENT$.edit(p$expectedValue)));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(new TXT$("Test linecount1 ==> '"),ENVIRONMENT$.edit(c2)),new TXT$("'   expectedValue=")),ENVIRONMENT$.edit(p$expectedValue)));
        ;
        if(VALUE$((c1!=(p$expectedValue)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  linecount FAILED: result="),ENVIRONMENT$.edit(c1)));
        }
        ;
        if(VALUE$((c2!=(p$expectedValue)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  linecount1 FAILED: result="),ENVIRONMENT$.edit(c2)));
        }
        ;
        if(VALUE$((c1!=(c2)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),new TXT$("Test  linecount FAILED"));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,752,9,753,34,754,37,756,40,757,43,758,48,759,53,760,60,761);
}
