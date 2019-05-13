package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 15:12:55 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst119 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public simtst119(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst119");
    }
    public RTObject$ STM$() {
        new simtst119$PBLK12(CUR$,5).STM$();
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst119(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst119.sim","SimulaProgram simtst119",1,9,14,38,23,40);
}
