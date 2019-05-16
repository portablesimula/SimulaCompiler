package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 17:07:06 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SeparatClass$A$proc1 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public SeparatClass$A$proc1(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public SeparatClass$A$proc1 STM$() {
        ((SeparatClass$A)(CUR$.SL$)).ord=(((SeparatClass)(CUR$.SL$.SL$)).n/(0));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("PrecompiledClass.sim","Procedure proc1",1,9,14,10,18,10);
}
