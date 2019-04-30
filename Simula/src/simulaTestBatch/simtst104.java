package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Tue Apr 30 10:26:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst104 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    float r=0.0f;
    public simtst104(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst104");
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- START SIMULA TEST 104"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- Procedure parameter 'F' by name."));
                sysout().outimage();
                sysout().outtext(new TXT$("--- Which should be evaluated and called when used."));
                sysout().outimage();
                sysout().outimage();
            }
        }
        r=new simtst104$Q(((simtst104)CUR$),new NAME$<PRCQNT$>(){ public PRCQNT$ get() { return(new PRCQNT$(((simtst104)CUR$),simtst104$P.class)); } }).RESULT$;
        new simtst104$trace(((simtst104)CUR$),new TXT$("r := Q(P)"),r,((float)(34)));
        if(VALUE$(found_error)) {
        } else
        {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 104"));
        }
        if(VALUE$(verbose)) {
            {
                sysout().outimage();
                sysout().outtext(new TXT$("--- END SIMULA TEST 104"));
                sysout().outimage();
            }
        }
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst104(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst104.sim","SimulaProgram simtst104",1,10,9,11,11,12,19,37,21,38,25,39,28,40,30,41,35,44,37,45,39,47,42,50,46,53,48,54,51,55,53,56,64,58);
}
