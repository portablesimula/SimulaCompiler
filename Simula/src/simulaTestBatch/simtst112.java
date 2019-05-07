package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 05 12:42:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst112 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    simtst112$B x=null;
    public simtst112(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst112");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=8;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- START SIMULA TEST 112"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- Virtual Label - Sample 2"));
                sysout().outimage();
                sysout().outimage();
            }
        }
        facit.Elt[0-facit.LB[0]]=new TXT$("In A before inner");
        facit.Elt[1-facit.LB[0]]=new TXT$("In Procedure 'goto_L'");
        facit.Elt[2-facit.LB[0]]=new TXT$("In B At Label L - OK");
        facit.Elt[3-facit.LB[0]]=new TXT$("In C before inner");
        facit.Elt[4-facit.LB[0]]=new TXT$("In C after inner");
        facit.Elt[5-facit.LB[0]]=new TXT$("In B after inner");
        facit.Elt[6-facit.LB[0]]=new TXT$("In A after inner");
        facit.Elt[7-facit.LB[0]]=new TXT$("In MAIN after new B");
        facit.Elt[8-facit.LB[0]]=new TXT$("In MAIN after new CLASS B");
        x=new simtst112$C(((simtst112)CUR$)).STM$();
        new simtst112$trace(((simtst112)CUR$),new TXT$("In MAIN after new B"));
        new simtst112$trace(((simtst112)CUR$),CONC(new TXT$("In MAIN after new "),x.ident$1));
        if(VALUE$(found_error)) {
        } else
        {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 112"));
        }
        if(VALUE$(verbose)) {
            {
                sysout().outimage();
                sysout().outtext(new TXT$("--- END SIMULA TEST 112"));
                sysout().outimage();
            }
        }
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst112(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst112.sim","SimulaProgram simtst112",1,9,10,10,12,11,14,12,16,13,22,12,29,60,31,61,35,62,37,63,42,66,44,67,46,68,48,69,50,70,52,71,54,72,56,73,58,74,60,76,62,77,64,78,66,80,69,83,73,86,75,87,78,88,80,89,91,92);
}
