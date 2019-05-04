package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat May 04 11:46:57 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class VirtualLabel$B extends VirtualLabel$A {
    public int prefixLevel() { return(1); }
    public LABQNT$ L$0() { return(new LABQNT$(this,1,"L")); }
    public final TXT$ ident$1=(TXT$)(new TXT$("CLASS B"));
    public VirtualLabel$B(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("B",14);
    }
    public VirtualLabel$B STM$() {
        VirtualLabel$B THIS$=(VirtualLabel$B)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                sysout().outtext(new TXT$("In A before inner"));
                sysout().outimage();
                GOTO$(L$0());
                sysout().outtext(new TXT$("In B before inner"));
                sysout().outimage();
                LABEL$(1,"L");
                sysout().outtext(new TXT$("At Label L - OK"));
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
    public static PROGINFO$ INFO$=new PROGINFO$("VirtualLabel.sim","Class B",1,12,8,16,10,14,21,6,24,7,26,15,29,16,33,18,36,9,39,18,53,19);
}
