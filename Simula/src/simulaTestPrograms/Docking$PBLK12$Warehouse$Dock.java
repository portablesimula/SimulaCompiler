// JavaLine 1 ==> SourceLine 202
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:04:25 CET 2019
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
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("Dock",202,inner);
                // JavaLine 23 ==> SourceLine 203
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Dock",203);
                }
                TRACE_END_STM$("Dock",203);
            }
        };
    } // End of Constructor
    // Class Statements
    public Docking$PBLK12$Warehouse$Dock STM$() { return((Docking$PBLK12$Warehouse$Dock)CODE$.EXEC$()); }
    public Docking$PBLK12$Warehouse$Dock START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Class Dock",1,202,23,203,34,203);
}
