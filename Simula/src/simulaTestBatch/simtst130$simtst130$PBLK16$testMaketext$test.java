package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testMaketext$test extends PROC$ {
    public char p$c;
    public int p$n;
    public TXT$ c1=null;
    public TXT$ c2=null;
    public simtst130$simtst130$PBLK16$testMaketext$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 2: p$c=(char)objectValue(param); break;
                case 1: p$n=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testMaketext$test(RTObject$ SL$) {
        super(SL$,2);
    }
    public simtst130$simtst130$PBLK16$testMaketext$test(RTObject$ SL$,char sp$c,int sp$n) {
        super(SL$);
        this.p$c = sp$c;
        this.p$n = sp$n;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testMaketext$test STM$() {
        c1=simtst130$PBLK16.maketext(p$c,p$n);
        ;
        c2=new simtst130$simtst130$PBLK16$testMaketext$maketext1((CUR$.SL$),p$c,p$n).RESULT$;
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  maketext("),ENVIRONMENT$.edit(p$c)),new TXT$(",n=")),ENVIRONMENT$.edit(p$n)),new TXT$(") ")),new TXT$(" ==> '")),c1),new TXT$("'")));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test maketext1("),ENVIRONMENT$.edit(p$c)),new TXT$(",n=")),ENVIRONMENT$.edit(p$n)),new TXT$(") ")),new TXT$(" ==> '")),c2),new TXT$("'")));
        ;
        if(VALUE$(TXTREL$NE(c1,c2))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),new TXT$("Test  maketext FAILED"));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,801,9,802,34,803,39,804,42,805,45,806,52,807);
}
