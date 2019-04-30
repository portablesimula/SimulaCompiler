package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon Apr 29 11:38:50 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst110$A extends CLASS$ {
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    public int i=0;
    public simtst110$A(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("A",30);
    }
    public simtst110$A STM$() {
        new simtst110$trace(((simtst110)(CUR$.SL$)),new TXT$("A: State 1(Initiating)"));
        detach();
        new simtst110$trace(((simtst110)(CUR$.SL$)),new TXT$("A: State 2"));
        detach();
        new simtst110$trace(((simtst110)(CUR$.SL$)),new TXT$("A: State 3(Terminating)"));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst110.sim","Class A",1,28,9,30,17,31,19,32,21,33,23,34,25,35,27,31,30,36);
}
