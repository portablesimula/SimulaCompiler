package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Apr 14 09:36:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$stackedb extends CLASS$ {
    public int prefixLevel() { return(0); }
    public char p$oldblev;
    public char p$oldrtblev;
    public int p$oldconnests;
    public char p$oldinsp;
    public COMMON$stackedb p$prev;
    public COMMON$stackedi redeclChain=null;
    public COMMON$stackedb(RTObject$ staticLink,char sp$oldblev,char sp$oldrtblev,int sp$oldconnests,char sp$oldinsp,COMMON$stackedb sp$prev) {
        super(staticLink);
        this.p$oldblev = sp$oldblev;
        this.p$oldrtblev = sp$oldrtblev;
        this.p$oldconnests = sp$oldconnests;
        this.p$oldinsp = sp$oldinsp;
        this.p$prev = sp$prev;
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("stackedb",1171);
    }
    public COMMON$stackedb STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class stackedb",12,1171,27,1171);
}
