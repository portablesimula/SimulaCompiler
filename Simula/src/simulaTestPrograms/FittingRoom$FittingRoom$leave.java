// JavaLine 1 <== SourceLine 18
package simulaTestPrograms;
// Simula-1.0 Compiled at Thu May 23 15:35:48 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FittingRoom$FittingRoom$leave extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=18, lastLine=22, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public FittingRoom$FittingRoom$leave(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("leave",18);
        STM$();
    }
    // Procedure Statements
    public FittingRoom$FittingRoom$leave STM$() {
        TRACE_BEGIN_STM$("leave",18);
        // JavaLine 23 <== SourceLine 19
        ((FittingRoom$FittingRoom)(CUR$.SL$)).inUse=false;
        // JavaLine 25 <== SourceLine 20
        new FittingRoom$FittingRoom$reportFittingRoomAvailable(((FittingRoom$FittingRoom)(CUR$.SL$)));
        // JavaLine 27 <== SourceLine 21
        ((FittingRoom)(CUR$.SL$.SL$)).ActivateDirect(false,((Process$)(((FittingRoom$FittingRoom)(CUR$.SL$)).door.first())));
        TRACE_END_STM$("leave",21);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Procedure leave",1,18,23,19,25,20,27,21,32,22);
} // End of Procedure
