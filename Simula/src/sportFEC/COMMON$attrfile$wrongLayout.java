// JavaLine 1 ==> SourceLine 1255
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:41:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$attrfile$wrongLayout extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=1255, lastLine=1256, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public COMMON$attrfile$wrongLayout(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("wrongLayout",1255);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public COMMON$attrfile$wrongLayout STM$() {
        TRACE_BEGIN_STM$("wrongLayout",1255);
        // JavaLine 23 ==> SourceLine 1256
        ((COMMON)(CUR$.SL$.SL$)).diag.Elt[0-((COMMON)(CUR$.SL$.SL$)).diag.LB[0]]=((COMMON$attrfile)(CUR$.SL$)).CURF.filename();
        ((COMMON)(CUR$.SL$.SL$)).COMMONerror$0().CPF().setPar(308).ENT$();
        TRACE_END_STM$("wrongLayout",1256);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure wrongLayout",1,1255,23,1256,29,1256);
}
