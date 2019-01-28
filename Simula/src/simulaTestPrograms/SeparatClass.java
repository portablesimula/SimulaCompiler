// JavaLine 1 ==> SourceLine 2
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Jan 28 10:24:03 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SeparatClass extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=1, PrefixLevel=0, firstLine=2, lastLine=13, hasLocalClasses=true, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 4
    public SeparatClass$A x=null;
    // JavaLine 14 ==> SourceLine 5
    public int n=0;
    // Normal Constructor
    public SeparatClass(RTObject$ staticLink,int sp$i) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("SeparatClass",11);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("SeparatClass",11,inner);
                // JavaLine 28 ==> SourceLine 13
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("SeparatClass",13);
                }
                TRACE_END_STM$("SeparatClass",13);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public SeparatClass STM$() { return((SeparatClass)CODE$.EXEC$()); }
    public SeparatClass START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("PrecompiledClass.sim","Class SeparatClass",1,2,12,4,14,5,28,13,40,13);
}
