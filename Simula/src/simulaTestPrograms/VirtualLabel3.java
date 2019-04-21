package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:08:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class VirtualLabel3 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    VirtualLabel3$MAINPROGRAM DEMOS=null;
    public VirtualLabel3(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("VirtualLabel3");
    }
    public RTObject$ STM$() {
        DEMOS=((VirtualLabel3$MAINPROGRAM)new VirtualLabel3$MAINPROGRAM(((VirtualLabel3)CUR$),copy(new TXT$("DEMOS"))).START$());
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new VirtualLabel3(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("VirtualLabel3.sim","SimulaProgram VirtualLabel3",1,2,16,29,25,30);
}
