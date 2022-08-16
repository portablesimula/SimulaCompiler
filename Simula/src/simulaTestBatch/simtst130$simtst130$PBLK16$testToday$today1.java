package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testToday$today1 extends PROC$ {
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public simtst130$simtst130$PBLK16$testToday$today1(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testToday$today1 STM$() {
        RESULT$=TXT$.sub(ENVIRONMENT$.datetime(),1,10);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure today1",1,298,18,298);
}
