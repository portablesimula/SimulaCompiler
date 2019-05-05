package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat May 04 14:52:24 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst111$A extends CLASS$ {
    public int prefixLevel() { return(0); }
    public final TXT$ ident=(TXT$)(new TXT$("CLASS A"));
    public LABQNT$ L$0(){ throw new RuntimeException("No Virtual Match: L"); }
    public simtst111$A(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("A",31);
    }
    public simtst111$A STM$() {
        new simtst111$trace(((simtst111)(CUR$.SL$)),new TXT$("In A before inner"));
        GOTO$(L$0());
        new simtst111$trace(((simtst111)(CUR$.SL$)),new TXT$("In A after inner"));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst111.sim","Class A",1,29,8,31,17,32,19,33,21,35,25,36);
}
