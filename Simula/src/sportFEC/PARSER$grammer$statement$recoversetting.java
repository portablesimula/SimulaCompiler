// JavaLine 1 ==> SourceLine 713
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:25 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$statement$recoversetting extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=713, lastLine=715, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$statement$recoversetting(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("recoversetting",713);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$statement$recoversetting STM$() {
        TRACE_BEGIN_STM$("recoversetting",713);
        TRACE_END_STM$("recoversetting",713);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure recoversetting",1,713,26,715);
}
