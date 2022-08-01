package simulaTestBatch;
// Simula-2.0 Compiled at Fri Sep 03 09:27:42 CEST 2021
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr01$ extends BASICIO$ {
    final TXT$ CASE$=(TXT$)(new TXT$(" ERROR-TEST 01"));
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    public simerr01$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simerr01$");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=8;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(CONC(new TXT$("--- START SIMULA"),CASE$));
                ;
                sysout().outtext(new TXT$("--- ILLEGAL GOTO"));
                ;
                sysout().outimage();
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        facit.Elt[0-facit.LB[0]]=new TXT$("--- START GOTO SAMPLE");
        ;
        facit.Elt[1-facit.LB[0]]=new TXT$("START SIMULATION");
        ;
        facit.Elt[2-facit.LB[0]]=new TXT$("Bil 1 is scheduled for 4.0");
        ;
        facit.Elt[3-facit.LB[0]]=new TXT$("Bil 1 is initiating");
        ;
        facit.Elt[4-facit.LB[0]]=new TXT$("Bil 1 is active 1");
        ;
        facit.Elt[5-facit.LB[0]]=new TXT$("Bil 1 is active 2");
        ;
        facit.Elt[6-facit.LB[0]]=new TXT$("ExceptionHandler got error: Illegal GOTO EXIT_LABEL");
        ;
        ENVIRONMENT$.DEFEXCEPTION(new PRCQNT$(((simerr01$)(CUR$)),simerr01$$ExceptionHandler.class));
        ;
        new simerr01$$trace((CUR$),new TXT$("--- START GOTO SAMPLE"));
        ;
        new simerr01$$p((CUR$));
        ;
        new simerr01$$trace((CUR$),new TXT$("THIS LINE SHOULD NEVER BE EXECUTED"));
        ;
        EBLK();
        return(this);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simerr01$(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr01.sim","SimulaProgram simerr01$",1,9,8,10,10,11,12,12,14,13,20,13,27,73,29,74,33,75,36,76,44,79,47,80,50,81,53,82,56,83,59,84,62,85,65,87,68,89,71,91,74,93,84,96);
}
