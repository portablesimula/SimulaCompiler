// JavaLine 1 <== SourceLine 774
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:24:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$stryk_finne_regel extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=774, lastLine=778, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$stryk_finne_regel(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("stryk_finne_regel",774);
        STM$();
    }
    // Procedure Statements
    public HegnaNRK$PBLK21$stryk_finne_regel STM$() {
        TRACE_BEGIN_STM$("stryk_finne_regel",774);
        // JavaLine 23 <== SourceLine 777
        ((HegnaNRK$PBLK21)(CUR$.SL$)).finne_regel_antall$1=0;
        TRACE_END_STM$("stryk_finne_regel",777);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure stryk_finne_regel",1,774,23,777,28,778);
} // End of Procedure
