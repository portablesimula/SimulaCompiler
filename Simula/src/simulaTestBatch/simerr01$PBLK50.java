package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 12:48:41 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr01$PBLK50 extends Simulation$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    final LABQNT$ EXIT_LABEL=new LABQNT$(this,1,"EXIT_LABEL");
    simerr01$p$simerr01$PBLK50$Car car1$2=null;
    public simerr01$PBLK50(RTObject$ staticLink) {
        super(staticLink);
    }
    public simerr01$PBLK50 STM$() {
        simerr01$PBLK50 THIS$=(simerr01$PBLK50)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                new simerr01$trace(((simerr01)(CUR$.SL$.SL$)),new TXT$("START SIMULATION"));
                car1$2=((simerr01$p$simerr01$PBLK50$Car)new simerr01$p$simerr01$PBLK50$Car(((simerr01$PBLK50)CUR$),new TXT$("Bil 1")).START$());
                new simerr01$trace(((simerr01)(CUR$.SL$.SL$)),CONC(car1$2.p3$pname,new TXT$(" is scheduled for 4.0")));
                ((simerr01$PBLK50)CUR$).ActivateAt(false,car1$2,4.0f,false);
                hold(((double)(12)));
                LABEL$(1,"EXIT_LABEL");
                sysout().outtext(new TXT$("At OUT"));
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
    public static PROGINFO$ INFO$=new PROGINFO$("simerr01.sim","PrefixedBlock simerr01$PBLK50",1,50,10,69,12,50,22,64,24,65,26,66,28,67,30,68,32,69,49,71);
}
