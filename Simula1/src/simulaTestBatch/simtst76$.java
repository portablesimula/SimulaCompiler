package simulaTestBatch;
// Simula-2.0 Compiled at Tue Jun 14 15:26:58 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst76$ extends BASICIO$ {
    public boolean found_error=false;
    public final boolean verbose=(boolean)(false);
    public TXT$ t=null;
    public simtst76$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst76$");
    }
    public RTObject$ STM$() {
        if(VALUE$(false)) {
            {
                sysout().outtext(new TXT$("--- START Simula a.s. TEST 76"));
                ;
                sysout().outimage();
                ;
                sysout().outtext(new TXT$("--- Test of detach and resume."));
                ;
                sysout().outimage();
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        new simtst76$PBLK27((CUR$)).STM$();
        ;
        new simtst76$PBLK69((CUR$)).STM$();
        ;
        if(VALUE$(found_error)) {
            ;
        } else
        {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 76"));
            ;
        }
        ;
        if(VALUE$(false)) {
            {
                sysout().outtext(new TXT$("--- END Simula a.s. TEST 76"));
                ;
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst76.sim","SimulaProgram simtst76$",1,11,8,12,10,13,18,18,20,19,24,20,27,21,30,22,38,66,41,110,44,112,48,115,54,118,56,119,60,124,71,124);
}
