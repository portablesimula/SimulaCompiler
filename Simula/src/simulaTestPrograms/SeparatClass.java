package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:18:01 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SeparatClass extends CLASS$ {
    public int prefixLevel() { return(0); }
    public int p$i;
    public SeparatClass$A x=null;
    public int n=0;
    public SeparatClass(RTObject$ staticLink,int sp$i) {
        super(staticLink);
        this.p$i = sp$i;
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("SeparatClass",11);
    }
    public SeparatClass STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("PrecompiledClass.sim","Class SeparatClass",1,2,9,4,11,5,20,13,23,13);
}
