package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 12:10:22 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst115$C extends CLASS$ {
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    public simtst115$C(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("C",45);
    }
    public simtst115$C STM$() {
        new simtst115$C$Q(((simtst115$C)CUR$));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst115.sim","Class C",1,36,18,51);
}
