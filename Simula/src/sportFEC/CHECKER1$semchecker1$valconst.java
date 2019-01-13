// JavaLine 1 ==> SourceLine 1232
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:42 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$valconst extends CHECKER1$semchecker1$const$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=2, firstLine=1232, lastLine=1240, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    // Declare locals as attributes
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$valconst$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$valconst(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch) {
        super(staticLink,sp$pred,sp$ch);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("valconst",1238);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("valconst",1238,inner);
                // JavaLine 22 ==> SourceLine 1240
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("valconst",1240);
                }
                TRACE_END_STM$("valconst",1240);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$valconst STM$() { return((CHECKER1$semchecker1$valconst)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$valconst START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class valconst",1,1232,22,1240,33,1240);
}
