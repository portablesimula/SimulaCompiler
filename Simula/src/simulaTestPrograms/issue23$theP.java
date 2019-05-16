// JavaLine 1 <== SourceLine 9
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 17:23:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue23$theP extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=9, lastLine=10, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public issue23$theP(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("theP",9);
        STM$();
    }
    // Procedure Statements
    public issue23$theP STM$() {
        TRACE_BEGIN_STM$("theP",9);
        // JavaLine 23 <== SourceLine 10
        sysout().outtext(new TXT$("  theP  "));
        TRACE_END_STM$("theP",10);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("issue23.sim","Procedure theP",1,9,23,10,28,10);
} // End of Procedure
