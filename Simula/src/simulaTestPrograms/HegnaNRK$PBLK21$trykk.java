// JavaLine 1 ==> SourceLine 747
package simulaTestPrograms;
// Release-Beta-0.3 Compiled at Sat Jan 05 17:29:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$trykk extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=747, lastLine=751, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$trykk(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("trykk",747);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$trykk STM$() {
        TRACE_BEGIN_STM$("trykk",747);
        // JavaLine 23 ==> SourceLine 749
        sysout().outimage();
        // JavaLine 25 ==> SourceLine 750
        new HegnaNRK$PBLK21$skjerm_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
        TRACE_END_STM$("trykk",750);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure trykk",1,747,23,749,25,750,30,751);
}
