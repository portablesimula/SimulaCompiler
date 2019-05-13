package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:36 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$idpack extends CLASS$ {
    public int prefixLevel() { return(0); }
    public char idhi=0;
    public char idlo=0;
    public int line=0;
    public COMMON$idpack next=null;
    public COMMON$idpack(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("idpack",1190);
    }
    public COMMON$idpack STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class idpack",1,1187,8,1188,11,1189,13,1190,21,1197,24,1197);
}
