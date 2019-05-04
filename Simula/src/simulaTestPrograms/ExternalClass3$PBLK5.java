package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat May 04 11:46:26 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ExternalClass3$PBLK5 extends SubSep {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    final float rrr$2;
    TXT$ fname$2=null;
    public ExternalClass3$PBLK5(RTObject$ staticLink,int sp$i) {
        super(staticLink,sp$i);
        rrr$2=rr+(3.14f);
    }
    public ExternalClass3$PBLK5 STM$() {
        new Separat$Print(((Separat)CUR$),new TXT$("--- Start Statements of Class Separat"));
        nA=0;
        nB=0;
        x=new Separat$B(((SubSep)CUR$)).STM$();
        x=new Separat$B(((ExternalClass3$PBLK5)CUR$)).STM$();
        iA.Elt[3-iA.LB[0]]=5;
        if(VALUE$(((ICHR$1==(49))&((IINT==(45)))))) {
            {
                sysout().outtext(new TXT$("OK"));
                sysout().outimage();
            }
        }
        fname$2=sysout().filename();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass3.sim","PrefixedBlock ExternalClass3$PBLK5",1,5,10,6,17,63,19,64,22,16,24,7,26,8,28,9,30,10,36,12,40,13);
}
