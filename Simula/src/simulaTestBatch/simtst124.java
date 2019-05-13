package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 13 09:52:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst124 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    int n=0;
    public simtst124(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst124");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=4;
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
        facit.Elt[0-facit.LB[0]]=new TXT$("BEGIN PROGRAM");
        facit.Elt[1-facit.LB[0]]=new TXT$("A.L1");
        facit.Elt[2-facit.LB[0]]=new TXT$("JUST BEFORE GOTO L1 - B.L1");
        facit.Elt[3-facit.LB[0]]=new TXT$("B.L1");
        facit.Elt[4-facit.LB[0]]=new TXT$("END PROGRAM");
        new simtst124$trace(((simtst124)CUR$),new TXT$("BEGIN PROGRAM"));
        new simtst124$B(((simtst124)CUR$)).STM$();
        new simtst124$trace(((simtst124)CUR$),new TXT$("END PROGRAM"));
        if(VALUE$(found_error)) {
        } else
        {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 124"));
        }
        if(VALUE$(verbose)) {
            {
                sysout().outimage();
                sysout().outtext(new TXT$("--- END SIMULA TEST 124"));
                sysout().outimage();
            }
        }
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst124(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst124.sim","SimulaProgram simtst124",1,14,10,15,12,16,14,17,16,18,22,17,29,52,31,53,35,54,37,55,42,58,44,59,46,60,48,61,50,62,52,64,54,65,56,66,58,68,61,71,65,74,67,75,70,76,72,77,83,81);
}
