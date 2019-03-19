// JavaLine 1 ==> SourceLine 306
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:03:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$hilse_melding extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=306, lastLine=314, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$hilse_melding(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("hilse_melding",306);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$hilse_melding STM$() {
        TRACE_BEGIN_STM$("hilse_melding",306);
        // JavaLine 23 ==> SourceLine 309
        sysout().outimage();
        // JavaLine 25 ==> SourceLine 310
        sysout().outtext(new TXT$("STORE NORSKE BEREGNINGSKOMPAGNIE"));
        sysout().outimage();
        // JavaLine 28 ==> SourceLine 311
        sysout().outimage();
        // JavaLine 30 ==> SourceLine 312
        sysout().outtext(new TXT$("Person-s�ke-system, versjon 29. februar 1984"));
        // JavaLine 32 ==> SourceLine 313
        sysout().outimage();
        TRACE_END_STM$("hilse_melding",313);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure hilse_melding",1,306,23,309,25,310,28,311,30,312,32,313,37,314);
}
