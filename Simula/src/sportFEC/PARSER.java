// JavaLine 1 ==> SourceLine 3
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:24 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class PARSER extends SCANINP {
    // ClassDeclaration: BlockKind=Class, BlockLevel=1, PrefixLevel=4, firstLine=3, lastLine=2700, hasLocalClasses=true, System=false, detachUsed=true
    public int prefixLevel() { return(4); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("PARSER",2239);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,4) {
            public void STM$() {
                TRACE_BEGIN_STM$("PARSER",2239,inner);
                // JavaLine 22 ==> SourceLine 2700
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("PARSER",2700);
                }
                TRACE_END_STM$("PARSER",2700);
            }
        };
    } // End of Constructor
    // Class Statements
    public PARSER STM$() { return((PARSER)CODE$.EXEC$()); }
    public PARSER START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Class PARSER",1,3,22,2700,33,2700);
}
