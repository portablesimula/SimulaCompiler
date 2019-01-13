// JavaLine 1 ==> SourceLine 858
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:49 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER2$semchecker$getlastblno extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=858, lastLine=865, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER2$semchecker$getlastblno(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("getlastblno",858);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER2$semchecker$getlastblno STM$() {
        TRACE_BEGIN_STM$("getlastblno",858);
        // JavaLine 23 ==> SourceLine 859
        ((CHECKER2$semchecker)(CUR$.SL$)).lastblhi=loadChar(((CHECKER2$semchecker)(CUR$.SL$)).L2buf,((CHECKER2$semchecker)(CUR$.SL$)).L2p);
        // JavaLine 25 ==> SourceLine 860
        ((CHECKER2$semchecker)(CUR$.SL$)).lastbllo=loadChar(((CHECKER2$semchecker)(CUR$.SL$)).L2buf,(((CHECKER2$semchecker)(CUR$.SL$)).L2p+(1)));
        // JavaLine 27 ==> SourceLine 861
        ((CHECKER2$semchecker)(CUR$.SL$)).L2p=(((CHECKER2$semchecker)(CUR$.SL$)).L2p+(2));
        TRACE_END_STM$("getlastblno",861);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER2.DEF","Procedure getlastblno",1,858,23,859,25,860,27,861,32,865);
}
