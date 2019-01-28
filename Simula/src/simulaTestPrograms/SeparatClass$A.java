// JavaLine 1 ==> SourceLine 7
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Jan 28 10:24:03 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SeparatClass$A extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=7, lastLine=11, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 8
    public int ord=0;
    // Normal Constructor
    public SeparatClass$A(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("A",10);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("A",10,inner);
                // JavaLine 24 ==> SourceLine 11
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("A",11);
                }
                TRACE_END_STM$("A",11);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public SeparatClass$A STM$() { return((SeparatClass$A)CODE$.EXEC$()); }
    public SeparatClass$A START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("PrecompiledClass.sim","Class A",1,7,11,8,24,11,36,11);
}
