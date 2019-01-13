// JavaLine 1 ==> SourceLine 620
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$localobject$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=620, lastLine=623, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$localobject$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",620);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$localobject$emit STM$() {
        TRACE_BEGIN_STM$("emit",620);
        // JavaLine 23 ==> SourceLine 621
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ITHIS;
        ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$localobject)(CUR$.SL$)).L3opq;
        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
        // JavaLine 27 ==> SourceLine 622
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IQUA;
        TRACE_END_STM$("emit",622);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,620,23,621,27,622,32,623);
}
