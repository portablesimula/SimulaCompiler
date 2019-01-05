// JavaLine 1 ==> SourceLine 65
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$codebuffer$elt$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=65, lastLine=68, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$codebuffer$elt$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",65);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$codebuffer$elt$emit STM$() {
        TRACE_BEGIN_STM$("emit",65);
        // JavaLine 23 ==> SourceLine 66
        ((PARSER)(CUR$.SL$.SL$.SL$)).opdhi=((PARSER$codebuffer$elt)(CUR$.SL$)).opdhii;
        ((PARSER)(CUR$.SL$.SL$.SL$)).opdlo=((PARSER$codebuffer$elt)(CUR$.SL$)).opdloo;
        // JavaLine 26 ==> SourceLine 67
        ((PARSER)(CUR$.SL$.SL$.SL$)).optx=((PARSER$codebuffer$elt)(CUR$.SL$)).optxx;
        ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER$codebuffer$elt)(CUR$.SL$)).opnn;
        call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
        TRACE_END_STM$("emit",67);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure emit",1,65,23,66,26,67,33,68);
}
