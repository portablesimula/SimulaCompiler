package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testDayno$dayno1 extends PROC$ {
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public simtst130$simtst130$PBLK16$testDayno$dayno1(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testDayno$dayno1 STM$() {
        RESULT$=TXT$.getint(TXT$.sub(ENVIRONMENT$.datetime(),9,2));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure dayno1",1,287,18,287);
}
