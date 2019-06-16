package simulaTestBatch;
// Simula-1.0 Compiled at Sat Jun 15 10:11:34 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst54$Car extends Process$ {
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    public TXT$ p3$pname;
    public simtst54$Car(RTObject$ staticLink,TXT$ sp3$pname) {
        super(staticLink);
        this.p3$pname = sp3$pname;
        TRACE_BEGIN_DCL$("Car",45);
    }
    public simtst54$Car STM$() {
        detach();
        new simtst54$report(((simtst54)(CUR$.SL$)),CONC(p3$pname,new TXT$(" is initiating")));
        while(true) {
            {
                new simtst54$report(((simtst54)(CUR$.SL$)),CONC(p3$pname,new TXT$(" is active 1")));
                ((simtst54)(CUR$.SL$)).hold(((double)(4)));
                new simtst54$report(((simtst54)(CUR$.SL$)),CONC(p3$pname,new TXT$(" is active 2")));
            }
            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
        }
        terminate();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst54.sim","Class Car",1,45,16,1,18,47,20,48,22,50,25,51,27,52,32,1,34,47,37,54);
}
