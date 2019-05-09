package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:12:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Docking$Warehouse$Van extends Process$ {
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    public int p3$load;
    public double waitTime$3=0.0d;
    public Docking$Warehouse$Dock myDock$3=null;
    public ShapeElement$ vanShape$3=null;
    public int dLine$3=0;
    public final int speed$3=(int)(200);
    public Docking$Warehouse$Van(RTObject$ staticLink,int sp3$load) {
        super(staticLink);
        this.p3$load = sp3$load;
        TRACE_BEGIN_DCL$("Van",136);
    }
    public Docking$Warehouse$Van STM$() {
        detach();
        new Docking$trace(((Docking)(CUR$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is entering the scene")));
        vanShape$3=new ShapeElement$(((Docking)(CUR$.SL$.SL$))).STM$();
        if(VALUE$((((Docking$Warehouse)(CUR$.SL$)).platforms$2.first()==(null)))) {
            {
                waitTime$3=((Docking$Warehouse)(CUR$.SL$)).time();
                new Docking$Warehouse$Van$VantoQueue(((Docking$Warehouse$Van)CUR$));
                ((Docking$Warehouse)(CUR$.SL$)).wait(((Docking$Warehouse)(CUR$.SL$)).Waiting$2);
                out();
                ((Docking$Warehouse)(CUR$.SL$)).accWait$2=((((Docking$Warehouse)(CUR$.SL$)).accWait$2+(((Docking$Warehouse)(CUR$.SL$)).time()))-(waitTime$3));
            }
        }
        new Docking$Warehouse$UpdateReport(((Docking$Warehouse)(CUR$.SL$)));
        myDock$3=((Docking$Warehouse$Dock)(((Docking$Warehouse)(CUR$.SL$)).platforms$2.first()));
        new Docking$Warehouse$Van$VantoPlatform(((Docking$Warehouse$Van)CUR$));
        myDock$3.out();
        ((Docking$Warehouse)(CUR$.SL$)).hold(((double)(((Docking$Warehouse)(CUR$.SL$)).pTime$2)));
        new Docking$Warehouse$Van$VantoUnload(((Docking$Warehouse$Van)CUR$));
        waitTime$3=((1000.0d*(((double)(p3$load))))/(((Docking$Warehouse)(CUR$.SL$)).unloadSpeed$2));
        ((Docking$Warehouse)(CUR$.SL$)).hold(waitTime$3);
        new Docking$Warehouse$Van$VantoWash(((Docking$Warehouse$Van)CUR$));
        ((Docking$Warehouse)(CUR$.SL$)).hold(((double)(((Docking$Warehouse)(CUR$.SL$)).washTime$2)));
        new Docking$Warehouse$Van$VanFinished(((Docking$Warehouse$Van)CUR$));
        myDock$3.into(((Docking$Warehouse)(CUR$.SL$)).platforms$2);
        if(VALUE$((((Docking$Warehouse)(CUR$.SL$)).Waiting$2.first()!=(null)))) {
            ((Docking$Warehouse)(CUR$.SL$)).ActivateAfter(false,((Process$)(((Docking$Warehouse)(CUR$.SL$)).Waiting$2.first())),((Docking$Warehouse$Van)CUR$));
        }
        new Docking$trace(((Docking)(CUR$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is terminating")));
        terminate();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Class Van",1,87,10,88,13,89,15,90,24,1,26,142,28,143,30,145,32,147,35,148,37,149,40,150,44,152,46,153,48,154,50,155,52,156,54,157,56,158,58,159,60,160,62,161,64,162,66,163,68,164,70,165,73,166,75,1,77,142,80,167);
}
