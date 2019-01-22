// JavaLine 1 ==> SourceLine 9
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Jan 20 10:46:20 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CoroutineSample$A extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=9, lastLine=17, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 11
    public int i=0;
    // Normal Constructor
    public CoroutineSample$A(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("A",11);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("A",11,inner);
                // JavaLine 25 ==> SourceLine 12
                new CoroutineSample$trace(((CoroutineSample)(CUR$.SL$)),new TXT$("A: State 1(Initiating)"));
                // JavaLine 27 ==> SourceLine 13
                detach();
                // JavaLine 29 ==> SourceLine 14
                new CoroutineSample$trace(((CoroutineSample)(CUR$.SL$)),new TXT$("A: State 2"));
                // JavaLine 31 ==> SourceLine 15
                detach();
                // JavaLine 33 ==> SourceLine 16
                new CoroutineSample$trace(((CoroutineSample)(CUR$.SL$)),new TXT$("A: State 3(Terminating)"));
                // JavaLine 35 ==> SourceLine 12
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("A",12);
                }
                TRACE_END_STM$("A",12);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public CoroutineSample$A STM$() { return((CoroutineSample$A)CODE$.EXEC$()); }
    public CoroutineSample$A START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CoroutineSample.sim","Class A",1,9,12,11,25,12,27,13,29,14,31,15,33,16,35,12,47,17);
}
