// JavaLine 1 ==> SourceLine 1376
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 18:13:17 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$sortermengde extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=1376, lastLine=1394, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$sortermengde(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("sortermengde",1376);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$sortermengde STM$() {
        TRACE_BEGIN_STM$("sortermengde",1376);
        // JavaLine 23 ==> SourceLine 1379
        if((((HegnaNRK$PBLK21)(CUR$.SL$)).mengde==(null))) {
            // JavaLine 25 ==> SourceLine 1380
            new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),18);
        } else
        // JavaLine 28 ==> SourceLine 1393
        new HegnaNRK$PBLK21$sortermengde$SubBlock1381(CUR$).STM$();
        TRACE_END_STM$("sortermengde",1392);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure sortermengde",1,1376,23,1379,25,1380,28,1393,33,1394);
}
