// JavaLine 1 <== SourceLine 5
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 17:19:55 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simerr13$Coder$elt extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=0, firstLine=5, lastLine=8, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 7
    public int x=0;
    // Normal Constructor
    public simerr13$Coder$elt(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("elt",7);
    }
    // Class Statements
    public simerr13$Coder$elt STM$() {
        TRACE_BEGIN_STM$("elt",7);
        // JavaLine 24 <== SourceLine 8
        // Class elt: Code before inner
        // Class elt: Code after inner
        TRACE_END_STM$("elt",8);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("simerr13.sim","Class elt",1,5,11,7,24,8,30,8);
} // End of Class
