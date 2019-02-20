// JavaLine 1 ==> SourceLine 190
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Image extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=190, lastLine=193, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Dates$Date$Image(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Image",190);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$Date$Image STM$() {
        TRACE_BEGIN_STM$("Image",190);
        // JavaLine 26 ==> SourceLine 192
        RESULT$=CONC(CONC(CONC(CONC(new Dates$Date$N_image(((Dates$Date)(CUR$.SL$)),((Dates$Date)(CUR$.SL$)).p$D).RESULT$,new TXT$(".")),new Dates$Date$N_image(((Dates$Date)(CUR$.SL$)),((Dates$Date)(CUR$.SL$)).p$M).RESULT$),new TXT$(".")),new Dates$Date$N_image(((Dates$Date)(CUR$.SL$)),((Dates$Date)(CUR$.SL$)).p$Y).RESULT$);
        TRACE_END_STM$("Image",192);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure Image",1,190,26,192,31,193);
}
