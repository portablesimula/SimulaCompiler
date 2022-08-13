package simulaTestBatch;
// Simula-2.0 Compiled at Fri Aug 12 13:52:55 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst54$simtst54$PBLK6$Car extends process$ {
    public boolean isDetachUsed() { return(true); }
    public TXT$ p3$pname;
    public simtst54$simtst54$PBLK6$Car(RTObject$ staticLink,TXT$ sp3$pname) {
        super(staticLink);
        this.p3$pname = sp3$pname;
    }
    public simtst54$simtst54$PBLK6$Car STM$() {
        detach();
        new simtst54$simtst54$PBLK6$report((CUR$.SL$),CONC(p3$pname,new TXT$(" is initiating")));
        ;
        while(true) {
            {
                new simtst54$simtst54$PBLK6$report((CUR$.SL$),CONC(p3$pname,new TXT$(" is active 1")));
                ;
                ((simtst54$PBLK6)(CUR$.SL$)).hold(4.0d);
                ;
                new simtst54$simtst54$PBLK6$report((CUR$.SL$),CONC(p3$pname,new TXT$(" is active 2")));
                ;
            }
            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
        }
        ;
        terminate();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst54.sim","Class Car",1,42,14,1,16,43,19,44,21,45,25,46,28,47,35,1,37,43,40,49);
}
