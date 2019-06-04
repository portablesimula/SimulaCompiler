package simulaTestPrograms;
// Simula-1.0 Compiled at Tue Jun 04 09:37:28 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class issue32$Customer extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=3, firstLine=3, lastLine=6, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public issue32$Customer(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("Customer",5);
    }
    // Class Statements
    public issue32$Customer STM$() {
        TRACE_BEGIN_STM$("Customer",5);
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // Class Process: Code before inner
        // JavaLine 24 <== SourceLine 1
        detach();
        // JavaLine 26 <== SourceLine 6
        // Class Customer: Code before inner
        // Class Customer: Code after inner
        // Class Process: Code after inner
        // JavaLine 30 <== SourceLine 1
        terminate();
        // JavaLine 32 <== SourceLine 6
        TRACE_END_STM$("Customer",6);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("issue32.sim","Class Customer",24,1,26,6,30,1,32,6,36,6);
} // End of Class
