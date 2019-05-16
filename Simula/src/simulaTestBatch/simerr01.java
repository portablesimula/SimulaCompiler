package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 16:39:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr01 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    final TXT$ CASE$=(TXT$)(new TXT$(" ERROR-TEST 01"));
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    public simerr01(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simerr01");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=8;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(CONC(new TXT$("--- START SIMULA"),CASE$));
                sysout().outtext(new TXT$("--- ILLEGAL GOTO"));
                sysout().outimage();
                sysout().outimage();
            }
        }
        facit.Elt[0-facit.LB[0]]=new TXT$("--- START GOTO SAMPLE");
        facit.Elt[1-facit.LB[0]]=new TXT$("START SIMULATION");
        facit.Elt[2-facit.LB[0]]=new TXT$("Bil 1 is scheduled for 4.0");
        facit.Elt[3-facit.LB[0]]=new TXT$("Bil 1 is initiating");
        facit.Elt[4-facit.LB[0]]=new TXT$("Bil 1 is active 1");
        facit.Elt[5-facit.LB[0]]=new TXT$("Bil 1 is active 2");
        facit.Elt[6-facit.LB[0]]=new TXT$("ExceptionHandler got error: Illegal GOTO EXIT_LABEL");
        DEFEXCEPTION(new PRCQNT$(((simerr01)CUR$),simerr01$ExceptionHandler.class));
        new simerr01$trace(((simerr01)CUR$),new TXT$("--- START GOTO SAMPLE"));
        new simerr01$p(((simerr01)CUR$));
        new simerr01$trace(((simerr01)CUR$),new TXT$("THIS LINE SHOULD NEVER BE EXECUTED"));
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simerr01(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr01.sim","SimulaProgram simerr01",1,9,9,10,11,11,13,12,15,13,21,13,28,73,30,74,33,75,35,76,40,79,42,80,44,81,46,82,48,83,50,84,52,85,54,87,56,89,58,91,60,93,69,96);
}
