package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Fri Apr 19 09:17:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst32$A extends CLASS$ {
    public int prefixLevel() { return(0); }
    public int ia=0;
    public simtst32$A(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("A",16);
    }
    public simtst32$A STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst32.sim","Class A",1,13,8,15,16,17,19,17);
}
