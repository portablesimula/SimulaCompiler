// JavaLine 1 ==> SourceLine 9
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Jan 28 10:24:03 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SeparatClass$A$proc1 extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=9, lastLine=10, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public SeparatClass$A$proc1(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("proc1",9);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SeparatClass$A$proc1 STM$() {
        TRACE_BEGIN_STM$("proc1",9);
        // JavaLine 23 ==> SourceLine 10
        ((SeparatClass$A)(CUR$.SL$)).ord=(((SeparatClass)(CUR$.SL$.SL$)).n/(0));
        TRACE_END_STM$("proc1",10);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PrecompiledClass.sim","Procedure proc1",1,9,23,10,28,10);
}
