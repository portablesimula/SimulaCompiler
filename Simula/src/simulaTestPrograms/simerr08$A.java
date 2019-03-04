package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu Feb 21 16:18:38 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simerr08$A extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=4, lastLine=4, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public simerr08$A(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("A",4);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("A",4,inner);
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("A",4);
                }
                TRACE_END_STM$("A",4);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public simerr08$A STM$() { return((simerr08$A)CODE$.EXEC$()); }
    public simerr08$A START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr08.sim","Class A",32,4);
}
