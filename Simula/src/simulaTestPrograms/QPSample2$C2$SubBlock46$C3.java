// JavaLine 1 ==> SourceLine 47
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Mar 16 11:38:03 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class QPSample2$C2$SubBlock46$C3 extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=4, PrefixLevel=0, firstLine=47, lastLine=52, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public QPSample2$C2$SubBlock46$C3(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("C3",47);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("C3",47,inner);
                // JavaLine 23 ==> SourceLine 48
                new QPSample2$note(((QPSample2)(CUR$.SL$.SL$.SL$)),new TXT$("Before Detach C3 - see fig. 7.3"));
                // JavaLine 25 ==> SourceLine 49
                detach();
                // JavaLine 27 ==> SourceLine 50
                new QPSample2$note(((QPSample2)(CUR$.SL$.SL$.SL$)),new TXT$("After  Resume X3 - see fig. 7.5"));
                // JavaLine 29 ==> SourceLine 51
                new QPSample2$C2$P2(((QPSample2$C2)(CUR$.SL$.SL$)));
                // JavaLine 31 ==> SourceLine 48
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("C3",48);
                }
                TRACE_END_STM$("C3",48);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public QPSample2$C2$SubBlock46$C3 STM$() { return((QPSample2$C2$SubBlock46$C3)CODE$.EXEC$()); }
    public QPSample2$C2$SubBlock46$C3 START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("QPSample2.sim","Class C3",1,47,23,48,25,49,27,50,29,51,31,48,43,52);
}
