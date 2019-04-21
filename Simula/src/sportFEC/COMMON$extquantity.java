package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Apr 14 09:36:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$extquantity extends COMMON$quantity {
    public int prefixLevel() { return(2); }
    public COMMON$extbrecord p2$module;
    public char clf$2=0;
    public char longindic$2=0;
    public COMMON$extquantity(RTObject$ staticLink,COMMON$extbrecord sp2$module) {
        super(staticLink);
        this.p2$module = sp2$module;
        TRACE_BEGIN_DCL$("extquantity",1146);
    }
    public COMMON$extquantity STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class extquantity",1,1140,9,1145,11,1146,19,1154,22,1154);
}
