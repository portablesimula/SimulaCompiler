// JavaLine 1 ==> SourceLine 102
package sportFEC;
// Simula-Beta-0.3 Compiled at Fri Feb 08 19:52:22 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$constsymbol extends COMMON$symbolbox {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=102, lastLine=104, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public COMMON$constsymbol(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("constsymbol",102);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("constsymbol",102,inner);
                // JavaLine 21 ==> SourceLine 104
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("constsymbol",104);
                }
                TRACE_END_STM$("constsymbol",104);
            }
        };
    } // End of Constructor
    // Class Statements
    public COMMON$constsymbol STM$() { return((COMMON$constsymbol)CODE$.EXEC$()); }
    public COMMON$constsymbol START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class constsymbol",1,102,21,104,32,104);
}
