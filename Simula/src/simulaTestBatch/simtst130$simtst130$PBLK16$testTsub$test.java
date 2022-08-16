package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testTsub$test extends PROC$ {
    public TXT$ p$t;
    public int p$p;
    public int p$l;
    public simtst130$simtst130$PBLK16$testTsub$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 3: p$t=(TXT$)objectValue(param); break;
                case 2: p$p=intValue(param); break;
                case 1: p$l=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testTsub$test(RTObject$ SL$) {
        super(SL$,3);
    }
    public simtst130$simtst130$PBLK16$testTsub$test(RTObject$ SL$,TXT$ sp$t,int sp$p,int sp$l) {
        super(SL$);
        this.p$t = sp$t;
        this.p$p = sp$p;
        this.p$l = sp$l;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testTsub$test STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  tsub("),p$t),new TXT$(",")),ENVIRONMENT$.edit(p$p)),new TXT$(",")),ENVIRONMENT$.edit(p$l)),new TXT$(") ==> ")),simtst130$PBLK16.tsub(p$t,p$p,p$l)));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  tsub1("),p$t),new TXT$(",")),ENVIRONMENT$.edit(p$p)),new TXT$(",")),ENVIRONMENT$.edit(p$l)),new TXT$(") ==> ")),new simtst130$simtst130$PBLK16$testTsub$tsub1((CUR$.SL$),p$t,p$p,p$l).RESULT$));
        ;
        if(VALUE$(TXTREL$NE(simtst130$PBLK16.tsub(p$t,p$p,p$l),new simtst130$simtst130$PBLK16$testTsub$tsub1((CUR$.SL$),p$t,p$p,p$l).RESULT$))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  tsub("),p$t),new TXT$(",")),ENVIRONMENT$.edit(p$p)),new TXT$(",")),ENVIRONMENT$.edit(p$l)),new TXT$(") FAILED")));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,1102,34,1103,37,1104,40,1105,47,1106);
}
