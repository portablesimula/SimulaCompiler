package simulaTestBatch;
// Simula-2.0 Compiled at Fri Aug 12 13:52:54 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SimulaTest extends CLASS$ {
    public int p$n;
    public TXT$ p$title;
    public boolean found_error=false;
    public final boolean verbose=(boolean)(false);
    public SimulaTest(RTObject$ staticLink,int sp$n,TXT$ sp$title) {
        super(staticLink);
        this.p$n = sp$n;
        this.p$title = sp$title;
        BBLK(); // Iff no prefix
    }
    public SimulaTest STM$() {
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
    public static PROGINFO$ INFO$=new PROGINFO$("SimulaTest.sim","Class SimulaTest",1,2,9,5,11,6,20,14,22,15,30,16,33,17,41,14,43,22,45,23,58,26,60,27,73,30);
}
