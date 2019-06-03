package simulaTestPrograms;
// Simula-1.0 Compiled at Tue May 28 14:07:28 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class adHoc01$Clerk extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=3, firstLine=5, lastLine=7, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public adHoc01$Station p3$location;
    // Declare locals as attributes
    // Normal Constructor
    public adHoc01$Clerk(RTObject$ staticLink,adHoc01$Station sp3$location) {
        super(staticLink);
        // Parameter assignment to locals
        this.p3$location = sp3$location;
        // Declaration Code
        TRACE_BEGIN_DCL$("Clerk",5);
    }
    // Class Statements
    public adHoc01$Clerk STM$() {
        TRACE_BEGIN_STM$("Clerk",5);
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // Class Process: Code before inner
        // JavaLine 26 <== SourceLine 1
        detach();
        // JavaLine 28 <== SourceLine 7
        // Class Clerk: Code before inner
        // Class Clerk: Code after inner
        // Class Process: Code after inner
        // JavaLine 32 <== SourceLine 1
        terminate();
        // JavaLine 34 <== SourceLine 7
        TRACE_END_STM$("Clerk",7);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc01.sim","Class Clerk",26,1,28,7,32,1,34,7,38,7);
} // End of Class
