// JavaLine 1 ==> SourceLine 86
package sportFEC;
// Simula-Beta-0.3 Compiled at Fri Feb 08 19:52:22 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$symbolgroup extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=86, lastLine=92, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 88
    public ARRAY$<COMMON$symbolbox[]>val=null;
    // Normal Constructor
    public COMMON$symbolgroup(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("symbolgroup",88);
        int[] val$LB=new int[1]; int[] val$UB=new int[1];
        val$LB[0]=0; val$UB[0]=255;
        BOUND_CHECK$(val$LB[0],val$UB[0]);
        val=new ARRAY$<COMMON$symbolbox[]>(new COMMON$symbolbox[val$UB[0]-val$LB[0]+1],val$LB,val$UB);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("symbolgroup",88,inner);
                // JavaLine 28 ==> SourceLine 92
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("symbolgroup",92);
                }
                TRACE_END_STM$("symbolgroup",92);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public COMMON$symbolgroup STM$() { return((COMMON$symbolgroup)CODE$.EXEC$()); }
    public COMMON$symbolgroup START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class symbolgroup",1,86,11,88,28,92,40,92);
}
