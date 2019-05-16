// JavaLine 1 <== SourceLine 4
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 17:01:15 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr08 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=4, lastLine=11, hasLocalClasses=true, System=true
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 5
    simerr08$A x=null;
    // JavaLine 13 <== SourceLine 6
    final char k=(char)(((char)39));
    // JavaLine 15 <== SourceLine 7
    simerr08$A inspect$7$0=null;
    // Normal Constructor
    public simerr08(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simerr08");
        // Declaration Code
        TRACE_BEGIN_DCL$("simerr08",7);
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("simerr08",7);
        {
            // BEGIN INSPECTION 
            inspect$7$0=new simerr08$A(((simerr08)CUR$)).STM$();
            if(inspect$7$0!=null) // INSPECT inspect$7$0
            // JavaLine 32 <== SourceLine 9
            {
                TRACE_BEGIN_STM$("CompoundStatement9",9);
                x=((simerr08$A)inspect$7$0);
                TRACE_END_STM$("CompoundStatement9",9);
            }
        }
        TRACE_END_STM$("simerr08",9);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new simerr08(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("simerr08.sim","SimulaProgram simerr08",1,4,11,5,13,6,15,7,32,9,48,11);
} // End of SubBlock
