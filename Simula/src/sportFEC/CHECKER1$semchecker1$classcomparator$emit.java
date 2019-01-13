// JavaLine 1 ==> SourceLine 541
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$classcomparator$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=541, lastLine=547, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$classcomparator$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",541);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$classcomparator$emit STM$() {
        TRACE_BEGIN_STM$("emit",541);
        // JavaLine 23 ==> SourceLine 542
        ((CHECKER1$semchecker1$classcomparator)(CUR$.SL$)).p1$right.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
        ((CHECKER1$semchecker1$classcomparator)(CUR$.SL$)).p1$right.emit$0().CPF();
        // JavaLine 26 ==> SourceLine 545
        if((((CHECKER1$semchecker1$classcomparator)(CUR$.SL$)).p1$right.p$ch==(((CHECKER1)(CUR$.SL$.SL$.SL$)).ITHIS))) {
            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).implNone=false;
        }
        // JavaLine 30 ==> SourceLine 546
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1$semchecker1$classcomparator)(CUR$.SL$)).p$ch;
        ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$classcomparator)(CUR$.SL$)).qual;
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opilo=((CHECKER1$semchecker1$classcomparator)(CUR$.SL$)).cl;
        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
        TRACE_END_STM$("emit",546);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,541,23,542,26,545,30,546,38,547);
}
