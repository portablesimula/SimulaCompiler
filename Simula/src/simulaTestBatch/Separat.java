package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Apr 21 13:18:11 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Separat extends CLASS$ {
    public int prefixLevel() { return(0); }
    public int p$i;
    public TXT$ t=null;
    public int nA=0;
    public int nB=0;
    public int eventValue=0;
    public Separat$A x=null;
    public Separat$B y=null;
    public PRCQNT$ checkEvent$0(){ throw new RuntimeException("No Virtual Match: checkEvent"); }
    public Separat(RTObject$ staticLink,int sp$i) {
        super(staticLink);
        this.p$i = sp$i;
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("Separat",52);
    }
    public Separat STM$() {
        new Separat$Event(((Separat)CUR$),1,9163876);
        nA=0;
        nB=0;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Separat.sim","Class Separat",1,2,9,5,11,6,14,7,16,18,18,19,28,54,30,55,33,54,36,57);
}
