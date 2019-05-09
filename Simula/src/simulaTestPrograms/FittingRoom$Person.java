package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:41:57 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class FittingRoom$Person extends Process$ {
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    public TXT$ p3$pname;
    public FittingRoom$Person(RTObject$ staticLink,TXT$ sp3$pname) {
        super(staticLink);
        this.p3$pname = sp3$pname;
        TRACE_BEGIN_DCL$("Person",43);
    }
    public FittingRoom$Person STM$() {
        detach();
        while(true) {
            {
                ((FittingRoom)(CUR$.SL$)).hold(normal(((double)(12)),((double)(4)),((FittingRoom)(CUR$.SL$)).u$2));
                new FittingRoom$report(((FittingRoom)(CUR$.SL$)),CONC(p3$pname,new TXT$(" is requesting the fitting room")));
                new FittingRoom$FittingRoom$request(((FittingRoom)(CUR$.SL$)).fittingRoom1$2);
                new FittingRoom$report(((FittingRoom)(CUR$.SL$)),CONC(p3$pname,new TXT$(" has entered the fitting room")));
                ((FittingRoom)(CUR$.SL$)).hold(normal(((double)(3)),((double)(1)),((FittingRoom)(CUR$.SL$)).u$2));
                new FittingRoom$FittingRoom$leave(((FittingRoom)(CUR$.SL$)).fittingRoom1$2);
                new FittingRoom$report(((FittingRoom)(CUR$.SL$)),CONC(p3$pname,new TXT$(" has left the fitting room")));
            }
            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
        }
        terminate();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Class Person",1,43,16,1,18,44,20,45,23,46,25,47,27,48,29,49,31,50,33,51,38,1,40,44,43,53);
}
