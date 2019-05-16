package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 17:00:11 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr02 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    final TXT$ CASE$=(TXT$)(new TXT$(" ERROR-TEST 02"));
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    simerr02$A x=null;
    float r=0.0f;
    simerr02$A inspect$68$0=null;
    public simerr02(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simerr02");
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
        facit.Elt[0-facit.LB[0]]=new TXT$("--- Testing NONE-CHECK");
        facit.Elt[1-facit.LB[0]]=new TXT$("ExceptionHandler got error: RuntimeException NONE-CHECK FAILED");
        DEFEXCEPTION(new PRCQNT$(((simerr02)CUR$),simerr02$ExceptionHandler.class));
        new simerr02$trace(((simerr02)CUR$),new TXT$("--- Testing NONE-CHECK"));
        {
            inspect$68$0=x;
            if(inspect$68$0!=null)
            r=new simerr02$A$F(inspect$68$0,r).RESULT$;
        }
        r=new simerr02$A$F(x,r).RESULT$;
        new simerr02$trace(((simerr02)CUR$),new TXT$("THIS LINE SHOULD NEVER BE EXECUTED"));
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simerr02(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr02.sim","SimulaProgram simerr02",1,11,10,12,12,13,14,14,16,15,18,17,20,18,22,68,28,15,35,55,37,56,40,57,42,58,47,61,49,62,51,64,53,66,55,68,61,70,63,72,72,74);
}
