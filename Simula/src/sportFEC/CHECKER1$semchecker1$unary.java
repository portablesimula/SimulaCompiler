// JavaLine 1 ==> SourceLine 519
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$unary extends CHECKER1$semchecker1$arithop {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=3, firstLine=519, lastLine=532, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    // Declare parameters as attributes
    // Declare locals as attributes
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$unary$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$unary(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch,CHECKER1$semchecker1$exp sp1$left,CHECKER1$semchecker1$exp sp1$right) {
        super(staticLink,sp$pred,sp$ch,sp1$left,sp1$right);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("unary",528);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("unary",528,inner);
                // JavaLine 22 ==> SourceLine 532
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("unary",532);
                }
                TRACE_END_STM$("unary",532);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$unary STM$() { return((CHECKER1$semchecker1$unary)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$unary START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class unary",1,519,22,532,33,532);
}
