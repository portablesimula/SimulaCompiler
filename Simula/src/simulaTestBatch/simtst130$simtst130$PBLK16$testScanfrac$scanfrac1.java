package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testScanfrac$scanfrac1 extends PROC$ {
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public NAME$<TXT$> p$t;
    public TXT$ s=null;
    public simtst130$simtst130$PBLK16$testScanfrac$scanfrac1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$t=(NAME$<TXT$>)param; break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testScanfrac$scanfrac1(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst130$simtst130$PBLK16$testScanfrac$scanfrac1(RTObject$ SL$,NAME$<TXT$> sp$t) {
        super(SL$);
        this.p$t = sp$t;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testScanfrac$scanfrac1 STM$() {
        s=simtst130$PBLK16.rest(p$t.get());
        ;
        if(VALUE$((simtst130$PBLK16.checkfrac(new NAME$<TXT$>(){ public TXT$ get() { return(s); } public TXT$ put(TXT$ x$) { return(s=(TXT$)x$); } })==(1)))) {
            {
                RESULT$=TXT$.getfrac(s);
                ;
                TXT$.setpos(p$t.get(),Math.subtractExact(Math.addExact(TXT$.pos(p$t.get()),TXT$.pos(s)),1));
            }
        } else
        RESULT$=((ENVIRONMENT$)CTX$).minint;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure scanfrac1",1,901,10,902,34,903,36,904,40,906,47,907);
}
