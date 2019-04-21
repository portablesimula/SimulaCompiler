package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:08:23 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class VirtualSwitch$A extends CLASS$ {
    public int prefixLevel() { return(0); }
    final LABQNT$ L2=new LABQNT$(this,1,"L2");
    public final TXT$ ident=(TXT$)(new TXT$("CLASS A"));
    public PRCQNT$ S$0(){ throw new RuntimeException("No Virtual Match: S"); }
    public PRCQNT$ P$0(){ throw new RuntimeException("No Virtual Match: P"); }
    public VirtualSwitch$A(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("A",5);
    }
    public VirtualSwitch$A STM$() {
        VirtualSwitch$A THIS$=(VirtualSwitch$A)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                sysout().outtext(new TXT$("In A before inner"));
                sysout().outimage();
                GOTO$(((LABQNT$)(((VirtualSwitch$A)CUR$).S$0().CPF().setPar(new NAME$<Integer>(){ public Integer get() { return(2); } }).ENT$().RESULT$())));
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
    public static PROGINFO$ INFO$=new PROGINFO$("VirtualSwitch.sim","Class A",7,9,9,5,23,6,26,7,28,9,45,10);
}
