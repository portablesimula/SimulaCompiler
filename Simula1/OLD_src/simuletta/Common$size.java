// JavaLine 1 <== SourceLine 396
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$size extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=396, lastLine=397, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Common$size(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$size STM$() {
        // JavaLine 23 <== SourceLine 397
        RESULT$=((Common)(CUR$.SL$)).identx$1;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure size",1,396,23,397,27,397);
} // End of Procedure
