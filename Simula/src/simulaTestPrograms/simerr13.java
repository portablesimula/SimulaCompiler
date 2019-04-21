package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:19:29 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr13 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    simerr13$Coder forcoder=null;
    public simerr13(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simerr13");
    }
    public RTObject$ STM$() {
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simerr13(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr13.sim","SimulaProgram simerr13",1,2,9,11,24,23);
}
