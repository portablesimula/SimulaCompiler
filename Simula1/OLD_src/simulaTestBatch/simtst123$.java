package simulaTestBatch;
// Simula-1.0 Compiled at Wed Oct 02 09:47:31 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst123$ extends BASICIO$ {
    public boolean isQPSystemBlock() { return(true); }
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    int n=0;
    public simtst123$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst123$");
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
        new simtst123$$B((CUR$)).STM$();
        new simtst123$$trace((CUR$),new TXT$("At END OF TEST"));
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
        return(this);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst123$(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst123.sim","SimulaProgram simtst123$",1,9,9,10,11,11,13,12,15,13,21,12,28,53,30,54,34,55,36,56,41,59,43,60,45,61,47,62,49,63,51,64,53,65,55,66,57,67,59,68,61,70,63,71,65,73,68,76,72,79,74,80,77,81,79,82,90,85);
}
