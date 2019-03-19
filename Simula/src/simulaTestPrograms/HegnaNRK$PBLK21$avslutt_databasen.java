// JavaLine 1 ==> SourceLine 300
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:03:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$avslutt_databasen extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=300, lastLine=304, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$avslutt_databasen(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("avslutt_databasen",300);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$avslutt_databasen STM$() {
        TRACE_BEGIN_STM$("avslutt_databasen",300);
        // JavaLine 23 ==> SourceLine 303
        new HegnaNRK$PBLK21$slutt_melding(((HegnaNRK$PBLK21)(CUR$.SL$)));
        TRACE_END_STM$("avslutt_databasen",303);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure avslutt_databasen",1,300,23,303,28,304);
}
