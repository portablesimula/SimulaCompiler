// JavaLine 1 ==> SourceLine 1140
package sportFEC;
// Simula-Beta-0.3 Compiled at Fri Feb 08 19:52:22 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$extquantity extends COMMON$quantity {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=2, firstLine=1140, lastLine=1154, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    public COMMON$extbrecord p2$module;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 1145
    public char clf=0;
    // JavaLine 14 ==> SourceLine 1146
    public char longindic=0;
    // Normal Constructor
    public COMMON$extquantity(RTObject$ staticLink,COMMON$extbrecord sp2$module) {
        super(staticLink);
        // Parameter assignment to locals
        this.p2$module = sp2$module;
        // Declaration Code
        TRACE_BEGIN_DCL$("extquantity",1146);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("extquantity",1146,inner);
                // JavaLine 27 ==> SourceLine 1154
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("extquantity",1154);
                }
                TRACE_END_STM$("extquantity",1154);
            }
        };
    } // End of Constructor
    // Class Statements
    public COMMON$extquantity STM$() { return((COMMON$extquantity)CODE$.EXEC$()); }
    public COMMON$extquantity START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class extquantity",1,1140,12,1145,14,1146,27,1154,38,1154);
}
