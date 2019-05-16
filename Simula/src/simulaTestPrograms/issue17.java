// JavaLine 1 <== SourceLine 10
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 17:22:40 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue17 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=10, lastLine=51, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    // Normal Constructor
    public issue17(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("issue17");
        // Declaration Code
        TRACE_BEGIN_DCL$("issue17",37);
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("issue17",37);
        // JavaLine 21 <== SourceLine 44
        sysout().outtext(new TXT$("--- START GOTO SAMPLE"));
        sysout().outimage();
        // JavaLine 24 <== SourceLine 46
        new issue17$p(((issue17)CUR$));
        // JavaLine 26 <== SourceLine 48
        sysout().outtext(new TXT$("THIS LINE SHOULD NEVER BE EXECUTED"));
        sysout().outimage();
        TRACE_END_STM$("issue17",48);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new issue17(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("issue17.sim","SimulaProgram issue17",1,10,21,44,24,46,26,48,38,51);
} // End of SubBlock
