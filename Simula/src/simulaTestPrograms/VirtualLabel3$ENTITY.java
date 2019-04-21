package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:08:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class VirtualLabel3$ENTITY extends CLASS$ {
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    public TXT$ p$TITLE;
    public LABQNT$ LOOP$0() { return(new LABQNT$(this,1,"LOOP")); }
    public float EVTIME=0.0f;
    public boolean TERMINATED=false;
    public int CYCLE=0;
    public VirtualLabel3$ENTITY(RTObject$ staticLink,TXT$ sp$TITLE) {
        super(staticLink);
        this.p$TITLE = sp$TITLE;
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("ENTITY",12);
    }
    public VirtualLabel3$ENTITY STM$() {
        VirtualLabel3$ENTITY THIS$=(VirtualLabel3$ENTITY)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                EVTIME=(-(1.0f));
                detach();
                LABEL$(1,"LOOP");
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
    public static PROGINFO$ INFO$=new PROGINFO$("VirtualLabel3.sim","Class ENTITY",1,4,10,17,12,6,14,7,16,8,29,15,31,16,33,18,35,19,50,20);
}
