// JavaLine 1 ==> SourceLine 91
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Weekday extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=91, lastLine=94, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Dates$Date$Weekday(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Weekday",91);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$Date$Weekday STM$() {
        TRACE_BEGIN_STM$("Weekday",91);
        // JavaLine 26 ==> SourceLine 93
        RESULT$=mod(new Dates$Date$N_days(((Dates$Date)(CUR$.SL$))).RESULT$,7);
        TRACE_END_STM$("Weekday",93);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure Weekday",1,91,26,93,31,94);
}
