// JavaLine 1 <== SourceLine 3
package simulaTestPrograms;
// Simula-1.0 Compiled at Wed May 22 12:18:52 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simulaid$ extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=3, lastLine=5, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    // Normal Constructor
    public simulaid$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simulaid$");
        // Declaration Code
        TRACE_BEGIN_DCL$("simulaid$",3);
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("simulaid$",3);
        sysout().outtext(simulaid());
        TRACE_END_STM$("simulaid$",3);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new simulaid$(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("simulaid.sim","SimulaProgram simulaid$",1,3,31,5);
} // End of SubBlock
