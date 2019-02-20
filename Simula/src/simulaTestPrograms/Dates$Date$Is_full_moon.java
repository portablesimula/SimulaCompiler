// JavaLine 1 ==> SourceLine 81
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Is_full_moon extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=81, lastLine=88, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 83
    final float Limit=0.016931597f;
    // JavaLine 16 ==> SourceLine 84
    float Phase=0.0f;
    // Normal Constructor
    public Dates$Date$Is_full_moon(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Is_full_moon",84);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$Date$Is_full_moon STM$() {
        TRACE_BEGIN_STM$("Is_full_moon",84);
        // JavaLine 30 ==> SourceLine 86
        Phase=new Dates$Date$Lunar_phase(((Dates$Date)(CUR$.SL$))).RESULT$;
        // JavaLine 32 ==> SourceLine 87
        RESULT$=((Phase<(Limit))|((((double)(Phase))>=(0.9830684036863566d))));
        TRACE_END_STM$("Is_full_moon",87);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure Is_full_moon",1,81,14,83,16,84,30,86,32,87,37,88);
}
