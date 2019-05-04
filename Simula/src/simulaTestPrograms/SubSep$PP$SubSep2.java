package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat May 04 11:46:16 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SubSep$PP$SubSep2 extends Separat {
    public int prefixLevel() { return(1); }
    public SubSep$PP$SubSep2(RTObject$ staticLink,int sp$i) {
        super(staticLink,sp$i);
        TRACE_BEGIN_DCL$("SubSep2",10);
    }
    public SubSep$PP$SubSep2 STM$() {
        new Separat$Print(((Separat)CUR$),new TXT$("--- Start Statements of Class Separat"));
        nA=0;
        nB=0;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass2.sim","Class SubSep2",1,10,13,63,15,64,18,13,21,13);
}
