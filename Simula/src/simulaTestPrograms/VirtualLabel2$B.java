package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:07:53 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class VirtualLabel2$B extends VirtualLabel2$A {
    public int prefixLevel() { return(1); }
    final LABQNT$ L=new LABQNT$(this,1,"L");
    public final TXT$ ident$1=(TXT$)(new TXT$("CLASS B"));
    public PRCQNT$ goto_L$0() { return(new PRCQNT$(this,VirtualLabel2$B$goto_L.class)); }
    public VirtualLabel2$B(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("B",18);
    }
    public VirtualLabel2$B STM$() {
        VirtualLabel2$B THIS$=(VirtualLabel2$B)CUR$;
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
    public static PROGINFO$ INFO$=new PROGINFO$("VirtualLabel2.sim","Class B",1,12,8,22,10,14,22,6,25,7,27,21,30,22,34,24,37,9,40,24,54,25);
}
