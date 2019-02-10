// JavaLine 1 ==> SourceLine 1235
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$valconst$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1235, lastLine=1239, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$valconst$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",1235);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$valconst$emit STM$() {
        TRACE_BEGIN_STM$("emit",1235);
        // JavaLine 23 ==> SourceLine 1237
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1$semchecker1$valconst)(CUR$.SL$)).type;
        // JavaLine 25 ==> SourceLine 1238
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opilo=((CHECKER1$semchecker1$valconst)(CUR$.SL$)).ixlo;
        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
        TRACE_END_STM$("emit",1238);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,1235,23,1237,25,1238,31,1239);
}
