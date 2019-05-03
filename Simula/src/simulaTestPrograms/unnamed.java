package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 02 20:39:24 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class unnamed extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public unnamed(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("unnamed");
    }
    public RTObject$ STM$() {
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new unnamed(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("unnamed.sim","SimulaProgram unnamed",1,3,21,3);
}
