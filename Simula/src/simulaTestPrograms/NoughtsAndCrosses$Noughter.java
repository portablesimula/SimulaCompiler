// JavaLine 1 ==> SourceLine 50
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Feb 23 10:10:58 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class NoughtsAndCrosses$Noughter extends NoughtsAndCrosses$Player {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=50, lastLine=59, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    public PRCQNT$ Move$0() { return(new PRCQNT$(this,NoughtsAndCrosses$Noughter$Move.class)); }
    // Normal Constructor
    public NoughtsAndCrosses$Noughter(RTObject$ staticLink,char sp$symb) {
        super(staticLink,sp$symb);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("Noughter",56);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("Noughter",56,inner);
                // JavaLine 23 ==> SourceLine 59
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Noughter",59);
                }
                TRACE_END_STM$("Noughter",59);
            }
        };
    } // End of Constructor
    // Class Statements
    public NoughtsAndCrosses$Noughter STM$() { return((NoughtsAndCrosses$Noughter)CODE$.EXEC$()); }
    public NoughtsAndCrosses$Noughter START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("NoughtsAndCrosses.sim","Class Noughter",1,50,23,59,34,59);
}
