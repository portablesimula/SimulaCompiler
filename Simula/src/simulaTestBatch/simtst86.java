package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Apr 21 13:18:13 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst86 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    boolean found_error=false;
    final boolean verbose=(boolean)(false);
    public simtst86(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst86");
    }
    public RTObject$ STM$() {
        new simtst86$PBLK19(CUR$,5).STM$();
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst86(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst86.sim","SimulaProgram simtst86",1,10,9,11,17,49,26,51);
}
