// JavaLine 1 <== SourceLine 4
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 16:31:57 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr07 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=4, lastLine=16, hasLocalClasses=true, System=true
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    simerr07$A x=null;
    // JavaLine 12 <== SourceLine 5
    float r=0.0f;
    // JavaLine 14 <== SourceLine 12
    simerr07$A inspect$12$0=null;
    // Normal Constructor
    public simerr07(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simerr07");
        // Declaration Code
        TRACE_BEGIN_DCL$("simerr07",12);
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("simerr07",12);
        {
            // BEGIN INSPECTION 
            inspect$12$0=x;
            if(inspect$12$0!=null) // INSPECT inspect$12$0
            r=new simerr07$A$F(inspect$12$0,r).RESULT$;
        }
        // JavaLine 33 <== SourceLine 14
        r=new simerr07$A$F(x,r).RESULT$;
        TRACE_END_STM$("simerr07",14);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new simerr07(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("simerr07.sim","SimulaProgram simerr07",1,4,12,5,14,12,33,14,44,16);
} // End of SubBlock
