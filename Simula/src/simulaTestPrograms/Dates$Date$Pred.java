// JavaLine 1 ==> SourceLine 58
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Pred extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=58, lastLine=61, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public Dates$Date RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Dates$Date$Pred(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Pred",58);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$Date$Pred STM$() {
        TRACE_BEGIN_STM$("Pred",58);
        // JavaLine 26 ==> SourceLine 60
        RESULT$=new Dates$Date$Minus(((Dates$Date)(CUR$.SL$)),1).RESULT$;
        TRACE_END_STM$("Pred",60);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure Pred",1,58,26,60,31,61);
}
