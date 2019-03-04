// JavaLine 1 ==> SourceLine 2
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Mar 04 18:35:22 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class unnamed extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=2, lastLine=3, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    // Normal Constructor
    public unnamed(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("unnamed");
        // Declaration Code
        TRACE_BEGIN_DCL$("unnamed",2);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("unnamed",2);
        sysout().outtext(new TXT$("Abra ca dab"));
        TRACE_END_STM$("unnamed",2);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new unnamed(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("unnamed.sim","SimulaProgram unnamed",1,2,31,3);
}
