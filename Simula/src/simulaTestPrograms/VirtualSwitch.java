package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:08:23 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class VirtualSwitch extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    VirtualSwitch$B x=null;
    public VirtualSwitch(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("VirtualSwitch");
    }
    public RTObject$ STM$() {
        x=new VirtualSwitch$B(((VirtualSwitch)CUR$)).STM$();
        sysout().outtext(new TXT$("In MAIN after new B"));
        sysout().outimage();
        sysout().outtext(CONC(new TXT$("In MAIN after new "),x.ident$1));
        sysout().outimage();
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new VirtualSwitch(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("VirtualSwitch.sim","SimulaProgram VirtualSwitch",1,3,9,22,17,23,19,24,22,25,32,26);
}
