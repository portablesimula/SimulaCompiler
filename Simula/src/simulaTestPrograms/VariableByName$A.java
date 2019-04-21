package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:07:26 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class VariableByName$A extends CLASS$ {
    public int prefixLevel() { return(0); }
    public VariableByName$A(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("A",8);
    }
    public VariableByName$A STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("VariableByName.sim","Class A",1,8,14,10,17,10);
}
