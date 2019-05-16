package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 17:11:35 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr03 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    final TXT$ CASE$=(TXT$)(new TXT$(" ERROR-TEST 01"));
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    public simerr03(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simerr03");
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
        DEFEXCEPTION(new PRCQNT$(((simerr03)CUR$),simerr03$ExceptionHandler.class));
        new simerr03$trace(((simerr03)CUR$),new TXT$("--- START DIV BY ZERO SAMPLE"));
        new simerr03$PBLK62(CUR$,5).STM$();
        new simerr03$trace(((simerr03)CUR$),new TXT$("THIS LINE SHOULD NEVER BE EXECUTED"));
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simerr03(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr03.sim","SimulaProgram simerr03",1,11,8,12,10,13,12,14,14,15,16,16,22,16,29,48,31,49,34,50,36,51,41,54,43,55,45,57,47,59,49,64,51,66,60,68);
}
