package simulaTestBatch;
// Simula-2.0 Compiled at Fri Aug 12 13:52:55 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst54 extends SimulaTest {
    public simtst54(RTObject$ staticLink,int sp$n,TXT$ sp$title) {
        super(staticLink,sp$n,sp$title);
        BPRG("simtst54");
    }
    public simtst54 STM$() {
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
        new simtst54$PBLK6((CUR$)).START$();
        ;
        ;
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
        EBLK();
        return(this);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst54(CTX$,54,new TXT$("--- A VERY Simple Simulation")).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst54.sim","PrefixedBlock simtst54",1,5,12,14,14,15,22,16,25,17,33,62,35,60,37,14,39,22,41,23,54,26,56,27,67,60,75,64);
}
