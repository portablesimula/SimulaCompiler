// JavaLine 1 ==> SourceLine 1150
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$whilstat$recoversetting extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1150, lastLine=1151, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$whilstat$recoversetting(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("recoversetting",1150);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$whilstat$recoversetting STM$() {
        TRACE_BEGIN_STM$("recoversetting",1150);
        // JavaLine 23 ==> SourceLine 1151
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IDO)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=true;
        TRACE_END_STM$("recoversetting",1151);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure recoversetting",1,1150,23,1151,28,1151);
}
