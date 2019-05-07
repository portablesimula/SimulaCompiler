package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 12:10:22 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst115$A extends CLASS$ {
    public int prefixLevel() { return(0); }
    public simtst115$A(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("A",28);
    }
    public simtst115$A STM$() {
        ((simtst115)(CUR$.SL$)).x=((simtst115$C)new simtst115$C(((simtst115)(CUR$.SL$))).START$());
        new simtst115$trace(((simtst115)(CUR$.SL$)),new TXT$("In Class A - Just Before first Resume(x)"));
        resume(((simtst115)(CUR$.SL$)).x);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst115.sim","Class A",1,28,14,30,16,32,18,33,20,30,23,34);
}
