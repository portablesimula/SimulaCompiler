// JavaLine 1 ==> SourceLine 29
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 10 12:24:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InspectionSamples$SubBlock29 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=2, firstLine=29, lastLine=31, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int w=0;
    // Normal Constructor
    public InspectionSamples$SubBlock29(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock29",29);
    } // End of Constructor
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock29",29);
        // JavaLine 21 ==> SourceLine 30
        w=(w+(1));
        TRACE_END_STM$("SubBlock29",30);
        EBLK();
        return(null);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("InspectionSamples.sim","SubBlock SubBlock29",1,29,21,30,26,31);
}
