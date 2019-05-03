package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:06:03 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PrimeUnder$PBLK14 extends Simulation$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    int acc$2=0;
    public PrimeUnder$PBLK14(RTObject$ staticLink) {
        super(staticLink);
        BPRG("PrimeUnder$PBLK14");
    }
    public PrimeUnder$PBLK14 STM$() {
        sysout().outtext(new TXT$("Show all primes less than "));
        sysout().breakoutimage();
        ((PrimeUnder$PBLK14)CUR$).ActivateAt(false,((PrimeUnder$PBLK14$Prime)new PrimeUnder$PBLK14$Prime(((PrimeUnder$PBLK14)CUR$)).START$()),2,false);
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
        new PrimeUnder$PBLK14(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("PrimeUnder.sim","PrefixedBlock PrimeUnder$PBLK14",1,14,16,28,19,30,21,31,23,33,26,34,36,36);
}
