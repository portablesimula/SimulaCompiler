package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 20:22:16 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr06 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    final TXT$ CASE$=(TXT$)(new TXT$(" ERROR-TEST 06"));
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    TXT$ txt=null;
    public simerr06(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simerr06");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=1;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(CONC(new TXT$("--- START SIMULA"),CASE$));
                sysout().outtext(new TXT$("---  ArrayIndexOutOfBounds"));
                sysout().outimage();
                sysout().outimage();
            }
        }
        facit.Elt[0-facit.LB[0]]=new TXT$("--- Testing NumberFormatException");
        facit.Elt[1-facit.LB[0]]=new TXT$("ExceptionHandler got error: ArrayIndexOutOfBounds");
        DEFEXCEPTION(new PRCQNT$(((simerr06)CUR$),simerr06$ExceptionHandler.class));
        new simerr06$trace(((simerr06)CUR$),new TXT$("--- Testing NumberFormatException"));
        txt=facit.Elt[13-facit.LB[0]];
        new simerr06$trace(((simerr06)CUR$),new TXT$("THIS LINE SHOULD NEVER BE EXECUTED"));
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simerr06(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr06.sim","SimulaProgram simerr06",1,11,9,12,11,13,13,14,15,15,17,17,23,15,30,49,32,50,35,51,37,52,42,55,44,56,46,58,48,60,50,62,52,64,61,66);
}
