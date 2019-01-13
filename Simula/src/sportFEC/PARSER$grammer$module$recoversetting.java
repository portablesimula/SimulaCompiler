// JavaLine 1 ==> SourceLine 729
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:25 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$module$recoversetting extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=729, lastLine=733, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$module$recoversetting(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("recoversetting",729);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$module$recoversetting STM$() {
        TRACE_BEGIN_STM$("recoversetting",729);
        // JavaLine 23 ==> SourceLine 730
        if((((PARSER$grammer$module)(CUR$.SL$)).errorno==(1))) {
            ((PARSER$grammer$module)(CUR$.SL$)).errorno=0;
        }
        // JavaLine 27 ==> SourceLine 731
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IEOP)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 29 ==> SourceLine 732
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IEXTR)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=true;
        TRACE_END_STM$("recoversetting",732);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure recoversetting",1,729,23,730,27,731,29,732,34,733);
}
