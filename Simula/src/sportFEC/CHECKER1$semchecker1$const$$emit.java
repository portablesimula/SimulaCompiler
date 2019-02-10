// JavaLine 1 ==> SourceLine 1177
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$const$$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1177, lastLine=1184, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$const$$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",1177);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$const$$emit STM$() {
        TRACE_BEGIN_STM$("emit",1177);
        // JavaLine 23 ==> SourceLine 1179
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1$semchecker1$const$)(CUR$.SL$)).type;
        // JavaLine 25 ==> SourceLine 1181
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opihi=((CHECKER1$semchecker1$const$)(CUR$.SL$)).ixhi;
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opilo=((CHECKER1$semchecker1$const$)(CUR$.SL$)).ixlo;
        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
        // JavaLine 29 ==> SourceLine 1182
        if(VALUE$(IS$(((CHECKER1$semchecker1$const$)(CUR$.SL$)),CHECKER1$semchecker1$arithconst.class))) {
            // JavaLine 31 ==> SourceLine 1183
            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).aconstList=((CHECKER1$semchecker1$arithconst)(((CHECKER1$semchecker1$const$)(CUR$.SL$))));
        }
        TRACE_END_STM$("emit",1183);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,1177,23,1179,25,1181,29,1182,31,1183,37,1184);
}
