package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:08:23 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class VirtualSwitch$B extends VirtualSwitch$A {
    public int prefixLevel() { return(1); }
    final LABQNT$ L=new LABQNT$(this,2,"L");
    public final TXT$ ident$1=(TXT$)(new TXT$("CLASS B"));
    public PRCQNT$ S$0() { return(new PRCQNT$(this,VirtualSwitch$B$S.class)); }
    public VirtualSwitch$B(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("B",15);
    }
    public VirtualSwitch$B STM$() {
        VirtualSwitch$B THIS$=(VirtualSwitch$B)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                sysout().outtext(new TXT$("In A before inner"));
                sysout().outimage();
                GOTO$(((LABQNT$)(((VirtualSwitch$A)CUR$).S$0().CPF().setPar(new NAME$<Integer>(){ public Integer get() { return(2); } }).ENT$().RESULT$())));
                sysout().outtext(new TXT$("In B before inner"));
                sysout().outimage();
                LABEL$(2,"L");
                sysout().outtext(new TXT$("At Label L - OK"));
                sysout().outimage();
                sysout().outtext(new TXT$("In B after inner"));
                sysout().outimage();
                LABEL$(1,"L2");
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
    public static PROGINFO$ INFO$=new PROGINFO$("VirtualSwitch.sim","Class B",1,12,8,17,10,15,22,6,25,7,27,16,30,17,34,19,37,9,41,19,55,20);
}
