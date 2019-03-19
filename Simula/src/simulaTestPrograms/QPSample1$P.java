// JavaLine 1 ==> SourceLine 9
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Mar 16 11:15:38 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class QPSample1$P extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=9, lastLine=15, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public QPSample1$P(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("P",9);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public QPSample1$P STM$() {
        TRACE_BEGIN_STM$("P",9);
        // JavaLine 23 ==> SourceLine 11
        ((QPSample1)(CUR$.SL$)).x=new QPSample1$C(((QPSample1)(CUR$.SL$))).START();
        // JavaLine 25 ==> SourceLine 13
        new QPSample1$trace(((QPSample1)(CUR$.SL$)),new TXT$("In Procedure P - Just Before first Resume(x)"));
        // JavaLine 27 ==> SourceLine 14
        resume(((QPSample1)(CUR$.SL$)).x);
        TRACE_END_STM$("P",14);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("QPSample1.sim","Procedure P",1,9,23,11,25,13,27,14,32,15);
}
