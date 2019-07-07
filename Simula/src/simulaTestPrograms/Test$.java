// JavaLine 1 <== SourceLine 3
package simulaTestPrograms;
// Simula-1.0 Compiled at Mon Jul 01 09:59:50 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Test$ extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=3, lastLine=53, hasLocalClasses=true, System=true
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 39
    int i=0;
    // JavaLine 12 <== SourceLine 40
    Test$$A x=null;
    // Normal Constructor
    public Test$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("Test$");
        // Declaration Code
        TRACE_BEGIN_DCL$("Test$",40);
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("Test$",40);
        // JavaLine 25 <== SourceLine 41
        i=new Test$$P(((Test$)(CUR$)),4,3.14f).RESULT$;
        // JavaLine 27 <== SourceLine 42
        new Test$$callFP(((Test$)(CUR$)),new PRCQNT$(((Test$)(CUR$)),Test$$P.class));
        // JavaLine 29 <== SourceLine 43
        x=new Test$$B(((Test$)(CUR$)),1,((float)(2)),((double)(3))).STM$();
        // JavaLine 31 <== SourceLine 51
        new Test$$SubBlock48((CUR$)).STM$();
        TRACE_END_STM$("Test$",50);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new Test$(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("Test.sim","SimulaProgram Test$",1,3,10,39,12,40,25,41,27,42,29,43,31,51,42,53);
} // End of SubBlock
