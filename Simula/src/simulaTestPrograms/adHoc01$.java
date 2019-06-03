// JavaLine 1 <== SourceLine 4
package simulaTestPrograms;
// Simula-1.0 Compiled at Tue May 28 14:01:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc01$ extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=4, lastLine=15, hasLocalClasses=true, System=true
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    // Normal Constructor
    public adHoc01$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("adHoc01$");
        // Declaration Code
        TRACE_BEGIN_DCL$("adHoc01$",11);
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("adHoc01$",11);
        // JavaLine 22 <== SourceLine 13
        new adHoc01$$Customer$into(new adHoc01$$Customer(((adHoc01$)CUR$)).STM$(),8);
        TRACE_END_STM$("adHoc01$",13);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new adHoc01$(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc01.sim","SimulaProgram adHoc01$",1,4,22,13,33,15);
} // End of SubBlock
