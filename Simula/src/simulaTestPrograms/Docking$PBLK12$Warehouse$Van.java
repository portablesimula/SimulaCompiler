package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:32:50 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Docking$PBLK12$Warehouse$Van extends Process$ {
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    public int p3$load;
    public double waitTime$3=0.0d;
    public Docking$PBLK12$Warehouse$Dock myDock$3=null;
    public ShapeElement$ vanShape$3=null;
    public int dLine$3=0;
    public final int speed$3=(int)(200);
    public Docking$PBLK12$Warehouse$Van(RTObject$ staticLink,int sp3$load) {
        super(staticLink);
        this.p3$load = sp3$load;
        TRACE_BEGIN_DCL$("Van",136);
    }
    public Docking$PBLK12$Warehouse$Van STM$() {
        detach();
        new Docking$PBLK12$trace(((Docking$PBLK12)(CUR$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is entering the scene")));
        vanShape$3=new ShapeElement$(((Docking$PBLK12)(CUR$.SL$.SL$))).STM$();
        if(VALUE$((((Docking$PBLK12$Warehouse)(CUR$.SL$)).platforms$2.first()==(null)))) {
            {
                waitTime$3=((Docking$PBLK12$Warehouse)(CUR$.SL$)).time();
                new Docking$PBLK12$Warehouse$Van$VantoQueue(((Docking$PBLK12$Warehouse$Van)CUR$));
                ((Docking$PBLK12$Warehouse)(CUR$.SL$)).wait(((Docking$PBLK12$Warehouse)(CUR$.SL$)).Waiting$2);
                out();
                ((Docking$PBLK12$Warehouse)(CUR$.SL$)).accWait$2=((((Docking$PBLK12$Warehouse)(CUR$.SL$)).accWait$2+(((Docking$PBLK12$Warehouse)(CUR$.SL$)).time()))-(waitTime$3));
            }
        }
        new Docking$PBLK12$Warehouse$UpdateReport(((Docking$PBLK12$Warehouse)(CUR$.SL$)));
        myDock$3=((Docking$PBLK12$Warehouse$Dock)(((Docking$PBLK12$Warehouse)(CUR$.SL$)).platforms$2.first()));
        new Docking$PBLK12$Warehouse$Van$VantoPlatform(((Docking$PBLK12$Warehouse$Van)CUR$));
        myDock$3.out();
        ((Docking$PBLK12$Warehouse)(CUR$.SL$)).hold(((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$)).pTime$2)));
        new Docking$PBLK12$Warehouse$Van$VantoUnload(((Docking$PBLK12$Warehouse$Van)CUR$));
        waitTime$3=((1000.0d*(((double)(p3$load))))/(((Docking$PBLK12$Warehouse)(CUR$.SL$)).unloadSpeed$2));
        ((Docking$PBLK12$Warehouse)(CUR$.SL$)).hold(waitTime$3);
        new Docking$PBLK12$Warehouse$Van$VantoWash(((Docking$PBLK12$Warehouse$Van)CUR$));
        ((Docking$PBLK12$Warehouse)(CUR$.SL$)).hold(((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$)).washTime$2)));
        new Docking$PBLK12$Warehouse$Van$VanFinished(((Docking$PBLK12$Warehouse$Van)CUR$));
        myDock$3.into(((Docking$PBLK12$Warehouse)(CUR$.SL$)).platforms$2);
        if(VALUE$((((Docking$PBLK12$Warehouse)(CUR$.SL$)).Waiting$2.first()!=(null)))) {
            ((Docking$PBLK12$Warehouse)(CUR$.SL$)).ActivateAfter(false,((Process$)(((Docking$PBLK12$Warehouse)(CUR$.SL$)).Waiting$2.first())),((Docking$PBLK12$Warehouse$Van)CUR$));
        }
        new Docking$PBLK12$trace(((Docking$PBLK12)(CUR$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is terminating")));
        terminate();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Class Van",1,87,10,88,13,89,15,90,24,1,26,142,28,143,30,145,32,147,35,148,37,149,40,150,44,152,46,153,48,154,50,155,52,156,54,157,56,158,58,159,60,160,62,161,64,162,66,163,68,164,70,165,73,166,75,1,77,142,80,167);
}
