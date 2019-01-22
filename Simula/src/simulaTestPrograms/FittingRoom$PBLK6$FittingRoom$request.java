// JavaLine 1 ==> SourceLine 10
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 18:12:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FittingRoom$PBLK6$FittingRoom$request extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=10, lastLine=16, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public FittingRoom$PBLK6$FittingRoom$request(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("request",10);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public FittingRoom$PBLK6$FittingRoom$request STM$() {
        TRACE_BEGIN_STM$("request",10);
        // JavaLine 23 ==> SourceLine 11
        if(((FittingRoom$PBLK6$FittingRoom)(CUR$.SL$)).inUse) {
            // JavaLine 25 ==> SourceLine 12
            {
                TRACE_BEGIN_STM$("CompoundStatement12",12);
                ((FittingRoom$PBLK6)(CUR$.SL$.SL$)).wait(((FittingRoom$PBLK6$FittingRoom)(CUR$.SL$)).door);
                // JavaLine 29 ==> SourceLine 13
                ((FittingRoom$PBLK6$FittingRoom)(CUR$.SL$)).door.first().out();
                TRACE_END_STM$("CompoundStatement12",13);
            }
        }
        // JavaLine 34 ==> SourceLine 15
        ((FittingRoom$PBLK6$FittingRoom)(CUR$.SL$)).inUse=true;
        TRACE_END_STM$("request",15);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Procedure request",1,10,23,11,25,12,29,13,34,15,39,16);
}
