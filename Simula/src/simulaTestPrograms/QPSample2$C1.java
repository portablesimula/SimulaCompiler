// JavaLine 1 ==> SourceLine 32
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Mar 16 11:38:03 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class QPSample2$C1 extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=32, lastLine=36, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public QPSample2$C1(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("C1",33);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("C1",33,inner);
                // JavaLine 23 ==> SourceLine 34
                new QPSample2$note(((QPSample2)(CUR$.SL$)),new TXT$("Before Detach C1 - see fig. 7.1"));
                // JavaLine 25 ==> SourceLine 35
                new QPSample2$C1$P1(((QPSample2$C1)CUR$));
                // JavaLine 27 ==> SourceLine 34
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("C1",34);
                }
                TRACE_END_STM$("C1",34);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public QPSample2$C1 STM$() { return((QPSample2$C1)CODE$.EXEC$()); }
    public QPSample2$C1 START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("QPSample2.sim","Class C1",1,32,23,34,25,35,27,34,39,36);
}
