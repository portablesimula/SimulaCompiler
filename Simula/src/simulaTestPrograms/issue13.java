// JavaLine 1 ==> SourceLine 8
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri Mar 15 09:22:39 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue13 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=8, lastLine=38, hasLocalClasses=true, System=true
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    int global=0;
    // JavaLine 12 ==> SourceLine 32
    issue13$A rAx=null;
    // Normal Constructor
    public issue13(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("issue13");
        // Declaration Code
        TRACE_BEGIN_DCL$("issue13",32);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("issue13",32);
        // JavaLine 25 ==> SourceLine 33
        rAx=new issue13$A(((issue13)CUR$)).STM$();
        // JavaLine 27 ==> SourceLine 34
        new issue13$A$P(rAx);
        // JavaLine 29 ==> SourceLine 36
        sysout().outtext(new TXT$("Kom helt til slutten!"));
        sysout().outimage();
        TRACE_END_STM$("issue13",36);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new issue13(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("issue13.sim","SimulaProgram issue13",1,8,12,32,25,33,27,34,29,36,41,38);
}
