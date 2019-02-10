// JavaLine 1 ==> SourceLine 490
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$divide extends CHECKER1$semchecker1$arithop {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=3, firstLine=490, lastLine=495, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$divide(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch,CHECKER1$semchecker1$exp sp1$left,CHECKER1$semchecker1$exp sp1$right) {
        super(staticLink,sp$pred,sp$ch,sp1$left,sp1$right);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("divide",490);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("divide",490,inner);
                // JavaLine 21 ==> SourceLine 494
                if(VALUE$((type<(((CHECKER1)(CUR$.SL$.SL$)).IREAL)))) {
                    type=((CHECKER1)(CUR$.SL$.SL$)).IREAL;
                }
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("divide",494);
                }
                TRACE_END_STM$("divide",494);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$divide STM$() { return((CHECKER1$semchecker1$divide)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$divide START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class divide",1,490,21,494,35,495);
}
