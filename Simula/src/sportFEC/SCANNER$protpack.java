// JavaLine 1 ==> SourceLine 1595
package sportFEC;
// Simula-Beta-0.3 Compiled at Fri Feb 08 20:41:33 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SCANNER$protpack extends COMMON$idpack {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=1595, lastLine=1597, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public SCANNER$protpack(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("protpack",1595);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("protpack",1595,inner);
                // JavaLine 21 ==> SourceLine 1597
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("protpack",1597);
                }
                TRACE_END_STM$("protpack",1597);
            }
        };
    } // End of Constructor
    // Class Statements
    public SCANNER$protpack STM$() { return((SCANNER$protpack)CODE$.EXEC$()); }
    public SCANNER$protpack START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Class protpack",1,1595,21,1597,32,1597);
}
