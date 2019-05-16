package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 16:39:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simerr01$p$simerr01$PBLK48$Car extends Process$ {
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    public TXT$ p3$pname;
    public simerr01$p$simerr01$PBLK48$Car(RTObject$ staticLink,TXT$ sp3$pname) {
        super(staticLink);
        this.p3$pname = sp3$pname;
        TRACE_BEGIN_DCL$("Car",50);
    }
    public simerr01$p$simerr01$PBLK48$Car STM$() {
        detach();
        new simerr01$trace(((simerr01)(CUR$.SL$.SL$.SL$)),CONC(p3$pname,new TXT$(" is initiating")));
        while(true) {
            {
                new simerr01$trace(((simerr01)(CUR$.SL$.SL$.SL$)),CONC(p3$pname,new TXT$(" is active 1")));
                ((simerr01$PBLK48)(CUR$.SL$)).hold(((double)(4)));
                new simerr01$trace(((simerr01)(CUR$.SL$.SL$.SL$)),CONC(p3$pname,new TXT$(" is active 2")));
                GOTO$(((simerr01$PBLK48)(CUR$.SL$)).EXIT_LABEL);
            }
            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
        }
        terminate();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr01.sim","Class Car",1,50,16,1,18,52,20,53,22,55,25,56,27,57,29,58,34,1,36,52,39,60);
}
