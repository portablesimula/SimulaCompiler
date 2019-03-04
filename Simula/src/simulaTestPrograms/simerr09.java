// JavaLine 1 ==> SourceLine 4
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu Feb 21 16:18:54 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr09 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=4, lastLine=9, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int i=0;
    int j=0;
    // JavaLine 12 ==> SourceLine 5
    char c=0;
    // JavaLine 14 ==> SourceLine 6
    final char k=((char)39);
    // Normal Constructor
    public simerr09(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simerr09");
        // Declaration Code
        TRACE_BEGIN_DCL$("simerr09",6);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("simerr09",6);
        // JavaLine 27 ==> SourceLine 7
        c=char$(i);
        TRACE_END_STM$("simerr09",7);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new simerr09(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr09.sim","SimulaProgram simerr09",1,4,12,5,14,6,27,7,38,9);
}
