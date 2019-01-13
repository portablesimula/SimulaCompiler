// JavaLine 1 ==> SourceLine 3
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:49 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER2 extends CHECKER1 {
    // ClassDeclaration: BlockKind=Class, BlockLevel=1, PrefixLevel=9, firstLine=3, lastLine=1666, hasLocalClasses=true, System=false, detachUsed=false
    public int prefixLevel() { return(9); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER2(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("CHECKER2",867);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,9) {
            public void STM$() {
                TRACE_BEGIN_STM$("CHECKER2",867,inner);
                // JavaLine 22 ==> SourceLine 1666
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("CHECKER2",1666);
                }
                TRACE_END_STM$("CHECKER2",1666);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER2 STM$() { return((CHECKER2)CODE$.EXEC$()); }
    public CHECKER2 START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER2.DEF","Class CHECKER2",1,3,22,1666,33,1666);
}
