// JavaLine 1 ==> SourceLine 190
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$rockBottom extends CHECKER1$semchecker1$exp {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=1, firstLine=190, lastLine=193, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    // Declare locals as attributes
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$rockBottom$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$rockBottom(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch) {
        super(staticLink,sp$pred,sp$ch);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("rockBottom",192);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("rockBottom",192,inner);
                // JavaLine 22 ==> SourceLine 193
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("rockBottom",193);
                }
                TRACE_END_STM$("rockBottom",193);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$rockBottom STM$() { return((CHECKER1$semchecker1$rockBottom)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$rockBottom START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class rockBottom",1,190,22,193,33,193);
}
