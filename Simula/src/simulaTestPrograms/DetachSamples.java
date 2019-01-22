// JavaLine 1 ==> SourceLine 3
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Jan 19 12:51:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class DetachSamples extends Simset$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=1, PrefixLevel=1, firstLine=3, lastLine=27, hasLocalClasses=true, System=false, detachUsed=true
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 5
    public DetachSamples$C x=null;
    // Normal Constructor
    public DetachSamples(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("DetachSamples",21);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("DetachSamples",21,inner);
                // JavaLine 24 ==> SourceLine 24
                x=new DetachSamples$C(((DetachSamples)CUR$)).START();
                // JavaLine 26 ==> SourceLine 25
                detach();
                // JavaLine 28 ==> SourceLine 24
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("DetachSamples",24);
                }
                TRACE_END_STM$("DetachSamples",24);
            }
        };
    } // End of Constructor
    // Class Statements
    public DetachSamples STM$() { return((DetachSamples)CODE$.EXEC$()); }
    public DetachSamples START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("DetachSamples.sim","Class DetachSamples",1,3,12,5,24,24,26,25,28,24,39,27);
}
