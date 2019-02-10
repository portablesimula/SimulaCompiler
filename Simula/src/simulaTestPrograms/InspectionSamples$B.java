// JavaLine 1 ==> SourceLine 6
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 10 12:24:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class InspectionSamples$B extends InspectionSamples$A {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=6, lastLine=6, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    // Declare locals as attributes
    public int m=0;
    // Normal Constructor
    public InspectionSamples$B(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("B",6);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("B",6,inner);
                m=i;
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("B",6);
                }
                TRACE_END_STM$("B",6);
            }
        };
    } // End of Constructor
    // Class Statements
    public InspectionSamples$B STM$() { return((InspectionSamples$B)CODE$.EXEC$()); }
    public InspectionSamples$B START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("InspectionSamples.sim","Class B",1,6,33,6);
}
