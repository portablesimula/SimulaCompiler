package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:24:45 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class FittingRoom$PBLK6$FittingRoom extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=6, lastLine=37, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 7
    public Head$ door=null;
    // JavaLine 12 <== SourceLine 8
    public boolean inUse=false;
    // Normal Constructor
    public FittingRoom$PBLK6$FittingRoom(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("FittingRoom",33);
    }
    // Class Statements
    public FittingRoom$PBLK6$FittingRoom STM$() {
        TRACE_BEGIN_STM$("FittingRoom",33);
        // Class FittingRoom: Code before inner
        door=new Head$(((FittingRoom$PBLK6)(CUR$.SL$))).STM$();
        // Class FittingRoom: Code after inner
        TRACE_END_STM$("FittingRoom",36);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Class FittingRoom",10,7,12,8,31,37);
} // End of Class
