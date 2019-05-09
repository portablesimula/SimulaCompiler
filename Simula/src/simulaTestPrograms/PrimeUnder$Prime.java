package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:38:12 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class PrimeUnder$Prime extends Process$ {
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    public int which$3=0;
    public PrimeUnder$Prime(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("Prime",17);
    }
    public PrimeUnder$Prime STM$() {
        detach();
        ((PrimeUnder)(CUR$.SL$)).acc$2=(((PrimeUnder)(CUR$.SL$)).acc$2+(1));
        which$3=((int)((int)Math.round(((PrimeUnder)(CUR$.SL$)).time())));
        sysout().outint(which$3,7);
        while(true) {
            {
                if(VALUE$((nextev().evtime()>((((PrimeUnder)(CUR$.SL$)).time()+(((double)(1)))))))) {
                    ((PrimeUnder)(CUR$.SL$)).ActivateDelay(false,((PrimeUnder$Prime)new PrimeUnder$Prime(((PrimeUnder)(CUR$.SL$))).START$()),1,false);
                }
                ((PrimeUnder)(CUR$.SL$)).hold(((double)(which$3)));
            }
            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
        }
        terminate();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("PrimeUnder.sim","Class Prime",1,16,9,17,16,1,18,18,20,19,22,20,24,21,26,22,29,23,32,24,37,1,39,18,42,26);
}
