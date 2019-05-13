package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:36 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$sembox extends CLASS$ {
    public int prefixLevel() { return(0); }
    public COMMON$sembox prevmeaning=null;
    public COMMON$sembox next=null;
    public COMMON$sembox(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("sembox",111);
    }
    public COMMON$sembox STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class sembox",1,109,8,110,10,111,18,112,21,112);
}
