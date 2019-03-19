// JavaLine 1 ==> SourceLine 19
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Mar 16 11:15:38 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class QPSample1$C$Q extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=19, lastLine=28, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public QPSample1$C$Q(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Q",19);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public QPSample1$C$Q STM$() {
        TRACE_BEGIN_STM$("Q",19);
        // JavaLine 23 ==> SourceLine 22
        new QPSample1$trace(((QPSample1)(CUR$.SL$.SL$)),new TXT$("In Procedure Q - Just Before first Detach"));
        // JavaLine 25 ==> SourceLine 23
        ((QPSample1$C)(CUR$.SL$)).detach();
        // JavaLine 27 ==> SourceLine 25
        new QPSample1$trace(((QPSample1)(CUR$.SL$.SL$)),new TXT$("In Procedure Q - Just Before second Detach"));
        // JavaLine 29 ==> SourceLine 26
        ((QPSample1$C)(CUR$.SL$)).detach();
        TRACE_END_STM$("Q",26);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("QPSample1.sim","Procedure Q",1,19,23,22,25,23,27,25,29,26,34,28);
}
