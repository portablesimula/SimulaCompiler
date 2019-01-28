// JavaLine 1 ==> SourceLine 184
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Jan 27 17:13:52 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Docking$PBLK13$Warehouse$Dock extends Link$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=2, firstLine=184, lastLine=185, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    public int p2$nr;
    // Declare locals as attributes
    // Normal Constructor
    public Docking$PBLK13$Warehouse$Dock(RTObject$ staticLink,int sp2$nr) {
        super(staticLink);
        // Parameter assignment to locals
        this.p2$nr = sp2$nr;
        // Declaration Code
        TRACE_BEGIN_DCL$("Dock",184);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("Dock",184,inner);
                // JavaLine 23 ==> SourceLine 185
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Dock",185);
                }
                TRACE_END_STM$("Dock",185);
            }
        };
    } // End of Constructor
    // Class Statements
    public Docking$PBLK13$Warehouse$Dock STM$() { return((Docking$PBLK13$Warehouse$Dock)CODE$.EXEC$()); }
    public Docking$PBLK13$Warehouse$Dock START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Class Dock",1,184,23,185,34,185);
}
