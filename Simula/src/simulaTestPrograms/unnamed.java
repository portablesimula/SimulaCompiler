// JavaLine 1 ==> SourceLine 2
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu Jan 24 16:47:14 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class unnamed extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=2, lastLine=6, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int i=0;
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
        // JavaLine 22 ==> SourceLine 3
        sysout().outtext(new TXT$("abracadab"));
        TRACE_END_STM$("unnamed",3);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new unnamed(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("unnamed.sim","SimulaProgram unnamed",1,2,22,3,33,6);
}
