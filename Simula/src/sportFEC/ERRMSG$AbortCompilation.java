// JavaLine 1 ==> SourceLine 988
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:19 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$AbortCompilation extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=988, lastLine=1000, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public ERRMSG$AbortCompilation(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("AbortCompilation",988);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$AbortCompilation STM$() {
        TRACE_BEGIN_STM$("AbortCompilation",988);
        // JavaLine 23 ==> SourceLine 991
        ((ERRMSG)(CUR$.SL$)).termstatus='6';
        // JavaLine 25 ==> SourceLine 996
        new ERRMSG$printDiag(((ERRMSG)(CUR$.SL$)),(((((ERRMSG)(CUR$.SL$)).numerrfound>(((ERRMSG)(CUR$.SL$)).maxerrno)))?(new TXT$("*** COMPILATION STOPPED: Too many errors ***")):((((((ERRMSG)(CUR$.SL$)).numerrfound==(0)))?(new TXT$("*** COMPILATION ABORTED ***")):(new TXT$("*** COMPILATION CANNOT CONTINUE ***"))))));
        // JavaLine 27 ==> SourceLine 997
        rts_utility(1,0);
        // JavaLine 29 ==> SourceLine 999
        ((ERRMSG)(CUR$.SL$)).ENDCOMP$0().CPF();
        TRACE_END_STM$("AbortCompilation",999);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure AbortCompilation",1,988,23,991,25,996,27,997,29,999,34,1000);
}
