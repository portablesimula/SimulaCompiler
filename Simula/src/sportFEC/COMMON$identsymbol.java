package sportFEC;
// Simula-Beta-0.3 Compiled at Fri Feb 08 19:52:22 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$identsymbol extends COMMON$symbolbox {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=104, lastLine=107, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 ==> SourceLine 106
    public COMMON$sembox curmeaning=null;
    // Normal Constructor
    public COMMON$identsymbol(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("identsymbol",106);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("identsymbol",106,inner);
                // JavaLine 22 ==> SourceLine 107
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("identsymbol",107);
                }
                TRACE_END_STM$("identsymbol",107);
            }
        };
    } // End of Constructor
    // Class Statements
    public COMMON$identsymbol STM$() { return((COMMON$identsymbol)CODE$.EXEC$()); }
    public COMMON$identsymbol START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class identsymbol",10,106,22,107,33,107);
}
