// JavaLine 1 <== SourceLine 1
package simulaTestPrograms;
// Simula-1.0 Compiled at Wed May 22 10:22:23 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Collatz extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=1, lastLine=31, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int i=0;
    // Normal Constructor
    public Collatz(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("Collatz");
        // Declaration Code
        TRACE_BEGIN_DCL$("Collatz",16);
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("Collatz",16);
        // JavaLine 22 <== SourceLine 29
        new Collatz$SubBlock19(CUR$).STM$();
        TRACE_END_STM$("Collatz",28);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new Collatz(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("Collatz.sim","SimulaProgram Collatz",1,1,22,29,33,31);
} // End of SubBlock
