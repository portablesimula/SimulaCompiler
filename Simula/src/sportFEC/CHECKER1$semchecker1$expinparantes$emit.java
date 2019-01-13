// JavaLine 1 ==> SourceLine 236
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$expinparantes$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=236, lastLine=237, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$expinparantes$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",236);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$expinparantes$emit STM$() {
        TRACE_BEGIN_STM$("emit",236);
        // JavaLine 23 ==> SourceLine 237
        ((CHECKER1$semchecker1$expinparantes)(CUR$.SL$)).p1$right.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
        ((CHECKER1$semchecker1$expinparantes)(CUR$.SL$)).p1$right.emit$0().CPF();
        TRACE_END_STM$("emit",237);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,236,23,237,29,237);
}
