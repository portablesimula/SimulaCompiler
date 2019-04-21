package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:17:25 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr08 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    simerr08$A x=null;
    final char k=(char)(((char)39));
    simerr08$A inspect$7$0=null;
    public simerr08(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simerr08");
    }
    public RTObject$ STM$() {
        {
            inspect$7$0=new simerr08$A(((simerr08)CUR$)).STM$();
            if(inspect$7$0!=null)
            {
                x=((simerr08$A)inspect$7$0);
            }
        }
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simerr08(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr08.sim","SimulaProgram simerr08",1,4,9,5,11,6,13,7,24,9,36,11);
}
