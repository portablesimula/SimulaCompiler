package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 16:21:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst116 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    simtst116$C x=null;
    public simtst116(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst116");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=8;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- START SIMULA TEST 116"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- Simple QPS-Sample 2"));
                sysout().outimage();
                sysout().outimage();
            }
        }
        facit.Elt[0-facit.LB[0]]=new TXT$("In Block - Just Before call procedure P");
        facit.Elt[1-facit.LB[0]]=new TXT$("In Procedure Q - Just Before first Detach");
        facit.Elt[2-facit.LB[0]]=new TXT$("In Procedure P - Just Before first Resume(x)");
        facit.Elt[3-facit.LB[0]]=new TXT$("In Procedure Q - Just Before second Detach");
        facit.Elt[4-facit.LB[0]]=new TXT$("In Block - Just Before final END");
        new simtst116$trace(((simtst116)CUR$),new TXT$("In Block - Just Before call procedure P"));
        new simtst116$P(((simtst116)CUR$));
        new simtst116$trace(((simtst116)CUR$),new TXT$("In Block - Just Before final END"));
        if(VALUE$(found_error)) {
        } else
        {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 116"));
        }
        if(VALUE$(verbose)) {
            {
                sysout().outimage();
                sysout().outtext(new TXT$("--- END SIMULA TEST 116"));
                sysout().outimage();
            }
        }
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst116(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst116.sim","SimulaProgram simtst116",1,9,10,10,12,11,14,12,16,13,22,12,29,54,31,55,35,56,37,57,42,60,44,61,46,62,48,63,50,64,52,67,54,68,56,70,58,73,61,76,65,79,67,80,70,81,72,82,83,85);
}
