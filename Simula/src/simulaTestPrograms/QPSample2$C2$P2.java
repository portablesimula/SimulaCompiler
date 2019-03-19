// JavaLine 1 ==> SourceLine 39
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Mar 16 11:38:03 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class QPSample2$C2$P2 extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=39, lastLine=44, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public QPSample2$C2$P2(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("P2",39);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public QPSample2$C2$P2 STM$() {
        TRACE_BEGIN_STM$("P2",39);
        // JavaLine 23 ==> SourceLine 41
        new QPSample2$note(((QPSample2)(CUR$.SL$.SL$)),new TXT$("Before Detach C2 - see fig. 7.6"));
        // JavaLine 25 ==> SourceLine 42
        ((QPSample2$C2)(CUR$.SL$)).detach();
        // JavaLine 27 ==> SourceLine 43
        new QPSample2$note(((QPSample2)(CUR$.SL$.SL$)),new TXT$("After  Detach C2 - see fig. 7.6 again"));
        TRACE_END_STM$("P2",43);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("QPSample2.sim","Procedure P2",1,39,23,41,25,42,27,43,32,44);
}
