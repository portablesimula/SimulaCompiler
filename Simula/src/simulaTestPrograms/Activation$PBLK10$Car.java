package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 28 21:54:05 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Activation$PBLK10$Car extends Process$ {
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    public TXT$ p3$id;
    public Activation$PBLK10$Car(RTObject$ staticLink,TXT$ sp3$id) {
        super(staticLink);
        this.p3$id = sp3$id;
        TRACE_BEGIN_DCL$("Car",40);
    }
    public Activation$PBLK10$Car STM$() {
        detach();
        new Activation$PBLK10$trace(((Activation$PBLK10)(CUR$.SL$)),CONC(p3$id,new TXT$(": Run Fase-1")));
        ((Activation$PBLK10)(CUR$.SL$)).hold(((double)(4)));
        new Activation$PBLK10$trace(((Activation$PBLK10)(CUR$.SL$)),CONC(p3$id,new TXT$(": Run Fase-2")));
        ((Activation$PBLK10)(CUR$.SL$)).hold(((double)(12)));
        new Activation$PBLK10$trace(((Activation$PBLK10)(CUR$.SL$)),CONC(p3$id,new TXT$(": Terminates")));
        terminate();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Activation.sim","Class Car",1,40,16,1,18,42,20,43,22,44,24,45,26,46,28,1,30,42,33,47);
}
