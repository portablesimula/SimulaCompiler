package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:36 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$stackedi extends COMMON$sembox {
    public int prefixLevel() { return(1); }
    public char p1$rehi;
    public char p1$relo;
    public COMMON$stackedi(RTObject$ staticLink,char sp1$rehi,char sp1$relo) {
        super(staticLink);
        this.p1$rehi = sp1$rehi;
        this.p1$relo = sp1$relo;
        TRACE_BEGIN_DCL$("stackedi",1160);
    }
    public COMMON$stackedi STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class stackedi",1,1160,17,1164,20,1164);
}
