package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 14:57:46 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class C extends CLASS$ {
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    public C(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("C",50);
    }
    public C STM$() {
        new Q(((C)CUR$));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst116.sim","Class C",1,41,18,56);
}
