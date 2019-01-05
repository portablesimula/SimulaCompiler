// JavaLine 1 ==> SourceLine 806
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 15:03:20 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$brctab2 extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=806, lastLine=810, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 808
    public ARRAY$<COMMON$brecord[]>val=null;
    // Normal Constructor
    public COMMON$brctab2(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("brctab2",808);
        int[] val$LB=new int[1]; int[] val$UB=new int[1];
        val$LB[0]=0; val$UB[0]=255;
        BOUND_CHECK$(val$LB[0],val$UB[0]);
        val=new ARRAY$<COMMON$brecord[]>(new COMMON$brecord[val$UB[0]-val$LB[0]+1],val$LB,val$UB);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("brctab2",808,inner);
                // JavaLine 28 ==> SourceLine 810
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("brctab2",810);
                }
                TRACE_END_STM$("brctab2",810);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public COMMON$brctab2 STM$() { return((COMMON$brctab2)CODE$.EXEC$()); }
    public COMMON$brctab2 START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class brctab2",1,806,11,808,28,810,40,810);
}
