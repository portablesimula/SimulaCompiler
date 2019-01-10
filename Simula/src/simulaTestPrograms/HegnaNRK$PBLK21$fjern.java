// JavaLine 1 ==> SourceLine 753
package simulaTestPrograms;
// Release-Beta-0.3 Compiled at Sat Jan 05 17:29:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$fjern extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=753, lastLine=758, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$fjern(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("fjern",753);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$fjern STM$() {
        TRACE_BEGIN_STM$("fjern",753);
        // JavaLine 23 ==> SourceLine 756
        new HegnaNRK$PBLK21$stryk_aktuell_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
        // JavaLine 25 ==> SourceLine 757
        new HegnaNRK$PBLK21$stryk_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
        TRACE_END_STM$("fjern",757);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure fjern",1,753,23,756,25,757,30,758);
}
