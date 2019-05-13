// JavaLine 1 <== SourceLine 3
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 12 09:56:05 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc00 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=3, lastLine=10, hasLocalClasses=true, System=true
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    adHoc00$A x=null;
    // Normal Constructor
    public adHoc00(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("adHoc00");
        // Declaration Code
        TRACE_BEGIN_DCL$("adHoc00",7);
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("adHoc00",7);
        x=((adHoc00$A)new adHoc00$A(((adHoc00)CUR$)).START$());
        // JavaLine 24 <== SourceLine 8
        x.detach();
        TRACE_END_STM$("adHoc00",8);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new adHoc00(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc00.sim","SimulaProgram adHoc00",1,3,24,8,35,10);
} // End of SubBlock
