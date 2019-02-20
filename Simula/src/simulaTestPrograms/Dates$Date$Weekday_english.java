// JavaLine 1 ==> SourceLine 109
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Weekday_english extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=109, lastLine=112, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Dates$Date$Weekday_english(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Weekday_english",109);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$Date$Weekday_english STM$() {
        TRACE_BEGIN_STM$("Weekday_english",109);
        // JavaLine 26 ==> SourceLine 111
        RESULT$=copy(copy(((Dates)(CUR$.SL$.SL$)).WE_tab.Elt[new Dates$Date$Weekday(((Dates$Date)(CUR$.SL$))).RESULT$-((Dates)(CUR$.SL$.SL$)).WE_tab.LB[0]]));
        TRACE_END_STM$("Weekday_english",111);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure Weekday_english",1,109,26,111,31,112);
}
