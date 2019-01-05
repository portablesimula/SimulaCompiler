// JavaLine 1 ==> SourceLine 291
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:46:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$search extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=291, lastLine=294, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$search(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("search",291);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$search STM$() {
        TRACE_BEGIN_STM$("search",291);
        // JavaLine 23 ==> SourceLine 294
        while((!(((PARSER$grammer)(CUR$.SL$)).recoversymbol.Elt[rank(((PARSER$grammer)(CUR$.SL$)).cs)-((PARSER$grammer)(CUR$.SL$)).recoversymbol.LB[0]]))) {
            new PARSER$grammer$NEXTSYMBOL(((PARSER$grammer)(CUR$.SL$)));
        }
        TRACE_END_STM$("search",294);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure search",1,291,23,294,30,294);
}
