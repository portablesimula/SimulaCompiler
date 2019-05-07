package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 12:10:22 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst115 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    final boolean verbose=(boolean)(true);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    simtst115$C x=null;
    public simtst115(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst115");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=8;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- START SIMULA TEST 115"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- Simple QPS-Sample 1"));
                sysout().outimage();
                sysout().outimage();
            }
        }
        facit.Elt[0-facit.LB[0]]=new TXT$("In Block - Just Before create first A");
        facit.Elt[1-facit.LB[0]]=new TXT$("In Procedure Q - Just Before first Detach");
        facit.Elt[2-facit.LB[0]]=new TXT$("In Class A - Just Before first Resume(x)");
        facit.Elt[3-facit.LB[0]]=new TXT$("In Procedure Q - Just Before second Detach");
        facit.Elt[4-facit.LB[0]]=new TXT$("In Block - Just Before create second A");
        facit.Elt[5-facit.LB[0]]=new TXT$("In Procedure Q - Just Before first Detach");
        facit.Elt[6-facit.LB[0]]=new TXT$("In Class A - Just Before first Resume(x)");
        facit.Elt[7-facit.LB[0]]=new TXT$("In Procedure Q - Just Before second Detach");
        facit.Elt[8-facit.LB[0]]=new TXT$("In Block - Just Before final END");
        new simtst115$trace(((simtst115)CUR$),new TXT$("In Block - Just Before create first A"));
        new simtst115$A(((simtst115)CUR$)).STM$();
        new simtst115$trace(((simtst115)CUR$),new TXT$("In Block - Just Before create second A"));
        new simtst115$A(((simtst115)CUR$)).STM$();
        new simtst115$trace(((simtst115)CUR$),new TXT$("In Block - Just Before final END"));
        if(VALUE$(found_error)) {
        } else
        {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 115"));
        }
        if(VALUE$(verbose)) {
            {
                sysout().outimage();
                sysout().outtext(new TXT$("--- END SIMULA TEST 115"));
                sysout().outimage();
            }
        }
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst115(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst115.sim","SimulaProgram simtst115",1,9,10,10,12,11,14,12,16,13,22,12,29,53,31,54,35,55,37,56,42,59,44,60,46,61,48,62,50,63,52,64,54,65,56,66,58,67,60,69,62,70,64,71,66,72,68,73,70,77,73,80,77,83,79,84,82,85,84,86,95,89);
}
