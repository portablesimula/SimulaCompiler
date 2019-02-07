// JavaLine 1 ==> SourceLine 1094
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:32:37 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$trykk_rapport$skriv_linje extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=1094, lastLine=1098, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$trykk_rapport$skriv_linje(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("skriv_linje",1094);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$trykk_rapport$skriv_linje STM$() {
        TRACE_BEGIN_STM$("skriv_linje",1094);
        // JavaLine 23 ==> SourceLine 1096
        ((HegnaNRK$PBLK21$trykk_rapport)(CUR$.SL$)).felt_linje=(((HegnaNRK$PBLK21$trykk_rapport)(CUR$.SL$)).felt_linje+(1));
        // JavaLine 25 ==> SourceLine 1097
        sysout().outimage();
        TRACE_END_STM$("skriv_linje",1097);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure skriv_linje",1,1094,23,1096,25,1097,30,1098);
}
