package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon Apr 29 14:51:19 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst110$ProducerClass extends CLASS$ {
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    public simtst110$ProducerClass(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("ProducerClass",29);
    }
    public simtst110$ProducerClass STM$() {
        new simtst110$trace(((simtst110)(CUR$.SL$)),new TXT$("Producer:Init"));
        detach();
        new simtst110$trace(((simtst110)(CUR$.SL$)),new TXT$("Producer:Part 1 - Statements"));
        resume(((simtst110)(CUR$.SL$)).Consumer);
        new simtst110$trace(((simtst110)(CUR$.SL$)),new TXT$("Producer:Part 2 - Statements"));
        resume(((simtst110)(CUR$.SL$)).Consumer);
        new simtst110$trace(((simtst110)(CUR$.SL$)),new TXT$("Producer:Part 3 - Statements"));
        resume(((simtst110)(CUR$.SL$)).Consumer);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst110.sim","Class ProducerClass",1,29,15,31,17,32,19,33,21,34,23,35,25,36,27,37,29,38,31,31,34,39);
}
