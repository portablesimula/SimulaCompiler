package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:17:09 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr07 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    simerr07$A x=null;
    float r=0.0f;
    simerr07$A inspect$12$0=null;
    public simerr07(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simerr07");
    }
    public RTObject$ STM$() {
        {
            inspect$12$0=x;
            if(inspect$12$0!=null)
            r=new simerr07$A$F(inspect$12$0,r).RESULT$;
        }
        r=new simerr07$A$F(x,r).RESULT$;
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simerr07(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr07.sim","SimulaProgram simerr07",1,4,10,5,12,12,25,14,34,16);
}
