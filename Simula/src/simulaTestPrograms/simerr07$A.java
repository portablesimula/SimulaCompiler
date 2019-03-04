// JavaLine 1 ==> SourceLine 7
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu Feb 21 16:18:24 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simerr07$A extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=7, lastLine=10, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public simerr07$A(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("A",9);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("A",9,inner);
                // JavaLine 22 ==> SourceLine 10
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("A",10);
                }
                TRACE_END_STM$("A",10);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public simerr07$A STM$() { return((simerr07$A)CODE$.EXEC$()); }
    public simerr07$A START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr07.sim","Class A",1,7,22,10,34,10);
}
