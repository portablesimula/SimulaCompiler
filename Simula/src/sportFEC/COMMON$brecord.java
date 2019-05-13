package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:36 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$brecord extends CLASS$ {
    public int prefixLevel() { return(0); }
    public char blnohi=0;
    public char blnolo=0;
    public char blev=0;
    public char rtblev=0;
    public char dcltag=0;
    public char stmtag=0;
    public char inrtag=0;
    public char kind=0;
    public boolean thisused=false;
    public boolean localclasses=false;
    public boolean descriptorpr=false;
    public boolean hasCode=false;
    public char inspected=0;
    public int connests=0;
    public int npar=0;
    public int navirt=0;
    public int line1=0;
    public COMMON$quantity declquant=null;
    public COMMON$quantity fpar=null;
    public COMMON$quantity favirt=null;
    public COMMON$idpack hidlist=null;
    public COMMON$stackedb preinsp=null;
    public COMMON$brecord(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("brecord",845);
    }
    public COMMON$brecord STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class brecord",1,822,8,824,13,825,17,826,19,828,21,829,23,830,25,831,27,832,29,833,31,835,33,837,35,838,37,839,39,840,41,841,43,842,45,845,53,929,56,929);
}
