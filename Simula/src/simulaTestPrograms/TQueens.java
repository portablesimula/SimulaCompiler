// JavaLine 1 ==> SourceLine 6
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Jan 27 17:21:56 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class TQueens extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=6, lastLine=17, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    public ARRAY$<int[]>q=null;
    public ARRAY$<int[]>u=null;
    public ARRAY$<int[]>d=null;
    // Normal Constructor
    public TQueens(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("TQueens");
        // Declaration Code
        TRACE_BEGIN_DCL$("TQueens",13);
        // JavaLine 20 ==> SourceLine 6
        int[] q$LB=new int[1]; int[] q$UB=new int[1];
        q$LB[0]=-17; q$UB[0]=17;
        BOUND_CHECK$(q$LB[0],q$UB[0]);
        q=new ARRAY$<int[]>(new int[q$UB[0]-q$LB[0]+1],q$LB,q$UB);
        int[] u$LB=new int[1]; int[] u$UB=new int[1];
        u$LB[0]=-17; u$UB[0]=17;
        BOUND_CHECK$(u$LB[0],u$UB[0]);
        u=new ARRAY$<int[]>(new int[u$UB[0]-u$LB[0]+1],u$LB,u$UB);
        int[] d$LB=new int[1]; int[] d$UB=new int[1];
        d$LB[0]=-17; d$UB[0]=17;
        BOUND_CHECK$(d$LB[0],d$UB[0]);
        d=new ARRAY$<int[]>(new int[d$UB[0]-d$LB[0]+1],d$LB,d$UB);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("TQueens",6);
        // JavaLine 37 ==> SourceLine 16
        new TQueens$p(((TQueens)CUR$),0,17,q.COPY(),u.COPY(),d.COPY());
        TRACE_END_STM$("TQueens",16);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new TQueens(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("TQueens.sim","SimulaProgram TQueens",1,6,20,6,37,16,48,17);
}
