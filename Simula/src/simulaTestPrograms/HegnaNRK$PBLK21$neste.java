// JavaLine 1 ==> SourceLine 707
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:03:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$neste extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=707, lastLine=710, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$neste(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("neste",707);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$neste STM$() {
        TRACE_BEGIN_STM$("neste",707);
        // JavaLine 23 ==> SourceLine 710
        new HegnaNRK$PBLK21$finn_og_hent(((HegnaNRK$PBLK21)(CUR$.SL$)),((HegnaNRK$PBLK21)(CUR$.SL$)).aktuell);
        TRACE_END_STM$("neste",710);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure neste",1,707,23,710,28,710);
}
