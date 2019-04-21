package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Apr 14 09:36:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$quantity extends COMMON$sembox {
    public int prefixLevel() { return(1); }
    public char type$1=0;
    public char kind$1=0;
    public char categ$1=0;
    public char special$1=0;
    public char protect$1=0;
    public char visible$1=0;
    public int plev$1=0;
    public int dim$1=0;
    public int virtno$1=0;
    public int ftag$1=0;
    public int line$1=0;
    public COMMON$symbolbox symb$1=null;
    public COMMON$brecord encl$1=null;
    public COMMON$brecord descr$1=null;
    public COMMON$quantity prefqual$1=null;
    public COMMON$quantity match$1=null;
    public COMMON$quantity(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("quantity",947);
    }
    public COMMON$quantity STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class quantity",1,932,8,933,13,934,15,935,17,936,19,938,21,939,23,940,25,941,27,942,29,943,31,945,33,946,35,947,42,1100,45,1100);
}
