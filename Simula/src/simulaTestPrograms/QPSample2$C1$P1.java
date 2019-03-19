// JavaLine 1 ==> SourceLine 33
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Mar 16 11:38:03 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class QPSample2$C1$P1 extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=33, lastLine=33, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public QPSample2$C1$P1(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("P1",33);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public QPSample2$C1$P1 STM$() {
        TRACE_BEGIN_STM$("P1",33);
        ((QPSample2$C1)(CUR$.SL$)).detach();
        TRACE_END_STM$("P1",33);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("QPSample2.sim","Procedure P1",1,33,27,33);
}
