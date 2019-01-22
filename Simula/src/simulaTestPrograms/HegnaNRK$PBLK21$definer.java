// JavaLine 1 ==> SourceLine 462
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 18:13:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$definer extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=462, lastLine=466, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$definer(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("definer",462);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$definer STM$() {
        TRACE_BEGIN_STM$("definer",462);
        // JavaLine 23 ==> SourceLine 465
        ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn=new HegnaNRK$PBLK21$les_register(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        TRACE_END_STM$("definer",465);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure definer",1,462,23,465,28,466);
}
