// JavaLine 1 ==> SourceLine 601
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:03:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$endre extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=601, lastLine=611, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$endre(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("endre",601);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$endre STM$() {
        TRACE_BEGIN_STM$("endre",601);
        // JavaLine 23 ==> SourceLine 604
        if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).aktuell!=(0)))) {
            // JavaLine 25 ==> SourceLine 606
            {
                TRACE_BEGIN_STM$("CompoundStatement606",606);
                new HegnaNRK$PBLK21$endre_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
                // JavaLine 29 ==> SourceLine 607
                new HegnaNRK$PBLK21$stryk_aktuell_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
                // JavaLine 31 ==> SourceLine 608
                new HegnaNRK$PBLK21$skriv_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
                TRACE_END_STM$("CompoundStatement606",608);
            }
        } else
        // JavaLine 36 ==> SourceLine 610
        new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),10);
        TRACE_END_STM$("endre",610);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure endre",1,601,23,604,25,606,29,607,31,608,36,610,41,611);
}
