package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testRest$test extends PROC$ {
    public TXT$ p$t;
    public TXT$ t1=null;
    public TXT$ t2=null;
    public TXT$ x=null;
    public int pos=0;
    public simtst130$simtst130$PBLK16$testRest$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$t=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testRest$test(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst130$simtst130$PBLK16$testRest$test(RTObject$ SL$,TXT$ sp$t) {
        super(SL$);
        this.p$t = sp$t;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testRest$test STM$() {
        pos=TXT$.pos(p$t);
        ;
        x=ENVIRONMENT$.copy(copy(p$t));
        ;
        TXT$.setpos(x,pos);
        ;
        t1=simtst130$PBLK16.rest(p$t);
        ;
        t2=new simtst130$simtst130$PBLK16$testRest$rest1((CUR$.SL$),x).RESULT$;
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  rest("),p$t),new TXT$(") t.pos=")),ENVIRONMENT$.edit(pos)),new TXT$(" ==> '")),t1),new TXT$("'")));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test rest1("),p$t),new TXT$(") t.pos=")),ENVIRONMENT$.edit(pos)),new TXT$(" ==> '")),t2),new TXT$("'")));
        ;
        if(VALUE$(TXTREL$NE(t1,t2))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),new TXT$("Test  rest FAILED"));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,858,8,859,12,860,36,861,41,862,46,863,49,864,52,865,59,866);
}
