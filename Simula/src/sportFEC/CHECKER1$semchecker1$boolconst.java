// JavaLine 1 ==> SourceLine 1257
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:42 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$boolconst extends CHECKER1$semchecker1$valconst {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=3, firstLine=1257, lastLine=1263, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$boolconst(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch) {
        super(staticLink,sp$pred,sp$ch);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("boolconst",1257);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("boolconst",1257,inner);
                // JavaLine 21 ==> SourceLine 1263
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("boolconst",1263);
                }
                TRACE_END_STM$("boolconst",1263);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$boolconst STM$() { return((CHECKER1$semchecker1$boolconst)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$boolconst START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class boolconst",1,1257,21,1263,32,1263);
}
