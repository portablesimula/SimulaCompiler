// JavaLine 1 ==> SourceLine 25
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 10 12:24:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InspectionSamples$SubBlock25 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=2, firstLine=25, lastLine=28, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int k=0;
    // Normal Constructor
    public InspectionSamples$SubBlock25(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock25",25);
    } // End of Constructor
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock25",25);
        // JavaLine 21 ==> SourceLine 26
        k=(((InspectionSamples)(CUR$.SL$)).inspect$17$1.i+(16));
        TRACE_END_STM$("SubBlock25",26);
        EBLK();
        return(null);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("InspectionSamples.sim","SubBlock SubBlock25",1,25,21,26,26,28);
}
