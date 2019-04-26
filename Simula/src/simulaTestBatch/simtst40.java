package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu Apr 25 10:29:21 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst40 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    boolean found_error=false;
    final boolean verbose=(boolean)(false);
    int i=0;
    public simtst40(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst40");
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- START Simula a.s. TEST 40"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- Test use of external procedures."));
                sysout().outimage();
                sysout().outimage();
            }
        }
        i=new pa(((simtst40)CUR$),0).RESULT$;
        if(VALUE$((i==(45)))) {
        } else
        {
            sysout().outtext(new TXT$("*** error : PA returned with wrong value."));
            sysout().outimage();
            sysout().outtext(new TXT$("            Erroneus value : "));
            sysout().outint(i,5);
            sysout().outimage();
            found_error=true;
        }
        if(VALUE$(found_error)) {
        } else
        {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 40"));
        }
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- END Simula a.s. TEST 40"));
                sysout().outimage();
            }
        }
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst40(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst40.sim","SimulaProgram simtst40",1,27,8,29,10,30,12,31,20,33,22,34,25,35,27,36,29,37,34,40,36,41,39,44,42,45,44,46,46,47,48,48,50,49,53,52,56,55,60,58,62,59,65,63,76,63);
}
