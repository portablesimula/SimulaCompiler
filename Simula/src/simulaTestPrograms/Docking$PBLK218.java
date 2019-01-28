package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Jan 27 17:13:52 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK218 extends Docking$PBLK13$Warehouse {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=2, firstLine=218, lastLine=218, hasLocalClasses=false, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Docking$PBLK218(RTObject$ staticLink,int sp2$nDocks) {
        super(staticLink,sp2$nDocks);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("Docking$PBLK218",218);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("Docking$PBLK218",218,inner);
                hold(((double)(960.0f)));
                TRACE_END_STM$("Docking$PBLK218",218);
            }
        };
    } // End of Constructor
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","PrefixedBlock Docking$PBLK218",26,218);
}
