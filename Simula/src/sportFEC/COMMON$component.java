// JavaLine 1 ==> SourceLine 1199
package sportFEC;
// Simula-Beta-0.3 Compiled at Wed Feb 06 13:19:01 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$component extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=1199, lastLine=1202, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 1200
    public char cs=0;
    public boolean getopt=false;
    // Normal Constructor
    public COMMON$component(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("component",1200);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("component",1200,inner);
                // JavaLine 25 ==> SourceLine 1202
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("component",1202);
                }
                TRACE_END_STM$("component",1202);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public COMMON$component STM$() { return((COMMON$component)CODE$.EXEC$()); }
    public COMMON$component START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class component",1,1199,11,1200,25,1202,37,1202);
}
