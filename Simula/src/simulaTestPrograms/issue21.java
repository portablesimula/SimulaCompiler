package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 09:41:12 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue21 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public issue21(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("issue21");
    }
    public RTObject$ STM$() {
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new issue21(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("issue21.sim","SimulaProgram issue21",1,2,21,2);
}
