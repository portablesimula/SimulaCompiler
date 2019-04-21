package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:07:14 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class TextSamples1 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    int n=0;
    float r=0.0f;
    char c=0;
    TXT$ t=null;
    public TextSamples1(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("TextSamples1");
    }
    public RTObject$ STM$() {
        t=blanks(14);
        ASGSTR$(t,"abracadabra");
        if(VALUE$(TRF_NE(t,null))) {
            ASGSTR$(TXT$.sub(t,1,3),"abc");
        }
        t=copy(copy(new TXT$("barabra")));
        sysout().outtext(t);
        sysout().outimage();
        if(VALUE$(TXT$.constant(t))) {
            {
            }
        }
        i=TXT$.start(t);
        i=TXT$.length(t);
        t=TXT$.main(t);
        i=TXT$.pos(t);
        TXT$.setpos(t,34);
        if(VALUE$(TXT$.more(t))) {
            {
            }
        }
        c=TXT$.getchar(t);
        TXT$.putchar(t,c);
        t=TXT$.sub(t,3,6);
        t=TXT$.strip(t);
        i=TXT$.getint(t);
        i=((int)((int)Math.round(TXT$.getreal(t))));
        i=TXT$.getfrac(t);
        TXT$.putint(t,i);
        TXT$.putfix(t,r,n);
        TXT$.putreal(t,r,n);
        TXT$.putfrac(t,i,n);
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new TextSamples1(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("TextSamples1.sim","SimulaProgram TextSamples1",1,2,10,3,12,4,14,5,22,6,24,7,26,8,30,9,32,10,35,12,40,13,42,14,44,15,46,16,48,17,50,18,55,19,57,20,59,21,61,22,63,23,65,24,67,25,69,26,71,27,73,28,75,29,84,32);
}
