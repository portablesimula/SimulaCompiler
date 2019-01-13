// JavaLine 1 ==> SourceLine 1248
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:42 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$charconst extends CHECKER1$semchecker1$valconst {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=3, firstLine=1248, lastLine=1255, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$charconst(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch) {
        super(staticLink,sp$pred,sp$ch);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("charconst",1248);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("charconst",1248,inner);
                // JavaLine 21 ==> SourceLine 1255
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("charconst",1255);
                }
                TRACE_END_STM$("charconst",1255);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$charconst STM$() { return((CHECKER1$semchecker1$charconst)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$charconst START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class charconst",1,1248,21,1255,32,1255);
}
