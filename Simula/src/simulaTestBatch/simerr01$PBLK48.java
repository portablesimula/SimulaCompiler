package simulaTestBatch;
// Simula-2.0 Compiled at Fri Sep 03 09:27:42 CEST 2021
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr01$PBLK48 extends Simulation$ {
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    final LABQNT$ EXIT_LABEL=new LABQNT$(this,1,"EXIT_LABEL");
    simerr01$$p$simerr01$PBLK48$Car car1$2=null;
    public simerr01$PBLK48(RTObject$ staticLink) {
        super(staticLink);
    }
    public simerr01$PBLK48 STM$() {
        simerr01$PBLK48 THIS$=(simerr01$PBLK48)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                new simerr01$$trace((CUR$.SL$.SL$),new TXT$("START SIMULATION"));
                ;
                car1$2=((simerr01$$p$simerr01$PBLK48$Car)new simerr01$$p$simerr01$PBLK48$Car((CUR$),new TXT$("Bil 1")).START$());
                ;
                new simerr01$$trace((CUR$.SL$.SL$),CONC(car1$2.p3$pname,new TXT$(" is scheduled for 4.0")));
                ;
                ((simerr01$PBLK48)(CUR$)).ActivateAt(false,(Process$)car1$2,4.0f,false);
                ;
                hold(12.0d);
                ;
                LABEL$(1,"EXIT_LABEL");
                sysout().outtext(new TXT$("At OUT"));
                ;
                sysout().outimage();
                ;
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
    public static PROGINFO$ INFO$=new PROGINFO$("simerr01.sim","PrefixedBlock simerr01$PBLK48",1,48,9,67,11,48,21,62,24,63,27,64,30,65,33,66,36,67,55,69);
}
