// JavaLine 1 ==> SourceLine 693
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$textoperand$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=693, lastLine=693, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$textoperand$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",693);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$textoperand$emit STM$() {
        TRACE_BEGIN_STM$("emit",693);
        ((CHECKER1$semchecker1$textoperand)(CUR$.SL$)).p$actual.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
        ((CHECKER1$semchecker1$textoperand)(CUR$.SL$)).p$actual.emit$0().CPF();
        TRACE_END_STM$("emit",693);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,693,28,693);
}
