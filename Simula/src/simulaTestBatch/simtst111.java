package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat May 04 14:52:24 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst111 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    simtst111$B x=null;
    public simtst111(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst111");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=5;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- START SIMULA TEST 111"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- Virtual Label"));
                sysout().outimage();
                sysout().outimage();
            }
        }
        facit.Elt[0-facit.LB[0]]=new TXT$("In A before inner");
        facit.Elt[1-facit.LB[0]]=new TXT$("At Label L - OK");
        facit.Elt[2-facit.LB[0]]=new TXT$("In B after inner");
        facit.Elt[3-facit.LB[0]]=new TXT$("In A after inner");
        facit.Elt[4-facit.LB[0]]=new TXT$("In MAIN after new B");
        facit.Elt[5-facit.LB[0]]=new TXT$("In MAIN after new CLASS B");
        x=new simtst111$B(((simtst111)CUR$)).STM$();
        new simtst111$trace(((simtst111)CUR$),new TXT$("In MAIN after new B"));
        new simtst111$trace(((simtst111)CUR$),CONC(new TXT$("In MAIN after new "),x.ident$1));
        if(VALUE$(found_error)) {
        } else
        {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 111"));
        }
        if(VALUE$(verbose)) {
            {
                sysout().outimage();
                sysout().outtext(new TXT$("--- END SIMULA TEST 111"));
                sysout().outimage();
            }
        }
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst111(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst111.sim","SimulaProgram simtst111",1,9,10,10,12,11,14,12,16,13,22,12,29,47,31,48,35,49,37,50,42,53,44,54,46,55,48,56,50,57,52,58,54,60,56,61,58,62,60,64,63,67,67,70,69,71,72,72,74,73,85,76);
}
