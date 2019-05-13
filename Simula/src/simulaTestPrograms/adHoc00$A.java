// JavaLine 1 <== SourceLine 5
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 12 09:56:05 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class adHoc00$A extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=5, lastLine=7, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public adHoc00$A(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("A",5);
    }
    // Class Statements
    public adHoc00$A STM$() {
        TRACE_BEGIN_STM$("A",5);
        // JavaLine 23 <== SourceLine 7
        // Class A: Code before inner
        // Class A: Code after inner
        TRACE_END_STM$("A",7);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc00.sim","Class A",1,5,23,7,29,7);
} // End of Class
