package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testScanreal$scanreal1 extends PROC$ {
    public double RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public NAME$<TXT$> p$t;
    public TXT$ s=null;
    public int i=0;
    public simtst130$simtst130$PBLK16$testScanreal$scanreal1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$t=(NAME$<TXT$>)param; break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testScanreal$scanreal1(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst130$simtst130$PBLK16$testScanreal$scanreal1(RTObject$ SL$,NAME$<TXT$> sp$t) {
        super(SL$);
        this.p$t = sp$t;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testScanreal$scanreal1 STM$() {
        s=simtst130$PBLK16.rest(p$t.get());
        ;
        i=simtst130$PBLK16.checkreal(new NAME$<TXT$>(){ public TXT$ get() { return(s); } public TXT$ put(TXT$ x$) { return(s=(TXT$)x$); } });
        ;
        if(VALUE$((i==(1)))) {
            {
                RESULT$=TXT$.getreal(s);
                ;
                new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(new TXT$("scanreal1("),s),new TXT$(")  PosAfter=")),ENVIRONMENT$.edit(TXT$.pos(s))));
                ;
                TXT$.setpos(p$t.get(),Math.subtractExact(Math.addExact(TXT$.pos(p$t.get()),TXT$.pos(s)),1));
            }
        } else
        RESULT$=((double)(((ENVIRONMENT$)CTX$).minreal));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure scanreal1",1,967,10,968,33,969,36,970,39,971,41,972,45,973,48,975,56,976);
}
