package simulaTestBatch;
// Simula-2.0 Compiled at Tue Aug 16 13:41:45 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SimulaTest extends CLASS$ {
    public int p$n;
    public TXT$ p$title;
    public boolean found_error=false;
    public int nFailed=0;
    public final boolean verbose=(boolean)(false);
    public boolean noMessage=false;
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
    public static PROGINFO$ INFO$=new PROGINFO$("SimulaTest.sim","Class SimulaTest",1,2,9,5,11,6,13,7,15,8,24,16,26,17,34,18,37,19,45,16,47,24,51,25,54,26,67,29,69,30,84,34);
}
