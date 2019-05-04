package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat May 04 11:46:57 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class VirtualLabel$A extends CLASS$ {
    public int prefixLevel() { return(0); }
    public final TXT$ ident=(TXT$)(new TXT$("CLASS A"));
    public LABQNT$ L$0(){ throw new RuntimeException("No Virtual Match: L"); }
    public VirtualLabel$A(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("A",5);
    }
    public VirtualLabel$A STM$() {
        sysout().outtext(new TXT$("In A before inner"));
        sysout().outimage();
        GOTO$(L$0());
        sysout().outtext(new TXT$("In A after inner"));
        sysout().outimage();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("VirtualLabel.sim","Class A",7,5,16,6,19,7,21,9,26,10);
}
