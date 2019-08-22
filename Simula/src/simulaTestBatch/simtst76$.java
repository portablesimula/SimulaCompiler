package simulaTestBatch;
// Simula-1.0 Compiled at Thu Aug 22 12:24:09 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst76$ extends BASICIO$ {
    boolean found_error=false;
    final boolean verbose=(boolean)(false);
    TXT$ t=null;
    public simtst76$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst76$");
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- START Simula a.s. TEST 76"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- Test of detach and resume."));
                sysout().outimage();
                sysout().outimage();
            }
        }
        new simtst76$PBLK27((CUR$)).STM$();
        new simtst76$PBLK69((CUR$)).STM$();
        if(VALUE$(found_error)) {
        } else
        {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 76"));
        }
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- END Simula a.s. TEST 76"));
                sysout().outimage();
            }
        }
        EBLK();
        return(this);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst76$(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst76.sim","SimulaProgram simtst76$",1,11,8,12,10,13,18,18,20,19,23,20,25,21,27,22,32,66,34,116,36,118,39,121,43,124,45,125,48,130,59,130);
}
