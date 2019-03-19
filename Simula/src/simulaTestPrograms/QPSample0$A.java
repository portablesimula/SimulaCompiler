// JavaLine 1 ==> SourceLine 9
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Mar 16 11:13:05 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class QPSample0$A extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=9, lastLine=15, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public QPSample0$A(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("A",9);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("A",9,inner);
                // JavaLine 22 ==> SourceLine 11
                ((QPSample0)(CUR$.SL$)).x=new QPSample0$C(((QPSample0)(CUR$.SL$))).START();
                // JavaLine 24 ==> SourceLine 13
                new QPSample0$trace(((QPSample0)(CUR$.SL$)),new TXT$("In Class A - Just Before first Resume(x)"));
                // JavaLine 26 ==> SourceLine 14
                resume(((QPSample0)(CUR$.SL$)).x);
                // JavaLine 28 ==> SourceLine 11
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
    public QPSample0$A STM$() { return((QPSample0$A)CODE$.EXEC$()); }
    public QPSample0$A START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("QPSample0.sim","Class A",1,9,22,11,24,13,26,14,28,11,40,15);
}
