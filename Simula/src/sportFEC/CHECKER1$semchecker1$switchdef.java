// JavaLine 1 ==> SourceLine 2527
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$switchdef extends CHECKER1$semchecker1$exp {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=1, firstLine=2527, lastLine=2561, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 2528
    public COMMON$quantity sw=null;
    public CHECKER1$semchecker1$switchelement elements=null;
    // JavaLine 14 ==> SourceLine 2529
    public boolean plain=false;
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$switchdef$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$switchdef(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch) {
        super(staticLink,sp$pred,sp$ch);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("switchdef",2558);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("switchdef",2558,inner);
                // JavaLine 27 ==> SourceLine 2561
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("switchdef",2561);
                }
                TRACE_END_STM$("switchdef",2561);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$switchdef STM$() { return((CHECKER1$semchecker1$switchdef)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$switchdef START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class switchdef",1,2527,11,2528,14,2529,27,2561,38,2561);
}
