// JavaLine 1 <== SourceLine 10
package simulaTestPrograms;
// Simula-1.0 Compiled at Thu May 23 15:35:48 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FittingRoom$FittingRoom$request extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=10, lastLine=16, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public FittingRoom$FittingRoom$request(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("request",10);
        STM$();
    }
    // Procedure Statements
    public FittingRoom$FittingRoom$request STM$() {
        TRACE_BEGIN_STM$("request",10);
        // JavaLine 23 <== SourceLine 11
        if(VALUE$(((FittingRoom$FittingRoom)(CUR$.SL$)).inUse)) {
            // JavaLine 25 <== SourceLine 12
            {
                TRACE_BEGIN_STM$("CompoundStatement12",12);
                ((FittingRoom)(CUR$.SL$.SL$)).wait(((FittingRoom$FittingRoom)(CUR$.SL$)).door);
                // JavaLine 29 <== SourceLine 13
                ((FittingRoom$FittingRoom)(CUR$.SL$)).door.first().out();
                TRACE_END_STM$("CompoundStatement12",13);
            }
        }
        // JavaLine 34 <== SourceLine 15
        ((FittingRoom$FittingRoom)(CUR$.SL$)).inUse=true;
        TRACE_END_STM$("request",15);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Procedure request",1,10,23,11,25,12,29,13,34,15,39,16);
} // End of Procedure
