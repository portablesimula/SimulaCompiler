package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:07:53 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class VirtualLabel2 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    VirtualLabel2$B x=null;
    public VirtualLabel2(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("VirtualLabel2");
    }
    public RTObject$ STM$() {
        x=new VirtualLabel2$C(((VirtualLabel2)CUR$)).STM$();
        sysout().outtext(new TXT$("In MAIN after new B"));
        sysout().outimage();
        sysout().outtext(CONC(new TXT$("In MAIN after new "),x.ident$1));
        sysout().outimage();
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new VirtualLabel2(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("VirtualLabel2.sim","SimulaProgram VirtualLabel2",1,3,9,34,17,35,19,36,22,37,32,38);
}
