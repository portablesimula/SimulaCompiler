package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 17:16:56 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr04 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    final TXT$ CASE$=(TXT$)(new TXT$(" ERROR-TEST 04"));
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    public simerr04(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simerr04");
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
        facit.Elt[0-facit.LB[0]]=new TXT$("--- START DIV BY ZERO SAMPLE");
        facit.Elt[1-facit.LB[0]]=new TXT$("ExceptionHandler got error: ArithmeticException / by zero");
        DEFEXCEPTION(new PRCQNT$(((simerr04)CUR$),simerr04$ExceptionHandler.class));
        new simerr04$trace(((simerr04)CUR$),new TXT$("--- START DIV BY ZERO SAMPLE"));
        new SeparatProcedure(((simerr04)CUR$),5);
        new simerr04$trace(((simerr04)CUR$),new TXT$("THIS LINE SHOULD NEVER BE EXECUTED"));
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simerr04(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr04.sim","SimulaProgram simerr04",1,9,8,10,10,11,12,12,14,13,16,14,22,14,29,46,31,47,34,48,36,49,41,52,43,53,45,55,47,57,49,59,51,61,60,63);
}
