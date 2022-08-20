package simulaTestBatch;
// Simula-2.0 Compiled at Sat Aug 20 06:39:17 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SimulaTest extends _CLASS {
    public int p_n;
    public _TXT p_title;
    public boolean found_error=false;
    public int nFailed=0;
    public final boolean verbose=(boolean)(false);
    public boolean noMessage=false;
    public SimulaTest(_RTObject staticLink,int sp_n,_TXT sp_title) {
        super(staticLink);
        this.p_n = sp_n;
        this.p_title = sp_title;
        BBLK(); // Iff no prefix
    }
    public SimulaTest _STM() {
        if(_VALUE(false)) {
            {
                sysout().outtext(new _TXT("--- START Simula a.s. TEST"));
                ;
                sysout().outint(p_n,4);
                ;
                sysout().outimage();
                ;
                sysout().outtext(p_title);
                ;
                sysout().outimage();
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        ;
        if(_VALUE(noMessage)) {
            ;
        } else
        {
            if(_VALUE((!(found_error)))) {
                {
                    sysout().outtext(new _TXT("--- NO ERRORS FOUND IN TEST"));
                    ;
                    sysout().outint(p_n,4);
                    ;
                    sysout().outtext(new _TXT("  "));
                    ;
                    sysout().outtext(p_title);
                    ;
                }
            }
            ;
            if(_VALUE(false)) {
                {
                    sysout().outtext(new _TXT("--- END Simula a.s. TEST"));
                    ;
                    sysout().outint(p_n,4);
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
    public static _PROGINFO INFO_=new _PROGINFO("SimulaTest.sim","Class SimulaTest",1,2,9,5,11,6,13,7,15,8,24,16,26,17,34,18,37,19,45,16,47,24,51,25,54,26,67,29,69,30,84,34);
}
