// JavaLine 1 ==> SourceLine 1
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu Feb 21 17:17:15 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr16 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=1, lastLine=3, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    float x=0.0f;
    // Normal Constructor
    public simerr16(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simerr16");
        // Declaration Code
        TRACE_BEGIN_DCL$("simerr16",1);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("simerr16",1);
        // JavaLine 22 ==> SourceLine 2
        (x+(((float)(4))))=((float)(5));
        TRACE_END_STM$("simerr16",2);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new simerr16(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr16.sim","SimulaProgram simerr16",1,1,22,2,33,3);
}
