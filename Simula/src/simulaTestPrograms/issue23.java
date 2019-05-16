// JavaLine 1 <== SourceLine 1
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 17:23:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue23 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=1, lastLine=15, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    public ARRAY$<float[]>ra=null;
    // Normal Constructor
    public issue23(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("issue23");
        // Declaration Code
        TRACE_BEGIN_DCL$("issue23",10);
        // JavaLine 18 <== SourceLine 1
        int[] ra$LB=new int[1]; int[] ra$UB=new int[1];
        ra$LB[0]=1; ra$UB[0]=10;
        BOUND_CHECK$(ra$LB[0],ra$UB[0]);
        ra=new ARRAY$<float[]>(new float[ra$UB[0]-ra$LB[0]+1],ra$LB,ra$UB);
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("issue23",1);
        // JavaLine 27 <== SourceLine 12
        ra.Elt[1-ra.LB[0]]=((float)(7));
        // JavaLine 29 <== SourceLine 13
        new issue23$PP(((issue23)CUR$),ra);
        // JavaLine 31 <== SourceLine 14
        new issue23$PQ(((issue23)CUR$),new PRCQNT$(((issue23)CUR$),issue23$theP.class));
        TRACE_END_STM$("issue23",14);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new issue23(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("issue23.sim","SimulaProgram issue23",1,1,18,1,27,12,29,13,31,14,42,15);
} // End of SubBlock
