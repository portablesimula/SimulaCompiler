// JavaLine 1 ==> SourceLine 121
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Days_in_month extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=121, lastLine=124, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Dates$Date$Days_in_month(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Days_in_month",121);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$Date$Days_in_month STM$() {
        TRACE_BEGIN_STM$("Days_in_month",121);
        // JavaLine 26 ==> SourceLine 123
        RESULT$=new Dates$M_leng(((Dates)(CUR$.SL$.SL$)),((Dates$Date)(CUR$.SL$)).p$M,((Dates$Date)(CUR$.SL$)).p$Y).RESULT$;
        TRACE_END_STM$("Days_in_month",123);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure Days_in_month",1,121,26,123,31,124);
}
