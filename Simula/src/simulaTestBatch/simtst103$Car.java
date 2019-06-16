package simulaTestBatch;
// Simula-1.0 Compiled at Sat Jun 15 12:44:15 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst103$Car extends Process$ {
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    public TXT$ p3$id;
    public simtst103$Car(RTObject$ staticLink,TXT$ sp3$id) {
        super(staticLink);
        this.p3$id = sp3$id;
        TRACE_BEGIN_DCL$("Car",37);
    }
    public simtst103$Car STM$() {
        detach();
        new simtst103$trace(((simtst103)(CUR$.SL$)),CONC(p3$id,new TXT$(": Run Fase-1")));
        ((simtst103)(CUR$.SL$)).hold(((double)(4)));
        new simtst103$trace(((simtst103)(CUR$.SL$)),CONC(p3$id,new TXT$(": Run Fase-2")));
        ((simtst103)(CUR$.SL$)).hold(((double)(12)));
        new simtst103$trace(((simtst103)(CUR$.SL$)),CONC(p3$id,new TXT$(": Terminates")));
        terminate();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst103.sim","Class Car",1,37,16,1,18,39,20,40,22,41,24,42,26,43,28,1,30,39,33,44);
}
