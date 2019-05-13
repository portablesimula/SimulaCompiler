package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 13 10:30:19 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst126 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    int n=0;
    public simtst126(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst126");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=13;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- START SIMULA TEST 126"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- GOTO VIRTUAL LABEL"));
                sysout().outimage();
                sysout().outimage();
            }
        }
        facit.Elt[0-facit.LB[0]]=new TXT$("BEGIN PROGRAM");
        facit.Elt[1-facit.LB[0]]=new TXT$("A.L1");
        facit.Elt[2-facit.LB[0]]=new TXT$("A.L3");
        facit.Elt[3-facit.LB[0]]=new TXT$("A.L6");
        facit.Elt[4-facit.LB[0]]=new TXT$("BEGIN B");
        facit.Elt[5-facit.LB[0]]=new TXT$("B.L1");
        facit.Elt[6-facit.LB[0]]=new TXT$("JUST BEFORE GOTO S(1) - B.L1");
        facit.Elt[7-facit.LB[0]]=new TXT$("B.L1");
        facit.Elt[8-facit.LB[0]]=new TXT$("JUST BEFORE GOTO S(1) - B.L1");
        facit.Elt[9-facit.LB[0]]=new TXT$("B.L1");
        facit.Elt[10-facit.LB[0]]=new TXT$("END PROGRAM");
        new simtst126$trace(((simtst126)CUR$),new TXT$("BEGIN PROGRAM"));
        new simtst126$B(((simtst126)CUR$)).STM$();
        new simtst126$trace(((simtst126)CUR$),new TXT$("END PROGRAM"));
        if(VALUE$(found_error)) {
        } else
        {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 126"));
        }
        if(VALUE$(verbose)) {
            {
                sysout().outimage();
                sysout().outtext(new TXT$("--- END SIMULA TEST 126"));
                sysout().outimage();
            }
        }
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst126(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst126.sim","SimulaProgram simtst126",1,14,10,15,12,16,14,17,16,18,22,17,29,58,31,59,35,60,37,61,42,64,44,65,46,66,48,67,50,68,52,69,54,70,56,71,58,72,60,73,62,74,64,76,66,78,68,80,70,83,73,86,77,89,79,90,82,91,84,92,95,96);
}
