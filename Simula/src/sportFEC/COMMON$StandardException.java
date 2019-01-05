// JavaLine 1 ==> SourceLine 1568
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:41:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$StandardException extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=1568, lastLine=1569, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public COMMON$StandardException(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("StandardException",1568);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public COMMON$StandardException STM$() {
        TRACE_BEGIN_STM$("StandardException",1568);
        // JavaLine 23 ==> SourceLine 1569
        DEFEXCEPTION(((COMMON)(CUR$.SL$)).EXCEPTION_HANDLER,new NAME$<Integer>(){ public Integer get() { return(((COMMON)(CUR$.SL$)).EXC_NUMBER); } public Integer put(Integer x$) { return(((COMMON)(CUR$.SL$)).EXC_NUMBER=(int)x$); } });
        TRACE_END_STM$("StandardException",1569);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure StandardException",1,1568,23,1569,28,1569);
}
