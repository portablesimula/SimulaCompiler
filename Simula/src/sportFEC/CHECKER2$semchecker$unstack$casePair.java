// JavaLine 1 ==> SourceLine 445
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:49 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER2$semchecker$unstack$casePair extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=445, lastLine=449, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 446
    char rht=0;
    // Normal Constructor
    public CHECKER2$semchecker$unstack$casePair(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("casePair",446);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER2$semchecker$unstack$casePair STM$() {
        TRACE_BEGIN_STM$("casePair",446);
        // JavaLine 25 ==> SourceLine 447
        new CHECKER2$semchecker$unstack$caseSingle(((CHECKER2$semchecker$unstack)(CUR$.SL$)));
        ((CHECKER2$semchecker$unstack)(CUR$.SL$)).lhi=((CHECKER2$semchecker$unstack)(CUR$.SL$)).rhi;
        rht=((CHECKER2$semchecker$unstack)(CUR$.SL$)).lhc;
        new CHECKER2$semchecker$unstack$caseSingle(((CHECKER2$semchecker$unstack)(CUR$.SL$)));
        // JavaLine 30 ==> SourceLine 448
        if((rht!=(((CHECKER2$semchecker$unstack)(CUR$.SL$)).lhc))) {
            new ERRMSG$error0(((CHECKER2)(CUR$.SL$.SL$.SL$)),442);
        }
        TRACE_END_STM$("casePair",448);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER2.DEF","Procedure casePair",1,445,11,446,25,447,30,448,37,449);
}
