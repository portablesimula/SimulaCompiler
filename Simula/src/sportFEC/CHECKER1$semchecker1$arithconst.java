// JavaLine 1 ==> SourceLine 1199
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$arithconst extends CHECKER1$semchecker1$const$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=2, firstLine=1199, lastLine=1201, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$arithconst(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch) {
        super(staticLink,sp$pred,sp$ch);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("arithconst",1199);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("arithconst",1199,inner);
                // JavaLine 21 ==> SourceLine 1201
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("arithconst",1201);
                }
                TRACE_END_STM$("arithconst",1201);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$arithconst STM$() { return((CHECKER1$semchecker1$arithconst)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$arithconst START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class arithconst",1,1199,21,1201,32,1201);
}
