// JavaLine 1 ==> SourceLine 3
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Mar 18 11:15:58 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc106 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=3, lastLine=9, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    // JavaLine 10 ==> SourceLine 4
    InFile$ inspect$3$0=null;
    // Normal Constructor
    public adHoc106(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("adHoc106");
        // Declaration Code
        TRACE_BEGIN_DCL$("adHoc106",4);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("adHoc106",4);
        // JavaLine 23 ==> SourceLine 3
        {
            // BEGIN INSPECTION 
            inspect$3$0=new InFile$(((BASICIO$)CTX$),sysout().filename()).STM$();
            if(inspect$3$0!=null) //INSPECT inspect$3$0
            // JavaLine 28 ==> SourceLine 8
            new adHoc106$PBLK6(CUR$).START();
        }
        TRACE_END_STM$("adHoc106",6);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new adHoc106(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc106.sim","SimulaProgram adHoc106",1,3,10,4,23,3,28,8,40,9);
}
