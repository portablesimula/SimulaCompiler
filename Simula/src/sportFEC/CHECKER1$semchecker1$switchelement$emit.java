// JavaLine 1 ==> SourceLine 2573
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$switchelement$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=2573, lastLine=2574, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$switchelement$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",2573);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$switchelement$emit STM$() {
        TRACE_BEGIN_STM$("emit",2573);
        // JavaLine 23 ==> SourceLine 2574
        ((CHECKER1$semchecker1$switchelement)(CUR$.SL$)).p$labelexp.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
        ((CHECKER1$semchecker1$switchelement)(CUR$.SL$)).p$labelexp.emit$0().CPF();
        TRACE_END_STM$("emit",2574);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,2573,23,2574,29,2574);
}
