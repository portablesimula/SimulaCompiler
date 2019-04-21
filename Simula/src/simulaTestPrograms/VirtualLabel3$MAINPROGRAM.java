package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:08:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class VirtualLabel3$MAINPROGRAM extends VirtualLabel3$ENTITY {
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    public LABQNT$ LOOP$0() { return(new LABQNT$(this,2,"LOOP")); }
    public VirtualLabel3$MAINPROGRAM(RTObject$ staticLink,TXT$ sp$TITLE) {
        super(staticLink,sp$TITLE);
        TRACE_BEGIN_DCL$("MAINPROGRAM",25);
    }
    public VirtualLabel3$MAINPROGRAM STM$() {
        VirtualLabel3$MAINPROGRAM THIS$=(VirtualLabel3$MAINPROGRAM)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                EVTIME=(-(1.0f));
                detach();
                LABEL$(1,"LOOP");
                LABEL$(2,"LOOP");
                detach();
                GOTO$(LOOP$0());
                TERMINATED=true;
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
    public static PROGINFO$ INFO$=new PROGINFO$("VirtualLabel3.sim","Class MAINPROGRAM",1,22,9,25,20,15,22,16,24,18,26,25,29,26,31,19,33,24,47,27);
}
