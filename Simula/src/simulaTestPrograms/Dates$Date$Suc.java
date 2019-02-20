// JavaLine 1 ==> SourceLine 45
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Suc extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=45, lastLine=48, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public Dates$Date RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Dates$Date$Suc(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Suc",45);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$Date$Suc STM$() {
        TRACE_BEGIN_STM$("Suc",45);
        // JavaLine 26 ==> SourceLine 47
        RESULT$=new Dates$Date$Plus(((Dates$Date)(CUR$.SL$)),1).RESULT$;
        TRACE_END_STM$("Suc",47);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure Suc",1,45,26,47,31,48);
}
