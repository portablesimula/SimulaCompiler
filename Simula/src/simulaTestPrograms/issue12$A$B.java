// JavaLine 1 ==> SourceLine 10
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri Mar 15 09:50:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class issue12$A$B extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=0, firstLine=10, lastLine=14, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 12
    public int i=0;
    // Normal Constructor
    public issue12$A$B(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("B",12);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("B",12,inner);
                // JavaLine 24 ==> SourceLine 13
                i=25;
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("B",13);
                }
                TRACE_END_STM$("B",13);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public issue12$A$B STM$() { return((issue12$A$B)CODE$.EXEC$()); }
    public issue12$A$B START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("issue12.sim","Class B",1,10,11,12,24,13,37,14);
}
