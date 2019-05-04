package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat May 04 11:46:26 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ExternalClass3 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public ExternalClass3(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("ExternalClass3");
    }
    public RTObject$ STM$() {
        new ExternalClass3$PBLK5(CUR$,5).STM$();
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new ExternalClass3(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass3.sim","SimulaProgram ExternalClass3",1,2,14,13,23,15);
}
