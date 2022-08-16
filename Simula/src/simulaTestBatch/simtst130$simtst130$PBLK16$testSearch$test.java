package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testSearch$test extends PROC$ {
    public TXT$ p$t1;
    public TXT$ p$t2;
    public int p$n;
    public int n2=0;
    public simtst130$simtst130$PBLK16$testSearch$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 3: p$t1=(TXT$)objectValue(param); break;
                case 2: p$t2=(TXT$)objectValue(param); break;
                case 1: p$n=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testSearch$test(RTObject$ SL$) {
        super(SL$,3);
    }
    public simtst130$simtst130$PBLK16$testSearch$test(RTObject$ SL$,TXT$ sp$t1,TXT$ sp$t2,int sp$n) {
        super(SL$);
        this.p$t1 = sp$t1;
        this.p$t2 = sp$t2;
        this.p$n = sp$n;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testSearch$test STM$() {
        n2=simtst130$PBLK16.search(p$t1,p$t2);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  search("),p$t1),new TXT$(",")),p$t2),new TXT$(",")),ENVIRONMENT$.edit(p$n)),new TXT$(") ==> ")),ENVIRONMENT$.edit(n2)));
        ;
        if(VALUE$((p$n!=(n2)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),new TXT$("Test  search FAILED"));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,1037,10,1038,38,1039,41,1040,48,1041);
}
