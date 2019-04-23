package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Apr 22 15:25:28 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HelloWorld extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HelloWorld(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("HelloWorld");
    }
    public RTObject$ STM$() {
        sysout().outtext(new TXT$("Hello World!"));
        sysout().outimage();
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new HelloWorld(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HelloWorld.sim","SimulaProgram HelloWorld",1,2,15,3,24,4);
}
