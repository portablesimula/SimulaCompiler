// JavaLine 1 <== SourceLine 8
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 17:22:28 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue16 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=8, lastLine=18, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    final int konst;
    // JavaLine 11 <== SourceLine 11
    InFile$ inspect$10$0=null;
    // Normal Constructor
    public issue16(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("issue16");
        // Declaration Code
        TRACE_BEGIN_DCL$("issue16",11);
        konst=((int)((int)Math.round(sqrt(((double)(4))))));
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("issue16",11);
        // JavaLine 25 <== SourceLine 10
        {
            // BEGIN INSPECTION 
            inspect$10$0=new InFile$(((BASICIO$)CTX$),sysout().filename()).STM$();
            if(inspect$10$0!=null) // INSPECT inspect$10$0
            // JavaLine 30 <== SourceLine 17
            new issue16$PBLK12(CUR$).START$();
        }
        TRACE_END_STM$("issue16",15);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new issue16(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("issue16.sim","SimulaProgram issue16",1,8,11,11,25,10,30,17,42,18);
} // End of SubBlock
