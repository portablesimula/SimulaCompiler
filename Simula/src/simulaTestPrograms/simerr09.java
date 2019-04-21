package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:17:37 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr09 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    int j=0;
    int null$=0;
    char c=0;
    final char k=(char)(((char)39));
    public simerr09(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simerr09");
    }
    public RTObject$ STM$() {
        c=char$(null$);
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simerr09(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr09.sim","SimulaProgram simerr09",1,4,11,5,13,6,21,7,30,9);
}
