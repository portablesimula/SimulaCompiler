// JavaLine 1 ==> SourceLine 10
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri Mar 15 09:22:39 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class issue13$A extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=10, lastLine=30, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 12
    public int k=0;
    // Normal Constructor
    public issue13$A(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("A",26);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("A",26,inner);
                // JavaLine 24 ==> SourceLine 29
                ((issue13)(CUR$.SL$)).global=11;
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("A",29);
                }
                TRACE_END_STM$("A",29);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public issue13$A STM$() { return((issue13$A)CODE$.EXEC$()); }
    public issue13$A START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("issue13.sim","Class A",1,10,11,12,24,29,37,30);
}
