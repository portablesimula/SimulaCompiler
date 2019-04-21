package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:25:32 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue17 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public issue17(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("issue17");
    }
    public RTObject$ STM$() {
        sysout().outtext(new TXT$("--- START GOTO SAMPLE"));
        sysout().outimage();
        new issue17$p(((issue17)CUR$));
        sysout().outtext(new TXT$("THIS LINE SHOULD NEVER BE EXECUTED"));
        sysout().outimage();
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new issue17(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("issue17.sim","SimulaProgram issue17",1,10,14,44,17,46,19,48,29,51);
}
