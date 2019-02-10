// JavaLine 1 ==> SourceLine 285
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:52:33 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER2$semchecker$caseexp$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=285, lastLine=288, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER2$semchecker$caseexp$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",285);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER2$semchecker$caseexp$emit STM$() {
        TRACE_BEGIN_STM$("emit",285);
        // JavaLine 23 ==> SourceLine 286
        new CHECKER2$semchecker$caseexp$othwise(((CHECKER2$semchecker$caseexp)(CUR$.SL$)));
        // JavaLine 25 ==> SourceLine 287
        ((CHECKER2$semchecker)(CUR$.SL$.SL$)).opc=((CHECKER2)(CUR$.SL$.SL$.SL$)).IDELA;
        call(((CHECKER2)(CUR$.SL$.SL$.SL$)).coder);
        TRACE_END_STM$("emit",287);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER2.DEF","Procedure emit",1,285,23,286,25,287,31,288);
}
