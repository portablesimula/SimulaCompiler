// JavaLine 1 ==> SourceLine 2
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:19:39 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc00 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=2, lastLine=3, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    final double L=29.5305883d;
    // Normal Constructor
    public adHoc00(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("adHoc00");
        // Declaration Code
        TRACE_BEGIN_DCL$("adHoc00",2);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("adHoc00",2);
        TRACE_END_STM$("adHoc00",2);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new adHoc00(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc00.sim","SimulaProgram adHoc00",1,2,31,3);
}
