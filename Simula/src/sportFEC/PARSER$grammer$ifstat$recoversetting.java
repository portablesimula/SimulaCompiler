// JavaLine 1 ==> SourceLine 1234
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:46:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$ifstat$recoversetting extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1234, lastLine=1239, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$ifstat$recoversetting(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("recoversetting",1234);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$ifstat$recoversetting STM$() {
        TRACE_BEGIN_STM$("recoversetting",1234);
        // JavaLine 23 ==> SourceLine 1236
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).ITHEN)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 25 ==> SourceLine 1237
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IELSE)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=true;
        TRACE_END_STM$("recoversetting",1237);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure recoversetting",1,1234,23,1236,25,1237,30,1239);
}
