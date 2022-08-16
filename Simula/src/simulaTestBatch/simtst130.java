package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130 extends SimulaTest {
    public simtst130(RTObject$ staticLink,int sp$n,TXT$ sp$title) {
        super(staticLink,sp$n,sp$title);
        BPRG("simtst130");
    }
    public simtst130 STM$() {
        if(VALUE$(false)) {
            {
                sysout().outtext(new TXT$("--- START Simula a.s. TEST"));
                ;
                sysout().outint(p$n,4);
                ;
                sysout().outimage();
                ;
                sysout().outtext(p$title);
                ;
                sysout().outimage();
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        new simtst130$PBLK16((CUR$)).STM$();
        ;
        ;
        if(VALUE$(noMessage)) {
            ;
        } else
        {
            if(VALUE$((!(found_error)))) {
                {
                    sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST"));
                    ;
                    sysout().outint(p$n,4);
                    ;
                    sysout().outtext(new TXT$("  "));
                    ;
                    sysout().outtext(p$title);
                    ;
                }
            }
            ;
            if(VALUE$(false)) {
                {
                    sysout().outtext(new TXT$("--- END Simula a.s. TEST"));
                    ;
                    sysout().outint(p$n,4);
                    ;
                    sysout().outimage();
                    ;
                }
            }
            ;
        }
        ;
        EBLK();
        return(this);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst130(CTX$,130,new TXT$("--- Test Class DEC\u005fLib, a set of utility procedures from DEC Handbook.")).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","PrefixedBlock simtst130",1,12,12,16,14,17,22,18,25,19,33,1311,35,1307,37,16,39,24,43,25,46,26,59,29,61,30,74,1307,82,1311);
}
