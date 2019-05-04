package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat May 04 11:46:16 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SubSep extends Separat {
    public int prefixLevel() { return(1); }
    public final int ICHR$1=(int)(49);
    public SubSep(RTObject$ staticLink,int sp$i) {
        super(staticLink,sp$i);
        TRACE_BEGIN_DCL$("SubSep",13);
    }
    public SubSep STM$() {
        new Separat$Print(((Separat)CUR$),new TXT$("--- Start Statements of Class Separat"));
        nA=0;
        nB=0;
        x=new Separat$B(((SubSep)CUR$)).STM$();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass2.sim","Class SubSep",1,3,8,5,15,63,17,64,23,18);
}
