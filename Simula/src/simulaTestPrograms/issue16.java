package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:25:19 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue16 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    final int konst;
    InFile$ inspect$10$0=null;
    public issue16(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("issue16");
        konst=((int)((int)Math.round(sqrt(((double)(4))))));
    }
    public RTObject$ STM$() {
        {
            inspect$10$0=new InFile$(((BASICIO$)CTX$),sysout().filename()).STM$();
            if(inspect$10$0!=null)
            new issue16$PBLK12(CUR$).START$();
        }
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new issue16(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("issue16.sim","SimulaProgram issue16",1,8,9,11,18,10,22,17,32,18);
}
