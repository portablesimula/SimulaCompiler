package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon Apr 29 11:35:36 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst109 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    final boolean verbose=(boolean)(true);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    simtst109$A x=null;
    public simtst109(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst109");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=6;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- START SIMULA TEST 109"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- Simple Co-Routine Sample"));
                sysout().outimage();
                sysout().outimage();
            }
        }
        facit.Elt[0-facit.LB[0]]=new TXT$("Main: Before new A");
        facit.Elt[1-facit.LB[0]]=new TXT$("A: State 1(Initiating)");
        facit.Elt[2-facit.LB[0]]=new TXT$("Main: Before first resume");
        facit.Elt[3-facit.LB[0]]=new TXT$("A: State 2");
        facit.Elt[4-facit.LB[0]]=new TXT$("Main: Before second resume");
        facit.Elt[5-facit.LB[0]]=new TXT$("A: State 3(Terminating)");
        facit.Elt[6-facit.LB[0]]=new TXT$("Main: Before third resume");
        {
            new simtst109$trace(((simtst109)CUR$),new TXT$("Main: Before new A"));
            x=((simtst109$A)new simtst109$A(((simtst109)CUR$)).START$());
            new simtst109$trace(((simtst109)CUR$),new TXT$("Main: Before first resume"));
            resume(x);
            new simtst109$trace(((simtst109)CUR$),new TXT$("Main: Before second resume"));
            resume(x);
            new simtst109$trace(((simtst109)CUR$),new TXT$("Main: Before third resume"));
            if(VALUE$(found_error)) {
            } else
            {
                sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 109"));
                sysout().outimage();
            }
            if(VALUE$(verbose)) {
                {
                    sysout().outtext(new TXT$("--- END SIMULA TEST 109"));
                    sysout().outimage();
                }
            }
        }
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst109(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst109.sim","SimulaProgram simtst109",1,9,10,10,12,11,14,12,16,13,22,12,29,39,31,40,35,41,37,42,42,45,44,46,46,47,48,48,50,49,52,50,54,51,56,54,59,55,61,56,63,57,65,58,67,59,69,60,71,64,74,67,77,68,80,71,82,72,85,73,97,76);
}
