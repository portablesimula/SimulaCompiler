// JavaLine 1 ==> SourceLine 294
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:03:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$start_databasen extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=294, lastLine=298, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$start_databasen(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("start_databasen",294);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$start_databasen STM$() {
        TRACE_BEGIN_STM$("start_databasen",294);
        // JavaLine 23 ==> SourceLine 297
        new HegnaNRK$PBLK21$hilse_melding(((HegnaNRK$PBLK21)(CUR$.SL$)));
        TRACE_END_STM$("start_databasen",297);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure start_databasen",1,294,23,297,28,298);
}
