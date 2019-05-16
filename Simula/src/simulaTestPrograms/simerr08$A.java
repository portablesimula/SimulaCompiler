package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 17:01:15 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simerr08$A extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=4, lastLine=4, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public simerr08$A(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("A",4);
    }
    // Class Statements
    public simerr08$A STM$() {
        TRACE_BEGIN_STM$("A",4);
        // Class A: Code before inner
        // Class A: Code after inner
        TRACE_END_STM$("A",4);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("simerr08.sim","Class A",26,4);
} // End of Class
