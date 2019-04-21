package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Fri Apr 19 09:17:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst32 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    boolean found_error=false;
    final boolean verbose=(boolean)(false);
    simtst32$A gra=null;
    simtst32$A ra=null;
    simtst32$B rb=null;
    simtst32$C rc=null;
    int gi=0;
    float gr=0.0f;
    char gch=0;
    boolean gbool=false;
    TXT$ gtext=null;
    public simtst32(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst32");
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- START Simula a.s. TEST 32"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- Simple test of formal procedures"));
                sysout().outimage();
                sysout().outimage();
            }
        }
        new simtst32$P(((simtst32)CUR$),new PRCQNT$(((simtst32)CUR$),simtst32$Ap.class));
        if(VALUE$(found_error)) {
        } else
        {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 32"));
        }
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- END Simula a.s. TEST 32"));
                sysout().outimage();
            }
        }
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst32(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst32.sim","SimulaProgram simtst32",1,10,10,11,13,32,15,33,17,34,19,35,21,36,23,37,25,38,27,39,35,143,37,144,40,145,42,146,44,147,49,150,51,152,54,155,58,158,60,159,63,163,74,163);
}
