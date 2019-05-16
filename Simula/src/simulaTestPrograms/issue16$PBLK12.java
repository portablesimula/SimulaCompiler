// JavaLine 1 <== SourceLine 12
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 17:22:28 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue16$PBLK12 extends Simulation$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=2, firstLine=12, lastLine=17, hasLocalClasses=false, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    final int k$2;
    // JavaLine 14 <== SourceLine 13
    int kkk$2=0;
    // Normal Constructor
    public issue16$PBLK12(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("issue16$PBLK12",13);
        k$2=Math.subtractExact(((issue16)(CUR$.SL$)).inspect$10$0.pos(),1);
    }
    // Class Statements
    public issue16$PBLK12 STM$() {
        TRACE_BEGIN_STM$("issue16$PBLK12",13);
        // Class Simset: Code before inner
        // Class Simulation: Code before inner
        // Class issue16$PBLK12: Code before inner
        // JavaLine 30 <== SourceLine 13
        kkk$2=((int)((int)Math.round(sqrt(((double)(4))))));
        // JavaLine 32 <== SourceLine 15
        ((issue16)(CUR$.SL$)).inspect$10$0.setpos(Math.subtractExact(((issue16)(CUR$.SL$)).inspect$10$0.pos(),1));
        TRACE_END_STM$("issue16$PBLK12",15);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("issue16.sim","PrefixedBlock issue16$PBLK12",1,12,14,13,30,13,32,15,37,17);
} // End of Class
