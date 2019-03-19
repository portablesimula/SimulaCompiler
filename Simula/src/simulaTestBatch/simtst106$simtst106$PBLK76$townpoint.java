// JavaLine 1 ==> SourceLine 114
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon Mar 18 11:16:18 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst106$simtst106$PBLK76$townpoint extends Link$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=2, firstLine=114, lastLine=129, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    public simtst106$simtst106$PBLK76$town p2$t;
    // Declare locals as attributes
    // Normal Constructor
    public simtst106$simtst106$PBLK76$townpoint(RTObject$ staticLink,simtst106$simtst106$PBLK76$town sp2$t) {
        super(staticLink);
        // Parameter assignment to locals
        this.p2$t = sp2$t;
        // Declaration Code
        TRACE_BEGIN_DCL$("townpoint",127);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("townpoint",127,inner);
                // JavaLine 23 ==> SourceLine 129
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("townpoint",129);
                }
                TRACE_END_STM$("townpoint",129);
            }
        };
    } // End of Constructor
    // Class Statements
    public simtst106$simtst106$PBLK76$townpoint STM$() { return((simtst106$simtst106$PBLK76$townpoint)CODE$.EXEC$()); }
    public simtst106$simtst106$PBLK76$townpoint START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst106.sim","Class townpoint",1,114,23,129,34,129);
}
