// JavaLine 1 <== SourceLine 2
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 17:19:55 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr13 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=2, lastLine=23, hasLocalClasses=true, System=true
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 11
    simerr13$Coder forcoder=null;
    // Normal Constructor
    public simerr13(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simerr13");
        // Declaration Code
        TRACE_BEGIN_DCL$("simerr13",18);
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("simerr13",18);
        TRACE_END_STM$("simerr13",18);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new simerr13(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("simerr13.sim","SimulaProgram simerr13",1,2,11,11,33,23);
} // End of SubBlock
