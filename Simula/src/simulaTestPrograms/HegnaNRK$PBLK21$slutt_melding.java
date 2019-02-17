// JavaLine 1 ==> SourceLine 316
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 17 15:04:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$slutt_melding extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=316, lastLine=321, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$slutt_melding(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("slutt_melding",316);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$slutt_melding STM$() {
        TRACE_BEGIN_STM$("slutt_melding",316);
        // JavaLine 23 ==> SourceLine 319
        sysout().outtext(new TXT$("Takk for samv�ret"));
        sysout().outimage();
        // JavaLine 26 ==> SourceLine 320
        sysout().outtext(new TXT$("Velkommen igjen om fire �r."));
        TRACE_END_STM$("slutt_melding",320);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure slutt_melding",1,316,23,319,26,320,31,321);
}
