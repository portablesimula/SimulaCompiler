package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testGetitem$getitem1 extends PROC$ {
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public NAME$<TXT$> p$tt;
    public simtst130$simtst130$PBLK16$testGetitem$getitem1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$tt=(NAME$<TXT$>)param; break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testGetitem$getitem1(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst130$simtst130$PBLK16$testGetitem$getitem1(RTObject$ SL$,NAME$<TXT$> sp$tt) {
        super(SL$);
        this.p$tt = sp$tt;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testGetitem$getitem1 STM$() {
        if(VALUE$(TRF_NE(p$tt.get(),null))) {
            new simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544((CUR$)).STM$();
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure getitem1",1,521,30,522,32,544,37,544);
}
