// JavaLine 1 ==> SourceLine 66
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:03:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$heltallverdi$skriv extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=66, lastLine=67, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$heltallverdi$skriv(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("skriv",66);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$heltallverdi$skriv STM$() {
        TRACE_BEGIN_STM$("skriv",66);
        // JavaLine 23 ==> SourceLine 67
        sysout().outint(((HegnaNRK$PBLK21$heltallverdi)(CUR$.SL$)).tall,5);
        TRACE_END_STM$("skriv",67);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure skriv",1,66,23,67,28,67);
}
