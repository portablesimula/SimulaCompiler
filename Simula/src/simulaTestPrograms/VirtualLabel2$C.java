package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:07:53 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class VirtualLabel2$C extends VirtualLabel2$B {
    public int prefixLevel() { return(2); }
    public VirtualLabel2$C(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("C",27);
    }
    public VirtualLabel2$C STM$() {
        VirtualLabel2$C THIS$=(VirtualLabel2$C)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                sysout().outtext(new TXT$("In A before inner"));
                sysout().outimage();
                ((VirtualLabel2$A)CUR$).goto_L$0().CPF();
                sysout().outtext(new TXT$("In B before inner"));
                sysout().outimage();
                LABEL$(1,"L");
                sysout().outtext(new TXT$("In B At Label L - OK"));
                sysout().outimage();
                sysout().outtext(new TXT$("In C before inner"));
                sysout().outimage();
                sysout().outtext(new TXT$("In C after inner"));
                sysout().outimage();
                sysout().outtext(new TXT$("In B after inner"));
                sysout().outimage();
                sysout().outtext(new TXT$("In A after inner"));
                sysout().outimage();
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    CUR$.STATE$=OperationalState.terminated;
                    throw(q);
                }
                JTX$=q.index; continue LOOP$;
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("VirtualLabel2.sim","Class C",1,27,17,6,20,7,22,21,25,22,29,29,32,31,35,24,38,9,41,31,55,32);
}
