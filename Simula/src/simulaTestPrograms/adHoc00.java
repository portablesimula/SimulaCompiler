// JavaLine 1 ==> SourceLine 4
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Jan 12 10:51:34 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc00 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=4, lastLine=4, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    // Normal Constructor
    public adHoc00(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("adHoc00");
        // Declaration Code
        TRACE_BEGIN_DCL$("adHoc00",4);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("adHoc00",4);
        TRACE_END_STM$("adHoc00",4);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new adHoc00(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc00.sim","SimulaProgram adHoc00",1,4,29,4);
}
