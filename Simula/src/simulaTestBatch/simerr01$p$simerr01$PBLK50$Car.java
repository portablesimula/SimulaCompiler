package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 12:48:41 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simerr01$p$simerr01$PBLK50$Car extends Process$ {
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    public TXT$ p3$pname;
    public simerr01$p$simerr01$PBLK50$Car(RTObject$ staticLink,TXT$ sp3$pname) {
        super(staticLink);
        this.p3$pname = sp3$pname;
        TRACE_BEGIN_DCL$("Car",52);
    }
    public simerr01$p$simerr01$PBLK50$Car STM$() {
        detach();
        new simerr01$trace(((simerr01)(CUR$.SL$.SL$.SL$)),CONC(p3$pname,new TXT$(" is initiating")));
        while(true) {
            {
                new simerr01$trace(((simerr01)(CUR$.SL$.SL$.SL$)),CONC(p3$pname,new TXT$(" is active 1")));
                ((simerr01$PBLK50)(CUR$.SL$)).hold(((double)(4)));
                new simerr01$trace(((simerr01)(CUR$.SL$.SL$.SL$)),CONC(p3$pname,new TXT$(" is active 2")));
                GOTO$(((simerr01$PBLK50)(CUR$.SL$)).EXIT_LABEL);
            }
            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
        }
        terminate();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr01.sim","Class Car",1,52,16,1,18,54,20,55,22,57,25,58,27,59,29,60,34,1,36,54,39,62);
}
