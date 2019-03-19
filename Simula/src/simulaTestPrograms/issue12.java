// JavaLine 1 ==> SourceLine 8
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri Mar 15 09:50:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue12 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=8, lastLine=24, hasLocalClasses=true, System=true
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 20
    issue12$A rA=null;
    // Normal Constructor
    public issue12(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("issue12");
        // Declaration Code
        TRACE_BEGIN_DCL$("issue12",20);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("issue12",20);
        // JavaLine 24 ==> SourceLine 21
        rA=new issue12$A(((issue12)CUR$)).STM$();
        // JavaLine 26 ==> SourceLine 22
        sysout().outint(rA.rB.i,9);
        TRACE_END_STM$("issue12",22);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new issue12(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("issue12.sim","SimulaProgram issue12",1,8,11,20,24,21,26,22,37,24);
}
