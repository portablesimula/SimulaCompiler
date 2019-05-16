package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 17:07:06 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SeparatClass$A extends CLASS$ {
    public int prefixLevel() { return(0); }
    public int ord=0;
    public SeparatClass$A(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("A",10);
    }
    public SeparatClass$A STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("PrecompiledClass.sim","Class A",1,7,8,8,16,11,19,11);
}
