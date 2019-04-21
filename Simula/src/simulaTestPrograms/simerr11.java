package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:18:13 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr11 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public simerr11(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simerr11");
    }
    public RTObject$ STM$() {
        new simerr11$PBLK7(CUR$,5).STM$();
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simerr11(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr11.sim","SimulaProgram simerr11",1,4,14,10,23,12);
}
