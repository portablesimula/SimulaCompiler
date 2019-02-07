// JavaLine 1 ==> SourceLine 79
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Wed Feb 06 20:31:42 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst68$Coroutine extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=79, lastLine=84, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public simtst68$Coroutine(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("Coroutine",79);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("Coroutine",79,inner);
                // JavaLine 23 ==> SourceLine 81
                new simtst68$trace(((simtst68)(CUR$.SL$)),new TXT$("In Coroutine: Just before Detach"));
                // JavaLine 25 ==> SourceLine 82
                detach();
                // JavaLine 27 ==> SourceLine 83
                new simtst68$trace(((simtst68)(CUR$.SL$)),new TXT$("In Coroutine: Just after Detach"));
                // JavaLine 29 ==> SourceLine 81
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Coroutine",81);
                }
                TRACE_END_STM$("Coroutine",81);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public simtst68$Coroutine STM$() { return((simtst68$Coroutine)CODE$.EXEC$()); }
    public simtst68$Coroutine START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst68.sim","Class Coroutine",1,79,23,81,25,82,27,83,29,81,41,84);
}
