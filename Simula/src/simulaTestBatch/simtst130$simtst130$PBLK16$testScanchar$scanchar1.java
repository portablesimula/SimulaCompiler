package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testScanchar$scanchar1 extends PROC$ {
    public char RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public NAME$<TXT$> p$t;
    public simtst130$simtst130$PBLK16$testScanchar$scanchar1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$t=(NAME$<TXT$>)param; break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testScanchar$scanchar1(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst130$simtst130$PBLK16$testScanchar$scanchar1(RTObject$ SL$,NAME$<TXT$> sp$t) {
        super(SL$);
        this.p$t = sp$t;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testScanchar$scanchar1 STM$() {
        RESULT$=((TXT$.more(p$t.get()))?(TXT$.getchar(p$t.get())):(ENVIRONMENT$.char$(0)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure scanchar1",1,876,30,877,34,877);
}
