package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 05 12:42:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst112$A extends CLASS$ {
    public int prefixLevel() { return(0); }
    public final TXT$ ident=(TXT$)(new TXT$("CLASS A"));
    public PRCQNT$ goto_L$0(){ throw new RuntimeException("No Virtual Match: goto_L"); }
    public simtst112$A(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("A",30);
    }
    public simtst112$A STM$() {
        new simtst112$trace(((simtst112)(CUR$.SL$)),new TXT$("In A before inner"));
        ((simtst112$A)CUR$).goto_L$0().CPF();
        new simtst112$trace(((simtst112)(CUR$.SL$)),new TXT$("In A after inner"));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst112.sim","Class A",1,28,8,30,17,31,19,32,21,34,25,35);
}
