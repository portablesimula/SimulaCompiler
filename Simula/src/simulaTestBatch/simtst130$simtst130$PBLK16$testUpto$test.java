package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testUpto$test extends PROC$ {
    public TXT$ p$t;
    public int p$i;
    public simtst130$simtst130$PBLK16$testUpto$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 2: p$t=(TXT$)objectValue(param); break;
                case 1: p$i=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testUpto$test(RTObject$ SL$) {
        super(SL$,2);
    }
    public simtst130$simtst130$PBLK16$testUpto$test(RTObject$ SL$,TXT$ sp$t,int sp$i) {
        super(SL$);
        this.p$t = sp$t;
        this.p$i = sp$i;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testUpto$test STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(new TXT$("Test  upto("),p$t),new TXT$(",")),ENVIRONMENT$.edit(p$i)),new TXT$(") ==> ")),simtst130$PBLK16.upto(p$t,p$i)));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(new TXT$("Test upto1("),p$t),new TXT$(",")),ENVIRONMENT$.edit(p$i)),new TXT$(") ==> ")),new simtst130$simtst130$PBLK16$testUpto$upto1((CUR$.SL$),p$t,p$i).RESULT$));
        ;
        if(VALUE$(TXTREL$NE(simtst130$PBLK16.upto(p$t,p$i),new simtst130$simtst130$PBLK16$testUpto$upto1((CUR$.SL$),p$t,p$i).RESULT$))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(new TXT$("Test upto("),p$t),new TXT$(",")),ENVIRONMENT$.edit(p$i)),new TXT$(") FAILED")));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,1177,31,1178,34,1179,37,1180,44,1181);
}
