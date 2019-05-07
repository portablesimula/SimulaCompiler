package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue May 07 13:54:39 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Atkins extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int MAX=0;
    int SQRT_MAX=0;
    public Atkins(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("Atkins");
    }
    public RTObject$ STM$() {
        sysout().outtext(new TXT$("Find out how many primes are less than "));
        sysout().breakoutimage();
        MAX=sysin().inint();
        sysout().outimage();
        SQRT_MAX=((int)((int)Math.round((sqrt(((double)(MAX)))+(((double)(1)))))));
        new Atkins$SubBlock7(CUR$).STM$();
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new Atkins(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Atkins.sim","SimulaProgram Atkins",1,1,16,3,19,4,22,5,24,49,33,51);
}
