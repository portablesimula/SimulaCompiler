package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon Apr 29 14:51:19 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst110$ConsumerClass extends CLASS$ {
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    public simtst110$ConsumerClass(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("ConsumerClass",41);
    }
    public simtst110$ConsumerClass STM$() {
        new simtst110$trace(((simtst110)(CUR$.SL$)),new TXT$("Consumer:Init"));
        detach();
        new simtst110$trace(((simtst110)(CUR$.SL$)),new TXT$("Consumer:Part 1 - Statements"));
        resume(((simtst110)(CUR$.SL$)).Producer);
        new simtst110$trace(((simtst110)(CUR$.SL$)),new TXT$("Consumer:Part 2 - Statements"));
        resume(((simtst110)(CUR$.SL$)).Producer);
        new simtst110$trace(((simtst110)(CUR$.SL$)),new TXT$("Consumer:Part 3 - Statements"));
        resume(((simtst110)(CUR$.SL$)).Producer);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst110.sim","Class ConsumerClass",1,41,15,43,17,44,19,45,21,46,23,47,25,48,27,49,29,50,31,43,34,51);
}
