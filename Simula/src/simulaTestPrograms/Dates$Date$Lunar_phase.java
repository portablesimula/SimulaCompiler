// JavaLine 1 ==> SourceLine 71
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Lunar_phase extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=71, lastLine=78, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public float RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 73
    double Ph=0.0d;
    // Normal Constructor
    public Dates$Date$Lunar_phase(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Lunar_phase",73);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$Date$Lunar_phase STM$() {
        TRACE_BEGIN_STM$("Lunar_phase",73);
        // JavaLine 28 ==> SourceLine 75
        Ph=((((double)(new Dates$Date$Diff(new Dates$Date(((Dates)(CUR$.SL$.SL$)),14,11,1997).STM$(),((Dates$Date)(CUR$.SL$))).RESULT$))-(0.13333333333333333d))/(((Dates)(CUR$.SL$.SL$)).Lunar_period));
        // JavaLine 30 ==> SourceLine 77
        RESULT$=((float)((Ph-(((double)(entier(Ph)))))));
        TRACE_END_STM$("Lunar_phase",77);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure Lunar_phase",1,71,14,73,28,75,30,77,35,78);
}
