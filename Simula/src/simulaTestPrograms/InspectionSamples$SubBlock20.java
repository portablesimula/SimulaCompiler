// JavaLine 1 ==> SourceLine 20
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 10 12:24:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InspectionSamples$SubBlock20 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=2, firstLine=20, lastLine=23, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int k=0;
    // Normal Constructor
    public InspectionSamples$SubBlock20(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock20",20);
    } // End of Constructor
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock20",20);
        // JavaLine 21 ==> SourceLine 21
        k=(((InspectionSamples$B)(((InspectionSamples)(CUR$.SL$)).inspect$17$1)).m+(4));
        TRACE_END_STM$("SubBlock20",21);
        EBLK();
        return(null);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("InspectionSamples.sim","SubBlock SubBlock20",1,20,21,21,26,23);
}
