// JavaLine 1 ==> SourceLine 38
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Mar 16 11:38:03 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class QPSample2$C2 extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=38, lastLine=57, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public QPSample2$C2(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("C2",43);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("C2",43,inner);
                // JavaLine 23 ==> SourceLine 56
                new QPSample2$C2$SubBlock46(CUR$).STM$();
                // JavaLine 25 ==> SourceLine 45
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("C2",45);
                }
                TRACE_END_STM$("C2",45);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public QPSample2$C2 STM$() { return((QPSample2$C2)CODE$.EXEC$()); }
    public QPSample2$C2 START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("QPSample2.sim","Class C2",1,38,23,56,25,45,37,57);
}
