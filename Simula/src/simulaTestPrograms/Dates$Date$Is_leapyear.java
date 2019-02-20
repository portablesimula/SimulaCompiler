// JavaLine 1 ==> SourceLine 127
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Is_leapyear extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=127, lastLine=130, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Dates$Date$Is_leapyear(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Is_leapyear",127);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$Date$Is_leapyear STM$() {
        TRACE_BEGIN_STM$("Is_leapyear",127);
        // JavaLine 26 ==> SourceLine 129
        RESULT$=new Dates$L_year(((Dates)(CUR$.SL$.SL$)),((Dates$Date)(CUR$.SL$)).p$Y).RESULT$;
        TRACE_END_STM$("Is_leapyear",129);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure Is_leapyear",1,127,26,129,31,130);
}
