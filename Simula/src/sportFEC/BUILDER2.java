// JavaLine 1 ==> SourceLine 3
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:07 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class BUILDER2 extends BUILDER1 {
    // ClassDeclaration: BlockKind=Class, BlockLevel=1, PrefixLevel=7, firstLine=3, lastLine=1727, hasLocalClasses=true, System=false, detachUsed=false
    public int prefixLevel() { return(7); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 139
    public BUILDER2$normalattrfile Afile=null;
    // Normal Constructor
    public BUILDER2(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("BUILDER2",1725);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,7) {
            public void STM$() {
                TRACE_BEGIN_STM$("BUILDER2",1725,inner);
                // JavaLine 24 ==> SourceLine 1727
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("BUILDER2",1727);
                }
                TRACE_END_STM$("BUILDER2",1727);
            }
        };
    } // End of Constructor
    // Class Statements
    public BUILDER2 STM$() { return((BUILDER2)CODE$.EXEC$()); }
    public BUILDER2 START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Class BUILDER2",1,3,12,139,24,1727,35,1727);
}
