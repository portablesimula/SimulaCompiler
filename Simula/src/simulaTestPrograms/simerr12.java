package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:19:15 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr12 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public simerr12(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simerr12");
    }
    public RTObject$ STM$() {
        new SeparatProcedure(((simerr12)CUR$),5);
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simerr12(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr12.sim","SimulaProgram simerr12",1,2,14,4,23,6);
}
