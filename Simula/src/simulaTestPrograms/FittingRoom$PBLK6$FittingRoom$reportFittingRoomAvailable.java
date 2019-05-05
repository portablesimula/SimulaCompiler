// JavaLine 1 <== SourceLine 24
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:24:45 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FittingRoom$PBLK6$FittingRoom$reportFittingRoomAvailable extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=24, lastLine=34, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 25
    Link$ elt=null;
    // Normal Constructor
    public FittingRoom$PBLK6$FittingRoom$reportFittingRoomAvailable(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("reportFittingRoomAvailable",25);
        STM$();
    }
    // Procedure Statements
    public FittingRoom$PBLK6$FittingRoom$reportFittingRoomAvailable STM$() {
        TRACE_BEGIN_STM$("reportFittingRoomAvailable",25);
        // JavaLine 25 <== SourceLine 26
        sysout().outfix(((FittingRoom$PBLK6)(CUR$.SL$.SL$)).time(),2,6);
        sysout().outtext(new TXT$(": FittingRoom becomes available, Queue: "));
        // JavaLine 28 <== SourceLine 27
        elt=((FittingRoom$PBLK6$FittingRoom)(CUR$.SL$)).door.first();
        // JavaLine 30 <== SourceLine 28
        if(VALUE$((elt==(null)))) {
            sysout().outtext(new TXT$("Empty"));
        }
        // JavaLine 34 <== SourceLine 29
        while((elt!=(null))) {
            // JavaLine 36 <== SourceLine 30
            {
                TRACE_BEGIN_STM$("CompoundStatement30",30);
                sysout().outtext(CONC(new TXT$(" "),((FittingRoom$PBLK6$Person)(elt)).p3$pname));
                // JavaLine 40 <== SourceLine 31
                elt=elt.suc();
                TRACE_END_STM$("CompoundStatement30",31);
            }
        }
        // JavaLine 45 <== SourceLine 33
        sysout().outimage();
        TRACE_END_STM$("reportFittingRoomAvailable",33);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Procedure reportFittingRoomAvailable",1,24,11,25,25,26,28,27,30,28,34,29,36,30,40,31,45,33,50,34);
} // End of Procedure
