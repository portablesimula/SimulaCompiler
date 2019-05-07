package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 16:21:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst116$C extends CLASS$ {
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    public simtst116$C(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("C",45);
    }
    public simtst116$C STM$() {
        new simtst116$C$Q(((simtst116$C)CUR$));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst116.sim","Class C",1,36,18,51);
}
