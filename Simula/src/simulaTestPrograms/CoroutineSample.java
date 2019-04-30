package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Apr 29 09:38:40 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CoroutineSample extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    final boolean verbose=(boolean)(true);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    CoroutineSample$A x=null;
    public CoroutineSample(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("CoroutineSample");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=6;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- START SIMULA TEST 104"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- Simple Co-Routine Sample"));
                sysout().outimage();
                sysout().outimage();
            }
        }
        facit.Elt[0-facit.LB[0]]=new TXT$("Main: Before new A");
        facit.Elt[1-facit.LB[0]]=new TXT$("A: State 1(Initiating)");
        facit.Elt[2-facit.LB[0]]=new TXT$("Main: Before first call");
        facit.Elt[3-facit.LB[0]]=new TXT$("A: State 2");
        facit.Elt[4-facit.LB[0]]=new TXT$("Main: Before second call");
        facit.Elt[5-facit.LB[0]]=new TXT$("A: State 3(Terminating)");
        facit.Elt[6-facit.LB[0]]=new TXT$("Main: Before third call");
        {
            new CoroutineSample$trace(((CoroutineSample)CUR$),new TXT$("Main: Before new A"));
            x=((CoroutineSample$A)new CoroutineSample$A(((CoroutineSample)CUR$)).START$());
            new CoroutineSample$trace(((CoroutineSample)CUR$),new TXT$("Main: Before first call"));
            call(x);
            new CoroutineSample$trace(((CoroutineSample)CUR$),new TXT$("Main: Before second call"));
            call(x);
            new CoroutineSample$trace(((CoroutineSample)CUR$),new TXT$("Main: Before third call"));
            if(VALUE$(found_error)) {
            } else
            {
                sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 104"));
                sysout().outimage();
            }
            if(VALUE$(verbose)) {
                {
                    sysout().outtext(new TXT$("--- END SIMULA TEST 104"));
                    sysout().outimage();
                }
            }
        }
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new CoroutineSample(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("CoroutineSample.sim","SimulaProgram CoroutineSample",1,9,10,10,12,11,14,12,16,13,22,12,29,38,31,39,35,40,37,41,42,44,44,45,46,46,48,47,50,48,52,49,54,50,56,53,59,54,61,55,63,56,65,57,67,58,69,59,71,63,74,66,77,67,80,70,82,71,85,72,97,75);
}
