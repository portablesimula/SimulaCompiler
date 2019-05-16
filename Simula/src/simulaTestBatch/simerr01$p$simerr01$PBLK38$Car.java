package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 12:09:27 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simerr01$p$simerr01$PBLK38$Car extends Process$ {
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    public TXT$ p3$pname;
    public simerr01$p$simerr01$PBLK38$Car(RTObject$ staticLink,TXT$ sp3$pname) {
        super(staticLink);
        this.p3$pname = sp3$pname;
        TRACE_BEGIN_DCL$("Car",40);
    }
    public simerr01$p$simerr01$PBLK38$Car STM$() {
        detach();
        new simerr01$trace(((simerr01)(CUR$.SL$.SL$.SL$)),CONC(p3$pname,new TXT$(" is initiating")));
        while(true) {
            {
                new simerr01$trace(((simerr01)(CUR$.SL$.SL$.SL$)),CONC(p3$pname,new TXT$(" is active 1")));
                ((simerr01$PBLK38)(CUR$.SL$)).hold(((double)(4)));
                new simerr01$trace(((simerr01)(CUR$.SL$.SL$.SL$)),CONC(p3$pname,new TXT$(" is active 2")));
                GOTO$(((simerr01$PBLK38)(CUR$.SL$)).EXIT_LABEL);
            }
            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
        }
        terminate();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr01.sim","Class Car",1,40,16,1,18,42,20,43,22,45,25,46,27,47,29,48,34,1,36,42,39,50);
}
