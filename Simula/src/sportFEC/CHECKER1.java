// JavaLine 1 ==> SourceLine 3
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1 extends BUILDER2 {
    // ClassDeclaration: BlockKind=Class, BlockLevel=1, PrefixLevel=8, firstLine=3, lastLine=2638, hasLocalClasses=true, System=false, detachUsed=false
    public int prefixLevel() { return(8); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("CHECKER1",2636);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,8) {
            public void STM$() {
                TRACE_BEGIN_STM$("CHECKER1",2636,inner);
                // JavaLine 22 ==> SourceLine 2638
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("CHECKER1",2638);
                }
                TRACE_END_STM$("CHECKER1",2638);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1 STM$() { return((CHECKER1)CODE$.EXEC$()); }
    public CHECKER1 START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class CHECKER1",1,3,22,2638,33,2638);
}
