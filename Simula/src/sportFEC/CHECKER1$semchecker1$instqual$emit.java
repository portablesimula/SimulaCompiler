// JavaLine 1 ==> SourceLine 577
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$instqual$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=577, lastLine=583, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$instqual$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",577);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$instqual$emit STM$() {
        TRACE_BEGIN_STM$("emit",577);
        // JavaLine 23 ==> SourceLine 578
        ((CHECKER1$semchecker1$instqual)(CUR$.SL$)).p1$right.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
        ((CHECKER1$semchecker1$instqual)(CUR$.SL$)).p1$right.emit$0().CPF();
        // JavaLine 26 ==> SourceLine 579
        if((((CHECKER1$semchecker1$instqual)(CUR$.SL$)).L3opq!=(null))) {
            // JavaLine 28 ==> SourceLine 581
            {
                TRACE_BEGIN_STM$("CompoundStatement581",581);
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IQUA;
                ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$instqual)(CUR$.SL$)).L3opq;
                call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                TRACE_END_STM$("CompoundStatement581",581);
            }
        }
        TRACE_END_STM$("emit",581);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,577,23,578,26,579,28,581,40,583);
}
