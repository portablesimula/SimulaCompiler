// JavaLine 1 <== SourceLine 1190
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:24:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$lukk_utbase extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=1190, lastLine=1194, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$lukk_utbase(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("lukk_utbase",1190);
        STM$();
    }
    // Procedure Statements
    public HegnaNRK$PBLK21$lukk_utbase STM$() {
        TRACE_BEGIN_STM$("lukk_utbase",1190);
        // JavaLine 23 <== SourceLine 1192
        ((HegnaNRK$PBLK21)(CUR$.SL$)).utbase$1.close();
        // JavaLine 25 <== SourceLine 1193
        ((HegnaNRK$PBLK21)(CUR$.SL$)).fil_image$1=null;
        TRACE_END_STM$("lukk_utbase",1193);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure lukk_utbase",1,1190,23,1192,25,1193,30,1194);
} // End of Procedure
