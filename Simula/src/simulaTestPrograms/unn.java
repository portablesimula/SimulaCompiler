// JavaLine 1 ==> SourceLine 1
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Jan 14 14:24:52 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class unn extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=1, lastLine=3, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    TXT$ t=null;
    // Normal Constructor
    public unn(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("unn");
        // Declaration Code
        TRACE_BEGIN_DCL$("unn",1);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("unn",1);
        // JavaLine 22 ==> SourceLine 2
        sysout().outtext(t);
        TRACE_END_STM$("unn",2);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new unn(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("unnamed","SimulaProgram unn",1,1,22,2,32,3);
}
