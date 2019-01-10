// JavaLine 1 ==> SourceLine 850
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 12:01:22 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER2$semchecker$getOpd extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=850, lastLine=855, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER2$semchecker$getOpd(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("getOpd",850);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER2$semchecker$getOpd STM$() {
        TRACE_BEGIN_STM$("getOpd",850);
        // JavaLine 23 ==> SourceLine 851
        ((CHECKER2)(CUR$.SL$.SL$)).opdhi=loadChar(((CHECKER2$semchecker)(CUR$.SL$)).L2buf,((CHECKER2$semchecker)(CUR$.SL$)).L2p);
        ((CHECKER2)(CUR$.SL$.SL$)).opdlo=loadChar(((CHECKER2$semchecker)(CUR$.SL$)).L2buf,(((CHECKER2$semchecker)(CUR$.SL$)).L2p+(1)));
        // JavaLine 26 ==> SourceLine 852
        ((CHECKER2$semchecker)(CUR$.SL$)).opdSymb=new COMMON$boxof(((CHECKER2)(CUR$.SL$.SL$)),((CHECKER2)(CUR$.SL$.SL$)).opdhi,((CHECKER2)(CUR$.SL$.SL$)).opdlo).RESULT$;
        ((CHECKER2$semchecker)(CUR$.SL$)).L2p=(((CHECKER2$semchecker)(CUR$.SL$)).L2p+(2));
        TRACE_END_STM$("getOpd",852);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER2.DEF","Procedure getOpd",1,850,23,851,26,852,32,855);
}
