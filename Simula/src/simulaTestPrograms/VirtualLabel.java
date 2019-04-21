package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:07:40 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class VirtualLabel extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    VirtualLabel$B x=null;
    public VirtualLabel(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("VirtualLabel");
    }
    public RTObject$ STM$() {
        x=new VirtualLabel$B(((VirtualLabel)CUR$)).STM$();
        sysout().outtext(new TXT$("In MAIN after new B"));
        sysout().outimage();
        sysout().outtext(CONC(new TXT$("In MAIN after new "),x.ident$1));
        sysout().outimage();
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new VirtualLabel(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("VirtualLabel.sim","SimulaProgram VirtualLabel",1,3,9,21,17,22,19,23,22,24,32,25);
}
