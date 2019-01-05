// JavaLine 1 ==> SourceLine 3
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:45:10 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SCANINP extends SCANNER {
    // ClassDeclaration: BlockKind=Class, BlockLevel=1, PrefixLevel=3, firstLine=3, lastLine=90, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public SCANINP(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("SCANINP",86);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("SCANINP",86,inner);
                // JavaLine 22 ==> SourceLine 90
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("SCANINP",90);
                }
                TRACE_END_STM$("SCANINP",90);
            }
        };
    } // End of Constructor
    // Class Statements
    public SCANINP STM$() { return((SCANINP)CODE$.EXEC$()); }
    public SCANINP START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("SCANINP.DEF","Class SCANINP",1,3,22,90,33,90);
}
