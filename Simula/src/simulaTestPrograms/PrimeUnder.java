package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:38:12 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PrimeUnder extends Simulation$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    int acc$2=0;
    public PrimeUnder(RTObject$ staticLink) {
        super(staticLink);
        BPRG("PrimeUnder");
    }
    public PrimeUnder STM$() {
        sysout().outtext(new TXT$("Show all primes less than "));
        sysout().breakoutimage();
        ((PrimeUnder)CUR$).ActivateAt(false,((PrimeUnder$Prime)new PrimeUnder$Prime(((PrimeUnder)CUR$)).START$()),2,false);
        hold(((double)(sysin().inint())));
        sysout().outimage();
        sysout().outimage();
        sysout().outint(acc$2,7);
        sysout().outtext(new TXT$(" primes found"));
        EBLK();
        return(this);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new PrimeUnder(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("PrimeUnder.sim","PrefixedBlock PrimeUnder",1,14,16,28,19,30,21,31,23,33,26,34,36,36);
}
