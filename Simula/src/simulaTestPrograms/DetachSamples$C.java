// JavaLine 1 ==> SourceLine 7
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Jan 19 12:51:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class DetachSamples$C extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=7, lastLine=11, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 9
    public int i=0;
    // Normal Constructor
    public DetachSamples$C(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("C",9);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("C",9,inner);
                // JavaLine 25 ==> SourceLine 10
                detach();
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("C",10);
                }
                TRACE_END_STM$("C",10);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public DetachSamples$C STM$() { return((DetachSamples$C)CODE$.EXEC$()); }
    public DetachSamples$C START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("DetachSamples.sim","Class C",1,7,12,9,25,10,38,11);
}
