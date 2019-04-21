package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:25:32 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue17$PBLK18 extends Simulation$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    final LABQNT$ EXIT_LABEL=new LABQNT$(this,1,"EXIT_LABEL");
    issue17$p$issue17$PBLK18$Car car1$2=null;
    public issue17$PBLK18(RTObject$ staticLink) {
        super(staticLink);
    }
    public issue17$PBLK18 STM$() {
        issue17$PBLK18 THIS$=(issue17$PBLK18)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                new issue17$trace(((issue17)(CUR$.SL$.SL$)),copy(new TXT$("START SIMULATION")));
                car1$2=((issue17$p$issue17$PBLK18$Car)new issue17$p$issue17$PBLK18$Car(((issue17$PBLK18)CUR$),new TXT$("Bil 1")).START$());
                new issue17$trace(((issue17)(CUR$.SL$.SL$)),copy(CONC(car1$2.p3$pname,new TXT$(" is scheduled for 4.0"))));
                ((issue17$PBLK18)CUR$).ActivateAt(false,car1$2,4.0f,false);
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
    public static PROGINFO$ INFO$=new PROGINFO$("issue17.sim","PrefixedBlock issue17$PBLK18",1,18,10,37,12,18,22,32,24,33,26,34,28,35,30,36,32,37,49,39);
}
