package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 13:17:22 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst119$PBLK5 extends SubSep {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    final float rrr$2;
    TXT$ fname$2=null;
    public simtst119$PBLK5(RTObject$ staticLink,int sp$i) {
        super(staticLink,sp$i);
        rrr$2=rr+(3.14f);
    }
    public simtst119$PBLK5 STM$() {
        new MainSeparat$Print(((MainSeparat)CUR$),new TXT$("--- Start Statements of Class MainSeparat"));
        nA=0;
        nB=0;
        new MainSeparat$Print(((SubSep)CUR$),new TXT$("--- Start Statements of Class SubSep"));
        x=new MainSeparat$B(((SubSep)CUR$)).STM$();
        new MainSeparat$Print(((simtst119$PBLK5)CUR$),new TXT$("--- Start Statements of SubSep(5) begin"));
        x=new MainSeparat$B(((simtst119$PBLK5)CUR$)).STM$();
        iA.Elt[3-iA.LB[0]]=5;
        if(VALUE$(((ICHR$1==(49))&((IINT==(45)))))) {
            {
                sysout().outtext(new TXT$("OK"));
                sysout().outimage();
            }
        }
        fname$2=sysout().filename();
        new SubSep$PP(((simtst119$PBLK5)CUR$));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst119.sim","PrefixedBlock simtst119$PBLK5",1,5,10,6,17,77,19,78,22,18,24,19,26,7,28,8,30,9,32,10,34,11,40,13,42,14,46,16);
}
