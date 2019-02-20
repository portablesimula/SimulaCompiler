// JavaLine 1 ==> SourceLine 133
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Is_weekend extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=133, lastLine=139, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 135
    int Dx=0;
    // Normal Constructor
    public Dates$Date$Is_weekend(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Is_weekend",135);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$Date$Is_weekend STM$() {
        TRACE_BEGIN_STM$("Is_weekend",135);
        // JavaLine 28 ==> SourceLine 137
        Dx=new Dates$Date$Weekday(((Dates$Date)(CUR$.SL$))).RESULT$;
        // JavaLine 30 ==> SourceLine 138
        RESULT$=((Dx==(((Dates)(CUR$.SL$.SL$)).Sunday))|((Dx==(((Dates)(CUR$.SL$.SL$)).Saturday))));
        TRACE_END_STM$("Is_weekend",138);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure Is_weekend",1,133,14,135,28,137,30,138,35,139);
}
