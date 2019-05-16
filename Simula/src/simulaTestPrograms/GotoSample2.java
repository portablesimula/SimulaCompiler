// JavaLine 1 <== SourceLine 6
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 11:18:13 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class GotoSample2 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=6, lastLine=54, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    // Normal Constructor
    public GotoSample2(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("GotoSample2");
        // Declaration Code
        TRACE_BEGIN_DCL$("GotoSample2",39);
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("GotoSample2",39);
        // JavaLine 21 <== SourceLine 45
        DEFEXCEPTION(new PRCQNT$(((GotoSample2)CUR$),GotoSample2$ExceptionHandler.class));
        // JavaLine 23 <== SourceLine 47
        sysout().outtext(new TXT$("--- START GOTO SAMPLE"));
        sysout().outimage();
        // JavaLine 26 <== SourceLine 49
        new GotoSample2$p(((GotoSample2)CUR$));
        // JavaLine 28 <== SourceLine 51
        sysout().outtext(new TXT$("THIS LINE SHOULD NEVER BE EXECUTED"));
        sysout().outimage();
        TRACE_END_STM$("GotoSample2",51);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new GotoSample2(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("GotoSample2.sim","SimulaProgram GotoSample2",1,6,21,45,23,47,26,49,28,51,40,54);
} // End of SubBlock
