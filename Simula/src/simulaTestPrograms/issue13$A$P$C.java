// JavaLine 1 ==> SourceLine 17
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri Mar 15 09:22:39 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class issue13$A$P$C extends issue13$A {
    // ClassDeclaration: BlockKind=Class, BlockLevel=4, PrefixLevel=1, firstLine=17, lastLine=22, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 19
    public int j=0;
    // Normal Constructor
    public issue13$A$P$C(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("C",19);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("C",19,inner);
                // JavaLine 23 ==> SourceLine 20
                j=5;
                // JavaLine 25 ==> SourceLine 21
                ((issue13)(CUR$.SL$.SL$.SL$)).global=55;
                // JavaLine 27 ==> SourceLine 20
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("C",20);
                }
                TRACE_END_STM$("C",20);
            }
        };
    } // End of Constructor
    // Class Statements
    public issue13$A$P$C STM$() { return((issue13$A$P$C)CODE$.EXEC$()); }
    public issue13$A$P$C START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("issue13.sim","Class C",1,17,11,19,23,20,25,21,27,20,38,22);
}
