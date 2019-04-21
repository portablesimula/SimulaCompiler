package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:25:32 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class issue17$p$issue17$PBLK18$Car extends Process$ {
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    public TXT$ p3$pname;
    public issue17$p$issue17$PBLK18$Car(RTObject$ staticLink,TXT$ sp3$pname) {
        super(staticLink);
        this.p3$pname = sp3$pname;
        TRACE_BEGIN_DCL$("Car",20);
    }
    public issue17$p$issue17$PBLK18$Car STM$() {
        detach();
        new issue17$trace(((issue17)(CUR$.SL$.SL$.SL$)),copy(CONC(p3$pname,new TXT$(" is initiating"))));
        while(true) {
            {
                new issue17$trace(((issue17)(CUR$.SL$.SL$.SL$)),copy(CONC(p3$pname,new TXT$(" is active 1"))));
                ((issue17$PBLK18)(CUR$.SL$)).hold(((double)(4)));
                new issue17$trace(((issue17)(CUR$.SL$.SL$.SL$)),copy(CONC(p3$pname,new TXT$(" is active 2"))));
                GOTO$(((issue17$PBLK18)(CUR$.SL$)).EXIT_LABEL);
            }
            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
        }
        terminate();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("issue17.sim","Class Car",1,20,16,1,18,22,20,23,22,25,25,26,27,27,29,28,34,1,36,22,39,30);
}
