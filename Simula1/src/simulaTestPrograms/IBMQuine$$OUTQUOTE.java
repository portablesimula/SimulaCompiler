package simulaTestPrograms;
// Simula-2.0 Compiled at Tue Jan 18 09:46:00 CET 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class IBMQuine$$OUTQUOTE extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=3, lastLine=3, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public IBMQuine$$OUTQUOTE(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public IBMQuine$$OUTQUOTE STM$() {
        sysout().outchar(ENVIRONMENT$.char$(127));
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("IBMQuine.sim","Procedure OUTQUOTE",22,3);
} // End of Procedure
