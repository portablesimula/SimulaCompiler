package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 10 12:24:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class InspectionSamples$A extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=5, lastLine=5, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    public int i=0;
    // Normal Constructor
    public InspectionSamples$A(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("A",5);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("A",5,inner);
                i=((InspectionSamples)(CUR$.SL$)).aa;
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("A",5);
                }
                TRACE_END_STM$("A",5);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public InspectionSamples$A STM$() { return((InspectionSamples$A)CODE$.EXEC$()); }
    public InspectionSamples$A START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("InspectionSamples.sim","Class A",34,5);
}
