// JavaLine 1 <== SourceLine 2
package simulaTestPrograms;
// Simula-1.0 Compiled at Fri Apr 10 13:32:11 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue38$ extends BASICIO$ {
    // SubBlock: Kind=SimulaProgram, BlockLevel=1, firstLine=2, lastLine=39, hasLocalClasses=true, System=true
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    issue38$$Meaning curmeaning=null;
    // JavaLine 11 <== SourceLine 3
    issue38$$macro_scan msc=null;
    // Normal Constructor
    public issue38$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("issue38$");
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
        new issue38$(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("issue38.sim","SimulaProgram issue38$",1,2,11,3,30,39);
} // End of SubBlock
