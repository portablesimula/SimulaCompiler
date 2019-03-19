// JavaLine 1 ==> SourceLine 6
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Mar 18 11:15:58 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc106$PBLK6 extends Simulation$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=2, firstLine=6, lastLine=8, hasLocalClasses=false, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public adHoc106$PBLK6(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("adHoc106$PBLK6",6);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("adHoc106$PBLK6",6,inner);
                ((adHoc106)(CUR$.SL$)).inspect$3$0.setpos((((adHoc106)(CUR$.SL$)).inspect$3$0.pos()-(1)));
                TRACE_END_STM$("adHoc106$PBLK6",6);
            }
        };
    } // End of Constructor
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc106.sim","PrefixedBlock adHoc106$PBLK6",1,6,27,8);
}
