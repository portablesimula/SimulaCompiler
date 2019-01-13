// JavaLine 1 ==> SourceLine 2607
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:42 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$qualification extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=2607, lastLine=2615, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public COMMON$quantity RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 2610
    COMMON$quantity cquant=null;
    // Normal Constructor
    public CHECKER1$semchecker1$qualification(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("qualification",2610);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$qualification STM$() {
        TRACE_BEGIN_STM$("qualification",2610);
        // JavaLine 28 ==> SourceLine 2612
        cquant=new BUILDER1$meaningof(((CHECKER1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb).RESULT$;
        // JavaLine 30 ==> SourceLine 2613
        if((cquant==(null))) {
            cquant=new ERRMSG$newnotseen(((CHECKER1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb).RESULT$;
        }
        // JavaLine 34 ==> SourceLine 2614
        RESULT$=cquant;
        TRACE_END_STM$("qualification",2614);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure qualification",1,2607,14,2610,28,2612,30,2613,34,2614,39,2615);
}
