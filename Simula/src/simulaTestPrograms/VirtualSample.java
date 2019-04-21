package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:08:12 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class VirtualSample extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    float x=0.0f;
    public VirtualSample(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("VirtualSample");
    }
    public RTObject$ STM$() {
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new VirtualSample(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("VirtualSample.sim","SimulaProgram VirtualSample",1,3,23,24);
}
