// JavaLine 1 ==> SourceLine 13
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Jan 19 12:51:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class DetachSamples$MyLink extends Link$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=2, firstLine=13, lastLine=16, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(2); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public DetachSamples$MyLink(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("MyLink",13);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("MyLink",13,inner);
                // JavaLine 22 ==> SourceLine 15
                detach();
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("MyLink",15);
                }
                TRACE_END_STM$("MyLink",15);
            }
        };
    } // End of Constructor
    // Class Statements
    public DetachSamples$MyLink STM$() { return((DetachSamples$MyLink)CODE$.EXEC$()); }
    public DetachSamples$MyLink START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("DetachSamples.sim","Class MyLink",1,13,22,15,34,16);
}
