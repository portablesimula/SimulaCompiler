// JavaLine 1 <== SourceLine 2
package simulaTestPrograms;
// Simula-2.0 Compiled at Sat Jun 11 10:29:57 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc06$ extends BASICIO$ {
    // SubBlock: Kind=SimulaProgram, BlockLevel=1, firstLine=2, lastLine=15, hasLocalClasses=true, System=true
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    // Normal Constructor
    public adHoc06$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("adHoc06$");
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
        new adHoc06$(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc06.sim","SimulaProgram adHoc06$",1,2,27,15);
} // End of SubBlock
