package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Apr 21 13:18:13 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst86$PBLK19 extends Separat {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public PRCQNT$ checkEvent$0() { return(new PRCQNT$(this,simtst86$simtst86$PBLK19$checkEvent.class)); }
    public simtst86$PBLK19(RTObject$ staticLink,int sp$i) {
        super(staticLink,sp$i);
    }
    public simtst86$PBLK19 STM$() {
        new Separat$Event(((Separat)CUR$),1,9163876);
        nA=0;
        nB=0;
        if(VALUE$(((simtst86)(CUR$.SL$)).verbose)) {
            {
                sysout().outtext(new TXT$("--- START TEST 86"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- Simple Test of Separately Compiled Class."));
                sysout().outimage();
                sysout().outimage();
            }
        }
        x=new Separat$B(((simtst86$PBLK19)CUR$)).STM$();
        if(VALUE$(((simtst86)(CUR$.SL$)).found_error)) {
        } else
        {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 86"));
        }
        if(VALUE$(((simtst86)(CUR$.SL$)).verbose)) {
            {
                sysout().outtext(new TXT$("--- END TEST 86"));
                sysout().outimage();
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst86.sim","PrefixedBlock simtst86$PBLK19",1,19,14,54,16,55,19,30,21,31,25,32,27,33,32,36,34,38,37,41,41,44,43,45,46,49,52,49);
}
