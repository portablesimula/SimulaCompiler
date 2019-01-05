// JavaLine 1 ==> SourceLine 1160
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 15:03:20 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$stackedi extends COMMON$sembox {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=1160, lastLine=1164, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    public char p1$rehi;
    public char p1$relo;
    // Declare locals as attributes
    // Normal Constructor
    public COMMON$stackedi(RTObject$ staticLink,char sp1$rehi,char sp1$relo) {
        super(staticLink);
        // Parameter assignment to locals
        this.p1$rehi = sp1$rehi;
        this.p1$relo = sp1$relo;
        // Declaration Code
        TRACE_BEGIN_DCL$("stackedi",1160);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("stackedi",1160,inner);
                // JavaLine 25 ==> SourceLine 1164
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("stackedi",1164);
                }
                TRACE_END_STM$("stackedi",1164);
            }
        };
    } // End of Constructor
    // Class Statements
    public COMMON$stackedi STM$() { return((COMMON$stackedi)CODE$.EXEC$()); }
    public COMMON$stackedi START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class stackedi",1,1160,25,1164,36,1164);
}
