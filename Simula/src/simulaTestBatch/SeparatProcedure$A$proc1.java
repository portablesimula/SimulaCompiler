package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 17:07:18 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SeparatProcedure$A$proc1 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public SeparatProcedure$A$proc1(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public SeparatProcedure$A$proc1 STM$() {
        ((SeparatProcedure$A)(CUR$.SL$)).ord=(((SeparatProcedure)(CUR$.SL$.SL$)).n/(0));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("PrecompiledProcedure.sim","Procedure proc1",1,9,14,10,18,10);
}
