package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 09:15:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Declarations$C extends CLASS$ {
    public int prefixLevel() { return(0); }
    public int p$i;
    public LABQNT$ p$l;
    public PRCQNT$ p$q;
    public Declarations$C(RTObject$ staticLink,int sp$i,LABQNT$ sp$l,PRCQNT$ sp$q) {
        super(staticLink);
        this.p$i = sp$i;
        this.p$l = sp$l;
        this.p$q = sp$q;
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("C",8);
    }
    public Declarations$C STM$() {
        p$q.CPF();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Declarations.sim","Class C",1,8,23,9);
}
