package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Apr 14 09:36:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$component extends CLASS$ {
    public int prefixLevel() { return(0); }
    public char cs=0;
    public boolean getopt=false;
    public COMMON$component(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("component",1200);
    }
    public COMMON$component STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class component",1,1199,8,1200,17,1202,20,1202);
}
