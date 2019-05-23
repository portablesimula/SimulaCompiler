// JavaLine 1 <== SourceLine 24
package simulaTestPrograms;
// Simula-1.0 Compiled at Thu May 23 15:35:48 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FittingRoom$FittingRoom$reportFittingRoomAvailable extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=24, lastLine=35, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 25
    Link$ elt=null;
    // Normal Constructor
    public FittingRoom$FittingRoom$reportFittingRoomAvailable(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("reportFittingRoomAvailable",25);
        STM$();
    }
    // Procedure Statements
    public FittingRoom$FittingRoom$reportFittingRoomAvailable STM$() {
        TRACE_BEGIN_STM$("reportFittingRoomAvailable",25);
        // JavaLine 25 <== SourceLine 26
        sysout().outfix(((FittingRoom)(CUR$.SL$.SL$)).time(),2,6);
        // JavaLine 27 <== SourceLine 27
        sysout().outtext(new TXT$(": FittingRoom becomes available, Queue: "));
        // JavaLine 29 <== SourceLine 28
        elt=((FittingRoom$FittingRoom)(CUR$.SL$)).door.first();
        // JavaLine 31 <== SourceLine 29
        if(VALUE$((elt==(null)))) {
            sysout().outtext(new TXT$("Empty"));
        }
        // JavaLine 35 <== SourceLine 30
        while((elt!=(null))) {
            // JavaLine 37 <== SourceLine 31
            {
                TRACE_BEGIN_STM$("CompoundStatement31",31);
                sysout().outtext(CONC(new TXT$(" "),((FittingRoom$Person)(elt)).p3$pname));
                // JavaLine 41 <== SourceLine 32
                elt=elt.suc();
                TRACE_END_STM$("CompoundStatement31",32);
            }
        }
        // JavaLine 46 <== SourceLine 34
        sysout().outimage();
        TRACE_END_STM$("reportFittingRoomAvailable",34);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Procedure reportFittingRoomAvailable",1,24,11,25,25,26,27,27,29,28,31,29,35,30,37,31,41,32,46,34,51,35);
} // End of Procedure
