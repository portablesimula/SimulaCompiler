// JavaLine 1 ==> SourceLine 115
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Weekday_norsk extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=115, lastLine=118, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Dates$Date$Weekday_norsk(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Weekday_norsk",115);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$Date$Weekday_norsk STM$() {
        TRACE_BEGIN_STM$("Weekday_norsk",115);
        // JavaLine 26 ==> SourceLine 117
        RESULT$=copy(copy(((Dates)(CUR$.SL$.SL$)).WN_tab.Elt[new Dates$Date$Weekday(((Dates$Date)(CUR$.SL$))).RESULT$-((Dates)(CUR$.SL$.SL$)).WN_tab.LB[0]]));
        TRACE_END_STM$("Weekday_norsk",117);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure Weekday_norsk",1,115,26,117,31,118);
}
