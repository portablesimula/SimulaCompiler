package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:17:25 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simerr08$A extends CLASS$ {
    public int prefixLevel() { return(0); }
    public simerr08$A(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("A",4);
    }
    public simerr08$A STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr08.sim","Class A",15,4);
}
