package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:07:53 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class VirtualLabel2$A extends CLASS$ {
    public int prefixLevel() { return(0); }
    public final TXT$ ident=(TXT$)(new TXT$("CLASS A"));
    public PRCQNT$ goto_L$0(){ throw new RuntimeException("No Virtual Match: goto_L"); }
    public VirtualLabel2$A(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("A",5);
    }
    public VirtualLabel2$A STM$() {
        sysout().outtext(new TXT$("In A before inner"));
        sysout().outimage();
        ((VirtualLabel2$A)CUR$).goto_L$0().CPF();
        sysout().outtext(new TXT$("In A after inner"));
        sysout().outimage();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("VirtualLabel2.sim","Class A",7,5,16,6,19,7,21,9,26,10);
}
