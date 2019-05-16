// JavaLine 1 <== SourceLine 7
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 16:31:57 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simerr07$A extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=7, lastLine=10, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public simerr07$A(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("A",9);
    }
    // Class Statements
    public simerr07$A STM$() {
        TRACE_BEGIN_STM$("A",9);
        // JavaLine 22 <== SourceLine 10
        // Class A: Code before inner
        // Class A: Code after inner
        TRACE_END_STM$("A",10);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("simerr07.sim","Class A",1,7,22,10,28,10);
} // End of Class
