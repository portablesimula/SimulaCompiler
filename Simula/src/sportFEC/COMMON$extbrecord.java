package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Apr 14 09:36:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$extbrecord extends COMMON$brecord {
    public int prefixLevel() { return(1); }
    public COMMON$extquantity cause$1=null;
    public int exttagnum$1=0;
    public int ftag$1=0;
    public char checkhi$1=0;
    public char checklo$1=0;
    public char modulhi$1=0;
    public char modullo$1=0;
    public char status$1=0;
    public COMMON$extbrecord(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("extbrecord",1121);
    }
    public COMMON$extbrecord STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class extbrecord",1,1103,8,1104,10,1113,12,1116,14,1118,17,1120,20,1121,27,1137,30,1137);
}
