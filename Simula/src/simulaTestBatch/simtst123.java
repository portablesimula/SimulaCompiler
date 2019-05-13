package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 13 00:24:06 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst123 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    int n=0;
    public simtst123(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst123");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=9;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- START SIMULA TEST 123"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- GOTO VIRTUAL LABEL"));
                sysout().outimage();
                sysout().outimage();
            }
        }
        facit.Elt[0-facit.LB[0]]=new TXT$("A.L1");
        facit.Elt[1-facit.LB[0]]=new TXT$("A.L3");
        facit.Elt[2-facit.LB[0]]=new TXT$("A.L6");
        facit.Elt[3-facit.LB[0]]=new TXT$("BEGIN B");
        facit.Elt[4-facit.LB[0]]=new TXT$("B.L1");
        facit.Elt[5-facit.LB[0]]=new TXT$("JUST BEFORE GOTO L1 - B.L1");
        facit.Elt[6-facit.LB[0]]=new TXT$("B.L1");
        facit.Elt[7-facit.LB[0]]=new TXT$("JUST BEFORE GOTO L1 - B.L1");
        facit.Elt[8-facit.LB[0]]=new TXT$("B.L1");
        facit.Elt[9-facit.LB[0]]=new TXT$("At END OF TEST");
        new simtst123$B(((simtst123)CUR$)).STM$();
        new simtst123$trace(((simtst123)CUR$),new TXT$("At END OF TEST"));
        if(VALUE$(found_error)) {
        } else
        {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 123"));
        }
        if(VALUE$(verbose)) {
            {
                sysout().outimage();
                sysout().outtext(new TXT$("--- END SIMULA TEST 123"));
                sysout().outimage();
            }
        }
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst123(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst123.sim","SimulaProgram simtst123",1,14,10,15,12,16,14,17,16,18,22,17,29,58,31,59,35,60,37,61,42,64,44,65,46,66,48,67,50,68,52,69,54,70,56,71,58,72,60,73,62,74,64,75,66,77,69,80,73,83,75,84,78,85,80,86,91,89);
}
