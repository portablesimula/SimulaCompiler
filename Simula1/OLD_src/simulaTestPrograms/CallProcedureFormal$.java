// JavaLine 1 <== SourceLine 3
package simulaTestPrograms;
// Simula-1.0 Compiled at Thu Aug 15 21:46:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CallProcedureFormal$ extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=3, lastLine=20, hasLocalClasses=false, System=false
    // Declare locals as attributes
    // Normal Constructor
    public CallProcedureFormal$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("CallProcedureFormal$");
        // Declaration Code
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        // JavaLine 18 <== SourceLine 18
        new CallProcedureFormal$$callFP(((CallProcedureFormal$)(CUR$)),new PRCQNT$(((CallProcedureFormal$)(CUR$)),CallProcedureFormal$$P.class));
        EBLK();
        return(this);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new CallProcedureFormal$(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("CallProcedureFormal.sim","SimulaProgram CallProcedureFormal$",1,3,18,18,28,20);
} // End of SubBlock
