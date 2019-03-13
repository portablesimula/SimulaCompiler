// JavaLine 1 ==> SourceLine 2
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Mar 09 13:41:37 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc66 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=2, lastLine=27, hasLocalClasses=true, System=true
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    adHoc66$C A=null;
    adHoc66$C B=null;
    // Normal Constructor
    public adHoc66(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("adHoc66");
        // Declaration Code
        TRACE_BEGIN_DCL$("adHoc66",9);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("adHoc66",9);
        // JavaLine 24 ==> SourceLine 18
        A=new adHoc66$C(((adHoc66)CUR$),new TXT$("A")).START();
        // JavaLine 26 ==> SourceLine 19
        B=new adHoc66$C(((adHoc66)CUR$),new TXT$("B")).START();
        // JavaLine 28 ==> SourceLine 20
        A.neste=B;
        // JavaLine 30 ==> SourceLine 21
        B.neste=A;
        // JavaLine 32 ==> SourceLine 23
        resume(A);
        // JavaLine 34 ==> SourceLine 24
        sysout().outtext(new TXT$("FINAL END"));
        sysout().outimage();
        TRACE_END_STM$("adHoc66",24);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new adHoc66(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc66.sim","SimulaProgram adHoc66",1,2,24,18,26,19,28,20,30,21,32,23,34,24,46,27);
}
