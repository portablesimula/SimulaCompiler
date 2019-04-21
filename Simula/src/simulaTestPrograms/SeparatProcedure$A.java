package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:19:06 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SeparatProcedure$A extends CLASS$ {
    public int prefixLevel() { return(0); }
    public int ord=0;
    public SeparatProcedure$A(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("A",10);
    }
    public SeparatProcedure$A STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("PrecompiledProcedure.sim","Class A",1,7,8,8,16,11,19,11);
}
