// JavaLine 1 ==> SourceLine 61
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Feb 23 10:10:58 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class NoughtsAndCrosses$Crosser extends NoughtsAndCrosses$Player {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=61, lastLine=70, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    public PRCQNT$ Move$0() { return(new PRCQNT$(this,NoughtsAndCrosses$Crosser$Move.class)); }
    // Normal Constructor
    public NoughtsAndCrosses$Crosser(RTObject$ staticLink,char sp$symb) {
        super(staticLink,sp$symb);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("Crosser",68);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("Crosser",68,inner);
                // JavaLine 23 ==> SourceLine 70
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Crosser",70);
                }
                TRACE_END_STM$("Crosser",70);
            }
        };
    } // End of Constructor
    // Class Statements
    public NoughtsAndCrosses$Crosser STM$() { return((NoughtsAndCrosses$Crosser)CODE$.EXEC$()); }
    public NoughtsAndCrosses$Crosser START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("NoughtsAndCrosses.sim","Class Crosser",1,61,23,70,34,70);
}
