// JavaLine 1 ==> SourceLine 73
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$popExpStack extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=73, lastLine=78, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$popExpStack(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("popExpStack",73);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$popExpStack STM$() {
        TRACE_BEGIN_STM$("popExpStack",73);
        // JavaLine 23 ==> SourceLine 77
        ((CHECKER1$semchecker1)(CUR$.SL$)).exptop=((CHECKER1$semchecker1)(CUR$.SL$)).exptop.p$pred;
        TRACE_END_STM$("popExpStack",77);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure popExpStack",1,73,23,77,28,78);
}
