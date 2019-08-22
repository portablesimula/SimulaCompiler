// JavaLine 1 <== SourceLine 4
package simulaTestPrograms;
// Simula-1.0 Compiled at Fri Aug 16 09:45:27 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ProcedureDeclaration$ extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=4, lastLine=12, hasLocalClasses=false, System=false
    // Declare locals as attributes
    // Normal Constructor
    public ProcedureDeclaration$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("ProcedureDeclaration$");
        // Declaration Code
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        EBLK();
        return(this);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new ProcedureDeclaration$(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("ProcedureDeclaration.sim","SimulaProgram ProcedureDeclaration$",1,4,26,12);
} // End of SubBlock
