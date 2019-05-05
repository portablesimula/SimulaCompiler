// JavaLine 1 <== SourceLine 202
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:36:39 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Docking$PBLK12$Warehouse$Dock extends Link$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=2, firstLine=202, lastLine=203, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    public int p2$nr;
    // Declare locals as attributes
    // Normal Constructor
    public Docking$PBLK12$Warehouse$Dock(RTObject$ staticLink,int sp2$nr) {
        super(staticLink);
        // Parameter assignment to locals
        this.p2$nr = sp2$nr;
        // Declaration Code
        TRACE_BEGIN_DCL$("Dock",202);
    }
    // Class Statements
    public Docking$PBLK12$Warehouse$Dock STM$() {
        TRACE_BEGIN_STM$("Dock",202);
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // JavaLine 25 <== SourceLine 203
        // Class Dock: Code before inner
        // Class Dock: Code after inner
        TRACE_END_STM$("Dock",203);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Class Dock",1,202,25,203,31,203);
} // End of Class
