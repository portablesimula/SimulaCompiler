// JavaLine 1 ==> SourceLine 269
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$relation extends CHECKER1$semchecker1$operation {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=2, firstLine=269, lastLine=271, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 270
    public char opttype=0;
    // Normal Constructor
    public CHECKER1$semchecker1$relation(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch,CHECKER1$semchecker1$exp sp1$left,CHECKER1$semchecker1$exp sp1$right) {
        super(staticLink,sp$pred,sp$ch,sp1$left,sp1$right);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("relation",270);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("relation",270,inner);
                // JavaLine 23 ==> SourceLine 271
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("relation",271);
                }
                TRACE_END_STM$("relation",271);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$relation STM$() { return((CHECKER1$semchecker1$relation)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$relation START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class relation",1,269,11,270,23,271,34,271);
}
