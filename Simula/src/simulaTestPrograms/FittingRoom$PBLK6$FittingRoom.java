package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:33:08 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class FittingRoom$PBLK6$FittingRoom extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=6, lastLine=37, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 ==> SourceLine 7
    public Head$ door=null;
    // JavaLine 12 ==> SourceLine 8
    public boolean inUse=false;
    // Normal Constructor
    public FittingRoom$PBLK6$FittingRoom(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("FittingRoom",33);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("FittingRoom",33,inner);
                // JavaLine 25 ==> SourceLine 36
                door=new Head$(((FittingRoom$PBLK6)(CUR$.SL$))).STM$();
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("FittingRoom",36);
                }
                TRACE_END_STM$("FittingRoom",36);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public FittingRoom$PBLK6$FittingRoom STM$() { return((FittingRoom$PBLK6$FittingRoom)CODE$.EXEC$()); }
    public FittingRoom$PBLK6$FittingRoom START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Class FittingRoom",10,7,12,8,25,36,38,37);
}
