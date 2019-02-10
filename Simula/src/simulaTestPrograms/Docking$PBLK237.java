// JavaLine 1 ==> SourceLine 237
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 10 12:42:17 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK237 extends Docking$PBLK12$Warehouse {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=2, firstLine=237, lastLine=239, hasLocalClasses=false, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Docking$PBLK237(RTObject$ staticLink,int sp2$nDocks) {
        super(staticLink,sp2$nDocks);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("Docking$PBLK237",237);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("Docking$PBLK237",237,inner);
                hold(((double)(960.0f)));
                // JavaLine 24 ==> SourceLine 238
                if(VALUE$((((Docking$PBLK12)(CUR$.SL$)).cnt<(6)))) {
                    new Docking$PBLK12$Warehouse$RemoveAllVans(((Docking$PBLK237)CUR$));
                }
                TRACE_END_STM$("Docking$PBLK237",238);
            }
        };
    } // End of Constructor
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","PrefixedBlock Docking$PBLK237",1,237,24,238,31,239);
}
