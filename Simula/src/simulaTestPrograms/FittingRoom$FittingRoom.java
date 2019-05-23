package simulaTestPrograms;
// Simula-1.0 Compiled at Thu May 23 15:35:48 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class FittingRoom$FittingRoom extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=6, lastLine=38, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 7
    public Head$ door=null;
    // JavaLine 12 <== SourceLine 8
    public boolean inUse=false;
    // Normal Constructor
    public FittingRoom$FittingRoom(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("FittingRoom",34);
    }
    // Class Statements
    public FittingRoom$FittingRoom STM$() {
        TRACE_BEGIN_STM$("FittingRoom",34);
        // Class FittingRoom: Code before inner
        door=new Head$(((FittingRoom)(CUR$.SL$))).STM$();
        // Class FittingRoom: Code after inner
        TRACE_END_STM$("FittingRoom",37);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Class FittingRoom",10,7,12,8,31,38);
} // End of Class
