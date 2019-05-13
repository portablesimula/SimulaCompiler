package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 22:54:15 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst122 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    int n=0;
    public simtst122(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst122");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=9;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- START SIMULA TEST 122"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- GOTO LABEL IN SUPER CLASS"));
                sysout().outimage();
                sysout().outimage();
            }
        }
        facit.Elt[0-facit.LB[0]]=new TXT$("A.L1");
        facit.Elt[1-facit.LB[0]]=new TXT$("B.L2");
        facit.Elt[2-facit.LB[0]]=new TXT$("A.L1");
        facit.Elt[3-facit.LB[0]]=new TXT$("B.L2");
        facit.Elt[4-facit.LB[0]]=new TXT$("At END OF TEST");
        new simtst122$B(((simtst122)CUR$)).STM$();
        new simtst122$trace(((simtst122)CUR$),new TXT$("At END OF TEST"));
        if(VALUE$(found_error)) {
        } else
        {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 122"));
        }
        if(VALUE$(verbose)) {
            {
                sysout().outimage();
                sysout().outtext(new TXT$("--- END SIMULA TEST 122"));
                sysout().outimage();
            }
        }
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst122(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst122.sim","SimulaProgram simtst122",1,9,10,10,12,11,14,12,16,13,22,12,29,39,31,40,35,41,37,42,42,45,44,46,46,47,48,48,50,49,52,51,54,52,56,54,59,57,63,60,65,61,68,62,70,63,81,66);
}
