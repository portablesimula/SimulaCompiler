// JavaLine 1 <== SourceLine 5
package simulaTestPrograms;
// Simula-1.0 Compiled at Thu Jun 06 12:16:16 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class issue32$Customer extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=3, firstLine=5, lastLine=14, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public issue32$Customer(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("Customer",11);
    }
    // Class Statements
    public issue32$Customer STM$() {
        TRACE_BEGIN_STM$("Customer",11);
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // Class Process: Code before inner
        // JavaLine 25 <== SourceLine 1
        detach();
        // JavaLine 27 <== SourceLine 14
        // Class Customer: Code before inner
        // Class Customer: Code after inner
        // Class Process: Code after inner
        // JavaLine 31 <== SourceLine 1
        terminate();
        // JavaLine 33 <== SourceLine 14
        TRACE_END_STM$("Customer",14);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("issue32.sim","Class Customer",1,5,25,1,27,14,31,1,33,14,37,14);
} // End of Class
