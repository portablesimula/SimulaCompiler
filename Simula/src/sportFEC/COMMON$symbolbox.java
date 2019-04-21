package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Apr 14 09:36:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$symbolbox extends CLASS$ {
    public int prefixLevel() { return(0); }
    public char idhi=0;
    public char idlo=0;
    public int idtag=0;
    public COMMON$symbolbox next=null;
    public TXT$ symbol=null;
    public COMMON$symbolbox(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("symbolbox",99);
    }
    public COMMON$symbolbox STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class symbolbox",1,94,8,95,11,96,13,98,15,99,23,100,26,100);
}
