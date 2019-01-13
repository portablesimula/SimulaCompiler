// JavaLine 1 ==> SourceLine 109
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:17 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$sembox extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=109, lastLine=112, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 110
    public COMMON$sembox prevmeaning=null;
    // JavaLine 13 ==> SourceLine 111
    public COMMON$sembox next=null;
    // Normal Constructor
    public COMMON$sembox(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("sembox",111);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("sembox",111,inner);
                // JavaLine 26 ==> SourceLine 112
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("sembox",112);
                }
                TRACE_END_STM$("sembox",112);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public COMMON$sembox STM$() { return((COMMON$sembox)CODE$.EXEC$()); }
    public COMMON$sembox START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class sembox",1,109,11,110,13,111,26,112,38,112);
}
