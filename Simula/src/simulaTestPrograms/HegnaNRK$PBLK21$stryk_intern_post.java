// JavaLine 1 <== SourceLine 573
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:24:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$stryk_intern_post extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=573, lastLine=577, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$stryk_intern_post(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("stryk_intern_post",573);
        STM$();
    }
    // Procedure Statements
    public HegnaNRK$PBLK21$stryk_intern_post STM$() {
        TRACE_BEGIN_STM$("stryk_intern_post",573);
        // JavaLine 23 <== SourceLine 576
        ((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall$1=0;
        TRACE_END_STM$("stryk_intern_post",576);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure stryk_intern_post",1,573,23,576,28,577);
} // End of Procedure
