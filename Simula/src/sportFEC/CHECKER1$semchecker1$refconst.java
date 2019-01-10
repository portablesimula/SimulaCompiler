// JavaLine 1 ==> SourceLine 1242
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$refconst extends CHECKER1$semchecker1$valconst {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=3, firstLine=1242, lastLine=1246, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$refconst(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch) {
        super(staticLink,sp$pred,sp$ch);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("refconst",1242);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("refconst",1242,inner);
                // JavaLine 21 ==> SourceLine 1246
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("refconst",1246);
                }
                TRACE_END_STM$("refconst",1246);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$refconst STM$() { return((CHECKER1$semchecker1$refconst)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$refconst START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class refconst",1,1242,21,1246,32,1246);
}
